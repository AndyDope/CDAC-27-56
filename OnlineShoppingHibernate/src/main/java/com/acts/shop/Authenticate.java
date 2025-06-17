package com.acts.shop;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.acts.shop.entity.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = -4114756371064815429L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        SessionFactory sessionFactory = (SessionFactory) context.getAttribute("hibernateSessionFactory");
        Session session = sessionFactory.openSession();

        Query<User> query = session.createQuery(
                "SELECT OBJECT(oUser) FROM User oUser WHERE username = :username AND password = :password", User.class);
        query.setParameter("username", req.getParameter("username"));
        query.setParameter("password", req.getParameter("password"));
        
        User user;
        try {
            user = query.getSingleResult();
        } catch (jakarta.persistence.NoResultException nre) {
            req.getSession().setAttribute("errorMessage", "Login failed. Please try again.");
            resp.sendRedirect("index.jsp");
            return;
        }
        session.close();

        if (user != null) {
            HttpSession userSession = req.getSession(true);
            userSession.setAttribute("username", user.getUsername());
            userSession.setAttribute("isLoggedIn", true);
            userSession.setAttribute("admin", false);
            if (user.isAdmin()) {
                userSession.setAttribute("admin", true);
                resp.sendRedirect("admin.jsp");
            }
        }
    }
}
