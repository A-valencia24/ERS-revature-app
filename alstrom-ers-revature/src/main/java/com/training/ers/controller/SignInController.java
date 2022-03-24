package com.training.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import dao.LoginDAO;
import dao.LoginDAOImpl;

/**
 * Servlet implementation class SignInController
 */
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		response.setContentType("text/html");
		out.println("<html><body>");
		
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", uname);
		
		LoginDAO loginDAO = new LoginDAOImpl();
		
		boolean result = loginDAO.validate(uname, pwd);
		
		if(result) {
			session.setAttribute("message","Valid User");
			
			out.println("<h1>Welcome :" +uname);
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.include(request, response);
		}
		else {
			session.setAttribute("message", "Invalid User");
			out.println("<h1> your username/password is incorrect , please <a href=logIn.html>login<a/> again");
		}
		
		
		
		out.println("</html></body>");
	}

}
