package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Userdao {

	public static boolean checkEmailExistsorNot(String e) throws ClassNotFoundException, SQLException {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps =  con.prepareStatement("Select * from user where email=?");
		ps.setString(1, e);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return true;

		return false;
	}
	public static boolean register(String n,String e,String p,String a,String phoneno) throws ClassNotFoundException, SQLException {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps =  con.prepareStatement("insert into user(name,email,password,age,phonenumber) values(?,?,?,?,?)");

		ps.setString(1, n);
		ps.setString(2, e);
		ps.setString(3, p);
		ps.setString(4, a);
		ps.setString(5, phoneno);

		if (ps.executeUpdate() > 0)
			return true;

		return false;
	}
	public static boolean emailexistsornot(String n, String p) throws SQLException, ClassNotFoundException {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps =  con.prepareStatement("select * from user where email=? && password=?");
		ps.setString(1,n);
		ps.setString(2, p);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
			return true;
		
		
		return false;
	}
	public static String getnameafterwelcome(String e) throws ClassNotFoundException, SQLException {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps =  con.prepareStatement("select name from user where email=?");
		ps.setString(1, e);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			return rs.getString(1);
		return null;
	}
	public static int getIdUsingEmail(String e) throws ClassNotFoundException, SQLException {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps =  con.prepareStatement("select id from user where email=?");
		ps.setString(1, e);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			return rs.getInt(1);
		
		return 0;
	}
}
