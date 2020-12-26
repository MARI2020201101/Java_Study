package com.mari2020;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test3")
public class test3 extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String n = request.getParameter("n");
		String result;
		
		if (n != "" && n != null) {
			if(Integer.parseInt(n) % 2 == 0) {
				result = "Â¦¼ö";
			}else {
				result = "È¦¼ö";
			}
		}else {
			result = "Â¦¼ö";
		}
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("test3.jsp");
		rd.forward(request, response);
		
	}

}
