package com.shpetny.controllers;

import com.shpetny.models.Coordinate;
import com.shpetny.models.Event;
import com.shpetny.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/users/{userId}/groups/{groupId}/events")
public class EventsController {

    private final EventService service;

    @Autowired
    public EventsController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public String showPages(ModelMap map, @PathVariable("groupId") String groupId,
                            @PathVariable("userId") String userId) {
        map.put("events",service.getAllEvents(groupId));
        return "events";
    }

    @PostMapping
    public void createEvent(@RequestParam("name") String name,
                            @RequestParam("latitude") String latitude,
                            @RequestParam("date") String date,
                            @RequestParam("longitude") String longitude, @PathVariable("groupId") String groupId) {


        // TODO CHANGE DATE TIME
        service.createEvent(new Event(name, groupId, LocalDateTime.now(),
                new Coordinate(Double.parseDouble(latitude), Double.parseDouble(longitude))));
    }
}
