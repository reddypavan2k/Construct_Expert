package org.dto;

import org.enums.Priority;
import org.enums.Status;
import org.model.Resource;
import org.model.Supervisor;
import org.model.Team;

import java.sql.Date;
import java.util.List;

public class TaskDTO {
    private Long id;
    private String title;
    private String type;
    private Date startDate;
    private Date endDate;
    private String description;
    private Priority priority;
    private Status status;
    private Integer daysLeft;
    private Supervisor supervisor;
    private Team team;
    private List<Resource> resourceList;

    public TaskDTO(Long id, String title, String type, Date startDate, Date endDate, String description, Priority priority, Status status, Integer daysLeft, Supervisor supervisor, Team team, List<Resource> resourceList) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.daysLeft = daysLeft;
        this.supervisor = supervisor;
        this.team = team;
        this.resourceList = resourceList;
    }

    public TaskDTO() {
    }

    public TaskDTO(String title, String type, Date startDate, Date endDate, String description, Priority priority, Status status, Integer daysLeft, Supervisor supervisor, Team team, List<Resource> resourceList) {
        this.title = title;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.daysLeft = daysLeft;
        this.supervisor = supervisor;
        this.team = team;
        this.resourceList = resourceList;
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

    public Integer getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(Integer daysLeft) {
        this.daysLeft = daysLeft;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", daysLeft=" + daysLeft +
                ", supervisor=" + supervisor +
                ", team=" + team +
                ", resourceList=" + resourceList +
                '}';
    }
}
