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

	
    
</script>
<%@ include file="cmn/footer2.jsp" %>
