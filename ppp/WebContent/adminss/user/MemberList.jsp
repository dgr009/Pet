<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

 
 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
$(function() {
	function printList(result) {
		var list = result.list;
		var p = result.pagination;
		var t = $("#context-main tbody");
		$.each(list, function(idx, member) {
			var str = "<tr><td>";
			str = str + member.memberNo + "</td><td>"
			str = str + member.memberId + "</td><td>"
			str = str + member.memberPhone + "</td><td>";
			str = str + member.memberMail + "</td><td>";
			str = str + member.memberAddress+"</td></tr>";
			t.append(str);
		});
		$("#pagination").append("<ul></ul>");
		var pt = $("#pagination ul");
		if(p.prev>-1)
			pt.append("<li><a href='list?pageNo="+p.prev+"'>이전으로</a></li>");
		for(var i=p.startPage;i<=p.endPage;i++)
			pt.append("<li><a href='list?pageNo='"+i+"'>"+i+"</a></li>");
		if(p.next>-1)
			pt.append("<li><a href='list?pageNo="+p.next+"'>다음으로</a></li>");
	}
	$.ajax({
		type: "POST",
		url: "/ppp/admin/memberlist",
		data: {pageNo:1},
		success: function(result) {
			printList(result);
		}
	});
</script>
<style>
body {
   position: relative;
}

#section1  {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white;
}

#section2 {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white;
}

#section3 {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white;
}

#section41 {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white;
}

#section42 {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white;
}
#section43 {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white; 
}
</style>
</head>
<body>

		
	<div class="t_board mt20">
						<table class="board_list" summary="예치금 이용내역">
							<caption>일반회원리스트</caption>
							
							<colgroup>
								<col width="6%" />
								<col width="18%" />
								<col width="18%" />
								<col width="15%" />
								<col width="18%" />
								
								<col width="20%" />
								<col width="15%" />
								<col width="10%" />
								
							</colgroup>
							
							<thead>
							<div>
		<input class="input-text" name="s" id="s" placeholder="Enter Search keywords..." type="text" />
		<input id="searchsubmit" value="Search" type="submit" />
</div>
							<tr> 
								<th>No</th> 
								<th>이름</th> 
								<th>아이디</th>
								<th>연락처</th>  
								<th>이메일</th>   
								<th>주소</th> 
								<th>
								활성화상태
								
								
								</th> 
								<th>탈퇴여부</th> 
								
								  
							</tr> 
							</thead>
							<tbody>
						
						
						  
							</tbody>
						</table>
							<!-- btn -->
							
							
							
							<!-- //btn -->
					</div>
   <div class="container">

</div>
   <br>
    <br>
    <br>    
     <br>
    <br>
    <br>    
     <br>
    <br>
    <br>     
</body>
</html>