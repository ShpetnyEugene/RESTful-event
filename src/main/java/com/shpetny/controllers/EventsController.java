package com.shpetny.controllers;

import com.shpetny.services.EventService;
import com.shpetny.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
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
                            @RequestParam("longitude") String longitude,
                            @RequestParam("dateTime") String dateTime,
                            @RequestParam("groupId") String groupId) {

        service.createEvent(name, dateTime, latitude, longitude, groupId);
    }
}
