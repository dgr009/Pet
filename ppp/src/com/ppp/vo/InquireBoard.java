package com.ppp.vo;

import java.sql.Date;

public class InquireBoard {
	int inquireBoardNo;
	String memberId;
	String inquireBoardTitle;
	String inquireBoardContent;
	Date inquireBoardDate;
	int inuqireBoardCommentCount;
	int memberNo;
	int adminNo;
	public int getInquireBoardNo() {
		return inquireBoardNo;
	}
	public void setInquireBoardNo(int inquireBoardNo) {
		this.inquireBoardNo = inquireBoardNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getInquireBoardTitle() {
		return inquireBoardTitle;
	}
	public void setInquireBoardTitle(String inquireBoardTitle) {
		this.inquireBoardTitle = inquireBoardTitle;
	}
	public String getInquireBoardContent() {
		return inquireBoardContent;
	}
	public void setInquireBoardContent(String inquireBoardContent) {
		this.inquireBoardContent = inquireBoardContent;
	}
	public Date getInquireBoardDate() {
		return inquireBoardDate;
	}
	public void setInquireBoardDate(Date inquireBoardDate) {
		this.inquireBoardDate = inquireBoardDate;
	}
	public int getInuqireBoardCommentCount() {
		return inuqireBoardCommentCount;
	}
	public void setInuqireBoardCommentCount(int inuqireBoardCommentCount) {
		this.inuqireBoardCommentCount = inuqireBoardCommentCount;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}
	
}
