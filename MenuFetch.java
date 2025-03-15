package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.daoimpl.MenuImpl;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MenuFetch")
public class MenuFetch extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Get the restaurant ID from the request
            int id = Integer.parseInt(req.getParameter("Restaurant_id"));

            // Set the Restaurant_id in the session
            HttpSession session = req.getSession();
            session.setAttribute("Restaurant_id", id);  // Added this line

            // Instantiate DAO to fetch menu items by restaurant ID
            MenuImpl menuDao = new MenuImpl();
            List<Menu> menuList = menuDao.fetchMenuByRestaurant(id);

            // Check if the menu list is available and forward to JSP accordingly
            if (menuList != null && !menuList.isEmpty()) {
                req.setAttribute("menulist", menuList);
            } else {
                // No menu items available for this restaurant
                req.setAttribute("errorMessage", "No menu items available for this restaurant.");
            }

            // Forward to the menu JSP page
            req.getRequestDispatcher("/Menu.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            // Invalid restaurant ID provided
            req.setAttribute("errorMessage", "Invalid restaurant ID provided.");
            req.getRequestDispatcher("/Menu.jsp").forward(req, resp);
        } catch (Exception e) {
            // Generic error handling
            e.printStackTrace();
            req.setAttribute("errorMessage", "An error occurred while fetching menu data.");
            req.getRequestDispatcher("/Menu.jsp").forward(req, resp);
        }
    }
}
