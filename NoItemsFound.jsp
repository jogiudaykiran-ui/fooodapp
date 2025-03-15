<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>No Food Items Found | FoodApp</title>
    
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        /* Reuse styles from the original file */
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
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            text-align: center;
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
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

        footer {
            background-color: #fff;
            padding: 15px 20px;
            text-align: center;
            box-shadow: 0 -2px 5px rgba(0, 0, 0, 0.1);
            font-size: 14px;
            color: #666;
            margin-top: auto; /* Push footer to the bottom of the page */
        }

        footer a {
            color: #ff4500;
            text-decoration: none;
            font-weight: 600;
        }

        footer a:hover {
            text-decoration: underline;
        }

        /* Message Styling */
        .message {
            font-size: 20px;
            font-weight: 600;
            color: #ff4500;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px; /* Ensure the message box doesn't stretch too wide */
            margin: 20px 0;
        }

        /* Go Back Button */
        .go-back-btn {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            font-weight: 600;
            color: #fff;
            background-color: #ff4500;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .go-back-btn:hover {
            background-color: #e63e00;
        }
    </style>
</head>
<body>
    <!-- Include the Foody bar -->
    <header>
        <div class="container">
            <div class="logo">Foody</div>
            <nav>
                <label for="nav-toggle" class="nav-toggle-label">
                    <span></span>
                </label>
                <ul>
                    <li><a href="GetAllRestaurant">Home</a></li>
                    <li><a href="Aboutus.html">About Us</a></li>
                    <li><a href="Contact-us.html">Contact Us</a></li>
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

    <!-- Centered Message -->
    <div class="container">
        <p class="message">No food items found</p>
        <button class="go-back-btn" onclick="window.history.back()">Go Back</button>
    </div>

    <!-- Footer -->
    <footer>
        &copy; 2025 FoodApp. All rights reserved.
    </footer>
</body>
</html>
