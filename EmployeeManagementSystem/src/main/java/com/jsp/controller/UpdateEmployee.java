package com.jsp.controller;

import java.io.IOException;

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

@WebServlet("/updateemp")
public class UpdateEmployee extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Employee e = new Employee();
		e.setEmpid(Integer.parseInt(request.getParameter("empid")));
		e.setEmpname(request.getParameter("ename"));
		e.setEmpsal(Double.parseDouble(request.getParameter("eSal")));
		e.setEmpdeptno(Integer.parseInt(request.getParameter("deptNo")));
		EmployeeDAO dao = new EmployeeDAOImpli();
		int status = dao.updateEmployee(e);
		
		request.getSession().setAttribute("allEmployeeDetails", dao.getAllEmployeeDetails());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("AllEmployee.jsp");
		dispatcher.forward(request, response);
	}
}
