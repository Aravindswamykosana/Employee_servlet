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
@WebServlet("/update")
public class Update extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		String email=req.getParameter("email");
		EmployeeCrud crud=new EmployeeCrud();
		try {
			Employee db = crud.fetchEmployee(email);
			if(db!=null){
				req.setAttribute("list", db);
				RequestDispatcher dispatcher=req.getRequestDispatcher("update.jsp");
				dispatcher.forward(req, res);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
