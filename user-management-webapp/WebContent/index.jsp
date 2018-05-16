<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.rsaladocid.java.examples.usermanagement.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home | User Management</title>
</head>
<body>
	<h1>Bienvenido,
		<%
			User user = (User) session.getAttribute("user");
			out.print(user);
		%>
	</h1>
	<p>
		<img src="<% out.print(user != null && user.getAvatar() == null ? "" : user.getAvatar()); %>" width="100" height="100"></img>
	</p>
	<nav>
		<a href="home">Home</a> |
		<a href="profile">Perfil</a> |
		<a href="logout">Salir</a>
	</nav>
</body>
</html>