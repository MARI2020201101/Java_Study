package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.board.dto.BoardDto;
import domain.board.dto.WriteDto;
import service.BoardService;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardService boardService = new BoardService();
	
    public BoardController() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd =request.getParameter("cmd");
		
		//writeform : get
		//write : post
		//list : select ·Î »Ñ¸®±â
		//detail 
		
		if(cmd.equals("list")) {
			List<BoardDto> boards = boardService.list();
			request.setAttribute("boards", boards);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
			rd.forward(request, response);
		
		}else if(cmd.equals("writeForm")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/writeForm.jsp");
			rd.forward(request, response);
		}else if(cmd.equals("write")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			WriteDto writeDto = WriteDto.builder()
											.userId(userId)
											.title(title)
											.content(content).build();
			boardService.save(writeDto);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/detail.jsp");
			rd.forward(request, response);
			
		}else if(cmd.equals("detail")) {

			boardService.findbyBoardId();
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/detail.jsp");
			rd.forward(request, response);
		}
		
	}
	
}
