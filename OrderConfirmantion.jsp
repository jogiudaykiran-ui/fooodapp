<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thank You - Order Confirmed | Foody</title>
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

        .thank-you-content {
            padding: 2rem;
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            position: relative;
            overflow: hidden;
        }

        .text-animation {
            font-size: 2rem;
            font-weight: bold;
            color: #333;
            margin-bottom: 2rem;
            opacity: 0;
            animation: fadeInBounce 1s forwards, hideOrderConfirming 0.5s forwards 2.5s;
        }

        .order-confirmed {
            font-size: 3rem;
            font-weight: bold;
            color: #ff4500;
            margin-bottom: 1rem;
            opacity: 0;
            animation: blastAnimation 0.5s forwards 3s;
        }

        .thank-you-msg {
            font-size: 1.5rem;
            color: #333;
            margin-bottom: 2rem;
            opacity: 0;
            animation: fadeInUp 1s forwards 3.5s;
        }

        .confetti {
            position: absolute;
            width: 10px;
            height: 10px;
            background-color: #ff4500;
            opacity: 0;
        }

        @keyframes fadeInBounce {
            0% {
                opacity: 0;
                transform: translateY(30px);
            }
            50% {
                opacity: 1;
                transform: translateY(-10px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes hideOrderConfirming {
            to {
                opacity: 0;
                transform: translateY(-20px);
            }
        }

        @keyframes blastAnimation {
            0% {
                transform: scale(0);
                opacity: 0;
            }
            50% {
                transform: scale(1.2);
                opacity: 1;
            }
            100% {
                transform: scale(1);
                opacity: 1;
            }
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes confettiFall {
            0% {
                transform: translateY(0) rotate(0deg);
                opacity: 1;
            }
            100% {
                transform: translateY(100vh) rotate(720deg);
                opacity: 0;
            }
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
            opacity: 0;
            animation: fadeInUp 1s forwards 4s;
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
            <form action="SearchMenuServlet" method="get">
            <div class="search-bar">
                <input type="text" name="search" placeholder="Search...">
                <button class="search-btn">🔍</button>
            </div>
            </form>
        </div>
    </header>

    <main class="container">
        <div class="thank-you-content">
            <div class="text-animation">Order Confirming...</div>
            <div class="order-confirmed">Order Confirmed!</div>
            <p class="thank-you-msg">Thank You for your order!</p>
            <a href="GetAllRestaurant" class="back-home-btn">Back to Home</a>
        </div>
    </main>

    <footer>
        <div class="container">
            <p>&copy; 2025 Foody. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
