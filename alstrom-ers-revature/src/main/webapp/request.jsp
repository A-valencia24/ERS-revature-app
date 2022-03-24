<%@page import="java.util.Iterator"%>
<%@page import="dao.LoginDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.LoginDAOImpl"%>
<%@page import="com.training.ers.model.User"%>
<%@page import="com.training.ers.model.Reimbursements"%>
<%@page import="com.training.ers.model.manager"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="styles.css">
</head>
<h1>Place a new request here:</h1>

<%
String username = (String) session.getAttribute("username");
String purpose = (String) session.getAttribute("purpose");
Float amount = (float) session.getAttribute("amount");
%>
<h2>
	You are logged in as :
	<%=username%>
	and the message is :
	<%=session.getAttribute("message")%></h2>
<body>
	<%
	LoginDAO loginDAO = new LoginDAOImpl();
	List<User> users = loginDAO.getUsers();
	Iterator<User> iterator = users.iterator();
	%>
	<h1>request details</h1>
	<table border="2" cellspacing="10" cellpadding="10">
		<th>User Id</th>
		<th>User Name</th>
		<th>purpose</th>
		<th>amount</th><
		
		<%
		
		%>
		<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=user.getGender()%></td>
			<td><%=user.getNotifications()%></td>
			<td><%=user.getQualification()%></td>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>l>