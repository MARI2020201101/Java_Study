package com.mari2020.mymemo.service;

import org.springframework.ui.Model;

import com.mari2020.mymemo.dao.Dao;

public class UpdateService {
	Dao dao = new Dao();
	public void execute(Model model, String title, String contents, String no) {
		dao.updateMemo(title, contents, no);
	}
}
