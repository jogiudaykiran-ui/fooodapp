<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.foodapp.model.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Results - Foody</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        /* Include the same styles from menu.jsp */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            line-height: 1.6;
            color: #333;
            background-color: #f5f5f5;
        }

        .container {
            width: 90%;
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        header {
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            position: sticky;
            top: 0;
            z-index: 1000;
        }

        header .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 1rem 0;
        }

        .logo {
            font-size: 1.8rem;
            font-weight: bold;
            color: #ff4500;
        }

        nav ul {
            display: flex;
            list-style-type: none;
        }

        nav ul li {
            margin-left: 1.5rem;
        }

        nav ul li a {
            text-decoration: none;
            color: #333;
            transition: color 0.3s ease;
        }

        nav ul li a:hover {
            color: #ff4500;
        }

        .search-results {
            padding: 3rem 0;
        }

        .search-results h2 {
            text-align: center;
            margin-bottom: 2rem;
            font-size: 2rem;
            color: #333;
        }

        .restaurant-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 2rem;
        }

        .card {
            background-color: #fff;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            position: relative;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
        }

        .restaurant-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
            transition: transform 0.3s ease;
        }

        .card:hover .restaurant-image {
            transform: scale(1.05);
        }

        .card-content {
            padding: 1.5rem;
        }

        h2 {
            font-size: 1.4rem;
            color: #333;
            margin-bottom: 0.5rem;
            font-weight: 600;
        }

        .description {
            font-size: 0.9rem;
            color: #666;
            margin-bottom: 1rem;
            line-height: 1.4;
        }

        .footer {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 1rem;
        }

        .price {
            font-size: 1.3rem;
            font-weight: bold;
            color: #ff4500;
        }

        .add-to-cart-btn {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 0.6rem 1.2rem;
            border-radius: 25px;
            cursor: pointer;
            font-size: 0.9rem;
            font-weight: 600;
            transition: background-color 0.3s ease, transform 0.2s ease;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .add-to-cart-btn:hover {
            background-color: #45a049;
            transform: scale(1.05);
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 1.5rem 0;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <div class="logo">Foody</div>
            <nav>
                <ul>
                    <li><a href="GetAllRestaurant">Home</a></li>
                    <li><a href="Aboutus.html">About Us</a></li>
                    <li><a href="Contact-us.html">Contact-us</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <main>
        <section class="search-results">
            <div class="container">
                <h2>Search Results</h2>
                <div class="restaurant-grid">
                    <% 
                    List<Menu> menuItems = (List<Menu>) request.getAttribute("menuItems");
                    if (menuItems != null && !menuItems.isEmpty()) {
                        for (Menu m : menuItems) {
                    %>
                    <div class="card">
                        <img src="<%= m.getImage_path() %>" alt="<%= m.getName() %>" class="restaurant-image">
                        <div class="card-content">
                            <h2><%= m.getName() %></h2>
                            <p class="description"><%= m.getDescription() %></p>
                            <div class="footer">
                                <p class="price">&#x20B9; <%= m.getPrice() %></p>
                                <form action="CartServlet">
                                    <input type="hidden" name="action" value="add">
                                    <input type="hidden" name="ItemId" value="<%= m.getMenu_id()%>">
                                    <button class="add-to-cart-btn">Add to cart</button>
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                    <% 
                        }
                    } else {
                    %>
                    <p>No items found matching your search.</p>
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
