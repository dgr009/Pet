package com.ppp.service;

import java.sql.*;
import java.util.*;

import javax.servlet.http.*;

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
		Member result = null; 
		result = dao.memberLogin(conn,member); 
	
		JdbcUtil.close(conn);
		return result;
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
		if(result==1) ob.addProperty("result", "success");
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

	//일반회원 애완동물 수정(변경) 하기
	public Object animalUpdate(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("member");
		int memberNo = m.getMemberNo();
		int animalNo = Integer.parseInt(req.getParameter("animal_no"));
		Animal a = MappingUtil.getAnimalFromRequest(req, animalNo, memberNo);
		int result = dao.animalUpdate(conn,a);
		JsonObject ob = new JsonObject();
		if(result==1) ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		JdbcUtil.close(conn);

		return new Gson().toJson(ob);
		
	}

	
}
