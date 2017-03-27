<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#go').on('click',function(){
			$.ajax({
				type:'POST',
				url:'/ppp/member/hotelidsearch',
				data: {hotel_mail:$("#hotel_mail").val(),hotel_orner_no:$("#hotel_orner_no").val()},
				success:function(response){
					if(response.result === undefined){
						$('#target').html('정보와 일치하는 아이디가 없습니다.').css('border','1px solid red').css('color','red');
					}else
						$('#target').html('귀하의 아이디는 '+response.result+' 입니다.').css('border','1px solid red').css('color','red');
				}
			})
		})
	})
</script>
</head>
<body>

	<p>메일 : <input type='text' id='hotel_mail' name='hotel_mail'></p>
	<p>사업자 등록 번호 : <input type='text' id='hotel_orner_no' name='hotel_orner_no'></p>
	<button id='go'>아이디 찾기</button>
	<br>
	<p id='target'></p>

</body>
</html>