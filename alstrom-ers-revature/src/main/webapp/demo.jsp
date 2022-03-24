<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Hello and welcome to jsp</h1>
<%! 
String guestName; %>
	<%
	guestName = request.getParameter("gname");
	for (int i=1;i<=5; i++) {
	%>
	<h1><%= guestName %></h1>
	<%
	}
	%>
	<%out.println("Welcome: " +guestName); %><br/>
	<%= "welcome : "+ guestName %>
	
	<%! 
	int nums;  %>
	
	

	<%
	int num1 = Integer.parseInt(request.getParameter("number1"));
	int num2 = Integer.parseInt(request.getParameter("number2"));
	String operation = request.getParameter("operation");
	int result = 0;
	switch (operation) {
	case "+":
		result = num1 + num2;
		break;
	case "-":
		result = num1 - num2;
		break;
	case "*":
		result = num1 * num2;
		break;
	case "/":
		result = num1 / num2;
		break;
	}
	%>

	<h2><%="Answer: " + result%></h2>




	
</body>
</html>