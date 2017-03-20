package com.ppp.vo;

import java.sql.Date;

public class HospitalReserve {
	int hospitalNo;
	int reserveHospitalNo;
	Date reserveHospitalDate;
	int memberNo;
	public int getHospitalNo() {
		return hospitalNo;
	}
	public void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	public int getReserveHospitalNo() {
		return reserveHospitalNo;
	}
	public void setReserveHospitalNo(int reserveHospitalNo) {
		this.reserveHospitalNo = reserveHospitalNo;
	}
	public Date getReserveHospitalDate() {
		return reserveHospitalDate;
	}
	public void setReserveHospitalDate(Date reserveHospitalDate) {
		this.reserveHospitalDate = reserveHospitalDate;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
}
