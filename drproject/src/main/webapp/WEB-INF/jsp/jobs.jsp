<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobs</title>
</head>
<body>

List of Jobs:
<br>
<table>
	<tr>
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
			<td><a href="/update_job?id=<c:out value='${job.id}'/>">Edit</a></td>
			<td><a href="/delete_job?id=<c:out value='${job.id}'/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<form action="/home">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>