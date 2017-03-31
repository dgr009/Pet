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
	var areaBeautyList = <%= request.getAttribute("result") %>
	// 이름, 메일, 연락처, 위치 //사진
	$.each(areaBeautyList, function(index, h) {
		//var tagA = $("<a href='#'></a>").html('<article class="hotel_article"><div class="hotel img"><img src="http://placehold.it/250x250" alt="미용사진" width="250px" height="250px;" /> </div><div class="hotel description"><h3 class="hotel_title row">대구 상동 딱지애견샵미용</h3><span>리뷰(3)</span><p class="hotel_address row">인천 남구 학익동 663-1 태승빌딩 5층 (1층 홈플러스)</p><p class="hotel_phone_number row">032 - 123 - 4567</p><p class="hotel_email row">petpapa@ICIA.com</p></div><div class="star">3.0</div></article><hr />');
		var tagA = $("<a href='/ppp/beauty/beautyview?beauty_no="+h.beautyNo+"'></a>");
		var tagArticle = $('<article class="hotel_article"></article>');
		var tagImg = $('<img src="/ppp/beauties/beautyimg/'+h.beautyPhoto+'" alt="미용사진" width="250px" height="250px;" />');
		var tagImgDiv = $('<div class="hotel img"></div>').append(tagImg);
		var title = $('<h3 class="hotel_title row">'+h.beautyName+'</h3>');
		var review = $('<p class="row"><a href="#">리뷰('+h.countReview +')</a></p>');
		var phone = $('<p class="hotel_phone_number row">'+h.beautyPhone+'</p>');
		var mail = $('<p class="hotel_email row">'+h.beautyMail+'</p>');
		var address = $('<p class="hotel_address row">'+h.beautyAddress+'</p>')
		var tagConDiv = $('<div class="hotel description"></div').append(title).append(phone).append(mail).append(address).append(review);
		var tagStarDiv = $('<div class="star"></div>').html(h.beautyScore);
		tagArticle.append(tagImgDiv).append(tagConDiv).append(tagStarDiv);
		tagA.append(tagArticle);
		$("#content").append(tagA).append('<hr />');
	});
	
});

</script>
<body>
<header> 
<%@ include file='../members/BigHeader.jsp' %>
</header>
	<section class="hotel_section">
	<h2 class="list_title">Beauty List</h2>
	<form id="inline_form" action="/ppp/beauty/beautyareasearch" method="get">
		지역 검색 : <input type="text" name="area">
		<button>검색</button>
	</form>
	<hr />
	<div id="content">
		
	</div>
	</section>

</body>
</html>