<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Home - Giants Box</title>
<!-- favicon -->
<link rel=" shortcut icon" href="${context}/resources/img/favicon.ico">
<link rel="icon" href="${context}/resources/img/favicon.ico">
<!-- //favicon -->
<link rel="stylesheet" href="${context}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
<link rel="stylesheet" href="${context}/resources/fonts/font-awesome.min.css">
<link rel="stylesheet" href="${context}/resources/fonts/simple-line-icons.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
<link rel="stylesheet" href="${context}/resources/css/styles.min.css">
<!--calendar-->
<link href="${context}/resources/css/datepicker.min.css" rel="stylesheet" type="text/css">
<!--//calendar-->
</head>

<body>
	<section class="d-flex flex-column align-items-start justify-content-sm-start align-items-sm-center justify-content-md-start justify-content-lg-start justify-content-xl-start align-items-xl-start clean-block clean-hero"
		style="background-image: url(&quot;${context}/resources/img/main2.jpg&quot;);color: rgba(130,142,166,0.29);">
		<nav
			class="navbar navbar-light navbar-expand-sm sticky-top d-xl-flex clean-navbar"
			style="background-color: rgba(255, 255, 255, 0); width: 100%;">
			<div class="container-fluid">
				<a href="main.do"><img src="${context}/resources/img/logo2.png"
					style="width: 208px;"></a>
				<button data-toggle="collapse" class="navbar-toggler"
					data-target="#navcol-1"
					style="background-color: rgba(255, 255, 255, 0.41);">
					<span class="sr-only">Toggle navigation</span><span
						class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navcol-1">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item" role="presentation"><a
							class="nav-link text-white" href="login.do">explore</a></li>
						<li class="nav-item" role="presentation"><a
							class="nav-link text-white" href="login.do">my event</a></li>
						<li class="nav-item" role="presentation"><a
							class="nav-link text-white" href="login.do">my account</a></li>
						<li class="nav-item" role="presentation"><a
							class="nav-link text-white" href="login.do">log out</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex flex-column align-items-start align-items-sm-start align-items-md-start align-items-lg-start justify-content-xl-center align-items-xl-start text"
			style="width: 100%; padding-top: 104px; padding-left: 100px;">
			<h2
				class="text-left d-md-flex d-xl-flex justify-content-md-start justify-content-xl-center"
				style="font-size: 50px;">
				Discover events<br>for movies you love
			</h2>
			<p class="d-lg-flex justify-content-lg-start"
				style="font-size: 22px;">Meet new people and make friends</p>
			<button class="btn btn-primary btn-lg" type="button"
				style="background-color: #0078ff;">Join Event</button>
		</div>
	</section>

	<main class="page landing-page" style="padding: 0;">


		<section>
			<!-- Start: Navigation with Search -->
			<nav
				class="navbar navbar-light navbar-expand-md navigation-clean-search">
				<div class="container">
					<button data-toggle="collapse" class="navbar-toggler"
						data-target="#navcol-1">
						<span class="sr-only">Toggle navigation</span><span
							class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse text-center d-xl-flex"
						id="navcol-1"
						style="padding: 10px; padding-right: 20%; padding-left: 20%;">
						<form class="form-inline mx-auto" style="width: 82%;" method="get"
							target="_self">
							<div class="form-group" style="width: 100%;">
								<label for="search-field"><i class="fa fa-search"></i></label><input
									class="form-control search-field" type="search"
									id="search-field" name="search" style="width: 95%;"
									placeholder="검색">
							</div>
						</form>
						<a class="btn btn-light mr-auto action-button" role="button"
							href="#" style="background-color: rgb(0, 120, 255);">검색</a>
					</div>
				</div>
			</nav>
			<!-- End: Navigation with Search -->
		</section>

		<section class="clean-block">
			<div class="container">

				<div
					class="d-flex flex-column justify-content-between block-heading"
					style="margin-bottom: 7px;">
					<h2 class="text-primary">My Upcoming Events</h2>
					<a
						class="d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-end justify-content-sm-end justify-content-md-end justify-content-lg-end justify-content-xl-end align-items-xl-center"
						href="#">See more</a>
				</div>

				<div class="row d-flex justify-content-around">

					<div class="mb-3">
						<div class="datepicker-here" data-language="en"></div>
					</div>

					<div class="col-lg-9 col-md-7">
						<div class="card clean-card text-left">
							<div class="card-body">
								<p class="text-left card-text">
									<strong>10월 31일 6:30PM</strong>
								</p>
								<h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
								<p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
							</div>

							<!-- 이벤트 반복 -->
							<hr/>
							<div class="card-body">
								<p class="text-left card-text">
									<strong>10월 31일 6:30PM</strong>
								</p>
								<h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
								<p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
							</div>
							
							<!-- 참여 이벤트 없을 경우 -->
							<hr/>
							<div class="card-body">
								<h4 class="card-title">참여하는 이벤트가 없습니다.</h4>
							</div>
						</div>
					</div>


				</div>

			</div>
		</section>

		<section class="clean-block dark">
			<div class="container">
				<div
					class="d-flex flex-column justify-content-between block-heading"
					style="margin-bottom: 7px;">
					<h2 class="text-primary">Event near you</h2>
					<a
						class="d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-end justify-content-sm-end justify-content-md-end justify-content-lg-end justify-content-xl-end align-items-xl-center"
						href="#">See more</a>
				</div>
				<div class="row justify-content-center">
					<div class="col-sm-6 col-lg-4">
						<div class="card clean-card text-center">
							<img class="card-img-top w-100 d-block"
								src="${context}/resources/img/event_thumbnail/halloween.jpg">
							<div class="card-body info">
								<p class="text-left card-text">
									<strong>10월 31일 6:30PM</strong>
								</p>
								<h4 class="text-truncate card-title">[할로윈 파티] 무서운 영화 시리즈 함께
									보실 분 :)</h4>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit.</p>
								<div class="icons">
									<a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i
										class="icon-social-instagram"></i></a><a href="#"><i
										class="icon-social-twitter"></i></a><small>59명 참여</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="card clean-card text-center">
							<img class="card-img-top w-100 d-block"
								src="${context}/resources/img/event_thumbnail/music.jpg">
							<div class="card-body info">
								<p class="text-left card-text">
									<strong>11월 6일 8:00PM</strong>
								</p>
								<h4 class="text-truncate card-title">
									불금<strong>🔥🔥🔥</strong>&nbsp;온라인 무비 마라톤 (라라랜드, 위플래시, 스쿨오브락
									음악영화 달리기)
								</h4>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit.</p>
								<div class="icons">
									<a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i
										class="icon-social-instagram"></i></a><a href="#"><i
										class="icon-social-twitter"></i></a><small>12명 참여</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="card clean-card text-center">
							<img class="card-img-top w-100 d-block"
								src="${context}/resources/img/event_thumbnail/netflix.jpg">
							<div class="card-body info">
								<p class="text-left card-text">
									<strong>11월 20일 5:00PM</strong>
								</p>
								<h4 class="text-truncate card-title">넷플릭스 + 맥주 + Chilling!</h4>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit.</p>
								<div class="icons">
									<a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i
										class="icon-social-instagram"></i></a><a href="#"><i
										class="icon-social-twitter"></i></a><small>2명 참여</small>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="clean-block">
			<div class="container">
				<div
					class="d-flex flex-column justify-content-between block-heading"
					style="margin-bottom: 7px;">
					<h2 class="text-primary">Films for Events</h2>
					<a
						class="d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-end justify-content-sm-end justify-content-md-end justify-content-lg-end justify-content-xl-end align-items-xl-center"
						href="#">See more</a>
				</div>
				<div class="row">
					<div class="col-md-6 col-lg-4" style="margin-bottom: 10px;">
						<div class="card">
							<img class="card-img-top w-100 d-block"
								src="${context}/resources/img/movie_rank/rank1.jpg">
							<div class="card-body">
								<h4 class="card-title">삼진그룹 영어토익반</h4>
								<p class="card-text">
									<strong>감독 </strong>이종필<br>
									<strong>출연 </strong>고아성, 이솜, 박혜수 등<br>
									<strong>장르</strong> 드라마
								</p>
							</div>
							<div class="text-center" style="margin-bottom: 20px;">
								<button class="btn btn-outline-primary btn-sm" type="button">관련
									이벤트</button>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-lg-4" style="margin-bottom: 10px;">
						<div class="card">
							<img class="card-img-top w-100 d-block"
								src="${context}/resources/img/movie_rank/rank2.jpg">
							<div class="card-body">
								<h4 class="card-title">미스터트롯: 더무비</h4>
								<p class="card-text">
									<strong>감독&nbsp;</strong><br>
									<strong>출연</strong>&nbsp;임영웅, 영탁, 이찬원 등<br>
									<strong>장르</strong>&nbsp;공연실황
								</p>
							</div>
							<div class="text-center" style="margin-bottom: 20px;">
								<button class="btn btn-outline-primary btn-sm" type="button">관련
									이벤트</button>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-lg-4" style="margin-bottom: 10px;">
						<div class="card">
							<img class="card-img-top w-100 d-block"
								src="${context}/resources/img/movie_rank/rank3.jpg">
							<div class="card-body">
								<h4 class="card-title">담보</h4>
								<p class="card-text">
									<strong>감독&nbsp;</strong>강대규<br>
									<strong>출연 </strong>성동일, 하지원, 김희원 등<br>
									<strong>장르</strong>&nbsp;드라마<br>
								</p>
							</div>
							<div class="text-center" style="margin-bottom: 20px;">
								<button class="btn btn-outline-primary btn-sm" type="button">관련
									이벤트</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="clean-block dark">
			<div class="container">
				<div
					class="d-flex flex-column justify-content-between block-heading"
					style="margin-bottom: 7px;">
					<h2 class="text-primary">Reviews</h2>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="card clean-testimonial-item border-0 rounded-0">
							<div class="card-body">
								<h3 class="text-truncate">삼진그룹 영어토익반 함께 봐요</h3>
								<h5 class="text-truncate">짧막한 후기</h5>
								<p class="card-text">지인들의 시사회 평이 잔뜩 기대했는데 그 이상이었습니다. 왜 평일에
									개봉한 건지ㅠㅠ 평일 저녁에도 참가해주신 분들 감사해요! 복고풍 영화들이 다 그렇듯이 이 영화도 향수를 자극하는
									여러 장치들이 존재...</p>
								<div class="d-flex justify-content-between">
									<h4>byebyetoeic</h4>
									<h6>2020.10.20</h6>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card clean-testimonial-item border-0 rounded-0">
							<div class="card-body">
								<h3 class="text-truncate">[3차] 주말에도 우리는 달린다</h3>
								<h5 class="text-truncate">역시 주말에는 치맥 + 코믹영화네요</h5>
								<p class="card-text">역시 주말에는 치맥이랑 코믹영화를 같이 봐야지요. 너무 웃어서 몸살
									나는 줄 알았아요. 이번 멤버 정말 미친 것 같은ㅋㅋㅋㅋㅋㅋ 다음에도 이 멤버 리멤버 포에버...☆</p>
								<div class="d-flex justify-content-between">
									<h4>comedykingkk</h4>
									<h6>2020.10.20</h6>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card clean-testimonial-item border-0 rounded-0">
							<div class="card-body">
								<h3 class="text-truncate">오랜만에 어벤져스2 같이 보실 분!!!</h3>
								<h5 class="text-truncate">다시 봐도 재밌네요</h5>
								<p class="card-text">역시 명불허전 어벤져스2 다시 봐도 재밌었습니다. 혼자만 보다가 마블
									세계관 덕후들이랑 같이 보니까 2배는 더 재밌는 것 같아요. 다음에는 DC로 한번 달려요^^ 사진 게시판에 오늘
									찍은 사진...</p>
								<div class="d-flex justify-content-between">
									<h4>captain_korea95</h4>
									<h6>2020.10.20</h6>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="clean-block slider">
			<div class="container">
				<div class="block-heading">
					<h2 class="text-primary">Gallery</h2>
				</div>
				<div class="carousel slide shadow" data-ride="carousel"
					data-interval="false" id="carousel-1">
					<div class="carousel-inner border rounded" role="listbox">
						<div class="carousel-item active">
							<img class="w-100 d-block"
								src="${context}/resources/img/event_img/photo2.jpg"
								alt="Slide Image" style="height: 750px;">
						</div>
						<div class="carousel-item">
							<img class="w-100 d-block"
								src="${context}/resources/img/event_img/photo3.jpg"
								alt="Slide Image" style="height: 750px;">
						</div>
						<div class="carousel-item">
							<img class="w-100 d-block"
								src="${context}/resources/img/event_img/photo4.jpg"
								alt="Slide Image" style="height: 750px;">
						</div>
					</div>
					<div>
						<!-- Start: Previous -->
						<a class="carousel-control-prev" href="#carousel-1" role="button"
							data-slide="prev"><span class="carousel-control-prev-icon"></span><span
							class="sr-only">Previous</span></a>
						<!-- End: Previous -->
						<!-- Start: Next -->
						<a class="carousel-control-next" href="#carousel-1" role="button"
							data-slide="next"><span class="carousel-control-next-icon"></span><span
							class="sr-only">Next</span></a>
						<!-- End: Next -->
					</div>
					<ol class="carousel-indicators">
						<li data-target="#carousel-1" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-1" data-slide-to="1"></li>
						<li data-target="#carousel-1" data-slide-to="2"></li>
					</ol>
				</div>
			</div>
		</section>
	</main>




	<!-- Start: Footer White -->
	<footer class="page-footer">
		<!-- Start: Newsletter Sign Up Blue -->
		<div class="clean-block add-on newsletter-sign-up blue">
			<h2>Join our Newsletter</h2>
			<input type="text" class="form-control" placeholder="Email">
			<button class="btn btn-outline-light" type="button">Subscribe</button>
		</div>
		<!-- End: Newsletter Sign Up Blue -->
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<h5>Get started</h5>
					<ul>
						<li><a href="#">Home</a></li>
						<li><a href="#">Log out</a></li>
					</ul>
				</div>
				<div class="col-sm-3">
					<h5>
						<strong>Event</strong><br>
					</h5>
					<ul>
						<li><a href="#">Explore</a></li>
						<li><a href="#">Today's Events</a></li>
						<li><a href="#">My Events</a></li>
					</ul>
				</div>
				<div class="col-sm-3">
					<h5>Support</h5>
					<ul>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Help</a></li>
						<li><a href="#">Contact us</a></li>
					</ul>
				</div>
				<div
					class="col-sm-3 d-flex justify-content-center justify-content-xl-start align-items-xl-center">
					<!-- Start: Social Icons -->
					<div class="clean-block add-on social-icons"
						style="padding: 0; padding-top: 0;">
						<div class="icons">
							<a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i
								class="fa fa-instagram"></i></a><a href="#"><i
								class="fa fa-twitter"></i></a>
						</div>
					</div>
					<!-- End: Social Icons -->
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<p>© 2020 Copyright Team Uver All rights reserved</p>
		</div>
	</footer>
	<!-- End: Footer White -->

	<script src="${context}/resources/js/jquery.min.js"></script>
	<script src="${context}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
	<script src="${context}/resources/js/script.min.js"></script>

	<!-- calendar -->
	<script src="${context}/resources/js/datepicker.min.js"></script>
	<script src="${context}/resources/js/datepicker.en.js"></script>
	<!-- //calendar -->


</body>
</html>