package com.foodapp.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ContinueShoppingServlet")
public class ContinueShoppingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Retrieve the last visited menu page URL from the session
        String lastMenuPage = (String) session.getAttribute("lastMenuPage");
        
        if (lastMenuPage != null && !lastMenuPage.isEmpty()) {
            // Redirect to the last visited menu page
            response.sendRedirect(lastMenuPage);
        } else {
            // If no last menu page is stored, redirect to a default menu page
            response.sendRedirect("FetchAllMenu");
        }
    }
}

