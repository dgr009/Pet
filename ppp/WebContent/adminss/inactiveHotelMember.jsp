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
	var inactiveHotelList = <%= request.getAttribute("result") %>
	// 이름, 메일, 연락처, 위치 //사진
	$.each(inactiveHotelList, function(index, h) {
		//var tagA = $("<a href='#'></a>").html('<article class="hotel_article"><div class="hotel img"><img src="http://placehold.it/250x250" alt="병원사진" width="250px" height="250px;" /> </div><div class="hotel description"><h3 class="hotel_title row">대구 상동 딱지애견샵병원</h3><span>리뷰(3)</span><p class="hotel_address row">인천 남구 학익동 663-1 태승빌딩 5층 (1층 홈플러스)</p><p class="hotel_phone_number row">032 - 123 - 4567</p><p class="hotel_email row">petpapa@ICIA.com</p></div><div class="star">3.0</div></article><hr />');
		var tagA = $("<a href='/ppp/admin/hospitalview? hotel_active=2'></a>");
		var tagArticle = $('<article class="hotel_article"></article>');
		var name = $('<h3 class="hotel_title row">'+h.hotelName+'</h3>');
		var phone = $('<p class="hotel_phone_number row">'+h.hotelPhone+'</p>');
		var mail = $('<p class="hotel_email row">'+h.hotelMail+'</p>');
		var address = $('<p class="hotel_address row">'+h.hotelAddress+'</p>')
		var tagConDiv = $('<div class="hotel description"></div>').append(name).append(phone).append(mail).append(mail).append(address);
		tagArticle.append(tagConDiv);
		tagA.append(tagArticle);
		$(".list tbody").append(tagA);
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
	<h2 class="list_title">Inactive Hotel List</h2>
	<form id="inline_form" action="/ppp/admin/hoteldeactiviysearch" method="get">
		<button>검색</button>
	</form>
	<hr />
	<table class='list'>
	<thead>
	</thead>
	<tbody>
	
	</tbody>
	</table>

</body>
</html>