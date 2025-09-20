package org.repository;

import org.config.DatabaseConfig;
import org.enums.ResourceType;
import org.model.Equipment;
import org.model.Material;
import org.model.Resource;
import org.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceRepositoryImpl implements ResourceRepository {

    DatabaseConfig databaseConfig = new DatabaseConfig();

    @Override
    public List<Equipment> getAllEquipment() throws SQLException, ClassNotFoundException {
        List<Equipment> equipments = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM resource WHERE resource_type = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, ResourceType.EQUIPMENT.toString());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Equipment equipment = new Equipment();
            equipment.setId(resultSet.getLong("id"));
            equipment.setTitle(resultSet.getString("title"));
            equipment.setType(resultSet.getString("type"));
            equipment.setProvider(resultSet.getString("provider"));
            equipment.setAcquisitionDate(resultSet.getDate("acquisition_date"));
            equipment.setPicture(resultSet.getString("picture"));
            equipment.setQuantity(resultSet.getString("quantity"));
            equipment.setAvailability(resultSet.getBoolean("availability"));
            equipments.add(equipment);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return equipments;
    }

    @Override
    public List<Material> getAllMaterial() throws SQLException, ClassNotFoundException {
        List<Material> materials = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM resource WHERE resource_type = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, ResourceType.MATERIAL.toString());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Material material = new Material();
            material.setId(resultSet.getLong("id"));
            material.setTitle(resultSet.getString("title"));
            material.setType(resultSet.getString("type"));
            material.setProvider(resultSet.getString("provider"));
            material.setAcquisitionDate(resultSet.getDate("acquisition_date"));
            material.setPicture(resultSet.getString("picture"));
            material.setQuantity(resultSet.getString("quantity"));
            material.setAvailability(resultSet.getBoolean("availability"));
            materials.add(material);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return materials;
    }

    @Override
    public List<Vehicle> getAllVehicle() throws SQLException, ClassNotFoundException {
        List<Vehicle> vehicles = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM resource WHERE resource_type = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, ResourceType.VEHICLE.toString());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(resultSet.getLong("id"));
            vehicle.setTitle(resultSet.getString("title"));
            vehicle.setType(resultSet.getString("type"));
            vehicle.setProvider(resultSet.getString("provider"));
            vehicle.setAcquisitionDate(resultSet.getDate("acquisition_date"));
            vehicle.setPicture(resultSet.getString("picture"));
            vehicle.setQuantity(resultSet.getString("quantity"));
            vehicle.setAvailability(resultSet.getBoolean("availability"));
            vehicles.add(vehicle);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return vehicles;
    }

    @Override
    public List<Resource> getAllAvailable() throws SQLException, ClassNotFoundException {
        List<Resource> resources = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM resource WHERE availability = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setBoolean(1, true);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Resource resource = new Resource();
            resource.setId(resultSet.getLong("id"));
            resource.setTitle(resultSet.getString("title"));
            resource.setType(resultSet.getString("type"));
            resource.setProvider(resultSet.getString("provider"));
            resource.setAcquisitionDate(resultSet.getDate("acquisition_date"));
            resource.setPicture(resultSet.getString("picture"));
            resource.setQuantity(resultSet.getString("quantity"));
            resource.setAvailability(resultSet.getBoolean("availability"));
            resource.setResourceType(ResourceType.valueOf(resultSet.getString("resource_type")));
            resources.add(resource);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return resources;
    }

    @Override
    public List<Resource> getAllResource() throws SQLException, ClassNotFoundException {
        List<Resource> resources = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM resource";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Resource resource = new Resource();
            resource.setId(resultSet.getLong("id"));
            resource.setTitle(resultSet.getString("title"));
            resource.setType(resultSet.getString("type"));
            resource.setProvider(resultSet.getString("provider"));
            resource.setAcquisitionDate(resultSet.getDate("acquisition_date"));
            resource.setPicture(resultSet.getString("picture"));
            resource.setQuantity(resultSet.getString("quantity"));
            resource.setAvailability(resultSet.getBoolean("availability"));
            resource.setResourceType(ResourceType.valueOf(resultSet.getString("resource_type")));
            resources.add(resource);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return resources;
    }

    @Override
    public void add(Resource resource) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "INSERT INTO resource (title, type, provider, acquisition_date, picture, quantity, availability, resource_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, resource.getTitle());
        statement.setString(2, resource.getType());
        statement.setString(3, resource.getProvider());
        statement.setDate(4, resource.getAcquisitionDate());
        statement.setString(5, resource.getPicture());
        statement.setString(6, resource.getQuantity());
        statement.setBoolean(7, resource.getAvailability());
        statement.setString(8, resource.getResourceType().toString());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void update(Resource resource) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE resource SET title=?, type=?, provider=?, acquisition_date=?, picture=?, quantity=?, availability=?, resource_type=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, resource.getTitle());
        statement.setString(2, resource.getType());
        statement.setString(3, resource.getProvider());
        statement.setDate(4, resource.getAcquisitionDate());
        statement.setString(5, resource.getPicture());
        statement.setString(6, resource.getQuantity());
        statement.setBoolean(7, resource.getAvailability());
        statement.setString(8, resource.getResourceType().toString());
        statement.setLong(9, resource.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void delete(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "DELETE FROM resource WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public Resource getById(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM resource WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        Resource resource = null;
        if (resultSet.next()) {
            resource = new Resource();
            resource.setId(resultSet.getLong("id"));
            resource.setTitle(resultSet.getString("title"));
            resource.setType(resultSet.getString("type"));
            resource.setProvider(resultSet.getString("provider"));
            resource.setAcquisitionDate(resultSet.getDate("acquisition_date"));
            resource.setPicture(resultSet.getString("picture"));
            resource.setQuantity(resultSet.getString("quantity"));
            resource.setAvailability(resultSet.getBoolean("availability"));
            resource.setResourceType(ResourceType.valueOf(resultSet.getString("resource_type")));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return resource;
    }

    @Override
    public Integer allResources() throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT COUNT(*) AS total_resource FROM resource";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        Integer total = 0;
        if(resultSet.next()){
            total = resultSet.getInt("total_resource");
        }
        return total;
    }

    @Override
    public Integer countResourceByType(ResourceType resourceType) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT COUNT(*) AS total_resource FROM resource WHERE resource_type = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, String.valueOf(resourceType));
        ResultSet resultSet = statement.executeQuery();
        Integer total = 0;
        if(resultSet.next()){
            total = resultSet.getInt("total_resource");
        }
        return total;
    }
}