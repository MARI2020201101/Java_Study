package com.mari2020.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc")
public class calc extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		Cookie[] cookies = request.getCookies();
		
		
		String value = request.getParameter("value");
		String op = request.getParameter("operater");
		int y = 0;
		
		if(value != null && !value.equals("")) {
			y = Integer.parseInt(value);
		}
		
	
		int result = 0;
		if(op.equals("=")) {
			
			int x = 0;
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("value")) {
					x = Integer.parseInt(cookie.getValue());
					break;	
				}
				
				String op_ = "";
				if(cookie.getName().equals("operater")) {
					op_ = cookie.getValue();
					break;
				}
			if(op_.equals("+")) {
				result = x + y;
			}
			else {
				result = x - y;
			}
				
			}
			
			
				
		}
		PrintWriter out = response.getWriter();
		out.print(result);
		
		
		Cookie valueCookie = new Cookie("value", String.valueOf(value));
		Cookie opCookie = new Cookie("operater", op);
		response.addCookie(valueCookie);
		response.addCookie(opCookie);
		
		
		
	}
	
}
