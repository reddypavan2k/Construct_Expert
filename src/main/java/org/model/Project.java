package org.model;

import org.enums.Status;

import java.sql.Date;


public class Project {
    private Long id;
    private String name;
    private String geolocation;
    private Date dateStart;
    private Date dateEnd;
    private Status status;
    private String description;
    private Integer room;
    private Integer bath;
    private Integer garage;
    private Integer terrace;
    private String wallMaterial;
    private String foundationType;
    private String roofingType;
    private Double areaSize;
    private Double budget;
    private String planFloor;
    private String picture;

    public Project(Long id, String name, String geolocation, Date dateStart, Date dateEnd, Status status, String description,
                   Integer room, Integer bath, Integer garage, Integer terrace, String wallMaterial, String foundationType,
                   String roofingType, Double areaSize, Double budget, String planFloor, String picture) {
        this.id = id;
        this.name = name;
        this.geolocation = geolocation;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.status = status;
        this.description = description;
        this.room = room;
        this.bath = bath;
        this.garage = garage;
        this.terrace = terrace;
        this.wallMaterial = wallMaterial;
        this.foundationType = foundationType;
        this.roofingType = roofingType;
        this.areaSize = areaSize;
        this.budget = budget;
        this.planFloor = planFloor;
        this.picture = picture;
    }

    public Project(String name, String geolocation, Date dateStart, Date dateEnd, Status status, String description, Integer room, Integer bath, Integer garage, Integer terrace, String wallMaterial, String foundationType, String roofingType, Double areaSize, Double budget, String planFloor, String picture) {
        this.name = name;
        this.geolocation = geolocation;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.status = status;
        this.description = description;
        this.room = room;
        this.bath = bath;
        this.garage = garage;
        this.terrace = terrace;
        this.wallMaterial = wallMaterial;
        this.foundationType = foundationType;
        this.roofingType = roofingType;
        this.areaSize = areaSize;
        this.budget = budget;
        this.planFloor = planFloor;
        this.picture = picture;
    }

    public Project() {
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

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getBath() {
        return bath;
    }

    public void setBath(Integer bath) {
        this.bath = bath;
    }

    public Integer getGarage() {
        return garage;
    }

    public void setGarage(Integer garage) {
        this.garage = garage;
    }

    public Integer getTerrace() {
        return terrace;
    }

    public void setTerrace(Integer terrace) {
        this.terrace = terrace;
    }

    public String getWallMaterial() {
        return wallMaterial;
    }

    public void setWallMaterial(String wallMaterial) {
        this.wallMaterial = wallMaterial;
    }

    public String getFoundationType() {
        return foundationType;
    }

    public void setFoundationType(String foundationType) {
        this.foundationType = foundationType;
    }

    public String getRoofingType() {
        return roofingType;
    }

    public void setRoofingType(String roofingType) {
        this.roofingType = roofingType;
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

    public String getPlanFloor() {
        return planFloor;
    }

    public void setPlanFloor(String planFloor) {
        this.planFloor = planFloor;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", geolocation='" + geolocation + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", room=" + room +
                ", bath=" + bath +
                ", garage=" + garage +
                ", terrace=" + terrace +
                ", wallMaterial='" + wallMaterial + '\'' +
                ", foundationType='" + foundationType + '\'' +
                ", roofingType='" + roofingType + '\'' +
                ", areaSize=" + areaSize +
                ", budget=" + budget +
                ", planfloor='" + planFloor + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}

