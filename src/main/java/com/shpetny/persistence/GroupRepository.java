package com.shpetny.persistence;


import com.shpetny.models.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Repository
public interface GroupRepository extends MongoRepository<Group, Long> {
    Group findByName(String name);
    Group findById(String id);
}

