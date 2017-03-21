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
	
	//
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

	public String memberLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> member = new HashMap<>();
		member.put("member_id", req.getParameter("member_id"));
		member.put("member_pwd", req.getParameter("member_pwd"));
		int result = 0; 
		result = dao.memberLogin(conn,member);
		JsonObject ob = new JsonObject();
		if(result==0) ob.addProperty("result", result);
		else ob.addProperty("result", result);
		System.out.println(new Gson().toJson(ob));
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}
}
