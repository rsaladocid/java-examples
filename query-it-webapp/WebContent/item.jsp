<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.rsaladocid.java.examples.queryit.entities.Item"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Query it! - Find information about anything</title>
</head>
<body>
	<h1>Query it!</h1>
	<h2>Find information about anything</h2>
	<form method="get" action="search">
		<input type="text" name="query" value="<% out.print(request.getParameter("query") != null ? request.getParameter("query") : ""); %>"><button type="submit">Submit</button>
	</form>
	<div>
		<% if (request.getAttribute("item") != null) {
			Item item = (Item) request.getAttribute("item");
		%>
			<p>
				<h3><% out.print(item.getName()); %></h3>
				<img src="<% out.print(item.getImage()); %>" height="200" />
				<h4>Summary:</h4>
				<p>
					<% if (item.getDescription() != null) { %>
						<% out.print(item.getDescription()); %>
					<% } %>
				</p>
				<h4>Type:</h4>
				<p>
					<% out.print(item.getType().toUpperCase()); %>
				</p>
			</p>
		<% } %>
	</div>
</body>
</html>