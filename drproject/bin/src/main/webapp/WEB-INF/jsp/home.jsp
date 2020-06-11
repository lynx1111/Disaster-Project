<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
	html, body{
	height:100%;
	}
	.leftNavbar{
	float:left;
	height:100%;
	}
</style>

<meta charset="ISO-8859-1">
<title>Disaster Recovery page</title>
</head>
<body>

<div class="upperHeader">
	<h2>Disaster Recovery Application: Time card Submission</h2>
</div>
<c:if test="${name=='duck'}">
	You are goose hehe
</c:if>
<div>
	<h2>Hi ${name}</h2>
</div>

<div class="leftNavbar">
<table>
	<tr>
		<td>
			<ul>
				<li><a href="/jobs">Job code Management</a></li>
				<li><a href="/machines">Machine Management</a></li>
				<li><a href="/timesheets">Timecard Approval</a></li>
			</ul>
		</td>
	</tr>
</table>
</div>

<div>

</div>
</body>
</html>