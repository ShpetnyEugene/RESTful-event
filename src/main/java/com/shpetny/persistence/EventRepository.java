package com.shpetny.persistence;

import com.shpetny.models.Coordinate;
import com.shpetny.models.Event;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Repository
public interface EventRepository extends MongoRepository<Event, Long> {
    List<Event> findByCoordinateNearAndDateTime(Coordinate coordinate, LocalDateTime dateTime);
}
