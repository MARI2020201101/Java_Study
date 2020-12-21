package com.mari2020.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		int value = Integer.parseInt(request.getParameter("value"));
		String operater = request.getParameter("operater");
		PrintWriter out = response.getWriter();
		ServletContext application = request.getServletContext();
		
		if(operater.equals("=")) {
			int x = (Integer)(application.getAttribute("value"));
			int y = value;
			int result = 0;
			String operater_ = (String)(application.getAttribute("operater"));
			
			//계산하기
			if(operater_.equals("+")) {
				result = x + y;
				out.printf("result is %d\n", result);
			}else {
				result = x - y;
				out.printf("result is %d\n", result);
			}
			
			
		}else {
			//값저장하기
			
			application.setAttribute("value",value);
			application.setAttribute("operater", operater);
			
		}
	}

}
