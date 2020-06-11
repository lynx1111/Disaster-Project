<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>
	td{
	font-size: 24px
	}
	body{
	text-align: center;
	}
	table{
	margin-left:auto; 
    margin-right:auto;
	}
</style>
</head>
<body>
<form:form action="/create_user" modelAttribute="user" method="post">
	<table>
		<tr>
			<td>Username</td>
			<td>
			<form:label path="username"></form:label>
				<form:input type="text" id="username" path="username"/>
				<form:errors path="username"/>
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>
			<form:label path="password"></form:label>
				<form:input type="password" id="password" path="password"/>
				<form:errors path="password"/>
			</td>
		</tr>
		<tr>
			<td>Full name</td>
			<td>
			<form:label path="name"></form:label>
				<form:input type="text" id="name" path="name"/>
				<form:errors path="name"/>
			</td>
		</tr>
		<tr>
			<form:select path="role">
				<form:option value="NONE" label="--- Select ---"/>
				<form:options items="${roles}"/>
			</form:select>
		</tr>
	</table>
	<input type="submit" value="Save" />
</form:form>
</body>
</html>