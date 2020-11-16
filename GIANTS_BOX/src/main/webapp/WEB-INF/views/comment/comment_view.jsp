<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>comment</title>
<link rel="stylesheet"
	href="${context}/resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="my-3 p-3 bg-white rounded shadow-sm"
			style="padding-top: 10px">
			<b>comment</b>
			<hr />
			<form name="commentInsertForm" id="commentInsertForm">
				<div>
					<input type="hidden" name="regId" id="regId" value="${vo.regId}" />
					<input type="hidden" name="seq" id="seq" value="${vo.seq}" /> <input
						type="hidden" name="div" id="div" value="${vo.getDiv()}" />
					<!-- 세션처리받아서 아이디 받는걸로 수정하기 -->
					<input style="text-align: center; width: 150px;" id="user_id"
						name="user_id" type="text" class="form-control" value="yeji"
						readonly="readonly" /><br />
					<textarea style="resize: none;" rows="5" cols="80" name="content"
						id="content" class="form-control" placeholder="내용을 입력해주세요"></textarea>
					<br />
					<!-- ---------------*********나중에 세션아이디값받아서 있을경우만 등록 생기도록 if문 -->
					<input type="button" class="btn btn-primary btn-sm" value="등록"
						id="doInsert" style="float: right" /> <br />
				</div>
			</form>
		</div>
	</div>
	<div class="container">
		<div class="my-3 p-3 bg-white rounded shadow-sm"
			style="padding-top: 10px">
			<b>comment list</b>
			<hr />
			<!-- json에 추가해주기 -->
			<%-- <div>
				<span><b>ehgml</b></span>
				<button id="like"
					style="background-color: #ffffff; float: right; border: none;">
					<img src="${context}/resources/img/comment/heart.png"
						style="width: 20px;">
				</button>
				<br />
				<div>진짜 너무재밌네요~~ㅋㅋㅋㅋㅋㅋzz</div>
				<br /> <br />
				<p>
					<span>2020.11.11</span> <input type="button"
						class="btn btn-primary btn-sm" value="삭제" id="doDelete"
						style="float: right"> <input type="button"
						class="btn btn-primary btn-sm" value="수정" id="doUpdate"
						style="float: right"> <br />
				</p>
			</div> --%>
			<!-- //제이슨 추가 -->
			<div id="commentList" class="commentList">
				<!--  그리기 -->
			</div>
			<!-- commentList -->
		</div>
		<!-- 댓글리스트  -->
	</div>
	<!-- 흰색배경 -->

	<!-- container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript">
		//var div,seq해주기
		$("#doInsert").on("click", function() {
			console.log("#doInsert");
			var url = "${context}/comment/doInsert.do"
			var content = $("#content").val();//댓글 내용
			console.log("content:" + content);
			if (null == content || content.trim().length == 0) {
				$("#content").focus();
				alert("내용을 입력하세요.");
				return;
			} else {
				alert("등록 하시겠습니까?");
			}
			$.ajax({
				type : "POST",//데이터를 보낼 방식
				url : url,//데이터를 보낼 url
				dataType : "html",
				data : {
					"seq" : "2",
					"div" : "10",//임의의값
					"content" : content,
					"regId" : "yeji"//${user}
				},//보낼 데이터
				success : function(data) { //성공
					console.log("data=" + data);
					console.log("content=" + content);

					if (data != null) {
						alert("댓글이 등록되었습니다");
						$("#commentList").empty();
						commentList();
						document.getElementById("content").value = '';
					}
				},
				error : function(xhr, status, error) {
					alert(meesage.msgContents);
				}

			});

		});

		//수정,삭제 기능 추가
		//commentlist do.?이후 부분+출력부분
		function commentList() {//10:이벤트 20:이벤트 후기

			var url = "${context}/comment/doSelectList.do"
			$
					.ajax({
						type : "get", //get방식으로 자료를 전달한다
						url : url, //컨트롤러에 있는 list.do로 맵핑하고 게시판 번호도 같이 보낸다.
						data : {
							"seq" : "2",
							"div" : "10"
						},
						success : function(data) { //데이터를 보내는것이 성공했을때 출력되는 메시지

							var commentList = data;//JSON.parse(data);
							console.log("commentList=" + commentList);
							var html = "";

							if (null != commentList && commentList.length > 0) {
								$
										.each(
												commentList,
												function(i, vo) {
													console.log(vo.commentSeq);
													console.log(vo.content);
													console.log(vo.modDt);
													html += '<span>'
													html += '<strong>'
															+ vo.regId + ""
															+ '</strong>';
													html += '<button id="like" style="background-color: #ffffff; float: right; border: none;">';
													html += '<img src="${context}/resources/img/comment/heart.png" style="width: 20px;"/>'
													html += '</button>'
													html += (vo.likeCnt)
													html += '</span>'
													html += '<br/>';
													html += '<div>'+ vo.content+ '</div>';
													html += '<br/>';
													html += '<p>';
													html += '<span>';
													html += vo.modDt;
													html += '<input type="button" onclick="commentdelete('+ vo.commentSeq+ ');" class="btn btn-primary btn-sm" value="삭제" id="doDelete" style="float: right">';
													html += '<input type="button" class="mr-1 btn btn-primary btn-sm" value="수정" id="doUpdate" style="float: right">';
													html += '</p>';
												});
								console.log(html);
								$("#commentList").append(html);
							} else {
								html += "<div class='text-center'><label>등록된 댓글이 없습니다.</label></div>"
								$("#commentList").append(html);
							}
						},
						error : function(xhr, status, error) {
							alert("error:" + error);
						}
					});

		}
		function commentdelete(commentSeq) {
			console.log("commentdelete" + commentSeq);

			var url = "${context}/comment/doDelete.do"
			$.ajax({
				type : "POST",//데이터를 보낼 방식
				url : url,//데이터를 보낼 url
				dataType : "html",
				data : {
					"commentSeq" : commentSeq
				},//보낼 데이터
				success : function(data) { //성공
					console.log("data=" + data);
					console.log("commentSeq=" + commentSeq);
					if (data != null) {
						alert("댓글이 삭제되었습니다");
						$("#commentList").empty();
						commentList();
					} else {
						alert("실패 삭제되었습니다");
					}

				},
				error : function(xhr, status, error) {
					alert(meesage.msgContents);
				}

			});//--ajax
		}
		// 게시글 열리면 자동으로 리스트 홀출할 수 있도록 이벤트 만들어줌
		$(document).ready(function() {
			console.log("document ready");
			commentList();
		})
	</script>
</body>
</html>
