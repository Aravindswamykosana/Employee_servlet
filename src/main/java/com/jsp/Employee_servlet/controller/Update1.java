package com.jsp.Employee_servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.Employee_servlet.dao.EmployeeCrud;
import com.jsp.Employee_servlet.dto.Employee;
@WebServlet("/edit")
public class Update1 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		Employee db;
		try {
			db=crud.update(emp);
			if(db!=null) {
				List<Employee> list = crud.fetchAllList(emp);
				req.setAttribute("list", list);
				RequestDispatcher dispatcher=req.getRequestDispatcher("printall.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}

}
