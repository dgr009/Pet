package com.ppp.util;

import java.sql.*;
import java.text.SimpleDateFormat;

import javax.servlet.http.*;

import com.ppp.vo.*;

public class MappingUtil {
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
		m.setMemberCoupon(0);
		m.setMemberActive(1);
		m.setMemberActiveDate(null);
		m.setAdminNo(1);

		return m;
	}

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
}
