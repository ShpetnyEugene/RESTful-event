package com.shpetny.services;

import com.shpetny.models.User;
import com.shpetny.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;


    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public User addUser(User user){
        return repository.save(user);
    }
}
