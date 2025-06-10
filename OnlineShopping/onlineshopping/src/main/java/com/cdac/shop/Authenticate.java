package com.cdac.shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        Connection dbConnection = (Connection) context.getAttribute("dbConnection");

        try {

            PreparedStatement statement = dbConnection
                    .prepareStatement("SELECT * FROM user WHERE Username = ? AND Password = ?;");

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet auth = statement.executeQuery();

            if (auth.next()) {
                HttpSession session = req.getSession(true);
                session.setAttribute("Username", username);

                resp.getWriter()
                        .println("<h1>Welcome to Celestial Shopping " + session.getAttribute("Username") + "!</h1>");

            } else
                resp.sendRedirect("login.html");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    };

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext context = getServletContext();

        String dbUrl = context.getInitParameter("dbUrl");
        String dbUsername = context.getInitParameter("dbUsername");
        String dbPassword = context.getInitParameter("dbPassword");
        String dbDriverClass = context.getInitParameter("dbDriverClass");

        try {

            Class.forName(dbDriverClass);
            Connection dbConnection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            context.setAttribute("dbConnection", dbConnection);

        } catch (SQLException | ClassNotFoundException e) {

            System.out.println("Failed to establish a connection with the Database");
            e.printStackTrace();
        }
        System.out.println("Connection Established");
    }

    @Override
    public void destroy() {
        ServletContext context = getServletContext();

        try {

            ((Connection) context.getAttribute("dbConnection")).close();
            System.out.println("Connection Terminated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
    }
}
