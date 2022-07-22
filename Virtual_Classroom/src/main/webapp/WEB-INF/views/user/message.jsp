<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<spring:url var="url" value="/user/submit_chat" />
	<form action="${url}"  method="post">
		<h1>Welcome ${requestScope.us.name}</h1>
	Message : &emsp;	<input name="message"></input>
		<button type="submit">Submit Chat</button>
		<h3><a href="user/logout">Logout</a></h3>
	</form>
</body>
</html>