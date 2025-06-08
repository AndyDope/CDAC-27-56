package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.cdac.dao.DBConnection;

public class TableCreator {
    public static void main(String[] args) {
        try (
                Scanner sc = new Scanner(System.in);
                Connection dbConnection = DBConnection.getConnection();
                Statement stCreateTable = dbConnection.createStatement();
        ) {
            int choice = -1;

            System.out.print("\nEnter table name : ");
            String tableName = sc.next();

            StringBuilder queryCreateTable = new StringBuilder("CREATE TABLE ").append(tableName).append("(");
            List<String> columnsList = new ArrayList<>();
            String primaryKey = "";

            while (choice != 3) {
                System.out.print(
                        "\n============MENU============"
                                + "\n1. Add column"
                                + "\n2. Set Primary key"
                                + "\n3. Save"
                                + "\n: ");

                switch (choice = sc.nextInt()) {
                    case 1: {
                        System.out.print("\n* Enter name of column : ");
                        StringBuilder columnName = new StringBuilder(sc.next());

                        if (columnsList.stream().anyMatch(col -> col.contains(columnName))) {
                            System.err.println("\n* Column name already exist");
                            break;
                        }

                        System.out.print("\n* Choose datatype"
                                + "\n1. VARCHAR(20)"
                                + "\n2. INT"
                                + "\n3. DECIMAL(10,2)"
                                + "\n: ");

                        int type = -1;
                        while (!Arrays.asList(1, 2, 3).contains(type)) {

                            switch (type = sc.nextInt()) {
                                case 1: {
                                    columnName.append(" VARCHAR(20), ");
                                    break;
                                }
                                case 2: {
                                    columnName.append(" INT, ");
                                    break;
                                }
                                case 3: {
                                    columnName.append(" DECIMAL(10,2), ");
                                    break;
                                }
                                default: {
                                    System.err.println("\n* Choose a valid datatype [1, 2, 3]");
                                    break;
                                }
                            }
                        }

                        columnsList.add(columnName.toString());
                        queryCreateTable.append(columnName);

                        break;
                    }

                    case 2: {

                        if (columnsList.isEmpty()) {
                            System.err.println("\n* No column added yet");
                            break;
                        }

                        System.out.println("\n* Select column");
                        for (int i = 0; i < columnsList.size(); i++)
                            System.out.println((i + 1) + ". " + columnsList.get(i).replace(", ", ""));
                        System.out.print(": ");

                        int columnNumber = sc.nextInt() - 1;

                        if (columnNumber < 0 || columnNumber > columnsList.size() - 1) {
                            System.err.println("\n* Invalid column number");
                            break;
                        }

                        primaryKey = columnsList.get(columnNumber).split(" ")[0];

                        System.out.println("\n* Primary key set to : " + primaryKey);
                        break;
                    }

                    case 3: {
                        if (primaryKey.isEmpty())
                            queryCreateTable.deleteCharAt(queryCreateTable.length() - 2).append(");");
                        else
                            queryCreateTable.append("PRIMARY KEY(").append(primaryKey).append(")").append(");");

                        stCreateTable.execute(queryCreateTable.toString());
                        System.out.println("\n* Table '" + tableName + "' created successfully");
                        break;
                    }

                    default: {
                        System.err.println("\n* Enter a valid choice");
                        break;
                    }
                }
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        System.out.println("\n* Program exited successfully :)");

    }
}
