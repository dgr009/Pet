package com.ppp.vo;

import java.sql.Date;

public class Member {
	int memberNo;
	String memberId;
	String memberPwd;
	String memberName;
	String memberAddress;
	String memberGender;
	String memberPhone;
	String memberMail;
	int memberCoupon;
	int memberActive;
	Date memberActiveDate;
	int AdminNo;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberMail() {
		return memberMail;
	}
	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}
	public int getMemberCoupon() {
		return memberCoupon;
	}
	public void setMemberCoupon(int memberCoupon) {
		this.memberCoupon = memberCoupon;
	}
	public int getMemberActive() {
		return memberActive;

	}
	public void setMemberActive(int memberActive) {
		this.memberActive = memberActive;
	}
	public Date getMemberActiveDate() {
		return memberActiveDate;
	}
	public void setMemberActiveDate(Date memberActiveDate) {
		this.memberActiveDate = memberActiveDate;
	}
	public int getAdminNo() {
		return AdminNo;
	}
	public void setAdminNo(int adminNo) {
		AdminNo = adminNo;
	}
	

}