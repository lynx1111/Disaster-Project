<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Machine Form</title>
</head>
<body>
<h1>Machine Management</h1>
<c:if test="${machine==null}">
	<table>
		<tr>
			<th>MAchine code: </th>
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
			<th>Max Hour per day: </th>
			<td>
				<input type="submit" value="Save" />
			</td>
		</tr>
	</table>
</c:if>
<c:if test="${machine!=null}">
	<table>
		<tr>
			<th>Machine name: </th>
			<td>
				${machine.id}
				<input type="hidden" name="id" value="${machine.id}"/>
			</td>
		</tr>
		<tr>
			<th>Description: </th>
			<td>
				<input type="text" name="description" value="${machine.description}"/>
			</td>
		</tr>
		<tr>
			<th>Hourly Rate: </th>
			<td>
				<input type="text" name="rate" value="${machine.hourlyrate}"/>
			</td>
		</tr>
		<tr>
			<th>Max Hour per day: </th>
			<td>
				<input type="text" name="maxHour" value="${machine.maxhourperday}"/>
			</td>
		</tr>
		<tr>
			<td>
				<form action="/after_update_machine" method="post">
					<input type="submit" value="Save" />
				</form>
			</td>
		</tr>
	</table>
</c:if>
<c:if test="${machine!=null}">
	<form action="/machines">
		<input type="submit" value="Go back to Machines"/>
	</form>
</c:if>
<br>
<form action="/home">
	<input type="submit" value="Homepage"/>
</form>
</body>
</html>