package com.fintech.servlets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/transactions3")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 List<Transaction> transactions = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setAttribute("transactions", transactions);
        req.getRequestDispatcher("transactions.jsp").forward(req, resp);
       
        resp.sendRedirect("index.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String amountStr = req.getParameter("amount");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String type = req.getParameter("type");

        int amount = 0;
        try {
            amount = Integer.parseInt(amountStr);
        } catch (NumberFormatException e) {
            // Handle error
        }

        Transaction transaction = new Transaction(amount, date, time, name, type);
        transactions.add(transaction);

        resp.sendRedirect("transactions");
    }
}