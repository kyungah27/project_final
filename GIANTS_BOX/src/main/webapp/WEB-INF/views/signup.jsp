<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp"%>


<main class="page registration-page" style="padding-top: 65px;">
	<section class="clean-block clean-form dark">
		<div class="container">
			<div class="block-heading">
				<h2 class="text-primary">Sign up</h2>
			</div>
			<form>
				<div class="form-group">
					<label for="id">Id</label><input class="form-control item"
						type="text" id="id">
				</div>
				<div class="form-group">
					<label for="name">Name</label><input class="form-control item"
						type="text" id="name">
				</div>
				<div class="form-group">
					<label for="password">Password(대문자,소문자,특수문자,숫자를 조합해 8자리 이상 작성해주세요)</label><input
						class="form-control item" type="password" id="password">
				</div>
				<div class="form-group">
					<label for="email">Email</label><input class="form-control item"
						type="email" id="email">
					<div class="form-group">(ex. -없이 번호만 입력해주세요)
						<label for="phone">Phone</label><input class="form-control item"
							type="text" id="phone">
					</div>
					<div class="form-group">
						<label for="birthday">Birthday(ex.970123)</label><input
							class="form-control item" type="text" id="birthday">
					</div>
				</div>
				<button class="btn btn-primary btn-block" type="submit" id="doReg">Sign
					Up</button>
			</form>
		</div>
	</section>
</main>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
	$("#doReg").on("click", function() {
		alert("doInsert");

		var id = $("#id").val();
		id = id.trim();

		if (null == id || id.length == 0) {
			$("#id").focus();
			alert("아이디를 입력 하세요.");//{0} 입력하세요. 
			return;
		}

		var name = $("#name").val();
		name = name.trim();
		if (null == name || name.length == 0) {
			$("#name").focus();
			alert("이름을 입력 하세요.");//{0} 입력하세요. 
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
			return;
		}

		var phone = $("#phone").val();
		phone = phone.trim();
		if (null == phone || phone.length == 0) {
			$("#phone").focus();
			alert("폰 번호를 입력 하세요.");//{0} 입력하세요. 
			return;
		}

		var birthday = $("#birthday").val();
		birthday = birthday.trim();
		if (null == birthday || birthday.length == 0) {
			$("#birthday").focus();
			alert("생년월일을 입력 하세요.");//{0} 입력하세요. 
			return;
		}

		$.ajax({
			type : "POST",
			url : "${context}/regUser.do",
			dataType : "html",
			data : {
				"userId" : $("#id").val(),
				"name" : $("#name").val(),
				"password" : $("#password").val(),
				"email" : $("#email").val(),
				"cellPhone" : $("#phone").val(),
				"birthday" : $("#birthday").val()

			},
			success : function(data) { //성공

				var obj = JSON.parse(data);
				//alert(obj.msgContents);
				alert(obj.msgId);
				$("#msgContents").val(obj.msgContents);
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

<%@ include file="cmn/footer.jsp"%>