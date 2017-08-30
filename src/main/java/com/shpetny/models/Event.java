package com.shpetny.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Document(collection = "events")
public class Event {
    @Id
    private String id;
    private String name;
    private String groupId;
    private LocalDateTime dateTime;
    private Point coordinate;

    public Event() {
    }

    public Event(String id, String name, String groupId, LocalDateTime dateTime, Point coordinate) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
        this.dateTime = dateTime;
        this.coordinate = coordinate;
    }

    public Event(String name, String groupId, LocalDateTime dateTime, Point coordinate) {
        this.name = name;
        this.groupId = groupId;
        this.dateTime = dateTime;
        this.coordinate = coordinate;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (groupId != null ? !groupId.equals(event.groupId) : event.groupId != null) return false;
        if (dateTime != null ? !dateTime.equals(event.dateTime) : event.dateTime != null) return false;
        return coordinate != null ? coordinate.equals(event.coordinate) : event.coordinate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (coordinate != null ? coordinate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", groupId='" + groupId + '\'' +
                ", dateTime=" + dateTime +
                ", coordinate=" + coordinate +
                '}';
    }
}
