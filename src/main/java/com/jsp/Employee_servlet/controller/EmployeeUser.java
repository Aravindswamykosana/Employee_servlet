package com.jsp.Employee_servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.jsp.Employee_servlet.dao.EmployeeCrud;
import com.jsp.Employee_servlet.dto.Employee;
@WebServlet("/save")
public class EmployeeUser extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pwd=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		int age=Integer.parseInt(req.getParameter("age"));
		double sal=Double.parseDouble(req.getParameter("sal"));
		String job=req.getParameter("job");
		String address=req.getParameter("address");
		Employee emp=new Employee(name,email,pwd,phone,age,sal,job,address);
		EmployeeCrud crud=new EmployeeCrud();
		
		try {
			crud.save(emp);
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.forward(req, res);
		} catch (ClassNotFoundException | SQLException e) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("register.html");
			dispatcher.include(req, res);
		}
	}

}
