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

@WebServlet("/deleteemp")
public class DeleteEmployee extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String empid1 = request.getParameter("empid");
		int empid = Integer.parseInt(empid1);
		
		EmployeeDAO dao = new EmployeeDAOImpli();
		
		
		int result = dao.deleteemployee(empid);
		
		List<Employee> allEmployeeDetails = dao.getAllEmployeeDetails();
		HttpSession session = request.getSession();
		
		if(result!=0)
		{
			session.setAttribute("allEmployeeDetails",allEmployeeDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("AllEmployee.jsp");
			dispatcher.include(request, response);
		}
	}
}
