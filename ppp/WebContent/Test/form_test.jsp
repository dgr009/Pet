<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language='javascript'> 
function test_submit() 
{ 
var test_form = document.getElementById('test'); 
if(test_form.t_radio[0].checked==true){ 
test_form.action="http://ABC.com/Aboard/bbs/search.php"} 
else{ 
test_form.action="http://ABC.com/Bboard/bbs/search.php"} 
test_form.submit(); 
} 
 </script> 
</head>
<body>
<form id='test' method='get' action=''> 
<input type='radio' name='t_radio' value='a'>A 
<input type='radio' name='t_radio' value='b'>B 
<input type='button' onclick='test_submit()' value='테스트하기'> 
</form>
</body>
 
</html>