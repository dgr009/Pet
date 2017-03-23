package com.ppp.util;

import java.sql.*;

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
		m.setMemberCoupon(Integer.parseInt(req.getParameter("member_coupon")));
		m.setMemberActive(Integer.parseInt(req.getParameter("member_active")));
		java.sql.Date date = null;
		if(Integer.parseInt(req.getParameter("member_active"))==2){
			java.util.Date d = new java.util.Date();
			date = new java.sql.Date(d.getTime());
		}
		m.setMemberActiveDate(date);
		m.setAdminNo(Integer.parseInt(req.getParameter("member_adminno")));

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
}
