package com.training.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.ers.model.Reimbursements;
import com.training.ers.model.User;

import dao.LoginDAO;
import dao.LoginDAOImpl;

/**
 * Servlet implementation class requests
 */
public class RequestsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String purpose = request.getParameter("purpose");
		String status = request.getParameter("status");
		float amount = request.getParameterValues(amount);
		
		Reimbursements reimbursements = new Reimbursements( username, status, purpose, amount);
		LoginDAO loginDAO = new LoginDAOImpl();
		loginDAO.newRequest(username,purpose,amount);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><body>");
		out.println("Welcome : " + username);
		out.println("you have requested a reimbursement equaled to : " + amount);
		out.println("<h1><a href=logIn.html>Login</a>");
	

		out.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
