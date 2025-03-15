<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.foodapp.model.Orders" %>
<%@ page import="com.foodapp.model.Order_Items" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order History</title>
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
            padding: 0 20px;
        }

        /* Header styles */
        header {
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
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
            font-size: 2rem;
            font-weight: bold;
            color: #ff4500;
            text-decoration: none;
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
            font-weight: 500;
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
            outline: none;
        }

        .search-btn {
            background: none;
            border: none;
            cursor: pointer;
            font-size: 1.2rem;
            color: #666;
            transition: color 0.3s ease;
        }

        .search-btn:hover {
            color: #ff4500;
        }

        .profile-btn {
            background-color: #ff4500;
            color: #fff;
            padding: 0.5rem 1rem;
            border-radius: 50%;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .profile-btn:hover {
            background-color: #e63900;
        }

        /* Main content styles */
        main {
            padding: 2rem 0;
            text-align: center;
        }

        .order-history {
            padding: 2rem;
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 2.5rem;
            color: #333;
            margin-bottom: 1.5rem;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #ff4500;
            color: white;
        }

        .order-details {
            margin-top: 20px;
            padding: 10px;
            background-color: #f9f9f9;
            border-radius: 8px;
        }

        .order-details table {
            width: 100%;
        }

        .back-home-btn {
            background-color: #ff4500;
            color: #fff;
            padding: 0.75rem 2rem;
            border-radius: 25px;
            font-size: 1.2rem;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease;
            display: inline-block;
        }

        .back-home-btn:hover {
            background-color: #e63900;
        }

        /* Footer styles */
        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 1rem 0;
            margin-top: 2rem;
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
                    <li><a href="Contact-us.html">Contact Us</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <main class="container">
        <div class="order-history">
            <h1>Order History</h1>
            <table>
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Total Amount</th>
                        <th>Status</th>
                        <th>Payment Mode</th>
                        <th>Restaurant ID</th>
                        <th>Details</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Orders> orderHistory = (ArrayList<Orders>) request.getAttribute("orderHistory");
                        if (orderHistory != null && !orderHistory.isEmpty()) {
                            for (Orders order : orderHistory) {
                    %>
                    <tr>
                        <td><%= order.getOrder_id() %></td>
                        <td><%= order.getTotal_amount() %></td>
                        <td><%= order.getStatus() %></td>
                        <td><%= order.getPayment_mode() %></td>
                        <td><%= order.getRestaurant_id() %></td>
                        <td><a href="#orderDetails_<%= order.getOrder_id() %>" onclick="document.getElementById('orderDetails_<%= order.getOrder_id() %>').style.display='block'">View Details</a></td>
                    </tr>
                    <tr id="orderDetails_<%= order.getOrder_id() %>" class="order-details" style="display:none;">
                        <td colspan="6">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Menu ID</th>
                                        <th>Quantity</th>
                                        <th>Items Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                    
                                        ArrayList<Order_Items> orderItems = order.getOrderItems();
                                        if (orderItems != null && !orderItems.isEmpty()) {
                                           
                                    %>
                                    <tr>
                                        <td><%= orderItems.get(0).getMenu_id() %></td>
                                        <td><%= orderItems.get(0).getQuanttity() %></td>
                                        <td><%= orderItems.get(0).getItems_total() %></td>
                                    </tr>
                                    <%
                                            
                                        } else {
                                    %>
                                    <tr>
                                        <td colspan="3">No items found.</td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="6">No orders found.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <a href="home.jsp" class="back-home-btn">Back to Home</a>
        </div>
    </main>

    <footer>
        <div class="container">
            <p>&copy; 2025 Foody. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
