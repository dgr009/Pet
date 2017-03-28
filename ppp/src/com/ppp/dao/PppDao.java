package com.ppp.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.ppp.util.*;

import javax.naming.spi.DirStateFactory.*;

import com.ppp.util.*;
import com.ppp.vo.*;

public class PppDao {
	// 일반회원 번호 마지막 찾기
	public int selectMemberNoMax(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.memberNoMax);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 일반 회원 등록(추가)
	public int memberInsert(Connection conn, Member mem) {
		PreparedStatement pstmt = null;
		try {

			pstmt = conn.prepareStatement(Sql.insertMember);
			pstmt.setInt(1, mem.getMemberNo());
			pstmt.setString(2, mem.getMemberAddress());
			pstmt.setString(3, mem.getMemberId());
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

	// 일반 회원 아이디찾기
	public String findMemberId(Connection conn, HashMap<String, String> member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(Sql.findMemberId);
			pstmt.setString(1, member.get("member_mail"));
			pstmt.setString(2, member.get("member_name"));
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getString(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}

		return null;
	}

	// 일반회원 비밀번호 찾기
	public String memberPwdCheck(Connection conn, HashMap<String, String> member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(Sql.findMemberPwd);
			pstmt.setString(1, member.get("member_mail"));
			pstmt.setString(2, member.get("member_name"));
			pstmt.setString(3, member.get("member_id"));
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getString(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}

		return null;
	}

	// 일반 회원 로그인
	public Member memberLogin(Connection conn, HashMap<String, String> member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = new Member();
		try {
			pstmt = conn.prepareStatement(Sql.memberLogin);
			pstmt.setString(1, member.get("member_id"));
			pstmt.setString(2, member.get("member_pwd"));

			rs = pstmt.executeQuery();

			while (rs.next()) {
				m.setMemberNo(rs.getInt("member_no"));
				m.setMemberAddress(rs.getString("member_address"));
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberGender(rs.getString("member_gender"));
				m.setMemberPhone(rs.getString("member_phone"));
				m.setMemberName(rs.getString("member_name"));
				m.setMemberMail(rs.getString("member_mail"));
				m.setMemberCoupon(rs.getInt("member_coupon"));
				m.setMemberActive(rs.getInt("member_active"));
				m.setAdminNo(rs.getInt("admin_no"));
			}
			return m;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}

		return null;
	}

	// 관리자 회원 로그인
	public int adminLogin(Connection conn, HashMap<String, String> admin) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(Sql.adminLogin);
			pstmt.setString(1, admin.get("member_id"));
			pstmt.setString(2, admin.get("member_pwd"));

			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}

		return 0;
	}

	// 관리자 마지막번호 찾기
	public int selectAdminNoMax(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.adminNoMax);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 관리자 추가
	public int insertAdmin(Connection conn, Admin a) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertAdmin);
			pstmt.setInt(1, a.getAdminNo());
			pstmt.setString(2, a.getAdminId());
			pstmt.setString(3, a.getAdminPwd());
			pstmt.setString(4, a.getAdminName());
			pstmt.setString(5, a.getAdminMail());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;

	}

	// 관리자 아이디 중복확인
	public int adminIdCheck(Connection conn, Admin a) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.adminidCheck);
			pstmt.setString(1, a.getAdminId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 관리자 쪽지 추가 (보내기)
	public int insertMessage(Connection conn, Message m) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.messageSend);
			pstmt.setInt(1, m.getMessageNo());
			pstmt.setString(2, m.getMessageTitle());
			pstmt.setString(3, m.getMessageContent());
			pstmt.setDate(4, m.getMessageDate());
			pstmt.setInt(6, m.getAdminNo());
			pstmt.setInt(5, m.getMemberNo());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 회원정보 조회 기본
	private Member basicMember(ResultSet rs) throws SQLException {
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
	public ArrayList<Member> selectAllMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			pstmt = conn.prepareStatement(Sql.allMember);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicMember(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 아이디로 회원정보 조회
	public Member selectMemberById(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.findMemberId);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return basicMember(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 회원 쿠폰수 조회
	public ArrayList<Member> selectMemberByCoupon(Connection conn, int memberCoupon) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			pstmt = conn.prepareStatement(Sql.memberCoupon);
			pstmt.setInt(1, memberCoupon);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicMember(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 회원 쿠폰수 수정
	public int updateMemberCoupon(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateMemberCoupon);
			pstmt.setInt(1, memberNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 회원 비활성화
	public int InactiveMember(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.inactiveMember);
			pstmt.setInt(1, memberNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 비활성화 회원 조회
	public ArrayList<Member> selectInactiveMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.allInactiveMember);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicMember(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 병원 회원 추가
	public int insertHospital(Connection conn, Hospital h) {
		PreparedStatement pstmt = null;
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
	private Hospital basicHospital(ResultSet rs) throws SQLException {
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
	public ArrayList<Hospital> selectAllHospital(Connection conn, Hospital h) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hospital> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.allHospital);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHospital(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return null;
	}

	// 아이디로 병원 회원 검색
	public Hospital selectHospitalById(Connection conn, String hospitalId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.findHospitalId);
			pstmt.setString(1, hospitalId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return basicHospital(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 병원 비활성화
	public int inactiveHospital(Connection conn, int hospitalNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.inactiveHospital);
			pstmt.setInt(1, hospitalNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 비활성화 된 병원 조회
	public ArrayList<Hospital> selectInactiveHospital(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hospital> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.allInactiveHospital);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHospital(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 미용실회원 검색 기본
	public Beauty basicBeauty(ResultSet rs) throws SQLException {
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
	public int inactiveBeauty(Connection conn, int beautyNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.inactiveBeauty);
			pstmt.setInt(1, beautyNo);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 비활성화 된 미용실 회원 조회
	public ArrayList<Beauty> selectInactiveBeauty(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Beauty> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.allInactiveBeauty);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicBeauty(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 호텔회원 검색 기본
	public Hotel basicHotel(ResultSet rs) throws SQLException {
		Hotel h = new Hotel();
		h.setHotelNo(rs.getInt("hotelNo"));
		h.setHotelName(rs.getString("hotelName"));
		h.setHotelOrnerName(rs.getString("hotelOrnerName"));
		h.setHotelOrnerNo(rs.getString("hotelOrnerNo"));
		h.setHotelMail(rs.getString("hotelMail"));
		h.setHotelAddress(rs.getString("hotelAddress"));
		h.setHotelPhone(rs.getString("hotelPhone"));
		h.setHotelPhoto(rs.getString("hotel_photo"));
		return h;
	}

	// 호텔회원 비활성화
	public int inactiveHotel(Connection conn, int hotelNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.inactiveHotel);
			pstmt.setInt(1, hotelNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 비활성화 된 호텔회원 조회
	public ArrayList<Hotel> selectInactiveHotel(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hotel> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.allInactiveHotel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHotel(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 관리자 삭제
	public int deleteAdmin(Connection conn, int adminNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteAdmin);
			pstmt.setInt(1, adminNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 회원삭제
	public int deleteMember(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteMember);
			pstmt.setInt(1, memberNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 병원회원 삭제
	public int deleteHospital(Connection conn, int hospitalNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteHospital);
			pstmt.setInt(1, hospitalNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 미용실회원 삭제
	public int deleteBeauty(Connection conn, int beautyNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteBeauty);
			pstmt.setInt(1, beautyNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 호텔회원 삭제
	public int deleteHotel(Connection conn, int hotelNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteHotel);
			pstmt.setInt(1, hotelNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 자유게시판 게시글 삭제
	public int deleteFreeBoard(Connection conn, int freeBoardNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteFreeBoard);
			pstmt.setInt(1, freeBoardNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 병원회원 아이디 중복체크
	public int hospitalIdCheck(Connection conn, String hospitalId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.hospitalIdCheck);
			pstmt.setString(1, hospitalId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 병원회원 사업자 등록번호 중복확인
	public int hospitalOrnerNoCheck(Connection conn, String hospitalOrnerNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.hospitalOnerNoCheck);
			pstmt.setString(1, hospitalOrnerNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 병원 예약시간 등록
	public int insertHospitalReserveTiem(Connection conn, ReserveHospitalTime rht) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertHospitalReserveTiem);
			pstmt.setInt(1, rht.getReserveHospitalTimeNo());
			pstmt.setString(2, rht.getHospitalTimeKind());
			pstmt.setInt(3, rht.getHospitalNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 병원예약내역 조회 기본
	private HospitalReserve basicHospitalReserve(ResultSet rs) throws SQLException {
		HospitalReserve hr = new HospitalReserve();
		hr.setHospitalNo(rs.getInt("hospitalNo"));
		hr.setMemberNo(rs.getInt("memberNo"));
		hr.setReserveHospitalNo(rs.getInt("reserveHotelNo"));
		hr.setReserveHospitalDate(rs.getDate("reserveHospitalDate"));
		return hr;

	}

	// 병원회원 전체 예약내역 확인
	public ArrayList<HospitalReserve> allHospitalReserve(Connection conn, HospitalReserve hr) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HospitalReserve> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findAllReserveHospital);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHospitalReserve(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 병원회원 날짜별 예약내역 확인
	public HospitalReserve selectHospitalReserveByDatd(Connection conn, Date reserveHospitalDate) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.findDateReserveHospital);
			pstmt.setDate(1, reserveHospitalDate);
			if (rs.next()) {
				return basicHospitalReserve(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 병원회원 예약시간대 수정
	public int updateHospitalReserveTime(Connection conn, int reserveHospitalTimeNo, int hospitalNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateReserveHospitalTime);
			pstmt.setInt(1, reserveHospitalTimeNo);
			pstmt.setInt(2, hospitalNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 지역별 병원회원 검색
	public ArrayList<Hospital> selectHospitalByArea(Connection conn, Hospital h) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hospital> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findAreaHospital);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHospital(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 평점별 병원회원 검색
	public ArrayList<Hospital> selectHospitalByScore(Connection conn, Hospital h) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hospital> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findScoreHospita);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHospital(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 리뷰순 병원회원 검색
	public ArrayList<Hospital> selectHospitalByReview(Connection conn, Hospital h) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hospital> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findReviewCntHospital);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHospital(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 병원회원 기본정보 수정
	public int updateHospital(Connection conn, Hospital h) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateHospital);
			pstmt.setString(1, h.getHospitalName());
			pstmt.setString(2, h.getHospitalMail());
			pstmt.setString(3, h.getHospitalAddress());
			pstmt.setString(4, h.getHospitalPhone());
			pstmt.setString(5, h.getHospitalOrnerName());
			pstmt.setInt(6, h.getHospitalNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 병원회원 아이디 찾기
	public String findHospitalId(Connection conn, HashMap<String, String> hospital) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.findHospitalId);
			pstmt.setString(1, hospital.get("hospital_mail"));
			pstmt.setString(2, hospital.get("hospital_orner_no"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 병원회원 비밀번호 찾기
	public String findHospitalPwd(Connection conn, HashMap<String,String> hospital) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.findHospitalPwd);
			pstmt.setString(1, hospital.get("hospital_mail"));
			pstmt.setString(2, hospital.get("hospital_orner_no"));
			pstmt.setString(3, hospital.get("hospital_id"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}
	
	// 미용실회원 아이디 중복체크
	public int beautyidCheck(Connection conn, String beautyId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.beautyIdCheck);
			pstmt.setString(1, beautyId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 미용실회원 사업자등록번호 중복확인
	public int beautyOrnerNoCheck(Connection conn, String beautyOrnerNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.beuatyOrnerNoCheck);
			pstmt.setString(1, beautyOrnerNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 미용실 예약시간 등록
	public int insertBeautyReserveTiem(Connection conn, ReserveBeautyTime rbt) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertHospitalReserveTiem);
			pstmt.setInt(1, rbt.getReserveBeautyTimeNo());
			pstmt.setString(2, rbt.getBeautyTimeKind());
			pstmt.setInt(3, rbt.getBeautyNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 미용실회원 예약내역 조회 기본
	public BeautyReserve basicBeautyReserve(ResultSet rs) throws SQLException {
		BeautyReserve br = new BeautyReserve();
		br.setReserveBeautyNo(rs.getInt("reserveBeautyNo"));
		br.setBeautyNo(rs.getInt("beautyNo"));
		br.setReserveBeautyDate(rs.getDate("reserveBeautyDate"));
		br.setMemberNo(rs.getInt("memberNo"));
		return br;
	}

	// 미용실회원 전체 예약내역 조회
	public ArrayList<BeautyReserve> findAllReserveBeauty(Connection conn, BeautyReserve br) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BeautyReserve> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findAllReserveBeauty);
			pstmt.setInt(1, br.getBeautyNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicBeautyReserve(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 미용실회원 날짜별 예약내역 조회
	public ArrayList<BeautyReserve> findReserveBeautyByDate(Connection conn, Date reserveBeautyDate) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BeautyReserve> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findDateReserveBeauty);
			pstmt.setDate(1, reserveBeautyDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicBeautyReserve(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 미용실 예약 시간대 수정
	public int updateReserveBeauty(Connection conn, int reserveBeautyTimeNo, int beautyNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateReserveBeautyTime);
			pstmt.setInt(1, reserveBeautyTimeNo);
			pstmt.setInt(2, beautyNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 지역별 미용실 조회
	public ArrayList<Beauty> selectBeautyByArea(Connection conn, Beauty b) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Beauty> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findAreaBeauty);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicBeauty(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 평점별 미용실 조회
	public ArrayList<Beauty> selectBeautyByScore(Connection conn, Beauty b) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Beauty> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findScoreBeauty);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicBeauty(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 리뷰순 미용실 조회
	public ArrayList<Beauty> selectBeautyByReview(Connection conn, Beauty b) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Beauty> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findReviewCntBeauty);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicBeauty(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 미용실회원 기본정보 수정
	public int updateBeauty(Connection conn, Beauty b) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateBeauty);
			pstmt.setString(1, b.getBeautyName());
			pstmt.setString(2, b.getBeautyMail());
			pstmt.setString(3, b.getBeautyAddress());
			pstmt.setString(4, b.getBeautyPhone());
			pstmt.setString(5, b.getBeautyOrnerName());
			pstmt.setInt(6, b.getBeautyNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 미용실회원 아이디 찾기
	public String findbeautyId(Connection conn, HashMap<String,String> beauty ) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.findBeautyId);
			pstmt.setString(1, beauty.get("beauty_mail"));
			pstmt.setString(2, beauty.get("beauty_orner_no"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}
	

	// 미용실회원 비밀번호 찾기
	public String findbeautyPwd(Connection conn, HashMap<String,String> beauty) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.findBeautyId);
			pstmt.setString(1, beauty.get("beauty_mail"));
			pstmt.setString(2, beauty.get("beaury_orner_no"));
			pstmt.setString(3, beauty.get("beaury_id"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}
	
	
	// 호텔회원 아이디 중복체크
	public int hotelidCheck(Connection conn, String hotelId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.hotelIdCheck);
			pstmt.setString(1, hotelId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 호텔회원 사업자등록번호 중복확인
	public int hotelOrnerNoCheck(Connection conn, String hotelOrnerNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.hotelOrnerNoCheck);
			pstmt.setString(1, hotelOrnerNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 호텔 방 등록
	public int insertHotelReserveTiem(Connection conn, Room r) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertRoom);
			pstmt.setInt(1, r.getRoomNo());
			pstmt.setInt(2, r.getHotelNo());
			pstmt.setString(3, r.getRoomKind());
			pstmt.setInt(4, r.getRoomPrice());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 호텔 예약내역 조회 기본
	public HotelReserve basicHotelReserve(ResultSet rs) throws SQLException {
		HotelReserve hr = new HotelReserve();
		hr.setReserveHotelNo(rs.getInt("reserveHotelNo"));
		hr.setHotelNo(rs.getInt("hotelNo"));
		hr.setReserveHotelDate(rs.getDate("reserveHotelDate"));
		hr.setMemberNo(rs.getInt("memberNo"));
		return hr;
	}

	// 호텔회원 전체 예약내역 조회
	public ArrayList<HotelReserve> findAllReserveHotel(Connection conn, HotelReserve hr) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HotelReserve> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findAllReserveHotel);
			pstmt.setInt(1, hr.getHotelNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHotelReserve(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 호텔회원 날짜별 예약내역 조회
	public ArrayList<HotelReserve> findReserveHotelByDate(Connection conn, Date reserveHotelDate) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HotelReserve> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findDateReserveHotel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHotelReserve(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 호텔 방 수정
	public int updateReserveHotel(Connection conn, int reserveHotelTimeNo, int hotelNo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateRoom);
			pstmt.setInt(1, reserveHotelTimeNo);
			pstmt.setInt(2, hotelNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 지역별 호텔 조회
	public ArrayList<Hotel> selectHotelByArea(Connection conn,String area) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		ArrayList<Hotel> list = new ArrayList<>();
		float avgScore = 0;
		if(area==null)
			area="";
		try {
			pstmt = conn.prepareStatement(Sql.findAreaHotel);
			pstmt.setString(1, "%"+area+"%");
			pstmt2 = conn.prepareStatement(Sql.hotelAvgScore);
			pstmt2.setString(1, "%"+area+"%");
			rs2 = pstmt2.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Hotel h = new Hotel();
				if(rs2.next())
					avgScore = rs2.getFloat(1);
				h.setHotelNo(rs.getInt("hotel_no"));
				h.setHotelName(rs.getString("hotel_name"));
				h.setHotelMail(rs.getString("hotel_mail"));
				h.setHotelAddress(rs.getString("hotel_address"));
				h.setHotelPhone(rs.getString("hotel_phone"));
				h.setHotelPhoto(rs.getString("hotel_photo"));
				h.setHotelScore(avgScore);
				list.add(h);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 평점별 호텔 조회
	public ArrayList<Hotel> selectBeautyByHotel(Connection conn, Hotel h) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hotel> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findScoreHotel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHotel(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 리뷰순 호텔 조회
	public ArrayList<Hotel> selectHotelByReview(Connection conn, Hotel h) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hotel> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findReviewCntHotel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(basicHotel(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 호텔회원 기본정보 수정
	public int updateHotel(Connection conn, Hotel h) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateBeauty);
			pstmt.setString(1, h.getHotelName());
			pstmt.setString(2, h.getHotelMail());
			pstmt.setString(3, h.getHotelAddress());
			pstmt.setString(4, h.getHotelPhone());
			pstmt.setString(5, h.getHotelOrnerName());
			pstmt.setInt(6, h.getHotelNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}

	// 호텔회원 아이디 찾기
	public String findHotelId(Connection conn, HashMap<String,String> hotel) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.findHotelId);
			pstmt.setString(1, hotel.get("hotel_mail"));
			pstmt.setString(2, hotel.get("hotel_orner_no"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}


	// 호텔회원 비밀번호 찾기
	public String findHotelPwd(Connection conn, HashMap<String,String> hotel) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.findHotelPwd);
			pstmt.setString(1, hotel.get("hotel_mail"));
			pstmt.setString(2, hotel.get("hotel_orner_no"));
			pstmt.setString(3, hotel.get("hotel_id"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return null;
	}

	// 일반 회원 수정
	public int memberUpdate(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		try {

			pstmt = conn.prepareStatement(Sql.updateMember);
			pstmt.setString(1, m.getMemberName());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberAddress());
			pstmt.setString(4, m.getMemberPhone());
			pstmt.setString(5, m.getMemberMail());
			pstmt.setString(6, m.getMemberGender());
			pstmt.setInt(7, m.getMemberNo());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return 0;
	}

	// 애완동물 리스트 보기
	public ArrayList<Animal> animalList(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Animal> animalList = new ArrayList<>();
		/*
		 * a.member_no,a.animal_no,a.animal_name,a.animal_kind,a.animal_gender,a
		 * .animal_breed,a.animal_weight
		 */
		try {
			pstmt = conn.prepareStatement(Sql.allAnimal);
			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Animal a = new Animal();
				a.setMemberNo(rs.getInt(1));
				a.setAnimalNo(rs.getInt(2));
				a.setAnimalName(rs.getString(3));
				a.setAnimalKind(rs.getString(4));
				a.setAnimalGender(rs.getString(5));
				a.setAnimalBreed(rs.getString(6));
				a.setAnimalWeight(rs.getFloat(7));

				animalList.add(a);
			}
			return animalList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}
	
	

	// 애완 동물 마지막 번호 찾기
	public int animalMaxNo(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(Sql.animalMaxNo);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return 1;
	}

	// 애완 동물 추가하기
	public int animalInsert(Connection conn, Animal a) {
		PreparedStatement pstmt = null;
		// member_no,animal_no,animal_name,animal_kind,animal_gender,animal_breed,animal_weight
		try {
			pstmt = conn.prepareStatement(Sql.insertAnimal);
			pstmt.setInt(1, a.getMemberNo());
			pstmt.setInt(2, a.getAnimalNo());
			pstmt.setString(3, a.getAnimalName());
			pstmt.setString(4, a.getAnimalKind());
			pstmt.setString(5, a.getAnimalGender());
			pstmt.setString(6, a.getAnimalBreed());
			pstmt.setFloat(7, a.getAnimalWeight());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}

		return 0;
	}

	// 애완 동물 변경하기
	public int animalUpdate(Connection conn, Animal a) {
		PreparedStatement pstmt = null;
		// "update animal set ANIMAL_NAME=?,animal_kind=?,
		// ANIMAL_GENDER=?,animal_breed=?, ANIMAL_WEIGHT=? where member_no=? and
		// animal_no=?";
		try {
			pstmt = conn.prepareStatement(Sql.updateAnimal);
			pstmt.setString(1, a.getAnimalName());
			pstmt.setString(2, a.getAnimalKind());
			pstmt.setString(3, a.getAnimalGender());
			pstmt.setString(4, a.getAnimalBreed());
			pstmt.setFloat(5, a.getAnimalWeight());
			pstmt.setInt(6, a.getMemberNo());
			pstmt.setInt(7, a.getAnimalNo());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}

		return 0;
	}

	public Animal animalView(Connection conn, int memberNo, int animalNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Animal a = new Animal();
		try {
			pstmt = conn.prepareStatement(Sql.animalView);
			pstmt.setInt(1, animalNo);
			pstmt.setInt(2, memberNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				a.setAnimalNo(rs.getInt("animal_no"));
				a.setAnimalName(rs.getString("animal_name"));
				a.setAnimalKind(rs.getString("animal_kind"));
				a.setAnimalGender(rs.getString("animal_gender"));
				a.setAnimalBreed(rs.getString("animal_breed"));
				a.setAnimalWeight(rs.getFloat("animal_weight"));

				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return a;
	}

	// 애완 동물 삭제하기
	public int animalDelete(Connection conn, int memberNo, int animalNo) {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(Sql.deleteAnimal);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, animalNo);

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return 0;
	}

	/////////////////////////////////////
	// 호텔 DAO

	// 호텔 마지막 번호 찾기
	public int selectHotelNoMax(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.hotelNoMax);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 호텔 회원 등록(추가)
	public int hotelInsert(Connection conn, Hotel h) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertHotel);
			pstmt.setInt(1, h.getHotelNo());
			pstmt.setString(2, h.getHotelName());
			pstmt.setString(3, h.getHotelOrnerName());
			pstmt.setString(4, h.getHotelOrnerNo());
			pstmt.setString(5, h.getHotelMail());
			pstmt.setString(6, h.getHotelPhone());
			pstmt.setString(7, h.getHotelAddress());
			pstmt.setString(8, h.getHotelId());
			pstmt.setString(9, h.getHotelPwd());
			pstmt.setString(10, h.getHotelPhoto());
			pstmt.setInt(11, h.getAdminNo());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return 0;
	}

	// 호텔 로그인
	public Hotel hotelLogin(Connection conn, HashMap<String, String> user) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Hotel h = new Hotel();
		try {

			pstmt = conn.prepareStatement(Sql.HotelLogin);
			pstmt.setString(1, user.get("user_id"));
			pstmt.setString(2, user.get("user_pwd"));

			rs = pstmt.executeQuery();

			while (rs.next()) {
				h.setHotelNo(rs.getInt("hotel_no"));
				h.setHotelName(rs.getString("hotel_name"));
				h.setHotelOrnerName(rs.getString("hotel_orner_name"));
				h.setHotelOrnerNo(rs.getString("hotel_orner_no"));
				h.setHotelMail(rs.getString("hotel_mail"));
				h.setHotelPhone(rs.getString("hotel_phone"));
				h.setHotelAddress(rs.getString("hotel_address"));
				h.setHotelId(rs.getString("hotel_id"));
				h.setHotelPwd(rs.getString("hotel_pwd"));
				h.setHotelPhoto(rs.getString("hotel_photo"));
				h.setHotelActive(rs.getInt("hotel_active"));
				h.setAdminNo(rs.getInt("admin_no"));
			}
			return h;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}

		return null;
	}

	// 일반회원 받은 메세지 보기
	public ArrayList<Message> receiveMessageList(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Message> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.selectMemberMessage);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Message msg = new Message();
				msg.setMemberNo(memberNo);
				msg.setMessageNo(rs.getInt("message_no"));
				msg.setMessageTitle(rs.getString("message_title"));
				msg.setMessageContent(rs.getString("message_content"));
				msg.setMessageDate(rs.getDate("message_date"));

				list.add(msg);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

	// 일반회원 메세지(쪽지) 삭제
	public void messageDelete(Connection conn, int messageNo, int memberNo) {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(Sql.deleteMessage);
			pstmt.setInt(1, messageNo);
			pstmt.setInt(2, memberNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}

	}

	/////////////////////////////////////
	// 병원 DAO

	// 병원 마지막 번호 찾기
	public int selectHospitalNoMax(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.hospitalNoMax);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 병원 회원 등록(추가)
	public int hospitalInsert(Connection conn, Hospital h) {
		PreparedStatement pstmt = null;
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
		return 0;
	}

	// 병원 로그인
	public Hospital hospitalLogin(Connection conn, HashMap<String, String> user) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Hospital h = new Hospital();
		try {

			pstmt = conn.prepareStatement(Sql.HospitalLogin);
			pstmt.setString(1, user.get("user_id"));
			pstmt.setString(2, user.get("user_pwd"));

			rs = pstmt.executeQuery();

			while (rs.next()) {
				h.setHospitalNo(rs.getInt("hospital_no"));
				h.setHospitalName(rs.getString("hospital_name"));
				h.setHospitalOrnerName(rs.getString("hospital_orner_name"));
				h.setHospitalOrnerNo(rs.getString("hospital_orner_no"));
				h.setHospitalMail(rs.getString("hospital_mail"));
				h.setHospitalPhone(rs.getString("hospital_phone"));
				h.setHospitalAddress(rs.getString("hospital_address"));
				h.setHospitalId(rs.getString("hospital_id"));
				h.setHospitalPwd(rs.getString("hospital_pwd"));
				h.setHospitalPhoto(rs.getString("hospital_photo"));
				h.setHospitalActive(rs.getInt("hospital_active"));
				h.setAdminNo(rs.getInt("admin_no"));
			}
			return h;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}

		return null;
	}

	/////////////////////////////////////
	// 미용 DAO

	// 미용 마지막 번호 찾기
	public int selectBeautyNoMax(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.beautyNoMax);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 미용 회원 등록(추가)
	public int beautyInsert(Connection conn, Beauty b) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertBeauty);
			pstmt.setInt(1, b.getBeautyNo());
			pstmt.setString(2, b.getBeautyName());
			pstmt.setString(3, b.getBeautyOrnerName());
			pstmt.setString(4, b.getBeautyOrnerNo());
			pstmt.setString(5, b.getBeautyMail());
			pstmt.setString(6, b.getBeautyPhone());
			pstmt.setString(7, b.getBeautyAddress());
			pstmt.setString(8, b.getBeautyId());
			pstmt.setString(9, b.getBeautyPwd());
			pstmt.setString(10, b.getBeautyPhoto());
			pstmt.setInt(11, b.getAdminNo());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return 0;
	}

	// 미용 회원 로그인
	public Beauty beautyLogin(Connection conn, HashMap<String, String> user) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Beauty b = new Beauty();
		try {

			pstmt = conn.prepareStatement(Sql.beautyLogin);
			pstmt.setString(1, user.get("user_id"));
			pstmt.setString(2, user.get("user_pwd"));

			rs = pstmt.executeQuery();

			while (rs.next()) {
				b.setBeautyNo(rs.getInt("beauty_no"));
				b.setBeautyName(rs.getString("beauty_name"));
				b.setBeautyOrnerName(rs.getString("beauty_orner_name"));
				b.setBeautyOrnerNo(rs.getString("beauty_orner_no"));
				b.setBeautyMail(rs.getString("beauty_mail"));
				b.setBeautyPhone(rs.getString("beauty_phone"));
				b.setBeautyAddress(rs.getString("beauty_address"));
				b.setBeautyId(rs.getString("beauty_id"));
				b.setBeautyPwd(rs.getString("beauty_pwd"));
				b.setBeautyPhoto(rs.getString("beauty_photo"));
				b.setBeautyActive(rs.getInt("beauty_active"));
				b.setAdminNo(rs.getInt("admin_no"));
			}
			return b;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}

		return null;
	}

	// 병원 수의사 추가
	public int insertVet(Connection conn, Vet v){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertVet);
			pstmt.setInt(1, v.getVetNo());
			pstmt.setString(2, v.getVetName());
			pstmt.setString(3, v.getVetIntroduce());
			pstmt.setInt(4, v.getHospitalNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 병원 수의사 수정
	public int updateVet(Connection conn, Vet v){
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(Sql.updateVet);
			pstmt.setString(1, v.getVetName());
			pstmt.setString(2, v.getVetIntroduce());
			pstmt.setInt(3, v.getVetNo());
			pstmt.setInt(4, v.getHospitalNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 병원 수의사 삭제
	public int deleteVet(Connection conn , int vetNo, int hospitalNo){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteVet);
			pstmt.setInt(1, vetNo);
			pstmt.setInt(2, hospitalNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 미용실 미용사 추가
	public int insertBeautician(Connection conn, Beautician b){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertBeautician);
			pstmt.setInt(1, b.getBeauticianNo());
			pstmt.setString(2, b.getBeauticianName());
			pstmt.setString(3, b.getBeauticianIntroduce());
			pstmt.setInt(4, b.getBeautyNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 미용실 미용사 수정
	public int updateBeautician(Connection conn, Beautician b){
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(Sql.updateBeautician);
			pstmt.setString(1, b.getBeauticianName());
			pstmt.setString(2, b.getBeauticianIntroduce());
			pstmt.setInt(3, b.getBeauticianNo());
			pstmt.setInt(4, b.getBeautyNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
		
	}
	// 미용실 미용사 삭제
	public int deleteBeautician(Connection conn, int beauticianNo, int beautyNo){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteBeautician);
			pstmt.setInt(1, beauticianNo);
			pstmt.setInt(2, beautyNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 병원리뷰 작성
	public int insertHospitalReview(Connection conn, HospitalReview hr){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertHospitalReview);
			pstmt.setInt(1, hr.getHospitalReviewNo());
			pstmt.setFloat(2, hr.getHospitalReviewScore());
			pstmt.setString(3, hr.getHospitalReviewEpilogue());
			pstmt.setInt(4, hr.getHospitalNo());
			pstmt.setInt(5, hr.getMemberNo());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 병원리뷰 수정
	public int updateHospitalReview(Connection conn, HospitalReview hr){
		PreparedStatement pstmt = null;
		try {
			pstmt =conn.prepareStatement(Sql.updateHospitalReview);
			pstmt.setString(1, hr.getHospitalReviewEpilogue());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		}
		return -1;
	}
	// 미용실리뷰 수정
	public int updateBeautyReview(Connection conn, BeautyReview br){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateBeautyReview);
			pstmt.setString(1, br.getBeautyReviewEpilouge());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 호텔리뷰 수정
	public int updateHotelReview(Connection conn, HotelReview hr){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateHotelReview);
			pstmt.setString(1, hr.getHotelReviewEpilogue());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 자유게시판 글작성
	public int insertFreeBoard(Connection conn, FreeBoard fb){
		PreparedStatement pstmt =null;
		try {
			pstmt = conn.prepareStatement(Sql.insertFreeBoard);
			pstmt.setInt(1, fb.getFreeBoardNo());
			pstmt.setString(2, fb.getFreeBoardTitle());
			pstmt.setInt(3, fb.getFreeBoardCount());
			pstmt.setInt(4, fb.getFreeBoardCommentCount());
			pstmt.setString(5, fb.getFreeBoardContent());
			pstmt.setDate(6, fb.getFreeBoardDate());
			pstmt.setString(7, fb.getMemberId());
			pstmt.setInt(8, fb.getMemberNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 자유게시판 글수정
	public int updateFreeBoard(Connection conn, FreeBoard fb){
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(Sql.updateFreeBoard);
			pstmt.setString(1, fb.getFreeBoardTitle());
			pstmt.setString(2, fb.getFreeBoardContent());
			pstmt.setInt(3, fb.getMemberNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 자유게시판 글삭제
	public int deleteFreeBoard(Connection conn, int freeBoardNo, int memberNo){
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(Sql.deleteFreeBoard);
			pstmt.setInt(1, freeBoardNo);
			pstmt.setInt(2, memberNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 자유게시판 검색 기본
	public FreeBoard basicFreeBoard(ResultSet rs) throws SQLException{
		FreeBoard fb = new FreeBoard();
		fb.setFreeBoardNo(rs.getInt("freeBoardNo"));
		fb.setFreeBoardTitle(rs.getString("freeBoardTitle"));
		fb.setFreeBoardContent(rs.getString("freeBoardContent"));
		fb.setFreeBoardDate(rs.getDate("freeBoardDate"));
		fb.setFreeBoardCount(rs.getInt("freeBoardCount"));	
		fb.setMemberId(rs.getString("memberId"));
		return fb;
	}
	// 아이디로 게시글 찾기
	public ArrayList<FreeBoard> findFreeBoardById(Connection conn, String memberId){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FreeBoard> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findIdFreeBoard);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicFreeBoard(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, rs);
		} 
		return null;
	}
	// 제목으로 게시글 찾기
	public ArrayList<FreeBoard> findFreeBoardbyTitle(Connection conn, String freeBoardTitle){
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		ArrayList<FreeBoard> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findTitleFreeBoard);
			pstmt.setString(1, freeBoardTitle);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicFreeBoard(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, rs);
		} return null;
	}
	// 최신순으로 글보기
	public ArrayList<FreeBoard> findFreeBoardByDate(Connection conn, Date freeBoardDate){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FreeBoard> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findDateFreeBoard);
			pstmt.setDate(1, freeBoardDate);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicFreeBoard(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, rs);
		} return null;
	}
	// 자유게시판 댓글 작성
	public int insertFreeBoardComment(Connection conn, FreeBoardComment	fbc){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertFreeBoardComment);
			pstmt.setInt(1, fbc.getFreeBoardNo());
			pstmt.setInt(2, fbc.getFreeBoardCommentNo());
			pstmt.setString(3, fbc.getMemberId());
			pstmt.setString(4, fbc.getFreeBoardCommentContent());
			pstmt.setDate(5, fbc.getFreeBoardCommentDate());
			pstmt.setInt(6, fbc.getMemberNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 자유게시판 댓글 수정
	public int updateFreeBoardComment(Connection conn, FreeBoardComment fbc){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateFreeBoardComment);
			pstmt.setString(1, fbc.getFreeBoardCommentContent());
			pstmt.setInt(2, fbc.getMemberNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 자유게시판 댓글 삭제
	public int deleteFreeBoardComment(Connection conn, int memberNo, int freeBoardCommentNo){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteFreeBoardComment);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, freeBoardCommentNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 문의게시판 글작성
	public int insertInquireBoard(Connection conn, InquireBoard ib){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertInquireBoard);
			pstmt.setInt(1, ib.getInquireBoardNo());
			pstmt.setString(2, ib.getMemberId());
			pstmt.setString(3, ib.getInquireBoardTitle());
			pstmt.setString(4, ib.getInquireBoardContent());
			pstmt.setDate(5, ib.getInquireBoardDate());
			pstmt.setInt(6, ib.getInuqireBoardCommentCount());
			pstmt.setInt(7, ib.getMemberNo());
			pstmt.setInt(8, ib.getAdminNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 문의게시판 글수정
	public int updateInquireBoard(Connection conn, InquireBoard ib){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateInquireBoard);
			pstmt.setString(1, ib.getInquireBoardContent());
			pstmt.setInt(2, ib.getAdminNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
		
	}
	// 문의게시판 글삭제
	public int deletetInquireBoard(Connection conn, int memberNo, int inquireBoardNo){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteInquireBoard);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, inquireBoardNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 문의게시판 검색 기본
	public InquireBoard basicInquireBoard(ResultSet rs) throws SQLException{
		InquireBoard ib = new InquireBoard();
		ib.setInquireBoardNo(rs.getInt("inquireBoardNo"));
		ib.setMemberId(rs.getString("memberId"));
		ib.setInquireBoardTitle(rs.getString("inquireBoardTitel"));
		ib.setInquireBoardContent(rs.getString("inquireBoardContent"));
		ib.setInquireBoardDate(rs.getDate("inquireBoardDate"));
		return ib;
		
	}
	// 제목으로 문의 게시글 찾기
	public ArrayList<InquireBoard> findInquireBoardByTitle(Connection conn, InquireBoard ib){
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<InquireBoard> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findTitleInquireBoard);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicInquireBoard(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, rs);
		} return null;
	}
	// 문의게시판 리스트 보기
	public ArrayList<InquireBoard> findAllInquireBoard(Connection conn, InquireBoard ib){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<InquireBoard> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findAllInquireBoard);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicInquireBoard(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, rs);
		} return null;
	}
	// 문의게시판 댓글 작성
	public int insertInquireBoardComment(Connection conn, InquireBoardComment ibc){
		PreparedStatement pstmt = null;
		try {
			pstmt =conn.prepareStatement(Sql.insertInquireBoardComment);
			pstmt.setInt(1, ibc.getInquireBoardNo());
			pstmt.setInt(2, ibc.getInquireBoardCommentNo());
			pstmt.setString(3, ibc.getAdminId());
			pstmt.setString(4, ibc.getInquireBoardCommentCotent());
			pstmt.setDate(5, ibc.getInquireBoardCommentDate());
			pstmt.setInt(6, ibc.getAdminNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 문의게시판 댓글 수정
	public int updateInquireBoardComment(Connection conn, InquireBoardComment ibc){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateInquireBoardComment);
			pstmt.setString(1, ibc.getInquireBoardCommentCotent());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 쪽지 찾기 기본
	public Message basicMessage(ResultSet rs) throws SQLException{
		Message m = new Message();
		m.setMessageNo(rs.getInt("message_no"));
		m.setMessageTitle(rs.getString("message_title"));
		m.setMessageContent(rs.getString("message_content"));
		m.setMessageDate(rs.getDate("message_date"));
		m.setAdminNo(rs.getInt("admin_no"));
		m.setMemberNo(rs.getInt("member_no"));
		
		return m;
	}
	
	// &쪽지 리스트
	public ArrayList<Message> allMessage(Connection conn, Message m){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Message> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.adminMessageSend);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicMessage(rs));
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, rs);
		} return null;
	
		
	}
	
	
	// 쪽지 찾기
	public ArrayList<Message> findAllMessage(Connection conn, Message m){
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		ArrayList<Message> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.findMessage);
			pstmt.setInt(1, m.getMemberNo());
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicMessage(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, rs);
		} return null;
	}
	// 쪽지 삭제
	public int deleteMessage(Connection conn, int memberNo){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteMessage);
			pstmt.setInt(1, memberNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		}  return -1;
	}
	
	// 반려동물 추가
	public int insertAnimal(Connection conn, Animal a){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertAnimal);
			pstmt.setInt(1, a.getMemberNo());
			pstmt.setInt(2, a.getAnimalNo());
			pstmt.setString(3, a.getAnimalName());
			pstmt.setString(4, a.getAnimalKind());
			pstmt.setString(5, a.getAnimalGender());
			pstmt.setString(6, a.getAnimalBreed());
			pstmt.setFloat(7, a.getAnimalWeight());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 개인회원 병원예약내역 조회
	public ArrayList<HospitalReserve> findHospitalReserve(Connection conn, HospitalReserve hr){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HospitalReserve> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.allReserveHospital);
			pstmt.setInt(1, hr.getMemberNo());
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicHospitalReserve(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		} return null;
	}
	// 개인회원 미용실예약 내역 조회
	public ArrayList<BeautyReserve> findBeautyReserve(Connection conn, BeautyReserve br){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BeautyReserve> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.allReserveBeauty);
			pstmt.setInt(1, br.getMemberNo());
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicBeautyReserve(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		} return null;
	}
	// 개인회원 호텔예약 내역 조회
	public ArrayList<HotelReserve> findHotelReserve(Connection conn, HotelReserve hr){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HotelReserve> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.allReserveHotel);
			pstmt.setInt(1, hr.getMemberNo());
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(basicHotelReserve(rs));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		} return null;
	}
	
	// 반려동물 수정
	public int updateAnimal(Connection conn, Animal a){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateAnimal);
			pstmt.setString(1, a.getAnimalName());
			pstmt.setString(2, a.getAnimalGender());
			pstmt.setFloat(3, a.getAnimalWeight());
			pstmt.setInt(4, a.getMemberNo());
			pstmt.setInt(5, a.getAnimalNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 반려동물 삭제
	public int deleteAnimal(Connection conn, Animal a){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteAnimal);
			pstmt.setInt(1, a.getMemberNo());
			pstmt.setInt(2, a.getAnimalNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
		} return -1;
	}
	// 마지막 쪽지번호 조회
	public int selectMessageNoMax(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.messageNoMax);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 호텔 상세 보기
	public Hotel hotelView(Connection conn, int hotelNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Hotel h = new Hotel();
		
		try {
			pstmt = conn.prepareStatement(Sql.allHotelNo);
			pstmt.setInt(1, hotelNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				h.setHotelNo(hotelNo);
				h.setHotelOrnerName(rs.getString("hotel_orner_name"));
				h.setHotelOrnerNo(rs.getString("hotel_orner_no"));
				h.setHotelName(rs.getString("hotel_name"));
				h.setHotelMail(rs.getString("hotel_mail"));
				h.setHotelPhone(rs.getString("hotel_phone"));
				h.setHotelAddress(rs.getString("hotel_address"));
				h.setHotelPhoto(rs.getString("hotel_photo"));
				
			}
			
			return h;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, rs);
		}
		
		
		return null;
	}

	// 방 상세보기
	public ArrayList<Room> roomAllView(Connection conn, int hotelNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Room> rList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(Sql.allRoom);
			pstmt.setInt(1, hotelNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Room r = new Room();
				r.setHotelNo(hotelNo);
				r.setRoomKind(rs.getString("room_kind"));
				r.setRoomNo(rs.getInt("room_no"));
				r.setRoomPrice(rs.getInt("room_price"));
				rList.add(r);
			}
			
			return rList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt, rs);
		}
		
		
		return null;
	}

	//평점별 호텔 조회
	public ArrayList<Hotel> selectHotelByScore(Connection conn,String area) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hotel> list = new ArrayList<>();
		if(area==null)
			area="";
		try {
			pstmt = conn.prepareStatement(Sql.findScoreHotel);
			pstmt.setString(1, "%"+area+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Hotel h = new Hotel();
				h.setHotelNo(rs.getInt("hotel_no"));
				h.setHotelName(rs.getString("hotel_name"));
				h.setHotelMail(rs.getString("hotel_mail"));
				h.setHotelAddress(rs.getString("hotel_address"));
				h.setHotelPhone(rs.getString("hotel_phone"));
				h.setHotelPhoto(rs.getString("hotel_photo"));
				h.setHotelScore(rs.getFloat(7));
				list.add(h);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}


	// 전체회원 리스트

	public int selectCountMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectCountMember);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}

	// 병원회원 전체 리스트
	//애완동물 리스트 보기
	// 애완동물 리스트 보기

	
	public int selectCountHospital(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectCountHospital);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}
	// 미용실회원 전체 리스트
	public int selectCountBeauty(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectCountBeauty);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}
	// 호텔회원 전체리스트
	public int selectCountHotel(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectCountHotel);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt, rs);
		}
		return -1;
	}
	
	// 비활성화된 회원 페이징
	public ArrayList<Member> selectByPaging(Connection conn, int startId, int endId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.inactiveMemberList);  // 여기부터
			pstmt.setInt(1, endId);
			pstmt.setInt(2, startId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setMemberNo(rs.getInt("member_no"));
				m.setMemberName(rs.getString("member_name"));
				m.setMemberPhone(rs.getString("member_phone"));
				m.setMemberMail(rs.getString("member_mail"));
				m.setMemberActiveDate(rs.getDate("member_active_date"));
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}
	
	// 비활성화 된 병원 페이징
	public ArrayList<Hospital> selectByPagingHospital(Connection conn, int startId, int endId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hospital> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.inactiveHospitalList);  // 여기부터
			pstmt.setInt(1, endId);
			pstmt.setInt(2, startId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hospital h = new Hospital();
				h.setHospitalNo(rs.getInt("hospital_no"));
				h.setHospitalName(rs.getString("hospital_name"));
				h.setHospitalPhone(rs.getString("hospital_phone"));
				h.setHospitalMail(rs.getString("hospital_mail"));
				h.setHospitalOrnerName(rs.getString("hospital_orner_name"));
				h.setHospitalOrnerNo(rs.getString("hospital_orner_no"));
				h.setHospitalActiveDate(rs.getDate("hospital_active_date"));
				list.add(h);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}
	// 비활성화 된 미용실 페이징
	public ArrayList<Beauty> selectByPagingBeauty(Connection conn, int startId, int endId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Beauty> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.inactiveBeautyList);  // 여기부터
			pstmt.setInt(1, endId);
			pstmt.setInt(2, startId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Beauty b = new Beauty();
				b.setBeautyNo(rs.getInt("beauty_no"));
				b.setBeautyName(rs.getString("beauty_name"));
				b.setBeautyPhone(rs.getString("beauty_phone"));
				b.setBeautyMail(rs.getString("beauty_mail"));
				b.setBeautyOrnerName(rs.getString("beauty_orner_name"));
				b.setBeautyOrnerNo(rs.getString("beauty_orner_no"));
				b.setBeautyActiveDate(rs.getDate("beauty_active_date"));
				list.add(b);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}
	
	// 비활성화 된 호텔 페이징
	public ArrayList<Hotel> selectByPagingHotel(Connection conn, int startId, int endId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Hotel> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(Sql.inactiveHotelList);  // 여기부터
			pstmt.setInt(1, endId);
			pstmt.setInt(2, startId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel h = new Hotel();
				h.setHotelNo(rs.getInt("hotel_no"));
				h.setHotelName(rs.getString("hotel_name"));
				h.setHotelPhone(rs.getString("hotel_phone"));
				h.setHotelMail(rs.getString("hotel_mail"));
				h.setHotelOrnerName(rs.getString("hotel_orner_name"));
				h.setHotelOrnerNo(rs.getString("hotel_orner_no"));
				h.setHotelActiveDate(rs.getDate("hotel_active_date"));
				list.add(h);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

}
