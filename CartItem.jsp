<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.controller.*,com.foodapp.model.*,java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart | FoodApp</title>
    
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
    	/* Reset and base styles */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Poppins', Arial, sans-serif;
    background-color: #f8f8f8;
    color: #333;
    line-height: 1.6;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
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

/* Cart styles */
.cart-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
    padding-bottom: 10px;
    border-bottom: 1px solid #e0e0e0;
}

.cart-header h1 {
    font-size: 24px;
    font-weight: 700;
    color: #1c1c1c;
}

.cart-items {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    overflow: hidden;
}

.cart-item {
    display: flex;
    align-items: center;
    padding: 20px;
    border-bottom: 1px solid #f0f0f0;
}

.item-image {
    width: 80px;
    height: 80px;
    border-radius: 8px;
    object-fit: cover;
    margin-right: 20px;
}

.item-details {
    flex-grow: 1;
}

.item-name {
    font-size: 16px;
    font-weight: 600;
    margin-bottom: 5px;
}

.item-price {
    font-size: 14px;
    color: #666;
}

.item-actions {
    display: flex;
    align-items: center;
}

.quantity-control {
    display: flex;
    align-items: center;
    margin-right: 20px;
}

.quantity-btn {
    width: 30px;
    height: 30px;
    background-color: #f0f0f0;
    border: none;
    border-radius: 50%;
    font-size: 18px;
    cursor: pointer;
    display: flex;
    justify-content: center;
    align-items: center;
}

.quantity-btn:hover {
    background-color: #e0e0e0;
}

.quantity {
    margin: 0 10px;
    font-size: 16px;
}

.remove-btn {
    background: none;
    border: none;
    color: #ff3d00;
    cursor: pointer;
    font-size: 14px;
}

.cart-summary {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    padding: 20px;
    margin-top: 20px;
}

.summary-row {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
}

.summary-row.total {
    font-weight: 700;
    font-size: 18px;
    border-top: 1px solid #e0e0e0;
    padding-top: 10px;
    margin-top: 10px;
}

.btn {
    display: inline-block;
    padding: 12px 24px;
    background-color: #ff3d00;
    color: #fff;
    text-decoration: none;
    border-radius: 4px;
    font-size: 16px;
    font-weight: 600;
    text-align: center;
    transition: background-color 0.3s ease;
}

.btn:hover {
    background-color: #e53935;
}

.btn-secondary {
    background-color: #fff;
    color: #ff3d00;
    border: 1px solid #ff3d00;
}

.btn-secondary:hover {
    background-color: #fff5f5;
}

.empty-cart {
    text-align: center;
    padding: 40px 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
}

.empty-cart p {
    font-size: 18px;
    color: #666;
    margin-bottom: 20px;
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

    .cart-item {
        flex-direction: column;
        align-items: flex-start;
    }

    .item-actions {
        margin-top: 10px;
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

    <div class="container">
        <div class="cart-header">
            <h1>Your Cart</h1>
        </div>
        
        <%
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getallitems().isEmpty()) {
        %>
        <div class="empty-cart">
            <p>Your cart is empty.</p>
            <a href="GetAllRestaurant" class="btn">Browse Restaurants</a>
        </div>
        <% 
        } else {
            double totalAmount = 0;
            int lastRestaurantId = -1;
        %>
        <div class="cart-items">
            <% 
            for (Map.Entry<Integer, CartItems> entry : cart.getallitems().entrySet()) {
                CartItems item = entry.getValue();
                totalAmount += item.getPrice() * item.getQuantity();
                lastRestaurantId = item.getResataurant_id();
            %>
            <div class="cart-item">
                <div class="item-details">
                    <h3 class="item-name"><%= item.getName() %></h3>
                    <p class="item-price">₹<%= item.getPrice() %></p>
                </div>
                <div class="item-actions">
                    <form action="CartServlet" method="post" class="quantity-control">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="ItemId" value="<%= entry.getKey() %>">
                        <button type="submit" name="quantity" value="<%= item.getQuantity() - 1 %>" class="quantity-btn" <%= item.getQuantity() <= 1 ? "disabled" : "" %>>-</button>
                        <span class="quantity"><%= item.getQuantity() %></span>
                        <button type="submit" name="quantity" value="<%= item.getQuantity() + 1 %>" class="quantity-btn">+</button>
                    </form>
                    <form action="CartServlet" method="post">
                        <input type="hidden" name="action" value="removeitem">
                        <input type="hidden" name="ItemId" value="<%= entry.getKey() %>">
                        <button type="submit" class="remove-btn">Remove</button>
                    </form>
                </div>
            </div>
            <% 
            } 
            %>
        </div>
        <div class="cart-summary">
            <div class="summary-row">
                <span>Subtotal</span>
                <span>₹<%= String.format("%.2f", totalAmount) %></span>
            </div>
            <div class="summary-row">
                <span>Delivery Fee</span>
                <span>₹40.00</span>
            </div>
            <div class="summary-row total">
                <span>Total</span>
                <span>₹<%= String.format("%.2f", totalAmount + 40.00) %></span>
            </div>
            <a href="CheckOut.jsp" class="btn" style="display: block; margin-top: 20px;">Proceed to Checkout</a>
            <a href="MenuFetch?Restaurant_id=<%= lastRestaurantId %>" class="btn btn-secondary" style="display: block; margin-top: 10px;">Add More Items</a>
        </div>
        <% 
        } 
        %>
    </div>
</body>
</html>

