<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("member")!=null){ %>
	<%@ include file="yesheader.jsp" %>
	<%} else if(session.getAttribute("hotel")!=null){ %>
	<%@ include file="hotelheader.jsp" %>
	<%} else if(session.getAttribute("hospital")!=null){ %>
	<%@ include file="hospitalheader.jsp" %>
	<%} else if(session.getAttribute("beauty")!=null){ %>
	<%@ include file="beautyheader.jsp" %>
	<%} else{ %>
	<%@ include file="noheader.jsp" %>
	<%} %>
</body>
</html>