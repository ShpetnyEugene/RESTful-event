package com.shpetny.controllers;

import com.shpetny.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Controller
@RequestMapping("/soon")
public class EventSoonController {

    private final EventService service;

    @Autowired
    public EventSoonController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public String soonEvent(Model model) {
        model.addAttribute("events", service.getNearEvents());
        return "soon";
    }
}
