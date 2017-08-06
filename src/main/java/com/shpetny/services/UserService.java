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

    public User getUserById(long idUser){
        return repository.findById(idUser);
    }

    public User getUserByNickName(String nickName){
        return repository.findByNickName(nickName);
    }

    public boolean checkPasswordByLogin(String login, String password){
        User user = repository.findByNickName(login);
        return user != null && user.getPassword().equals(password);
    }

    public void addUser(User user){
        repository.save(user);
    }
}
