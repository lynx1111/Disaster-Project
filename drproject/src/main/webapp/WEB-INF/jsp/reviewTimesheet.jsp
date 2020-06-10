<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reviewing timesheet</title>
</head>
<body>
<form:form action="/submit_approval/${timesheet.id}" modelAttribute="timesheet" method="post">
	<p>Would you like to approve the following timesheet?</p>
	<form:radiobuttons path="s" items="${timesheet.statusOptions}"/>
	<table>
	<tr bgcolor="black" style="color:white">
		<th>Site code</th>
		<th>Name</th>
		<th>Hours</th>
		<th>Total Pay</th>
	</tr>
	<tr>
		<td>${timesheet.siteCode}</td>
		<td>${timesheet.name}</td>
		<td>${timesheet.hours}</td>
		<td>${timesheet.totalpay}</td>
	</tr>
	</table>
	<input type="submit" value="Save" />
</form:form>
</body>
</html>