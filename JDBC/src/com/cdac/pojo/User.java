package com.cdac.pojo;

public class User {
    private String username;
    private String password;
    private String email;
    private String name;
    private String city;

    public User(String username, String password, String email, String name, String city) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", email=" + email + ", name=" + name + "]";
    }

}
