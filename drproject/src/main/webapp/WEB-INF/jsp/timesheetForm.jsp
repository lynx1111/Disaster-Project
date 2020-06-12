<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jspf"%>
<%@ include file="navigation/timesheetna.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Timesheet Form</title>
<style>
	th, td{
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
<font class="time" size="30">Timesheet Submission</font>
<form:form action="/add_ts" modelAttribute="timesheet" method="POST">
<table>
	<tr>
		<th>Site code: </th>
		<td>
			<form:label path="siteCode"></form:label>
			<form:input type="text" id="siteCode" path="siteCode"/>
			<form:errors path="siteCode"/>
		</td>
	</tr>
	<tr>
		<th>Contractor Name: </th>
		<td>
			<form:label path="name"></form:label>
			<form:input type="text" id="name" path="name"/>
			<form:errors path="name"/>
		</td>
	</tr>
	<tr>
		<th>Hours: </th>
		<td>
			<form:label path="hours"></form:label>
			<form:input type="text" id="hours" path="hours"/>
			<form:errors path="hours"/>
		</td>
	</tr>
	<tr>
		<th>Total pay: </th>
		<td>
			<form:label path="totalpay"></form:label>
			<form:input type="text" id="totalpay" path="totalpay"/>
			<form:errors path="totalpay"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="Save" />
		</td>
	</tr>
</table>
</form:form>
<br>
</body>
</html>
<%@ include file="footer.jspf"%>