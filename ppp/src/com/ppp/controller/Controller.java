package com.ppp.controller;

import javax.servlet.http.*;

import com.ppp.di.*;
import com.ppp.service.*;
import com.ppp.util.*;
import com.ppp.vo.*;

public class Controller {
	// 일반회원 등록(추가)폼
	/*
	 * @RequestMapping(value = "/member/memberregister", method = "GET") public
	 * static ModelAndView memberRegisterStart(HttpServletRequest req) {
	 * ModelAndView mav = new ModelAndView();
	 * mav.setView("/members/memberResistration.html"); return mav; }
	 */

	// 일반회원 등록(추가)
	@RequestMapping(value = "/member/memberregister", method = "POST")
	public static ModelAndView memberRegisterEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.memberCreateEnd(req));
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();

		return mav;
	}

	// 일반회원 로그인(폼으로)
	@RequestMapping(value = "/member/login", method = "GET")
	public static ModelAndView memberLoginStart(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		String go = (String) session.getAttribute("destination");
		System.out.println("go:" + go);
		mav.setView("/members/login.jsp");

		return mav;
	}

	// 일반회원 로그인
	@RequestMapping(value = "/member/login", method = "POST")
	public static ModelAndView memberLoginEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		if (service.memberLogin(req) == null) {
			// 로그인실패
			mav.setView("/ppp/member/membermain");
			mav.setRedirect();
		} else {
			// 로그인성공
			HttpSession session = req.getSession();
			String go = (String) session.getAttribute("destination");
			System.out.println("go:" + go);
			session.removeAttribute("destination");
			if (go == null)
				go = "/ppp/member/membermain";
			mav.setView(go);
			mav.setRedirect();
		}
		return mav;
	}

	// 일반회원 로그아웃
	@RequestMapping(value = "/member/memberlogout", method = "GET")
	public static ModelAndView memberIdCheck(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		service.memberLogout(req);
		ModelAndView mav = new ModelAndView();
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();

		return mav;
	}

	// 일반회원 아이디찾기(폼)
	@RequestMapping(value = "/member/memberidsearch", method = "GET")
	public static ModelAndView memberIdSearchStart(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/members/MemberIdSearch.jsp");

		return mav;
	}

	// 일반회원 아이디찾기
	@RequestMapping(value = "/member/memberidsearch", method = "AJAX")
	public static ModelAndView memberIdSearchEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.memberIdSearch(req));
		return mav;
	}

	// 일반회원 비밀번호 찾기(폼)
	@RequestMapping(value = "/member/memberpwdsearch", method = "GET")
	public static ModelAndView memberPwdSearch(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/members/MemberPwdSearch.jsp");

		return mav;
	}

	// 일반회원 비밀번호찾기
	@RequestMapping(value = "/member/memberpwdsearch", method = "AJAX")
	public static ModelAndView memberPwdSearchEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.memberPwdSearch(req));
		return mav;
	}

	// 일반회원 개인 정보보기(폼으로)
	@RequestMapping(value = "/member/memberinfo", method = "GET")
	public static ModelAndView memberInfo(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/members/MemberInfo.jsp");

		return mav;
	}

	// 일반회원 정보 수정(폼으로)
	@RequestMapping(value = "/member/memberupdate", method = "GET")
	public static ModelAndView memberUpdateStart(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/members/MemberUpdate.jsp");

		return mav;
	}

	// 일반회원 메인으로
	@RequestMapping(value = "/member/membermain", method = "GET")
	public static ModelAndView memberMain(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/members/MemberHome.jsp");

		return mav;
	}

	// 일반회원 정보 수정
	@RequestMapping(value = "/member/memberupdate", method = "POST")
	public static ModelAndView memberUpdateEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.memberUpdate(req));
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();
		return mav;
	}

	// 일반회원 로그인테스트
	@RequestMapping(value = "/member/membertest", method = "GET")
	public static ModelAndView memberTest(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();
		return mav;
	}

	// 일반회원 동물 추가(폼으로)
	@RequestMapping(value = "/member/animalinsert", method = "GET")
	public static ModelAndView animalInsertStart(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/ppp/members/AnimalInsert.jsp");
		mav.setRedirect();
		return mav;
	}

	// 일반회원 동물 추가
	@RequestMapping(value = "/member/animalinsert", method = "POST")
	public static ModelAndView animalInsertEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/ppp/member/membermain");
		mav.addObject("result", service.animalInsert(req));
		mav.setRedirect();
		return mav;
	}

	// 일반회원 동물 수정(변경)(폼으로)
	@RequestMapping(value = "/member/animalupdate", method = "GET")
	public static ModelAndView animalUpdateStart(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.animalView(req));
		mav.setView("/members/AnimalUpdate.jsp");

		return mav;
	}

	// 일반회원 동물 수정
	@RequestMapping(value = "/member/animalupdate", method = "POST")
	public static ModelAndView animalUpdateEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.animalUpdate(req));
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();

		return mav;
	}

	// 일반회원 동물 삭제(폼으로)
	@RequestMapping(value = "/member/animaldelete", method = "GET")
	public static ModelAndView animalDeleteStart(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.animalDelete(req));
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();
		return mav;
	}

	// 일반회원 받은 메세지 보기
	@RequestMapping(value = "/board/receivemessage", method = "GET")
	public static ModelAndView receiveMessageStart(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.receiveBoard(req));
		mav.setView("/members/ReceiveMessage.jsp");

		return mav;
	}

	// 일반회원 받은 메세지 삭제
	@RequestMapping(value = "/board/receivemessagedelete", method = "GET")
	public static ModelAndView receiveMessageDelete(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.messageDelete(req));
		mav.setView("/members/ReceiveMessage.jsp");

		return mav;
	}
	/////////////////////////////////
	/////////////////////////////////
	/////////////////////////////////
	// 호텔 컨트롤러

	// 호텔 회원 등록
	@RequestMapping(value = "/hotel/hotelregister", method = "POST")
	public static ModelAndView hotelRegisterEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.hotelCreateEnd(req));
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();

		return mav;
	}

	// 호텔 회원 로그인
	@RequestMapping(value = "/hotel/login", method = "POST")
	public static ModelAndView hotelLoginEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		if (service.hotelLogin(req) == null) {
			// 로그인실패
			mav.setView("/ppp/member/membermain");
			mav.setRedirect();
		} else {
			// 로그인성공
			HttpSession session = req.getSession();
			String go = (String) session.getAttribute("destination");
			System.out.println("go:" + go);
			session.removeAttribute("destination");
			if (go == null)
				go = "/ppp/member/membermain";
			mav.setView(go);
			mav.setRedirect();
		}
		return mav;
	}

	// 호텔회원 로그아웃
	@RequestMapping(value = "/hotel/hotellogout", method = "GET")
	public static ModelAndView hotelLogout(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		service.hotelLogout(req);
		ModelAndView mav = new ModelAndView();
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();

		return mav;
	}
	
	//호텔 지역으로 검색(리스트)
	@RequestMapping(value = "/hotel/hotelareasearch", method = "GET")
	public static ModelAndView hotelAreaSearch(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.hotelAreaSearch(req));
		mav.setView("/hotels/HotelAreaSearch.jsp");

		return mav;
	}
	
	//호텔 상세보기
	@RequestMapping(value = "/hotel/hotelview", method = "GET")
	public static ModelAndView hotelView(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("hotel", service.hotelView(req));
		mav.addObject("room", service.roomView(req));
		mav.setView("/hotels/HotelView.jsp");

		return mav;
	}
	
	
	/////////////////////////////////
	/////////////////////////////////
	/////////////////////////////////
	// 미용 컨트롤러

	// 미용 회원 등록
	@RequestMapping(value = "/beauty/beautyregister", method = "POST")
	public static ModelAndView beautyRegisterEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.beautyCreateEnd(req));
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();

		return mav;
	}

	// 미용 회원 로그인
	@RequestMapping(value = "/beauty/login", method = "POST")
	public static ModelAndView beautyLoginEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		if (service.beautyLogin(req) == null) {
			// 로그인실패
			mav.setView("/ppp/member/membermain");
			mav.setRedirect();
		} else {
			// 로그인성공
			HttpSession session = req.getSession();
			String go = (String) session.getAttribute("destination");
			System.out.println("go:" + go);
			session.removeAttribute("destination");
			if (go == null)
				go = "/ppp/member/membermain";
			mav.setView(go);
			mav.setRedirect();
		}
		return mav;
	}

	// 미용회원 로그아웃
	@RequestMapping(value = "/beauty/beautylogout", method = "GET")
	public static ModelAndView beautyLogout(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		service.beautyLogout(req);
		ModelAndView mav = new ModelAndView();
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();

		return mav;
	}

	/////////////////////////////////
	/////////////////////////////////
	/////////////////////////////////
	// 병원 컨트롤러
	// 병원 회원 등록
	@RequestMapping(value = "/hospital/hospitalregister", method = "POST")
	public static ModelAndView hospitalRegisterEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.hospitalCreateEnd(req));
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();

		return mav;
	}

	// 병원 회원 로그인
	@RequestMapping(value = "/hospital/login", method = "POST")
	public static ModelAndView hospitalLoginEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		if (service.hospitalLogin(req) == null) {
			// 로그인실패
			mav.setView("/ppp/member/membermain");
			mav.setRedirect();
		} else {
			// 로그인성공
			HttpSession session = req.getSession();
			String go = (String) session.getAttribute("destination");
			System.out.println("go:" + go);
			session.removeAttribute("destination");
			if (go == null)
				go = "/ppp/member/membermain";
			mav.setView(go);
			mav.setRedirect();
		}
		return mav;
	}

	// 병원 회원 로그아웃
	@RequestMapping(value = "/hospital/hospitallogout", method = "GET")
	public static ModelAndView hospitalLogout(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		service.hospitalLogout(req);
		ModelAndView mav = new ModelAndView();
		mav.setView("/ppp/member/membermain");
		mav.setRedirect();

		return mav;
	}

	//////////////////////////
	// 관리자 컨트롤러

	// 관리자 등록(추가)폼
	@RequestMapping(value = "/admin/adminregister", method = "GET")
	public static ModelAndView adminRegisterStart(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setView("/admins/adminResistration.html");
		return mav;
	}

	// 관리자 등록(추가)
	@RequestMapping(value = "/admin/adminregister", method = "POST")
	public static ModelAndView adminRegisterEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.adminCreateEnd(req));
		mav.setView("/ppp/admins/adminindex.jsp");
		mav.setRedirect();

		return mav;
	}

	// 관리자 로그인(폼으로)
	@RequestMapping(value = "/admin/adminlogin", method = "GET")
	public static ModelAndView adminLoginStart(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		String go = (String) session.getAttribute("destination");
		System.out.println("1go:" + go);
		mav.setView("/admins/adminLogin.jsp");

		return mav;
	}

	// 관리자 로그인
	@RequestMapping(value = "/admin/adminlogin", method = "POST")
	public static ModelAndView adminLoginEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		int adminNo = service.adminLogin(req);

		if (adminNo == 0) {
			System.out.println("아이디나 비밀번호 확인필요");
			mav.setView("/admins/adminLogin.jsp");
		} else {
			System.out.println("로그인 성공");
			HttpSession session = req.getSession();
			String go = (String) session.getAttribute("destination");
			if (go == null || go.equals("")) {
				go = "/ppp/admins/adminindex2.jsp";
			}
			System.out.println("admin login go:" + go);
			session.removeAttribute("destination");

			Admin admin = MappingUtil.getAdminFromRequest(req, adminNo);
			session.setAttribute("admin", admin);
			mav.setView(go);
			mav.setRedirect();
		}
		return mav;
	}

	

	// 관리자 홈페이지로 이동
	@RequestMapping(value = "/admin/adminhome", method = "GET")
	public static ModelAndView adminHome(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		mav.setView("/ppp/admins/adminindex2.jsp");
		mav.setRedirect();
		return mav;
	}
	// 회원 쿠폰수 검색

}

