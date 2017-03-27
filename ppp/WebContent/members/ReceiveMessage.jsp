<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var list = <%=request.getAttribute("result")%>
	$.each(list, function(index, l) {
		var msgNo = $("<td></td>").html(l.messageNo);
		var msgTitle = $("<td></td>").html(l.messageTitle);
		var msgContent = $("<td></td>").html(l.messageContent);
		var msgDate = $("<td></td>").html(l.messageDate);
	
		var del = $("<a class='delete'></a>").prop("href", "receivemessagedelete?message_no="+l.messageNo).html('삭제');
		var tddel = $("<td></td>").append(del);
		// var ename = $("<td></td>").append(a);
		//var ename = "<td empno='" + e.empno + "'>" + e.ename + "</td>";
		var tr = $("<tr></tr>").append(msgNo).append(msgTitle).append(msgContent).append(msgDate).append(tddel);
		$(".list tbody").append(tr);
	});
	
	
});
	
</script>
</head>
<body>
		<table class="list" border="1" width="1000px">
		
			<thead>		
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>받은날짜</th>
				</tr>
			</thead>
			<tbody >
				
			</tbody>
		</table>
</body>
</html>