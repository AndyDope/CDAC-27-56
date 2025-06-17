<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home - OnlineShop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="css/style.css" rel="stylesheet">
</head>
<body class="login-page-body">
	<%
		if(session == null || !(Boolean) session.getAttribute("admin"))
			response.sendRedirect("index.jsp");
	%>
    <%-- Include the Navbar component --%>
    <%@ include file="jsp/Navbar.jsp" %>

    <main class="container">
        <%-- Admin menus --%>
        <div style="font-family: 'Inter', sans-serif; text-align: center; padding: 40px; background-color: #f8f9fa; min-height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center;">
        <h1 style="color: #343a40; margin-bottom: 20px; font-size: 2.5em;">Welcome, <%= session.getAttribute("username") %>!</h1>
        <p style="color: #6c757d; margin-bottom: 40px; font-size: 1.1em;">What would you like to do today?</p>

        <div style="display: flex; flex-wrap: wrap; gap: 25px; justify-content: center; max-width: 900px; width: 100%;">
            <!-- Add Product Button -->
            <a href="addProduct.jsp" style="text-decoration: none; flex: 1 1 200px; max-width: 280px;">
                <button style="
                    width: 100%;
                    background-color: #28a745; /* Green */
                    color: white;
                    padding: 20px 25px;
                    border: none;
                    border-radius: 12px;
                    cursor: pointer;
                    font-size: 1.2em;
                    font-weight: bold;
                    transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
                    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    gap: 10px;
                    min-height: 100px;
                " onmouseover="this.style.backgroundColor='#218838'; this.style.transform='scale(1.05)'; this.style.boxShadow='0 8px 16px rgba(0,0,0,0.3)';" onmouseout="this.style.backgroundColor='#28a745'; this.style.transform='scale(1)'; this.style.boxShadow='0 6px 12px rgba(0,0,0,0.2)';">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-plus-circle"><circle cx="12" cy="12" r="10"/><path d="M8 12h8"/><path d="M12 8v8"/></svg>
                    <span>Add Product</span>
                </button>
            </a>

            <!-- Add Category Button -->
            <a href="addCategory.jsp" style="text-decoration: none; flex: 1 1 200px; max-width: 280px;">
                <button style="
                    width: 100%;
                    background-color: #007bff; /* Blue */
                    color: white;
                    padding: 20px 25px;
                    border: none;
                    border-radius: 12px;
                    cursor: pointer;
                    font-size: 1.2em;
                    font-weight: bold;
                    transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
                    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    gap: 10px;
                    min-height: 100px;
                " onmouseover="this.style.backgroundColor='#0056b3'; this.style.transform='scale(1.05)'; this.style.boxShadow='0 8px 16px rgba(0,0,0,0.3)';" onmouseout="this.style.backgroundColor='#007bff'; this.style.transform='scale(1)'; this.style.boxShadow='0 6px 12px rgba(0,0,0,0.2)';">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-folder-plus"><path d="M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h5l2 3h9a2 2 0 0 1 2 2Z"/><path d="M12 11v6"/><path d="M9 14h6"/></svg>
                    <span>Add Category</span>
                </button>
            </a>

            <!-- Update Product Button -->
            <a href="updateProduct.jsp" style="text-decoration: none; flex: 1 1 200px; max-width: 280px;">
                <button style="
                    width: 100%;
                    background-color: #ffc107; /* Yellow */
                    color: #343a40;
                    padding: 20px 25px;
                    border: none;
                    border-radius: 12px;
                    cursor: pointer;
                    font-size: 1.2em;
                    font-weight: bold;
                    transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
                    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    gap: 10px;
                    min-height: 100px;
                " onmouseover="this.style.backgroundColor='#e0a800'; this.style.transform='scale(1.05)'; this.style.boxShadow='0 8px 16px rgba(0,0,0,0.3)';" onmouseout="this.style.backgroundColor='#ffc107'; this.style.transform='scale(1)'; this.style.boxShadow='0 6px 12px rgba(0,0,0,0.2)';">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-pencil"><path d="M17 3a2.85 2.85 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5Z"/><path d="M15 5l4 4"/></svg>
                    <span>Update Product</span>
                </button>
            </a>

            <!-- Update Category Button -->
            <a href="updateCategory.jsp" style="text-decoration: none; flex: 1 1 200px; max-width: 280px;">
                <button style="
                    width: 100%;
                    background-color: #dc3545; /* Red */
                    color: white;
                    padding: 20px 25px;
                    border: none;
                    border-radius: 12px;
                    cursor: pointer;
                    font-size: 1.2em;
                    font-weight: bold;
                    transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
                    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    gap: 10px;
                    min-height: 100px;
                " onmouseover="this.style.backgroundColor='#c82333'; this.style.transform='scale(1.05)'; this.style.boxShadow='0 8px 16px rgba(0,0,0,0.3)';" onmouseout="this.style.backgroundColor='#dc3545'; this.style.transform='scale(1)'; this.style.boxShadow='0 6px 12px rgba(0,0,0,0.2)';">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-folder-pen"><path d="M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h5l2 3h9a2 2 0 0 1 2 2Z"/><path d="M17 10l-4 4L2 22l2.5-1.5L17 10Z"/><path d="M15 12l4 4"/></svg>
                    <span>Update Category</span>
                </button>
            </a>
        </div>
    </div>
                
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>