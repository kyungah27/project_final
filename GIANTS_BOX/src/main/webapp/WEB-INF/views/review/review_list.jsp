<%@page import="com.uver.cmn.Search"%>
<%@page import="com.uver.vo.ReviewVO"%>
<%@page import="java.util.List"%>
<%@page import="com.uver.cmn.StringUtil"%>

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
<title>Review - Giants Box</title>

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
				<div class="page-header">
					<!-- 게시판 -->
					<h1>후기 게시판</h1>
				</div>
				<!-- 검색영역 -->

				<div class="row ">
					<!--  <form action="${hContext}/review/doSelectList.do" name="searchFrm"-->
					<form action="" name="searchFrm"
						class="form-inline  col-lg-12 col-md-12 text-right">
						<input type="hidden" name="pageNum" id="pageNum" /> <input
							type="hidden" name="div" id="div" value="${vo.getDiv()}" /> <input
							type="hidden" name="seq" id="seq" />
						<div class="form-group">

							<select name="search_option" class="form-control" align="center">
								<option value="eventSeq"
									<c:if test="${map.search_option == 'eventSeq'}">selected</c:if>>이벤트번호</option>
								<option value="writer"
									<c:if test="${map.search_option == 'writer'}">selected</c:if>>글쓴이</option>
								<option value="title"
									<c:if test="${map.search_option == 'title'}">selected</c:if>>제목</option>
								<option value="context"
									<c:if test="${map.search_option == 'context'}">selected</c:if>>내용</option>
								<option value="category"
									<c:if test="${map.search_option == 'category'}">selected</c:if>>카테고리</option>

							</select> 
							
							<input type="text" name="searchWord" id="searchWord"
								class="form-control  input-sm" value="${vo.searchWord }"
								placeholder="검색어" /> 
								
							<input type="button"
								class="btn btn-primary btn-sm" value="조회"
								onclick="javascript:doSelectList();" /> 
																
							<!--  <input type="button" class="btn btn-primary btn-sm" value="?!?!" /> -->
							
							<input type="button"
								class="btn btn-primary btn-sm" value="글쓰기" id="doInsertBtn"
								onclick="javascript:doInsert();" />
							
						</div>
					</form>
				</div>


				<!--// 검색영역 -->

				<div class="table-responsive">
					<!-- table -->
					<table
						class="table table-striped table-bordered table-hover table-condensed eclass_k"
						id="review">
						<thead class="bg-primary">
							<th style="width:5%;" class="text-center col-lg-6 col-md-6  col-xs-9">글번호</th>
							<th style="width:7%;" class="text-center col-lg-6 col-md-6  col-xs-9">이벤트번호</th>
							<th style="width:7%;" class="text-center col-lg-2 col-md-2  col-xs-1">카테고리</th>
							<th style="width:6%;" class="text-center col-lg-2 col-md-2  col-xs-1">글쓴이</th>
							<th style="width:15%;" class="text-center col-lg-2 col-md-2  col-xs-1">제목</th>
							<th style="width:7%;" class="text-center col-lg-2 col-md-2  col-xs-1">등록일</th>
						</thead>
						<tbody>
							<!-- 문자: 왼쪽, 숫자: 오른쪽, 같은면: 가운데 -->
							<c:choose>
								<c:when test="${list.size()>0 }">
									<c:forEach var="vo" items="${list}">
										<tr>
											<td class="text-center">${vo.review_seq}</td>
											<td class="text-center">${vo.eventSeq }</td>
											<td class="text-center">${vo.category }</td>
											<td class="text-center">${vo.writer}</td>
											<td class="text-center">${vo.title}</td>
											<td class="text-center">${vo.mod_dt}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td class="text-center" colspan="99">No data found.</td>
									</tr>
								</c:otherwise>
							</c:choose>



						</tbody>

					</table>
					<!--// table -->
				</div>

				<!-- pagenation -->
				<div class="text-center">
					<%
						int maxNum = 0; //총글수
					int currPageNo = 1; //현재페이지
					int rowPerPage = 10; //한페이지에 보여질 행수
					int bottomCount = 10;//바닥에 보여질 페이지 수
					String url = ""; //호출url
					String scriptName = "";//호출javascritpt

					maxNum = (Integer) request.getAttribute("totalCnt");

					Search searchPage = (Search) request.getAttribute("vo");
					if (null != searchPage) {
						currPageNo = searchPage.getPageNum();
						rowPerPage = searchPage.getPageSize();
					}

					url = request.getContextPath() + "/review/doSelectList.do";
					//out.print("url:"+url);
					scriptName = "doSearchPage";

					out.print(StringUtil.renderPaging(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName));
					%>
				</div>
				<!--// pagenation -->
			</div>
			<!--// div container -->
			<%--     <%@include  file="/cmn/inc/footer.jsp" %> --%>
			</div>
			<!-- //게시판 작성  -->

			</div>
		</section>
	</main>

</body>

<!-- 자바스크립트 자리 -->
<script type="text/javascript">
	function doSearchPage(url, num) {
		//alert(url+":"+num);

		var frm = document.searchFrm;
		frm.pageNum.value = num;
		frm.action = url;
		frm.submit();
	}

	$("#doInsertBtn").on("click", function() {

		var frm = document.searchFrm;
		frm.action = "${hContext}/review/doInsert.do";
		frm.submit();

	});

	function doInsert() {
		//alert('doSelectList');
		var frm = document.searchFrm;
		frm.pageNum.value = 1;
		frm.submit();
	}

	function doSelectList() {
		//alert('doSelectList');
		var frm = document.searchFrm;
		frm.pageNum.value = 1;
		frm.submit();
	}

	/* 		$(".eclass_k").on("click", function() {
	 alert(".eclass_k");	
	 }); */

	$("#review>tbody").on("click", "tr", function() {
		//console.log("#boardListTable>tbody");
		var trs = $(this);
		var tds = trs.children();
		var seq = tds.eq(5).text();

		console.log("seq:" + seq);
		//get방식 형태 call
		//window.location.href="${hContext}/board/doSelectOne.do?seq="+seq;

		var frm = document.searchFrm;
		frm.seq.value = seq;
		frm.action = "${hContext}/review/doSelectList.do";
		frm.submit();
	});
</script>

</html>
