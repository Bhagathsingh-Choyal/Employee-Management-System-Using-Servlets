<%@page import="com.jsp.DAO.EmployeeDAOImpli"%>
<%@page import="com.jsp.DAO.EmployeeDAO"%>
<%@page import="com.jsp.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<%
		EmployeeDAO dao = new EmployeeDAOImpli();
		int id = Integer.parseInt(request.getParameter("empid"));
		Employee emp = dao.fetchEmployeeById(id);
	%>
		<form action="updateemp" method="post">
			<input type="hidden" name="empid" value="<%=id%>">
			<input placeholder="Employee Name : " name="ename" value="<%=emp.getEmpname()%>"><br><br>
			<input placeholder="Employee Salary : " name="eSal" value="<%=emp.getEmpsal()%>"><br><br>
			<input placeholder="Employee DeptNo : " name="deptNo" value="<%=emp.getEmpdeptno()%>"><br><br>
			<input type="submit" value="Update">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="cancel">
		</form>
	</center>
</body>
</html>