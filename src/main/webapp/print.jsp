<%@page import="java.util.List"%>
<%@page import="com.jsp.Employee_servlet.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Employee emp = (Employee) request.getAttribute("e1");%>
	Name:<%=emp.getName()%>
	<br> Email:<%=emp.getEmail()%>
	<br> Pwd:<%=emp.getPassword()%><br> 
	phone:<%=emp.getPhone()%><br>
	age :<%=emp.getAge()%><br>
	sal :<%=emp.getSal()%><br> 
	job :<%=emp.getJob()%><br> 
	address :<%=emp.getAddress()%><br>
</body>
</html>