package com.ppp.vo;

import java.sql.*;

public class HospitalReserveDetail {
	int reserveHospitalNo;
	int memberNo;
	int hospitalNo;
	String animalKind;
	float aniamlWeight;
	String memberName;
	String memberPhone;
	String vetName;
	String reserveHostpitalTime;
	Date reserveHospitalDate;
	String animalName;

	
	
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getVetName() {
		return vetName;
	}
	public void setVetName(String vetName) {
		this.vetName = vetName;
	}
	public String getReserveHostpitalTime() {
		return reserveHostpitalTime;
	}
	public void setReserveHostpitalTime(String reserveHostpitalTime) {
		this.reserveHostpitalTime = reserveHostpitalTime;
	}
	public Date getReserveHospitalDate() {
		return reserveHospitalDate;
	}
	public void setReserveHospitalDate(Date reserveHospitalDate) {
		this.reserveHospitalDate = reserveHospitalDate;
	}
	public int getReserveHospitalNo() {
		return reserveHospitalNo;
	}
	public void setReserveHospitalNo(int reserveHospitalNo) {
		this.reserveHospitalNo = reserveHospitalNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getHospitalNo() {
		return hospitalNo;
	}
	public void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	public String getAnimalKind() {
		return animalKind;
	}
	public void setAnimalKind(String animalKind) {
		this.animalKind = animalKind;
	}
	public float getAniamlWeight() {
		return aniamlWeight;
	}
	public void setAniamlWeight(float aniamlWeight) {
		this.aniamlWeight = aniamlWeight;
	}
	
}
