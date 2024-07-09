<%@page import="com.jsp.Employee_servlet.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	th{
		background-color: purple;
	}
	td{
		background: yellow;
	}
</style>
</head>
<body>
	<%List<Employee> list=(List<Employee>)request.getAttribute("list");%>
	<table border="2px solid" cellspacing="5px" cellpadding="5px" style="background-color: blue">
		<tr>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th>AGE</th>
			<th>SAL</th>
			<th>JOB</th>
			<th>ADDRESS</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		for(Employee employee:list){ 
		%>
		<tr>
			<td><%= employee.getName() %></td>
			<td><%= employee.getEmail() %></td>
			<td><%= employee.getPhone() %></td>
			<td><%= employee.getAge()%></td>
			<td><%= employee.getSal() %></td>
			<td><%= employee.getJob()%></td>
			<td><%= employee.getAddress()%></td>
			<td><a href="update?email=<%= employee.getEmail() %>">Update</a></td>
			<td><a href="delete?email=<%= employee.getEmail() %>">Delete</a></td>
		</tr>
		<%}%>
	</table>
	
</body>
</html>