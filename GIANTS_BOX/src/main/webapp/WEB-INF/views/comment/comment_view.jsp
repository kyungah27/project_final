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
			<b>comment</b> <br /> <br />
			<form name="commentInsertForm">
				<div>

					<input style="text-align: center; width: 150px;" " id="user_id"
						name="user_id" type="text" class="form-control" value=""
						readonly="readonly" /><br />
					<textarea style="resize: none;" rows="5" cols="80" name="contents"
						id="contents" class="form-control" placeholder="내용을 입력해주세요""></textarea>
					<br /> <input type="button" class="btn btn-primary btn-sm"
						value="등록" id="doInsert" /> </span>
				</div>
			</form>
		</div>
	</div>
	<div class="container">
		<div class="my-3 p-3 bg-white rounded shadow-sm"
			style="padding-top: 10px">
			<b>Reply list</b> <br /> <br />
			<div id="commentList" class="commentList"></div>
		</div>
	</div>
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
					"seq" : $("#seq").val(),
					"div" : $("#div").val(),
					"contents" : $("#contents").val()
				},//보낼 데이터
				success : function(data) { //성공
					console.log("data=" + data);
					var message = JSON.parse(data);

					alert(meesage.msgContents);
					// 둘 중 하나 삭제하기
					alert("댓글이 등록되었습니다")
					if (data == 1)
						commentList(seq);

					//moveToListView()

				},
				error : function(xhr, status, error) {
					alert(meesage.msgContents);
				}

			});//--ajax
		});


		//수정,삭제 기능 추가
		//commentlist do.?이후 부분+출력부분
		function commentList(seq,div) {//10:이벤트 20:이벤트 후기

				var url = "${path}/comment/doSeleectList.do?seq="
				url += seq;
			    $.ajax({
			        type: "get", //get방식으로 자료를 전달한다
			        url: "${path}/comment/doSeleectList.do?seq=", //컨트롤러에 있는 list.do로 맵핑하고 게시판 번호도 같이 보낸다.
			        success: function(result){ //자료를 보내는것이 성공했을때 출력되는 메시지
			            //result : responseText 응답텍스트(html)
			            $("#commentList").html(result);
			        
			    });
			}

		}

		// 게시글 열리면 자동으로 리스트 홀출할 수 있도록 이벤트 만들어줌
		$(document).ready(function() {
			commentList(2,10);

			
		})
	</script>
</body>
</html>
