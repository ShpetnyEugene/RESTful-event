package com.shpetny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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

    @PostMapping
    public void print(HttpSession session){
        session.setAttribute("",null);
    }
}
