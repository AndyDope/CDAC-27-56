package com.acts.shop.listener;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ResourceAllocator implements ServletContextListener {
    SessionFactory hibernateSessionFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // Hibernate Session Factory Opened
        ServletContext context = sce.getServletContext();
        Configuration hiberConfig = new Configuration();
        Properties props = new Properties();

        props.setProperty("hibernate.connection.driver_class", context.getInitParameter("hibernate.connection.driver_class"));
        props.setProperty("hibernate.connection.url", context.getInitParameter("hibernate.connection.url"));
        props.setProperty("hibernate.connection.username", context.getInitParameter("hibernate.connection.username"));
        props.setProperty("hibernate.connection.password", context.getInitParameter("hibernate.connection.password"));
        props.setProperty("hibernate.dialect", context.getInitParameter("hibernate.dialect"));
        props.setProperty("hibernate.hbm2ddl.auto", context.getInitParameter("hibernate.hbm2ddl.auto"));

        hiberConfig.setProperties(props);
        hiberConfig.addAnnotatedClass(com.acts.shop.entity.User.class);
        hiberConfig.addAnnotatedClass(com.acts.shop.entity.Category.class);
        hiberConfig.addAnnotatedClass(com.acts.shop.entity.Product.class);

        hibernateSessionFactory = hiberConfig.buildSessionFactory();

        System.out.println("############################Session Factory Initialed");
        context.setAttribute("hibernateSessionFactory", hibernateSessionFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        // Hibernate Session Factory Closed
        hibernateSessionFactory.close();
        System.out.println("############################Session Factory Closed");
    }

}
