<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/mycss.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


<style>
body {
	position: relative;
}

#section1 {
	padding-top: 50px;
	height: 770px;
	color: black;
	background-color: white;
}

#section2 {
	padding-top: 50px;
	height: 770px;
	color: black;
	background-color: white;
}

#section3 {
	padding-top: 50px;
	height: 770px;
	color: black;
	background-color: white;
}

#section41 {
	padding-top: 50px;
	height: 770px;
	color: black;
	background-color: white;
}

#section42 {
	padding-top: 50px;
	height: 770px;
	color: black;
	background-color: white;
}

#section43 {
	padding-top: 50px;
	height: 770px;
	color: black;
	background-color: white;
}
</style>
</head>
<body>
	<!-- 헤더 -->
	<%@ include file="BigHeader.jsp"%>

	<div id="section1" class="container-fluid">
		<h1>메인</h1>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
	</div>

	<div id="section41" class="container">
		<h2>애완 호텔</h2>
		<div class="container">
			<p>애완호텔을 지역별, 평점순, 리뷰순으로 찾아볼수 있습니다</p>
			<div class="row">
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style="background-color: white;">
					<a href="/ppp/hotel/hotelareasearch"><img
						src="https://s-media-cache-ak0.pinimg.com/originals/03/1f/86/031f86ad9fb180893a2d899aeaceb44e.jpg"
						width="150px" height="170"><br>지역별 호텔보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-3 btnimg"
					style="background-color: white;">
					<a href="/ppp/hotel/hotelscoresearch"><img
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
			<div class="row">
				<div class="col-sm-9 col-md-12 col-lg-8"
					style="background-color: white;">
					<h5>이용방법</h5>
					<h6>
						아픈동물은 죄송하지만 이용하실수 없습니다<br>최근한달내에 수술한친구들은 이용하실수 없습니다
					</h6>
				</div>
			</div>
		</div>
	</div>
	<div id="section42" class="container">
		<h2>동물병원</h2>
		<div class="containe">
			<h2>동물병원 보기</h2>
			<p>동물병원을 전체, 지역별, 평점순으로 찾아볼수 있습니다</p>
			<div class="row">
				<div class="col-sm-3 col-md-6 col-lg-4"
					style="background-color: white;">
					<img
						src="http://cfile6.uf.tistory.com/image/1418904C5053417C19157A"
						width="113.5px"><br> <a href="#" class="btn btn-info"
						role="button">전체 병원보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-4"
					style="background-color: white;">
					<img
						src="https://s-media-cache-ak0.pinimg.com/originals/03/1f/86/031f86ad9fb180893a2d899aeaceb44e.jpg"
						width="113.5px"><br> <a href="#" class="btn btn-info"
						role="button">지역별 병원보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-4"
					style="background-color: white;">
					<img
						src="http://cfile24.uf.tistory.com/image/2419AD4652FC36A7345270"
						width="180.5px"><br> <a href="#" class="btn btn-info"
						role="button">평점순 병원보기</a>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-9 col-md-12 col-lg-8"
					style="background-color: white;">
					<p>
						동물병원 이용방법<br> 동물병원의 이용방법은 이렇게 이렇게 이고
					</p>
					<p>
						동물병원 유의사항<br> 동물병원 이용시 주의사항 은 이렇게 이렇게 입니다
					</p>
				</div>
			</div>
		</div>
	</div>
	<div id="section43" class="container">
		<h1>애완미용</h1>
		<div class="container">
			<h2>애견샵 보기</h2>
			<p>애견샵을 전체, 지역별, 평점순으로 찾아볼수 있습니다</p>
			<div class="row">
				<div class="col-sm-3 col-md-6 col-lg-4"
					style="background-color: white;">
					<img
						src="http://cfile6.uf.tistory.com/image/1418904C5053417C19157A"
						width="113.5px"><br> <a href="#" class="btn btn-info"
						role="button">전체 애견샵보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-4"
					style="background-color: white;">
					<img
						src="https://s-media-cache-ak0.pinimg.com/originals/03/1f/86/031f86ad9fb180893a2d899aeaceb44e.jpg"
						width="113.5px"><br> <a href="#" class="btn btn-info"
						role="button">지역별 애견샵보기</a>
				</div>
				<div class="col-sm-3 col-md-6 col-lg-4"
					style="background-color: white;">
					<img
						src="http://cfile24.uf.tistory.com/image/2419AD4652FC36A7345270"
						width="180.5px"><br> <a href="#" class="btn btn-info"
						role="button">평점순 애견샵보기</a>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-9 col-md-12 col-lg-8"
					style="background-color: white;">
					<p>
						애완샵 이용방법<br> 애완샵의 이용방법은 이렇게 이렇게 이고
					</p>
					<p>
						애완샵 유의사항<br> 애완샵 이용시 주의사항 은 이렇게 이렇게 입니다
					</p>
				</div>
			</div>
		</div>
	</div>
	<div id="section2" class="container-fluid">
		<h1>게시판</h1>
		<p>고민해봅십다</p>
	</div>
	<div id="section3" class="container-fluid">
		<h1>고객센터</h1>
		<div class="container">
			<h3 class="text-center">Contact</h3>
			<p class="text-center">
				<em>We love our fans!</em>
			</p>
			<div class="row test">
				<div class="col-md-4">
					<p>Fan? Drop a note.</p>
					<p>
						<span class="glyphicon glyphicon-map-marker"></span>Chicago, US
					</p>
					<p>
						<span class="glyphicon glyphicon-phone"></span>Phone: +00
						1515151515
					</p>
					<p>
						<span class="glyphicon glyphicon-envelope"></span>Email:
						mail@mail.com
					</p>
				</div>
				<div class="col-md-8">
					<div class="row">
						<div class="col-sm-6 form-group">
							<input class="form-control" id="name" name="name"
								placeholder="Name" type="text" required>
						</div>
						<div class="col-sm-6 form-group">
							<input class="form-control" id="email" name="email"
								placeholder="Email" type="email" required>
						</div>
					</div>
					<textarea class="form-control" id="comments" name="comments"
						placeholder="Comment" rows="5"></textarea>
					<div class="row">
						<div class="col-md-12 form-group">
							<button class="btn pull-right" type="submit">Send</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>