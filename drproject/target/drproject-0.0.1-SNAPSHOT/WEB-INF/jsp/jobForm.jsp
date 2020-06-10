<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Form</title>
</head>
<body>
<h1>Job Management</h1>
<%-- <c:if test="${job==null}"> --%>
<form action="/add1" method="post">
	<table>
		<tr>
			<th>Job name: </th>
			<td>
				<input type="text" name="id"/>
			</td>
		</tr>
		<tr>
			<th>Description: </th>
			<td>
				<input type="text" name="description"/>
			</td>
		</tr>
		<tr>
			<th>Hourly Rate: </th>
			<td>
				<input type="text" name="rate"/>
			</td>
		</tr>
		<tr>
			<th>Max Hour per day: </th>
			<td>
				<input type="text" name="maxHour"/>
			</td>
		</tr>
		<tr>
			<td>
				
					<input type="submit" value="Save" />
				
			</td>
		</tr>
	</table>
	</form>
<%-- </c:if> --%>
<c:if test="${job!=null}">
<form action="/after_update_job" method="post">
	<table>
		<tr>
			<th>Job name: </th>
			<td>
				${job.id}
				<input type="hidden" name="id" value="${job.id}"/>
			</td>
		</tr>
		<tr>
			<th>Description: </th>
			<td>
				<input type="text" name="description" value="${job.description}"/>
			</td>
		</tr>
		<tr>
			<th>Hourly Rate: </th>
			<td>
				<input type="text" name="rate" value="${job.hourlyrate}"/>
			</td>
		</tr>
		<tr>
			<th>Max Hour per day: </th>
			<td>
				<input type="text" name="maxHour" value="${job.maxhourperday}"/>
			</td>
		</tr>
		<tr>
			<td>
				
					<input type="submit" value="Save" />
				
			</td>
		</tr>
	</table>
	</form>
</c:if>
<c:if test="${job!=null}">
	<form action="/jobs">
		<input type="submit" value="Go back to Jobs"/>
	</form>
</c:if>
<br>
<form action="/home">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>