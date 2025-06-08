package com.cdac.dao;

import java.sql.Connection;
import java.util.Iterator;
import com.cdac.pojo.User;

public interface UserDAO {
    public boolean registerUser(String username, String password, String name, String email, String city);

    public Iterator<String> allUsers();

    public User getUser(String username);

    public boolean changePassword(String username, String password);

    public Connection getConnection();

}
