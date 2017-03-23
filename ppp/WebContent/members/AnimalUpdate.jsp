<%@page import="com.ppp.vo.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ppp.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	Member member = (Member)session.getAttribute("member");
	ArrayList<Animal> animallist = (ArrayList<Animal>)session.getAttribute("animallist");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- a.member_no,a.animal_no,a.animal_name,a.animal_kind,a.animal_gender,a.animal_breed,a.animal_weight  -->
<form action='/ppp/member/animalupdate' method='post'>
<table border='1'>
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
				<% for(Animal list:animallist){ %>
					<tr id='no<%=list.getAnimalNo()%>'>
					<td><input type='hidden' name='animal_no' value='<%=list.getAnimalNo()%>'/><%=list.getAnimalNo() %></td>
					<td><input type='text' name='animal_name' value='<%=list.getAnimalName() %>'></td>
					<td><input type='text' name='animal_gender' value='<%=list.getAnimalGender() %>'></td>
					<td><input type='text' name='animal_kind' value='<%=list.getAnimalKind() %>'></td>
					<td><input type='text' name='animal_breed' value='<%=list.getAnimalBreed() %>'></td>
					<td><input type='text' name='animal_weight' value='<%=list.getAnlmalWeigth() %>'></td>
					<td><input type="button" value="삭제" class='delete'></td>
					<td><input type="button" value="수정" class='update'></td>
					</tr>
				
				<%} %>
				
</table>
</form>
<input type='button' onclick='location.href="/ppp/member/membermain"' value='취소'>

</body>
</html>