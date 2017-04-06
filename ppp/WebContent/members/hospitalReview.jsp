<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	var hospitalNo = <%=request.getParameter("hospital_no")%>
	$(".modal-body").append("<input type='hidden' value='"+ hospitalNo +"' name='hospital_no'>" );
</script>
<body>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4 class="modal-title">Hospital Review</h4>
	</div>
	<form action="/ppp/hospital/writehospitalreview" method="post">
		<div class="modal-body">
			<div class="form-group">
				<label for="who">SCORE: </label> <input type="radio" name="score"
					value="1">1 <input type="radio" name="score" value="2">2
				<input type="radio" name="score" value="3">3 <input
					type="radio" name="score" value="4">4 <input type="radio"
					name="score" value="5">5
			</div>
			<div class="form-group">
				<label for="usr">내용:</label> <br>
				<textarea rows='20' cols='66' id="epilogue" name="epilogue">정말 좋았어요~</textarea>
			</div>

		</div>
		<div class="modal-footer">
			<input type="submit" class="btn btn-default" value="작성">
		</div>
	</form>

</body>
</html>