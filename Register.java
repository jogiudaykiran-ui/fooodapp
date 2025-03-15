package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.daoimpl.UserImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password=req.getParameter("user_password");
		if(password.equals(req.getParameter("rewritepassword"))) {
			String user_name=req.getParameter("user_name");
			String email=req.getParameter("user_email");
			String adress=req.getParameter("adress");
			
			UserImpl Userimpl=new UserImpl();
			 Userimpl.insert(new User(user_name,password,email,adress));
			 
			 resp.sendRedirect("Login.html");
		}
		else {
			resp.sendRedirect("passwordmishmatch.jsp");
		}
	}
}
