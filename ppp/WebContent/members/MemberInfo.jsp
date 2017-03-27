<%@page import="com.ppp.vo.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ppp.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Member member = (Member)session.getAttribute("member");
	ArrayList<Animal> animallist = (ArrayList<Animal>)session.getAttribute("animallist");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var animallist = <%=session.getAttribute("animallistgson")%>
	$.each(animallist, function(index, a) {
		var animalNo = $("<td></td>").html(a.animalNo);
		var animalName = $("<td></td>").html(a.animalName);
		var animalKind = $("<td></td>").html(a.animalKind);
		var animalGender = $("<td></td>").html(a.animalGender);
		var animalBreed = $("<td></td>").html(a.animalBreed);
		var animalWeight = $("<td></td>").html(a.animalWeight);
		
		var up = $("<a></a>").prop("href", "animalupdate?animal_no="+a.animalNo).html('수정');
		var tdup = $("<td></td>").append(up);
		var del = $("<a class='delete'></a>").prop("href", "animaldelete?animal_no="+a.animalNo).html('삭제');
		var tddel = $("<td></td>").append(del);
		// var ename = $("<td></td>").append(a);
		//var ename = "<td empno='" + e.empno + "'>" + e.ename + "</td>";
		var tr = $("<tr></tr>").append(animalNo).append(animalName).append(animalKind).append(animalGender).append(animalBreed).append(animalWeight).append(tdup).append(tddel);
		$(".animal_list tbody").append(tr);
	});
	
	
});
	
</script>
</head>
<body>
	<div>
		<table border="1" width="500px">
			<thead>
				<!-- 
				member_no,
				member_id,
				member_address,
				member_name,
				ember_phone,
				member_mail,
				member_gender,
				member_coupon 
				-->
				<tr>
					<td>번호</td>
					<td>아이디</td>
					<td>주소</td>
					<td>이름</td>
					<td>연락처</td>
					<td>이메일</td>
					<td>성별</td>
					<td>쿠폰</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=member.getMemberNo() %></td>
					<td><%=member.getMemberId() %></td>
					<td><%=member.getMemberAddress() %></td>
					<td><%=member.getMemberName() %></td>
					<td><%=member.getMemberPhone() %></td>
					<td><%=member.getMemberMail() %></td>
					<td><%=member.getMemberGender() %></td>
					<td><%=member.getMemberCoupon() %></td>
					
				</tr>
				<tr><td colspan="8">---------------------------------</td></tr>
			</tbody>
		</table>
		<table class="animal_list" border="1" width="500px">
		
			<thead>		
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>성별</th>
					<th>종류</th>
					<th>품종</th>
					<th>무게</th>
				</tr>
			</thead>
			<tbody >
				
			</tbody>
		</table>
		<input type="button" value="정보 수정" onclick="location.href = '/ppp/member/memberupdate'" />
		<input type="button" value="동물 추가" onclick="location.href = '/ppp/member/animalinsert'" />
		<input type="button" value="받은 쪽지함" onclick="location.href = '/ppp/board/receivemessage'" /> 
		<input type="button" value="홈으로" onclick="location.href = '/ppp/member/membermain'" />
	</div>
</body>
</html>