<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="modal fade" id="myModall" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">개인 회원 가입</h4>
				</div>
				<form action="/ppp/member/memberregister" method="post">
					<div class="modal-body">

						<div class="form-group">
							<label for="usr">Name:</label> <input type="text"
								class="form-control" id="usr" name='member_name'>
						</div>
						<div class="form-group">
							<label for="usr">I D:</label> <input type="text"
								class="form-control" id="usr" name='member_id'>
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="pwd" name='member_pwd'>
						</div>
						<div class="form-group">
							<label for="pwd">PasswordCheck:</label> <input type="password"
								class="form-control" id="pwd">
						</div>
						<div class="form-group">
							<label for="usr">phone:</label> <input type="text"
								class="form-control" id="usr" name='member_phone'>
						</div>
						<div class="form-group">
							<label for="usr">mail:</label> <input type="text"
								class="form-control" id="usr" name='member_mail'>
						</div>
						<div class="form-group">
							<label for="usr">address:</label> <input type="text"
								class="form-control" id="usr" name='member_address'>
						</div>
						<div class="form-group">
							<label for="usr">Gender:</label><br> <label
								class="checkbox-inline"><input type="checkbox" value="M"
								name='member_gender'>남자</label> <label class="checkbox-inline"><input
								type="checkbox" name='member_gender' value="F">여자</label>
						</div>
						<div>
							<input type='hidden' value='0' name='member_coupon' /> <input
								type='hidden' value='1' name='member_active' /> <input
								type='hidden' value='1' name='member_adminno' />
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default">가입하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>