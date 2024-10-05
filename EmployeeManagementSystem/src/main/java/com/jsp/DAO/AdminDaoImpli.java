package com.jsp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpli implements AdminDao
{

	private static final String url ="jdbc:mysql://localhost:3306/employeeregistration?user=root&password=12345";
	private static final String adminlogin = "select * from adminlogin where adminemailid=? and adminpassword=?";

	
	@Override
	public boolean adminLogin(String emailid, String password) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(adminlogin);
			ps.setString(1,emailid);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
