package org.model;

import org.enums.ResourceType;

import java.sql.Date;


public class Vehicle extends Resource{
    public Vehicle(Long id, String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability, ResourceType resourceType) {
        super(id, title, type, provider, acquisitionDate, picture, quantity, availability, resourceType);
        setResourceType(ResourceType.VEHICLE);
    }

    public Vehicle(String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability, ResourceType resourceType) {
        super(title, type, provider, acquisitionDate, picture, quantity, availability, resourceType);
        setResourceType(ResourceType.VEHICLE);
    }

    public Vehicle(Long id, String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability) {
        super(id, title, type, provider, acquisitionDate, picture, quantity, availability);
        setResourceType(ResourceType.VEHICLE);
    }

    public Vehicle(String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability) {
        super(title, type, provider, acquisitionDate, picture, quantity, availability);
        setResourceType(ResourceType.VEHICLE);
    }

    public Vehicle() {
        super();
    }
}
