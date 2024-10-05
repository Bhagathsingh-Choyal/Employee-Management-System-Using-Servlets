package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.DAO.AdminDao;
import com.jsp.DAO.AdminDaoImpli;
import com.jsp.DAO.EmployeeDAO;
import com.jsp.DAO.EmployeeDAOImpli;


@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		
		AdminDao dao = new AdminDaoImpli();
		boolean adminLogin = dao.adminLogin(emailid,password);
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		System.out.println(adminLogin);
		if(adminLogin==true)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/allemployee");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.include(request, response);
			
			writer.println("<center><h1>Invalid Credentails</h1></center>");
		}
		
	}
}
