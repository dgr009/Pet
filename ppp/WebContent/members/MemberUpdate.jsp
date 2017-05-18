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
</head>
<body>
   <form action='/ppp/member/memberupdate' method='post'>
      <div class="container">
         <table class="table table-bordered">
            <h2>회원정보수정</h2>
            <thead>
               <tr>
                  <th width="15%;">회원번호</th>
                  <td><input type='hidden' value='<%=member.getMemberNo()%>'
                     id='member_no' name='member_no'><%=member.getMemberNo()%></td>
               </tr>
               <tr>
                  <th>아이디</th>
                  <td><input type='hidden' value='<%=member.getMemberId()%>'
                     id='member_id' name='member_id'><%=member.getMemberId()%></td>
               </tr>
               <tr>
                  <th>비밀번호</th>
                  <td><input type="password" style="background-color: #D8D8D8;"
                     id="member_pwd1" name='member_pwd'></td>
               </tr>
               <tr>
                  <th>비밀번호확인</th>
                  <td><input type="password" style="background-color: #D8D8D8;"
                     id="member_pwd2"></td>
               </tr>
               <tr>
                  <th>주소</th>
                  <td><input type='text' style="background-color: #D8D8D8;"
                     value='<%=member.getMemberAddress()%>' id='member_address'
                     name='member_address'></td>
               </tr>
               <tr>
                  <th>이름</th>
                  <td><input type='text' style="background-color: #D8D8D8;"
                     value='<%=member.getMemberName()%>' id='member_name'
                     name='member_name'></td>
               </tr>
               <tr>
                  <th>연락처</th>
                  <td><input type='text' style="background-color: #D8D8D8;"
                     value='<%=member.getMemberPhone()%>' id='member_phone'
                     name='member_phone'></td>
               </tr>
               <th>이메일</th>
               <td><input type='text' style="background-color: #D8D8D8;"
                  value='<%=member.getMemberMail()%>' id='member_mail'
                  name='member_mail'></td>
               <tr>
                  <th>성별</th>
                  <td><input type='text' style="background-color: #D8D8D8;"
                     value='<%=member.getMemberGender()%>' id='member_gender'
                     name='member_gender'></td>
               </tr>
               <tr>
                  <th>쿠폰</th>
                  <td><input type='hidden'
                     value='<%=member.getMemberCoupon()%>' id='member_coupon'
                     name='member_coupon'><%=member.getMemberCoupon()%></td>
               </tr>
            </thead>
            <tbody>
               <input type='hidden' value='<%=member.getAdminNo()%>'
                  id='member_adminno' name='member_adminno'>
               <input type='hidden' value='<%=member.getMemberActive()%>'
                  id='member_active' name='member_active'>

            </tbody>
         </table>
         <span style="float: right"><input type="submit"
            class="btn btn-info" value="수정 완료" /></span> <span style="float: right"><input
            type="button" class="btn btn-info" value="홈으로"
            onclick="location.href = '/ppp/member/membermain'" /></span>
      </div>
   </form>
</body>
</html>