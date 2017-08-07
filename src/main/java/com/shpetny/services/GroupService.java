package com.shpetny.services;

import com.shpetny.models.Group;
import com.shpetny.persistence.GroupRepository;
import com.shpetny.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void createGroup(String name,long userID){
        Group group = new Group(name);

        //  TODO Найти юзера по id и добавить его в список или просто получить id из сессии


        // TODO ВОЗМОЖЕН БРЕД !!!!!!!
        userRepository.findOne(userID).getGroups().add(group);
        group.getUsers().add(userRepository.findById(userID));

        repository.save(group);
    }


    // TODO ADD COMMENTARY
    public List<Group> getAllGroups(){
        return repository.findAll();
    }
}
