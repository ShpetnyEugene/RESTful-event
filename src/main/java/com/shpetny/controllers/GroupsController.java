package com.shpetny.controllers;

import com.shpetny.services.GroupService;
import org.apache.log4j.Logger;
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
@RequestMapping("/groups")
public class GroupsController {

    private static final Logger log = Logger.getLogger(GroupsController.class);

    private final GroupService service;

    @Autowired
    public GroupsController(GroupService service) {
        this.service = service;
    }

    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("groups", service.getAllGroups());
        return "groups";
    }

    @PostMapping
    public String createGroup(@RequestParam("name") String name) {
        log.info("Created new group with name: " + name);
        service.createGroup(name);
        return "redirect:groups";
    }
}
