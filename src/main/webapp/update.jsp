<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h1>Update PERSON DETIALS</h1>
		<form:form action="updateperson" modelAttribute="person">
			ID:	    <form:input path="id" readonly="true"/>
			NAME:	    <form:input path="name" />
			EMAIL:	    <form:input path="email" />
			PHONE NO:	<form:input path="num" />
			AGE:    	<form:input path="age" />
			<form:button >Save</form:button>

		</form:form>


</body>
</html>