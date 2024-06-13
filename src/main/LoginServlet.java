package com.fintech.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Adicione a lógica de autenticação aqui
        if (username.equals("admin") && password.equals("admin")) {
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}