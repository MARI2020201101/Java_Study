package com.mari2020;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/Test")
public class Test extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String mobileNumber = request.getParameter("mobileNumber");
		String email = request.getParameter("email");
		String bloodGroup = request.getParameter("bloodGroup");
		String status = "pending";
		String sql = "insert into bloodrequest value(?,?,?,?,?)";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "mari2020");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, mobileNumber);
			st.setString(3, email);
			st.setString(4, bloodGroup);
			st.setString(5, status);
			int result = st.executeUpdate();
			System.out.println(result);
		
			}
			catch(Exception e) {
				System.out.print(e);
			}
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		RequestDispatcher rd = request.getRequestDispatcher("Test2");
		rd.forward(request, response);
		
	}

}
