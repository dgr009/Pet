package com.ppp.vo;

import java.sql.*;

/* 
 * h.hospital_name,
 * h.hospital_phone,
 * h.hospital_address,
 * v.vet_name,
 * r.RESERVE_HOSPITAL_DATE,
 * r.RESERVE_HOSPITAL_TIME,
 * a.ANIMAL_NAME 
 */
public class HospitalReserveList {
	private int hospitalNo;
	private String hospitalName;
	private String hospitalPhone;
	private String hospitalAddress;
	private String vetName;
	private Date reserveHospitalDate;
	private String reserveHospitalTime;
	private String animalName;
	
	
	public int getHospitalNo() {
		return hospitalNo;
	}
	public void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalPhone() {
		return hospitalPhone;
	}
	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	public String getVetName() {
		return vetName;
	}
	public void setVetName(String vetName) {
		this.vetName = vetName;
	}
	public Date getReserveHospitalDate() {
		return reserveHospitalDate;
	}
	public void setReserveHospitalDate(Date reserveHospitalDate) {
		this.reserveHospitalDate = reserveHospitalDate;
	}
	public String getReserveHospitalTime() {
		return reserveHospitalTime;
	}
	public void setReserveHospitalTime(String reserveHospitalTime) {
		this.reserveHospitalTime = reserveHospitalTime;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	
	
}
