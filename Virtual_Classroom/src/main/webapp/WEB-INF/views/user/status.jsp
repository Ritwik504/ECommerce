<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h5 style="color: red;">Hello  ${requestScope.us.name} </h5>
<h5>Chat submitted</h5>
<h5>  <a href="user/logout">Logout</a>  </h5>
	
</body>
</html>