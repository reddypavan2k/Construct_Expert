package org.repository;

import org.dto.TaskDTO;
import org.enums.Status;
import org.model.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskRepository {
    List<Task> getAll(Long id) throws SQLException, ClassNotFoundException;
    Long add(Long id, Task task) throws SQLException, ClassNotFoundException;
    void update(Task task) throws SQLException, ClassNotFoundException;
    void delete(Long id) throws SQLException, ClassNotFoundException;
    Task getById(Long id) throws SQLException, ClassNotFoundException;
    void updateTaskStatus(Long id, Status status) throws SQLException, ClassNotFoundException;
    TaskDTO getTaskWithAssociated(Long id) throws SQLException, ClassNotFoundException;
    List<TaskDTO> getAllTaskWithAssociated(Long id) throws SQLException, ClassNotFoundException;
}
