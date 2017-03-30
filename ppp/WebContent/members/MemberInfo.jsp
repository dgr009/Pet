<%@page import="com.ppp.vo.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ppp.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Member member = (Member) session.getAttribute("member");
	ArrayList<Animal> animallist = (ArrayList<Animal>) session.getAttribute("animallist");
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
	$(document).ready(
			function() {
				var animallist =
<%=session.getAttribute("animallistgson")%>
	$.each(animallist, function(index, a) {
					var animalNo = $("<td></td>").html(a.animalNo);
					var animalName = $("<td></td>").html(a.animalName);
					var animalKind = $("<td></td>").html(a.animalKind);
					var animalGender = $("<td></td>").html(a.animalGender);
					var animalBreed = $("<td></td>").html(a.animalBreed);
					var animalWeight = $("<td></td>").html(a.animalWeight);
					var up = $("<a></a>").prop("href",
							"animalupdate?animal_no=" + a.animalNo).html('수정');
					var tdup = $("<td></td>").append(up);
					var del = $("<a class='delete'></a>").prop("href",
							"animaldelete?animal_no=" + a.animalNo).html('삭제');
					var tddel = $("<td></td>").append(del);
					// var ename = $("<td></td>").append(a);
					//var ename = "<td empno='" + e.empno + "'>" + e.ename + "</td>";
					var tr = $("<tr></tr>").append(animalNo).append(animalName)
							.append(animalKind).append(animalGender).append(
									animalBreed).append(animalWeight).append(
									tdup).append(tddel);
					$(".animal_list tbody").append(tr);
				});
			});
</script>
</head>
<body>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<h3>회 원 정 보</h3>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th style="width:23%">회원번호</th>
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
			</tbody>
		</table>
		<button type="button" class="btn btn-info" onclick="location.href = '/ppp/member/memberupdate'" >회원 정보 수정</button>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th colspan="6">애 완 동 물 리 스 트</th> 
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>번호</th>

				</tr>
				<tr>
					<th>이름</th>

				</tr>
				<tr>
					<th>성별</th>
					
				</tr>
				<tr>
					<th>종류</th>
					
				</tr>
				<tr>
					<th>품종</th>
					

				</tr>
				<tr>
					<th>무게</th>

				</tr>
			</tbody>
		</table>
		 <button type="button" class="btn btn-info" onclick="location.href = '/ppp/member/animalinsert'" >반려동물 추가</button>
		 <button type="button" class="btn btn-info" onclick="location.href = '/ppp/board/receivemessage'" >쪽지함</button>
		 <button type="button" class="btn btn-info" onclick="location.href = '/ppp/member/membermain'" >홈으로</button>
	
	</div>
</body>
</html>