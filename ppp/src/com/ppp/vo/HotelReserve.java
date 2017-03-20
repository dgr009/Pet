package com.ppp.vo;

import java.sql.Date;

public class HotelReserve {
	int hotelNo;
	int memberNo;
	int reserveHotelNo;
	Date reserveHotelDate;
	public int getHotelNo() {
		return hotelNo;
	}
	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getReserveHotelNo() {
		return reserveHotelNo;
	}
	public void setReserveHotelNo(int reserveHotelNo) {
		this.reserveHotelNo = reserveHotelNo;
	}
	public Date getReserveHotelDate() {
		return reserveHotelDate;
	}
	public void setReserveHotelDate(Date reserveHotelDate) {
		this.reserveHotelDate = reserveHotelDate;
	}
	
}
