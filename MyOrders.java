package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.foodapp.daoimpl.Order_Items_impl;
import com.foodapp.daoimpl.OrdersImpl;
import com.foodapp.model.Order_Items;
import com.foodapp.model.Orders;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyOrders")
public class MyOrders extends HttpServlet {
    private OrdersImpl orderImpl = new OrdersImpl();
    private Order_Items_impl orderItemsImpl = new Order_Items_impl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.jsp");  // Redirect to login if session doesn't exist
            return;
        }

        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login.jsp");  // Redirect to login if user is not logged in
            return;
        }
        int u=user.getUser_id();
        // Fetch orders for the specific user
        ArrayList<Orders> userOrderHistory = orderImpl.fetch(u); // Fetch orders by user ID

        // Fetch order items for each order
      
            ArrayList<Order_Items> orderItems = orderItemsImpl.fetch(new Order_Items(userOrderHistory.get(0).getOrder_id(), 0, 0, 0, 0)); // Fetch items for the current order
            userOrderHistory.get(0).setOrderItems(orderItems); // Set the order items in the order object
        

        // Set the orders in the request scope
        req.setAttribute("orderHistory", userOrderHistory);

        // Forward to the order history JSP page
        req.getRequestDispatcher("orderHistory.jsp").forward(req, resp);
    }
}
