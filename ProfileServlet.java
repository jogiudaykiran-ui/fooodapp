package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.foodapp.daoimpl.UserImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("user");

        if (sessionUser != null) {
            UserImpl userImpl = new UserImpl();
            ArrayList<User> userList = userImpl.fetch(sessionUser);

            if (userList != null && !userList.isEmpty()) {
                User fetchedUser = userList.get(0); // Assuming only one user is returned
                req.setAttribute("profile", fetchedUser);
                req.getRequestDispatcher("profile.jsp").forward(req, resp);
            } else {
                resp.getWriter().write("User not found.");
            }
        } else {
            resp.getWriter().write("No user is logged in.");
        }
    }
}
