package com.training.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.ers.model.User;

import dao.LoginDAO;
import dao.LoginDAOImpl;

/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String notification[] = request.getParameterValues("notification");
		String qualification = request.getParameter("qualification");
		String finalNotification = "";
		for (String temp : notification) {
			finalNotification += temp + ":"; // Email:SMS:Courier
		}
		User user = new User(-1, username, password, gender, finalNotification, qualification);
		LoginDAO loginDAO = new LoginDAOImpl();
		loginDAO.register(user);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><body>");
		out.println("Welcome : " + username);
		out.println("you are registered successfully and your password is : " + password);
		out.println("<h1><a href=logIn.html>Login</a>");
	

		out.println("</html></body>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
