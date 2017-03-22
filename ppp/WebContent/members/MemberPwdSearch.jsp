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
				url:'/ppp/member/memberpwdsearch',
				data: {member_id:$("#member_id").val(),member_name:$("#member_name").val(),member_mail:$("#member_mail").val()},
				success:function(response){
					if(response.result === undefined){
						$('#target').html('정보가 일치하지 않습니다.').css('border','1px solid red').css('color','red');
					}else
						$('#target').html('귀하의 비밀번호는 '+response.result+' 입니다.').css('border','1px solid red').css('color','red');
				}
			})
		})
	})
</script>
</head>
<body>

	<p>아이디 : <input type='text' id='member_id' name='member_id'></p>
	<p>이름 : <input type='text' id='member_name' name='member_name'></p>
	<p>메일 : <input type='text' id='member_mail' name='member_mail'></p>
	<button id='go'>비밀번호 찾기</button>
	<br>
	<p id='target'></p>

</body>
</html>