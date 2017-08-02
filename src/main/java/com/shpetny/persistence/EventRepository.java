package com.shpetny.persistence;

import com.shpetny.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event,Long>{


}


/*
*   SQL -
*   NOSQL - collections
*
*
* **/
