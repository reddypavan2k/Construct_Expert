package org.model;

import org.enums.EmployeeType;

public class Supervisor extends Employee{

    public Supervisor(Long id, String name, String jobType, String picture, Boolean availability, EmployeeType employeeType) {
        super(id, name, jobType, picture, availability, employeeType);
        this.setEmployeeType(EmployeeType.SUPERVISOR);
    }

    public Supervisor(String name, String jobType, String picture, Boolean availability, EmployeeType employeeType) {
        super(name, jobType, picture, availability, employeeType);
        this.setEmployeeType(EmployeeType.SUPERVISOR);
    }

    public Supervisor(Long id, String name, String jobType, String picture, Boolean availability) {
        super(id, name, jobType, picture, availability);
        this.setEmployeeType(EmployeeType.SUPERVISOR);
    }

    public Supervisor(String name, String jobType, String picture, Boolean availability) {
        super(name, jobType, picture, availability);
        this.setEmployeeType(EmployeeType.SUPERVISOR);
    }

    public Supervisor() {
    }
}
