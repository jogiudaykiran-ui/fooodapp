package com.foodapp.controller;

import java.awt.MenuItem;
import java.io.IOException;
import java.util.List;

import com.foodapp.daoimpl.MenuImpl;
import com.foodapp.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchMenuServlet")
public class SearchMenuServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchQuery = request.getParameter("search");  // Get the search query from the URL parameter
		System.out.println(searchQuery);
		// Fetch the menu items matching the search query from the database
		MenuImpl menuItemDAO = new MenuImpl();
		System.out.println("menuDao");
		System.out.println(menuItemDAO.searchMenu(searchQuery));
		List<Menu> menuItems = menuItemDAO.searchMenu(searchQuery);
		System.out.println("servlet :  "+menuItems);
		if (menuItems == null || menuItems.isEmpty()) {
		    response.sendRedirect("NoItemsFound.jsp");
		    System.out.println("Empty");
		    return;
		}
		int Restaurantid=menuItems.get(0).getRestaurant_id();
		request.setAttribute("Restaurant_id",Restaurantid);

		// Set the search results as an attribute for the JSP page
		request.setAttribute("menuItems", menuItems);

		// Forward the request to the search result JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchResults.jsp");
		dispatcher.forward(request, response);
	}
}
