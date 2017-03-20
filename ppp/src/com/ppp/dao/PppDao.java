package com.ppp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.ppp.util.JdbcUtil;
import com.ppp.vo.Admin;
import com.ppp.vo.Member;
import com.ppp.vo.Message;

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
	
	//관리자 최대번호 조회
	public int selectAdminNoMax(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql.adminNoMax);
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		} return -1;
	}
	
	//관리자 추가
	public int insertAdmin(Connection conn,Admin a){
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(Sql.insertAdmin);
			pstmt.setInt(1, a.getAdminNo());
			pstmt.setString(2, a.getAdminId());
			pstmt.setString(3, a.getAdminPwd());
			pstmt.setString(4, a.getAdminName());
			pstmt.setString(5, a.getAdminMail());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(pstmt,null);
		}
		return -1;
	}
	// 관리자 아이디 중복확인
	public int adminIdCheck(Connection conn, Admin a){
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			pstmt=conn.prepareStatement(Sql.adminidCheck);
			pstmt.setString(1, a.getAdminId());
			rs=pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt,rs);
		}
		return -1;
	}
	// 관리자 쪽지 추가 (보내기)
	public int insertMessage(Connection conn, Message m){
		PreparedStatement pstmt =null;
		try {
			pstmt=conn.prepareStatement(Sql.insertMessage);
			pstmt.setInt(1, m.getMessageNo());
			pstmt.setString(2, m.getMessageTitle());
			pstmt.setString(3, m.getMessageContent());
			pstmt.setDate(4, m.getMessageDate());
			pstmt.setInt(5, m.getAdminNo());
			pstmt.setInt(6, m.getMemberNo());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt,null);
		}
		return  -1;
	}
	// 회원정보 조회 기본
	private Member basicMember(ResultSet rs) throws SQLException{
		Member m = new Member();
		m.setMemberNo(rs.getInt("memberNo"));
		m.setMemberId(rs.getString("memberId"));
		m.setMemberAddress(rs.getString("memberAddress"));
		m.setMemberPhone(rs.getString("memberPhone"));
		m.setMemberGender(rs.getString("memberGender"));
		m.setMemberName(rs.getString("memberName"));
		m.setMemberMail(rs.getString("memberMail"));
		m.setMemberCoupon(rs.getInt("memberCoupon"));
		return m;
	}
	
	// 회원정보 조회
	public ArrayList<Member> selectAllMember(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			pstmt=conn.prepareStatement(Sql.allMember);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(basicMember(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt,rs);
		} return null;
	}
	
	// 아이디로 회원정보 조회
	public Member selectMemberById(Connection conn, String memberId){
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql.findMemberId);
			pstmt.setString(1, memberId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				return basicMember(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		}return null;
	}
	
	// 회원 쿠폰수 조회
	public ArrayList<Member> selectMemberByCoupon(Connection conn, int memberCoupon){
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			pstmt=conn.prepareStatement(Sql.memberCoupon);
			pstmt.setInt(1, memberCoupon);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(basicMember(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}
	
	// 회원 쿠폰수 수정
	public int updateMemberCoupon(Connection conn, int memberNo){
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(Sql.updateMemberCoupon);
			pstmt.setInt(1, memberNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}
	
	
	
}
