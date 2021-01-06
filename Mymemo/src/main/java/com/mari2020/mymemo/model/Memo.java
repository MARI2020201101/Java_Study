package com.mari2020.mymemo.model;

public class Memo {
	private int no;
	private String title;
	private String contents;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Memo(int no, String title, String contents) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
	}
	public Memo() {
		super();
	}
}
