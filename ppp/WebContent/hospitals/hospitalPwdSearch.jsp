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
				url:'/ppp/hospital/hospitalpwdsearch',
				data: {hospital_id:$("#hospital_id").val(),hospital_mail:$("#hospital_mail").val(),hospital_orner_no:$("#hospital_orner_no").val()},
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

	<p>아이디 : <input type='text' id='hospital_id' name='hospital_id'></p>
	<p>메일 : <input type='text' id='hospital_mail' name='hospital_mail'></p>
	<p>사업자 등록번호 : <input type='text' id='hospital_orner_no' name='hospital_orner_no'></p>
	<button id='go'>비밀번호 찾기</button>
	<br>
	<p id='target'></p>

</body>
</html>