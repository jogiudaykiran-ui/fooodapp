<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Checkout Page</title>
<link rel="stylesheet" href="checkout-styles.css">
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
        padding: 0.5rem 1rem; /* Reduced padding */
    }

    .logo {
        font-size: 1.5rem; /* Reduced font size */
        font-weight: bold;
        color: #ff4500;
        text-decoration: none;
        padding-left: 10px; /* Optional: Adjust padding */
    }

    nav ul {
        display: flex;
        list-style-type: none;
    }

    nav ul li {
        margin-left: 1rem; /* Reduced margin */
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
        padding: 0.3rem 0.5rem; /* Reduced padding */
        transition: box-shadow 0.3s ease;
    }

    .search-bar input {
        width: 150px; /* Reduced width */
        padding: 0.5rem;
        font-size: 0.9rem; /* Reduced font size */
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
        padding: 0.3rem 0.8rem; /* Reduced padding */
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
    }

    form {
        background-color: #fff;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        padding: 2rem;
        max-width: 600px;
        margin: 0 auto;
    }

    form p {
        font-size: 1.8rem;
        font-weight: 600;
        text-align: center;
        margin-bottom: 1.5rem;
        color: #ff4500;
    }

    label {
        display: block;
        margin-bottom: 0.5rem;
        font-weight: 500;
        color: #333;
    }

    input[type="text"],
    select {
        width: 100%;
        padding: 0.75rem;
        margin-bottom: 1rem;
        border: 1px solid #ddd;
        border-radius: 6px;
        font-size: 1rem;
        transition: border-color 0.3s ease, box-shadow 0.3s ease;
    }

    input[type="text"]:focus,
    select:focus {
        outline: none;
        border-color: #ff4500;
        box-shadow: 0 0 0 2px rgba(255, 69, 0, 0.1);
    }

    button[type="submit"] {
        display: block;
        width: 100%;
        padding: 1rem;
        background-color: #ff4500;
        color: #fff;
        border: none;
        border-radius: 6px;
        font-size: 1.1rem;
        font-weight: 600;
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.3s ease;
    }

    button[type="submit"]:hover {
        background-color: #e63900;
        transform: translateY(-2px);
    }

    /* Footer styles */
    footer {
        background-color: #333;
        color: #fff;
        text-align: center;
        padding: 1rem 0;
        margin-top: 2rem;
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

        .search-bar,
        .profile-btn {
            margin-top: 1rem;
        }

        form {
            width: 90%;
            padding: 1.5rem;
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
            
        </div>
    </header>

    <main class="container">
        <form action="CheckOut" method="post">
            <p>Checkout</p>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name"> <br>
            <label for="door-no">Door-No:</label>
            <input type="text" id="door-no" name="door-no"> <br>
            <label for="street">Street:</label>
            <input type="text" id="street" name="street"> <br>
            <label for="landmark">Landmark:</label>
            <input type="text" id="landmark" name="landmark"> <br>
            <label for="pincode">Pincode:</label>
            <input type="text" id="pincode" name="pincode"> <br>
            <label for="mobile">Mobile No:</label>
            <input type="text" id="mobile" name="mobile"> <br>
            <label for="payment-mode">Payment Mode:</label>
            <select id="payment-mode" name="payment-mode">
                <option value="debit">Debit</option>
                <option value="credit">Credit</option>
                <option value="upi">UPI</option>
                <option value="cod">Cash on Delivery (COD)</option>
            </select> <br>
            <button type="submit">Place Order</button>
        </form>
    </main>

    <footer>
        <div class="container">
            <p>&copy; 2023 Foody. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
