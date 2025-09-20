package org.model;

import org.enums.EmployeeType;

public class Team extends Employee{


    public Team(Long id, String name, String jobType, String picture, Boolean availability, EmployeeType employeeType) {
        super(id, name, jobType, picture, availability, employeeType);
        this.setEmployeeType(EmployeeType.TEAM);
    }

    public Team(String name, String jobType, String picture, Boolean availability, EmployeeType employeeType) {
        super(name, jobType, picture, availability, employeeType);
        this.setEmployeeType(EmployeeType.TEAM);
    }

    public Team(Long id, String name, String jobType, String picture, Boolean availability) {
        super(id, name, jobType, picture, availability);
        this.setEmployeeType(EmployeeType.TEAM);
    }

    public Team(String name, String jobType, String picture, Boolean availability) {
        super(name, jobType, picture, availability);
        this.setEmployeeType(EmployeeType.TEAM);
    }

    public Team() {
        super();
    }
}
