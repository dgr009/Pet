package com.ppp.controller;

import javax.servlet.http.*;

import com.ppp.di.*;
import com.ppp.service.*;
import com.ppp.util.*;
import com.ppp.vo.*;

public class Controller {
	// 회원 등록(추가)폼
	@RequestMapping(value = "/member/memberregister", method = "GET")
	public static ModelAndView memberRegisterStart(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setView("/members/memberResistration.html");
		return mav;
	}

	// 멤버 등록(추가)
	@RequestMapping(value = "/member/memberregister", method = "POST")
	public static ModelAndView memberRegisterEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.memberCreateEnd(req));
		mav.setView("/ppp/MemberHome.html");
		mav.setRedirect();

		return mav;
	}

	// 로그인(폼으로)
	@RequestMapping(value = "/member/login", method = "GET")
	public static ModelAndView memberLoginStart(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		String go = (String) session.getAttribute("destination");
		System.out.println("go:" + go);
		mav.setView("/members/login.jsp");

		return mav;
	}

	// 로그인
	@RequestMapping(value = "/member/login", method = "POST")
	public static ModelAndView memberLoginEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/members/login.jsp");
		int memberNo = service.memberLogin(req);

		if (memberNo == 0) {
			System.out.println("아이디나 비밀번호 확인필요");
			mav.setView("/members/login.jsp");
		} else {
			System.out.println("로그인 성공");
			HttpSession session = req.getSession();
			String go = (String) session.getAttribute("destination");
			System.out.println("go:" + go);
			session.removeAttribute("destination");
			if (go == null)
				go = "/ppp/MemberHome.html";
			Member member = MappingUtil.getMemberFromRequest(req, memberNo);
			session.setAttribute("member", member);
			mav.setView(go);
			mav.setRedirect();
		}
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
		String go = (String)session.getAttribute("destination");
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
			if (go==null || go.equals("")) {
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
	
	//회원 홈페이지로 이동
	@RequestMapping(value = "/member/memberhome", method = "GET")
	public static ModelAndView memberHome(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		mav.setView("/ppp/members/memberindex2.jsp");
		mav.setRedirect();
		return mav;
	}
	
	//관리자 홈페이지로 이동
	@RequestMapping(value = "/admin/adminhome", method = "GET")
	public static ModelAndView adminHome(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		mav.setView("/ppp/admins/adminindex2.jsp");
		mav.setRedirect();
		return mav;
	}
}
