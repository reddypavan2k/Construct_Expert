package org.repository;

import org.config.DatabaseConfig;
import org.dto.ProjectDTO;
import org.enums.Status;
import org.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {

    DatabaseConfig databaseConfig = new DatabaseConfig();

    @Override
    public List<Project> getAll() throws SQLException, ClassNotFoundException {
        List<Project> projects = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM project";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Project project = new Project();
            project.setId(resultSet.getLong("id"));
            project.setName(resultSet.getString("name"));
            project.setGeolocation(resultSet.getString("geolocation"));
            project.setDateStart(resultSet.getDate("date_start"));
            project.setDateEnd(resultSet.getDate("date_end"));
            project.setStatus(Status.valueOf(resultSet.getString("status")));
            project.setDescription(resultSet.getString("description"));
            project.setRoom(resultSet.getInt("room"));
            project.setBath(resultSet.getInt("bath"));
            project.setGarage(resultSet.getInt("garage"));
            project.setTerrace(resultSet.getInt("terrace"));
            project.setWallMaterial(resultSet.getString("wall_material"));
            project.setFoundationType(resultSet.getString("foundation_type"));
            project.setRoofingType(resultSet.getString("roofing_type"));
            project.setAreaSize(resultSet.getDouble("area_size"));
            project.setBudget(resultSet.getDouble("budget"));
            project.setPlanFloor(resultSet.getString("plan_floor"));
            project.setPicture(resultSet.getString("picture"));
            projects.add(project);
        }
        resultSet.close();
        statement.close();
        return projects;
    }

    @Override
    public void add(Project project) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "INSERT INTO project (name, geolocation, date_start, date_end, status, description, room, " +
                "bath, garage, terrace, wall_material, foundation_type, roofing_type, area_size, budget, " +
                "plan_floor, picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, project.getName());
        statement.setString(2, project.getGeolocation());
        statement.setDate(3, project.getDateStart());
        statement.setDate(4, project.getDateEnd());
        statement.setString(5, project.getStatus().toString());
        statement.setString(6, project.getDescription());
        statement.setInt(7, project.getRoom());
        statement.setInt(8, project.getBath());
        statement.setInt(9, project.getGarage());
        statement.setInt(10, project.getTerrace());
        statement.setString(11, project.getWallMaterial());
        statement.setString(12, project.getFoundationType());
        statement.setString(13, project.getRoofingType());
        statement.setDouble(14, project.getAreaSize());
        statement.setDouble(15, project.getBudget());
        statement.setString(16, project.getPlanFloor());
        statement.setString(17, project.getPicture());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void update(Project project) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE project SET name = ?, geolocation = ?, date_start = ?, date_end = ?, status = ?, " +
                "description = ?, room = ?, bath = ?, garage = ?, terrace = ?, wall_material = ?, " +
                "foundation_type = ?, roofing_type = ?, area_size = ?, budget = ?, plan_floor = ?, picture = ? " +
                "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, project.getName());
        statement.setString(2, project.getGeolocation());
        statement.setDate(3, project.getDateStart());
        statement.setDate(4, project.getDateEnd());
        statement.setString(5, project.getStatus().getStatusName());
        statement.setString(6, project.getDescription());
        statement.setInt(7, project.getRoom());
        statement.setInt(8, project.getBath());
        statement.setInt(9, project.getGarage());
        statement.setInt(10, project.getTerrace());
        statement.setString(11, project.getWallMaterial());
        statement.setString(12, project.getFoundationType());
        statement.setString(13, project.getRoofingType());
        statement.setDouble(14, project.getAreaSize());
        statement.setDouble(15, project.getBudget());
        statement.setString(16, project.getPlanFloor());
        statement.setString(17, project.getPicture());
        statement.setLong(18, project.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void delete(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "DELETE FROM project WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public Project getById(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM project WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();

        Project project = null;
        if (resultSet.next()) {
            project = new Project();
            project.setId(resultSet.getLong("id"));
            project.setName(resultSet.getString("name"));
            project.setGeolocation(resultSet.getString("geolocation"));
            project.setDateStart(resultSet.getDate("date_start"));
            project.setDateEnd(resultSet.getDate("date_end"));
            project.setStatus(Status.valueOf(resultSet.getString("status")));
            project.setDescription(resultSet.getString("description"));
            project.setRoom(resultSet.getInt("room"));
            project.setBath(resultSet.getInt("bath"));
            project.setGarage(resultSet.getInt("garage"));
            project.setTerrace(resultSet.getInt("terrace"));
            project.setWallMaterial(resultSet.getString("wall_material"));
            project.setFoundationType(resultSet.getString("foundation_type"));
            project.setRoofingType(resultSet.getString("roofing_type"));
            project.setAreaSize(resultSet.getDouble("area_size"));
            project.setBudget(resultSet.getDouble("budget"));
            project.setPlanFloor(resultSet.getString("plan_floor"));
            project.setPicture(resultSet.getString("picture"));
        }

        resultSet.close();
        statement.close();
        connection.close();
        return project;
    }

    @Override
    public Integer allProjects() throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT COUNT(*) AS total_project FROM project";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        Integer total = 0;
        if(resultSet.next()){
            total = resultSet.getInt("total_project");
        }
        return total;
    }

    @Override
    public Double countBudget() throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT SUM(budget) AS total_budget FROM project";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        Double total = 0.00;
        if(resultSet.next()){
            total = resultSet.getDouble("total_budget");
        }
        return total;
    }

    @Override
    public List<ProjectDTO> projectProgress() throws SQLException, ClassNotFoundException {
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM project";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setName(resultSet.getString("name"));
            projectDTO.setId(resultSet.getLong("id"));
            projectDTO.setGeolocation(resultSet.getString("geolocation"));
            projectDTO.setDateStart(resultSet.getDate("date_start"));
            projectDTO.setDateEnd(resultSet.getDate("date_end"));
            projectDTO.setPicture(resultSet.getString("picture"));
            projectDTO.setBudget(resultSet.getDouble("budget"));
            projectDTO.setAreaSize(resultSet.getDouble("area_size"));
            projectDTO.setRoom(resultSet.getInt("room"));
            projectDTO.setStatus(Status.valueOf(resultSet.getString("status")));
            String queryDone = "SELECT COUNT(*) as total_done FROM task WHERE id_project = ? AND status = ?";
            PreparedStatement statementDone = connection.prepareStatement(queryDone);
            statementDone.setLong(1, projectDTO.getId());
            statementDone.setString(2, Status.COMPLETED.toString());
            ResultSet resultSetDone = statementDone.executeQuery();
            if (resultSetDone.next()){
                projectDTO.setTaskDone(resultSetDone.getInt("total_done"));
            }
            statementDone.close();
            resultSetDone.close();
            String queryTotal = "SELECT COUNT(*) as total_task FROM task WHERE id_project = ?";
            PreparedStatement statementTotal = connection.prepareStatement(queryTotal);
            statementTotal.setLong(1, projectDTO.getId());
            ResultSet resultSetTotal = statementTotal.executeQuery();
            if (resultSetTotal.next()){
                projectDTO.setTotalTask(resultSetTotal.getInt("total_task"));
            }
            statementTotal.close();
            resultSetTotal.close();
            if (projectDTO.getTotalTask() > 0) {
                double progress = ((double) projectDTO.getTaskDone() / projectDTO.getTotalTask()) * 100;
                projectDTO.setProgress((int) progress);
            }
            if (projectDTO.getTotalTask() == 0){
                String updateProjectToTODO = "UPDATE project SET status = ? WHERE id = ?";
                PreparedStatement statementTODO = connection.prepareStatement(updateProjectToTODO);
                statementTODO.setString(1, Status.TODO.toString());
                statementTODO.setLong(2, projectDTO.getId());
                statementTODO.executeUpdate();
                statementTODO.close();
            } else if (projectDTO.getProgress()<100) {
                String updateProjectToINPROGRESS = "UPDATE project SET status = ? WHERE id = ?";
                PreparedStatement statementINPROGRESS = connection.prepareStatement(updateProjectToINPROGRESS);
                statementINPROGRESS.setString(1, Status.IN_PROGRESS.toString());
                statementINPROGRESS.setLong(2, projectDTO.getId());
                statementINPROGRESS.executeUpdate();
                statementINPROGRESS.close();
            } else if (projectDTO.getProgress()==100) {
                String updateProjectToDONE = "UPDATE project SET status = ? WHERE id = ?";
                PreparedStatement statementDONE = connection.prepareStatement(updateProjectToDONE);
                statementDONE.setString(1, Status.COMPLETED.toString());
                statementDONE.setLong(2, projectDTO.getId());
                statementDONE.executeUpdate();
                statementDONE.close();
            }
        projectDTOList.add(projectDTO);
        }
        statement.close();
        resultSet.close();
        connection.close();
        return projectDTOList;
    }

}
