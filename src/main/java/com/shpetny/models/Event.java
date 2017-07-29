package com.shpetny.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Event {
    @Id
    private long id;
    private String name;
    /**
     * TODO group ID or just group ?
     * */
    private long groupId;
    private LocalDateTime dateTime;
    private Coordinate coordinate;

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

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (groupId != event.groupId) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (dateTime != null ? !dateTime.equals(event.dateTime) : event.dateTime != null) return false;
        return coordinate != null ? coordinate.equals(event.coordinate) : event.coordinate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (groupId ^ (groupId >>> 32));
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (coordinate != null ? coordinate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupId=" + groupId +
                ", dateTime=" + dateTime +
                ", coordinate=" + coordinate +
                '}';
    }
}
