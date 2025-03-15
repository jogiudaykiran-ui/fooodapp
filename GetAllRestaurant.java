package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.foodapp.daoimpl.RestaurentImpl;
import com.foodapp.model.Restaurent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GetAllRestaurant")
public class GetAllRestaurant extends HttpServlet {

    private ArrayList<Restaurent> restaurentList;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RestaurentImpl restaurentImpl = new RestaurentImpl();
        restaurentList = restaurentImpl.fetchall();
        
        HttpSession session = req.getSession();
        session.setAttribute("restaurentList", restaurentList); 
        session.getAttribute("user");

        resp.sendRedirect("home.jsp");
    }
}
