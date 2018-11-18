<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All users</title>
</head>
<body>
<a href="/Warsztaty__6/user/add">Add user</a><br>
	  <a href="/Warsztaty__6/user/all">All users</a><br>
	<h1>All users</h1>
		<table>
		<tr>
			<th>Imię</th>
			<th>Nazwisko</th>
			<th>Email</th>
			<th>Akcja</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td><a href="/Warsztaty__6/user/${user.id}">Edit</a></td>
				<td><a href="/Warsztaty__6/deleteUser/${user.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>