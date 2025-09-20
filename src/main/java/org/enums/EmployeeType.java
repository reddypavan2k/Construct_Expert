package org.enums;

public enum EmployeeType {
    SUPERVISOR("SUPERVISOR"),
    TEAM("TEAM");

    private final String EmployeeType;

    EmployeeType(String EmployeeType) {
        this.EmployeeType = EmployeeType;;
    }

    public String getPriorityName() {
        return EmployeeType;
    }

    @Override
    public String toString() {
        return EmployeeType;
    }
}
