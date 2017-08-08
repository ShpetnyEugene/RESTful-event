package com.shpetny.services;

import com.shpetny.models.Event;
import com.shpetny.persistence.EventRepository;
import com.shpetny.persistence.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;
    private final GroupRepository groupRepository;

    @Autowired
    public EventService(EventRepository repository, GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        this.repository = repository;
    }

    public void createEvent(Event event) {
        repository.save(event);
    }



    // TODO CHECK IT
    public List<Event> getAllEvents(String idGroup) {
        return groupRepository.findOne(Long.valueOf(idGroup)).getEvents();
    }
}
