<%@page import="com.ppp.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Member member = (Member)session.getAttribute("member");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<div>
		<table border="1">
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
				<tr>
					<td colspan="8">애완동물</td>
				</tr>
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>성별</td>
					<td>종류</td>
					<td>품종</td>
					<td>무게</td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<input type="button" value="정보 수정" onclick="location.href = '/ppp/member/memberupdate'" />
		<input type="button" value="동물 추가" onclick="location.href = '/ppp/member/animalinsert'" />
		<input type="button" value="동물 수정" onclick="location.href = '/ppp/member/animalupdate'" />
		<input type="button" value="홈으로" onclick="location.href = '/ppp/member/membermain'" />
	</div>
</body>
</html>