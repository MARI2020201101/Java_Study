package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import object.Food;

public class Dao {
	
	String url = "jdbc:mysql://localhost:3306/mealplanner";
	String user = "root";
	String password = "mari2020";
	final static String SELECT_ALL = "select * from food";
	final static String SELECT_FOOD = "select * from food where foodname = ?";
	final static String INSERT_NEW = "insert into food values(?,?,?,?,?,?,?,?)";
	final static String DELETE_FOOD = "delete from food where foodname = ?";
	
	//select all
	public ArrayList<Food> selectAllFood(){
		
		ArrayList<Food> foods = new ArrayList<Food>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SELECT_ALL);
			while(rs.next()) {
				String foodName = rs.getString(1);
				double portionSize = rs.getDouble(2);
				double carb = rs.getDouble(3);
				double protein = rs.getDouble(4);
				double fat = rs.getDouble(5);
				double natrium = rs.getDouble(6);
				double sugar = rs.getDouble(7);
				double calories = rs.getDouble(8);
				
				Food food = new Food(foodName,portionSize,carb,protein,fat,natrium,sugar,calories);
				foods.add(food);
			}
			rs.close();
			st.close();
			con.close();

		}catch(Exception e) {
			System.out.println(e);
		}return foods;
	}
	
	
	//select by foodName
	public Food selectFood(String foodName_) {
		
		Food food = new Food();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(SELECT_FOOD);
			ps.setString(1, foodName_);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String foodName = rs.getString(1);
				double portionSize = rs.getDouble(2);
				double carb = rs.getDouble(3);
				double protein = rs.getDouble(4);
				double fat = rs.getDouble(5);
				double natrium = rs.getDouble(6);
				double sugar = rs.getDouble(7);
				double calories = rs.getDouble(8);
				
				food = new Food(foodName,portionSize,carb,protein,fat,natrium,sugar,calories);
			}
			rs.close();
			ps.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}return food;
	}
	
	
	//insert new food
	
	public void insertFood(String foodName, double portionSize, double carb, double protein, double fat, double natrium, double sugar, double calories) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(INSERT_NEW);
			ps.setString(1, foodName);
			ps.setDouble(2, portionSize);
			ps.setDouble(3, carb);
			ps.setDouble(4, protein);
			ps.setDouble(5, fat);
			ps.setDouble(6, natrium);
			ps.setDouble(7, sugar);
			ps.setDouble(8, calories);
			ps.executeUpdate();
			
			
			ps.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	
	//delete food
	public void deleteFood(String foodName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(DELETE_FOOD);
			ps.setString(1, foodName);
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
