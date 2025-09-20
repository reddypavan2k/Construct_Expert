package org.repository;

import org.config.DatabaseConfig;
import org.dto.TaskDTO;
import org.enums.EmployeeType;
import org.enums.Priority;
import org.enums.ResourceType;
import org.enums.Status;
import org.model.Resource;
import org.model.Supervisor;
import org.model.Task;
import org.model.Team;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    DatabaseConfig databaseConfig = new DatabaseConfig();

    @Override
    public List<Task> getAll(Long id) throws SQLException, ClassNotFoundException {
        List<Task> tasks = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM task WHERE id_project = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Task task = new Task();
            task.setId(resultSet.getLong("id"));
            task.setTitle(resultSet.getString("title"));
            task.setType(resultSet.getString("type"));
            task.setStartDate(resultSet.getDate("start_date"));
            task.setEndDate(resultSet.getDate("end_date"));
            task.setDescription(resultSet.getString("description")); // Ajout de la description
            task.setPriority(Priority.valueOf(resultSet.getString("priority")));
            task.setStatus(Status.valueOf(resultSet.getString("status")));
            tasks.add(task);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return tasks;
    }

    @Override
    public Long add(Long id, Task task) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "INSERT INTO task (title, type, start_date, end_date, description, priority, status, id_project) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, task.getTitle());
        statement.setString(2, task.getType());
        statement.setDate(3, task.getStartDate());
        statement.setDate(4, task.getEndDate());
        statement.setString(5, task.getDescription());
        statement.setString(6, task.getPriority().name());
        statement.setString(7, task.getStatus().name());
        statement.setLong(8, id);
        statement.executeUpdate();
        String getIdQuery = "SELECT id FROM task WHERE id_project = ? AND title = ?";
        PreparedStatement getIdStatement = connection.prepareStatement(getIdQuery);
        getIdStatement.setLong(1, id);
        getIdStatement.setString(2, task.getTitle());
        ResultSet resultSet = getIdStatement.executeQuery();
        Long idTask = null;
        if (resultSet.next()) {
           idTask = resultSet.getLong("id");
        }
        getIdStatement.close();
        statement.close();
        connection.close();
        return idTask;
    }

    @Override
    public void update(Task task) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE task SET title=?, type=?, start_date=?, end_date=?, description=?, priority=?, status=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, task.getTitle());
        statement.setString(2, task.getType());
        statement.setDate(3, task.getStartDate());
        statement.setDate(4, task.getEndDate());
        statement.setString(5, task.getDescription());
        statement.setString(6, task.getPriority().name());
        statement.setString(7, task.getStatus().name());
        statement.setLong(8, task.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void delete(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "DELETE FROM task WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public Task getById(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM task WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        Task task = null;
        if (resultSet.next()) {
            task = new Task();
            task.setId(resultSet.getLong("id"));
            task.setTitle(resultSet.getString("title"));
            task.setType(resultSet.getString("type"));
            task.setStartDate(resultSet.getDate("start_date"));
            task.setEndDate(resultSet.getDate("end_date"));
            task.setDescription(resultSet.getString("description"));
            task.setPriority(Priority.valueOf(resultSet.getString("priority")));
            task.setStatus(Status.valueOf(resultSet.getString("status")));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return task;
    }

    @Override
    public void updateTaskStatus(Long id, Status status) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE task SET status = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, String.valueOf(status));
        statement.setLong(2, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public TaskDTO getTaskWithAssociated(Long id) throws SQLException, ClassNotFoundException {
        TaskDTO taskDTO = new TaskDTO();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM task WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            taskDTO.setId(resultSet.getLong("id"));
            taskDTO.setTitle(resultSet.getString("title"));
            taskDTO.setType(resultSet.getString("type"));
            taskDTO.setStartDate(resultSet.getDate("start_date"));
            taskDTO.setEndDate(resultSet.getDate("end_date"));
            LocalDate today = LocalDate.now();
            LocalDate startDate = taskDTO.getStartDate().toLocalDate();
            taskDTO.setDaysLeft((int) ChronoUnit.DAYS.between(startDate, today));
            taskDTO.setDescription(resultSet.getString("description"));
            taskDTO.setPriority(Priority.valueOf(resultSet.getString("priority")));
            taskDTO.setStatus(Status.valueOf(resultSet.getString("status")));
            Supervisor supervisor = new Supervisor();
            String querySupervisor = "SELECT employee.id, employee.name, employee.job_type, employee.picture, employee.availability, employee.employee_type FROM task_employee JOIN task ON task_employee.id_task = task.id JOIN employee ON task_employee.id_employee = employee.id WHERE task.id = ? AND employee.employee_type = ?";
            PreparedStatement statementSupervisor = connection.prepareStatement(querySupervisor);
            statementSupervisor.setLong(1, id);
            statementSupervisor.setString(2, EmployeeType.SUPERVISOR.toString());
            ResultSet resultSetSupervisor = statementSupervisor.executeQuery();
            if (resultSetSupervisor.next()){
                supervisor.setId(resultSetSupervisor.getLong("employee.id"));
                supervisor.setName(resultSetSupervisor.getString("employee.name"));
                supervisor.setJobType(resultSetSupervisor.getString("employee.job_type"));
                supervisor.setPicture(resultSetSupervisor.getString("employee.picture"));
                supervisor.setAvailability(resultSetSupervisor.getBoolean("employee.availability"));
                supervisor.setEmployeeType(EmployeeType.valueOf(resultSetSupervisor.getString("employee.employee_type")));
            }
            taskDTO.setSupervisor(supervisor);
            statementSupervisor.close();
            resultSetSupervisor.close();
            Team team = new Team();
            String queryTeam = "SELECT employee.id, employee.name, employee.job_type, employee.picture, employee.availability, employee.employee_type FROM task_employee JOIN task ON task_employee.id_task = task.id JOIN employee ON task_employee.id_employee = employee.id WHERE task.id = ? AND employee.employee_type = ?";
            PreparedStatement statementTeam = connection.prepareStatement(queryTeam);
            statementTeam.setLong(1, id);
            statementTeam.setString(2, EmployeeType.TEAM.toString());
            ResultSet resultSetTeam = statementTeam.executeQuery();
            if (resultSetTeam.next()){
                team.setId(resultSetTeam.getLong("employee.id"));
                team.setName(resultSetTeam.getString("employee.name"));
                team.setJobType(resultSetTeam.getString("employee.job_type"));
                team.setPicture(resultSetTeam.getString("employee.picture"));
                team.setAvailability(resultSetTeam.getBoolean("employee.availability"));
                team.setEmployeeType(EmployeeType.valueOf(resultSetTeam.getString("employee.employee_type")));
            }
            taskDTO.setTeam(team);
            statementTeam.close();
            resultSetTeam.close();
            List<Resource> resources = new ArrayList<>();
            String queryResource = "SELECT resource.id, resource.title, resource.type, resource.provider, resource.acquisition_date, resource.picture, resource.quantity, resource.availability, resource.resource_type FROM task_resource JOIN task ON task_resource.id_task = task.id JOIN resource ON task_resource.id_resource = resource.id WHERE task.id = ? ORDER BY resource_type DESC";
            PreparedStatement statementResources = connection.prepareStatement(queryResource);
            statementResources.setLong(1, id);
            ResultSet resultSetResources = statementResources.executeQuery();
            while (resultSetResources.next()){
                Resource resource = new Resource();
                resource.setId(resultSetResources.getLong("resource.id"));
                resource.setTitle(resultSetResources.getString("resource.title"));
                resource.setType(resultSetResources.getString("resource.type"));
                resource.setProvider(resultSetResources.getString("resource.provider"));
                resource.setAcquisitionDate(resultSetResources.getDate("resource.acquisition_date"));
                resource.setPicture(resultSetResources.getString("resource.picture"));
                resource.setQuantity(resultSetResources.getString("resource.quantity"));
                resource.setAvailability(resultSetResources.getBoolean("resource.availability"));
                resource.setResourceType(ResourceType.valueOf(resultSetResources.getString("resource.resource_type")));
                resources.add(resource);
            }
            taskDTO.setResourceList(resources);
            statementResources.close();
            resultSetResources.close();
        }
        statement.close();
        resultSet.close();
        return taskDTO;
    }

    @Override
    public List<TaskDTO> getAllTaskWithAssociated(Long id) throws SQLException, ClassNotFoundException {
        List<TaskDTO> tasks = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String queryTasks = "SELECT * FROM task WHERE id_project = ?";
        PreparedStatement statementTasks = connection.prepareStatement(queryTasks);
        statementTasks.setLong(1, id);
        ResultSet resultSetTasks = statementTasks.executeQuery();
        while (resultSetTasks.next()) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(resultSetTasks.getLong("id"));
            taskDTO.setTitle(resultSetTasks.getString("title"));
            taskDTO.setType(resultSetTasks.getString("type"));
            taskDTO.setStartDate(resultSetTasks.getDate("start_date"));
            taskDTO.setEndDate(resultSetTasks.getDate("end_date"));
            LocalDate today = LocalDate.now();
            LocalDate startDate = taskDTO.getStartDate().toLocalDate();
            taskDTO.setDaysLeft((int) ChronoUnit.DAYS.between(startDate, today));
            taskDTO.setDescription(resultSetTasks.getString("description"));
            taskDTO.setPriority(Priority.valueOf(resultSetTasks.getString("priority")));
            taskDTO.setStatus(Status.valueOf(resultSetTasks.getString("status")));
            Supervisor supervisor = new Supervisor();
            String querySupervisor = "SELECT employee.id, employee.name, employee.job_type, employee.picture, employee.availability, employee.employee_type FROM task_employee JOIN employee ON task_employee.id_employee = employee.id WHERE task_employee.id_task = ? AND employee.employee_type = ?";
            PreparedStatement statementSupervisor = connection.prepareStatement(querySupervisor);
            statementSupervisor.setLong(1, taskDTO.getId());
            statementSupervisor.setString(2, EmployeeType.SUPERVISOR.toString());
            ResultSet resultSetSupervisor = statementSupervisor.executeQuery();
            if (resultSetSupervisor.next()) {
                supervisor.setId(resultSetSupervisor.getLong("employee.id"));
                supervisor.setName(resultSetSupervisor.getString("employee.name"));
                supervisor.setJobType(resultSetSupervisor.getString("employee.job_type"));
                supervisor.setPicture(resultSetSupervisor.getString("employee.picture"));
                supervisor.setAvailability(resultSetSupervisor.getBoolean("employee.availability"));
                supervisor.setEmployeeType(EmployeeType.valueOf(resultSetSupervisor.getString("employee.employee_type")));
            }
            statementSupervisor.close();
            resultSetSupervisor.close();
            taskDTO.setSupervisor(supervisor);
            Team team = new Team();
            String queryTeam = "SELECT employee.id, employee.name, employee.job_type, employee.picture, employee.availability, employee.employee_type FROM task_employee JOIN employee ON task_employee.id_employee = employee.id WHERE task_employee.id_task = ? AND employee.employee_type = ?";
            PreparedStatement statementTeam = connection.prepareStatement(queryTeam);
            statementTeam.setLong(1, taskDTO.getId());
            statementTeam.setString(2, EmployeeType.TEAM.toString());
            ResultSet resultSetTeam = statementTeam.executeQuery();
            if (resultSetTeam.next()) {
                team.setId(resultSetTeam.getLong("employee.id"));
                team.setName(resultSetTeam.getString("employee.name"));
                team.setJobType(resultSetTeam.getString("employee.job_type"));
                team.setPicture(resultSetTeam.getString("employee.picture"));
                team.setAvailability(resultSetTeam.getBoolean("employee.availability"));
                team.setEmployeeType(EmployeeType.valueOf(resultSetTeam.getString("employee.employee_type")));
            }
            statementTeam.close();
            resultSetTeam.close();
            taskDTO.setTeam(team);
            List<Resource> resources = new ArrayList<>();
            String queryResource = "SELECT resource.id, resource.title, resource.type, resource.provider, resource.acquisition_date, resource.picture, resource.quantity, resource.availability, resource.resource_type FROM task_resource JOIN resource ON task_resource.id_resource = resource.id WHERE task_resource.id_task = ? ORDER BY resource.resource_type DESC";
            PreparedStatement statementResources = connection.prepareStatement(queryResource);
            statementResources.setLong(1, taskDTO.getId());
            ResultSet resultSetResources = statementResources.executeQuery();
            while (resultSetResources.next()) {
                Resource resource = new Resource();
                resource.setId(resultSetResources.getLong("resource.id"));
                resource.setTitle(resultSetResources.getString("resource.title"));
                resource.setType(resultSetResources.getString("resource.type"));
                resource.setProvider(resultSetResources.getString("resource.provider"));
                resource.setAcquisitionDate(resultSetResources.getDate("resource.acquisition_date"));
                resource.setPicture(resultSetResources.getString("resource.picture"));
                resource.setQuantity(resultSetResources.getString("resource.quantity"));
                resource.setAvailability(resultSetResources.getBoolean("resource.availability"));
                resource.setResourceType(ResourceType.valueOf(resultSetResources.getString("resource.resource_type")));
                resources.add(resource);
            }
            statementResources.close();
            resultSetResources.close();
            taskDTO.setResourceList(resources);
            tasks.add(taskDTO);
        }
        statementTasks.close();
        resultSetTasks.close();
        connection.close();
        return tasks;
    }

}
