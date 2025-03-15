<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Mismatch</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Roboto', sans-serif;
            background-image: url('https://images.unsplash.com/photo-1504674900247-0877df9cc836?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        body::before {
            content: "";
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: inherit;
            filter: blur(8px);
            z-index: -1;
        }

        .container {
            width: 600px;
            height: 350px;
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .frontbox {
            background-color: white;
            border-radius: 20px;
            height: 100%;
            width: 50%;
            z-index: 10;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 20px;
            box-sizing: border-box;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #ff4d4f;
            text-align: center;
            margin-top: 0;
            margin-bottom: 20px;
        }

        p {
            color: #404040;
            font-size: 15px;
            text-align: center;
            margin-bottom: 20px;
        }

        button {
            background-color: #35B729;
            border: none;
            color: white;
            font-size: 12px;
            font-weight: 300;
            padding: 10px;
            border-radius: 10px;
            width: 120px;
            cursor: pointer;
        }

        button a {
            color: white;
            text-decoration: none;
        }

        button:hover {
            background-color: #2c8e24;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="frontbox">
            <h2>Password Mismatch</h2>
            <p>Please enter your password correctly to proceed.</p>
            <button><a href="SignUp.html">Retry Sign Up</a></button>
        </div>
    </div>
</body>
</html>