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
	<%String emp=request.getParameter("email");%>
	<%Employee emp1=(Employee)request.getAttribute("list"); %>
	
	<form action="edit" style="border: 2px solid" method="post">
		<input type="text" placeholder="enter your name" name="name" value="<%=emp1.getName()%>"><br/><br/>
		<input type="email" placeholder="enter your email" name="email" value="<%=emp%>" readonly="readonly"><br/><br/>
		<input type="password" placeholder="enter your password" name="password" value="<%=emp1.getPassword()%>" ><br/><br/>
		<input type="tel" placeholder="enter your phno" name="phone" value="<%=emp1.getPhone()%>"><br/><br/>
		<input type="number" placeholder="enter your age" name="age" value="<%=emp1.getAge()%>"><br/><br/>
		<input type="number" placeholder="enter your sal" name="sal" value="<%=emp1.getSal()%>"><br/><br/>
		<input type="text" placeholder="enter your job" name="job" value="<%=emp1.getJob()%>" ><br/><br/>
		<textarea rows="3" cols="15" name="address" placeholder="enter your address" value="<%=emp1.getAddress()%>"></textarea><br/><br/>
		<button>update</button>
	</form>
</body>
</html>