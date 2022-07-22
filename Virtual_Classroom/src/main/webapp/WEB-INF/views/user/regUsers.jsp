<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table style="background-color: lightgrey; margin: auto">
		<h1>Users Participated in Classroom session :
			</h1>
		<c:forEach var="u" items="${requestScope.allUser}">
			<tr>
				<td> ${u.id} &emsp; ${u.name} &emsp; ${u.batch}</td>
			</tr>
		</c:forEach>
	</table>
	<h2><a href="message">My personal Chatbox</a> </h2>

</body>
</html>