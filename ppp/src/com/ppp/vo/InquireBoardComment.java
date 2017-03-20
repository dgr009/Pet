package com.ppp.vo;

import java.sql.Date;

public class InquireBoardComment {
	int inquireBoardNo;
	int inquireBoardCommentNo;
	String adminId;
	String inquireBoardCommentCotent;
	Date inquireBoardCommentDate;
	int adminNo;
	public int getInquireBoardNo() {
		return inquireBoardNo;
	}
	public void setInquireBoardNo(int inquireBoardNo) {
		this.inquireBoardNo = inquireBoardNo;
	}
	public int getInquireBoardCommentNo() {
		return inquireBoardCommentNo;
	}
	public void setInquireBoardCommentNo(int inquireBoardCommentNo) {
		this.inquireBoardCommentNo = inquireBoardCommentNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getInquireBoardCommentCotent() {
		return inquireBoardCommentCotent;
	}
	public void setInquireBoardCommentCotent(String inquireBoardCommentCotent) {
		this.inquireBoardCommentCotent = inquireBoardCommentCotent;
	}
	public Date getInquireBoardCommentDate() {
		return inquireBoardCommentDate;
	}
	public void setInquireBoardCommentDate(Date inquireBoardCommentDate) {
		this.inquireBoardCommentDate = inquireBoardCommentDate;
	}
	public int getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}
	
}
