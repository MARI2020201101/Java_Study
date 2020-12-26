package com.mari2020.web;


import java.sql.*;
import java.sql.DriverManager;


public class LoginDao {
	public boolean loginCheck(String id, String password) {
	
		String sql = "select * from login where id = ? and password = ?";
		
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginregister", "root", "mari2020");
			//System.out.println("ok");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next())return true;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
