package com.pet.service;

import java.sql.*;

import javax.servlet.http.*;

import com.google.gson.*;
import com.pet.util.*;
import com.ppp.dao.*;
import com.ppp.vo.*;

public class Service {
	private MemberDao dao;
	public Service(MemberDao dao) {
		this.dao = dao;
	}
	
	public String createEnd(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int memberNo = dao.selectMemberNoMax(conn);
		Member mem = MappingUtil.getMemberFromRequest(req, memberNo);
		int result = dao.insert(conn, mem);
		JsonObject ob = new JsonObject();
		if(result==1) ob.addProperty("result", "success");
		else ob.addProperty("result", "fail");
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}
}
