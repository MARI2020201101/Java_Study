package com.mari2020.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginControl")
public class login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login check(if there are id. password in database)
		//redirect to welcome page
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		User user = new User(id, password);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		LoginDao logindao = new LoginDao();
		if(logindao.loginCheck(id, password)) {
			response.sendRedirect("welcome.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
		
		
		
	}

}
