package com.ppp.dao;

import java.sql.*;

import com.ppp.util.*;
import com.ppp.vo.*;

public class PppDao {
	
	public int selectMemberNoMax(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.memberNoMax);
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}
	public int selectCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.allArticle);
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;		
	}
	public int memberInsert(Connection conn, Member mem) {
		PreparedStatement pstmt = null;
		try {
			
			pstmt = conn.prepareStatement(Sql.insertMember);
			pstmt.setInt(1, mem.getMemberNo());
			pstmt.setString(2, mem.getMemberAddress());
			pstmt.setString(3,	mem.getMemberId());
			pstmt.setString(4, mem.getMemberPwd());
			pstmt.setString(5, mem.getMemberGender());
			pstmt.setString(6, mem.getMemberPhone());
			pstmt.setString(7, mem.getMemberName());
			pstmt.setString(8, mem.getMemberMail());
			pstmt.setInt(9, mem.getMemberCoupon());
			pstmt.setInt(10, mem.getMemberActive());
			pstmt.setDate(11, mem.getMemberActiveDate());
			pstmt.setInt(12, mem.getAdminNo());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return 0;
	}
	public int memberUpdate(Connection conn, Member mem) {
		return -1;
	}
}
