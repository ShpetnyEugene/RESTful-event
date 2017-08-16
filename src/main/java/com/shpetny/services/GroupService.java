package com.shpetny.services;

import com.shpetny.models.Group;
import com.shpetny.persistence.GroupRepository;
import com.shpetny.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public GroupService(GroupRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public void createGroup(String name){
        Group group = new Group(name);


        // TODO CHANGE THIS MAYBE_

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nameUser = auth.getName(); //get logged in username
    //Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        name.isEmpty();


//        userRepository.findOne(userID).getGroups().add(group);
//        group.getUsers().add(userRepository.findById(userID));
//
//
//        repository.save(group);
    }


    // TODO ADD COMMENTARY
    public List<Group> getAllGroups(){
        return repository.findAll();
    }
}
