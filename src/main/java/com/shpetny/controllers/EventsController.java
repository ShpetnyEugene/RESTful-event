package com.shpetny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventsController {

    //TODO Create events page

    @GetMapping
    public String showPages(){
        return "events";
    }



}
