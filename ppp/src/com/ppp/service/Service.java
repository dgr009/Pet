package com.ppp.service;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

import com.google.gson.*;
import com.ppp.dao.*;
import com.ppp.util.*;
import com.ppp.vo.*;

public class Service {
	private PppDao dao;
	public Service(PppDao dao) {
		this.dao = dao;
	}
	
	//일반회원 등록
	public String memberCreateEnd(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int memberNo = dao.selectMemberNoMax(conn);
		Member member = MappingUtil.getMemberFromRequest(req, memberNo);
		int result = dao.memberInsert(conn, member);
		JsonObject ob = new JsonObject();
		if(result==1) ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	//일반회원 로그인
	public Member memberLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> member = new HashMap<>();
		member.put("member_id", req.getParameter("member_id"));
		member.put("member_pwd", req.getParameter("member_pwd"));
		Member result = dao.memberLogin(conn,member); 
		HttpSession session = req.getSession();
		ArrayList<Animal> animallist = animalSelectLogin(req);
		if(result.getMemberId()==null){
			System.out.println("아이디나 비밀번호 확인필요");
			session.setAttribute("logincheck", "아이디나 비밀번호 확인필요");
			JdbcUtil.close(conn);
			return null;
		} else {
			System.out.println("로그인 성공");
			session.removeAttribute("logincheck");
			session.setAttribute("member", result);
			session.setAttribute("animallist", animallist);
			session.setAttribute("animallistgson", new Gson().toJson(animallist));
			JdbcUtil.close(conn);
			return result;
		}
	}
	
	//관리자 추가
	public String adminCreateEnd(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int adminNo = dao.selectAdminNoMax(conn);
		Admin admin = MappingUtil.getAdminFromRequest(req, adminNo);
		int result = dao.insertAdmin(conn, admin);
		JsonObject ob = new JsonObject();
		if(result==1) ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	//관리자 로그인
	public int adminLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> admin = new HashMap<>();
		admin.put("member_id", req.getParameter("admin_id"));
		admin.put("member_pwd", req.getParameter("admin_pwd"));
		int result = 0; 
		result = dao.adminLogin(conn,admin); 
	
		JdbcUtil.close(conn);
		return result;
	}

	//일반회원 아이디찾기
	public String memberIdSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> member = new HashMap<>();
		member.put("member_mail", req.getParameter("member_mail"));
		member.put("member_name", req.getParameter("member_name"));
		JsonObject ob = new JsonObject();
		ob.addProperty("result", dao.memberIdCheck(conn, member));
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	//일반회원 비밀번호 찾기
	public String memberPwdSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> member = new HashMap<>();
		member.put("member_id", req.getParameter("member_id"));
		member.put("member_mail", req.getParameter("member_mail"));
		member.put("member_name", req.getParameter("member_name"));
		JsonObject ob = new JsonObject();
		ob.addProperty("result", dao.memberPwdCheck(conn, member));
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);

	}

	//일반회원 정보수정
	public String memberUpdate(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int memberNo = Integer.parseInt(req.getParameter("member_no"));
		Member m = MappingUtil.getMemberFromRequest(req, memberNo);
		HttpSession session = req.getSession();
		session.setAttribute("member", m);
		int result = dao.memberUpdate(conn, m);
		JsonObject ob = new JsonObject();
		if(result==1) ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	//로그인시 애완 동물 리스트 불러오기
	public ArrayList<Animal> animalSelectLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> member = new HashMap<>();
		member.put("member_id", req.getParameter("member_id"));
		member.put("member_pwd", req.getParameter("member_pwd"));
		Member m = dao.memberLogin(conn, member);
		
		ArrayList<Animal> result = dao.animalList(conn,m.getMemberNo()); 
		JdbcUtil.close(conn);
		return result;
	}

	//애완 동물 추가하기
	public String animalInsert(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("member");
		int memberNo = m.getMemberNo();
		int animalNo = dao.animalMaxNo(conn,memberNo);
		Animal a = MappingUtil.getAnimalFromRequest(req,animalNo,memberNo);
		int result = dao.animalInsert(conn,a);
		JsonObject ob = new JsonObject();
		if(result==1){
			ob.addProperty("result", "success");
			ArrayList<Animal> animallist = animalSelect(req);
			session.setAttribute("animallist", animallist);
			session.setAttribute("animallistgson", new Gson().toJson(animallist));
		}
		else ob.addProperty("result", "fail");
		JdbcUtil.close(conn);

		return new Gson().toJson(ob);
	}
	
	//개인정보 애완 동물 리스트 불러오기
	public ArrayList<Animal> animalSelect(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("member");
		
		ArrayList<Animal> result = dao.animalList(conn,m.getMemberNo()); 
		JdbcUtil.close(conn);
		return result;
	}
	//개인정보 애완 동물 리스트 불러오기 지손(gson)
		public String animalSelectGson(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			HttpSession session = req.getSession();
			Member m = (Member)session.getAttribute("member");
			
			ArrayList<Animal> result = dao.animalList(conn,m.getMemberNo()); 
			JdbcUtil.close(conn);
			return new Gson().toJson(result);
		}

	//일반회원 애완동물 수정(변경) 하기
	public String animalUpdate(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("member");
		int memberNo = m.getMemberNo();
		int animalNo = Integer.parseInt(req.getParameter("animal_no"));
		Animal a = MappingUtil.getAnimalFromRequest(req, animalNo, memberNo);
		int result = dao.animalUpdate(conn,a);
		JsonObject ob = new JsonObject();
		if(result==1){
			ob.addProperty("result", "success");
			ArrayList<Animal> animallist = animalSelect(req);
			session.setAttribute("animallist", animallist);
			session.setAttribute("animallistgson", new Gson().toJson(animallist));
		}
		else ob.addProperty("result", "fail");
		
		JdbcUtil.close(conn);

		return new Gson().toJson(ob);
		
	}

	//애완 동물 정보 가져오기
	public Animal animalView(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("member");
		int memberNo = m.getMemberNo();
		int animalNo = Integer.parseInt(req.getParameter("animal_no"));
		Animal a = dao.animalView(conn,memberNo,animalNo);
		return a;
	}

	//일반회원 로그아웃
	public void memberLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("member");
		session.removeAttribute("animallist");
		session.removeAttribute("animallistgson");
		session.removeAttribute("logincheck");
	}

	
	//일반회원 애완동물 삭제
	public String animalDelete(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("member");
		int memberNo = m.getMemberNo();
		int animalNo = Integer.parseInt(req.getParameter("animal_no"));
		int result = dao.animalDelete(conn,memberNo,animalNo);
		JsonObject ob = new JsonObject();
		ob.addProperty("result", result);
		if(result==1){
			System.out.println("삭제성공");
			ArrayList<Animal> animallist = animalSelect(req);
			session.setAttribute("animallist", animallist);
			session.setAttribute("animallistgson", new Gson().toJson(animallist));
		}else{
		
		}
		
		return new Gson().toJson(ob);
	}

	///////////////////////////////////////
	//호텔 서비스

	//호텔 회원 등록(추가)
	public String hotelCreateEnd(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int hotelNo = dao.selectHotelNoMax(conn);
		Hotel hotel = MappingUtil.getHotelFromRequest(req, hotelNo);
		dao.hotelInsert(conn, hotel);
		JdbcUtil.close(conn);
		return new Gson().toJson(hotel);
	}

	//호텔 로그인
	public Object hotelLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> user = new HashMap<>();
		user.put("user_id", req.getParameter("member_id"));
		user.put("user_pwd", req.getParameter("member_pwd"));
		Hotel result = dao.hotelLogin(conn,user); 
		HttpSession session = req.getSession();
		
		if(result.getHotelId()==null){
			System.out.println("아이디나 비밀번호 확인필요");
			session.setAttribute("logincheck", "아이디나 비밀번호 확인필요");
			JdbcUtil.close(conn);
			return null;
		} else {
			System.out.println("로그인 성공");
			session.removeAttribute("logincheck");
			session.setAttribute("hotel", result);
			JdbcUtil.close(conn);
			return result;
		}
	}

	
	//호텔회원 로그아웃
	public void hotelLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("hotel");
		session.removeAttribute("logincheck");
		
	}

	//일반 회원 받은 메세지(쪽지) 리스트
	public String receiveBoard(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("member");
		ArrayList<Message> list = dao.receiveMessageList(conn,m.getMemberNo());
		JdbcUtil.close(conn);
		return new Gson().toJson(list);
		
	}

	//일반 회원 메세지(쪽지) 삭제
	public String messageDelete(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("member");
		dao.messageDelete(conn,Integer.parseInt(req.getParameter("message_no")),m.getMemberNo());
		ArrayList<Message> list = dao.receiveMessageList(conn,m.getMemberNo());
		JdbcUtil.close(conn);
		return new Gson().toJson(list);

	}
/////////////
	//미용 회원 등록(추가)
		public String beautyCreateEnd(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			int beautyNo = dao.selectBeautyNoMax(conn);
			Beauty beauty = MappingUtil.getBeautyFromRequest(req, beautyNo);
			int result = dao.beautyInsert(conn, beauty);
			JdbcUtil.close(conn);
			return new Gson().toJson(beauty);
		}

		//미용 로그인
		public Object beautyLogin(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			HashMap<String, String> user = new HashMap<>();
			user.put("user_id", req.getParameter("member_id"));
			user.put("user_pwd", req.getParameter("member_pwd"));
			Beauty result = dao.beautyLogin(conn,user); 
			HttpSession session = req.getSession();
			
			if(result.getBeautyId()==null){
				System.out.println("아이디나 비밀번호 확인필요");
				session.setAttribute("logincheck", "아이디나 비밀번호 확인필요");
				JdbcUtil.close(conn);
				return null;
			} else {
				System.out.println("로그인 성공");
				session.removeAttribute("logincheck");
				session.setAttribute("beauty", result);
				JdbcUtil.close(conn);
				return result;
			}
		}

		
		//미용회원 로그아웃
		public void beautyLogout(HttpServletRequest req) {
			HttpSession session = req.getSession();
			session.removeAttribute("beauty");
			session.removeAttribute("logincheck");
			
		}
		//////////////////
		//병원 회원 등록(추가)
		public String hospitalCreateEnd(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			int hospitalNo = dao.selectHospitalNoMax(conn);
			Hospital hospital = MappingUtil.getHospitalFromRequest(req, hospitalNo);
			int result = dao.hospitalInsert(conn, hospital);
			JdbcUtil.close(conn);
			return new Gson().toJson(hospital);
		}

		//병원 로그인
		public Object hospitalLogin(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			HashMap<String, String> user = new HashMap<>();
			user.put("user_id", req.getParameter("member_id"));
			user.put("user_pwd", req.getParameter("member_pwd"));
			Hospital result = dao.hospitalLogin(conn,user); 
			HttpSession session = req.getSession();
			
			if(result.getHospitalId()==null){
				System.out.println("아이디나 비밀번호 확인필요");
				session.setAttribute("logincheck", "아이디나 비밀번호 확인필요");
				JdbcUtil.close(conn);
				return null;
			} else {
				System.out.println("로그인 성공");
				session.removeAttribute("logincheck");
				session.setAttribute("hospital", result);
				JdbcUtil.close(conn);
				return result;
			}
		}

		
		//병원회원 로그아웃
		public void hospitalLogout(HttpServletRequest req) {
			HttpSession session = req.getSession();
			session.removeAttribute("hospital");
			session.removeAttribute("logincheck");
			
		}
	
}
