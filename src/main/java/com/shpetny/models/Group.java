package com.shpetny.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Document(collection = "groups")
public class Group {
    @Id
    private String id;
    private String name;
    private Set<String> users = new HashSet<>();
    private List<Event> events = new ArrayList<>();

    public Group(String name, Set<String> users, List<Event> events) {
        this.name = name;
        this.users = users;
        this.events = events;
    }

    public Group(String id, String name, Set<String> users, List<Event> events) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.events = events;
    }

    public Group(String name) {
        this.name = name;
    }

    public Group() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (id != null ? !id.equals(group.id) : group.id != null) return false;
        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        if (users != null ? !users.equals(group.users) : group.users != null) return false;
        return events != null ? events.equals(group.events) : group.events == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", events=" + events +
                '}';
    }
}
