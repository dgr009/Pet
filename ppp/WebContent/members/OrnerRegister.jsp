<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="myModalll" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">기업 회원 가입</h4>
				</div>
				<form id="orner_register_form" action="" method="post" enctype="multipart/form-data">
					<div class="modal-body">
						<div class="form-group">
							<label for="who">Orner: </label> <input type="radio"
								name="user" value="hotel">호텔 <input type="radio"
								name="user" value="hospital">병원 <input type="radio"
								name="user" value="beauty">미용
						</div>
						<div class="form-group">
							<label for="usr">Business name:</label> <input type="text"
								class="form-control" id="usr" name='business_name'>
						</div>
						<div class="form-group">
							<label for="usr">Orner name:</label> <input type="text"
								class="form-control" id="usr" name='orner_name'>
						</div>
						<div class="form-group">
							<label for="usr">Orner no:</label> <input type="text"
								class="form-control" id="usr" name='orner_no'>
						</div>
						<div class="form-group">
							<label for="usr">I D:</label> <input type="text"
								class="form-control" id="usr" name='orner_id'>
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="pwd" name='orner_pwd'>
						</div>
						<div class="form-group">
							<label for="pwd">PasswordCheck:</label> <input type="password"
								class="form-control" id="pwd">
						</div>
						<div class="form-group">
							<label for="usr">phone:</label> <input type="text"
								class="form-control" id="usr" name='orner_phone'>
						</div>
						<div class="form-group">
							<label for="usr">mail:</label> <input type="text"
								class="form-control" id="usr" name='orner_mail'>
						</div>
						<div class="form-group">
							<label for="usr">address:</label> <input type="text"
								class="form-control" id="usr" name='orner_address'>
						</div>
						<div>
							<input type='hidden' value='1' name='orner_active' > <input
								type='hidden' value='1' name='orner_adminno' >
						</div>
						<div class="form-group">
							<label for="usr">photo:</label> <input type="file"
								class="form-control" id="image" onchange="InputImage()"
								name='orner_photo'>
							<div id="imagePreview"></div>
						</div>
						
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default"
							onclick="register_check()" value="Register">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>