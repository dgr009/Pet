<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/mycss.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		/*var oner_id = document.getElementById('orner_id');
		var oner_pwd = document.getElementById('orner_pwd');
		var oner_name = document.getElementById('orner_name');
		var oner_no = document.getElementById('orner_no');
		var oner_phone = document.getElementById('orner_phone');
		var oner_address = document.getElementById('orner_address');
		var oner_mail = document.getElementById('orner_mail');
		var oner_active = document.getElementById('orner_active');
		var oner_adminno = document.getElementById('orner_adminno');
		var oner_photo = document.getElementById('orner_photo');
		var business_name = document.getElementById('business_name');*/

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
<style>
body {
	position: relative;
}

#section1 {
	padding-top: 50px;
	height: 650px;
	color: black;
}

#section2 {
	padding-top: 50px;
	height: 700px;
	color: black;
}

#section3 {
	padding-top: 50px;
	height: 700px;
	color: black;
}

#section41 {
	padding-top: 50px; 
	height: 700px;
	color: black;
}

#section42 {
	padding-top: 50px;
	height: 700px;
	color: black;
}

#section43 {
	padding-top: 50px;
	height: 700px;
	color: black;
}
 .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  .btnimg{
  	-webkit-box-shadow: 5px 5px 15px 5px #8F8F8F;
	box-shadow: 5px 5px 15px 5px #8F8F8F;
	margin-left:40px;
	text-align: center;
	border-radius: 10px;
  }
  .glyphicon glyphicon-envelope, .glyphicon glyphicon-earphone{
  	width: 80px;
  	height: 80px;
  }
</style>
</head>
<body>
	<!-- 헤더 -->
	<%@ include file="BigHeader.jsp"%>
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

	<div id="section1" class="container"><br><br><br><br>
		<!-- <img src="images/KakaoTalk_20170328_144152588.png" width="800px">-->
		<h2>Pet PAPA에 오신걸 환영합니다</h2>
		<br>
		<h4>Pet PAPA에서는 반려동물을 위한 미용, 호텔, 진료 서비스를 한번에 이용하실수 있습니다</h4>
					
	</div>
	<div id="section41" class="container">
		<div class="container"><br><br><br><br>
			<h2>애완 호텔</h2>
			<p>애완호텔을 지역별, 평점순, 리뷰순으로 찾아볼수 있습니다</p>
			<div class="row">
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style="background-color: white;">
					<a href="/ppp/hotel/hotelareasearch"><img
						src="https://s-media-cache-ak0.pinimg.com/originals/03/1f/86/031f86ad9fb180893a2d899aeaceb44e.jpg"
						width="150px" height="170"><br>지역별 호텔보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style=" background-color: white;">
					<a href="/ppp/hotel/hotelgradesearch"><img
						src="http://cfile24.uf.tistory.com/image/2419AD4652FC36A7345270"
						width="150px" height="170"><br>평점순 호텔보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style="background-color: white;">
					<a href="/ppp/hotel/hotelreviewsearch"><img
						src="http://cfile6.uf.tistory.com/image/1418904C5053417C19157A"
						width="150px" height="170"><br>리뷰순 호텔보기</a>
				</div>
			</div>
			<br>
			<div class="container">
				<h3>이용방법</h3>
				<button type="button" class="btn btn-info" data-toggle="collapse"
					data-target="#demo">확인하기</button>
				<div id="demo" class="collapse">
					이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용
					방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법</div>
			</div>
		</div>
	</div>
	<div id="section42" class="container">
		<div class="containe"><br><br><br><br>
			<h2>동물병원 보기</h2>
			<p>동물병원을 전체, 지역별, 평점순으로 찾아볼수 있습니다</p>
			<div class="row">
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style="background-color: white;">
					<a href="/ppp/hotel/hotelareasearch"><img
						src="https://s-media-cache-ak0.pinimg.com/originals/03/1f/86/031f86ad9fb180893a2d899aeaceb44e.jpg"
						width="150px" height="170"><br>지역별 호텔보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style="background-color: white;">
					<a href="/ppp/hotel/hotelgradesearch"><img
						src="http://cfile24.uf.tistory.com/image/2419AD4652FC36A7345270"
						width="150px" height="170"><br>평점순 호텔보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style="background-color: white;">
					<a href="/ppp/hotel/hotelreviewsearch"><img
						src="http://cfile6.uf.tistory.com/image/1418904C5053417C19157A"
						width="150px" height="170"><br>리뷰순 호텔보기</a>
				</div>
			</div>
			<br>
			<div class="container">
				<button type="button" class="btn btn-info" data-toggle="collapse"
					data-target="#demoo">확인하기</button>
				<div id="demoo" class="collapse">
					이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용
					방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법</div>
			</div>
		</div>
	</div>
	<div id="section43" class="container">
		<div class="container"><br><br><br><br>
			<h2>애견샵 보기</h2>
			<p>애견샵을 전체, 지역별, 평점순으로 찾아볼수 있습니다</p>
			<div class="row">
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style="background-color: white;">
					<a href="/ppp/hotel/hotelareasearch"><img
						src="https://s-media-cache-ak0.pinimg.com/originals/03/1f/86/031f86ad9fb180893a2d899aeaceb44e.jpg"
						width="150px" height="170"><br>지역별 호텔보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style="background-color: white;">
					<a href="/ppp/hotel/hotelgradesearch"><img
						src="http://cfile24.uf.tistory.com/image/2419AD4652FC36A7345270"
						width="150px" height="170"><br>평점순 호텔보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style="background-color: white;">
					<a href="/ppp/hotel/hotelreviewsearch"><img
						src="http://cfile6.uf.tistory.com/image/1418904C5053417C19157A"
						width="150px" height="170"><br>리뷰순 호텔보기</a>
				</div>
			</div>
			<br>
			<div class="container"><br><br><br><br>
				<button type="button" class="btn btn-info" data-toggle="collapse"
					data-target="#demooo">확인하기</button>
				<div id="demooo" class="collapse"> 
					이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용
					방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법이용방법</div>
			</div>
		</div>
	</div>
	<div id="section2" class="container"><br><br><br><br>
		<h1>게시판</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>글번호</th>
					<th>글쓴이</th>
					<th>제목</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>딸기우유</td>
					<td>딸기우유맛잇다</td>
					<td>2017.03.28</td>
					<td>1</td> 
				</tr>
				<tr>
					<td>Mary</td>
					<td>Moe</td>
					<td>mary@example.com</td>
					<td>1</td>
					<td>2</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		  <button type="button" class="btn btn-primary btn-sm">게시판으로</button>
	</div>
	
	<div id="section3" class="container-fluid"><br><br><br><br>
	           <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">고객센터</h2>
                    <hr class="primary">  
                       <p>궁금하신 사항은 1대1 문의게시판을 통해 문의할수 있습니다</p>
                    <button type="button" class="btn btn-primary btn-sm">1대1문의</button> 
                </div>
                <div class="col-lg-4 col-lg-offset-2 text-center">
                    <i class="glyphicon glyphicon-earphone"></i><br><br>
                    <p>123-456-6789</p>
                </div>
                <div class="col-lg-4 text-center">
                    <i class="glyphicon glyphicon-envelope"></i><br><br>
                    <p><a href="mailto:your-email@your-domain.com">feedback@startbootstrap.com</a></p>
                </div>
                 
            </div>
	</div>
</body>
</html>