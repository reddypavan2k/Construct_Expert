package org.repository;

import org.enums.EmployeeType;
import org.model.Employee;
import org.model.Supervisor;
import org.model.Team;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    List<Supervisor> getAllSupervisor() throws SQLException, ClassNotFoundException;
    List<Team> getAllTeam() throws SQLException, ClassNotFoundException;
    List<Employee> allAvailableEmployee() throws SQLException, ClassNotFoundException;
    void add(Employee employee) throws SQLException, ClassNotFoundException;
    void update(Employee employee) throws SQLException, ClassNotFoundException;
    void delete(Long id) throws SQLException, ClassNotFoundException;
    Employee getById(Long id) throws SQLException, ClassNotFoundException;
    Integer allEmployees() throws SQLException, ClassNotFoundException;
    Integer countEmployeeByType(EmployeeType employeeType) throws SQLException, ClassNotFoundException;
}
