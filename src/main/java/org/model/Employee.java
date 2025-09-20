package org.model;

import org.enums.EmployeeType;

public class Employee {
    private Long id;
    private String name;
    private String jobType;
    private String picture;
    private Boolean availability;
    private EmployeeType employeeType;

    public Employee(Long id, String name, String jobType, String picture, Boolean availability, EmployeeType employeeType) {
        this.id = id;
        this.name = name;
        this.jobType = jobType;
        this.picture = picture;
        this.availability = availability;
        this.employeeType = employeeType;
    }

    public Employee(String name, String jobType, String picture, Boolean availability, EmployeeType employeeType) {
        this.name = name;
        this.jobType = jobType;
        this.picture = picture;
        this.availability = availability;
        this.employeeType = employeeType;
    }

    public Employee(Long id, String name, String jobType, String picture, Boolean availability) {
        this.id = id;
        this.name = name;
        this.jobType = jobType;
        this.picture = picture;
        this.availability = availability;
    }

    public Employee(String name, String jobType, String picture, Boolean availability) {
        this.name = name;
        this.jobType = jobType;
        this.picture = picture;
        this.availability = availability;
    }

    public Employee() {
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

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobType='" + jobType + '\'' +
                ", picture='" + picture + '\'' +
                ", availability=" + availability +
                ", employeeType=" + employeeType +
                '}';
    }
}
