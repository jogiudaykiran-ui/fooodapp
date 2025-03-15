package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.daoimpl.UserImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/forgetServlet")
public class forgetServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword=req.getParameter("repassword");
        
        if(password.equals(rePassword)) {
        	UserImpl userimpl=new UserImpl();
        	userimpl.update(password, email);
        	resp.sendRedirect("passwordChange.html");
        }
        else {
        	resp.sendRedirect("passwordmishmatch.jsp");
        }
	}
	
}
