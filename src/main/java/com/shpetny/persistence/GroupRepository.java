package com.shpetny.persistence;


import com.shpetny.models.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group,Long> {

}
