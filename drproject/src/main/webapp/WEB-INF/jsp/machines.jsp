<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Machines</title>
<style>
	html, body{
	height:100%;
	text-align:center;
	}
	.add{
	float:center;
	font-size: 24px;
	}
	th, td{
	font-size: 24px
	}
</style>
</head>
<body>

<font size="30">List of Machines:</font>
<br>
<br>
<div class="add">
	<a href="/create_machine">Add new machine</a>
</div>
<br>
<br>
<table>
	<tr bgcolor="black" style="color:white"> 
		<th>Machine code</th>
		<th>Description</th>
		<th>Hourly Rate</th>
		<th>Max Hours per day</th>
	</tr>
	<c:forEach items="${machines}" var="machine">
		<tr>
			<td>${machine.id}</td>
			<td>${machine.description}</td>
			<td>${machine.hourlyrate}</td>
			<td>${machine.maxhourperday}</td>
			<td><a href="/edit_machine/${machine.id}">Edit</a></td>
			<td><a href="/delete_machine?id=<c:out value='${machine.id}'/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<form action="/home">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>