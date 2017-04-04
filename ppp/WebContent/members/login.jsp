<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	function login_check() {
		var login_form = document.getElementById('login_form');
		var user_id = document.getElementById('usr_id');
		var user_pwd = document.getElementById('usr_pwd');
		if (login_form.user[0].checked == true) {
			login_form.action = "/ppp/member/login";
		} else if (login_form.user[1].checked == true) {
			login_form.action = "/ppp/hotel/login";
		} else if (login_form.user[2].checked == true) {
			login_form.action = "/ppp/hospital/login";
		} else if (login_form.user[3].checked == true) {
			login_form.action = "/ppp/beauty/login";
		}
		login_form.submit();
	}

	function user_id_check() {
		var btn = $("#find_id");
		var login_form = document.getElementById('login_form');
		if (login_form.user[0].checked == true) {
			location.href = "/ppp/member/memberidsearch";
		} else if (login_form.user[1].checked == true) {
			location.href = "/ppp/hotel/hotelidsearch";
		} else if (login_form.user[2].checked == true) {
			location.href = "/ppp/hospital/hospitalidsearch";
		} else if (login_form.user[3].checked == true) {
			location.href = "/ppp/beauty/beautyidsearch";
		}
	}
	function user_pwd_check() {
		var btn = $("find_pwd");
		var login_form = document.getElementById('login_form');
		if (login_form.user[0].checked == true) {
			location.href = "/ppp/member/memberpwdsearch";
		} else if (login_form.user[1].checked == true) {
			location.href = "/ppp/hotel/hotelpwdsearch";
		} else if (login_form.user[2].checked == true) {
			location.href = "/ppp/hospital/hospitalpwdsearch";
		} else if (login_form.user[3].checked == true) {
			location.href = "/ppp/beauty/beautypwdsearch";
		}
	}
	</script>
</head>
<body>
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
						<input type="button" class="btn btn-default"
							onclick="user_id_check()" id="find_id" value="Find ID"> <input
							type="button" class="btn btn-default" onclick="user_pwd_check()"
							id="find_pwd" value="Find PWD"> <input type="button"
							class="btn btn-default" onclick="login_check()" value="Login">
					</div>

				</form>

			</div>
</body>
</html>