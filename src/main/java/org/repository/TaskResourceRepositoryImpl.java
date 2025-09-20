package org.repository;

import org.config.DatabaseConfig;
import org.dto.ResourceDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TaskResourceRepositoryImpl implements TaskResourceRepository{
    DatabaseConfig databaseConfig = new DatabaseConfig();
    @Override
    public void AffectResourceToTask(Long id, List<ResourceDTO> resourceDTOList) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "INSERT INTO task_resource (id_task, id_resource, quantity) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        for (ResourceDTO resourceDTO : resourceDTOList) {
            statement.setLong(1, id);
            statement.setLong(2, resourceDTO.getId());
            statement.setString(3, resourceDTO.getQuantity());
            statement.executeUpdate();
        }
        statement.close();
        connection.close();
    }

    @Override
    public void UpdateResourceQuantity(List<ResourceDTO> resourceDTOList) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE resource SET quantity = quantity - ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        for (ResourceDTO resourceDTO : resourceDTOList) {
            statement.setString(1, resourceDTO.getQuantity());
            statement.setLong(2, resourceDTO.getId());
            statement.executeUpdate();
        }
        String availabilityQuery = "UPDATE resource SET availability = false WHERE quantity = 0";
        PreparedStatement availabilityStatement = connection.prepareStatement(availabilityQuery);
        availabilityStatement.executeUpdate();
        availabilityStatement.close();
        statement.close();
        connection.close();
    }
}
