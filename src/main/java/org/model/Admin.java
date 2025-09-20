package org.model;

import org.enums.Role;

public class Admin extends User{
    public Admin(Long id, String name, String userName, String userEmail, String userPassword, String picture, Role role) {
        super(id, name, userName, userEmail, userPassword, picture, role);
        this.setRole(Role.ADMIN);
    }

    public Admin() {
        super();
    }
}
