package com.ppp.vo;

import java.sql.Date;

public class MemberMessage {
	 int memberMessageNo;
	 String memberMessageTitle;
	 String memberMessageContent;
	 Date memberMessageDate;
	public int getMemberMessageNo() {
		return memberMessageNo;
	}
	public void setMemberMessageNo(int memberMessageNo) {
		this.memberMessageNo = memberMessageNo;
	}
	public String getMemberMessageTitle() {
		return memberMessageTitle;
	}
	public void setMemberMessageTitle(String memberMessageTitle) {
		this.memberMessageTitle = memberMessageTitle;
	}
	public String getMemberMessageContent() {
		return memberMessageContent;
	}
	public void setMemberMessageContent(String memberMessageContent) {
		this.memberMessageContent = memberMessageContent;
	}
	public Date getMemberMessageDate() {
		return memberMessageDate;
	}
	public void setMemberMessageDate(Date memberMessageDate) {
		this.memberMessageDate = memberMessageDate;
	}
	 
}