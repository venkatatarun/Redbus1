package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Route;


public class Routedao {

	public static List<String> getAllRoutes() throws ClassNotFoundException, SQLException {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("select distinct name from route");
		List<String>list=new ArrayList<String>();
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			list.add(rs.getString(1));
		}
		return list;
	}

	public static List<Route> getTableDetails() throws SQLException, ClassNotFoundException {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from route");
		List<Route>table=new ArrayList<Route>();
		Route r = null;
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			r=new Route(rs.getInt(1),rs.getString(2),rs.getString(3));
			table.add(r);
		}
		return table;
		
	}
   
}
