<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var inactivememberList = <%= request.getAttribute("result") %>
	// 이름, 메일, 연락처, 위치 //사진
	$.each(inactivememberList, function(index, h) {
		//var tagA = $("<a href='#'></a>").html('<article class="member_article"><div class="member img"><img src="http://placehold.it/250x250" alt="병원사진" width="250px" height="250px;" /> </div><div class="member description"><h3 class="member_title row">대구 상동 딱지애견샵병원</h3><span>리뷰(3)</span><p class="member_address row">인천 남구 학익동 663-1 태승빌딩 5층 (1층 홈플러스)</p><p class="member_phone_number row">032 - 123 - 4567</p><p class="member_email row">petpapa@ICIA.com</p></div><div class="star">3.0</div></article><hr />');
		var no = $("<td></td>").html(h.memberNo);
		var name = $("<td></td>").html(h.memberName);
		var id = $("<td></td>").html(h.memberId);
		var phone = $("<td></td>").html(h.memberPhone);
		var mail = $("<td></td>").html(h.memberMail);
		var address = $("<td></td>").html(h.memberAddress);

		var tr = $("<tr width='90%'></tr>").append(no).append(name).append(id).append(ornerNo).append(ornerName).append(phone).append(mail).append(address);
		//var tagA = $("<a href='/ppp/admin/memberview?member_no="+h.memberNo+"'></a>").append(tr);
		$(".list tbody").append(tr);
	});
	
});

</script>
<style>
	table{
		margin-left: 100px;
	}
</style>
<body>
<header> 
 <%@ include file='../adminss/header/YesHeader.jsp' %>  
</header>
	<div height="135px">as</div>
	<br><br><br><br><br><br>
	<h2 class="list_title">Inactive member List</h2>
	<form id="inline_form" action="/ppp/admin/memberdeactiviysearch" method="get">
		<button>검색</button>
	</form>
	<hr />
	<table class='list' border ='1' width='90%'>
	<thead>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>회원이름</th>
		<th>회원 주소</th>
		<th>회원 연락처</th>
		<th>회원 메일</th>
	</tr>
	</thead>
	<tbody>
	
	</tbody>
	</table>

</body>
</html>