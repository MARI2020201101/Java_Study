package memberControl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberDao.Member;
import memberDao.MemberDao;

@WebServlet("/memberControl")
public class MemberControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao memberdao = new MemberDao();
		List<Member> members = memberdao.MemberSelect();
		//String memberInfo = null;
		for(Member member : members) {
			member.getUserID();
			member.getUserPassword();
			member.getUserName();
			member.getUserAge();
		}
		request.setAttribute("members", members);
		RequestDispatcher rd = request.getRequestDispatcher("member.jsp");
		rd.forward(request, response);
	}

}
