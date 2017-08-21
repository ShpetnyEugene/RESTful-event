package com.shpetny.controllers;

import com.shpetny.models.Coordinate;
import com.shpetny.models.Event;
import com.shpetny.services.EventService;
import com.shpetny.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/events")
public class EventsController {


    private final GroupService groupService;


    private final EventService service;

    @Autowired
    public EventsController(EventService service, GroupService groupService) {
        this.service = service;
        this.groupService = groupService;
    }


    @GetMapping
    public String showPages(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "events";
    }

    @PostMapping
    public void createEvent(@RequestParam("name") String name,
                            @RequestParam("latitude") String latitude,
                            @RequestParam("dateTime") String dateTime,
                            @RequestParam("longitude") String longitude,
                            @RequestParam("groupId") String groupId) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        dateTime = dateTime.replace("T", " ");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
        service.createEvent(new Event(name, groupId, localDateTime,
                new Coordinate(Double.parseDouble(latitude), Double.parseDouble(longitude))),groupId);
    }
}
