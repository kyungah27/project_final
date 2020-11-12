/**
 * 
 */
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


		function searchToNameKM(movieNm) {
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
							html += '</div><div class="text-center" style="margin-bottom: 20px;"><button class="btn btn-outline-primary btn-sm" type="button">관련 이벤트</button></div></div></div>'	
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