<%@page import="com.ppp.vo.Member"%>
<%@page import="com.ppp.vo.Hospital"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Hospital h = (Hospital) request.getAttribute("hospital");
	Member m = (Member) session.getAttribute("member");
%>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	var vetGson =<%= request.getAttribute("vet") %>
	var animallist = <%=session.getAttribute("animallistgson")%>
	
	
	$(function() {
		$.each(vetGson, function(index, r) {
			var vetPhoto = $("<img src='/ppp/hospitals/vetimg/"+r.vetPhoto+"' alt='Alternate Text' width='200' height='200' >");
			var vetNo = $("<td width='50px'></td>").html(r.vetNo);
			var PhotoTd = $("<td width='200px' height='200px'></td>").append(vetPhoto);
			var vetName = $("<h4></h4>").html("수의사 이름 : " +r.vetName);
			var vetIntro = $("<h3><b></b></h3>").html("수의사 소개 : " +r.vetIntroduce);
			var vetInfo = $("<td width='200px' height='200px'></td>").append(vetName).append(vetIntro);
			var tr = $('<tr></tr>').append(vetNo).append(PhotoTd).append(vetInfo);
			$(".vet_info tbody").append(tr);
			
			var option = $("<option value='r.vetName'></option>").html(r.vetName);
			$("#check_vet").append(option);
			
		})
		nameCheck();
		
		$.each(animallist, function(index, a) {
			var animalOp = $("<option value='a.animalNo'></option>").html(a.animalName);
			$("#animal_name").append(animalOp);
		})
	})
	
	function nameCheck(){
			$.each(vetGson,function(index,r){
				$("#introduce").html(r.vetIntroduce);	
				if(r.vetName==$("#check_vet").val())
					$("#introduce").html(r.vetIntroduce);	
			})	
		}
</script>
<style>
header {
	height: 135px;
}

.hospital_info {
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
.vet_info {
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


	<div class='hospital_info'>
		<h3><%=h.getHospitalName()%></h3>
		<p class="address btn_copy"><%=h.getHospitalAddress()%></p>
		<p class="tel"><%=h.getHospitalPhone()%></p>
	</div>

	<hr />

	<div class="vet_info">
		<table border='1'>
			<thead>
				<tr>
					<th width='50px'>수의사 번호</th>
					<th width='200px' >수의사 사진</th>
					<th width='200px'>수의사 정보</th>
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
				<td>수의사 선택</td>
				<td><select onchange="nameCheck()" name="vet_name" id="check_vet"></select></td>
			</tr>
			<tr>
				<td>수의사 소개</td>
				<td><p name='vet_introduce' id='introduce'><p><td>
			</tr>
			<tr>
				<td>애완 동물 선택</td>
				<td><select name="animal_name" id="animal_name"></select></td>
			</tr>
		</table>
		<hr />
		<button>예약하기</button>
	</div>



</body>
</html>