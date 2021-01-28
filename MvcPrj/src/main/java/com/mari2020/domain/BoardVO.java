package com.mari2020.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	Long bno;
	String title;
	String content;
	String writer;
	Date regDate;
	Date updateDate;
	
}
