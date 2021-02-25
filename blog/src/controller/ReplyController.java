package controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		
		if(cmd.equals("write")) {
			BufferedReader br = request.getReader();
			String replyJson = br.readLine();
			Gson gson = new Gson();
			WriteDto reply = gson.fromJson(replyJson, WriteDto.class);
			System.out.println(reply);
			replyService.save(reply);
		}
	}

}
