<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Timesheets</title>
<style>
	th, td{
	font-size: 24px
	}
	body{
	text-align: center;
	}
</style>
</head>
<body>
<font size="30">Timesheets:</font>
<br>
<table>
	<tr bgcolor="black" style="color:white">
		<th>Site code</th>
		<th>Name</th>
		<th>Hours</th>
		<th>Total Pay</th>
	</tr>
	<c:forEach items="${timesheets}" var="timesheet">
		<tr>
			<td>${timesheet.siteCode}</td>
			<td>${timesheet.name}</td>
			<td>${timesheet.hours}</td>
			<td>${timesheet.totalpay}</td>
			<td>
			<c:if test="${timesheet.status eq false}">
				<a href="/review/${timesheet.id}">Review</a>
			</c:if>
			<c:if test="${timesheet.status eq true}">
				Finalized
			</c:if>
		</tr>
	</c:forEach>
</table>
<form action="/home">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>