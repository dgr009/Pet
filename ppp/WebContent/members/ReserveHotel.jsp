<%@page import="com.ppp.vo.Hotel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Hotel h = (Hotel) request.getAttribute("hotel");
%>
<link href="/ppp/css/reset.css" rel="stylesheet" />
<head>
<style>
header {
	height: 135px;
}

.hotel_info{
	margin-left:20px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 -->
	<%@ include file="/members/BigHeader.jsp"%>
	<header> 안보이지롱 </header>


	<div class='hotel_info'>
	<h3><%=h.getHotelName()%></h3>
	<p class="address btn_copy"><%=h.getHotelAddress()%></p>
	<p class="tel"><%=h.getHotelPhone()%></p>
	</div>
<div>
				<!--
				<span><input type="text" id="datepic_01" placeholder="입실 날짜 선택"  value="2017-04-03" readonly="true" /></span>
				-->
				<span><input type="text" id="newdatepic_01" class="datepicker picker__input" value="2017-04-03" readonly="" aria-haspopup="true" aria-expanded="false" aria-readonly="false" aria-owns="newdatepic_01_root"><input type="hidden" name="_submit" value="2017-04-03"></span>
			</div>
</body>
</html>