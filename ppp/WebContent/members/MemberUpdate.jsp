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
	<form action='/ppp/member/memberupdate' method='post'>
	<div>
		<table border="1">
			
				<tr>
					<td>번호</td><td><input type='hidden' value='<%=member.getMemberNo() %>' id='member_no' name='member_no'><%=member.getMemberNo() %></td></tr><tr>
					
					<td>아이디</td><td><input type='hidden' value='<%=member.getMemberId() %>' id='member_id' name='member_id'><%=member.getMemberId() %></td></tr><tr>
					<td>비밀번호</td><td><input type="password" id="member_pwd1" name='member_pwd'></td></tr><tr>
					<td>비밀번호확인</td><td><input type="password" id="member_pwd2"></td></tr><tr>
					<td>주소</td><td><input type='text' value='<%=member.getMemberAddress() %>' id='member_address' name='member_address'></td></tr><tr>
					<td>이름</td><td><input type='text' value='<%=member.getMemberName() %>' id='member_name' name='member_name'></td></tr><tr>
					<td>연락처</td><td><input type='text' value='<%=member.getMemberPhone() %>' id='member_phone' name='member_phone'></td></tr><tr>
					<td>이메일</td><td><input type='text' value='<%=member.getMemberMail() %>' id='member_mail' name='member_mail'></td></tr><tr>
					<td>성별</td><td><input type='text' value='<%=member.getMemberGender() %>' id='member_gender' name='member_gender'></td></tr><tr>
					<td>쿠폰</td><td><input type='hidden' value='<%=member.getMemberCoupon() %>' id='member_coupon' name='member_coupon'><%=member.getMemberCoupon() %></td></tr>
					<input type='hidden' value='<%=member.getAdminNo() %>' id='member_adminno' name='member_adminno'>
					<input type='hidden' value='<%=member.getMemberActive() %>' id='member_active' name='member_active'>
				
			
				<tr><td colspan="2">---------------------------------</td></tr>
				<tr>
					<td colspan="2">애완동물</td>
				</tr>
				<tr>
					<td>번호</td></tr><tr>
					<td>이름</td></tr><tr>
					<td>성별</td></tr><tr>
					<td>종류</td></tr><tr>
					<td>품종</td></tr><tr>
					<td>무게</td>
				</tr>
		
		</table>
		<input type="submit" value="수정 완료" />
		<input type="button" value="홈으로" onclick="location.href = '/ppp/member/membermain2'" />
		
	</div>
	</form>
</body>
</html>