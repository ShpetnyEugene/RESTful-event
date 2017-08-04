package com.shpetny.persistence;

import com.shpetny.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    // TODO
    User findById(long id);

    // TODO
    User findByNickName(String nickName);
}
