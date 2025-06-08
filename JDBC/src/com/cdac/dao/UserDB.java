package com.cdac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.cdac.pojo.User;

public class UserDB implements UserDAO {

    Connection dbConnection = DBConnection.getConnection();

    @Override
    public boolean registerUser(String username, String password, String name, String email, String city) {
        try {
            PreparedStatement psRegister = dbConnection.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?, ?)");

            psRegister.setString(1, username);
            psRegister.setString(2, password);
            psRegister.setString(3, name);
            psRegister.setString(4, email);
            psRegister.setString(5, city);

            psRegister.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Iterator<String> allUsers() {
        List<String> allUsers = new ArrayList<>();

        try {
            Statement stAllUsers = dbConnection.createStatement();
            ResultSet rsUsers = stAllUsers.executeQuery("SELECT Username FROM users;");

            while (rsUsers.next()) {
                String userName = rsUsers.getString("Username");

                allUsers.add(userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers.iterator();
    }

    @Override
    public User getUser(String username) {
        try {
            Statement stAllUsers = dbConnection.createStatement();
            ResultSet rsUsers = stAllUsers.executeQuery("SELECT * FROM users WHERE username = '" + username + "';");

            if (rsUsers.next()) {
                String userName = rsUsers.getString("Username");
                String password = rsUsers.getString("Password");
                String name = rsUsers.getString("Name");
                String email = rsUsers.getString("Email");
                String city = rsUsers.getString("City");

                return new User(userName, password, email, name, city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public boolean changePassword(String username, String password) {

        try {
            Statement psIsUser = dbConnection
                    .createStatement();

            ResultSet rUser = psIsUser.executeQuery("SELECT username FROM users WHERE Username = '" + username + "';");

            if (rUser.next()) {
                Statement stGetUser = dbConnection.createStatement();

                stGetUser.executeUpdate(
                        "UPDATE users SET Password = '" + password + "' WHERE username = '" + username + "';");

                return true;
            }

            else return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public Connection getConnection() {
        return dbConnection;
    }
}
