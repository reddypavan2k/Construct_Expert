package org.enums;

public enum Role {
    ADMIN("ADMIN"),
    CLIENT("CLIENT"),
    SUPERVISOR("SUPERVISOR");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
