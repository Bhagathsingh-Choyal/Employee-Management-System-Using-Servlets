<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.jsp.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="AllEmployee.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="searchemployee">
			<input placeholder="Search By Salary Or Deptno" name="salaryordeptno">
			<input type="submit" value="search">
		</form>
	</center>
	<%
	List<Employee> list = (List<Employee>) session.getAttribute("allEmployeeDetails");
	%>
	<center>
		<br>
		<table border="1">
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Employee Salary</th>
				<th>Emnployee Deptno</th>
				<th colspan="2"><form action="AddEmployee.jsp" method="post"><input type="submit" value="add"></form></th>
			</tr>
			<%
			for (Employee employee : list) {
			%>

			<tr>
				<td><%=employee.getEmpid()%></td>
				<td><%=employee.getEmpname()%></td>
				<td><%=employee.getEmpsal()%></td>
				<td><%=employee.getEmpdeptno()%></td>
				<td><form action="Update.jsp" method="post">
						<input type="hidden" name="empid" value="<%= employee.getEmpid()%>">
						<input type="submit" value="update">
					</form></td>
				<td>
					<form action="deleteemp" method="post">
						<input type="hidden" name="empid" value="<%=employee.getEmpid()%>">
						<input type="submit" value="delete">
					</form>
				</td>
			</tr>
			<%}%>
		</table>
	</center>
</body>
</html>