package com.fintech.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register2")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    

        // Adicione a lógica de registro aqui
        resp.sendRedirect("login.jsp");
    }
} 
