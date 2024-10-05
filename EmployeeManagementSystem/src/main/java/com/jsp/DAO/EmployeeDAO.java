package com.jsp.DAO;

import java.util.List;


import com.jsp.model.Employee;

public interface EmployeeDAO 
{
	
	List<Employee> getAllEmployeeDetails();
	List<Employee> searchEmployeeByDeptnoOrSalary(int salaryordeptno);
	int deleteemployee(int empid);
	int updateEmployee(Employee employee);
	Employee fetchEmployeeById(int id);
	int addEmployee(Employee employee);
}
