package com.shpetny.controllers;

import com.shpetny.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String showPages() {
        return "users";
    }

    @PostMapping
    public void setCoordinate(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude) {
        service.updateCoordinate(latitude, longitude);
    }

}
