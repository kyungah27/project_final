<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath }" />



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Review Write- Giants Box</title>

<!-- favicon -->
<link rel=" shortcut icon" href="${context}/resources/img/favicon.ico">
<link rel="icon" href="${context}/resources/img/favicon.ico">
<!-- //favicon -->

<link rel="stylesheet"
	href="${context}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
<link rel="stylesheet"
	href="${context}/resources/fonts/font-awesome.min.css">
<link rel="stylesheet"
	href="${context}/resources/fonts/simple-line-icons.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
<link rel="stylesheet" href="${context}/resources/css/styles.min.css"
	rel="stylesheet" type="text/css">

<!--calendar-->
<link href="${context}/resources/css/datepicker.min.css"
	rel="stylesheet" type="text/css">
<!--//calendar-->

<!-- css/불러오는 jsp -->
<!-- //css/불러오는 jsp -->


</head>

<body>

	<main class="page review-page" style="padding-top: 65px;">
		<section class="clean-block clean-form">
			<div class="container">
				<!-- 게시판 작성  -->
				<!-- 제목 -->
				<div class="page-header">
					<h2>게시판 등록</h2>
				</div>
				<!--// 제목 -->

				<!-- button -->
				<div class="row text-right">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></label>
					<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
						<!-- javascript click event -->
						<!-- <input  type="button" class="btn btn-primary btn-sm" value="등록" onclick="javascript:doInsert();" /> -->
						<!-- jquery click event -->
						<input type="button" class="btn btn-primary btn-sm" value="등록"
							id="insertBtn" /> <input type="button"
							class="btn btn-primary btn-sm" value="목록" id="moveList" />
					</div>
				</div>
				<!--// button -->
				<form class="form-horizontal" name="mngFrm"
					action="${hContext}/review/doSelectList.do" method="post">
					<!-- hidden: work_div,div=10(공지사항),read_cnt=0 -->
					<input type="hidden" name="review_seq" id="review_seq" />
					<div class="form-group">
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">글 순서?</label>
						<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
							<%
								//페이지 사이즈

							//??몰라 이부분

							//검색조건
							%>
						</div>
					</div>


					<div class="form-group">
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">작성자</label>
						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
							<input type="text" class="form-control" name="writer" id=""
								writer"" placeholder="작성자" maxlength="20" />
						</div>
					</div>
					
					<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">카테고리</label>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								<input type="text" class="form-control" name="category"
									id="category" placeholder="카테고리" />
							</div>

					<div class="form-group">
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">제목</label>
						<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
							<input type="text" class="form-control" name="title" id="title"
								placeholder="제목" maxlength="200" />
						</div>
					</div>


					<div class="form-group">
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">내용</label>
						<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
							<textarea rows="5" cols="40" name="context" id="context"
								class="form-control"></textarea>
						</div>

						

						</div>
					</div>
				</form>
			</div>
			<!--// container -->
		</section>
		<%--     <%@include  file="/cmn/inc/footer.jsp" %>	 --%>
		</div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

		
		<!-- //게시판 작성  -->

		</div>
		</section>
	</main>

</body>



<!-- 자바스크립트 자리 -->
</body>
</html>
