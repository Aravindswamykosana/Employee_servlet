<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	form{
			text-align:center;
			border:2px solid;
			width:250px;
			heigth:200px;
			background-image: url("https://cdn.pixabay.com/photo/2024/01/04/21/54/volcano-8488486_1280.jpg");
		}
		body{
			background-color: green;
		}
</style>
</head>
<body>
<%String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<h1 style="color: red"><%= msg %></h1>
<% } %>
<form action="login">
		<input type="email" placeholder="enter your email" name="email"><br><br>
		<input type="password" placeholder="enter your pass" name="password"><br><br>
		<button>sign in</button> 
	</form>
</body>
</html>