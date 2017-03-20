package com.ppp.controller;

import javax.servlet.http.*;

import com.ppp.di.*;
import com.ppp.service.*;

public class Controller {
	
	@RequestMapping(value="/petpapa/memberregister", method="GET")
	public static ModelAndView registerStart(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		mav.setView("/memberResistration.html");
		
		return mav;
	}
	@RequestMapping(value="/petpapa/memberregister", method="POST")
	public static ModelAndView registerEnd(HttpServletRequest req){
		Service service = (Service)req.getServletContext().getAttribute("service");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", service.createEnd(req));
		mav.setView("/memberResistration.html");
		mav.setRedirect();
		
		return mav;
	}
	
}
