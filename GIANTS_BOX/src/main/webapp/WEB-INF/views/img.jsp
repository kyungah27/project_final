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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath }"></c:set>
<c:set var="servletContext" value="${pageContext.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>부트스트랩_form_template</title>
    <link rel="shortcut icon" type="image/x-icon" href="${context}/resources/img/favicon.ico" > 
    <!-- 부트스트랩 -->
    <link href="${context}/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link href="/EJDBC/css/layout.css" rel="stylesheet"> -->

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->

  </head>
<body>
<div id="wrap">
<%-- 	<%@include  file="/cmn/inc/header.jsp" %> --%>
	<section>
		<!-- container -->
		<div class="container">
			<!-- 제목 -->
			<div class="page-header">
				<h2>파일 등록</h2>
			</div>
			<!--// 제목 -->
			
			<!-- 이미지 업로드 폼 -->
			<form class="form-horizontal" name="save_frm" action="${context}/img/doInsert.do" method="post" enctype="multipart/form-data">
				<input type="file" id="image" name="image" accept="image/jpg, image/png, image/jpeg, image/gif" onchange="preview(event);" multiple/>
				<input type="submit" class="btn btn-primary btn-sm" value="등록"  />
				<div>
					<table id="img_preview">
						
					</table>
				</div>
			</form>
			<!-- //이미지 업로드 폼 -->
			
			
			<%-- 
			
			<table class="table table-striped table-bordered" id="listTable">
				<thead>
					<th>원본파일명</th>
					<th>저장파일명</th>
					<th>사이즈</th>
					<th>확장자</th>
				</thead>
				<tbody>
					 <c:choose>
					 	<c:when test="${list.size() > 0}">
					 			<c:forEach var="vo" items="${list}">
					 				<tr>
					 					<td>${vo.imgVO.originName }</td>
					 					<td>${vo.imgVO.serverName }</td>
					 					<td>${vo.imgVO.imgSize } byte</td>
					 					<td>${vo.imgVO.imgType } </td>
					 				</tr>
					 <c:set var="imgPath" value="${context}/upload_img/${vo.imgVO.serverName}.${vo.imgVO.imgType}"/>
					 			</c:forEach>	
					 	</c:when>
					 	<c:otherwise>
					 		<tr>
					 			<td class="text-center" colspan="99">등록된 데이터가 없습니다.</td>
					 		</tr>
					 	</c:otherwise>
					 
					 </c:choose>	
				
				</tbody>
			</table> --%>
			
			
			
		</div>
		<!--// container -->
	</section>
<%--     <%@include  file="/cmn/inc/footer.jsp" %>	 --%>
</div>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>   
    
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${context}/resources/js/bootstrap.min.js"></script>
    
    <!-- javascript -->
    <script type="text/javascript">

	    //모든 컨트롤(element)가 로딩이 완료되면.
		$(document).ready(function(){   
			console.log("document ready"); 

		});//document ready    


		// onchange 이벤트
		function preview(event){
			for(var image of event.target.files){

				// FileReader 객체 생성
				var reader = new FileReader();

				// FileReader onload 시 프리뷰 이벤트 발생
				reader.onload = function(event) {
						var tr = document.createElement("tr");
						var td = document.createElement("td");
						var img = document.createElement("img");

						td.appendChild(img);
						tr.appendChild(td);

						
						img.setAttribute("src", event.target.result);
						img.setAttribute("width", "150px");
						document.querySelector("table#img_preview")
								.appendChild(tr);
				};

				console.log(image);
				reader.readAsDataURL(image);
			}
		}

		</script>
    
  </body>
</html>