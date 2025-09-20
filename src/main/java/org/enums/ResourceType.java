package org.enums;

public enum ResourceType {
    VEHICLE("VEHICLE"),
    MATERIAL("MATERIAL"),
    EQUIPMENT("EQUIPMENT");

    private final String resourceType;

    ResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceTypeName() {
        return resourceType;
    }

    @Override
    public String toString() {
        return resourceType;
    }
}
