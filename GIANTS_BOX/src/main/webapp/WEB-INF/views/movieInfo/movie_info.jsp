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
			
		$("#search_btn").on("click", function(e) {
			var movieNm = $("#movie_name").val();
			searchToNameKM(movieNm);	
		});

		 $(document).on("click","button[name=select_btn]",function(){
				var tmp = $(this).val().split("|");
				
			 
				alert($(this).val());
				if( false==confirm("선택하시겠습니까?"))return;
				$(opener.document).find('#movie_code').val(tmp[0]);
				$(opener.document).find('#movie_genre').val(tmp[1]);
				window.close();
		}) ;
		

		//information by 한국영화데이터 베이스 (https://www.kmdb.or.kr)
		function searchToNameKM(movieNm) {
			$("#movie_info").empty();	
			var key = 'HAE2WH3Y4F7C3N2R6Z1Y';
			var url = 'http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey='+key+'&title=';
			url += movieNm;
			//url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
			$.ajax({
				url : url,
				type : 'GET',
				dataType : 'html',
				success : function(s) {
					var item = JSON.parse(s);
					$.each(item.Data, function(i,data) {

						$.each(data.Result, function(i,result) {

							var title = result.title;
							title = title.replace(/!HS/gi, " ");
							title = title.replace(/!HE/gi, " ");									
							//감독
							var director = result.directors.director[0].directorNm;
							//출연
							var actors = "";
							$.each(result.actors.actor, function(i,actor) {
								if(i == 3) return false;
								
								actors += actor.actorNm+"  ";
							})							
							//장르
							var genre = result.genre;							
							//코드
							var DOCID = result.DOCID;
							//포스터 url
							var poster = result.posters;
							poster = poster.split("|");
							
							var posterUrl = poster[0];
							if(posterUrl.length < 1){
								posterUrl = "${context}/resources/img/logo.png"
							}
							// 줄거리
							var plot = result.plots.plot[0].plotText;
							var html = '';
							html += '<div class="col-md-6 col-lg-4" style= "margin-bottom: 10px;">'
							html +=	'<div class="card">'
							html += '<img class= "card-img-top w-100 d-block" src= '+posterUrl+'>'
							html += '<div class="card-body"> <h4 class="card-title">'+title+'</h4>'
							html += '<p class="card-text"><strong>감독 </strong>'+director+'<br>'
							html += '<strong>출연 </strong>'+actors+'<br>'
							html += '<strong>장르</strong>'+genre+'</p>'
							html += '</div><div class="text-center" style="margin-bottom: 20px;"><button value='+DOCID+"|"+genre+' name="select_btn" class="btn btn-outline-primary btn-sm" type="button">선택</button></div></div></div>'	;
							
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

	
		//information by 한국영화데이터 베이스 (https://www.kmdb.or.kr)
		function searchOneToNameKM(movieNm) {
			var key = 'HAE2WH3Y4F7C3N2R6Z1Y';
			var url = 'http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey='+key+'&title=';
			url += movieNm;
			$.ajax({
				url : url,
				type : 'GET',
				dataType : 'html',
				success : function(s) {
					var item = JSON.parse(s);
					data = item.Data[0];
					result = data.Result[0];		
					//제목
					var title = result.title;									
					//감독
					var director = result.directors.director[0].directorNm;
					//출연
					$.each(result.actors.actor, function(i,actor) {
						if(i == 3) return false;
						var actors = "";
						actors += actor.actorNm+"  ";
					})							
					//장르
					var genre = result.genre;								
					//코드
					var DOCID = result.DOCID;
					//포스터 url
					var poster = result.posters;
					poster = poster.split("|");
					var posterUrl = poster[0];
					// 줄거리
					var plot = result.plots.plot[0].plotText;			
				 			
				},
				error : function(xhr, status, error) {
					alert("error:" + error);
				},
				complete : function(data) {
				}
			})
		}







		//information by KOFIC 영화관입장권통합전산망 오픈 API (http://kobis.or.kr/kobisopenapi)
		function searchToName(movieNm) {
			var url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=6f53bd46d6879627e90298b05f473d62&movieNm=';
			url += movieNm;
			//url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
			$.ajax({
				url : url,
				type : 'get',
				dataType : 'json',
				success : function(item) {
					$.each(item.movieListResult.movieList, function(i,content) {
						var movieCd = content.movieCd; // 영화코드	 관련이벤트 조회때 필요
						var movieNm = content.movieNm;
						var nationAlt = content.nationAlt;
						var prdtYear = content.prdtYear;
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
		//information by KOFIC 영화관입장권통합전산망 오픈 API (http://kobis.or.kr/kobisopenapi)
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
						
						//detailMovieInfo(movieCd);
						var movieNm = content.movieNm;
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
		//information by KOFIC 영화관입장권통합전산망 오픈 API (http://kobis.or.kr/kobisopenapi)
		function detailMovieInfo(movieCd) {
			var url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=6f53bd46d6879627e90298b05f473d62&movieCd=';
			url += movieCd;
			//url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
			$.ajax({
				url : url,
				type : 'get',
				dataType : 'json',
				success : function(item) {

					var movieInfo = item.movieInfoResult.movieInfo;

					//영화제목
					var movieNm = movieInfo.movieNm;
					//영화 감독 정보
					var directorName = movieInfo.directors[0].peopleNm;
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