<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>

    <main class="page login-page" style="padding-top: 65px;">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-primary">Log In</h2>
                </div>
                <form>
                    <div class="form-group">
	                    <label for="email">ID</label>
                    	<input class="form-control item" type="text" id="id" />
                    </div>
                    <div class="form-group">
                    	<label for="password">Password</label>
                    	<input class="form-control" type="password" id="password" />
                    </div>
                    <div class="form-group">
                        <div class="form-check">
                        	<input class="form-check-input" type="checkbox" id="checkbox">
                        	<label class="form-check-label" for="checkbox">Remember me</label>
                        </div>
                    </div>
                    <button class="btn btn-primary btn-block" type="button" id="doLogin">Log In</button>
                </form>
            </div>
        </section>
    </main>
    
    
<%@ include file="cmn/footer1.jsp" %>
<!-- 자바스크립트 자리 -->
<script type="text/javascript">
    $("#doLogin").on("click", function() {
		
		let userId = $("#id").val();			
		let password = $("#password").val();
		console.log("userId" + userId);			
	
		  $.ajax({
			    type:"GET",
			    url:"${context}/loginn.do",
			    dataType:"html", 
			    data:{"userId":userId,
				      "password":password
			    },
			    success:function(data){ //성공

			    	var obj = JSON.parse(data);

				    if(null != obj && obj.msgId==="1"){
				    	console.log("success");
		                alert(obj.msgContents);
				    	moveToMain();
		                
					} else{
		                alert(obj.msgId+"|"+obj.msgContents);
		            }

			    	
			    },
			    error:function(xhr,status,error){
			     alert("error:"+error);
			    },
			    complete:function(data){
			    	
			    
			    }   
			  
		});//--ajax

     });



	function moveToMain(){
		console.log("moveToMain()");
		window.location.href = "${context}/main.do";
	}

	$(document).ready(function(){
	    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
	    var userInputId = getCookie("userInputId");
	    $("input[name='id']").val(id); 
	     
	    if($("input[name='id']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
	        $("#checkbox").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
	    }
	     
	    $("#checkbox").change(function(){ // 체크박스에 변화가 있다면,
	        if($("#checkbox").is(":checked")){ // ID 저장하기 체크했을 때,
	            var userInputId = $("input[name='id']").val();
	            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
	        }else{ // ID 저장하기 체크 해제 시,
	            deleteCookie("userInputId");
	        }
	    });
	     
	    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
	    $("input[name='id']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
	        if($("#checkbox").is(":checked")){ // ID 저장하기를 체크한 상태라면,
	            var userInputId = $("input[name='id']").val();
	            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
	        }
	    });
	});
	 
	function setCookie(cookieName, value, exdays){
	    var exdate = new Date();
	    exdate.setDate(exdate.getDate() + exdays);
	    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
	    document.cookie = cookieName + "=" + cookieValue;
	}
	 
	function deleteCookie(cookieName){
	    var expireDate = new Date();
	    expireDate.setDate(expireDate.getDate() - 1);
	    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
	}
	 
	function getCookie(cookieName) {
	    cookieName = cookieName + '=';
	    var cookieData = document.cookie;
	    var start = cookieData.indexOf(cookieName);
	    var cookieValue = '';
	    if(start != -1){
	        start += cookieName.length;
	        var end = cookieData.indexOf(';', start);
	        if(end == -1)end = cookieData.length;
	        cookieValue = cookieData.substring(start, end);
	    }
	    return unescape(cookieValue);
	}
    
</script>
<%@ include file="cmn/footer2.jsp" %>
