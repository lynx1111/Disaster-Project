<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobs</title>
</head>
<body>

Timesheets:
<br>
<table>
	<tr>
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
		</tr>
	</c:forEach>
</table>
<form action="/home">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>