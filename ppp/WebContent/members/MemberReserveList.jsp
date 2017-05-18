<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	
	
	var reserve = <%=request.getAttribute("reserve")%>;
	var hrl = reserve.hrl;
	var horl = reserve.horl;
	var brl = reserve.brl;
	
	$(function(){
		$.each(horl, function(index, horl) {
			var hoNo = $("<td></td>").html(index+1);
			var hoName = $("<td></td>").html(horl.hospitalName);
			var hoPhone = $("<td></td>").html(horl.hospitalPhone);
			var hoAddress = $("<td></td>").html(horl.hospitalAddress);
			var vetName = $("<td></td>").html(horl.vetName);
			var hoDay = $("<td></td>").html(horl.reserveHospitalDate);
			var hoTime = $("<td></td>").html(horl.reserveHospitalTime);
			var aniName = $("<td></td>").html(horl.animalName);
			var aToReivew = $('<a href="/ppp/hospital/writehospitalreview?hospital_no='+horl.hospitalNo+'" data-toggle="modal" data-target="#writeReview"></a>').append('<td>예약완료</td>');
			var aToDelete = $('<a href="/ppp/hospital/hospitalreservedelete?hospital_no='+horl.hospitalNo+'"></a>').append('<td>예약취소</td>');
			var tr = $("<tr></tr>").append(hoNo).append(hoName).append(hoPhone).append(hoAddress).append(vetName).append(hoDay).append(hoTime).append(aniName).append(aToReivew).append(aToDelete);
			$(".hospital_list tbody").append(tr);
		})
	
	})
	
</script>
<style type="text/css">
table {
	text-align: center;
	margin-left: 50px;
	border: 1px solid black;
	width:90%;
}

th {
	font-size: 1.2e;
	font-weight: bold;
	border: 1px solid black;
}
tr,td{
	border: 1px solid black;
}
header{
	height:135px;
}
h2{
	margin-left: 50px;
}
</style>
<title>예약 내역 보기</title>

</head>
<body>
<header></header>
<div>
	<hr />
	<h2>호텔 예약 내역</h2>
	<table class="hotel_list" >
		<thead>
			<tr>
				<th>번호</th>
				<th>호텔이름</th>
				<th>전화번호</th>
				<th>호텔주소</th>
				<th>방종류</th>
				<th>체크인날짜</th>
				<th>체크아웃날짜</th>
				<th>예약시간</th>
				<th>동물이름</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
	<hr />
	
	<h2>병원 예약 내역</h2>
	<table class="hospital_list">
		<thead>
			<tr>
				<th>번호</th>
				<th>병원이름</th>
				<th>전화번호</th>
				<th>병원주소</th>
				<th>수의사</th>
				<th>예약날짜</th>
				<th>예약시간</th>
				<th>동물이름</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	<hr />
	<h2>미용 예약 내역</h2>
	<table class="beauty_list">
		<thead>
			<tr>
				<th>번호</th>
				<th>미용실이름</th>
				<th>전화번호</th>
				<th>미용실주소</th>
				<th>미용사</th>
				<th>예약날짜</th>
				<th>예약시간</th>
				<th>동물이름</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
	<hr />
</div>
<!-- 병원 리뷰 폼 -->
<div class="modal fade" id="writeReview" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Login</h4>
				</div>


					<div class="modal-body">
						asdsadasdsa


					</div>
					<div class="modal-footer">
						
					</div>

			</div>
		</div>
	</div>
</body>
</html>