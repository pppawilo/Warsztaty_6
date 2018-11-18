<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User form</title>
</head>
<body>
<a href="/Warsztaty__6/user/add">Add user</a><br>
	  <a href="/Warsztaty__6/user/all">All users</a><br>
	<h1>User form</h1>
		<form:form method="post" modelAttribute="userDto">
		First name: <form:input path="firstName" />
		<form:errors path="firstName"
					 cssClass="error" /><br />
		Last name: <form:input path="lastName" />
		<form:errors path="lastName"
					 cssClass="error" /><br />
		<form:hidden path="id" />
		Email: <form:input path="email" />
		<form:errors path="email"
					 cssClass="error" /><br/>
		<input type="submit" />
	</form:form>
</body>
</html>