<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.acts.shop.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>

<header class="navbar navbar-expand-lg navbar-dark bg-dark-text-bg fixed-top py-3">
    <div class="container-fluid">
        <%-- Logo Section --%>
        <a class="navbar-brand text-neutral-background" href="index.jsp">
            <img src="images/logo.png" alt="OnlineShop Logo" style="height: 40px;">
            <%-- YourShop --%>
        </a>

        <%-- Navbar Toggler for Mobile --%>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <%-- Navbar Links --%>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link text-neutral-background" href="index.jsp">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-neutral-background" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Categories
                    </a>
                    <ul class="dropdown-menu bg-dark-text-bg" aria-labelledby="navbarDropdown">
                        <%-- Static Category Links for now --%>
                        <%
                                SessionFactory hbFactory = (SessionFactory) application.getAttribute("hibernateSessionFactory");
                                Session hbSession = hbFactory.openSession();
                            	Query<Category> query = hbSession.createQuery("FROM Category", Category.class);

                            	List<Category> categories = query.getResultList();
                                hbSession.close();
                            	
                            	for (Category category: categories) {
                         %>
                         
                         <li><a class="dropdown-item text-neutral-background" href="Products?category=<%= category.getCatName().replaceAll("[\\s&]", "") %>"><%= category.getCatName() %></a></li>
                         
                         <%   		
                            }
                        %>
                        
                        <li><hr class="dropdown-divider bg-neutral-background"></li>
                        <li><a class="dropdown-item text-neutral-background" href="products">All Products</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-neutral-background" href="about.jsp">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-neutral-background" href="contact.jsp">Contact</a>
                </li>
            </ul>

            <%-- Search Form (Static)
            <form class="d-flex me-2" action="search" method="GET">
                <input class="form-control me-2" type="search" name="query" placeholder="Search products..." aria-label="Search">
                <button class="btn btn-outline-light" type="submit">Search</button>
            </form> --%>

            <%-- Static user-related links --%>
            <ul class="navbar-nav fw-bold">
                <li class="nav-item">
                    <a class="nav-link text-neutral-background" href="<%= session.getAttribute("admin") != null && (Boolean) session.getAttribute("admin") ? "admin.jsp" : "index.jsp" %>">
                        <i class="bi bi-person-circle"></i>
                        <%= session.getAttribute("username") == null ? "Login/Register" : session.getAttribute("username")%>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-neutral-background" href="cart">
                        <i class="bi bi-cart"></i> Cart
                    </a>
                </li>
                <%
                	if(session != null && session.getAttribute("isLoggedIn") != null && (Boolean) session.getAttribute("isLoggedIn"))
                	{
                %>
                <li class="nav-item">
                    <a class="nav-link text-neutral-background" href="Logout">
                        <i class="bi bi-box-arrow-right"></i> Logout
                    </a>
                </li>
                <% } %>
            </ul>

        </div>
    </div>
</header>