package com.ppp.service;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

import com.google.gson.*;
import com.ppp.dao.*;
import com.ppp.di.RequestMapping;
import com.ppp.util.*;
import com.ppp.vo.*;

public class Service {
	private PppDao dao;

	public Service(PppDao dao) {
		this.dao = dao;
	}

	// 일반회원 등록
	public String memberCreateEnd(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int memberNo = dao.selectMemberNoMax(conn);
		Member member = MappingUtil.getMemberFromRequest(req, memberNo);
		int result = dao.memberInsert(conn, member);
		JsonObject ob = new JsonObject();
		if (result == 1)
			ob.addProperty("result", "success");
		else
			ob.addProperty("result", "fail");
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	// 일반회원 로그인
	public Member memberLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> member = new HashMap<>();
		member.put("member_id", req.getParameter("member_id"));
		member.put("member_pwd", req.getParameter("member_pwd"));
		Member result = dao.memberLogin(conn, member);
		HttpSession session = req.getSession();
		ArrayList<Animal> animallist = animalSelectLogin(req);
		if (result.getMemberId() == null) {
			System.out.println("아이디나 비밀번호 확인필요");
			session.setAttribute("logincheck", "아이디나 비밀번호 확인필요");
			JdbcUtil.close(conn);
			return null;
		} else {
			System.out.println("로그인 성공");
			session.removeAttribute("logincheck");
			session.setAttribute("member", result);
			session.setAttribute("animallist", animallist);
			session.setAttribute("animallistgson", new Gson().toJson(animallist));
			JdbcUtil.close(conn);
			return result;
		}
	}

	// 관리자 추가
	public String adminCreateEnd(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int adminNo = dao.selectAdminNoMax(conn);
		Admin admin = MappingUtil.getAdminFromRequest(req, adminNo);
		int result = dao.insertAdmin(conn, admin);
		JsonObject ob = new JsonObject();
		if (result == 1)
			ob.addProperty("result", "success");
		else
			ob.addProperty("result", "fail");
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	// 관리자 로그인
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

	// 일반회원 아이디찾기
	public String memberIdSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> member = new HashMap<>();
		member.put("member_mail", req.getParameter("member_mail"));
		member.put("member_name", req.getParameter("member_name"));
		JsonObject ob = new JsonObject();
		ob.addProperty("result", dao.findMemberId(conn, member));
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

	// 일반회원 정보수정
	public String memberUpdate(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int memberNo = Integer.parseInt(req.getParameter("member_no"));
		Member m = MappingUtil.getMemberFromRequest(req, memberNo);
		HttpSession session = req.getSession();
		session.setAttribute("member", m);
		int result = dao.memberUpdate(conn, m);
		JsonObject ob = new JsonObject();
		if (result == 1)
			ob.addProperty("result", "success");
		else
			ob.addProperty("result", "fail");
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	//////////////////////////////////////////////
	/*
	 * //비활성화 된 회원 검색 public String inactiveMember(HttpServletRequest req) {
	 * Connection conn = JdbcUtil.getConnection(); int pageNo =
	 * Integer.parseInt(req.getParameter("pageNo")); int numberOfArticle =
	 * dao.selectCountMember(conn); Pagination pagination =
	 * PagingUtil.setPageMaker(pageNo, numberOfArticle); ArrayList<Member> list
	 * = dao.selectByPaging(conn, pagination.getStartArticle(),
	 * pagination.getEndArticle()); HashMap<String, Object> map = new
	 * HashMap<>(); map.put("pagination", pagination); map.put("list", list);
	 * JdbcUtil.close(conn); return new Gson().toJson(map); } // 비활성화 된 병원 검색
	 * public String inactiveHospital(HttpServletRequest req) { Connection conn
	 * = JdbcUtil.getConnection(); int pageNo =
	 * Integer.parseInt(req.getParameter("pageNo")); int numberOfArticle =
	 * dao.selectCountHospital(conn); Pagination pagination =
	 * PagingUtil.setPageMaker(pageNo, numberOfArticle); ArrayList<Hospital>
	 * list = dao.selectByPagingHospital(conn, pagination.getStartArticle(),
	 * pagination.getEndArticle()); HashMap<String, Object> map = new
	 * HashMap<>(); map.put("pagination", pagination); map.put("list", list);
	 * JdbcUtil.close(conn); return new Gson().toJson(map); } // 비활성화 된 미용실 검색
	 * public String inactiveBeauty(HttpServletRequest req) { Connection conn =
	 * JdbcUtil.getConnection(); int pageNo =
	 * Integer.parseInt(req.getParameter("pageNo")); int numberOfArticle =
	 * dao.selectCountBeauty(conn); Pagination pagination =
	 * PagingUtil.setPageMaker(pageNo, numberOfArticle); ArrayList<Beauty> list
	 * = dao.selectByPagingBeauty(conn, pagination.getStartArticle(),
	 * pagination.getEndArticle()); HashMap<String, Object> map = new
	 * HashMap<>(); map.put("pagination", pagination); map.put("list", list);
	 * JdbcUtil.close(conn); return new Gson().toJson(map); } // 비활성화 된 호텔 검색
	 * public String inactiveHotel(HttpServletRequest req) { Connection conn =
	 * JdbcUtil.getConnection(); int pageNo =
	 * Integer.parseInt(req.getParameter("pageNo")); int numberOfArticle =
	 * dao.selectCountHotel(conn); Pagination pagination =
	 * PagingUtil.setPageMaker(pageNo, numberOfArticle); ArrayList<Hotel> list =
	 * dao.selectByPagingHotel(conn, pagination.getStartArticle(),
	 * pagination.getEndArticle()); HashMap<String, Object> map = new
	 * HashMap<>(); map.put("pagination", pagination); map.put("list", list);
	 * JdbcUtil.close(conn); return new Gson().toJson(map); }
	 */
	// 메세지 추가
	public String messageSend(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Admin a = (Admin) session.getAttribute("admin");
		int messageNo = dao.selectMessageNoMax(conn);
		int adminNo = a.getAdminNo();
		Message m = MappingUtil.getSendMessge(req, adminNo, messageNo);
		int result = dao.insertMessage(conn, m);
		JsonObject ob = new JsonObject();
		if (result == 1)
			ob.addProperty("result", "success");
		else
			ob.addProperty("result", "fail");
		JdbcUtil.close(conn);
		if (result == 1) {
			ob.addProperty("result", "success");
			ArrayList<Message> messagelist = messageSelect(req);
			session.setAttribute("messagelist", messagelist);
			session.setAttribute("messagelistgson", new Gson().toJson(messagelist));
		} else
			ob.addProperty("result", "fail");
		JdbcUtil.close(conn);

		return new Gson().toJson(ob);
	}

	public ArrayList<Message> messageSelect(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Message m = (Message) session.getAttribute("message");

		ArrayList<Message> result = dao.allMessage(conn, m);
		JdbcUtil.close(conn);
		return result;
	}

	// 로그인시 애완 동물 리스트 불러오기
	public ArrayList<Animal> animalSelectLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> member = new HashMap<>();
		member.put("member_id", req.getParameter("member_id"));
		member.put("member_pwd", req.getParameter("member_pwd"));
		Member m = dao.memberLogin(conn, member);

		ArrayList<Animal> result = dao.animalList(conn, m.getMemberNo());
		JdbcUtil.close(conn);
		return result;
	}

	// 애완 동물 추가하기
	public String animalInsert(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member) session.getAttribute("member");
		int memberNo = m.getMemberNo();
		int animalNo = dao.animalMaxNo(conn, memberNo);
		Animal a = MappingUtil.getAnimalFromRequest(req, animalNo, memberNo);
		int result = dao.animalInsert(conn, a);
		JsonObject ob = new JsonObject();
		if (result == 1) {
			ob.addProperty("result", "success");
			ArrayList<Animal> animallist = animalSelect(req);
			session.setAttribute("animallist", animallist);
			session.setAttribute("animallistgson", new Gson().toJson(animallist));
		} else
			ob.addProperty("result", "fail");
		JdbcUtil.close(conn);

		return new Gson().toJson(ob);
	}

	// 개인정보 애완 동물 리스트 불러오기
	public ArrayList<Animal> animalSelect(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member) session.getAttribute("member");

		ArrayList<Animal> result = dao.animalList(conn, m.getMemberNo());
		JdbcUtil.close(conn);
		return result;
	}

	// 개인정보 애완 동물 리스트 불러오기 지손(gson)
	public String animalSelectGson(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member) session.getAttribute("member");

		ArrayList<Animal> result = dao.animalList(conn, m.getMemberNo());
		JdbcUtil.close(conn);
		return new Gson().toJson(result);
	}

	// 일반회원 애완동물 수정(변경) 하기
	public String animalUpdate(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member) session.getAttribute("member");
		int memberNo = m.getMemberNo();
		int animalNo = Integer.parseInt(req.getParameter("animal_no"));
		Animal a = MappingUtil.getAnimalFromRequest(req, animalNo, memberNo);
		int result = dao.animalUpdate(conn, a);
		JsonObject ob = new JsonObject();
		if (result == 1) {
			ob.addProperty("result", "success");
			ArrayList<Animal> animallist = animalSelect(req);
			session.setAttribute("animallist", animallist);
			session.setAttribute("animallistgson", new Gson().toJson(animallist));
		} else
			ob.addProperty("result", "fail");

		JdbcUtil.close(conn);

		return new Gson().toJson(ob);

	}

	// 애완 동물 정보 가져오기
	public Animal animalView(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member) session.getAttribute("member");
		int memberNo = m.getMemberNo();
		int animalNo = Integer.parseInt(req.getParameter("animal_no"));
		Animal a = dao.animalView(conn, memberNo, animalNo);
		return a;
	}

	// 일반회원 로그아웃
	public void memberLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("member");
		session.removeAttribute("animallist");
		session.removeAttribute("animallistgson");
		session.removeAttribute("logincheck");
	}

	// 일반회원 애완동물 삭제
	public String animalDelete(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member) session.getAttribute("member");
		int memberNo = m.getMemberNo();
		int animalNo = Integer.parseInt(req.getParameter("animal_no"));
		int result = dao.animalDelete(conn, memberNo, animalNo);
		JsonObject ob = new JsonObject();
		ob.addProperty("result", result);
		if (result == 1) {
			System.out.println("삭제성공");
			ArrayList<Animal> animallist = animalSelect(req);
			session.setAttribute("animallist", animallist);
			session.setAttribute("animallistgson", new Gson().toJson(animallist));
		} else {

		}
		return new Gson().toJson(ob);
	}

	// 일반 회원 받은 메세지(쪽지) 리스트
	public String receiveBoard(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member) session.getAttribute("member");
		ArrayList<Message> list = dao.receiveMessageList(conn, m.getMemberNo());
		JdbcUtil.close(conn);
		return new Gson().toJson(list);

	}

	// 일반 회원 메세지(쪽지) 삭제
	public String messageDelete(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HttpSession session = req.getSession();
		Member m = (Member) session.getAttribute("member");
		dao.messageDelete(conn, Integer.parseInt(req.getParameter("message_no")), m.getMemberNo());
		ArrayList<Message> list = dao.receiveMessageList(conn, m.getMemberNo());
		JdbcUtil.close(conn);
		return new Gson().toJson(list);

	}
	///////////////////////////////////////
	// 호텔 서비스

	// 호텔 회원 등록(추가)
	public String hotelCreateEnd(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int hotelNo = dao.selectHotelNoMax(conn);
		Hotel hotel = MappingUtil.getHotelFromRequest(req, hotelNo);
		dao.hotelInsert(conn, hotel);
		JdbcUtil.close(conn);
		return new Gson().toJson(hotel);
	}

	// 호텔 로그인
	public Object hotelLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> user = new HashMap<>();
		user.put("user_id", req.getParameter("member_id"));
		user.put("user_pwd", req.getParameter("member_pwd"));
		Hotel result = dao.hotelLogin(conn, user);
		HttpSession session = req.getSession();

		if (result.getHotelId() == null) {
			System.out.println("아이디나 비밀번호 확인필요");
			session.setAttribute("logincheck", "아이디나 비밀번호 확인필요");
			JdbcUtil.close(conn);
			return null;
		} else {
			System.out.println("로그인 성공");
			session.removeAttribute("logincheck");
			session.setAttribute("hotel", result);
			session.setAttribute("hotelgson", new Gson().toJson(result));
			JdbcUtil.close(conn);
			return result;
		}
	}

	// 호텔회원 로그아웃
	public void hotelLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("hotel");
		session.removeAttribute("hotelgson");
		session.removeAttribute("logincheck");

	}

	// 호텔회원 아이디찾기
	public String hotelIdSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> hotel = new HashMap<>();
		hotel.put("hotel_mail", req.getParameter("hotel_mail"));
		hotel.put("hotel_orner_no", req.getParameter("hotel_orner_no"));
		JsonObject ob = new JsonObject();
		ob.addProperty("result", dao.findHotelId(conn, hotel));
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	// 호텔회원 비밀번호 찾기
	public String hotelPwdSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> hotel = new HashMap<>();
		hotel.put("hotel_mail", req.getParameter("hotel_mail"));
		hotel.put("hotel_orner_no", req.getParameter("hotel_orner_no"));
		hotel.put("hotel_id", req.getParameter("hotel_id"));
		JsonObject ob = new JsonObject();
		ob.addProperty("result", dao.findHotelPwd(conn, hotel));
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}
	// &&호텔회원 삭제
	
	//일반 회원 받은 메세지(쪽지) 리스트

	
	/*
	// 호텔 평점으로 검색(리스트)
	public String hotelScoreSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		ArrayList<Hotel> list = dao.selectHotelByScore(conn,req.getParameter("area"));
		JdbcUtil.close(conn);
		return new Gson().toJson(list);
	}
	
	// 호텔 상세보기
	public String hotelView(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int hotelNo = Integer.parseInt(req.getParameter("hotel_no"));
		Hotel h = dao.hotelView(conn, hotelNo);
		JdbcUtil.close(conn);
		return new Gson().toJson(h);
	}
	*/
	// 방 정보 보기
	public String roomView(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int hotelNo = Integer.parseInt(req.getParameter("hotel_no"));
		ArrayList<Room> rList = dao.roomAllView(conn, hotelNo);
		JdbcUtil.close(conn);
		return new Gson().toJson(rList);
	}

	/////////////
	// 미용 회원 등록(추가)
	public String beautyCreateEnd(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int beautyNo = dao.selectBeautyNoMax(conn);
		Beauty beauty = MappingUtil.getBeautyFromRequest(req, beautyNo);
		dao.beautyInsert(conn, beauty);
		JdbcUtil.close(conn);
		return new Gson().toJson(beauty);
	}

	// 미용 로그인
	public Object beautyLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> user = new HashMap<>();
		user.put("user_id", req.getParameter("member_id"));
		user.put("user_pwd", req.getParameter("member_pwd"));
		Beauty result = dao.beautyLogin(conn, user);
		HttpSession session = req.getSession();

		if (result.getBeautyId() == null) {
			System.out.println("아이디나 비밀번호 확인필요");
			session.setAttribute("logincheck", "아이디나 비밀번호 확인필요");
			JdbcUtil.close(conn);
			return null;
		} else {
			System.out.println("로그인 성공");
			session.removeAttribute("logincheck");
			session.setAttribute("beauty", result);
			JdbcUtil.close(conn);
			return result;
		}
	}

	// 미용회원 로그아웃
	public void beautyLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("beauty");
		session.removeAttribute("logincheck");

	}

	//////////////////
	// 병원 회원 등록(추가)
	public String hospitalCreateEnd(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int hospitalNo = dao.selectHospitalNoMax(conn);
		Hospital hospital = MappingUtil.getHospitalFromRequest(req, hospitalNo);
		dao.hospitalInsert(conn, hospital);
		JdbcUtil.close(conn);
		return new Gson().toJson(hospital);
	}

	// 병원 로그인
	public Object hospitalLogin(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> user = new HashMap<>();
		user.put("user_id", req.getParameter("member_id"));
		user.put("user_pwd", req.getParameter("member_pwd"));
		Hospital result = dao.hospitalLogin(conn, user);
		HttpSession session = req.getSession();

		if (result.getHospitalId() == null) {
			System.out.println("아이디나 비밀번호 확인필요");
			session.setAttribute("logincheck", "아이디나 비밀번호 확인필요");
			JdbcUtil.close(conn);
			return null;
		} else {
			System.out.println("로그인 성공");
			session.removeAttribute("logincheck");
		} return null;
		}
		/*
		//미용실 회원 아이디찾기
		public String beautyIdSearch(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HashMap<String, String> beauty = new HashMap<>();
			beauty.put("beauty_mail", req.getParameter("beauty_mail"));
			beauty.put("beauty_orner_no", req.getParameter("beauty_orner_no"));
			JsonObject ob = new JsonObject();
			ob.addProperty("result", dao.findbeautyId(conn, beauty));
			JdbcUtil.close(conn);
			return new Gson().toJson(ob);
		}
		
		//미용실 회원 비밀번호 찾기
		public String beautyPwdSearch(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HashMap<String, String> beauty = new HashMap<>();
			beauty.put("beauty_mail", req.getParameter("beauty_mail"));
			beauty.put("beauty_orner_no", req.getParameter("beauty_orner_no"));
			beauty.put("beauty_id", req.getParameter("beauty_id"));
			JsonObject ob = new JsonObject();
			ob.addProperty("result", dao.findbeautyPwd(conn, beauty));
			JdbcUtil.close(conn);
			return new Gson().toJson(ob);
		}
		*/

	/*
		//병원회원 로그아웃
		public void hospitalLogout(HttpServletRequest req) {
			HttpSession session = req.getSession();
			session.removeAttribute("hospital");
			session.removeAttribute("logincheck");
			
		}
		//병원회원 아이디 찾기
		public String hospitalIdSearch(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HashMap<String, String> hospital = new HashMap<>();
			hospital.put("hospital_mail", req.getParameter("hospital_mail"));
			hospital.put("hospital_orner_no", req.getParameter("hospital_orner_no"));
			JsonObject ob = new JsonObject();
			ob.addProperty("result", dao.findHospitalId(conn, hospital));
			JdbcUtil.close(conn);
			return new Gson().toJson(ob);
		}
		
		//병원회원 비밀번호 찾기
		public String hospitalPwdSearch(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HashMap<String , String> hospital = new HashMap<>();
			hospital.put("hospital_mail", req.getParameter("hospital_mail"));
			hospital.put("hospital_orner_no", req.getParameter("hospital_orner_no"));
			hospital.put("hospital_id", req.getParameter("hospital_id"));
			JsonObject ob = new JsonObject();
			ob.addProperty("result", dao.findHospitalPwd(conn, hospital));
			JdbcUtil.close(conn);
			return new Gson().toJson(ob);
		}
		*/
	// 미용실 회원 아이디찾기
	public String beautyIdSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> beauty = new HashMap<>();
		beauty.put("beauty_mail", req.getParameter("beauty_mail"));
		beauty.put("beauty_orner_no", req.getParameter("beauty_orner_no"));
		JsonObject ob = new JsonObject();
		ob.addProperty("result", dao.findbeautyId(conn, beauty));
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	// 미용실 회원 비밀번호 찾기
	public String beautyPwdSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> beauty = new HashMap<>();
		beauty.put("beauty_mail", req.getParameter("beauty_mail"));
		beauty.put("beauty_orner_no", req.getParameter("beauty_orner_no"));
		beauty.put("beauty_id", req.getParameter("beauty_id"));
		JsonObject ob = new JsonObject();
		ob.addProperty("result", dao.findbeautyPwd(conn, beauty));
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	//////////////////
	// 병원 회원 등록(추가)

	// 병원회원 로그아웃
	public void hospitalLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("hospital");
		session.removeAttribute("hospitalgson");
		session.removeAttribute("logincheck");

	}

	// 병원회원 아이디 찾기
	public String hospitalIdSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> hospital = new HashMap<>();
		hospital.put("hospital_mail", req.getParameter("hospital_mail"));
		hospital.put("hospital_orner_no", req.getParameter("hospital_orner_no"));
		JsonObject ob = new JsonObject();
		ob.addProperty("result", dao.findHospitalId(conn, hospital));
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	// 병원회원 비밀번호 찾기
	public String hospitalPwdSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		HashMap<String, String> hospital = new HashMap<>();
		hospital.put("hospital_mail", req.getParameter("hospital_mail"));
		hospital.put("hospital_orner_no", req.getParameter("hospital_orner_no"));
		hospital.put("hospital_id", req.getParameter("hospital_id"));
		JsonObject ob = new JsonObject();
		ob.addProperty("result", dao.findHospitalPwd(conn, hospital));
		JdbcUtil.close(conn);
		return new Gson().toJson(ob);
	}

	// 비활성화 된 회원 검색
	public String inactiveMemberSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		ArrayList<Member> list = dao.selectInactiveMember(conn);
		JdbcUtil.close(conn);
		return new Gson().toJson(list);
	}

	// 비활성화 된 병원 검색
	public String inactiveHospitalSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		ArrayList<Hospital> list = dao.selectInactiveHospital(conn);
		JdbcUtil.close(conn);
		return new Gson().toJson(list);
	}

	// 비활성화 된 미용실 검색
	public String inactiveBeautySearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		ArrayList<Beauty> list = dao.selectInactiveBeauty(conn);
		JdbcUtil.close(conn);
		return new Gson().toJson(list);
	}

	// 비활성화 된 호텔 검색
	public String inactiveHotelSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		ArrayList<Hotel> list = dao.selectInactiveHotel(conn);
		JdbcUtil.close(conn);
		return new Gson().toJson(list);
	}

	// 호텔 리뷰순으로 검색
	public String hotelReviewSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		ArrayList<Hotel> list = dao.selectHotelByReview(conn, req.getParameter("area"));
		JdbcUtil.close(conn);
		return new Gson().toJson(list);
	}

	// 호텔 평점으로 검색(리스트)
	public String hotelScoreSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		ArrayList<Hotel> list = dao.selectHotelByScore(conn, req.getParameter("area"));
		JdbcUtil.close(conn);
		return new Gson().toJson(list);
	}

	// 지역별 호텔 검색
	public String hotelAreaSearch(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		ArrayList<Hotel> list = dao.selectHotelByArea(conn, req.getParameter("area"));
		JdbcUtil.close(conn);
		return new Gson().toJson(list);
	}

	// 호텔 상세보기
	public String hotelView(HttpServletRequest req) {
		Connection conn = JdbcUtil.getConnection();
		int hotelNo = Integer.parseInt(req.getParameter("hotel_no"));
		Hotel h = dao.hotelView(conn, hotelNo);
		JdbcUtil.close(conn);
		return new Gson().toJson(h);
	}
	


	/////////////////////////
	//병원
	
	// 병원 리뷰순으로 검색
		public String hospitalReviewSearch(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			ArrayList<Hospital> list = dao.selectHospitalByReview(conn, req.getParameter("area"));
			JdbcUtil.close(conn);
			return new Gson().toJson(list);
		}

		// 병원 평점으로 검색(리스트)
		public String hospitalScoreSearch(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			ArrayList<Hospital> list = dao.selectHospitalByScore(conn, req.getParameter("area"));
			JdbcUtil.close(conn);
			return new Gson().toJson(list);
		}

		// 지역별 병원 검색
		public String hospitalAreaSearch(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			ArrayList<Hospital> list = dao.selectHospitalByArea(conn, req.getParameter("area"));
			JdbcUtil.close(conn);
			return new Gson().toJson(list);
		}

		// 병원 상세보기
		public String hospitalView(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			int hospitalNo = Integer.parseInt(req.getParameter("hospital_no"));
			Hospital h = dao.hospitalView(conn, hospitalNo);
			JdbcUtil.close(conn);
			return new Gson().toJson(h);
		}
		
	/////////////////////
		//미용
		
		// 미용 리뷰순으로 검색
		public String beautyReviewSearch(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			ArrayList<Beauty> list = dao.selectBeautyByReview(conn, req.getParameter("area"));
			JdbcUtil.close(conn);
			return new Gson().toJson(list);
		}

		// 미용 평점으로 검색(리스트)
		public String beautyScoreSearch(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			ArrayList<Beauty> list = dao.selectBeautyByScore(conn, req.getParameter("area"));
			JdbcUtil.close(conn);
			return new Gson().toJson(list);
		}

		// 지역별 미용 검색
		public String beautyAreaSearch(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			ArrayList<Beauty> list = dao.selectBeautyByArea(conn, req.getParameter("area"));
			JdbcUtil.close(conn);
			return new Gson().toJson(list);
		}

		// 미용 상세보기
		public String beautyView(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			int beautyNo = Integer.parseInt(req.getParameter("beauty_no"));
			Beauty h = dao.beautyView(conn, beautyNo);
			JdbcUtil.close(conn);
			return new Gson().toJson(h);
		}

		// 호텔 방 추가하기
		public String roomInsert(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			HttpSession session = req.getSession();
			Hotel h = (Hotel)session.getAttribute("hotel");
			int roomNo = dao.selectRoomNoMax(conn,h.getHotelNo());
			Room r = MappingUtil.getRoomFromRequest(req,roomNo,h.getHotelNo());
			int result = dao.roomInsert(conn, r);
			
			JdbcUtil.close(conn);
			return new Gson().toJson(r);
		}
		
		// 관리자 페이지에서 비활성화 호텔 리스트 불러오기
		public ArrayList<Hotel> inactiveHotelSelect(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HttpSession session = req.getSession();
			Admin a = (Admin) session.getAttribute("admin");
			ArrayList<Hotel> result =dao.selectInactiveHotel(conn);
			JdbcUtil.close(conn);
			return result;
		}

		//호텔회원 삭제 
		public String deleteHotel(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HttpSession session = req.getSession();
			Admin a = (Admin) session.getAttribute("admin");
			int adminNo = a.getAdminNo();
			int hotelNo = Integer.parseInt(req.getParameter("hotel_no"));
			int result = dao.deleteHotel(conn, hotelNo);
			JsonObject ob = new JsonObject();
			ob.addProperty("result", result);
			if(result ==1 ){
				System.out.println("삭제성공");
				ArrayList<Hotel> hotelList = inactiveHotelSelect(req);
				session.setAttribute("hotelList", hotelList);
				session.setAttribute("hotelListgson", new Gson().toJson(hotelList));
			}
			return new Gson().toJson(ob);
			
		}
		
		// 관리자 페이지에서 비활성화 병원 리스트 불러오기
		public ArrayList<Hospital> inactiveHospitalSelect(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HttpSession session = req.getSession();
			Admin a = (Admin) session.getAttribute("admin");
			ArrayList<Hospital> result = dao.selectInactiveHospital(conn);
			JdbcUtil.close(conn);
			return result;
		}
	
		//병원회원 삭제
		public String deleteHospital(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HttpSession session = req.getSession();
			Admin a = (Admin) session.getAttribute("admin");
			int adminNo = a.getAdminNo();
			int hospitalNo = Integer.parseInt(req.getParameter("hospital_no"));
			int result  = dao.deleteHospital(conn, hospitalNo);
			JsonObject ob = new JsonObject();
			ob.addProperty("result", result);
			if(result == 1 ){
				System.out.println("삭제성공");
				ArrayList<Hospital> hospitalList = inactiveHospitalSelect(req);
				session.setAttribute("hospitalList", hospitalList);
				session.setAttribute("hospitalListgson", new Gson().toJson(hospitalList));
			}
			return new Gson().toJson(ob);
		}
		
		// 관리자 페이지에서 비활성화 미용실 리스트 불러오기
		public ArrayList<Beauty> inactiveBeautySelect(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HttpSession session = req.getSession();
			Admin a = (Admin) session.getAttribute("admin");
			ArrayList<Beauty> result = dao.selectInactiveBeauty(conn);
			JdbcUtil.close(conn);
			return result;
		}
		
		// 미용실회원 삭제
		public String deleteBeauty(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HttpSession  session = req.getSession();
			Admin a = (Admin) session.getAttribute("admin");
			int adminNo = a.getAdminNo();
			int beautyNo = Integer.parseInt(req.getParameter("beauty_no"));
			int result = dao.deleteBeauty(conn, beautyNo);
			JsonObject ob = new JsonObject();
			ob.addProperty("result", result);
			if(result==1){
				System.out.println("삭제성공");
				ArrayList<Beauty> beautyList = inactiveBeautySelect(req);
				session.setAttribute("beautyList", beautyList);
				session.setAttribute("beaautyListgson", new Gson().toJson(beautyList));
			}
			return new Gson().toJson(ob);
		}
		//호텔 정보 수정하기
		public String hotelUpdate(HttpServletRequest req) {
			Connection conn = JdbcUtil.getConnection();
			HttpSession session = req.getSession();
			Hotel h = (Hotel)session.getAttribute("hotel");
			Hotel hotel = h;
			hotel.setHotelName(req.getParameter("hotel_name"));
			hotel.setHotelPhone(req.getParameter("hotel_phone"));
			hotel.setHotelPwd(req.getParameter("hotel_pwd"));
			hotel.setHotelAddress(req.getParameter("hotel_address"));
			hotel.setHotelMail(req.getParameter("hotel_mail"));
			dao.updateHotel(conn, hotel);
			session.setAttribute("hotel", hotel);
			session.setAttribute("hotelgson", new Gson().toJson(hotel));
			JdbcUtil.close(conn);
			return new Gson().toJson(hotel);
		}
		
		// 회원 쿠폰수 검색
		public String memberCoupon(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			ArrayList<Member> list = dao.selectMemberByCoupon(conn);
			JdbcUtil.close(conn);
			return new Gson().toJson(list);
		}
		// 회원 쿠폰수 조정
		public String memberCouponUpadte(HttpServletRequest req){
			Connection conn = JdbcUtil.getConnection();
			HttpSession session = req.getSession();
			Admin a = (Admin)session.getAttribute("admin");
			Member m = new Member();
			int memberNo = m.getMemberNo();
			dao.updateMemberCoupon(conn, memberNo);
			session.setAttribute("m", m);
			session.setAttribute("mgson", new Gson().toJson(m));
			JdbcUtil.close(conn);
			return new Gson().toJson(m);
			
		}
		
}
