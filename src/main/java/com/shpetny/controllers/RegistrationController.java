package com.shpetny.controllers;

import com.shpetny.models.User;
import com.shpetny.services.UserService;
import org.apache.log4j.Logger;
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
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger log = Logger.getLogger(RegistrationController.class);

    private final UserService service;

    @Autowired
    public RegistrationController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String showPages() {
        return "registration";
    }

    @PostMapping
    public String registerUser(@RequestParam("nickName") String nickName, @RequestParam("password1") String password1,
                               @RequestParam("password2") String password2) {
        if (password1.equals(password2) && service.getUserByNickName(nickName) == null) {
            service.addUser(new User(nickName, password1));
            log.info("Created new user with nickName: " + nickName);
            return "redirect:login";
        } else {
            log.info("User with such nickName exist");
            return "registration";
        }
    }
}
