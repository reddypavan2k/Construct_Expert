package org.model;

import org.enums.ResourceType;

import java.sql.Date;


public class Material extends Resource{

    public Material(Long id, String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability, ResourceType resourceType) {
        super(id, title, type, provider, acquisitionDate, picture, quantity, availability, resourceType);
        setResourceType(ResourceType.MATERIAL);
    }

    public Material(String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability, ResourceType resourceType) {
        super(title, type, provider, acquisitionDate, picture, quantity, availability, resourceType);
        setResourceType(ResourceType.MATERIAL);
    }

    public Material(Long id, String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability) {
        super(id, title, type, provider, acquisitionDate, picture, quantity, availability);
        setResourceType(ResourceType.MATERIAL);
    }

    public Material(String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability) {
        super(title, type, provider, acquisitionDate, picture, quantity, availability);
        setResourceType(ResourceType.MATERIAL);
    }

    public Material() {
        super();
    }
}
