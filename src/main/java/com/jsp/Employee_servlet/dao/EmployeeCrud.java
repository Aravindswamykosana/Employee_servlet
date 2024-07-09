package com.jsp.Employee_servlet.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.Employee_servlet.dto.Employee;

public class EmployeeCrud {
	public Connection table() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_servlet?createDatabaseIfNotExist=true", "root", "root");
		Statement s = con.createStatement();
		s.execute("create table If Not Exists emp(name varchar(45),email varchar(45),password varchar(45),phone long,age int,sal double,job varchar(45),address varchar(45))");	
		return con;	
	}
	public Employee save(Employee emp1) throws ClassNotFoundException, SQLException {
		Connection con=table();
		PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?)");
		ps.setString(1,emp1.getName());
		ps.setString(2,emp1.getEmail());
		ps.setString(3,emp1.getPassword());
		ps.setLong(4, emp1.getPhone());
		ps.setInt(5, emp1.getAge());
		ps.setDouble(6, emp1.getSal());
		ps.setString(7,emp1.getJob());
		ps.setString(8,emp1.getAddress());
		ps.execute();
		return emp1;		
	}
	public Employee update(Employee emp1) throws ClassNotFoundException, SQLException{
		Connection con=table();
		PreparedStatement ps = con.prepareStatement("update emp set name=?,email=?,password=?,phone=?,age=?,sal=?,job=?,address=? where email=?");
		ps.setString(1,emp1.getName());
		ps.setString(2,emp1.getEmail());
		ps.setString(3,emp1.getPassword());
		ps.setLong(4, emp1.getPhone());
		ps.setInt(5, emp1.getAge());
		ps.setDouble(6, emp1.getSal());
		ps.setString(7,emp1.getJob());
		ps.setString(8,emp1.getAddress());
		ps.setString(9,emp1.getEmail());
		ps.execute();
		return emp1;
	}
	public int delete(String email) throws ClassNotFoundException, SQLException{
		Connection con=table();
		PreparedStatement ps = con.prepareStatement("delete from emp where email=?");
		ps.setString(1, email);
		return ps.executeUpdate();	
	}
	public Employee fetchEmployee(String email)throws ClassNotFoundException, SQLException{
		Connection con=table();
		PreparedStatement ps = con.prepareStatement("select * from emp where email=?");
		ps.setString(1, email);
		ResultSet res = ps.executeQuery();
		if(res.next()){
			Employee employee=new Employee();
			employee.setName(res.getString("name"));
			employee.setEmail(res.getString("email"));
			employee.setPassword(res.getString("password"));
			employee.setPhone(res.getLong("phone"));
			employee.setAge(res.getInt("age"));
			employee.setSal(res.getDouble("sal"));
			employee.setJob(res.getString("job"));
			employee.setAddress(res.getString("address"));
			return employee;
		}	
		else
			return null;
	}
	public List<Employee> fetchAllList(Employee emp) throws ClassNotFoundException, SQLException{
		Connection con=table();
		PreparedStatement ps = con.prepareStatement("select * from emp");
		ResultSet res = ps.executeQuery();
		List<Employee> li=new ArrayList<Employee>();
		while(res.next()) {
			String name = res.getString(1);
			String email=res.getString(2);
			String pwd = res.getString(3);
			long phno = res.getLong(4);
			int age = res.getInt(5);
			double sal = res.getDouble(6);
			String job=res.getString(7);
			String address=res.getString(8);
			Employee emp1=new Employee(name,email,pwd,phno,age,sal,job,address);
			li.add(emp1);
		}
		return li;	
	}
}
