package com.shpetny;

import com.shpetny.services.EventService;
import com.shpetny.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manager {

    private final UserService userService;

    private final EventService eventService;

    @Autowired
    public Manager(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    public void checkEvent(){
    }
}
