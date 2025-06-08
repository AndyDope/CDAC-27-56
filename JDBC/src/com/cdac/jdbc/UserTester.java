package com.cdac.jdbc;

import java.sql.Connection;
import java.util.Iterator;
import java.util.Scanner;
import com.cdac.dao.UserDB;
import com.cdac.pojo.User;

public class UserTester {
    public static void main(String[] args) {
        UserDB userDB = new UserDB();
        try (
                Connection dbConnection = userDB.getConnection();
                Scanner sc = new Scanner(System.in);) {

            int choice = -1;
            while (choice != 0) {

                System.out.print(
                        "\n============MENU============"
                                + "\n1. Register new User"
                                + "\n2. Show all Users"
                                + "\n3. Details of specific User"
                                + "\n4. Change password"
                                + "\n0. Exit"
                                + "\n: ");

                switch (choice = sc.nextInt()) {
                    case 1: {
                        System.out.print("Enter Username : ");
                        String userName = sc.next();

                        System.out.print("Enter Password : ");
                        String password = sc.next();

                        System.out.print("Enter Email : ");
                        String email = sc.next();

                        System.out.print("Enter Name : ");
                        String name = sc.next();

                        System.out.print("Enter City : ");
                        String city = sc.next();

                        if (userDB.registerUser(userName, password, name, email, city))
                            System.out.println("\n* User registered Successfully");
                        else
                            System.err.println("\n* Error Creating new user");
                        break;
                    }

                    case 2: {
                        Iterator<String> it = userDB.allUsers();

                        if (!it.hasNext()) {
                            System.out.println("\n* No user found");
                            break;
                        }

                        System.out.println("\n*_ List of all users:");
                        for (int i = 1; it.hasNext(); i++) {
                            String user = it.next();
                            System.out.println(i + ". " + user);
                        }
                        break;
                    }

                    case 3: {
                        System.out.print("\nEnter username : ");
                        String username = sc.next();

                        User user = userDB.getUser(username);
                        if (user != null)
                            System.out.println("\n* " + user);
                        else
                            System.out.println("\n* User not found");
                        break;
                    }

                    case 4: {

                        System.out.print("\nEnter Username : ");
                        String username = sc.next();

                        System.out.print("Enter new Password : ");
                        String newPassword = sc.next();

                        if (userDB.changePassword(username, newPassword))
                            System.out.println("\n* Password updated successfully");
                        else
                            System.err.println("\n* Invalid Username");
                        break;
                    }

                    default: {
                        System.err.println("\n* Enter a valid option");
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n* Program exited successfully :)");

    }
}
