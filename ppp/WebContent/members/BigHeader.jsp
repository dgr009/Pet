<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/mycss.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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

	function register_check() {
		var register_form = document.getElementById('orner_register_form');

		if (register_form.user[0].checked == true) {
			register_form.action = "/ppp/hotel/hotelregister";
		} else if (register_form.user[1].checked == true) {
			register_form.action = "/ppp/hospital/hospitalregister";
		} else if (register_form.user[2].checked == true) {
			register_form.action = "/ppp/beauty/beautyregister";
		}
		register_form.submit();
	}

	var InputImage = (function loadImageFile() {
		if (window.FileReader) {
			var ImagePre;
			var ImgReader = new window.FileReader();
			var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i;

			ImgReader.onload = function(Event) {
				if (!ImagePre) {
					var newPreview = document.getElementById("imagePreview");
					ImagePre = new Image();
					ImagePre.style.width = "400px";
					ImagePre.style.height = "400px";
					newPreview.appendChild(ImagePre);
				}
				ImagePre.src = Event.target.result;

			};

			return function() {

				var img = document.getElementById("image").files;

				if (!fileType.test(img[0].type)) {
					alert("이미지 파일을 업로드 하세요");
					return;
				}

				ImgReader.readAsDataURL(img[0]);
			}

		}

		document.getElementById("imagePreview").src = document
				.getElementById("image").value;

	})();
</script>

</head>
<body>
<!-- 헤더 -->
	<%@ include file="header/SmallHeader.jsp"%>

	<!-- 로그인 폼 -->
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
						<input type="button" class="btn btn-default"
							onclick="user_id_check()" id="find_id" value="Find ID"> <input
							type="button" class="btn btn-default" onclick="user_pwd_check()"
							id="find_pwd" value="Find PWD"> <input type="button"
							class="btn btn-default" onclick="login_check()" value="Login">
					</div>

				</form>

			</div>
		</div>
	</div>

	<!-- 회원가입 개인기업 선택 폼 -->
	<%@ include file="SelectRegister.jsp"%>

	<!-- 개인 회원가입 -->
	<%@ include file="MemberRegister.jsp"%>
	<!-- 기업 회원가입 -->
	<%@ include file="OrnerRegister.jsp"%>

</body>
</html>