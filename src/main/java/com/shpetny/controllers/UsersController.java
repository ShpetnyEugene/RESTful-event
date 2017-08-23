package com.shpetny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @GetMapping
    public String showPages() {
        return "users";
    }
}
