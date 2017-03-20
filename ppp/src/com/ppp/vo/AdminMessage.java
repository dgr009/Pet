package com.ppp.vo;

import java.sql.Date;

public class AdminMessage {
	   int adminMessageNo;
	   String adminMessageTitle;
	   String adminMessageContent;
	   Date adminMessageDate;
	public int getAdminMessageNo() {
		return adminMessageNo;
	}
	public void setAdminMessageNo(int adminMessageNo) {
		this.adminMessageNo = adminMessageNo;
	}
	public String getAdminMessageTitle() {
		return adminMessageTitle;
	}
	public void setAdminMessageTitle(String adminMessageTitle) {
		this.adminMessageTitle = adminMessageTitle;
	}
	public String getAdminMessageContent() {
		return adminMessageContent;
	}
	public void setAdminMessageContent(String adminMessageContent) {
		this.adminMessageContent = adminMessageContent;
	}
	public Date getAdminMessageDate() {
		return adminMessageDate;
	}
	public void setAdminMessageDate(Date adminMessageDate) {
		this.adminMessageDate = adminMessageDate;
	}
	   
}
