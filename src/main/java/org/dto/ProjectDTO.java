package org.dto;

import org.enums.Status;

import java.sql.Date;

public class ProjectDTO {
    private Long id;
    private String name;
    private Date dateStart;
    private Date dateEnd;
    private Status status;
    private Integer taskDone;
    private Integer totalTask;
    private Integer progress;
    private Double areaSize;
    private Double budget;
    private String geolocation;
    private Integer room;
    private String picture;

    public ProjectDTO(Long id, String name, Date dateStart, Date dateEnd, Status status, Integer taskDone, Integer totalTask, Integer progress, Double areaSize, Double budget, String geolocation, Integer room, String picture) {
        this.id = id;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.status = status;
        this.taskDone = taskDone;
        this.totalTask = totalTask;
        this.progress = progress;
        this.areaSize = areaSize;
        this.budget = budget;
        this.geolocation = geolocation;
        this.room = room;
        this.picture = picture;
    }

    public ProjectDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getTaskDone() {
        return taskDone;
    }

    public void setTaskDone(Integer taskDone) {
        this.taskDone = taskDone;
    }

    public Integer getTotalTask() {
        return totalTask;
    }

    public void setTotalTask(Integer totalTask) {
        this.totalTask = totalTask;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Double getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(Double areaSize) {
        this.areaSize = areaSize;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", status=" + status +
                ", taskDone=" + taskDone +
                ", totalTask=" + totalTask +
                ", progress=" + progress +
                ", areaSize=" + areaSize +
                ", budget=" + budget +
                ", geolocation='" + geolocation + '\'' +
                ", room=" + room +
                ", picture='" + picture + '\'' +
                '}';
    }
}
