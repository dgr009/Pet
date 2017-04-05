<%@page import="com.ppp.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Member member = (Member) session.getAttribute("member");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	var animallist = <%=session.getAttribute("animallistgson")%>
	$.each(animallist, function(index, a) {
		var animalNo = $("<td></td>").html(a.animalNo);
		var animalName = $("<td></td>").html(a.animalName);
		var animalKind = $("<td></td>").html(a.animalKind);
		var animalGender = $("<td></td>").html(a.animalGender);
		var animalBreed = $("<td></td>").html(a.animalBreed);
		var animalWeight = $("<td></td>").html(a.animalWeight);
		$("#ani_no").append(animalNo);
		$("#ani_name").append(animalName);
		$("#ani_kind").append(animalKind);
		$("#ani_breed").append(animalBreed);
		$("#ani_gender").append(animalGender);
		$("#ani_weight").append(animalWeight);
		var up = $("<a></a>").prop("href",
				"animalupdate?animal_no=" + a.animalNo).html('수정/');
		var del = $("<a class='delete'></a>").prop("href",
				"animaldelete?animal_no=" + a.animalNo).html('삭제');
		var tdupdel = $("<td></td>").append(up).append(del);
		// var ename = $("<td></td>").append(a); 
		//var ename = "<td empno='" + e.empno + "'>" + e.ename + "</td>";

		$("#ani_update").append(tdupdel);
	});
</script>
</head>
<body>
	<div>
		<table class="table table-bordered" border="1" width="500px">
			<thead>
				<tr>
					<th colspan="6">회 원 정 보</th>
				</tr>
				<tr>
					<th width="20%;">회원번호</th>
					<td><%=member.getMemberNo()%></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><%=member.getMemberId()%></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><%=member.getMemberAddress()%></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><%=member.getMemberName()%></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><%=member.getMemberPhone()%></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><%=member.getMemberMail()%></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><%=member.getMemberGender()%></td>
				</tr>
				<tr>
					<th>쿠폰</th>
					<td><%=member.getMemberCoupon()%></td>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<hr />
		<table class="table table-bordered" border="1" width="500px">
			<thead>
				<tr>
					<th colspan="6">애 완 동 물 리 스 트</th>
				</tr>
				<tr id='ani_no'>
					<th>번호</th>
				</tr>
				<tr id='ani_name'>
					<th>이름</th>
				</tr>
				<tr id='ani_gender'>
					<th>성별</th>
				</tr>
				<tr id='ani_kind'>
					<th>종류</th>
				</tr>
				<tr id='ani_breed'>
					<th>품종</th>
				</tr>
				<tr id='ani_weight'>
					<th>무게</th>
				</tr>
				<tr id='ani_update'>
					<th>----</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
		<input type="button" class="btn btn-info" value="정보 수정"
			onclick="location.href = '/ppp/member/memberupdate'" /> <input
			type="button" class="btn btn-info" value="동물 추가"
			onclick="location.href = '/ppp/member/animalinsert'" /> <input
			type="button" class="btn btn-info" value="받은 쪽지함"
			onclick="location.href = '/ppp/board/receivemessage'" /> <input
			type="button" class="btn btn-info" value="홈으로"
			onclick="location.href = '/ppp/member/membermain'" />
	</div>
</body>
</html>