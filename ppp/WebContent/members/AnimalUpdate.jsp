<%@page import="com.ppp.vo.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ppp.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Animal a = (Animal) request.getAttribute("result");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- 
<script type="text/javascript">
var a = request.getAttribute("result")
var animalNo = $("<td></td>").html(a.animalNo);
var animalName = $("<td></td>").html(a.animalName);
var animalKind = $("<td></td>").html(a.animalKind);
var animalGender = $("<td></td>").html(a.animalGender);
var animalBreed = $("<td></td>").html(a.animalBreed);
var animalWeight = $("<td></td>").html(a.animalWeight);
var tr = $("<tr></tr>").append(animalNo).append(animalName).append(animalKind).append(animalGender).append(animalBreed).append(animalWeight).append(tda);
$(".list tbody").append(tr);
</script>
 -->
</head>
<body>
	<!-- a.member_no,a.animal_no,a.animal_name,a.animal_kind,a.animal_gender,a.animal_breed,a.animal_weight  -->
	<form action='/ppp/member/animalupdate' method='post'>
		<table border='1' class='list' width="500px">
			<thead>
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
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type='hidden' value='<%=a.getAnimalNo()%>' name="animal_no"><%=a.getAnimalNo()%></td>
					<td><input type="text" value='<%=a.getAnimalName()%>' name="animal_name"></td>
					<td><input type="text" value='<%=a.getAnimalGender()%>' name="animal_gender"></td>
					<td><input type="text" value='<%=a.getAnimalKind()%>' name="animal_kind"></td>
					<td><input type="text" value='<%=a.getAnimalBreed()%>' name="animal_breed"></td>
					<td><input type="text" value='<%=a.getAnimalWeigth()%>' name="animal_weight"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<input type='button' onclick='location.href="/ppp/member/membermain"'
		value='취소'>

</body>
</html>