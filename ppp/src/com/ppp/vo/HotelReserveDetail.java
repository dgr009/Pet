package com.ppp.vo;

import java.sql.Date;

public class HotelReserveDetail {
	int reserveHotelNo;
	int memberNo;
	int hotelNo;
	int roomNo;
	String animalkind;
	float animalWeight;
	String animalName;
	Date checkIn;
	Date checkOut;
	int reserveHotelPrice;
	
	
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public int getReserveHotelNo() {
		return reserveHotelNo;
	}
	public void setReserveHotelNo(int reserveHotelNo) {
		this.reserveHotelNo = reserveHotelNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getHotelNo() {
		return hotelNo;
	}
	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getAnimalkind() {
		return animalkind;
	}
	public void setAnimalkind(String animalkind) {
		this.animalkind = animalkind;
	}
	public float getAnimalWeight() {
		return animalWeight;
	}
	public void setAnimalWeight(float animalWeight) {
		this.animalWeight = animalWeight;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public int getReserveHotelPrice() {
		return reserveHotelPrice;
	}
	public void setReserveHotelPrice(int reserveHotelPrice) {
		this.reserveHotelPrice = reserveHotelPrice;
	}
	
}
