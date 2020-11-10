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
<link href="${context}/resources/css/bootstrap.min.css" rel="stylesheet">
<title>movie_info</title>

</head>
<body>

	<h2>영화 테스트</h2>
	<div style="margin-bottom: 10px;">
		<input class="form-control input-sm " type="text" id="movie_name"
			placeholder="숫자만 입력해주세요." value="영화코드">
		<input type="button" class="btn btn-primary btn-sm" value="찾기" id="search_btn" />
	</div>
	<!-- place_list -->
	<div style="margin-bottom: 10px;">
		<select multiple class='form-control' id='movie_list' size="10">
			
		</select>
	</div>
	<!-- //place_list -->

	<!-- button -->
	<input type="button" class="btn btn-primary btn-sm" value="등록"
		id="find_place_verify" />
	<!-- //button -->



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			console.log("document ready");
			//boxOffList(20201109);
			//detailMovieInfo(20192193);
			//searchToName("광해");
			
			 $("#search_btn").on("click",function(){
					var searchWord = $("movie_name").val();
					searchToName(searchWord);
				}) ;

			

		});

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
						
						$('#movie_list').append("<option value="+movieCd+">"+"|영화명  : "+movieNm+"&nbsp;&nbsp;&nbsp;&nbsp; | 제작국가 : "
								+nationAlt+"&nbsp;&nbsp;&nbsp;&nbsp;| 개봉년도 :"+prdtYear+"&nbsp;&nbsp;&nbsp;&nbsp;| 감독 : "+directorsNames+"</option>");

						

						
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

						detailMovieInfo(movieCd);

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
					var directorList = movieInfo.directors;
					var directorsNames = "";
					$.each(directorList, function(i, content) {
						directorsNames += content.peopleNm + "  ";
					})
					console.log("감독  : " + directorsNames);
					//영화 배우 조회
					var actorList = movieInfo.actors;
					var actorsNames = "";
					$.each(actorList, function(i, content) {
						if (i == 3)
							return false;
						actorsNames += content.peopleNm + "  ";
					})
					console.log("출연  : " + actorsNames);

					var genreList = movieInfo.genres;
					var genresNames = "";
					$.each(genreList, function(i, content) {
						genresNames += content.genreNm + "  ";
					})
					console.log("장르  : " + genresNames);

				},
				error : function(xhr, status, error) {
					alert("error:" + error);
				},
				complete : function(data) {
				}
			})
		}

		/* 		function writeSelect(obj) {
		 $("#select_list").empty();
		
		 for (var i = 0; i < obj.length - 1; i++) {			
		 $('#place_list').append("<option value="+obj[i].placeNum+">"+"지점코드 :"+obj[i].placeNum+"&nbsp;&nbsp;&nbsp;&nbsp;지점명 : "+obj[i].placeName+"</option>");
		
		 }
		 $('#ss').append("</select>");
		 } */
	</script>
</body>
</html>