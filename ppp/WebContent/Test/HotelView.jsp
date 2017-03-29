<%@page import="com.ppp.vo.Hotel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
var hotelDetail = <%=request.getAttribute("hotel")%>
var roomDetail = <%=request.getAttribute("room")%>
var hotel = <%=session.getAttribute("hotelgson") %>
$(document).ready(function() {
	
	// 이름, 메일, 연락처, 위치 //사진
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
		$(".room_view tbody").append(tr);
	});
	
	if(hotel!=null){
		if(hotel.hotelNo==hotelDetail.hotelNo){
			document.getElementById("room_insert").style.visibility = "visible";
		}else{
			document.getElementById("room_insert").style.visibility = "hidden";
		}	
	}else{
		document.getElementById("room_insert").style.visibility = "hidden";
	}
	
});
</script>
</head>
<body>
<!-- 헤더 -->
	<%@ include file="../members/BigHeader.jsp"%>
	
<br><br><br><br><br><br><br><br><br><br>
	<div>
	<form action="/ppp/hotel/hotelareasearch" method="get">
	지역 검색 : <input type="text" name="area"><button>검색</button>
</form>
</div>

<table class="hotel_view" border='1'>

</table>
<table class="room_view" border='1' width="400px">
		
			<thead>		
				<tr>
					<th colspan='4'>Room Infomation</th>
				</tr>
				<tr>
					<td>사진</td><td>방번호</td><td>방종류</td><td>방가격</td>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
		<button id='room_insert' onclick='location.href="/ppp/hotel/roomregister"'>추가</button>
</body>
</html>