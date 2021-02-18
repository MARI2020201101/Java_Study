package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user.dto.LoginDto;
import domain.user.dto.RegisterDto;
import service.UserService;


@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd =request.getParameter("cmd");
		UserService userService = new UserService();
		
		if(cmd.equals("loginForm")) {
			//get 로그인 폼 화면
			
			System.out.println("loginForm");
			PrintWriter out = response.getWriter();
			out.print("loginForm........");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/loginForm.jsp");
			rd.forward(request, response);
			
		}else if(cmd.equals("registerForm")){
			//get 회원등록 폼 화면
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/registerForm.jsp");
			rd.forward(request, response);
			
		}else if(cmd.equals("login")) {
			//post 로그인form받아서 db에서 확인
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			LoginDto loginDto = LoginDto.builder().username(username).password(password).build();
			userService.login(loginDto);
			
		}else if(cmd.equals("register")) {
			//post 레지스터form받아서 db에 세이브
			
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			RegisterDto registerDto = RegisterDto.builder()
													.address(address)
													.email(email)
													.password(password)
													.username(username).build();
			userService.register(registerDto);
			response.sendRedirect("/WEB-INF/user/loginForm.jsp");
		}
	}
	
}
