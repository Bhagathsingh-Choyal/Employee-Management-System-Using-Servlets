package com.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.DAO.EmployeeDAO;
import com.jsp.DAO.EmployeeDAOImpli;
import com.jsp.model.Employee;

@WebServlet("/searchemployee")
public class SearchEmployeeBySalaryOrDeptno extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String deptno = request.getParameter("salaryordeptno");
		int salordeptno = Integer.parseInt(deptno);
		
	
		HttpSession session = request.getSession();
		
		EmployeeDAO dao = new EmployeeDAOImpli();
		List<Employee> searchEmployeeByDeptnoOrSalary = dao.searchEmployeeByDeptnoOrSalary(salordeptno);
		System.out.println(searchEmployeeByDeptnoOrSalary);
		
		if(searchEmployeeByDeptnoOrSalary.size()!=0)
		{
			session.setAttribute("allEmployeeDetails",searchEmployeeByDeptnoOrSalary);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("AllEmployee.jsp");
			dispatcher.include(request, response);
		}
	}
}
