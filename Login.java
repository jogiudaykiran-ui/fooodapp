package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.foodapp.dao.UserInterface;
import com.foodapp.daoimpl.UserImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String htmlpassword = req.getParameter("password");
        
        User u = new User();
        u.setEmail(email);
        
        UserInterface userimpl = new UserImpl();
        ArrayList<User> list = userimpl.fetch(u);
        
        if (list.isEmpty()) {
            resp.sendRedirect("usernotfound.html");
        } else {
            User databaseUser = list.get(0);
            if (databaseUser.getPassword().equals(htmlpassword)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", databaseUser);
                req.getRequestDispatcher("GetAllRestaurant").forward(req, resp);
            } else {
                resp.sendRedirect("WrongPassword.html");
            }
        }
    }
}
