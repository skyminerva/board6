package com.board.vo;

import java.util.Date;

public class BoardVo {
	
	private int id;
	private String name;
	private String title;
	private String content;
	private String division;
	private Date regdate;
	private Date up_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public Date getUpdate() {
		return up_date;
	}
	public void setUpdate(Date update) {
		this.up_date = update;
	}
	@Override
	public String toString() {
		return "BoardVo [id=" + id + ", name=" + name + ", title=" + title + ", content=" + content + ", division="
				+ division + ", regdate=" + regdate + ", up_date=" + up_date + "]";
	}


}
