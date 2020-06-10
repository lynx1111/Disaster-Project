<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobs</title>
<style>
	html, body{
	height:100%;
	}
	.add{
	float:center;
	font-size: 24px;
	}
	th, td{
	font-size: 24px;
	}
</style>
</head>
<body>

<font size="30">List of Jobs:</font>
<br>
<div class="add">
	<a href="/create">Add new job</a>
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
			<td><a href="/edit_job/${job.id}">Edit</a></td>
			<td><a href="/delete_job?id=<c:out value='${job.id}'/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<form action="/home">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>