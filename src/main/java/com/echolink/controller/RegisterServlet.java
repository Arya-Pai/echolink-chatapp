package com.echolink.controller;

import java.io.IOException;

import com.echolink.dao.UserDAO;
import com.echolink.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/RegistrationPage")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user=new User(username, email, password);
        HttpSession session=req.getSession();
        UserDAO dao=new UserDAO();
        try {
            boolean isRegistered = dao.register(user);
            if (isRegistered) {
                session.setAttribute("successfulRegistrationMessage", "Registration is successful! You can log in now!");
                res.sendRedirect("login.jsp");
            } else {
                session.setAttribute("failureRegistrationMessage", "Registration failed! Please try again.");
                res.sendRedirect("register.jsp"); // Redirect to the registration form
            }
        } catch (Exception e) {
            session.setAttribute("failureRegistrationMessage", "An error occurred! Please try again.");
            res.sendRedirect("register.jsp");
        }
    }
}

