package com.acts.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "Username")
    String username;

    @Column(name = "Password")
    String password;

    @Column(name = "Email")
    String email;

    @Column(name = "Name")
    String name;

    @Column(name = "Address")
    String address;

    @Column(name = "Admin")
    Boolean admin;

    public User() {
    }

    public User(String username, String password, String email, String name, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
        this.admin = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", email=" + email + ", name=" + name
                + ", address=" + address + ", admin=" + admin + "]";
    }

}
