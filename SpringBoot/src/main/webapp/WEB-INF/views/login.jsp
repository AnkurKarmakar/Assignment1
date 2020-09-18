<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>CRUD Project</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body style="background-color: #eee;">
	<div class="container">
		<nav class="navbar navbar-dark navbar-expand-sm bg-dark fixed-top">
			<div class="container">
				<a href="#" class="navbar-brand">CRUD Project</a>
			</div>
		</nav>
	</div>
	<div style="margin-top: 80px;"></div>
	<div class="container ">
		<form:form modelAttribute="login" action="/login" method="post">
			<div class="form-group ">
				<form:label path="username" for="username">USER NAME</form:label>
				<form:input path="username" name="username" id="username" class="form-control"
					placeholder="Enter Your Username"/>
			</div>
			<div class="form-group">
				<form:label path="password" for="password">PASSWORD</form:label>
				<form:input path="password" name="password" id="password"
					class="form-control" placeholder="Enter Your Password"/>
			</div>
			<div class="form-row">
				<div class="col">
					<button type="submit" class="btn btn-success btn-block">LOGIN</button>
				</div>
				<div class="col">
					<button type="reset" class="btn btn-warning btn-block">RESET</button>
				</div>
			</div>
			
		</form:form>
	</div>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark fixed-bottom">
			<div class="container">
				<a href="#" class="navbar-brand">CRUD Project &copy;
					2020</a>
			</div>
		</nav>
	</div>
</body>
</html>