package com.ppp.dao;

import java.sql.*;
import java.util.*;

import com.ppp.util.*;
import com.ppp.vo.*;

public class PppDao {
	//일반회원 번호 마지막 찾기
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
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	//일반 회원 등록(추가)
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
			pstmt.setInt(10, mem.getAdminNo());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return 0;
	}

	//일반 회원 로그인
	public int memberLogin(Connection conn, HashMap<String, String> member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(Sql.memberLogin);
			pstmt.setString(1,member.get("member_id"));
			pstmt.setString(2,member.get("member_pwd"));
			
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		}

		return 0;
	}
	
	//관리자 마지막번호 찾기
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
	//회원 비활성화
	public int InactiveMember(Connection conn, int memberNo){
		PreparedStatement pstmt =null;
		try {
			pstmt=conn.prepareStatement(Sql.inactiveMember);
			pstmt.setInt(1, memberNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		}return -1;
	}
	//비활성화 회원 조회
	public ArrayList<Member> selectInactiveMember(Connection conn, Member m){
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(Sql.allInactiveMember);
			rs=pstmt.executeQuery();
			while(rs.next()){
			list.add(basicMember(rs));
			return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt, rs);
		}return null;
	}
	// 병원 회원 추가
	public int insertHospital(Connection conn, Hospital h){
		PreparedStatement pstmt =null;
		try {
			pstmt = conn.prepareStatement(Sql.insertHospital);
			pstmt.setInt(1, h.getHospitalNo());
			pstmt.setString(2, h.getHospitalName());
			pstmt.setString(3, h.getHospitalOrnerName());
			pstmt.setString(4, h.getHospitalOrnerNo());	
			pstmt.setString(5, h.getHospitalMail());
			pstmt.setString(6, h.getHospitalPhone());
			pstmt.setString(7, h.getHospitalAddress());
			pstmt.setString(8, h.getHospitalId());
			pstmt.setString(9, h.getHospitalPwd());
			pstmt.setString(10, h.getHospitalPhoto());
			pstmt.setInt(11, h.getAdminNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}
	// 병원회원 검색 기본
	public Hospital basicHospital(ResultSet rs) throws SQLException{
		Hospital h = new Hospital();
		h.setHospitalNo(rs.getInt("hospitalNo"));
		h.setHospitalName(rs.getString("hospitalName"));
		h.setHospitalOrnerName(rs.getString("hospitalOrnerName"));
		h.setHospitalOrnerNo(rs.getString("hospitalOrnerNo"));
		h.setHospitalMail(rs.getString("hospitalMail"));
		h.setHospitalAddress(rs.getString("hospitalAddress"));
		h.setHospitalPhone(rs.getString("hospitalPhone"));
		return h;
	}
	// 병원 전체 리스트 조회
	public ArrayList<Hospital> selectAllHospital(Connection conn, Hospital h){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hospital> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.allHospital);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(basicHospital(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		}
		return null;
	}
	// 아이디로 병원 회원 검색
	public Hospital selectHospitalById(Connection conn, String hospitalId){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(Sql.findHospitalId);
			pstmt.setString(1, hospitalId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				return basicHospital(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		}return null;
	}
	//병원 비활성화
	public int inactiveHospital(Connection conn, int hospitalNo){
		PreparedStatement pstmt =null;
		try {
			pstmt=conn.prepareStatement(Sql.inactiveHospital);
			pstmt.setInt(1, hospitalNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		}return -1;
	}
	//비활성화 된 병원 조회
	public ArrayList<Hospital> selectInactiveHospital(Connection conn, Hospital h){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hospital> list = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(Sql.allInactiveHospital);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(basicHospital(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, rs);
		}return null;
	}
	// 미용실회원 검색 기본
	public Beauty basicBeauty(ResultSet rs) throws SQLException{
		Beauty b = new Beauty();
		b.setBeautyNo(rs.getInt("beautyNo"));
		b.setBeautyName(rs.getString("beautyName"));
		b.setBeautyOrnerName(rs.getString("beautyOrnerName"));
		b.setBeautyOrnerNo(rs.getString("beautyOrnerNo"));
		b.setBeautyMail(rs.getString("beautyMail"));
		b.setBeautyAddress(rs.getString("beautyAddress"));
		b.setBeautyPhone(rs.getString("beautyPhone"));
		return b;
	}
	// 미용실회원 비활성화
	public int inactiveBeauty(Connection conn, int beautyNo){
		PreparedStatement pstmt =null;
		try {
			pstmt = conn.prepareStatement(Sql.inactiveBeauty);
			pstmt.setInt(1, beautyNo);
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		}return -1;
	}
	// 비활성화 된 미용실 회원 조회
	public ArrayList<Beauty> selectInactiveBeauty(Connection conn, Beauty b){
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		ArrayList<Beauty> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.allInactiveBeauty);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicBeauty(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		}return null;
	}
	// 호텔회원 검색 기본
	public Hotel basicHotel(ResultSet rs) throws SQLException{
		Hotel h = new Hotel();
		h.setHotelNo(rs.getInt("hotelNo"));
		h.setHotelName(rs.getString("hotelName"));
		h.setHotelOrnerName(rs.getString("hotelOrnerName"));
		h.setHotelOrnerNo(rs.getString("hotelOrnerNo"));
		h.setHotelMail(rs.getString("hotelMail"));
		h.setHotelAddress(rs.getString("hotelAddress"));
		h.setHotelPhone(rs.getString("hotelPhone"));
		return h;
	}
	
	// 호텔회원 비활성화
	public int inactiveHotel(Connection conn, int hotelNo){
		PreparedStatement pstmt =null;
		try {
			pstmt= conn.prepareStatement(Sql.inactiveHotel);
			pstmt.setInt(1, hotelNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		}return -1;
	}
	// 비활성화 된 호텔회원 조회
	public ArrayList<Hotel> selectInactiveHotel(Connection conn, Hotel h){
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		ArrayList<Hotel> list = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(Sql.allInactiveHotel);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(basicHotel(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		}return null;
	}
	// 관리자 삭제
	public int deleteAdmin(Connection conn, int adminNo){
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(Sql.deleteAdmin);
			pstmt.setInt(1, adminNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		}return -1;
	}
	
	// 회원삭제
	public int deleteMember(Connection conn, int memberNo){
		PreparedStatement pstmt = null;
		try {
			pstmt= conn.prepareStatement(Sql.deleteMember);
			pstmt.setInt(1, memberNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 병원회원 삭제
	public int deleteHospital(Connection conn, int hospitalNo){
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(Sql.deleteHospital);
			pstmt.setInt(1, hospitalNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		}return -1;
	}
	// 미용실회원 삭제
	public int deleteBeauty(Connection conn, int beautyNo){
		PreparedStatement pstmt =null;
		try {
			pstmt=conn.prepareStatement(Sql.deleteBeauty);
			pstmt.setInt(1, beautyNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		}return -1;
	}
	// 호텔회원 삭제
	public int deleteHotel(Connection conn, int hotelNo){
		PreparedStatement pstmt = null;
		try {
			pstmt= conn.prepareStatement(Sql.deleteHotel);
			pstmt.setInt(1, hotelNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		}return -1;
	}
	// 자유게시판 게시글 삭제
	public int deleteFreeBoard(Connection conn, int freeBoardNo){
		PreparedStatement pstmt =null;
		try {
			pstmt=conn.prepareStatement(Sql.deleteFreeBoard);
			pstmt.setInt(1, freeBoardNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		}return -1;
	}
	// 병원회원 아이디 중복체크
	public int hospitalIdCheck(Connection conn, String hospitalId){
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			pstmt = conn.prepareStatement(Sql.hospitalIdCheck);
			rs= pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		} return -1;
	}

}













