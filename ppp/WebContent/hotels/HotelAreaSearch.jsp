<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var areaHotelList = <%=request.getAttribute("result")%>
	$.each(areaHotelList, function(index, h) {
		$(".hotel_list tbody").append("<tr><td><img src='<%=h.hotelPhoto%>'></td></tr>");
	});
	
	
});
</script>
<body>
<div>
<form action="/ppp/hotel/hotelareasearch" method="get">
	지역 검색 : <input type="text" name="area"><button>검색</button>
</form>
</div>
<table class="hotel_list" border="1" width="500px">
		
			<thead>		
				<tr>
					<th colspan="2">호텔 리스트</th>
				</tr>
			</thead>
			<tbody >
				
			</tbody>
		</table>
</body>
</html>