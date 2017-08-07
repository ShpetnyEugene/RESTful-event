package com.shpetny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String showPage() {
        return "home";
    }
}
