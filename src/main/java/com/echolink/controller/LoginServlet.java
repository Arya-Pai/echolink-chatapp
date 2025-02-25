package com.echolink.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.echolink.dao.UserDAO;
import com.echolink.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		UserDAO dao=new UserDAO();
		HttpSession session=req.getSession();
		try {
			boolean present=dao.validate(email, password);
			if(present) {
				User user=dao.getUserByEmailAndPassword(email, password);
				String username=user.getUsername();
				long id=user.getId();
				session.setAttribute("username",String.valueOf(username));
				session.setAttribute("id", String.valueOf(id));
				session.setAttribute("userEmail","email");
				res.sendRedirect("index.jsp");
			}else {
				session.setAttribute("fail","Check email or password, if not registered , then register first");
				res.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			String message=e.getMessage();
			session.setAttribute("errorMessage","message");
			res.sendRedirect("Error.jsp");
		}
	}
}
