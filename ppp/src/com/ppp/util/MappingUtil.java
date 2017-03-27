package com.ppp.util;

import java.sql.*;
import java.text.SimpleDateFormat;

import javax.servlet.http.*;

import com.ppp.vo.*;

public class MappingUtil {
	// rs로 회원 만들기
	public static Member getMemberFromResultSet(ResultSet rs) throws SQLException {
		Member m = new Member();

		m.setMemberNo(rs.getInt("member_no"));
		m.setMemberAddress(rs.getString("member_address"));
		m.setMemberId(rs.getString("member_id"));
		m.setMemberPwd(rs.getString("member_pwd"));
		m.setMemberGender(rs.getString("member_gender"));
		m.setMemberPhone(rs.getString("member_phone"));
		m.setMemberName(rs.getString("member_name"));
		m.setMemberMail(rs.getString("member_mail"));
		m.setMemberCoupon(rs.getInt("member_coupon"));

		return m;
	}

	// req 로 회원만들기
	public static Member getMemberFromRequest(HttpServletRequest req, int memberNo) {
		Member m = new Member();

		m.setMemberNo(memberNo);
		m.setMemberAddress(req.getParameter("member_address"));
		m.setMemberId(req.getParameter("member_id"));
		m.setMemberPwd(req.getParameter("member_pwd"));
		m.setMemberGender(req.getParameter("member_gender"));
		m.setMemberPhone(req.getParameter("member_phone"));
		m.setMemberName(req.getParameter("member_name"));
		m.setMemberMail(req.getParameter("member_mail"));
		m.setMemberCoupon(Integer.parseInt(req.getParameter("member_coupon")));
		m.setMemberActive(Integer.parseInt(req.getParameter("member_active")));
		java.sql.Date date = null;
		if (Integer.parseInt(req.getParameter("member_active")) == 2) {
			java.util.Date d = new java.util.Date();
			date = new java.sql.Date(d.getTime());
		}
		m.setMemberActiveDate(date);
		m.setAdminNo(Integer.parseInt(req.getParameter("member_adminno")));

		return m;
	}

	// 관리자 만들기
	public static Admin getAdminFromRequest(HttpServletRequest req, int adminNo) {
		Admin a = new Admin();

		a.setAdminNo(adminNo);
		a.setAdminId(req.getParameter("admin_id"));
		a.setAdminPwd(req.getParameter("admin_pwd"));
		a.setAdminName(req.getParameter("admin_name"));
		a.setAdminMail(req.getParameter("admin_mail"));

		return a;
	}
	
	public static Message getSendMessge(HttpServletRequest req, int adminNo , int messageNo){
		Message m = new Message();
		java.util.Date d = new java.util.Date();
	    java.sql.Date date = new java.sql.Date(d.getTime());  
		m.setAdminNo(adminNo);
		m.setMessageNo(messageNo);
		m.setMessageTitle(req.getParameter("message_title"));
		m.setMessageContent(req.getParameter("message_content"));
		m.setMessageDate(date);
		m.setMemberNo(Integer.parseInt(req.getParameter("memeber_no")));
		return m;
	}

	// 애완 동물 만들기
	public static Animal getAnimalFromRequest(HttpServletRequest req, int animalNo, int memberNo) {
		Animal a = new Animal();
		a.setMemberNo(memberNo);
		a.setAnimalNo(animalNo);
		a.setAnimalBreed(req.getParameter("animal_breed"));
		a.setAnimalGender(req.getParameter("animal_gender"));
		a.setAnimalKind(req.getParameter("animal_kind"));
		a.setAnimalName(req.getParameter("animal_name"));
		a.setAnimalWeight(Float.parseFloat(req.getParameter("animal_weight")));

		return a;
	}

	// 호텔 만들기
	public static Hotel getHotelFromRequest(HttpServletRequest req, int hotelNo) {
		Hotel h = new Hotel();
		h.setHotelNo(hotelNo);
		h.setHotelId(req.getParameter("hotel_id"));
		h.setHotelPwd(req.getParameter("hotel_pwd"));
		h.setHotelName(req.getParameter("hotel_name"));
		h.setHotelAddress(req.getParameter("hotel_address"));
		h.setHotelOrnerName(req.getParameter("hotel_orner_name"));
		h.setHotelOrnerNo(req.getParameter("hotel_orner_no"));
		h.setHotelMail(req.getParameter("hotel_mail"));
		h.setHotelPhone(req.getParameter("hotel_phone"));
		h.setHotelPhoto(req.getParameter("hotel_photo"));
		h.setHotelActive(Integer.parseInt(req.getParameter("hotel_active")));
		java.sql.Date date = null;
		if (Integer.parseInt(req.getParameter("hotel_active")) == 2) {
			java.util.Date d = new java.util.Date();
			date = new java.sql.Date(d.getTime());
		}
		h.setHotelActiveDate(date);
		h.setAdminNo(Integer.parseInt(req.getParameter("hotel_adminno")));
		return h;
	}

	// 병원 만들기
	public static Hospital getHospitalFromRequest(HttpServletRequest req, int hospitalNo) {
		Hospital h = new Hospital();
		h.setHospitalNo(hospitalNo);
		h.setHospitalId(req.getParameter("hospital_id"));
		h.setHospitalPwd(req.getParameter("hospital_pwd"));
		h.setHospitalName(req.getParameter("hospital_name"));
		h.setHospitalAddress(req.getParameter("hospital_address"));
		h.setHospitalOrnerName(req.getParameter("hospital_orner_name"));
		h.setHospitalOrnerNo(req.getParameter("hospital_orner_no"));
		h.setHospitalMail(req.getParameter("hospital_mail"));
		h.setHospitalPhone(req.getParameter("hospital_phone"));
		h.setHospitalPhoto(req.getParameter("hospital_photo"));
		h.setHospitalActive(Integer.parseInt(req.getParameter("hospital_active")));
		java.sql.Date date = null;
		if (Integer.parseInt(req.getParameter("hospital_active")) == 2) {
			java.util.Date d = new java.util.Date();
			date = new java.sql.Date(d.getTime());
		}
		h.setHospitalActiveDate(date);
		h.setAdminNo(Integer.parseInt(req.getParameter("hospital_adminno")));
		return h;
	}

	// 미용 만들기
	public static Beauty getBeautyFromRequest(HttpServletRequest req, int beautyNo) {
		Beauty b = new Beauty();
		b.setBeautyNo(beautyNo);
		b.setBeautyId(req.getParameter("beauty_id"));
		b.setBeautyPwd(req.getParameter("beauty_pwd"));
		b.setBeautyName(req.getParameter("beauty_name"));
		b.setBeautyAddress(req.getParameter("beauty_address"));
		b.setBeautyOrnerName(req.getParameter("beauty_orner_name"));
		b.setBeautyOrnerNo(req.getParameter("beauty_orner_no"));
		b.setBeautyMail(req.getParameter("beauty_mail"));
		b.setBeautyPhone(req.getParameter("beauty_phone"));
		b.setBeautyPhoto(req.getParameter("beauty_photo"));
		b.setBeautyActive(Integer.parseInt(req.getParameter("beauty_active")));
		java.sql.Date date = null;
		if (Integer.parseInt(req.getParameter("beauty_active")) == 2) {
			java.util.Date d = new java.util.Date();
			date = new java.sql.Date(d.getTime());
		}
		b.setBeautyActiveDate(date);
		b.setAdminNo(Integer.parseInt(req.getParameter("beauty_adminno")));
		return b;
	}
}
