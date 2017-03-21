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
	public int memberLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> member = new HashMap<>();
		member.put("member_id", req.getParameter("member_id"));
		member.put("member_pwd", req.getParameter("member_pwd"));
		int result = 0; 
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
}
