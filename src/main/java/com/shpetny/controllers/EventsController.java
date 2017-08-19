package com.shpetny.controllers;

import com.shpetny.models.Coordinate;
import com.shpetny.models.Event;
import com.shpetny.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/events")
public class EventsController {

    private final EventService service;

    @Autowired
    public EventsController(EventService service) {
        this.service = service;
    }


    // TODO
    @GetMapping
    public String showPages(ModelMap map) {
//        map.put("events",service.getAllEvents("1"));
        return "events";
    }

    @PostMapping
    public void createEvent(@RequestParam("name") String name,
                            @RequestParam("latitude") String latitude,
                            @RequestParam("dateTime") String dateTime,
                            @RequestParam("longitude") String longitude) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);


        // 2017-08-19T21:00

        // TODO CHANGE GROUP ID
        service.createEvent(new Event(name, "1", localDateTime,
                new Coordinate(Double.parseDouble(latitude), Double.parseDouble(longitude))));
    }
}
