package com.mari2020.mymemo.service;

import org.springframework.ui.Model;

import com.mari2020.mymemo.dao.Dao;

public class DeleteService {
	Dao dao = new Dao();
	public void execute(Model model , int no) {
		dao.deleteMemo(no);
	}
}
