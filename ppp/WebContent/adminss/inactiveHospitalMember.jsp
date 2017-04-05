<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/ppp/css/reset.css" rel="stylesheet" />
<link href="/ppp/css/list.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<style>
	#list_title{
		display:inline-block;
	}
	.inline_form{
		display:inline-block;
	}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var inactiveHospitalList = <%= request.getAttribute("result") %>
	// 이름, 메일, 연락처, 위치 //사진
	$.each(inactiveHospitalList, function(index, h) {
		//var tagA = $("<a href='#'></a>").html('<article class="hospital_article"></div><div class="hospital description"><h3 class="hospital_title row">대구 상동 딱지애견샵병원</h3><span>리뷰(3)</span><p class="hospital_address row">인천 남구 학익동 663-1 태승빌딩 5층 (1층 홈플러스)</p><p class="hospital_phone_number row">032 - 123 - 4567</p><p class="hospital_email row">petpapa@ICIA.com</p></div><div class="star">3.0</div></article><hr />');
		var tagA = $("<a href='/ppp/admin/hospitalview? hospital_active=2'></a>");
		var tagArticle = $('<article class="hospital_article"></article>');
		var name = $('<h3 class="hospital_title row">'+h.hospitalName+'</h3>');
		var phone = $('<p class="hospital_phone_number row">'+h.hospitalPhone+'</p>');
		var mail = $('<p class="hospital_email row">'+h.hospitalMail+'</p>');
		var address = $('<p class="hospital_address row">'+h.hospitalAddress+'</p>')
		var tagConDiv = $('<div class="hospital description"></div>').append(name).append(phone).append(mail).append(mail).append(address);
		tagArticle.append(tagConDiv);
		tagA.append(tagArticle);
		$("#content").append(tagA);
	});
	
});

</script>
<body>
<header> 
 <%@ include file='../adminss/header/YesHeader.jsp' %>  
</header>
	<section class="admin_section">
	<h2 class="list_title">Inactive hospital List</h2>
	<form id="inline_form" action="/ppp/admin/hospitaldeactiviysearch" method="get">
		<button>검색</button>
	</form>
	<hr />
	<div id="content">
		
	</div>
	</section>

</body>
</html>