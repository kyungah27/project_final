<%--
/**
	Class Name:
	Description:
	Modification information
	
	수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2020. 9. 18        최초작성 
    
    author eclass 개발팀
    since 2020.05
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${context}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="${context}/resources/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="${context}/resources/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="${context}/resources/css/styles.min.css">
<title>movie_info</title>

</head>
<body>

	<!-- movie_list -->
        <section class="clean-block clean-info dark">
            <div class="container">
                <div class="d-flex flex-column justify-content-between block-heading" style="margin-bottom: 7px;">
                    <h2 class="text-primary">영화이름을 검색해 주세요</h2></div>
                
         			<div class="row">
                   	<input   class="form-control input-sm " type="text" style="width:1000px; float:right" id="movie_name"placeholder="이름을 검색해주세요" value=""></input>
                    <input type="button" class="btn btn-primary btn-sm" style="float:right" value="찾기"  id="search_btn" />
                    </div>
                <div class="row" id = "movie_info">
    
            	</div>
        	</div>
        </section>

	<!-- //movie_list -->




	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${context}/resources/js/movie_func.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			console.log("document ready");
			//boxOffList(date);
			//detailMovieInfo(20192193);
			//searchToName("광해");
			//searchToNameKM("우뢰매");
		});
			
		$("#search_btn").on("click", function(e) {
			var movieNm = $("#movie_name").val();
			searchToNameKM(movieNm);	
		});

		 $(document).on("click","button[name=select_btn]",function(){
				alert($(this).val());
				/* $(document).find('#selected_seq').val($(this).val());
				window.open("/ABC/layout/trans/trans_detail.jsp", "window" ,"width=800 height=400"); */
		}) ;
		


		function searchToNameKM(movieNm) {
			$("#movie_info").empty();	
			console.log("searchToNameKM");
			var key = 'HAE2WH3Y4F7C3N2R6Z1Y';
			var url = 'http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey='+key+'&title=';
			url += movieNm;
			//url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
			console.log(url);
			$.ajax({
				url : url,
				type : 'GET',
				dataType : 'html',
				success : function(s) {
					var item = JSON.parse(s);
					console.log(item);
					$.each(item.Data, function(i,data) {

						$.each(data.Result, function(i,result) {

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
							if(posterUrl.length < 1){
								posterUrl = "${context}/resources/img/logo.png"
							}
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
							html += '<strong>장르</strong>'+genre+'</p>'
							html += '</div><div class="text-center" style="margin-bottom: 20px;"><button value='+DOCID+' name="select_btn" class="btn btn-outline-primary btn-sm" type="button">관련 이벤트</button></div></div></div>'	
							console.log(html);	
							$("#movie_info").append(html);			
						}) 
					})  			
				},
				error : function(xhr, status, error) {
					alert("error:" + error);
				},
				complete : function(data) {
				}
			})
		}

	
		
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
					console.log(title);										
					//감독
					var director = result.directors.director[0].directorNm;
					console.log(director);
					//출연
					$.each(result.actors.actor, function(i,actor) {
						if(i == 3) return false;
						var actors = "";
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
				 			
				},
				error : function(xhr, status, error) {
					alert("error:" + error);
				},
				complete : function(data) {
				}
			})
		}







		
		function searchToName(movieNm) {
			console.log("searchToName");
			var url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=6f53bd46d6879627e90298b05f473d62&movieNm=';
			url += movieNm;
			//url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
			console.log(url);
			$.ajax({
				url : url,
				type : 'get',
				dataType : 'json',
				success : function(item) {
					$.each(item.movieListResult.movieList, function(i,content) {
						var movieCd = content.movieCd; // 영화코드	 관련이벤트 조회때 필요
						console.log(movieCd);
						var movieNm = content.movieNm;
						console.log(movieNm);
						var nationAlt = content.nationAlt;
						console.log(nationAlt);
						var prdtYear = content.prdtYear;
						console.log(prdtYear);
						var directorList = content.directors;
						var directorsNames = "";
						$.each(directorList, function(i, content) {
							directorsNames += content.peopleNm + "  ";
						})
						
					})
				},
				error : function(xhr, status, error) {
					alert("error:" + error);
				},
				complete : function(data) {
				}
			})
		}

		//박스오피스 조회
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

		//영화 상세조회
		function detailMovieInfo(movieCd) {
			console.log("detailMovieInfo");
			var url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=6f53bd46d6879627e90298b05f473d62&movieCd=';
			url += movieCd;
			//url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
			console.log(url);
			$.ajax({
				url : url,
				type : 'get',
				dataType : 'json',
				success : function(item) {

					var movieInfo = item.movieInfoResult.movieInfo;

					//영화제목
					var movieNm = movieInfo.movieNm;
					console.log("영화제목  : " + movieNm);
					//영화 감독 정보
					var directorName = movieInfo.directors[0].peopleNm;
					console.log("감독  : " + directorName);
				},
				error : function(xhr, status, error) {
					alert("error:" + error);
				},
				complete : function(data) {
				}
			})
		}

		function selectKey(DOCID){
			
			alert(DOCID);

		}
		
		
		

	

	</script>
</body>
</html>