<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="context" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<style>
.like:hover {
transform: scale( 1.3 );
color: red;
}
.fa:active-color{
 color: red;

 
}

 .className1{
 
 
 }
 

</style>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>comment</title>
<link rel="stylesheet"
	href="${context}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
	<div class="container">
		<div class="my-3 p-3 bg-white rounded shadow-sm"
			style="padding-top: 10px">
			<b>comment</b>
			<hr />
			<form name="commentInsertForm" id="commentInsertForm">
				<div>
					<input type="hidden" name="user_id" id="user_id" value="${user.userId}" />
					<input type="hidden" name="seq" id="seq" value="${vo.seq}" /> <input
						type="hidden" name="div" id="div" value="${vo.getDiv()}" />
					<!-- 세션처리받아서 아이디 받는걸로 수정하기 -->
					<input style="text-align: center; width: 150px;" id="user_id"
						name="user_id" type="text" class="form-control" value="${user.userId}"
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
	<!-- </div> -->
	
	<!-- <div class="update">
	<input style="text-align: center; width: 150px;" id="user_id" name="user_id" type="text" class="form-control" value="yeji" readonly="readonly" />
	<br />
	<textarea style="resize: none;" rows="5" cols="80" name="upcontent" id="content" class="form-control" placeholder="내용을 입력해주세요"></textarea>
	<br />
	<input type="button" class="btn btn-primary btn-sm" value="수정" style="float: right" /><br/>
	</div> -->

		<!--<div class="container">-->
		<div class="my-3 p-3 bg-white rounded shadow-sm"
			style="padding-top: 10px">
			<b>comment list</b> <b>( <b id="count"> </b> )
			</b> <br />
			<hr />
			<!-- json에 추가해주기 -->
			<div id="commentList" class="commentList">
				<!--  그리기 -->
			</div>
			<!-- commentList -->
		</div>
		<!-- 댓글리스트  -->
	</div>
	<!-- 흰색배경 -->

	<!-- container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
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
					"regId" : "${sessionScope.user.userId}"
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

			});//-----ajax

		});//----------doInsert


		//---[수정]
	function commentUpdate(commentSeq,content) {
	var html = "";
	html += '<input style="text-align: center; width: 130px;" id="user_id" name="user_id" type="text" class="form-control" value="yeji" readonly="readonly" />';
	html += '<br />';
	html += '<textarea style="resize: none;" rows="5" cols="80" name="upcontent" id="content" class="form-control" placeholder="내용을 입력해주세요">'+'</textarea>';
	html += '<br />';
	html += '<input type="button" onclick="commentUpdateSave('+ commentSeq+ ');" class="btn btn-primary btn-sm" value="수정" style="float: right" />'+'<br/>'
	$("#commentList").append(html);

	}//commentUpdate

		//보내는값에 session추가
		function commentUpdateSave(commentSeq) {
			console.log(">>>>>>>>>>doUpdate");
			var url = "${context}/comment/doUpdate.do"
			var content = $("#content").val();//댓글 내용
			console.log("content:" + content);
			if (null == content || content.trim().length == 0) {
				$("#content").focus();
				alert("내용을 입력하세요.");
				return;
			} else {
				alert("수정 하시겠습니까?");
			}
			$.ajax({
				type : "POST",//데이터를 보낼 방식
				url : url,//데이터를 보낼 url
				dataType : "html",
				data : {
					"seq" : "2",
					"div" : "10",//임의의값
					"content" : content,
					"regId" : "${sessionScope.user.userId}"
				},//보낼 데이터
				success : function(data) { //성공
					console.log("data=" + data);
					console.log("content=" + content);
						alert("댓글이 수정되었습니다");
						$("#commentList").empty();
						commentList();
						document.getElementById("content").value = '';	
				}
				

			});//-----ajax

		}//----------doUpdate


		//commentlist do.?이후 부분+출력부분
		function commentList() {//10:이벤트 20:이벤트 후기
			var check = "";
			var url = "${context}/comment/doSelectList.do"
			$.ajax({
						type : "get", //get방식으로 자료를 전달한다
						url : url, //컨트롤러에 있는 list.do로 맵핑하고 게시판 번호도 같이 보낸다.
						data : {
							"seq" : "2",
							"div" : "10"
						},
						success : function(data) { //데이터를 보내는것이 성공했을때 출력되는 메시지

							var commentList = data;//JSON.parse(data);
							var length = commentList.length;
							var cnt=commentList.likeCnt;
							//console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>cnt"+cnt);
							$("#count").empty();
							$("#count").append('<b>' + length + '</b>');
							$("#cnt").append('<b>' +cnt  + '</b>');

							var html = "";

							if (null != commentList && commentList.length > 0) {
								$.each(commentList,function(i, vo) {
													//console.log(vo.commentSeq);
													//console.log(vo.content);
													//console.log(vo.modDt);
													html += '<div name="commentDiv">';
														html += '<p class="my-2">';
															html += '<button class="like" onclick="like('+ vo.commentSeq+ ');" id="like" style="background-color: #ffffff; float: right; border: none;">';
																html += '<i class="fa fa-heart" aria-hidden="true">'+'</i>'
																//html += '<img src="${context}/resources/img/comment/fullheart.png" style="width: 20px;"/>';
																html += '<span>' +"&nbsp"+vo.likeCnt+""+'</span>'
															html += '</button>';
														html += '<strong>'+ vo.regId + ""+ '</strong>';
														html += '</p>';
														html += '<div class="my-3">'+ vo.content+ '</div>';
														html += '<span>';
														html += vo.modDt;
														html += '</span>';
														if(vo.regId=="${sessionScope.user.userId}"){
														html += '<div class="row justify-content-end mb-3">';
															html += '<input type="button" onclick="commentUpdate(this)" class="mr-1 btn btn-primary btn-sm" value="수정" style="float: right">';
															html += '<input type="button" onclick="commentdelete('+ vo.commentSeq+ ');" class="btn btn-primary btn-sm mr-2" value="삭제" id="doDelete" style="float: right">';
														html += '</div>';
														}
													html += '</div>';
												});
								//console.log(html);
								$("#commentList").append(html);
							} else {
								html += "<div class='text-center'><label>등록된 댓글이 없습니다.</label></div>"
								$("#commentList").append(html);
							}
							//$("#commentList").append(html);
						},
						error : function(xhr, status, error) {
							alert("error:" + error);
						}
					});//--ajax

		}//--commentList

//-------

		function commentUpdate(idx) {
 			console.log(idx);

 			var appendDiv = idx.parentNode.parentNode;
 			console.log(appendDiv);

 			var commentDt = idx.parentNode.previousSibling;
 			console.log("date: " + commentDt.textContent);
 			var commentContent = commentDt.previousSibling;
 			console.log("content: " + commentContent.textContent);
 			var commentRegId = commentContent.previousSibling.lastChild;
 			console.log("regId: " + commentRegId.textContent);


			commentDt.textContent = "";
			commentContent.textContent = "";
			commentRegId.textContent = "";

			let inputElement = document.createElement("input");
			let taElement = document.createElement("textarea");
			let inputElement2 = document.createElement("input");

			console.log(inputElement);
			console.log(taElement);
			console.log(inputElement2);

			inputElement.setAttribute("style","text-align: center; width: 150px");
			inputElement.setAttribute("name", "user_id");
			inputElement.setAttribute("type", "text");
			inputElement.setAttribute("class", "form-control");
			inputElement.setAttribute("value", "yeji");
			//${user.userId}
			
			appendDiv.appendChild(inputElement);
			
			

			//var html = "";
			//html += '<input style="text-align: center; width: 150px;" id="user_id" name="user_id" type="text" class="form-control" value="yeji" readonly="readonly" />';
			//html += '<br />';
			//html += '<textarea style="resize: none;" rows="5" cols="80" name="upcontent" id="content" class="form-control" placeholder="내용을 입력해주세요">'+'</textarea>';
			//html += '<br />';
			//html += '<input type="button" class="btn btn-primary btn-sm" value="수정" style="float: right" />'+'<br/>';
			
 			
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
		}//--commentdelete
		function like(commentSeq,regId){
			console.log("======like====== ");
			  var frm_read = $('#frm_read');
			 // var commentSeq = $('#commentSeq', frm_read).val();
			 // var memberSeq = $('#memberSeq', frm_read).val();
			  var url = "${context}/comment/like.do"
		
			  console.log("commentSeq : " + commentSeq );
			  
			  $.ajax({
			    url: url,
			    type: "GET",
			    dataType: "html",
			    data: {"commentSeq" : commentSeq,
					"regId" : "${sessionScope.user.userId}"
				    },
			    success: function(data) {
					var obj = JSON.parse(data);
				     var like_img = '';
					    if(obj.likeCheck == 0){
				        like_img = "${context}/resources/img/comment/heart.png";
				        alert("좋아요 취소");
				      } else {
				        like_img = "${context}/resources/img/comment/fullheart.png";
				        alert("좋아요 성공");
				        //toggleClass(".active-color");
				        $(this).addClass('fa:active-color');
				        
				      }      
				      $('#like_img', frm_read).attr('src', like_img);
				    /*   $('#like_cnt').html(data.like_cnt);
				      $('#like_check').html(data.like_check); */
				  	$("#commentList").empty();
					commentList();
	
			    },
			    error : function(xhr, status, error) {
					alert(meesage.msgContents);
				}
			  });//--ajax
			}//--like

		// 게시글 열리면 자동으로 리스트 홀출할 수 있도록 이벤트 만들어줌
		$(document).ready(function() {
			console.log("document ready");
			commentList();
		})
	</script>
</body>
</html>
