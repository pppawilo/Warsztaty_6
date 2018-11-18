<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Tweets</title>
</head>
<body>
<a href="/Warsztaty__6/user/add">Add user</a><br>
	  <a href="/Warsztaty__6/user/all">All users</a><br>
	<h1>User Tweets</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${userDto.tweets}" var="user">
			<tr>
				<td>${user.tweets.title}</td>
				<td>${user.tweets.tweetText}</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>