package org.service;

import org.model.Employee;
import org.model.Team;
import org.repository.EmployeeRepository;
import org.repository.EmployeeRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class TeamService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    public List<Team> getAllTeams() throws SQLException, ClassNotFoundException {
        return employeeRepository.getAllTeam();
    }

    public Employee getById(Long id) throws SQLException, ClassNotFoundException {
        return employeeRepository.getById(id);
    }

    public void add(Team team) throws SQLException, ClassNotFoundException {
        employeeRepository.add(team);
    }

    public void update(Team team) throws SQLException, ClassNotFoundException {
        employeeRepository.update(team);
    }

    public void delete(Long id) throws SQLException, ClassNotFoundException {
        employeeRepository.delete(id);
    }
}
