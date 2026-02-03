package org.netty;

/**
 * 事件实体类，包含时间、地点和事件信息
 */
public class Event {
    private Long id;
    private String time;
    private String location;
    private String incident;

    public Event() {}

    public Event(Long id, String time, String location, String incident) {
        this.id = id;
        this.time = time;
        this.location = location;
        this.incident = incident;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", incident='" + incident + '\'' +
                '}';
    }
}