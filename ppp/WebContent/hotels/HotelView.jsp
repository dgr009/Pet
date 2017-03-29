<%@page import="com.ppp.vo.Hotel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String h = (String)request.getAttribute("hotel");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>PetPaPa HotelList</title>
    <link href="/ppp/css/reset.css" rel="stylesheet" />
    <link href="/ppp/css/view_detail.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
var h = <%=request.getAttribute("hotel")%>
var roomDetail = <%=request.getAttribute("room")%>
var hotelGson = <%=session.getAttribute("hotelgson") %>
$(document).ready(function() {
	
	var hotelName = $("<div></div>").append("<h2>"+h.hotelName+"</h2>")
	var reserveBtn = $("<div></div>").append('<a href="#"><div class="reserv"><img src="/ppp/images/reservation.png" alt="Alternate Text" width="70px;" /></div></a>')
	$(".detail_header").append(hotelName).append(reserveBtn);
	
	/*// 이름, 메일, 연락처, 위치 //사진
	$.each(roomDetail, function(index, r) {
		var roomNo = $("<td></td>").html(r.roomNo);
		var roomKind = $("<td></td>").html(r.roomKind);
		var roomPrice = $("<td></td>").html(r.roomPrice);
		var roomPhoto = $("<td><img src='"+r.rommPhoto+"'></td>");
		var btn1 = $("<button></button>").html("예약");
		var btn2 = $("<button></button>").html("수정");
		var td1 = $("<td></td>").append(btn1);
		var td2 = $("<td></td>").append(btn2);
		var tr = $("<tr></tr>").append(roomPhoto).append(roomNo).append(roomKind).append(roomPrice);
		if(hotel!=null){
			if(hotel.hotelNo==hotelDetail.hotelNo){
				tr.append(td2);
			}
		}else{
			tr.append(td1);	
		}
		$("room_view tbody").append(tr);
	});
	
	if(hotel!=null){
		if(hotel.hotelNo==hotelDetail.hotelNo){
			document.getElementById("room_insert").style.visibility = "visible";
		}else{
			document.getElementById("room_insert").style.visibility = "hidden";
		}	
	}else{
		document.getElementById("room_insert").style.visibility = "hidden";
	}*/
	
});
</script>
</head>
<body>
<!-- 헤더 -->
	<%@ include file="../members/BigHeader.jsp"%>
	
	 <header>
        <h1 class="main_title"><a href="hotel_list.html"><img src="/ppp/images/logo.png" alt="펫파파 로고" /></a></h1>
    </header>
    <section class="hotel_section">
        <div class="detail_header">
           
        </div>
        <hr />
        
        <article class="detail_article">
            <div class="detail_img">
                <img src="호텔1.jpg" alt="Alternate Text" width="300" height="300" />
                <img src="호텔2.jpg" alt="Alternate Text" width="300" height="300" />
                <img src="호텔3.jpg" alt="Alternate Text" width="300" height="300" />
            </div>
            <div class="detail_description">
                <div class="detail_row info">
                    <div>
                        <p>주소</p>
                        <p>인천 남구 학익동 663-1 태승빌딩 5층 (1층 홈플러스)</p>
                    </div>
                    <div>
                        <p>전화번호</p>
                        <p>032 - 123 - 4567</p>
                    </div>
                    <div>
                        <p>이메일</p>
                        <p>petpapa@ICIA.com</p>
                    </div>
                </div>
                <div class="detail_row info2">
                    <table>
                        <thead>
                            <tr>
                                <th>무게</th>
                                <th>가격</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>0kg~4kg미만</td>
                                <td>15,000원</td>
                            </tr>
                            <tr>
                                <td>5kg~7kg미만</td>
                                <td>20,000원</td>
                            </tr>
                            <tr>
                                <td>8kg~10kg미만</td>
                                <td>25,000원</td>
                            </tr>
                            <tr>
                                <td>11kg~14kg미만</td>
                                <td>35,000원</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </article>
         
    </section>

</body>
</html>