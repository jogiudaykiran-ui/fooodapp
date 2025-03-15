package com.foodapp.controller;

import java.io.IOException;
import com.foodapp.daoimpl.MenuImpl;
import com.foodapp.model.CartItems;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	
	    @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        HttpSession session = req.getSession();
	        Cart cart = (Cart) session.getAttribute("cart");

	        // If the cart is null, create a new cart
	        if (cart == null) {
	            cart = new Cart();
	            session.setAttribute("cart", cart);
	        }

	        String action = req.getParameter("action");
	        int itemId = Integer.parseInt(req.getParameter("ItemId"));

	        MenuImpl menuimpl = null;
	        try {
	            menuimpl = new MenuImpl();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        try {
	            if ("add".equals(action)) {
	                // Add item to the cart
	                Menu menuItem = menuimpl.fetch(itemId);
	                if (menuItem != null) {
	                    int quantity = 1;  // Default quantity
	                    CartItems cartItem = new CartItems(menuItem.getMenu_id(), menuItem.getRestaurant_id(), menuItem.getName(), menuItem.getPrice(), quantity);
	                    cart.addItems(cartItem);
	                    
	                    // Set session attributes for checkout
	                    session.setAttribute("ItemId", itemId);
	                    session.setAttribute("quantity", quantity);
	                }
	            } else if ("update".equals(action)) {
	                // Update item quantity
	                int quantity = Integer.parseInt(req.getParameter("quantity"));
	                CartItems cartItem = cart.getItem(itemId);
	                if (cartItem != null) {
	                    // Update the quantity of the item
	                    cartItem.setQuantity(quantity);
	                    
	                    // Set session attributes for checkout
	                    session.setAttribute("ItemId", itemId);
	                    session.setAttribute("quantity", quantity);
	                }
	            } else if ("removeitem".equals(action)) {
	                // Remove item from the cart
	                cart.removeitem(itemId);
	                
	                // Set session attributes for checkout (optional, if needed)
	                session.setAttribute("ItemId", itemId);
	                session.setAttribute("quantity", 0); // Assuming 0 for removed item
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // Calculate total number of items in the cart
	        int totalItems = 0;
	        for (CartItems item : cart.getallitems().values()) {
	            totalItems += item.getQuantity();
	        }

	        // Store total items in session
	        session.setAttribute("totalItems", totalItems);

	        // Store updated cart in session
	        session.setAttribute("cart", cart);

	        // Redirect to CartItem.jsp
	        resp.sendRedirect("CartItem.jsp");
	    }
	}


