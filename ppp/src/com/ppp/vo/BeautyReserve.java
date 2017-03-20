package com.ppp.vo;

import java.sql.Date;

public class BeautyReserve {
	int beautyNo;
	int memberNo;
	int reserveBeautyNo;
	Date reserveBeautyDate;
	public int getBeautyNo() {
		return beautyNo;
	}
	public void setBeautyNo(int beautyNo) {
		this.beautyNo = beautyNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getReserveBeautyNo() {
		return reserveBeautyNo;
	}
	public void setReserveBeautyNo(int reserveBeautyNo) {
		this.reserveBeautyNo = reserveBeautyNo;
	}
	public Date getReserveBeautyDate() {
		return reserveBeautyDate;
	}
	public void setReserveBeautyDate(Date reserveBeautyDate) {
		this.reserveBeautyDate = reserveBeautyDate;
	}
	
}
