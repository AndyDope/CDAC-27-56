package com.cdac.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    static Connection dbConnection;
    private DBConnection() {};

    public static Connection getConnection() {
        Properties dbProperties = new Properties();

        try {
            dbProperties.load(
                    new FileInputStream("application.properties"));
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        String dbUrl = dbProperties.getProperty("sql.url");
        String dbUser = dbProperties.getProperty("sql.user");
        String dbPassword = dbProperties.getProperty("sql.password");

        try {
            dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return dbConnection;
    }

}
