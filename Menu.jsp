<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.foodapp.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foody - Menu Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
    	/* Reset and base styles */
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

/* Header styles */
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

.search-bar {
    display: flex;
    align-items: center;
    background-color: #f0f0f0;
    border-radius: 20px;
    padding: 0.5rem;
}

.search-bar input {
    border: none;
    background-color: transparent;
    padding: 0.5rem;
    font-size: 1rem;
    width: 200px;
}

.search-btn {
    background: none;
    border: none;
    cursor: pointer;
    font-size: 1.2rem;
}

.profile-btn {
    background-color: #ff4500;
    color: #fff;
    padding: 0.5rem 1rem;
    border-radius: 50%;
    text-decoration: none;
    font-weight: bold;
}

/* Food quote styles */
.food-quote {
    background-color: #f9f9f9;
    padding: 2rem 0;
    text-align: center;
    border-bottom: 1px solid #e0e0e0;
}

.food-quote p {
    font-size: 1.4rem;
    font-style: italic;
    color: #555;
    max-width: 800px;
    margin: 0 auto;
    position: relative;
    padding: 0 2rem;
}

.food-quote p::before,
.food-quote p::after {
    content: '"';
    font-size: 3rem;
    position: absolute;
    color: #ccc;
}

.food-quote p::before {
    left: 0;
    top: -1rem;
}

.food-quote p::after {
    right: 0;
    bottom: -2rem;
}

/* Menu section styles */
.menu-section {
    padding: 3rem 0;
    background-color: #fff;
}

.menu-container {
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

/* Footer styles */
footer {
    background-color: #333;
    color: #fff;
    text-align: center;
    padding: 1.5rem 0;
    font-size: 0.9rem;
}

/* Responsive styles */
@media (max-width: 768px) {
    header .container {
        flex-wrap: wrap;
    }

    nav {
        order: 3;
        width: 100%;
        margin-top: 1rem;
    }

    nav ul {
        flex-direction: column;
        align-items: center;
    }

    nav ul li {
        margin: 0.5rem 0;
    }

    .search-bar, .profile-btn {
        margin-top: 1rem;
    }

    .food-quote p {
        font-size: 1.2rem;
        padding: 0 1.5rem;
    }

    .menu-container {
        grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    }
}

@media (max-width: 480px) {
    .menu-container {
        grid-template-columns: 1fr;
    }

    .food-quote p {
        font-size: 1rem;
        padding: 0 1rem;
    }
}

/* Navigation toggle for mobile */
.nav-toggle {
    display: none;
}

.nav-toggle-label {
    display: none;
    cursor: pointer;
}

@media (max-width: 768px) {
    .nav-toggle-label {
        display: block;
        position: absolute;
        top: 0;
        right: 0;
        margin-right: 1rem;
        height: 100%;
        display: flex;
        align-items: center;
    }

    .nav-toggle-label span,
    .nav-toggle-label span::before,
    .nav-toggle-label span::after {
        display: block;
        background: #333;
        height: 2px;
        width: 2rem;
        border-radius: 2px;
        position: relative;
    }

    .nav-toggle-label span::before,
    .nav-toggle-label span::after {
        content: '';
        position: absolute;
    }

    .nav-toggle-label span::before {
        bottom: 7px;
    }

    .nav-toggle-label span::after {
        top: 7px;
    }

    nav {
        position: absolute;
        top: 100%;
        left: 0;
        background: #fff;
        width: 100%;
        transform: scale(1, 0);
        transform-origin: top;
        transition: transform 0.3s ease-out;
    }

    nav ul {
        margin: 0;
        padding: 0;
        list-style: none;
    }

    nav li {
        margin-bottom: 1rem;
        margin-left: 1rem;
    }

    nav a {
        color: #333;
        text-decoration: none;
        font-size: 1.2rem;
        opacity: 0;
        transition: opacity 150ms ease-in-out;
    }

    .nav-toggle:checked ~ nav {
        transform: scale(1, 1);
    }

    .nav-toggle:checked ~ nav a {
        opacity: 1;
        transition: opacity 250ms ease-in-out 250ms;
    }
}

    	
    </style>
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
            <form action="SearchMenuServlet" method="get">
            <div class="search-bar">
                <input type="text" name="search" placeholder="Search...">
                <button class="search-btn">🔍</button>
            </div>
            </form>
        </div>
    </header>

    <div class="food-quote">
        <div class="container">
            <p>"One cannot think well, love well, sleep well, if one has not dined well."</p>
        </div>
    </div>

    <main>
        <section class="menu-section">
            <div class="container">
                <div class="menu-container">
                    <% 
                    ArrayList<Menu> menuList = (ArrayList<Menu>) request.getAttribute("menulist");
                    if (menuList != null) {
                        for (Menu m : menuList) {
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
                    <p>No menu items available.</p>
                    <% } %>
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

