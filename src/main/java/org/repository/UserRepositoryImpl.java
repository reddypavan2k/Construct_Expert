package org.repository;

import org.config.DatabaseConfig;
import org.dto.UserDTO;
import org.enums.Role;
import org.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    DatabaseConfig databaseConfig = new DatabaseConfig();

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM user_table";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name_user"));
            user.setUserName(resultSet.getString("user_name"));
            user.setUserEmail(resultSet.getString("user_email"));
            user.setPassword(resultSet.getString("user_password"));
            user.setPicture(resultSet.getString("picture"));
            user.setRole(Role.valueOf(resultSet.getString("user_role")));
            users.add(user);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return users;
    }

    @Override
    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "INSERT INTO user_table (name_user, user_name, user_email, user_password, picture, user_role) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, user.getUserName());
        statement.setString(3, user.getUserEmail());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getPicture());
        statement.setString(6, user.getRole().toString());
        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void update(User user) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE user_table SET name_user=?, user_name=?, user_email=?, user_password=?, picture=?, user_role=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, user.getUserName());
        statement.setString(3, user.getUserEmail());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getPicture());
        statement.setString(6, user.getRole().toString());
        statement.setLong(7, user.getId());
        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public void delete(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "DELETE FROM user_table WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Override
    public User getById(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM user_table WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name_user"));
            user.setUserName(resultSet.getString("user_name"));
            user.setUserEmail(resultSet.getString("user_email"));
            user.setPassword(resultSet.getString("user_password"));
            user.setPicture(resultSet.getString("picture"));
            user.setRole(Role.valueOf(resultSet.getString("user_role")));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return user;
    }

    @Override
    public UserDTO authentication(String username, String password) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM user_table WHERE user_name=? AND user_password=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            UserDTO user = new UserDTO();
            user.setName(resultSet.getString("name_user"));
            user.setUserName(resultSet.getString("user_name"));
            user.setUserEmail(resultSet.getString("user_email"));
            user.setPicture(resultSet.getString("picture"));
            user.setRole(Role.valueOf(resultSet.getString("user_role")));
            return user;
        }

        resultSet.close();
        statement.close();
        connection.close();

        return null;
    }
}
