package com.shpetny.controllers;

import com.shpetny.models.Coordinate;
import com.shpetny.models.Event;
import com.shpetny.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller

// TODO ВОЗМОЖЕН БРЕД !!!!!
@RequestMapping("/groups/{groupID}/events")
public class EventsController {


    @Autowired
    private EventService service;

    @GetMapping
    public String showPages(ModelMap map) {
        map.put("events",service.getAllEvents());
        return "events";
    }

    @PostMapping
    public void createEvent(@RequestParam("name") String name,
                            @RequestParam("latitude") String latitude,
                            @RequestParam("Date") String date,
                            @RequestParam("longitude") String longitude) {


        // TODO CHANGE GROUP ID

        // TODO CHANGE DATE TIME
        service.createEvent(new Event(name, 1, LocalDateTime.now(),
                new Coordinate(Double.parseDouble(latitude), Double.parseDouble(longitude))));
    }
}
