package com.mari2020.mymemo.service;

import org.springframework.ui.Model;

import com.mari2020.mymemo.dao.Dao;

public class WriteService {
	Dao dao = new Dao();

	public void execute(Model model, String no , String title, String contents) {
		dao.insertMemo(no, title, contents);
	}
}
