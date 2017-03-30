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
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="/ppp/member/membermain"><img src="/ppp/images/logo2.png"></a>
		</div>
		<div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">예약 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#section41">호텔</a></li>
							<li><a href="#section42">병원</a></li>
							<li><a href="#section43">미용</a></li>
						</ul>
					<li><a href="#section2">게시판</a></li>
					<li><a href="#section3">고객센터</a></li>
					<li><a href="/ppp/member/memberinfo" data-toggle="modal"
						data-target="#myModall"><span
							class="glyphicon glyphicon-user"></span> My Page</a></li>
					<li><a href="/ppp/member/memberlogout"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</ul>
			</div>
		</div>
	</div>
	</nav>
	<form action='/ppp/member/memberupdate' method='post'>
		<div class="container">
			<table class="table table-bordered">
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<tr>
					<td>번호</td>
					<td><input type='hidden' value='<%=member.getMemberNo()%>'
						id='member_no' name='member_no'><%=member.getMemberNo()%></td>
				</tr>
				<tr>
					<td style="width:18%">아이디</td>
					<td><input type='hidden' value='<%=member.getMemberId()%>'
						id='member_id' name='member_id'><%=member.getMemberId()%></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" style="background-color: yellow;"
						id="member_pwd1" name='member_pwd'></td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input type="password" style="background-color: yellow;"
						id="member_pwd2"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type='text' style="background-color: yellow;"
						value='<%=member.getMemberAddress()%>' id='member_address'
						name='member_address'></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type='text' style="background-color: yellow;"
						value='<%=member.getMemberName()%>' id='member_name'
						name='member_name'></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type='text' style="background-color: yellow;"
						value='<%=member.getMemberPhone()%>' id='member_phone'
						name='member_phone'></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type='text' style="background-color: yellow;"
						value='<%=member.getMemberMail()%>' id='member_mail'
						name='member_mail'></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type='text' style="background-color: yellow;"
						value='<%=member.getMemberGender()%>' id='member_gender'
						name='member_gender'></td>
				</tr>
				<tr>
					<td>쿠폰</td>
					<td><input type='hidden'
						value='<%=member.getMemberCoupon()%>' id='member_coupon'
						name='member_coupon'><%=member.getMemberCoupon()%></td>
				</tr>
				<input type='hidden' value='<%=member.getAdminNo()%>'
					id='member_adminno' name='member_adminno'>
				<input type='hidden' value='<%=member.getMemberActive()%>'
					id='member_active' name='member_active'>

			</table>
			<input type="submit" class="btn btn-info" value="수정 완료" />
			<button type="button" class="btn btn-info" onclick="location.href = '/ppp/member/membermain'">홈으로</button>
		</div>
	</form>
</body>
</html>