<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobs</title>
</head>
<body>

List of Machines:
<br>
<table>
	<tr>
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
		</tr>
	</c:forEach>
</table>
<form action="/">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>