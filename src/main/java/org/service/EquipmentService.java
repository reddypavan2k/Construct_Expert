package org.service;

import org.model.Equipment;
import org.model.Resource;
import org.repository.ResourceRepository;
import org.repository.ResourceRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EquipmentService {
    private final ResourceRepository resourceRepository = new ResourceRepositoryImpl();

    public List<Equipment> getAllEquipment() throws SQLException, ClassNotFoundException {
        return resourceRepository.getAllEquipment();
    }

    public Resource getById(Long id) throws SQLException, ClassNotFoundException {
        return resourceRepository.getById(id);
    }

    public void add(Equipment equipment) throws SQLException, ClassNotFoundException {
        resourceRepository.add(equipment);
    }

    public void update(Equipment equipment) throws SQLException, ClassNotFoundException {
        resourceRepository.update(equipment);
    }

    public void delete(Long id) throws SQLException, ClassNotFoundException {
        resourceRepository.delete(id);
    }
}
