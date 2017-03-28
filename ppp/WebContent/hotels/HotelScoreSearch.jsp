<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/mycss.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var scoreHotelList = <%=request.getAttribute("result")%>
	// 이름, 메일, 연락처, 위치 //사진
	$.each(scoreHotelList, function(index, h) {
		var hotelMail = $("<tr><td></td></tr>").html(h.hotelMail);
		var hotelPhone = $("<tr><td></td></tr>").html(h.hotelPhone);
		var hotelAddress = $("<tr><td></td></tr>").html(h.hotelAddress);
		var hotelScore = $("<tr><td></td></tr>").html(h.hotelScore);
		$(".hotel_list tbody").append("<tr><td rowspan='5' width='200px'><a href='/ppp/hotel/hotelview?hotel_no="+h.hotelNo+"'><img src='../hotels/hotelimg//"+h.hotelPhoto +"' width='200px' height='200px'></a></td><td>"+h.hotelName+"</td></tr>").append(hotelMail).append(hotelPhone).append(hotelAddress).append(hotelScore);
	});
	
	
});
</script>
<body>
<br><br><br><br>
<div>
<!-- 헤더 -->
	<%@ include file="../members/BigHeader.jsp"%>

</div>
<br><br><br>
<div>
</div>
<br><br><br><br>
<table class="hotel_list"  width="700px">
		
			<thead>
				<tr>
					<th>호텔 리스트</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
</body>
</html>