<%@page import="com.ppp.vo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action='/ppp/admin/messagesend' method='post'>
<table border='1'>
	<tr><td>ȸ�� ��ȣ</td><td><input type='text' name='member_no'></td></tr>
	<tr><td>����</td><td><input type='text' name='message_title'></td></tr>
	<tr><td>����</td><td><input type='text' name='message_content'></td></tr>
	<tr><td>���� ��¥</td><td><input type='text' name='message_date'></td></tr>
</table>
<input type="submit" value='�߰�'>

<input type='button' onclick='location.href="/ppp/admin/messagesend"' value='���'>
</form>

</body>
</html>