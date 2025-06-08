package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

import com.cdac.dao.DBConnection;

public class TableColumns {
    public static void main(String[] args) {
        try (
                Scanner sc = new Scanner(System.in);
                Connection dbConnection = DBConnection.getConnection();
                Statement stTable = dbConnection.createStatement();) {

            System.out.print("\nEnter table name : ");
            String tableName = sc.next();

            ResultSet result = stTable.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData metaData = result.getMetaData();

            for (int i = 1; i < metaData.getColumnCount() + 1; i++)
                System.out.println(i + ". " + metaData.getColumnName(i) + " : " + metaData.getColumnTypeName(i));

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
