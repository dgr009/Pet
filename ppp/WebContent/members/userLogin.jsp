<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인 -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Login</h4>
				</div>
				<form id="login_form" action="" method="post">


					<div class="modal-body">
						<div class="form-group">
							<label for="who">User: </label> <input type="radio" name="user"
								value="member" checked="checked">멤버 <input type="radio"
								name="user" value="hotel">호텔 <input type="radio"
								name="user" value="hospital">병원 <input type="radio"
								name="user" value="beauty">미용
						</div>
						<div class="form-group">
							<label for="usr">I D:</label> <input type="text"
								class="form-control" id="usr_id" name="member_id">
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="usr_pwd" name="member_pwd">
						</div>


					</div>
					<div class="modal-footer">
						<button type="button"
							onclick="location.href = '/ppp/member/memberidsearch'"
							class="btn btn-default">아이디찾기</button>
						<button type="button"
							onclick="location.href = '/ppp/member/memberpwdsearch'"
							class="btn btn-default">비밀번호 찾기</button>
						<input type="button" class="btn btn-default"
							onclick="login_check()" value="Login">
					</div>

				</form>

			</div>
		</div>
	</div>
</body>
</html>