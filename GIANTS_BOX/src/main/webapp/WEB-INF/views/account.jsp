<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp"%>


<main class="page registration-page" style="padding-top: 65px;">
	<section class="clean-block clean-form dark">
		<div class="container">
			<div class="block-heading">
				<h2 class="text-primary">My account</h2>
			</div>
			<form onsubmit="return false;">
				<div class="form-group">
					<label for="name" id ="id_label">Id</label><input class="form-control item"
						type="text" style="background-color:#E6E6E6" id="id" readonly >
						
				</div>
				
				
				<div class="form-group">
					<label for="name" id ="name_label">Name</label><input class="form-control item"
						type="text" id="name">
				</div>
				<div class="form-group" >
					<label for="password"  id ="password_label">Password(대문자,소문자,특수문자,숫자를 조합해 8자리 이상 작성해주세요)</label><input
						class="form-control item" type="password" id="password">
				</div>
				<div class="form-group">
					<label for="email" id ="email_label">Email</label><input class="form-control item"
						type="email" id="email">
					<div class="form-group">
						<label for="phone" id ="phone_label">Phone(ex. -없이 번호만 입력해주세요)</label><input class="form-control item"
							type="text" id="phone">
					</div>
					<div class="form-group">
						<label for="birthday" id ="birthday_label">Birthday(ex.970123)</label><input
							class="form-control item" type="text" id="birthday" style="background-color:#E6E6E6" readonly >
					</div>
				</div>
				<button class="btn btn-primary btn-block"  id="doUpdate">회원정보수정</button>
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
			$("#password").focus();
			alert("비밀번호를 입력 하세요.");//{0} 입력하세요.
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
				"userId":${sessionScope.user}
			},
			success : function(data) { //성공

				var obj = JSON.parse(data);
				//alert(obj.msgContents);
				alert(obj.msgContents);
				if(obj.msgId == 1){
				}else{
					$("#password_label").css("color","red");
				}
				
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