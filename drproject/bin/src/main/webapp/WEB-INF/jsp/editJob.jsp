<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Form</title>
</head>
<body>
<h1>Job Management</h1>
<form:form action="/update_job/${job.id}" modelAttribute="job" method="post">
	<table>
		<tr>
			<th>Job name: </th>
			<td>
				${job.id}
				<form:input type="hidden" path="id" id="id" value="${job.id}"/>
			</td>
		</tr>
		<tr>
			<th>Description: </th>
			<td>
				<form:label path="description"></form:label>
				<form:input type="text" id="description" path="description" value="${job.description}"/>
				<form:errors path="description"/>
			</td>
		</tr>
		<tr>
			<th>Hourly Rate: </th>
			<td>
				<form:label path="hourlyrate"></form:label>
				<form:input type="text" id="hourlyrate" path="hourlyrate" value="${job.hourlyrate}"/>
				<form:errors path="hourlyrate"/>
			</td>
		</tr>
		<tr>
			<th>Max Hour per day: </th>
			<td>
				<form:label path="maxhourperday"></form:label>
				<form:input type="text" id="maxhourperday" path="maxhourperday" value="${job.maxhourperday}"/>
				<form:errors path="maxhourperday"/>
			</td>
		</tr>
		<tr>
			<td>
					<input type="submit" value="Save" />	
			</td>
		</tr>
	</table>
	</form:form>
<form action="/jobs">
	<input type="submit" value="Go back to Jobs"/>
</form>

<form action="/home">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>
