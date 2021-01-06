package com.mari2020.mymemo.service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.mari2020.mymemo.dao.Dao;
import com.mari2020.mymemo.model.Memo;

public class ViewService {
	Dao dao = new Dao();


	public void execute(Model model) {
		ArrayList<Memo> memos = dao.selectAllMemo();
		model.addAttribute("memos", memos);
		
	}


	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Memo> memos = dao.selectAllMemo();
		request.setAttribute("memos", memos);
		
	}


}
