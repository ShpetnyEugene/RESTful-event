package com.shpetny.services;

import com.shpetny.models.Coordinate;
import com.shpetny.models.User;
import com.shpetny.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserByNickName(String nickName) {
        return repository.findByNickName(nickName);
    }

    public boolean checkPasswordByLogin(String login, String password) {
        User user = repository.findByNickName(login);
        return user != null && user.getPassword().equals(password);
    }

    /**
     * Add user in data base
     *
     * @param user - User where need inser
     */
    public void addUser(User user) {
        repository.save(user);
    }


    /**
     * Update users coordinate
     *
     * @param latitude  - new user latitude
     * @param longitude - new user longitude
     */
    public void updateCoordinate(String latitude, String longitude) {
        double lat;
        double lon;
        try {
            lat = Double.parseDouble(latitude);
            lon = Double.parseDouble(longitude);
        } catch (Exception e) {
            lat = 0;
            lon = 0;
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = repository.findByNickName(auth.getName());
        user.setCoordinate(new Coordinate(lat, lon));
        repository.save(user);
    }

}
