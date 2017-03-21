package com.ppp.controller;

import javax.servlet.http.*;

import com.ppp.di.*;
import com.ppp.service.*;
import com.ppp.util.*;
import com.ppp.vo.*;

public class Controller {
	// 회원 등록(추가)폼
	@RequestMapping(value = "/member/memberregister", method = "GET")
	public static ModelAndView registerStart(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setView("/members/memberResistration.html");
		return mav;
	}

	// 멤버 등록(추가)
	@RequestMapping(value = "/member/memberregister", method = "POST")
	public static ModelAndView registerEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.memberCreateEnd(req));
		mav.setView("/ppp/index.html");
		mav.setRedirect();

		return mav;
	}

	// 로그인
	@RequestMapping(value = "/member/login", method = "GET")
	public static ModelAndView memberLoginStart(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		String go = (String)session.getAttribute("destination");
		System.out.println("go:" + go);
		mav.setView("/services/login.jsp");

		return mav;
	}

	// 로그인
	@RequestMapping(value = "/member/login", method = "POST")
	public static ModelAndView memberLoginEnd(HttpServletRequest req) {
		Service service = (Service) req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/services/login.jsp");
		int memberNo = service.memberLogin(req);

		if (memberNo == 0) {
			System.out.println("아이디나 비밀번호 확인필요");
			mav.setView("/services/login.jsp");
		} else {
			System.out.println("로그인 성공");
			HttpSession session = req.getSession();
			String go = (String) session.getAttribute("destination");
			System.out.println("go:" + go);
			session.removeAttribute("destination");
			if (go == null)
				go = "/ppp/index.html";
			Member member = MappingUtil.getMemberFromRequest(req, memberNo);
			session.setAttribute("member", member);
			mav.setView(go);
			mav.setRedirect();
		}
		return mav;
	}
}
