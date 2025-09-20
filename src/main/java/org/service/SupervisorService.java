package org.service;

import org.model.Employee;
import org.model.Supervisor;
import org.repository.EmployeeRepository;
import org.repository.EmployeeRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class SupervisorService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    public List<Supervisor> getAllSupervisors() throws SQLException, ClassNotFoundException {
        return employeeRepository.getAllSupervisor();
    }

    public Employee getById(Long id) throws SQLException, ClassNotFoundException {
        return employeeRepository.getById(id);
    }

    public void add(Supervisor supervisor) throws SQLException, ClassNotFoundException {
        employeeRepository.add(supervisor);
    }

    public void update(Supervisor supervisor) throws SQLException, ClassNotFoundException {
        employeeRepository.update(supervisor);
    }

    public void delete(Long id) throws SQLException, ClassNotFoundException {
        employeeRepository.delete(id);
    }
}
