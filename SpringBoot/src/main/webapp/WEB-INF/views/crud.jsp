<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<title>Employee Database</title>
</head>
<body style="background-color: #eee">
	<div class="container">
		<nav class="navbar navbar-dark bg-dark fixed-top">
			<div class="container">
				<a href="#" class="navbar-brand">Employee database</a>
			</div>
		</nav>
	</div>
	<div style="margin-top: 80px;"></div>
	<div class="container ">
		
		<div class="card text-center border-secondary">
			<div class="card-header text-white bg-secondary">
				<strong>Employee details</strong>
			</div>
			<div class="card-body">
				<table border="2">
				<tr>
				<td>Employee ID</td>
				<td>Employee Name</td>
				<td>Designation</td>
				<td>Salary</td>
				<td>Action</td>
				</tr>
				<% 
				ArrayList<ArrayList<String>> ar = (ArrayList<ArrayList<String>>)request.getAttribute("ar");
				for(int i=0;i<ar.get(0).size();i++)
				{
%>
<tr>
<td><%=ar.get(0).get(i) %></td>
<td><%=ar.get(1).get(i) %></td>
<td><%=ar.get(2).get(i) %></td>
<td><%=ar.get(3).get(i) %></td>
<td><form:form modelAttribute="delete" action="/delete" method="post"><button type="submit">Delete</button></form:form></td>
</tr>
<%
				}
%>
<tr><td><form:form modelAttribute="add" action="/add" method="post"><button type="submit">Add Employee</button></form:form>
			</div></td></tr>




		</div>

	</div>
	
	<div class="container">
		<nav class="navbar navbar-dark bg-dark fixed-bottom">
			<div class="container">
				<a href="#" class="navbar-brand">CRUD Project
					&copy; 2020</a>
			</div>
		</nav>
	</div>
</body>
</html>