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

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/events")
public class EventsController {


    @Autowired
    private GroupService groupService;



    private final EventService service;

    @Autowired
    public EventsController(EventService service) {
        this.service = service;
    }


    // TODO
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


        String q = groupId;
        groupId.isEmpty();
        // TODO CHECK THIS
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);


        // 2017-08-19T21:00

        // TODO CHANGE GROUP ID
        service.createEvent(new Event(name, "1", localDateTime,
                new Coordinate(Double.parseDouble(latitude), Double.parseDouble(longitude))));
    }
}
