<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PetPaPa HotelList</title>
    <link href="/ppp/css/reset.css" rel="stylesheet" />
    <link href="/ppp/css/hotel.css" rel="stylesheet" />
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var areaHotelList = <%=request.getAttribute("result")%>
	// 이름, 메일, 연락처, 위치 //사진
	$.each(areaHotelList, function(index, h) {
		var hotelMail = $("<tr><td></td></tr>").html(h.hotelMail);
		var hotelPhone = $("<tr><td></td></tr>").html(h.hotelPhone);
		var hotelAddress = $("<tr><td></td></tr>").html(h.hotelAddress);
		var hotelScore = $("<tr><td></td></tr>").html(h.hotelScore);
		$(".hotel_list tbody").append("<tr><td rowspan='5' width='200px'><a href='/ppp/hotel/hotelview?hotel_no="+h.hotelNo+"'><img src='../hotels/hotelimg//"+h.hotelPhoto +"' width='200px' height='200px'></a></td><td>"+h.hotelName+"</td></tr>").append(hotelMail).append(hotelPhone).append(hotelAddress).append(hotelScore);
	});
	
	
});
</head>
<body>
 <header>
        <h1 class="main_title"><a href="/ppp/member/membermain"><img src="/ppp/images/logo.png" alt="펫파파 로고" /></a></h1>
    </header>
    <section class="hotel_section">
        <h2>Hotel List</h2>
        <hr />
        <a href="#">
            <article class="hotel_article">
                <div class="hotel img">
                    <img src="http://placehold.it/250x250" alt="호텔사진" width="250px" height="250px;" />
                </div>
                <div class="hotel description">
                    <h3 class="hotel_title row">대구 상동 딱지애견샵호텔</h3><span>리뷰(3)</span>
                    <p class="hotel_address row">인천 남구 학익동 663-1 태승빌딩 5층 (1층 홈플러스)</p>
                    <p class="hotel_phone_number row">032 - 123 - 4567</p>
                    <p class="hotel_email row">petpapa@ICIA.com</p>
                </div>
                <div class="star">
                    3.0
                </div>
            </article>
        </a>
        <hr />
        <a href="#">
            <article class="hotel_article">
                <div class="hotel img">
                    <img src="http://placehold.it/250x250" alt="호텔사진" width="250px" height="250px;" />
                </div>
                <div class="hotel description">
                    <h3 class="hotel_title row">대구 상동 딱지애견샵호텔</h3><span>리뷰(3)</span>
                    <p class="hotel_address row">인천 남구 학익동 663-1 태승빌딩 5층 (1층 홈플러스)</p>
                    <p class="hotel_phone_number row">032 - 123 - 4567</p>
                    <p class="hotel_email row">petpapa@ICIA.com</p>
                </div>
                <div class="star">
                    3.0
                </div>
            </article>
        </a>
        <hr />
        <a href="#">
            <article class="hotel_article">
                <div class="hotel img">
                    <img src="http://placehold.it/250x250" alt="호텔사진" width="250px" height="250px;" />
                </div>
                <div class="hotel description">
                    <h3 class="hotel_title row">대구 상동 딱지애견샵호텔</h3><span>리뷰(3)</span>
                    <p class="hotel_address row">인천 남구 학익동 663-1 태승빌딩 5층 (1층 홈플러스)</p>
                    <p class="hotel_phone_number row">032 - 123 - 4567</p>
                    <p class="hotel_email row">petpapa@ICIA.com</p>
                </div>
                <div class="star">
                    3.0
                </div>
            </article>
        </a>
        <hr />
    </section>
</body>
</html>