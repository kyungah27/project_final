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
	<script src="/WEB-INF/views/movieInfo/movie.js"></script>
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
		
		


	

	</script>
</body>
</html>