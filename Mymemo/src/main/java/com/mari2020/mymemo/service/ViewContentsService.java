package com.mari2020.mymemo.service;

import org.springframework.ui.Model;

import com.mari2020.mymemo.dao.Dao;
import com.mari2020.mymemo.model.Memo;

public class ViewContentsService {
	Dao dao = new Dao();
	public void execute(Model model, int no) {
		Memo memo = dao.selectMemo(no);
		model.addAttribute("memo", memo);
	}
}
