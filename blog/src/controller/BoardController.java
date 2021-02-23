package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.board.dto.BoardDto;
import domain.board.dto.BoardwithUserDto;
import domain.board.dto.Pagination;
import domain.board.dto.UpdateDto;
import domain.board.dto.WriteDto;
import domain.user.dto.UserDto;
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
	
		//writeform : get
		//write : post
		//list : select ·Î »Ñ¸®±â
		//detail 
		
		if(cmd.equals("list")) {
			
			int count = boardService.countAll();
			System.out.println("Board row Count :"+ count);
			
			Pagination pagination = null; 
			String currentPage = request.getParameter("pageNum");
			
			if(currentPage!=null) {
				pagination= new Pagination(count, Integer.parseInt(currentPage));
			}else {
				pagination= new Pagination(count, 1);
			}
			System.out.println(pagination);
			List<BoardDto> boards = boardService.listwithPage(pagination);

			request.setAttribute("pagination", pagination);
			request.setAttribute("boards", boards);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
			rd.forward(request, response);
			
		
		}else if(cmd.equals("writeForm")) {
			
			UserDto loginUser = (UserDto) session.getAttribute("loginUser");
			request.setAttribute("loginUser", loginUser);
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
			System.out.println("writed content" + writeDto);
			
			int result = boardService.save(writeDto);
			System.out.println("result : " + result);
			if(result ==1 ) {
				response.sendRedirect("/blog/board?cmd=list");
			}
		}else if(cmd.equals("detail")) {
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			BoardwithUserDto board = boardService.findbyBoardIdwithUser(boardId);
			String writeDate = board.getWriteDate();
			board.setWriteDate(writeDate.substring(0, 10));
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("board", board);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/detail.jsp");
			rd.forward(request, response);
			
		}else if(cmd.equals("update")) {

			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			UpdateDto updateDto = UpdateDto.builder().title(title).content(content).build();
			boardService.update(boardId, updateDto);

			request.setAttribute("pageNum", pageNum);
			RequestDispatcher rd = request.getRequestDispatcher("/board?cmd=list");
			rd.forward(request, response);
			
		}else if(cmd.equals("updateForm")) {

			int boardId = Integer.parseInt(request.getParameter("boardId"));
			BoardDto board = boardService.findbyBoardId(boardId);
			request.setAttribute("board", board);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/updateForm.jsp");
			rd.forward(request, response);
		}else if(cmd.equals("delete")) {
			
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			int result = boardService.delete(boardId);
			out.print(result);
			out.flush();

		}

	}
	
}
