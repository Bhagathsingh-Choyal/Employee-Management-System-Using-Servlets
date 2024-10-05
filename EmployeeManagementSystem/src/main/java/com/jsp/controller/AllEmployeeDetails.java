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

@WebServlet("/allemployee")
public class AllEmployeeDetails extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAO dao = new EmployeeDAOImpli();
		List<Employee> allEmployeeDetails = dao.getAllEmployeeDetails();
		HttpSession session = request.getSession();
		
		if(allEmployeeDetails.size()!=0)
		{
			session.setAttribute("allEmployeeDetails",allEmployeeDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("AllEmployee.jsp");
			dispatcher.include(request, response);
		} 
	}
}

