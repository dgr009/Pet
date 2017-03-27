<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/ppp/admin/hoteldeactiviysearch" method="GET">
	<table>
		<tr>
			<td>회원 리스트</td>
			<td></td>
		</tr>
	</table>
	<button>로그인</button>
</body>
</html>

<!-- 
	$(function() {
		var list = result.list;
		var pagination = result.pagination;
		var target = $("#content-main table tbody");
		$.each(list, function(idx, emp) {
			var str = "<tr><td>"+emp.employeeId+"</td>";
			str = str + "<td><a href='view?pageNo=" + pagination.pageNo + "&employee_id=" + emp.employeeId + "'>" + (emp.firstName+" "+emp.lastName) + "</a></td>";
			str = str + "<td>" + emp.departmentName + "</td><td></tr>";
			target.append(str);
		});
		$("#pagination").append("<ul></ul>");
		var p = $("#pagination ul");
		if (pagination.prev > -1)
			p.append("<li><a href='list?pageNo=" + pagination.prev + "'>이전으로</a></li>");
		for (var i = pagination.startPage; i <= pagination.endPage; i++)
			p.append("<li><a href='list?pageNo=" + i + "'>" + i + "</a></li>");
		if (pagination.next > -1)
			p.append("<li><a href='list?pageNo=" + pagination.next + "'>다음으로</a></li>");
	});
 -->