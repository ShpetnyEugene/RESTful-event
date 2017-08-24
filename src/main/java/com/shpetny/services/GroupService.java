package com.shpetny.services;

import com.shpetny.models.Group;
import com.shpetny.models.User;
import com.shpetny.persistence.GroupRepository;
import com.shpetny.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Service
public class GroupService {

    private final GroupRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public GroupService(GroupRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


    // TODO CHANGE THIS MAYBE_


    public void joinUser(String groupId) {
        Group group = repository.findById(groupId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByNickName(auth.getName());
        group.getUsers().add(user.getId());
        user.getGroups().add(group);
        repository.save(group);
        userRepository.save(user);
    }

    public void createGroup(String name) {
        Group group = new Group(name);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByNickName(auth.getName());
        user.getGroups().add(group);
        group.getUsers().add(user.getId());
        repository.save(group);
        userRepository.save(user);
    }


    // TODO ADD COMMENTARY
    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    public Group getGroupById(String id) {
        return repository.findById(id);
    }

}
