package com.shpetny.services;

import com.shpetny.models.Event;
import com.shpetny.persistence.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public void createEvent(Event event) {
        repository.save(event);
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }



}
