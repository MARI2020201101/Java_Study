package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.CommonDto;
import domain.reply.dto.DetailDto;
import domain.reply.dto.ReplyDto;
import domain.reply.dto.WriteDto;
import service.ReplyService;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReplyService replyService = new ReplyService();
	
    public ReplyController() {
 
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
		
		if(cmd.equals("write")) {
			BufferedReader br = request.getReader();
			String replyJson = br.readLine();
			Gson gson = new Gson();
			WriteDto reply = gson.fromJson(replyJson, WriteDto.class);
			System.out.println(reply);
			
			int replyId = replyService.save(reply); 
			System.out.println("replyId : " + replyId); 
			
			DetailDto replyDto = replyService.findbyId(replyId);
			DetailDto newReply = DetailDto.builder() 
										.replyId(replyDto.getReplyId())
										.boardId(replyDto.getBoardId()) 
										.content(replyDto.getContent())
										.userId(replyDto.getUserId())
										.username(replyDto.getUsername())
										.build(); 
			
			out.print(gson.toJson(newReply)); 
			out.flush();
			 
			 
			
		}else if(cmd.equals("delete")) {
			int replyId = Integer.parseInt(request.getParameter("replyId"));
			int result = replyService.delete(replyId);
			out.print(result);
			out.flush();
		}
	}

}
