package com.mari2020.mymemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mari2020.mymemo.model.Memo;

public class Dao{
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/mymemo";
	static final String USER = "root";
	static final String PASSWORD = "mari2020";
	static final String SELECTALL = "select * from memo";
	static final String SELECT = "select * from memo where no = ?";
	static final String INSERT = "insert into memo values(?,?,?)";
	static final String UPDATE = "update memo set title = ?, contents = ? where no = ?";
	static final String DELETE = "delete from memo where no = ?";
	
	
	public ArrayList<Memo> selectAllMemo(){
		ArrayList<Memo> memos = new ArrayList<Memo>();
		try{
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SELECTALL);
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				
				Memo memo = new Memo(no,title,contents);
				memos.add(memo);
			}
			rs.close();
			st.close();
			con.close();
			
			}catch(Exception e){
				e.printStackTrace();
		}return memos;
	}
	
	
	public Memo selectMemo(int no_){
		Memo memo = new Memo();
		try{
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(SELECT);
			ps.setString(1,Integer.toString(no_));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				
				memo = new Memo(no,title,contents);
			}
			rs.close();
			ps.close();
			con.close();
			
			}catch(Exception e){
				e.printStackTrace();
		}return memo;
	}
	
	public void insertMemo(String no, String title, String contents){
		
		try{
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setInt(1,Integer.parseInt(no));
			ps.setString(2,title);
			ps.setString(3,contents);
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	public void updateMemo(String title, String contents, String no){
		
		try{
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(UPDATE);
			ps.setString(1,title);
			ps.setString(2,contents);
			ps.setInt(3,Integer.parseInt(no));
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	
	public void deleteMemo(int no){
		
		try{
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(DELETE);
			ps.setString(1,Integer.toString(no));
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	

}
