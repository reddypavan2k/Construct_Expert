package org.repository;

import org.dto.UserDTO;
import org.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    List<User> getAll() throws SQLException, ClassNotFoundException;
    void add(User user) throws SQLException, ClassNotFoundException;
    void update(User user) throws SQLException, ClassNotFoundException;
    void delete(Long id) throws SQLException, ClassNotFoundException;
    User getById(Long id) throws SQLException, ClassNotFoundException;
    UserDTO authentication(String username, String password) throws SQLException, ClassNotFoundException;
}
