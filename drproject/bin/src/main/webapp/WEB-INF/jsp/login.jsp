<<<<<<< HEAD
<center>
<h1>Welcome to Spring Boot Security</h1>

<form method="POST" action="/login">
	User Name : <input type="text" name="username" value="user"/><br><br>
	Password  : <input type="password" name="password" value="password"/><br><br>
	<input type="submit" name="submit"/>
</form>
</center>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>Login page</title>
</head>

<body>
	<font color="green">${success}</font>
    <font color="red">${errorMessage}</font>
    <form:form action="/" method="post" modelAttribute="user">
        Username :
				<form:label path="username"></form:label>
				<form:input type="text" id="username" path="username"/>
				<form:errors path="username"/>
        		<br>
        Password : 
				<form:label path="password"></form:label>
				<form:input type="password" id="password" path="password"/>
				<form:errors path="password"/>
				<br>
        <input type="submit" />	  
    </form:form>
</body>

</html>
>>>>>>> refs/heads/Patrick
