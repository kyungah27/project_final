<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<% response.setHeader("Pragma", "no-cache"); 
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Cache-Control", "no-store"); 
response.setDateHeader("Expires", 0L); %>

<main class="page registration-page" style="padding-top: 65px;">
	<section class="clean-block clean-form dark">
		<div class="container">
			<div class="block-heading">
				<h2 class="text-primary">My account</h2>
			</div>
			
			<form onsubmit="return false;">
				<div class="form-group">
					<label for="name" id ="id_label">Id</label><input class="form-control item"
						type="text" style="background-color:#E6E6E6" id="id" value="${sessionScope.user.userId}" readonly >
				</div>
				<div class="form-group">
					<label for="name" id ="name_label">Name</label><input class="form-control item"
						type="text" id="name" value="${sessionScope.user.name}">
				</div>
				<div class="form-group" >
					<label for="password"  id ="password_label">Password</label><input
						class="form-control item" type="password" id="password" placeholder='영문자,숫자,특수문자를 조합해 8자리 이상 작성'>
				</div>
				<div class="form-group" >
					<label for="password"  id ="newPassword_label">New Password<br/><small>(영문자,숫자,특수문자를 조합해 8자리 이상 작성)</small></label>
					<input
						class="form-control item" type="password" id="newPassword" placeholder='새비밀번호'>
						<input
						class="form-control item" type="password" id="newPassword1" placeholder='새비밀번호확인'>
				</div>
					<div class="form-group">
						<label for="email" id ="email_label">Email</label>
						<input class="form-control item" type="email" id="email" value="${sessionScope.user.email}">
					</div>
					
					<div class="form-group">
						<label for="phone" id ="phone_label">Phone<br/><small>(ex. -없이 번호만 입력해주세요)</small></label><input class="form-control item"
							type="text" id="phone" value="${sessionScope.user.cellPhone}">
					</div>
					<div class="form-group">
						<label for="birthday" id ="birthday_label">Birthday(ex.970123)</label><input
							class="form-control item" type="text" id="birthday" style="background-color:#E6E6E6" readonly value="${sessionScope.user.birthday}" >
					</div>
				    <div class="form-group">
						<label for="genre" id ="genre_label" >좋아하는 영화장르 선택</label></br>
						<label for="genre1"><input type="radio" id="genre1" name="genre" value="드라마">드라마</label>
   						<label for="genre2"><input type="radio" id="genre2" name="genre" value="액션">액션</label>
   						<label for="genre3"><input type="radio" id="genre3" name="genre" value="멜로">멜로</label>
   						<label for="genre4"><input type="radio" id="genre4" name="genre" value="공포(호러)">공포(호러)</label>
   						<label for="genre5"><input type="radio" id="genre5" name="genre" value="범죄">범죄</label></br>
   						<label for="genre6"><input type="radio" id="genre6" name="genre" value="코메디">코메디</label>
   						<label for="genre7"><input type="radio" id="genre7" name="genre" value="가족">가족</label>
   						<label for="genre8"><input type="radio" id="genre8" name="genre" value="SF">SF</label>
   						<label for="genre9"><input type="radio" id="genre9" name="genre" value="판타지">판타지</label>
   						<label for="genre10"><input type="radio" id="genre10" name="genre" value="">기타</label>	    	    	 		  		  		  		  		  		 	 		 	 	
			    	</div>
				<div class="form-group row">
					<div class="col-lg-6 mb-lg-0 mb-3">
						<button class="btn btn-primary btn-block" type="button"  id="doUpdate">회원정보수정</button>
					</div>
					<div class="col-lg-6">
						<button class="btn btn-primary btn-block" type="button"  id="doDelete">회원탈퇴</button>
					</div>
				</div>
			</form>
			
		</div>
	</section>
</main>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
    

    //회원정보수정
	$("#doUpdate").on("click", function() {	 
			
		var name = $("#name").val();
		name = name.trim();
		if (null == name || name.length == 0) {
			$("#name").focus();
			alert("이름을 입력 하세요.");//{0} 입력하세요. 
			$("#name_label").css("color","red");
			return;
		}

		var password = $("#password").val();
		password = password.trim();
		if (null == password || password.length == 0) {
			alert("비밀번호를 입력 하세요.");//{0} 입력하세요.

			$("#password").focus();
			return;
		}
			
		if("${sessionScope.user.password}"!=(password)){
			alert("비밀번호를 확인 하세요.");
			$("#password").focus();
			return;
		}

		var newPassword = $("#newPassword").val();
		var newPassword1 = $("#newPassword1").val();
		passwordConf = newPassword.trim();
		passwordConf = newPassword1.trim();
		if (newPassword != newPassword1) {
			$("#newPassword").focus();
			alert("새비밀번호를 확인 하세요.");//{0} 입력하세요.
			$("#newPassword_label").css("color","red");
			return;
		}


		var email = $("#email").val();
		email = email.trim();
		if (null == email || email.length == 0) {
			$("#email").focus();
			alert("이메일을 입력 하세요.");//{0} 입력하세요.
			$("#email_label").css("color","red"); 
			return;
		}

		var phone = $("#phone").val();
		phone = phone.trim();
		if (null == phone || phone.length == 0) {
			$("#phone").focus();
			alert("폰 번호를 입력 하세요.");//{0} 입력하세요. 
			$("#phone_label").css("color","red");
			return;
		}

		var birthday = $("#birthday").val();
		birthday = birthday.trim();
		if (null == birthday || birthday.length == 0) {
			$("#birthday").focus();
			alert("생년월일을 입력 하세요.");//{0} 입력하세요.
			$("#birthday_label").css("color","red"); 
			return;
		}
		      
		
		$.ajax({
			type : "POST",
			url : "${context}/updateUser.do",
			dataType : "html",
			data : {
				
				"seq":${sessionScope.user.seq},
				"userId":$("#id").val(),
				"name":$("#name").val(),
				"password":$("#newPassword").val(),
				"cellPhone":$("#phone").val(),
				"birthday":$("#birthday").val(),
				"email":$("#email").val(),
				"auth":1,
				"genre"  : $('[name=genre]:checked').val()
				

			},
			success : function(data) { //성공

				var obj = JSON.parse(data);
				//alert(obj.msgContents);
				alert(obj.msgContents);
				if(obj.msgId == 1){
				}else{
					$("#newPassword_label").css("color","red");
				}
				
				
			},
			error : function(xhr, status, error) {
				alert("error:" + error);
			},                    
			complete : function(data) {
			}

		});//--ajax

	});


	$(document).ready(function(){
		var step;
		for (step = 1; step <= 10; step++) {
			if($("#genre"+step).val() == "${sessionScope.user.genre}"){
				console.log($("#genre"+step).val());
				$("#genre"+step).prop("checked", true);
			}
		  console.log('Walking east one step');
		}

		
	});

	
	
    
	//회원정보삭제
	    $("#doDelete").on("click", function() {
	    	
		if (confirm("정말 삭제하시겠습니까??") == false) return false;
		
		$.ajax({
			type : "POST",
			url : "${context}/deleteUser.do",
			dataType : "html",
			data : {
				
				"seq":${sessionScope.user.seq}

			},
			success : function(data) { //성공

				var obj = JSON.parse(data);
				//alert(obj.msgContents);
				alert(obj.msgContents);
				window.location.href="${context}/login.do";
					
			},
			error : function(xhr, status, error) {
				alert("error:" + error);
			},                    
			complete : function(data) {
			}

		});//--ajax

	});

</script>

<%@ include file="cmn/footer1.jsp" %>
<!-- 자바스크립트 자리 -->
<%@ include file="cmn/footer2.jsp" %>