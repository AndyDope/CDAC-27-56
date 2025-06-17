package com.acts.shop;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.acts.shop.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 8763916895707592749L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        boolean allParams = Arrays.asList(username, password, name, email, address).stream()
                .allMatch(Objects::nonNull);

        if (allParams) {
            req.getSession().setAttribute("registrationSuccess",
                    "You have been successfully registered! Please log in.");
            resp.sendRedirect("index.jsp");
        } else {
            req.getSession().setAttribute("errorMessage", "Registration failed. Please try again.");
            resp.sendRedirect("signup.jsp");
            return;
        }

        SessionFactory sessionFactory = (SessionFactory) getServletContext().getAttribute("hibernateSessionFactory");
        Session hbSession = sessionFactory.openSession();
        Transaction transaction = hbSession.beginTransaction();

        User newUser = new User(username, password, email, name, address);
        hbSession.persist(newUser);
        transaction.commit();
        hbSession.close();

    }

}
