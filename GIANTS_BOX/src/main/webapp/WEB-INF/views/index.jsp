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
	
    <link rel="stylesheet" href="${context}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="${context}/resources/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="${context}/resources/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="${context}/resources/css/styles.min.css">
</head>

<body>
    <section class="d-flex flex-column align-items-start justify-content-sm-start align-items-sm-center justify-content-md-start justify-content-lg-start justify-content-xl-start align-items-xl-start clean-block clean-hero" style="background-image: url(&quot;${context}/resources/img/main2.jpg&quot;);color: rgba(130,142,166,0.29);">
        <nav class="navbar navbar-light navbar-expand-sm sticky-top d-xl-flex clean-navbar" style="/*height: 100px;*/background-color: rgba(255,255,255,0);width: 100%;">
            <div class="container-fluid"><a href="main.do"><img src="${context}/resources/img/logo2.png" style="width: 208px;/*filter: blur(0px);*/"></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1" style="background-color: rgba(255,255,255,0.41);"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div
                    class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link text-white" href="login.do">log in</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link text-white" href="signup.do">sign up</a></li>
                    </ul>
            </div>
            </div>
        </nav>
        <div class="d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex flex-column align-items-start align-items-sm-start align-items-md-start align-items-lg-start justify-content-xl-center align-items-xl-start text" style="width: 100%;padding-top: 104px;padding-left: 100px;">
            <h2 class="text-left d-md-flex d-xl-flex justify-content-md-start justify-content-xl-center" style="font-size: 50px;">Discover events<br>for movies you love</h2>
            <p class="d-lg-flex justify-content-lg-start" style="font-size: 22px;">Meet new people and make friends</p>
            
            
            <a href="signup.do">
            	<button class="btn btn-primary btn-lg" type="button" style="background-color: #0078ff;">Join Us</button>
            </a>
            
            </div>
    </section>
    <main class="page landing-page" style="padding: 0;">

        <section>
            <%@include file="cmn/search.jsp" %>
        </section>




        <section class="clean-block">
            <div class="container">
                <div class="d-flex flex-column justify-content-between block-heading" style="margin-bottom: 7px;">
                    <h2 class="text-primary">Event near you</h2><a class="d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-end justify-content-sm-end justify-content-md-end justify-content-lg-end justify-content-xl-end align-items-xl-center" href="#">See more</a></div>
                <div
                    class="row justify-content-center">
                    <div class="col-sm-6 col-lg-4">
                        <div class="card clean-card text-center"><img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/halloween.jpg">
                            <div class="card-body info">
                                <p class="text-left card-text"><strong>10월 31일 6:30PM</strong></p>
                                <h4 class="text-truncate card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                <div class="icons"><a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i class="icon-social-instagram"></i></a><a href="#"><i class="icon-social-twitter"></i></a><small>59명 참여</small></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="card clean-card text-center"><img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/music.jpg">
                            <div class="card-body info">
                                <p class="text-left card-text"><strong>11월 6일 8:00PM</strong></p>
                                <h4 class="text-truncate card-title">불금<strong>🔥🔥🔥</strong>&nbsp;온라인 무비 마라톤 (라라랜드, 위플래시, 스쿨오브락 음악영화 달리기)</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                <div class="icons"><a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i class="icon-social-instagram"></i></a><a href="#"><i class="icon-social-twitter"></i></a><small>12명 참여</small></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="card clean-card text-center"><img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/netflix.jpg">
                            <div class="card-body info">
                                <p class="text-left card-text"><strong>11월 20일 5:00PM</strong></p>
                                <h4 class="text-truncate card-title">넷플릭스 + 맥주 + Chilling!</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                <div class="icons"><a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i class="icon-social-instagram"></i></a><a href="#"><i class="icon-social-twitter"></i></a><small>2명 참여</small></div>
                            </div>
                        </div>
                    </div>
            </div>
            </div>
        </section>
        <section class="clean-block clean-info dark">
            <div class="container">
                <div class="d-flex flex-column justify-content-between block-heading" style="margin-bottom: 7px;">
                    <h2 class="text-primary">Films for Events</h2><a class="d-flex d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-end justify-content-sm-end justify-content-md-end justify-content-lg-end justify-content-xl-end align-items-xl-center" href="#">See more</a>
                </div>
               	<div class="row" id = "movie_info">
				<!--  박스 오피스 정보 append 위치 -->
           	 	</div>
            </div>
        </section>
        <section class="clean-block features">
            <div class="container">
                <div class="d-flex flex-column justify-content-between block-heading" style="margin-bottom: 7px;">
                    <h2 class="text-primary">Reviews</h2>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card clean-testimonial-item border-0 rounded-0">
                            <div class="card-body">
                                <h3 class="text-truncate">삼진그룹 영어토익반 함께 봐요</h3>
                                <h5 class="text-truncate">짧막한 후기</h5>
                                <p class="card-text">지인들의 시사회 평이 잔뜩 기대했는데 그 이상이었습니다. 왜 평일에 개봉한 건지ㅠㅠ 평일 저녁에도 참가해주신 분들 감사해요! 복고풍 영화들이 다 그렇듯이 이 영화도 향수를 자극하는 여러 장치들이 존재...</p>
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
                                <p class="card-text">역시 주말에는 치맥이랑 코믹영화를 같이 봐야지요. 너무 웃어서 몸살 나는 줄 알았아요. 이번 멤버 정말 미친 것 같은ㅋㅋㅋㅋㅋㅋ 다음에도 이 멤버 리멤버 포에버...☆</p>
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
                                <p class="card-text">역시 명불허전 어벤져스2 다시 봐도 재밌었습니다. 혼자만 보다가 마블 세계관 덕후들이랑 같이 보니까 2배는 더 재밌는 것 같아요. 다음에는 DC로 한번 달려요^^ 사진 게시판에 오늘 찍은 사진...</p>
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
        <section class="clean-block slider dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-primary">Gallery</h2>
                </div>
                <div class="carousel slide shadow" data-ride="carousel" data-interval="false" id="carousel-1">
                    <div class="carousel-inner border rounded" role="listbox">
                        <div class="carousel-item active"><img class="w-100 d-block" src="${context}/resources/img/event_img/photo2.jpg" alt="Slide Image" style="height: 750px;"></div>
                        <div class="carousel-item"><img class="w-100 d-block" src="${context}/resources/img/event_img/photo3.jpg" alt="Slide Image" style="height: 750px;"></div>
                        <div class="carousel-item"><img class="w-100 d-block" src="${context}/resources/img/event_img/photo4.jpg" alt="Slide Image" style="height: 750px;"></div>
                    </div>
                    <div>
                        <!-- Start: Previous --><a class="carousel-control-prev" href="#carousel-1" role="button" data-slide="prev"><span class="carousel-control-prev-icon"></span><span class="sr-only">Previous</span></a>
                        <!-- End: Previous -->
                        <!-- Start: Next --><a class="carousel-control-next" href="#carousel-1" role="button" data-slide="next"><span class="carousel-control-next-icon"></span><span class="sr-only">Next</span></a>
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
            <h2>Join our Newsletter</h2><input type="text" class="form-control" placeholder="Email"><button class="btn btn-outline-light" type="button">Subscribe</button></div>
        <!-- End: Newsletter Sign Up Blue -->
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <h5>Get started</h5>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Sign up</a></li>
                        <li><a href="#">Log in</a></li>
                    </ul>
                </div>
                <div class="col-sm-3">
                    <h5><strong>Event</strong><br></h5>
                    <ul>
                        <li><a href="#">Events</a></li>
                        <li><a href="#">Movies</a></li>
                        <li><a href="#">Reviews</a></li>
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
                <div class="col-sm-3 d-flex justify-content-center justify-content-xl-start align-items-xl-center">
                    <!-- Start: Social Icons -->
                    <div class="clean-block add-on social-icons" style="padding: 0;padding-top: 0;">
                        <div class="icons"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-instagram"></i></a><a href="#"><i class="fa fa-twitter"></i></a></div>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="${context}/resources/js/script.min.js"></script>
    <script type="text/javascript">

	$(document).ready(function() {
		console.log("document ready");
		let today = new Date();   
		let year = today.getFullYear(); // 년도
		let month = today.getMonth() + 1;  // 월
		let date = today.getDate()-2;  // 날짜
		var currentDate = year+""+month+""+date;
		console.log(currentDate);
		boxOffList(currentDate);


		$('#search_btn').click(function() {
			$(location).attr('href',"event_list.do?searchWord="+$("#search-field").val());
		});

	});

    
    function searchOneToNameKM(movieNm) {
		console.log("searchOneToNameKM");
		var key = 'HAE2WH3Y4F7C3N2R6Z1Y';
		var url = 'http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey='+key+'&title=';
		url += movieNm;
		console.log(url);
		$.ajax({
			url : url,
			type : 'GET',
			dataType : 'html',
			success : function(s) {
				var item = JSON.parse(s);
				console.log(item);
				data = item.Data[0];
				result = data.Result[0];		
				//제목
				var title = result.title;
				title = title.replace(/!HS/gi, " ");
				title = title.replace(/!HE/gi, " ");
				console.log(title);										
				//감독
				var director = result.directors.director[0].directorNm;
				console.log(director);
				//출연
				var actors = "";
				$.each(result.actors.actor, function(i,actor) {
					if(i == 3) return false;
					
					actors += actor.actorNm+"  ";
					console.log(actors);
				})							
				//장르
				var genre = result.genre;
				console.log(genre); 								
				//코드
				var DOCID = result.DOCID;
				console.log(DOCID); 
				//포스터 url
				var poster = result.posters;
				poster = poster.split("|");
				var posterUrl = poster[0];
				console.log(posterUrl); 
				// 줄거리
				var plot = result.plots.plot[0].plotText;
				console.log(plot); 	
				var html = '';
				html += '<div class="col-md-6 col-lg-4" style= "margin-bottom: 10px;">'
				html +=	'<div class="card">'
				html += '<img class= "card-img-top w-100 d-block" src= '+posterUrl+'>'
				html += '<div class="card-body"> <h4 class="card-title">'+title+'</h4>'
				html += '<p class="card-text"><strong>감독 </strong>'+director+'<br>'
				html += '<strong>출연 </strong>'+actors+'<br>'
				html += '<strong>장르 </strong>'+genre+'</p>'
				html += '</div><div class="text-center" style="margin-bottom: 20px;"><button class="btn btn-outline-primary btn-sm" type="button">관련 이벤트</button></div></div></div>'	
				console.log(html);	
				$("#movie_info").append(html);		
			},
			error : function(xhr, status, error) {
				alert("error:" + error);
			},
			complete : function(data) {
			}
		})
	}

	function boxOffList(date) {
		console.log("boxOffList");
		var url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=6f53bd46d6879627e90298b05f473d62&itemPerPage=3&targetDt=';
		url += date;
		//url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
		console.log(url);
		$.ajax({
			url : url,
			type : 'get',
			dataType : 'json',
			success : function(item) {
				$.each(item.boxOfficeResult.dailyBoxOfficeList, function(i,
						content) {

					var movieCd = content.movieCd;
					console.log(movieCd);
					
					//detailMovieInfo(movieCd);
					var movieNm = content.movieNm;
					console.log(movieNm);
					searchOneToNameKM(movieNm);
				})
			},
			error : function(xhr, status, error) {
				alert("error:" + error);
			},
			complete : function(data) {
			}
		})
	}







    </script>
</body>

</html>