package org.service;

import org.model.Material;
import org.model.Resource;
import org.repository.ResourceRepository;
import org.repository.ResourceRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class MaterialService {
    private final ResourceRepository resourceRepository = new ResourceRepositoryImpl();

    public List<Material> getAllMaterials() throws SQLException, ClassNotFoundException {
        return resourceRepository.getAllMaterial();
    }

    public Resource getById(Long id) throws SQLException, ClassNotFoundException {
        return resourceRepository.getById(id);
    }

    public void add(Material material) throws SQLException, ClassNotFoundException {
        resourceRepository.add(material);
    }

    public void update(Material material) throws SQLException, ClassNotFoundException {
        resourceRepository.update(material);
    }

    public void delete(Long id) throws SQLException, ClassNotFoundException {
        resourceRepository.delete(id);
    }
}
