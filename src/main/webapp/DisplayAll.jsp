<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>PERSONS DETAILS</h1>
		<table border="5px">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
				<th>Age</th>
				<th>DELETE</th>
				<th>UPDATE</th>
			</tr>
			<c:forEach var="person" items="${persons}">
			<tr>
			<th>${person.getId()}</th>
			<th>${person.getName()}</th>
			<th>${person.getEmail()}</th>
			<th>${person.getNum()}</th>
			<th>${person.getAge()}</th>
			
			<th><a href="delete?id=${person.getId()}">delete</a></th>
			<th><a href="update?id=${person.getId()}">Update</a></th>
			</tr>
			</c:forEach>
		</table>

	</center>

</body>
</html>