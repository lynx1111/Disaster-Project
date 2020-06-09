<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Timesheet Form</title>
</head>
<body>
<h1>Timesheet Management</h1>
<c:if test="${timesheet==null}">
	<table>
		<tr>
			<th>Site code: </th>
			<td>
				<input type="text" name="id"/>
			</td>
		</tr>
		<tr>
			<th>Name: </th>
			<td>
				<input type="text" name="name"/>
			</td>
		</tr>
		<tr>
			<th>Hours: </th>
			<td>
				<input type="text" name="hours"/>
			</td>
		</tr>
		<tr>
			<th>Total pay: </th>
			<td>
				<input type="text" name="pay"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Save" />
			</td>
		</tr>
	</table>
</c:if>
<c:if test="${timesheet!=null}">
	<table>
		<tr>
			<th>Site code: </th>
			<td>
				${timesheet.siteCode}
				<input type="hidden" name="id" value="${timesheet.siteCode}"/>
			</td>
		</tr>
		<tr>
			<th>Name: </th>
			<td>
				<input type="text" name="name" value="${timesheet.name}"/>
			</td>
		</tr>
		<tr>
			<th>Hours: </th>
			<td>
				<input type="text" name="hours" value="${timesheet.hours}"/>
			</td>
		</tr>
		<tr>
			<th>Total pay: </th>
			<td>
				<input type="text" name="maxHour" value="${timesheet.totalpay}"/>
			</td>
		</tr>
		<tr>
			<td>
				<form action="/after_update_timesheet" method="post">
					<input type="submit" value="Save" />
				</form>
			</td>
		</tr>
	</table>
</c:if>
<c:if test="${timesheet!=null}">
	<form action="/timesheets">
		<input type="submit" value="Go back to Timesheets"/>
	</form>
</c:if>
<br>
<form action="/home">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>