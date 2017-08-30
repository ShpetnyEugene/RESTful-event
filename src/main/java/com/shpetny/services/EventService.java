package com.shpetny.services;

import com.mongodb.Mongo;
import com.shpetny.models.Event;
import com.shpetny.models.Group;
import com.shpetny.models.User;
import com.shpetny.persistence.EventRepository;
import com.shpetny.persistence.GroupRepository;
import com.shpetny.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//import org.springframework.data.geo.Point;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Service
public class EventService {

    private final EventRepository repository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Autowired
    public EventService(EventRepository repository, GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.repository = repository;
        this.userRepository = userRepository;
    }

    /**
     * Creates events in given group
     *
     * @param name      - name event which to obtain in group
     * @param dateTime  - Date and Time events
     * @param longitude - Longitude events
     * @param latitude  - Latitude events
     * @param idGroup   - ID group in which insert group
     */
    public void createEvent(String name, String dateTime, String latitude, String longitude, String idGroup) {
        Group group = groupRepository.findById(idGroup);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        dateTime = dateTime.replace("T", " ");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
        Event event = new Event(name, idGroup, localDateTime,
                new Point(Double.parseDouble(latitude), Double.parseDouble(longitude)));
        group.getEvents().add(event);
        repository.save(event);
        groupRepository.save(group);
    }

    public List<Event> getNearEvents() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByNickName(auth.getName());
        Point point = new Point(user.getCoordinate().getLatitude(), user.getCoordinate().getLongitude());
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.plusHours(24);
        MongoOperations mongoTemplate = new MongoTemplate(new Mongo(), "events");
        Query findEvents = new Query(
                Criteria.where("coordinate")
                        .near(point).maxDistance(2)
                        .and("dateTime")
                        .gt(LocalDateTime.now())
                        .lt(localDateTime));
        return mongoTemplate.find(findEvents, Event.class);
    }


    /**
     * Get all events in given group
     *
     * @param idGroup - ID group in which to obtain all events
     */
    public List<Event> getAllEvents(String idGroup) {
        return groupRepository.findById(idGroup).getEvents();
    }
}
