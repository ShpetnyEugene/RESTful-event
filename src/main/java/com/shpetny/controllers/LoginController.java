package com.shpetny.controllers;

import com.shpetny.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */

@Controller
public class LoginController {

    private static final Logger log = Logger.getLogger(LoginController.class);

    private final UserService service;

    @Autowired
    public LoginController(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }



    @PostMapping("/login")
    public String enterInSystem(@RequestParam String login, @RequestParam String password) {
        if (service.checkPasswordByLogin(login, password)) {
            log.info("Login user with nickName: " + login);
            return "redirect:home";
        } else {
            return "login";
        }
    }
}
