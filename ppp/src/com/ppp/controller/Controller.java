package com.ppp.controller;

import javax.servlet.http.*;

import com.ppp.di.*;
import com.ppp.service.*;
import com.ppp.vo.*;

public class Controller {
	//회원 등록(추가)폼
	@RequestMapping(value="/member/memberregister", method="GET")
	public static ModelAndView registerStart(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		mav.setView("/members/memberResistration.html");
		System.out.println("view:" + mav.getView());
		return mav;
	}
	
	//멤버 등록(추가)
	@RequestMapping(value="/member/memberregister", method="POST")
	public static ModelAndView registerEnd(HttpServletRequest req){
		Service service = (Service)req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.memberCreateEnd(req));
		mav.setView("/members/memberResistration.html");
		mav.setRedirect();
		
		return mav;
	}
	
	//로그인
	@RequestMapping(value="/member/login", method="GET")
	public static ModelAndView memberLogin(HttpServletRequest req){
		Service service = (Service)req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.setView("/services/login.jsp");
		System.out.println("들어옴??");
		int memberNo = service.memberLogin(req);
		
		if(memberNo==0) {
			mav.setView("/services/login.jsp");
			System.out.println("sadasd");
		}
		else {
			HttpSession session = req.getSession();
			String go = (String)session.getAttribute("destination");
			System.out.println("go:" + go);
			session.removeAttribute("destination");
			if(go==null) 
				go = "/ppp/index.html";
			Member member = new Member();
			member.setMemberNo(memberNo);
			member.setMemberId(req.getParameter("member_id"));
			session.setAttribute("member", member);
			mav.setView(go);
			mav.setRedirect();
		}
		return mav;
	}
}
