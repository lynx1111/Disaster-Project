<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ include file="header.jspf"%>
<%@ include file="navigation/adminna.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobs</title>
<style>
	html, body{
	height:100%;
	text-align: center;
	}
	.add{
	float:center;
	font-size: 24px;
	}
	th, td{
	font-size: 24px;
	}
	table{
	margin-left:auto; 
    margin-right:auto;
	}
</style>
</head>
<body>

<font size="30">List of Jobs:</font>
<br>
<div class="add">
	<a href="/job/create">Add new job</a>
</div>
<br>
<table>
	<tr bgcolor="black" style="color:white">
		<th>Job code</th>
		<th>Description</th>
		<th>Hourly Rate</th>
		<th>Max Hours per day</th>
	</tr>
	<c:forEach items="${jobs}" var="job">
		<tr>
			<td>${job.id}</td>
			<td>${job.description}</td>
			<td>${job.hourlyrate}</td>
			<td>${job.maxhourperday}</td>
			<td><a href="/job/edit_job/${job.id}">Edit</a></td>
			<td><a href="/job/delete_job?id=<c:out value='${job.id}'/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<form action="/home">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>
<%@ include file="footer.jspf"%>