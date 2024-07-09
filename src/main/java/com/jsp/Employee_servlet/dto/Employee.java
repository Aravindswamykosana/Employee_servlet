package com.jsp.Employee_servlet.dto;

public class Employee{
	private String name;
	private String email;
	private String password;
	private long phone;
	private int age;
	private double sal;
	private String job;
	private String address;
	
	public Employee(String name2, String email2, String pwd, long phone2, int age2, double sal2, String job2,
			String address2) {
		super();
		this.name=name2;
		this.email=email2;
		this.password=pwd;
		this.phone=phone2;
		this.age=age2;
		this.sal=sal2;
		this.job=job2;
		this.address=address2;
	}
	public Employee(String name2) {
		this.name=name2;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String toString() {
		return "EmployeeEncap [name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", age=" + age + ", sal=" + sal + ", job=" + job + ", address=" + address + "]";
	}
	
}
