package org.model;

import org.enums.Role;

public class User {
    private Long id;
    private String name;
    private String userName;
    private String userEmail;
    private String password;
    private String picture;
    private Role role;

    public User(Long id, String name, String userName, String userEmail, String password, String picture, Role role) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.picture = picture;
        this.role = role;
    }

    public User(String name, String userName, String userEmail, String password, String picture, Role role) {
        this.name = name;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.picture = picture;
        this.role = role;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", role=" + role +
                '}';
    }
}

