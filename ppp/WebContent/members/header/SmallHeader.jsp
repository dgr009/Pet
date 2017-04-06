<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
