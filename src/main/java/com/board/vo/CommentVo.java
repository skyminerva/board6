package com.board.vo;

import java.util.Date;

public class CommentVo {
	
	// db 칼럼 내용
	private int cmtNo;
	
	private int id;
	
	private String comment;
	
	private String commenter;
	
	private Date regDate;
	
	private Date upDate;

	// getter, setter
	public int getCmtNo() {
		return cmtNo;
	}

	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpDate() {
		return upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	// toString 
	@Override
	public String toString() {
		return "CommentVo [cmtNo=" + cmtNo + ", id=" + id + ", comment=" + comment + ", commenter=" + commenter
				+ ", regDate=" + regDate + ", upDate=" + upDate + "]";
	}
	
	

}
