package org.service;

import org.model.Resource;
import org.model.Vehicle;
import org.repository.ResourceRepository;
import org.repository.ResourceRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class VehicleService {
    private final ResourceRepository resourceRepository = new ResourceRepositoryImpl();

    public List<Vehicle> getAllVehicles() throws SQLException, ClassNotFoundException {
        return resourceRepository.getAllVehicle();
    }

    public Resource getById(Long id) throws SQLException, ClassNotFoundException {
        return  resourceRepository.getById(id);
    }

    public void add(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        resourceRepository.add(vehicle);
    }

    public void update(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        resourceRepository.update(vehicle);
    }

    public void delete(Long id) throws SQLException, ClassNotFoundException {
        resourceRepository.delete(id);
    }
}
