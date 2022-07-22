<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5 style="color: red;">${requestScope.mesg}</h5>
<spring:url var="url" value="/user/register" />
	<form action="${url}"  method="post">
	<!--  When action is missing  same URl sends-->
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" required /></td>
			</tr>
			<tr>
				<td>Roll no</td>
				<td><input type="number" name="rollno" required /></td>
			</tr>
			<tr>
				<td>Batch</td>
				<td><input type="number" name="batch" required /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pass" required /></td>
			</tr>
			

			<tr>
				<td><button type="submit">Register me</button></td>
			</tr>
			
		</table>
	</form>
</body>
</html>