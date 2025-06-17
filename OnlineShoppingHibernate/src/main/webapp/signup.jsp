<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - OnlineShop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="css/style.css" rel="stylesheet">
</head>
<%-- Apply the custom login-page-body class for centering the form --%>
<body class="login-page-body">
    <%-- Include the Navbar component --%>
    <%@ include file="jsp/Navbar.jsp" %>

    <main class="container">
        <%-- The login-container class from style.css styles this div --%>
        <div class="login-container">
            <h2 class="mb-4 text-dark-text-bg">Register into OnlineShop</h2>

            <%-- Display error message if exists (passed from Authenticate servlet) --%>
            <%
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null && !errorMessage.isEmpty()) {
            %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert1">
                    <%= errorMessage %>
                    <button type="button" class="btn-close" data-bs-dismiss="alert1" aria-label="Close"></button>
                </div>
            <%
                }
            %>

            <form action="Register" method="post">
                <div class="mb-3">
                    <label for="usernameInput" class="form-label text-dark-text-bg">Username</label>
                    <input type="text" class="form-control" id="usernameInput" name="username" required>
                </div>
                <div class="mb-3">
                    <label for="passwordInput" class="form-label text-dark-text-bg">Password</label>
                    <input type="password" class="form-control" id="passwordInput" name="password" required>
                </div>
                <div class="mb-3">
                    <label for="nameInput" class="form-label text-dark-text-bg">Name</label>
                    <input type="text" class="form-control" id="nameInput" name="name" required>
                </div>
                <div class="mb-3">
                    <label for="emailInput" class="form-label text-dark-text-bg">Email</label>
                    <input type="email" class="form-control" id="emailInput" name="email" required>
                </div>
                <div class="mb-3">
                    <label for="addressInput" class="form-label text-dark-text-bg">Address</label>
                    <textarea class="form-control" id="addressInput" name="address" required></textarea>
                </div>
                
                <%-- Use custom btn-primary for styling --%>
                <button type="submit" class="btn btn-primary login-button">Sign Up</button>
            </form>
            
            <%-- Signup link --%>
            <p class="text-center mt-3 text-dark-text-bg">
                Already have an account? <a href="index.jsp" class="text-primary-accent">Login here</a>
            </p>
        </div>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>