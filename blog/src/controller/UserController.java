package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.user.dto.LoginDto;
import domain.user.dto.RegisterDto;
import domain.user.dto.UpdateDto;
import domain.user.dto.UserDto;
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
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();	
		if(cmd.equals("loginForm")) {
			//get 로그인 폼 화면
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
			UserDto loginUser = userService.login(loginDto);

			if(loginUser==null) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/loginForm.jsp");
				request.setAttribute("msg", "Please Check Username and Password...");
				rd.forward(request, response);
				
			}else {

				response.sendRedirect("/blog/board?cmd=list");
				session.setAttribute("loginUser", loginUser);
			}

			
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
			response.sendRedirect("/blog/user?cmd=loginForm");
		}else if(cmd.equals("updateForm")) {
			System.out.println("updateForm...................................");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/updateForm.jsp");
			rd.forward(request, response);
			
		}else if(cmd.equals("update")) {
			
			int userId = Integer.parseInt(request.getParameter("userId"));
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			UpdateDto updateDto = UpdateDto.builder()
													.userId(userId)
													.address(address)
													.email(email)
													.password(password)
													.username(username).build();
			userService.update(updateDto);
			response.sendRedirect("/blog/user?cmd=loginForm");
			
		}else if(cmd.equals("logout")) {
			session.removeAttribute("loginUser");
			session.invalidate();
			response.sendRedirect("/blog/board?cmd=list");
			
		}else if(cmd.equals("usernameCheck")) {
			
			String username = request.getParameter("username");
			System.out.println(username);
			
			boolean check = userService.usernameCheck(username);
			System.out.println(check);
			if(check==true) {
				//username 중복
				out.print(0);
			}else {
				out.print(1);
			}
		}
	}
	
}
