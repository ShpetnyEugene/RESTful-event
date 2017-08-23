package com.shpetny.controllers;

import com.shpetny.services.EventService;
import com.shpetny.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Controller
@RequestMapping("/events/all")
public class AllEventsController {

    private final GroupService groupService;
    private final EventService service;

    @Autowired
    public AllEventsController(EventService service, GroupService groupService) {
        this.service = service;
        this.groupService = groupService;
    }

    @PostMapping
    public String showAllEvents(Model model, @RequestParam("groupId") String idGroup) {
        model.addAttribute("events", service.getAllEvents(idGroup));
        model.addAttribute("name", groupService.getGroupById(idGroup).getName());
        return "eventsAll";
    }
}
