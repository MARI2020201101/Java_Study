package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.user.dto.UserDto;
import utils.Script;


public class UserFilter implements javax.servlet.Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		String cmd = request.getParameter("cmd");
		if(cmd.equals("writeForm")) {
			UserDto loginUser = null;
			loginUser = (UserDto) session.getAttribute("loginUser");
			if(loginUser==null) {
				Script.back(response, "Please Login............");
				return;
			}
		}else if(uri.contains("board")&& cmd.equals("updateForm")) {
			UserDto loginUser = null;
			loginUser = (UserDto) session.getAttribute("loginUser");
			int userId = Integer.parseInt(request.getParameter("userId"));
			if(loginUser==null) {
				Script.back(response, "Please Login............");
				return;
			}else if(loginUser.getUserId()!=userId) {
				Script.back(response, "Non Qualified Action............");
				return;
			}
		}
		chain.doFilter(request, response);}

    }

