<%@page import="com.ppp.vo.Member"%>
<%@page import="com.ppp.vo.Beauty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Beauty h = (Beauty) request.getAttribute("beauty");
	Member m = (Member) session.getAttribute("member");
%>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	var beauticianGson =<%= request.getAttribute("beautician") %>
	
	$(function() {
		$.each(beauticianGson, function(index, r) {
			var beauticianPhoto = $("<img src='/ppp/beauties/beauticianimg/"+r.beauticianPhoto+"' alt='Alternate Text' width='200' height='200' >");
			var beauticianNo = $("<td width='50px'></td>").html(r.beauticianNo);
			var PhotoTd = $("<td width='200px' height='200px'></td>").append(beauticianPhoto);
			var beauticianName = $("<h4></h4>").html("미용사 이름 : " +r.beauticianName);
			var beauticianIntro = $("<h3><b></b></h3>").html("미용사 소개 : " +r.beauticianIntroduce);
			var beauticianInfo = $("<td width='200px' height='200px'></td>").append(beauticianName).append(beauticianIntro);
			var tr = $('<tr></tr>').append(beauticianNo).append(PhotoTd).append(beauticianInfo);
			$(".beautician_info tbody").append(tr);
			
			var option = $("<option value='"+r.beauticianName+"'></option>").html(r.beauticianName);
			$("#check_beautician").append(option);
			
		})
		nameCheck();
	})
	
	function nameCheck(){
			$.each(beauticianGson,function(index,r){	
				if(r.beauticianName==$("#check_beautician").val())
					$("#introduce").html(r.beauticianIntroduce);	
			})	
		}
</script>
<style>
header {
	height: 135px;
}

.beauty_info {
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
.beautician_info {
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


	<div class='beauty_info'>
		<h3><%=h.getBeautyName()%></h3>
		<p class="address btn_copy"><%=h.getBeautyAddress()%></p>
		<p class="tel"><%=h.getBeautyPhone()%></p>
	</div>

	<hr />

	<div class="beautician_info">
		<table border='1'>
			<thead>
				<tr>
					<th width='50px'>미용사 번호</th>
					<th width='200px' >미용사 사진</th>
					<th width='200px'>미용사 정보</th>
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
				<td>예약 날짜</td>
				<td><input type="date" name="reserve_date" id="reserve_date"></td>
			</tr>
			<tr>
				<td>예약 시간</td>
				<td><select name='reserve_time'>
					<% for(int i=9; i<=21; i++){ %>
						<option value='<%= i %>:00'><%= i %>:00</option>
						<option value='<%= i %>:30'><%= i %>:30</option>
					<%} %>
				</select></td>
				
			</tr>
			<tr>
				<td>미용사 선택</td>
				<td><select onchange="nameCheck()" name="beautician_Name" id="check_beautician"></select></td>
			</tr>
			<tr>
				<td>미용사 소개</td>
				<td><p name='beautician_introduce' id='introduce'><p><td>
			</tr>
		</table>
		<hr />
		<button>예약하기</button>
	</div>



</body>
</html>