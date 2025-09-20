package org.model;

import org.enums.ResourceType;

import java.sql.Date;


public class Resource {
    private Long id;
    private String title;
    private String type;
    private String provider;
    private Date acquisitionDate;
    private String picture;
    private String quantity;
    private Boolean availability;
    private ResourceType resourceType;

    public Resource(Long id, String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability, ResourceType resourceType) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.provider = provider;
        this.acquisitionDate = acquisitionDate;
        this.picture = picture;
        this.quantity = quantity;
        this.availability = availability;
        this.resourceType = resourceType;
    }

    public Resource(String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability, ResourceType resourceType) {
        this.title = title;
        this.type = type;
        this.provider = provider;
        this.acquisitionDate = acquisitionDate;
        this.picture = picture;
        this.quantity = quantity;
        this.availability = availability;
        this.resourceType = resourceType;
    }

    public Resource(Long id, String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.provider = provider;
        this.acquisitionDate = acquisitionDate;
        this.picture = picture;
        this.quantity = quantity;
        this.availability = availability;
    }

    public Resource(String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability) {
        this.title = title;
        this.type = type;
        this.provider = provider;
        this.acquisitionDate = acquisitionDate;
        this.picture = picture;
        this.quantity = quantity;
        this.availability = availability;
    }

    public Resource() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public java.sql.Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", provider='" + provider + '\'' +
                ", acquisitionDate=" + acquisitionDate +
                ", picture='" + picture + '\'' +
                ", quantity='" + quantity + '\'' +
                ", availability=" + availability +
                ", resourceType=" + resourceType +
                '}';
    }
}

