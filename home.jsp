<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.User, com.foodapp.model.Restaurent, java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foody - It's an Experience</title>
    <link rel="stylesheet" href="home.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
</head>
<body>
    <header>
        <div class="container">
            <div class="logo">Foody</div>
            <nav>
                <input type="checkbox" id="nav-toggle" class="nav-toggle">
                <label for="nav-toggle" class="nav-toggle-label">
                    <span></span>
                </label>
                <ul>
                    <li><a href="GetAllRestaurant">Home</a></li>
                    <li><a href="Aboutus.html">About Us</a></li>
                    <li><a href="Contact-us.html">Contact-us</a></li>
                </ul>
            </nav>
            <div class="profile-container">
                <input type="checkbox" id="profile-toggle" class="profile-toggle">
                <label for="profile-toggle" class="profile-btn">
                    <div class="profile-icon">
                        <svg viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <circle cx="16" cy="16" r="16" fill="black"/>
                            <circle cx="16" cy="11" r="4.5" fill="white"/>
                            <path d="M16 16C12 16 8.5 18 8.5 22V24H23.5V22C23.5 18 20 16 16 16Z" fill="white"/>
                        </svg>
                    </div>
                    <span class="profile-text">Profile</span>
                </label>
                <div class="profile-popup">
                    <div class="popup-content">
                        <div class="popup-profile-icon">
                            <svg viewBox="0 0 120 120" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <circle cx="60" cy="60" r="60" fill="black"/>
                                <circle cx="60" cy="45" r="16" fill="white"/>
                                <path d="M60 65C48 65 38 71 38 83V90H82V83C82 71 72 65 60 65Z" fill="white"/>
                            </svg>
                        </div>
                        <!--  <span class="popup-profile-text">Profile</span>  -->
                        <% 
                        User user = (User) session.getAttribute("user"); 
                        if (user != null) {
                        %>
                            <h2><%= user.getUser_name() %></h2>
                            <h5><%= user.getEmail() %></h5>
                        <%
                        } 
                        %>
                        <a href="MyOrders" class="popup-btn">My Orders</a>
                        <label for="profile-toggle" class="popup-btn close-btn">Close</label>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <main>
        <section class="hero">
            <div class="container">
                <div class="hero-content">
                    <% 
                    if (user != null) {
                    %>
                        <h2>Welcome, <%= user.getUser_name() %>!</h2>
                    <%
                    } 
                    %>
                    <div class="location">
                        <span class="location-icon"></span>
                        Bengaluru
                    </div>
                    <h1>Discover Restaurants that deliver near you</h1>
                    <form action="SearchMenuServlet" method="get">
                    <div class="search-bar">
                        <input type="text" name="search"placeholder="Search for your fav Food">
                        <button class="btn-primary">search</button>
                    </div>
                    </form>  
                </div>
            </div>
        </section>

        <section class="featured-restaurants">
            <div class="container">
                <h2>Featured Restaurants</h2>
                
                <div class="restaurant-grid">
                    <%
                    ArrayList<Restaurent> restaurants = (ArrayList<Restaurent>) session.getAttribute("restaurentList");
                    if (restaurants != null && !restaurants.isEmpty()) {
                        for (Restaurent res : restaurants) {
                    %>
                    <a href="MenuFetch?Restaurant_id=<%=res.getRestaurant_id() %>" class="restaurant-card">
      
                        <div class="card">
                            <div class="card-header">
                                <img src="<%= res.getRestauran_imagePath() %>" alt="<%= res.getRestaurant_name() %>" />
                                <h3><%= res.getRestaurant_name() %></h3>
                                	
                                <span class="cuisine-badge"><%= res.getCuisine_type() %></span>
                            </div>
                            <div class="card-body">
                                <p><strong>Delivery Time:</strong> <%= res.getDelivery_time() %></p>
                                <p><strong>Address:</strong> <%= res.getRestaurant_adress() %></p>
                                <p class="rating">
                                    <strong>Rating:</strong>
                                    <span class="stars">
                                        <% for(int i = 0; i < Math.round(res.getRestaurant_rating()); i++) { %>★<% } %>
                                    </span>
                                    (<%= String.format("%.1f", res.getRestaurant_rating()) %>)
                                </p>
                            </div>
                            <div class="card-footer <%= res.getRestaurant_isActive() == 1 ? "active" : "inactive" %>">
                                <%= res.getRestaurant_isActive() == 1 ? "Open Now" : "Closed" %>
                            </div>
                        </div>
                    </a>
                    <%
                        }
                    } else {
                    %>
                    <p class="no-restaurants">No Restaurants Available.</p>
                    <%
                    } 
                    %>
                </div>
            </div>
        </section>
    </main>

    <footer>
        <div class="container">
            <p>&copy; 2024 Foody. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>

