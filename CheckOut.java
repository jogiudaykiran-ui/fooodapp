package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.foodapp.daoimpl.Order_Items_impl;
import com.foodapp.daoimpl.OrdersImpl;
import com.foodapp.model.CartItems;
import com.foodapp.model.Order_Items;
import com.foodapp.model.Orders;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	
	private Orders order = new Orders();
	private OrdersImpl orderimpl = new OrdersImpl();
	private HttpSession session;
	
	public void insertOrderItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // Retrieve the session object
	    session = req.getSession(false); // Use false to avoid creating a new session if one doesn't exist

	    // Check if the session is null
	    if (session == null) {
	        resp.sendRedirect("errorPage.jsp"); // Redirect to an error page if the session is null
	        return;
	    }

	    int ordersId;

	    // Fetch the list of orders
	    ArrayList<Orders> getorderid = orderimpl.fetchall();

	    // Debugging: Check the fetched orders
	    if (getorderid.isEmpty()) {
	        resp.sendRedirect("errorPage.jsp"); // Redirect to an error page if no orders are found
	        return;
	    }

	    // Debugging: Print all orders fetched
	    for (Orders o : getorderid) {
	        System.out.println("Fetched Order ID: " + o.getOrder_id());
	    }

	    // Get the last order's order_id
	    ordersId = getorderid.get(getorderid.size() - 1).getOrder_id(); // Get the last order as the latest
	    System.out.println("Latest Order ID: " + ordersId);

	    // Ensure session attributes are not null before using them
	    Integer itemId = (Integer) session.getAttribute("ItemId");
	    Integer quantity = (Integer) session.getAttribute("quantity");
	    Integer totalItems = (Integer) session.getAttribute("totalItems");

	    // If any session attribute is null, handle it appropriately
	    if (itemId == null || quantity == null || totalItems == null) {
	        resp.sendRedirect("errorPage.jsp"); // Redirect to an error page
	        return;
	    }

	    System.out.println("Order id: " + ordersId);
	    System.out.println("Item id: " + itemId);
	    System.out.println("Quantity: " + quantity);
	    System.out.println("Total items: " + totalItems);

	    // Insert the order item into the database
	    Order_Items_impl oii = new Order_Items_impl();
	    Order_Items orderItem = new Order_Items(ordersId, itemId, quantity, totalItems);
	    oii.insert(orderItem);

	    // Remove cart from session and set the order in session
	    session.removeAttribute("cart");
	    session.setAttribute("order", order);

	    // Redirect to order confirmation page
	    resp.sendRedirect("OrderConfirmantion.jsp");
	}




    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paymentMethod = req.getParameter("payment-mode");
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        
        if (cart != null && user != null) {
            Orders order = new Orders();
            order.setUser_id(user.getUser_id());
            System.out.println(user.getUser_id());
            order.setRestaurant_id((int) session.getAttribute("Restaurant_id"));;
            System.out.println(session.getAttribute("Restaurant_id"));
            order.setPayment_mode(paymentMethod);
            System.out.println(paymentMethod);
            order.setStatus("pending");
            
            double totalAmount = 0;
            for (CartItems item : cart.getallitems().values()) {
                totalAmount += item.getPrice() * item.getQuantity();
                System.out.println(totalAmount);
            }
            order.setTotal_amount(totalAmount);
            
            
            orderimpl.insert(order);
        } else {
            resp.sendRedirect("home.jsp");
        }
        insertOrderItems(req,resp);
    }
            
           
}


