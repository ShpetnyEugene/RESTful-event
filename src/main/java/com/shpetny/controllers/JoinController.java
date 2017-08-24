package com.shpetny.controllers;


import com.shpetny.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Controller
@RequestMapping("/groups/join")
public class JoinController {

    private final GroupService groupService;

    @Autowired
    public JoinController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public String join(@RequestParam("join") String groupId) {
        groupService.joinUser(groupId);
        return "redirect:groups";
    }
}
