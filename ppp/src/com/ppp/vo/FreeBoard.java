package com.ppp.vo;

import java.sql.Date;

public class FreeBoard {
	int freeBoardNo;
	String freeBoardTitle;
	int freeBoardCount;
	int freeBoardCommentCount;
	String freeBoardContent;
	Date freeBoardDate;
	String memberId;
	int memberNo;
	public int getFreeBoardNo() {
		return freeBoardNo;
	}
	public void setFreeBoardNo(int freeBoardNo) {
		this.freeBoardNo = freeBoardNo;
	}
	public String getFreeBoardTitle() {
		return freeBoardTitle;
	}
	public void setFreeBoardTitle(String freeBoardTitle) {
		this.freeBoardTitle = freeBoardTitle;
	}
	public int getFreeBoardCount() {
		return freeBoardCount;
	}
	public void setFreeBoardCount(int freeBoardCount) {
		this.freeBoardCount = freeBoardCount;
	}
	public int getFreeBoardCommentCount() {
		return freeBoardCommentCount;
	}
	public void setFreeBoardCommentCount(int freeBoardCommentCount) {
		this.freeBoardCommentCount = freeBoardCommentCount;
	}
	public String getFreeBoardContent() {
		return freeBoardContent;
	}
	public void setFreeBoardContent(String freeBoardContent) {
		this.freeBoardContent = freeBoardContent;
	}
	public Date getFreeBoardDate() {
		return freeBoardDate;
	}
	public void setFreeBoardDate(Date freeBoardDate) {
		this.freeBoardDate = freeBoardDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
}
