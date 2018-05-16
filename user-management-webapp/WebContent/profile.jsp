<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.rsaladocid.java.examples.usermanagement.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil | User Management</title>
</head>
<body>
	<nav>
		<a href="home">Home</a> |
		<a href="profile">Perfil</a> |
		<a href="logout">Salir</a>
	</nav>
	<br>
	<form method="post" action="profile">
		<%
			User user = (User) session.getAttribute("user");
		%>
		<p>
			<label for="email">Email:</label><br>
			<input id="email" type="text" name="email" value="<% out.print(user.getMail()); %>" readonly /><br>
		</p>
		<p>
			<label for="username">Nombre de usuario:</label><br>
			<input id="username" type="text" name="username" value="<% out.print(user.getUsername() == null ? "" : user.getUsername()); %>" /><br>
		</p>
		<p>
			<label for="name">Nombre real:</label><br>
			<input id="name" type="text" name="name" value="<% out.print(user.getName() == null ? "" : user.getName()); %>" /><br>
		</p>
		<p>
			<label for="bio">Sobre ti:</label><br>
			<textarea id="bio" name="bio" rows="5" cols="50"><% out.print(user.getBio() == null ? "" : user.getBio()); %></textarea><br>
		</p>
		<p>
			<label for="avatar">Avatar (100x100):</label><br>
			<input id="avatar" type="text" name="avatar" value="<% out.print(user.getAvatar() == null ? "" : user.getAvatar()); %>" /><br>
		</p>
		<p>
			<label for="site">Sitio personal:</label><br>
			<input id="site" type="text" name="site" value="<% out.print(user.getSite() == null ? "" : user.getSite()); %>" /><br>
		</p>
		<p></p>
		<input type="submit" value="Modificar" />
	</form>
	<p>
		<a href="delete">Eliminar</a>
	</p>
</body>
</html>