<%@page import="com.ppp.vo.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>반려동물 추가</h2>
		<form action='/ppp/member/animalinsert' method='post'>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th width="15%">동물 이름</th>
						<td><input type='text' name='animal_name'></td>
					</tr>
					<tr>
						<th>동물 종류</th>
						<td><input type='text' name='animal_kind'></td>
					</tr>
					<tr>
						<th>동물 성별</th>
						<td><input type='text' name='animal_gender'></td>
					</tr>
					<tr>
						<th>동물 품종</th>
						<td><input type='text' name='animal_breed'></td>
					</tr>
					<tr>
						<th>동물 무게</th>
						<td><input type='text' name='animal_weight'></td>
					</tr>
				</thead>
			</table>
			<button class="btn btn-info">추가</button>
			<input type='button' class="btn btn-info"
				onclick='location.href="/ppp/member/membermain"' value='취소'>
	</div>
	</form>
</body>
</html>