<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.User, com.foodapp.model.Menu, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Featured Restaurants</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 20px;
    }

    .featured-restaurants {
        padding: 20px 0;
    }

    .container {
        max-width: 1200px;
        margin: 0 auto;
        padding: 0 15px;
    }

    h2 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 20px;
    }

    .home-link {
        display: inline-block;
        margin-bottom: 20px;
        font-size: 14px;
        color: #3498db;
        text-decoration: none;
        font-weight: bold;
    }

    .home-link:hover {
        text-decoration: underline;
    }

    .restaurant-grid {
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        gap: 20px;
        justify-items: center;
    }

    .card {
        background-color: #ffffff;
        border-radius: 12px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        width: 280px;
        text-align: left;
        position: relative;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .card:hover {
        transform: translateY(-5px);
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    .restaurant-image {
        width: 100%;
        height: 200px;
        object-fit: cover;
    }

    .card-content {
        padding: 15px;
    }

    h3 {
        font-size: 18px;
        font-weight: bold;
        color: #2c3e50;
        margin: 10px 0;
        text-transform: capitalize;
    }

    .description {
        font-size: 14px;
        color: #7f8c8d;
        margin: 5px 0 15px;
    }

    .price {
        font-size: 16px;
        font-weight: bold;
        color: #e74c3c;
        margin: 0;
    }

    .availability {
        font-size: 14px;
        color: #27ae60;
        font-weight: bold;
        margin: 10px 0;
    }

    .not-available {
        color: #e74c3c;
    }

    .add-to-cart-btn {
        display: inline-block;
        padding: 10px 20px;
        font-size: 14px;
        font-weight: bold;
        color: #fff;
        background-color: #27ae60;
        border: none;
        border-radius: 20px;
        cursor: pointer;
        transition: background-color 0.3s;
        text-transform: uppercase;
    }

    .add-to-cart-btn:hover {
        background-color: #219150;
    }

    @media (max-width: 1200px) {
        .restaurant-grid {
            grid-template-columns: repeat(3, 1fr);
        }
    }

    @media (max-width: 768px) {
        .restaurant-grid {
            grid-template-columns: repeat(2, 1fr);
        }
    }

    @media (max-width: 480px) {
        .restaurant-grid {
            grid-template-columns: 1fr;
        }
    }
</style>
</head>
<body>
<section class="featured-restaurants">
    <div class="container">
        <h2>Feast Your Eyes on Our Delicious Treats!</h2>
        <div class="restaurant-grid">
            <%
            // Try both session and request attributes
            ArrayList<Menu> menuList = (ArrayList<Menu>) session.getAttribute("MenuList");
            if(menuList == null) {
                menuList = (ArrayList<Menu>) request.getAttribute("menulist");
            }
            if (menuList != null && !menuList.isEmpty()) {
                for (Menu m : menuList) {
            %>
               <div class="card">
        <div class="new-tag">Newly Launched</div>
        <img src="<%= m.getImage_path() %>" alt="<%= m.getName() %>" class="restaurant-image">
        <div class="card-content">
            <h2><%= m.getName() %></h2>
            <p class="description"><%= m.getDescription() %></p>
            <div class="footer">
                <p class="price">&#x20B9 <%= m.getPrice() %></p>
              	<form action="CartServlet">
    
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="ItemId" value="<%= m.getMenu_id()%>">
                    <button>Add to cart
                </button></form>
            </div>
        </div>
    </div>
            <% 
                } 
            } else { 
            %>
                <div class="container">
                    <p style="text-align: center; color: #666;">No menu items available.</p>
                </div>
            <% 
            } 
            %>
        </div>
    </div>
</section>
</body>
</html>