package com.ppp.filter;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.ppp.vo.*;

@WebFilter("/*")
public class PppLoginFilter implements Filter {
	// 로그인 없이 접근할 수 있는 경로를 지정
	private ArrayList<String> whiteList = new ArrayList<>();
    public PppLoginFilter() {
    	
    	whiteList.add("/ppp/member/memberidsearch");
    	whiteList.add("/ppp/member/memberpwdsearch");
    	whiteList.add("/ppp/members/MemberHome.html");
    	whiteList.add("/ppp/members/MemberHomeTest.html");
    	whiteList.add("/ppp/admins/adminindex.jsp");
    	whiteList.add("/ppp/admins/adminindex2.jsp");
    	whiteList.add("/ppp/member/login");
    	whiteList.add("/ppp/member/memberregister");
    	whiteList.add("/ppp/admin/adminregister");
    	whiteList.add("/ppp/admins/adminRegistration.html");
    	whiteList.add("/ppp/admin/adminlogin");
    	whiteList.add("/ppp/admins/adminLogin.jsp");
    	whiteList.add("/ppp/members/login.jsp");
    	
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();
		System.out.println("filter uri: "+uri);
		String go = uri;
		Member member = (Member)session.getAttribute("member");
		Admin admin = (Admin)session.getAttribute("admin");
		// 화이트리스트에 없는 로그인이 필요한 경로에 접근했고 로그인이 안된 경우
		if((!whiteList.contains(uri)) && (member==null && admin==null)) {
			System.out.println("로그인 안됨");
			// 예를 들어 /board/view를 요청했는데 로그인이 안된 경우
			// 로그인을 한 다음 /board/view로 다시 이동해야 한다
			// 따라서 로그인 후 다시 이동할 주소를 세션에 저장한 다음 로그인으로 이동
			String user = uri.substring(uri.indexOf("/",2)+1, uri.lastIndexOf("/"));
			System.out.println("user : " + user);
			if(user.equals("member") || user.equals("members"))
				go = "/ppp/member/login";
			if(user.equals("admin") || user.equals("admins"))
				go = "/ppp/admin/adminlogin";
			session.setAttribute("destination", uri);
			if(req.getParameter("member_no")!=null)
				session.setAttribute("member_no", req.getParameter("member_no"));
			if(req.getParameter("admin_no")!=null)
				session.setAttribute("admin_no", req.getParameter("admin_no"));
			res.sendRedirect(go);
		} else {
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
