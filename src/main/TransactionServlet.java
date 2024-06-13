package com.fintech.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String amount = req.getParameter("amount");
        String type = req.getParameter("type");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        List<Transaction> transactions = new ArrayList<>();
        
       
        transactions.add(new Transaction(12000, "13/04/2024", "12:00"));
        transactions.add(new Transaction(-59, "10/04/2024", "14:00"));
        transactions.add(new Transaction(-1200, "27/03/2024", "09:00"));
        transactions.add(new Transaction(5400, "15/03/2024", "11:00"));
        
      
        req.setAttribute("transactions", transactions);
        
        
        req.getRequestDispatcher("transactions.jsp").forward(req, resp);

      

        resp.sendRedirect("index.jsp");
    }
}