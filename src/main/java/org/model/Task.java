package org.model;


import org.enums.Priority;
import org.enums.Status;

import java.sql.Date;

public class Task {
    private Long id;
    private String title;
    private String type;
    private Date startDate;
    private Date endDate;
    private String description;
    private Priority priority;
    private Status status;

    public Task(Long id, String title, String type, Date startDate, Date endDate, String description, Priority priority, Status status) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public Task(String title, String type, Date startDate, Date endDate, String description, Priority priority, Status status) {
        this.title = title;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
