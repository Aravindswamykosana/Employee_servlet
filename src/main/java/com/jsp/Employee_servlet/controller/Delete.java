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

import com.jsp.Employee_servlet.dao.EmployeeCrud;
import com.jsp.Employee_servlet.dto.Employee;
@WebServlet("/delete")
public class Delete extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		EmployeeCrud crud=new EmployeeCrud();
		try {
			Employee emp1=crud.fetchEmployee(email);
			int value = crud.delete(email);
			if(value>0) {
				List<Employee> list = crud.fetchAllList(emp1);
				req.setAttribute("list", list);
				RequestDispatcher dispatcher=req.getRequestDispatcher("printall.jsp");
				dispatcher.forward(req, res);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
