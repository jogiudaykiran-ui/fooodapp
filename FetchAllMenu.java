package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.foodapp.daoimpl.MenuImpl;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/FetchAllMenu")
public class FetchAllMenu extends HttpServlet {
	
	private ArrayList<Menu> MenuList;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuImpl menuImpl = new MenuImpl();
        MenuList = menuImpl.fetchAll();
        
        HttpSession session = req.getSession();
        session.setAttribute("MenuList", MenuList); 

        resp.sendRedirect("MenuFetchAll.jsp");
	}

}
