package org.repository;

import org.config.DatabaseConfig;
import org.dto.ResourceDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskEmployeeRepositoryImpl implements TaskEmployeeRepository{
    DatabaseConfig databaseConfig = new DatabaseConfig();
    @Override
    public void AffectEmployeeToTask(Long idTask, Long idEmployee) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "INSERT INTO task_employee (id_task, id_employee) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, idTask);
        statement.setLong(2, idEmployee);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void UpdateEmployeeAvailability(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE employee SET availability = false WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
