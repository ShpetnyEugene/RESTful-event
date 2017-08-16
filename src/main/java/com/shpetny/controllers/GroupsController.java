package com.shpetny.controllers;

import com.shpetny.services.GroupService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/groups")
public class GroupsController {

    private static final Logger log = Logger.getLogger(GroupsController.class);

    private final GroupService service;

    @Autowired
    public GroupsController(GroupService service) {
        this.service = service;
    }


    // TODO ADD SHOW ALL GROUP, BUT WHERE


    @GetMapping
    public String showPage() {
        return "groups";
    }

    @PostMapping
    public void createGroup(@RequestParam("name") String name) {
        log.info("Created new group with name: " + name);
        service.createGroup(name);
    }
}
