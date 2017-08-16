package com.shpetny.persistence;

import com.shpetny.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Repository
public interface EventRepository extends MongoRepository<Event, Long> {

}