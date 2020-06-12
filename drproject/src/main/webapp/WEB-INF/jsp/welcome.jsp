<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jspf"%>
<%@ include file="navigation/homena.jspf"%>

<head>
<<<<<<< HEAD
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
	body{
	text-align: center;
	font-size: 24px;
	}
</style>
=======
<meta charset="UTF-8">
 
<title>welcome</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
>>>>>>> 2ac1101c6967aff6e92c2d1889c07810b025124d
</head>

<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">Home Page</div>
		<div class="panel-body">
			Welcome <a href="/login">Click here</a> to login
			<br>
			If you are a new user please create a user with: <a href="/register">Register</a>
		</div>
	</div>
</div>

<%@ include file="footer.jspf"%>