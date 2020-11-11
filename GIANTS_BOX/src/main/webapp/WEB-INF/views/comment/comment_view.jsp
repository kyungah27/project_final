<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<style>
.button:like {
	border: 0;
	outline: 0;
}
</style>
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
			<b>comment</b> <br /> <br />
			<form name="commentInsertForm">
				<div>

					<input style="text-align: center; width: 150px;" id="user_id"
						name="user_id" type="text" class="form-control" value=""
						readonly="readonly" /><br />
					<textarea style="resize: none;" rows="5" cols="80" name="contents"
						id="contents" class="form-control" placeholder="내용을 입력해주세요"></textarea>
					<br />
					<!-- ---------------*********나중에 세션아이디값받아서 있을경우만 등록 생기도록 if문 -->
					<input type="button" class="btn btn-primary btn-sm" value="등록"
						id="doInsert" />
				</div>
			</form>
		</div>
	</div>
	<div class="container">
		<div class="my-3 p-3 bg-white rounded shadow-sm"
			style="padding-top: 10px">
			<b>comment list</b>
			<hr />
			<div>
				<b>ehgml</b>&nbsp;
				<button class="love" id="like"
					style="background-color: #ffffff; float: right; border: none;">
					<img src="${context}/resources/img/comment/heart.png"
						style="width: 20px;">
				</button>
				<br />
				<div>진짜 너무재밌네요~~ㅋㅋㅋㅋㅋㅋzz</div>
				<br /> <br /> <span>2020.11.11</span> <input type="button"
					class="btn btn-primary btn-sm" value="삭제" id="doDelete"
					style="float: right"><input type="button"
					class="btn btn-primary btn-sm" value="수정" id="doUpdate"
					style="float: right">
			</div>
			<div id="commentList" class="commentList">
				<!--  그리기 -->
			</div>
			<!-- commentList -->
		</div>
		<!-- 댓글리스트  -->
	</div>
	<!-- 흰색배경 -->
	</div>
	<!-- container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript">
		//var div,seq해주기
		$("#doInsert").on("click", function() {
			console.log("#doInsert");

			var contents = $("#contents").val();//댓글 내용
			console.log("contents:" + contents);
			if (null == contents || contents.trim().length == 0) {
				$("#contents").focus();
				alert("내용을 입력하세요.");
				return;
			}
			if (false == confirm("등록 하시겠습니까?"))
				return;
			$.ajax({
				type : "POST",//데이터를 보낼 방식
				url : "${hContext}/comment/doInsert.do",//데이터를 보낼 url
				dataType : "html",
				data : {
					/* 	 "seq" : $("#seq").val(),
						"div" : $("#div").val(),  */
					"contents" : $("#contents").val()
				},//보낼 데이터
				success : function(data) { //성공
					console.log("data=" + data);
					var message = JSON.parse(data);

					alert(meesage.msgContents);
					// 둘 중 하나 삭제하기
					alert("댓글이 등록되었습니다")
					if (data == 1)
						commentList();

					//moveToListView()

				},
				error : function(xhr, status, error) {
					alert(meesage.msgContents);
				}

			});//--ajax
		});

		//수정,삭제 기능 추가
		//commentlist do.?이후 부분+출력부분
		function commentList() {//10:이벤트 20:이벤트 후기

			var url = "${context}/comment/doSelectList.do"
			$.ajax({
				type : "get", //get방식으로 자료를 전달한다
				url : url, //컨트롤러에 있는 list.do로 맵핑하고 게시판 번호도 같이 보낸다.
				data : {
					"seq" : "2",
					"div" : "10"
				},
				success : function(data) { //데이터를 보내는것이 성공했을때 출력되는 메시지
					var commentList = JSON.parse(data);
					console.log("commentList=" + commentList);
					var html = "";

					if (null != commentList && commentList.length > 0) {
						$.each(commentList, function(i, value) {
							console.log(value.commentSeq);

						});
					}
					// $("#commentList").html(htmls);
				},
				error : function(xhr, status, error) {
					alert("error:" + error);
				}
			});

		}

		// 게시글 열리면 자동으로 리스트 홀출할 수 있도록 이벤트 만들어줌
		$(document).ready(function() {
			console.log("document ready");
			commentList();
		})
	</script>
</body>
</html>
