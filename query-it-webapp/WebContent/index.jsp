<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.rsaladocid.java.examples.queryit.entities.Item"%>
<%@ page import="java.util.List"%>
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
		<% if (request.getAttribute("items") != null) { %>
			<div>
				<span><% out.print(((List<Item>) request.getAttribute("items")).size()); %> items found</span>
			</div>
			<% for (int i = 0; i < ((List<Item>) request.getAttribute("items")).size(); i++) {
				Item item = ((List<Item>) request.getAttribute("items")).get(i);
			%>
				<p>
					<ul>
						<li>[<% out.print(item.getType().toUpperCase()); %>] <a href="<% out.print("item?sn=" + item.getServiceName() + "&id=" + item.getId()); %>"><% out.print(item.getName()); %></a></li>
					</ul>
				</p>
			<% } %>
		<% } %>
	</div>
</body>
</html>