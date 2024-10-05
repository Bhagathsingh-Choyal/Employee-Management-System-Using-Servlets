package com.jsp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.jsp.model.Employee;

public class EmployeeDAOImpli implements EmployeeDAO
{

	private static final String url ="jdbc:mysql://localhost:3306/employeeregistration?user=root&password=12345";
	private static final String select_all_employee_details = "select * from employee";
	private static final String search_By_Deptno_Or_Salary = "select * from employee where empsal=? or empdeptno=?";
	private static final String add_employee = "insert into employee(empname, empsal, empdeptno) values(?,?,?)";
	private static final String update_emp = "update employee set empname=? ,empsal=?,empdeptno=? where empid=?";
	private static final String delete_emp ="delete from employee where empid=?";
	private static final String select_emp_By_Id = "select * from employee where empid=?";
	
	@Override
	public List<Employee> getAllEmployeeDetails() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement statement = connection.prepareStatement(select_all_employee_details);
			ResultSet result = statement.executeQuery(select_all_employee_details);
			List<Employee> listOfEmployee = new ArrayList<Employee>();
			if(result.isBeforeFirst())
			{
				while(result.next())
				{
					Employee employee = new Employee(result.getInt("empid"),result.getString("empname"),result.getDouble("empsal"),result.getInt("empdeptno"));
					listOfEmployee.add(employee);
				}
				return listOfEmployee;
			}
			else
			{
				return null;
			}
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> searchEmployeeByDeptnoOrSalary(int salordeptno) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(search_By_Deptno_Or_Salary);
			ps.setDouble(1,salordeptno);
			ps.setInt(2,salordeptno);
			ResultSet result = ps.executeQuery();
			List<Employee> listOfEmployee = new ArrayList<Employee>();

			if(result.isBeforeFirst())
			{
				while(result.next())
				{
					Employee employeedetails = new Employee(result.getInt("empid"),result.getString("empname"),result.getDouble("empsal"),result.getInt("empdeptno"));
					listOfEmployee.add(employeedetails);
				}
				return listOfEmployee;
			}
			else
			{
				return null;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteemployee(int empid) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(delete_emp);
			ps.setInt(1,empid);
			int result = ps.executeUpdate();
			
			if(result!=0)
			{
				return result;
			}
			else
			{
				return 0;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int updateEmployee(Employee employee) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(update_emp);
			ps.setString(1, employee.getEmpname());
			ps.setDouble(2, employee.getEmpsal());
			ps.setInt(3, employee.getEmpdeptno());
			ps.setInt(4,employee.getEmpid());
			int result = ps.executeUpdate();
			
			if(result!=0)
			{   
				return result;
			}
			else
			{
				return 0;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Employee fetchEmployeeById(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select_emp_By_Id);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				Employee e = new Employee();
				e.setEmpid(rs.getInt(1));
				e.setEmpname(rs.getString(2));
				e.setEmpsal(rs.getDouble(3));
				e.setEmpdeptno(rs.getInt(4));
				return e;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int addEmployee(Employee employee) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(add_employee);
			ps.setString(1,employee.getEmpname());
			ps.setDouble(2,employee.getEmpsal());
			ps.setInt(3,employee.getEmpdeptno());
		    int result = ps.executeUpdate();
		    if(result!=0)
		    {
		    	return result;
		    }
		    else
		    {
		    	return 0;
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
