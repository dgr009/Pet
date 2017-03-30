package com.ppp.util;

import java.io.*;
import java.sql.*;

import java.util.*;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

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
	
	// 메세지 가져오기
	public static Message getSendMessge(HttpServletRequest req, int adminNo , int messageNo){
		Message m = new Message();
		java.util.Date d = new java.util.Date();
	    java.sql.Date date = new java.sql.Date(d.getTime());  
		m.setAdminNo(adminNo);
		m.setMessageNo(messageNo);
		m.setMessageTitle(req.getParameter("message_title"));
		m.setMessageContent(req.getParameter("message_content"));
		m.setMessageDate(date);
		m.setMemberNo(Integer.parseInt(req.getParameter("member_no")));
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
		java.sql.Date date = null;
		String path = req.getServletContext().getRealPath("hotels/hotelimg");
		DiskFileItemFactory f = new DiskFileItemFactory();
		ServletFileUpload uploader = new ServletFileUpload(f);
		uploader.setFileSizeMax(1024 * 1024 * 10);
		List<FileItem> list;

		try {
			list = uploader.parseRequest(req);
			for (FileItem item : list) {
				
				if(item.isFormField()) {
					if(item.getFieldName().equals("orner_id")){
						h.setHotelId(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_pwd")){
						h.setHotelPwd(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_name")){
						h.setHotelOrnerName(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_address")){
						h.setHotelAddress(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("business_name")){
						h.setHotelName(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_no")){
						h.setHotelOrnerNo(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_mail")){
						h.setHotelMail(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_phone")){
						h.setHotelPhone(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_active")){
						h.setHotelActive(Integer.parseInt(item.getString("UTF-8")));
						if (h.getHotelActive() == 2) {
							java.util.Date d = new java.util.Date();
							date = new java.sql.Date(d.getTime());
						}
						h.setHotelActiveDate(date);
					}else if(item.getFieldName().equals("orner_adminno")){
						h.setAdminNo(Integer.parseInt(item.getString("UTF-8")));
					}else if(item.getFieldName().equals("score")){
						h.setHotelScore(Integer.parseInt(item.getString("UTF-8")));
					}else if(item.getFieldName().equals("count_review")){
						h.setCountReview(Integer.parseInt(item.getString("UTF-8")));
					}
					
				}else{
					String fileName = item.getName();
					// System.out.println(item.getName());
					int indexOfPoint = fileName.indexOf(".");
					// System.out.println(fileName.indexOf("."));
					String fName = fileName.substring(0, indexOfPoint);
					String ext = fileName.substring(indexOfPoint + 1);
					fileName = fName + "-" + System.nanoTime() + "." + ext;
					item.write(new File(path + "\\" + fileName));
					System.out.println(path + "\\" + fileName);
					h.setHotelPhoto(fileName);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
	}

	// 병원 만들기
	public static Hospital getHospitalFromRequest(HttpServletRequest req, int hospitalNo) {
		Hospital h = new Hospital();

		h.setHospitalNo(hospitalNo);
		java.sql.Date date = null;
		String path = req.getServletContext().getRealPath("hospitals/hospitalimg");
		DiskFileItemFactory f = new DiskFileItemFactory();
		ServletFileUpload uploader = new ServletFileUpload(f);
		uploader.setFileSizeMax(1024 * 1024 * 10);
		List<FileItem> list;

		try {
			list = uploader.parseRequest(req);
			for (FileItem item : list) {
				
				if(item.isFormField()) {
					if(item.getFieldName().equals("orner_id")){
						h.setHospitalId(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_pwd")){
						h.setHospitalPwd(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_name")){
						h.setHospitalOrnerName(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_address")){
						h.setHospitalAddress(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("business_name")){
						h.setHospitalName(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_no")){
						h.setHospitalOrnerNo(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_mail")){
						h.setHospitalMail(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_phone")){
						h.setHospitalPhone(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_active")){
						h.setHospitalActive(Integer.parseInt(item.getString("UTF-8")));
						if (h.getHospitalActive() == 2) {
							java.util.Date d = new java.util.Date();
							date = new java.sql.Date(d.getTime());
						}
						h.setHospitalActiveDate(date);
					}else if(item.getFieldName().equals("orner_adminno")){
						h.setAdminNo(Integer.parseInt(item.getString("UTF-8")));
					}else if(item.getFieldName().equals("score")){
						h.setHospitalScore(Integer.parseInt(item.getString("UTF-8")));
					}else if(item.getFieldName().equals("count_review")){
						h.setCountReview(Integer.parseInt(item.getString("UTF-8")));
					}
				}else{
					String fileName = item.getName();
					// System.out.println(item.getName());
					int indexOfPoint = fileName.indexOf(".");
					// System.out.println(fileName.indexOf("."));
					String fName = fileName.substring(0, indexOfPoint);
					String ext = fileName.substring(indexOfPoint + 1);
					fileName = fName + "-" + System.nanoTime() + "." + ext;
					item.write(new File(path + "\\" + fileName));
					System.out.println(path + "\\" + fileName);
					h.setHospitalPhoto(fileName);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
	}

	// 미용 만들기
	public static Beauty getBeautyFromRequest(HttpServletRequest req, int beautyNo) {
		Beauty b = new Beauty();

		b.setBeautyNo(beautyNo);
		java.sql.Date date = null;
		String path = req.getServletContext().getRealPath("beauties/beautyimg");
		DiskFileItemFactory f = new DiskFileItemFactory();
		ServletFileUpload uploader = new ServletFileUpload(f);
		uploader.setFileSizeMax(1024 * 1024 * 10);
		List<FileItem> list;

		try {
			list = uploader.parseRequest(req);
			for (FileItem item : list) {
				
				if(item.isFormField()) {
					if(item.getFieldName().equals("orner_id")){
						b.setBeautyId(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_pwd")){
						b.setBeautyPwd(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_name")){
						b.setBeautyOrnerName(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_address")){
						b.setBeautyAddress(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("business_name")){
						b.setBeautyName(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_no")){
						b.setBeautyOrnerNo(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_mail")){
						b.setBeautyMail(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_phone")){
						b.setBeautyPhone(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("orner_active")){
						b.setBeautyActive(Integer.parseInt(item.getString("UTF-8")));
						if (b.getBeautyActive() == 2) {
							java.util.Date d = new java.util.Date();
							date = new java.sql.Date(d.getTime());
						}
						b.setBeautyActiveDate(date);
					}else if(item.getFieldName().equals("orner_adminno")){
						b.setAdminNo(Integer.parseInt(item.getString("UTF-8")));
					}else if(item.getFieldName().equals("score")){
						b.setBeautyScore(Integer.parseInt(item.getString("UTF-8")));
					}else if(item.getFieldName().equals("count_review")){
						b.setCountReview(Integer.parseInt(item.getString("UTF-8")));
					}
				}else{
					String fileName = item.getName();
					// System.out.println(item.getName());
					int indexOfPoint = fileName.indexOf(".");
					// System.out.println(fileName.indexOf("."));
					String fName = fileName.substring(0, indexOfPoint);
					String ext = fileName.substring(indexOfPoint + 1);
					fileName = fName + "-" + System.nanoTime() + "." + ext;
					item.write(new File(path + "\\" + fileName));
					System.out.println(path + "\\" + fileName);
					b.setBeautyPhoto(fileName);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	// 쪽지 
	public static Message getMessageFromRequest(HttpServletRequest req, int messageNo){
		java.util.Date d = new java.util.Date();
	     java.sql.Date date = new java.sql.Date(d.getTime());
		Message m = new Message();
		m.setMessageNo(messageNo);
		m.setMemberNo(Integer.parseInt(req.getParameter("member_no")));
		m.setMessageTitle(req.getParameter("message_title"));
		m.setMessageContent(req.getParameter("message_content"));
		m.setMessageDate(date);
		return m;
	}

	// 방 추가하기
	public static Room getRoomFromRequest(HttpServletRequest req, int roomNo, int hotelNo) {
		Room r = new Room();
		r.setHotelNo(hotelNo);
		r.setRoomNo(roomNo);
		
		String path = req.getServletContext().getRealPath("hotels/roomimg");
		DiskFileItemFactory f = new DiskFileItemFactory();
		ServletFileUpload uploader = new ServletFileUpload(f);
		uploader.setFileSizeMax(1024 * 1024 * 10);
		List<FileItem> list;

		try {
			list = uploader.parseRequest(req);
			for (FileItem item : list) {
				
				if(item.isFormField()) {
					if(item.getFieldName().equals("room_kind")){
						r.setRoomKind(item.getString("UTF-8"));
					}else if(item.getFieldName().equals("room_price")){
						r.setRoomPrice(Integer.parseInt(item.getString("UTF-8")));
					}
				}else{
					String fileName = item.getName();
					// System.out.println(item.getName());
					int indexOfPoint = fileName.indexOf(".");
					// System.out.println(fileName.indexOf("."));
					String fName = fileName.substring(0, indexOfPoint);
					String ext = fileName.substring(indexOfPoint + 1);
					fileName = fName + "-" + System.nanoTime() + "." + ext;
					item.write(new File(path + "\\" + fileName));
					System.out.println(path + "\\" + fileName);
					r.setRoomPhoto(fileName);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	// 미용사 추가하기
		public static Beautician getBeauticianFromRequest(HttpServletRequest req, int beauticianNo, int beautyNo) {
			Beautician b = new Beautician();
			b.setBeauticianNo(beauticianNo);
			b.setBeautyNo(beautyNo);
			
			String path = req.getServletContext().getRealPath("beauties/beauticianimg");
			DiskFileItemFactory f = new DiskFileItemFactory();
			ServletFileUpload uploader = new ServletFileUpload(f);
			uploader.setFileSizeMax(1024 * 1024 * 10);
			List<FileItem> list;

			try {
				list = uploader.parseRequest(req);
				for (FileItem item : list) {
					
					if(item.isFormField()) {
						if(item.getFieldName().equals("beautician_name")){
							b.setBeauticianName(item.getString("UTF-8"));
						}else if(item.getFieldName().equals("beautician_introduce")){
							b.setBeauticianIntroduce(item.getString("UTF-8"));
						}
					}else{
						String fileName = item.getName();
						// System.out.println(item.getName());
						int indexOfPoint = fileName.indexOf(".");
						// System.out.println(fileName.indexOf("."));
						String fName = fileName.substring(0, indexOfPoint);
						String ext = fileName.substring(indexOfPoint + 1);
						fileName = fName + "-" + System.nanoTime() + "." + ext;
						item.write(new File(path + "\\" + fileName));
						System.out.println(path + "\\" + fileName);
						b.setBeauticianPhoto(fileName);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;
		}
}
