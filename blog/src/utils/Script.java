package utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Script{
	
	public static void alert(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		System.out.println("------------------------alert script------------------");
		out.println("<script>");
		out.println("alert('" + msg + "');");
		out.println("</script>");
		out.flush();
	}
	public static void back(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + msg + "');");
		out.println("history.back();");
		out.println("</script>");
		out.flush();
	}

}
