package com.jsp.Employee_servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.jsp.Employee_servlet.dao.EmployeeCrud;
import com.jsp.Employee_servlet.dto.Employee;

@WebServlet("/login")
public class LoginUser extends GenericServlet {
	public void service(ServletRequest req,ServletResponse res) throws ServletException, IOException {
		EmployeeCrud crud = new EmployeeCrud();
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		PrintWriter p=res.getWriter();
		try {
			Employee emp=crud.fetchEmployee(email);
			if(emp!=null) {
				if(pwd.equals(emp.getPassword())) {
					p.println("Login Successfull");
//					p.println(emp);
					List<Employee> list = crud.fetchAllList(emp);
//					for(Employee e:e1){
//						p.println(e);
//					}	
//					Object a=null;
//					Iterator itr=e1.iterator();
//					while(itr.hasNext()){
//						a = itr.next();
//						p.print(a);
//					}	
//					req.setAttribute("emp", emp);
//					RequestDispatcher dispatcher=req.getRequestDispatcher("print.jsp");
//					dispatcher.forward(req, res);
					req.setAttribute("list", list);
					RequestDispatcher dispatcher=req.getRequestDispatcher("printall.jsp");
					dispatcher.forward(req, res);
				}
				else {
					//password wrong.
					req.setAttribute("msg", "password wrong");
					RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
					dispatcher.include(req,res);
					p.print("Login Failed");
				}
			}
			else {
				//email wrong
				req.setAttribute("msg", "email wrong");
				RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
				dispatcher.include(req,res);
				p.print("Login Failed");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

}
