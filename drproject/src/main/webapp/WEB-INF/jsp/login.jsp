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
    <font color="red">${errorMessage}</font>
    <form:form action="/${user.username}/${user.password}" method="post" modelAttribute="user">
        Username :
				<form:label path="username"></form:label>
				<form:input type="text" id="username" path="username"/>
				<form:errors path="username"/>
        		<br>
        Password : 
				<form:label path="password"></form:label>
				<form:input type="text" id="password" path="password"/>
				<form:errors path="password"/>
				<br>
		Name:
				<form:label path="name"></form:label>
				<form:input type="text" id="name" path="name"/>
				<form:errors path="name"/>
        <input type="submit" />	  
    </form:form>
</body>

</html>