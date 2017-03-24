<%@page import="com.ppp.vo.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- a.member_no,a.animal_no,a.animal_name,a.animal_kind,a.animal_gender,a.animal_breed,a.animal_weight  -->
<form action='/ppp/member/animalinsert' method='post'>
<table border='1'>
	<tr><td>동물 이름</td><td><input type='text' name='animal_name'></td></tr>
	<tr><td>동물 종류</td><td><input type='text' name='animal_kind'></td></tr>
	<tr><td>동물 성별</td><td><input type='text' name='animal_gender'></td></tr>
	<tr><td>동물 품종</td><td><input type='text' name='animal_breed'></td></tr>
	<tr><td>동물 무게</td><td><input type='text' name='animal_weight'></td></tr>
</table>
<button>추가</button>

<input type='button' onclick='location.href="/ppp/member/membermain"' value='취소'>
</form>
</body>
</html>