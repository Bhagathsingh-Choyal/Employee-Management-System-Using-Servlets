package com.jsp.model;

public class Employee
{
	private int empid;
	private String empname;
	private double empsal;
	private int empdeptno;
	
	public Employee() {}

	public Employee(int empid, String empname, double empsal, int empdeptno) 
	{	
		this.empid = empid;
		this.empname = empname;
		this.empsal = empsal;
		this.empdeptno = empdeptno;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public double getEmpsal() {
		return empsal;
	}

	public void setEmpsal(double empsal) {
		this.empsal = empsal;
	}

	public int getEmpdeptno() {
		return empdeptno;
	}

	public void setEmpdeptno(int empdeptno) {
		this.empdeptno = empdeptno;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empsal=" + empsal + ", empdeptno=" + empdeptno
				+ "]";
	}
	
}
