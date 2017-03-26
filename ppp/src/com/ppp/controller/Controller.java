package com.ppp.controller;

import java.sql.Connection;
import java.util.*;

import javax.servlet.http.*;

import org.apache.catalina.Server;

import com.google.gson.*;
import com.ppp.di.*;
import com.ppp.service.*;
import com.ppp.util.*;
import com.ppp.vo.*;

public class Controller {
	// 일반회원 등록(추가)폼
	/*@RequestMapping(value = "/member/memberregister", method = "GET")
	public static ModelAndView memberRegisterStart(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setView("/members/memberResistration.html");
		return mav;
	}*/

	// 일반회원 등록(추가)
	@RequestMapping(value = "/member/memberregister", method = "POST")
	public static ModelAndView memberRegisterEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.memberCreateEnd(req));
		mav.setView("/ppp/members/MemberHome.jsp");
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
			//로그인실패
			mav.setView("/ppp/member/membermain");
			mav.setRedirect();
		} else {
			//로그인성공
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
	
	// 회원 홈페이지로 이동
		@RequestMapping(value = "/member/memberhome", method = "GET")
		public static ModelAndView memberHome(HttpServletRequest req) {
			ModelAndView mav = new ModelAndView();
			HttpSession session = req.getSession();
			mav.setView("/ppp/members/memberindex2.jsp");
			mav.setRedirect();
			return mav;
		}
		
		
	//////////////////////////////////////////////////////////////////

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

	//////////////////////////
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
/////////////////////////////////////////////////////////////
	// 비활성화 된 회원 검색
	@RequestMapping(value="/admin/memberdeactiviysearch", method="GET")
	public static ModelAndView list(HttpServletRequest req) {
		Service service = (Service)req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.inactiveMember(req));
		mav.setView("/ppp/admins/list.jsp");
		return mav;
	}
	
	// 비활성화 된 병원회원 검색
	@RequestMapping(value="/admin/hospitaldeactiviysearch", method="GET")
	public static ModelAndView hospitalList(HttpServletRequest req){
		Service service = (Service)req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.inactiveHospital(req));
		mav.setView("/ppp/admins/hospitalList.jsp");
		return mav;
	}
	
	// 비활성화 된 미용실회원 검색
	@RequestMapping(value="/admin/beautydeactiviysearch", method="GET")
	public static ModelAndView beautyList(HttpServletRequest req){
		Service service = (Service)req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.inactiveBeauty(req));
		mav.setView("/ppp/admins/beautyList.jsp");
		return mav;
	}
	
	// 비활성화 된 호텔회원 검색
	@RequestMapping(value="/admin/hoteldeactiviysearch", method="GET")
	public static ModelAndView hotelList(HttpServletRequest req){
		Service service = (Service)req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.inactiveHotel(req));
		mav.setView("/ppp/admins/hotelList.jsp");
		return mav;
	}
}

