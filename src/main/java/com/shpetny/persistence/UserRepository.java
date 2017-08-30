package com.shpetny.persistence;

import com.shpetny.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Get user by Nick Name
     *
     * @param nickName - Nick Name user which need find
     */
    User findByNickName(String nickName);
}
