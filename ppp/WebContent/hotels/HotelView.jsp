<%@page import="com.ppp.vo.Hotel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Hotel h = (Hotel)request.getAttribute("hotel");
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

var roomDetail = <%=request.getAttribute("room")%>
var hotel = <%=session.getAttribute("hotelgson") %>
$(document).ready(function() {
	
	var div_btn1 = $("<div class='btns'></div>");
	var div_btn2 = $("<div class='btns'></div>");
	var div_btn3 = $("<div class='btns'></div>");
	var div_btn4 = $("<div class='btns'></div>");
	var reserve_btn = div_btn1.append('<a href="/ppp/member/reserveHotel"><span id="fon">예약</span><img src="/ppp/images/reserv.png" alt="Alternate Text" width="150" height="70" /></a>');
	var update_btn = div_btn2.append('<a href="/ppp/hotel/roomupdate"><span id="fon">수정</span><img src="/ppp/images/update.png" alt="Alternate Text" width="150" height="70" /></a>')
	var regist_btn = div_btn3.append('<a href="/ppp/hotel/roomregister"><span id="fon">추가</span><img src="/ppp/images/regist.png" alt="Alternate Text" width="150" height="70" /></a>')
	var delete_btn = div_btn4.append('<a href="/ppp/hotel/roomdelete"><span id="fon">삭제</span><img src="/ppp/images/delete.png" alt="Alternate Text" width="150" height="70" /></a>')
	
	if(hotel!=null){
		if(hotel.hotelNo==<%=h.getHotelNo()%>){
			$(".detail_header").append(update_btn);
			$(".detail_header").append(regist_btn);
			$(".detail_header").append(delete_btn);
		}
	}else{
		 $(".detail_header").append(reserve_btn);
	}
	
	$.each(roomDetail, function(index, r) {
		var roomPhoto = $("<img src='/ppp/hotels/roomimg/"+r.roomPhoto+"' alt='Alternate Text' width='300' height='300' >");
		$(".detail_img").append(roomPhoto);
		var roomKind = $("<td></td>").html(r.roomKind);
		var roomPrice = $("<td></td>").html(r.roomPrice);
		var tr = $('<tr></tr>').append(roomKind).append(roomPrice);
		$("#room_info tbody").append(tr);
			
	})
	
	
	
});
</script>
</head>
<body>
<!-- 헤더 -->
	<%@ include file="../members/BigHeader.jsp"%>
	
	 <header>
	 안보이지롱
    </header>
    <section class="hotel_section">
        <div class="detail_header">
            <div>
                <h2><%= h.getHotelName() %></h2>
            </div>
           
        </div>
        <hr />
        <article class="detail_article">
            <div class="detail_img">

            </div>
            <div class="detail_description">
                <div class="detail_row info">
                    <div>
                        <p>주소</p>
                        <p><%=h.getHotelAddress() %></p>
                    </div>
                    <div>
                        <p>전화번호</p>
                        <p><%=h.getHotelPhone() %></p>
                    </div>
                    <div>
                        <p>이메일</p>
                        <p><%=h.getHotelMail() %></p>
                    </div>
                </div>
                <div class="detail_row info2">
                    <table id='room_info'>
                        <thead>
                            <tr>
                                <th>무게</th>
                                <th>가격</th>
                            </tr>
                        </thead>
                        <tbody>
                          
                        </tbody>
                    </table>
                </div>
            </div>
        </article>
    </section>

</body>
</html>