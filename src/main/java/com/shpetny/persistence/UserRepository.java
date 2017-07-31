package com.shpetny.persistence;

import com.shpetny.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    // TODO
    User findById(long id);
}
