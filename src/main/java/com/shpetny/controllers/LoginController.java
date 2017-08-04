package com.shpetny.controllers;

import com.shpetny.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static final Logger log = Logger.getLogger(LoginController.class);

    private final UserService service;

    @Autowired
    public LoginController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public String showLoginPage() {
        return "login";
    }

    // TODO Login and redirect home final static ?

    @PostMapping
    public String showPage(@RequestParam("login") String login, @RequestParam("password") String password) {
        if(service.checkPasswordByLogin(login,password)){
            return "redirect:home";
        }else {
            return "login";
        }
    }
}
