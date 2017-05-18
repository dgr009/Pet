<%@page import="com.ppp.vo.Member"%>
<%@page import="com.ppp.vo.Hotel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Hotel h = (Hotel) request.getAttribute("hotel");
	Member m = (Member) session.getAttribute("member");
%>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	var roomGson =<%= request.getAttribute("room") %>
	
	$(function() {
		$.each(roomGson, function(index, r) {
			var roomPhoto = $("<img src='/ppp/hotels/roomimg/"+r.roomPhoto+"' alt='Alternate Text' width='200' height='200' >");
			var roomNo = $("<td width='50px'></td>").html(r.roomNo);
			var PhotoTd = $("<td width='200px' height='200px'></td>").append(roomPhoto);
			var roomKind = $("<h4></h4>").html("방 종류 : " +r.roomKind);
			var roomPrice = $("<h3><b></b></h3>").html("방 가격 : " +r.roomPrice);
			var roomInfo = $("<td width='200px' height='200px'></td>").append(roomKind).append(roomPrice);
			var tr = $('<tr></tr>').append(roomNo).append(PhotoTd).append(roomInfo);
			$(".room_info tbody").append(tr);
			
			var option = $("<option value='"+r.roomNo+"'></option>").html(r.roomKind);
			$("#check_room").append(option);
		})
		
		priceCheck();
	})
	
	var priceCheck = function(){
			$.each(roomGson,function(index,r){
				if(r.roomKind==$("#check_room").val())
					$("#price").html(r.roomPrice);	
				
			})	
		}
</script>
<style>
header {
	height: 135px;
}

.hotel_info {
	margin-left: 20px;
}
td,th{
	text-align: center;
}

tr{
	
}

table{
	padding : 5px;
}
.room_info {
	margin-left: 30px;
	float: left;
}

.reserve {
	margin-right: 30px;
	float: right;
}

p{
	
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 -->
	<%@ include file="/members/BigHeader.jsp"%>
	<header> 안보이지롱 </header>


	<div class='hotel_info'>
		<h3><%=h.getHotelName()%></h3>
		<p class="address btn_copy"><%=h.getHotelAddress()%></p>
		<p class="tel"><%=h.getHotelPhone()%></p>
	</div>

	<hr />

	<div class="room_info">
		<table border='1'>
			<thead>
				<tr>
					<th width='50px'>방 번호</th>
					<th width='200px' >방 사진</th>
					<th width='200px'>방 정보</th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
		</table>
	</div>

	<div class='reserve'>
		<table border='1' width='500px' height='500px'>
			<tr>
				<td><h5>예약자 이름</h5></td>

				<td><input type="text" class="inp_txt" name="member_name" id="member_name" width='100%'
					placeholder="이름을 입력해 주세요."  value="<%=m.getMemberName()%>"></td>
			</tr>
			<tr>
				<td><h5>휴대폰 번호</h5></td>

				<td><input type="tel" class="inp_txt" name="member_phone"
					id="member_phone" placeholder="휴대폰 번호를 입력해 주세요." 
					value="<%=m.getMemberPhone()%>"></td>
					
			</tr>
			<tr>
				<td>체크인 날짜</td>
				<td><input type="date" name="check_in_date" id="check_in_date"></td>
			</tr>
			<tr>
				<td>체크아웃 날짜</td>
				<td><input type="date" name="check_out_date" id="check_out_date"></td>
			</tr>
			<tr>
				<td>예약 시간</td>
				<td><select name='reserve_time'>
					<% for(int i=9; i<=18; i++){ %>
						<option value='<%= i %>:00'><%= i %>:00</option>
						<option value='<%= i %>:30'><%= i %>:30</option>
					<%} %>
				</select></td>
				
			</tr>
			<tr>
				<td>예약 방 선택</td>
				<td><select onchange="priceCheck()" name="room_no" id="check_room"></select></td>
			</tr>
			<tr>
				<td>예약 방 가격</td>
				<td><sapn name='room_price' id='price'><span><td>
			</tr>
		</table>
		<hr />
		<button>예약하기</button>
	</div>



</body>
</html>