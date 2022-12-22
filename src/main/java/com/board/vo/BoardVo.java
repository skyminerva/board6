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
	private int sel_cnt;
	
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
	
	
	public Date getUp_date() {
		return up_date;
	}
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	public int getSel_cnt() {
		return sel_cnt;
	}
	public void setSel_cnt(int sel_cnt) {
		this.sel_cnt = sel_cnt;
	}
	@Override
	public String toString() {
		return "BoardVo [id=" + id + ", name=" + name + ", title=" + title + ", content=" + content + ", division="
				+ division + ", regdate=" + regdate + ", up_date=" + up_date + ", sel_cnt=" + sel_cnt + "]";
	}


}
