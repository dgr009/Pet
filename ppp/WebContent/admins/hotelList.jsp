<%@page import="java.util.ArrayList"%>
<%@page import="com.ppp.vo.Hotel"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Hotel hotel = (Hotel)session.getAttribute("hotel");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>
</head>
<body>
	<div>
		<table border="1" width="500px">
			<thead>
				<!-- 
					int hotelNo;
					String hotelId;
					String hotelName;
					String hotelAddress;
					String hotelOrnerName;
					String hotelOrnerNo;
					String hotelMail;
					String hotelPhone;
					String hotelPhoto;
					int hotelActive;
					Date hotelActiveDate;
				-->
				<tr>
					<td>��ȣ</td>
					<td>���̵�</td>
					<td>�̸�</td>
					<td>�ּ�</td>
					<td>����� �̸�</td>
					<td>����� ��ȣ</td>
					<td>�̸���</td>
					<td>��ȭ��ȣ<td>
					<td>����</td>
					<td>��Ȱ��ȭ ��¥</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=hotel.getHotelNo() %></td>
					<td><%=hotel.getHotelId() %></td>
					<td><%=hotel.getHotelName() %></td>
					<td><%=hotel.getHotelAddress() %></td>
					<td><%=hotel.getHotelOrnerName() %></td>
					<td><%=hotel.getHotelOrnerNo() %></td>
					<td><%=hotel.getHotelMail() %></td>
					<td><%=hotel.getHotelPhone() %></td>
					<td><%=hotel.getHotelPhoto() %></td>
					<td><%=hotel.getHotelActiveDate() %></td>
				</tr>
				<tr><td colspan="8">---------------------------------</td></tr>
			</tbody>
		</table>
		<input type="button" value="���� ����" onclick="location.href = '/ppp/member/memberupdate'" />
		<input type="button" value="���� �߰�" onclick="location.href = '/ppp/member/animalinsert'" />
		<input type="button" value="���� ������" onclick="location.href = '/ppp/board/receivemessage'" /> 
		<input type="button" value="Ȩ����" onclick="location.href = '/ppp/member/membermain'" />
	</div>
</body>
</html>

