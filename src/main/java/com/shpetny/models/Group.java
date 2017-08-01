package com.shpetny.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Document(collection = "groups")
public class Group {
    @Id
    private long id;
    private String name;
    private List<User> users;
    private List<Event> events;

    public Group(long id, String name, List<User> users, List<Event> events) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.events = events;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
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

        if (id != group.id) return false;
        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        if (users != null ? !users.equals(group.users) : group.users != null) return false;
        return events != null ? events.equals(group.events) : group.events == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", events=" + events +
                '}';
    }
}
