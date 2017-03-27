package com.ppp.vo;

import java.sql.Date;

public class FreeBoardComment {
	int freeBoardNo;
	int freeBoardCommentNo;
	String memberId;
	String freeBoardCommentContent;
	Date freeBoardCommentDate;
	int memberNo;
	public int getFreeBoardNo() {
		return freeBoardNo;
	}
	public void setFreeBoardNo(int freeBoardNo) {
		this.freeBoardNo = freeBoardNo;
	}
	public int getFreeBoardCommentNo() {
		return freeBoardCommentNo;
	}
	public void setFreeBoardCommentNo(int freeBoardCommentNo) {
		this.freeBoardCommentNo = freeBoardCommentNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getFreeBoardCommentContent() {
		return freeBoardCommentContent;
	}
	public void setFreeBoardCommentContent(String freeBoardCommentContent) {
		this.freeBoardCommentContent = freeBoardCommentContent;
	}
	public Date getFreeBoardCommentDate() {
		return freeBoardCommentDate;
	}
	public void setFreeBoardCommentDate(Date freeBoardCommentDate) {
		this.freeBoardCommentDate = freeBoardCommentDate;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	
}
