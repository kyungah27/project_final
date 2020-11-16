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


		
        console.log("#checkbox");   
        var u_id = $("#id").val().trim();
        //check되면 : 쿠키에 ID저장
        if($("#checkbox").is(":checked")){
            console.log("sss");
           if(u_id !=null){
              setCookie("id",u_id,7);
           }
        }else{//그렇치 않으면 쿠키에 ID삭제
           if(u_id !=null){
             deleteCookie("id");
           }
        }
		
		  $.ajax({
			    type:"GET",
			    url:"${context}/loginn.do",
			    dataType:"html", 
			    data:{"userId":userId,
				      "password":password
			    },
			    success:function(data){ //성공

			    	var obj = JSON.parse(data);

				    if(null != obj && obj.msgId=="1"){
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

	//cookie로 ID저장



     
    //id cookie에 저장
    //cookieValue:j124_146;expires=Mon, 05 Oct 2020 05:39:49 GMT
     function setCookie(cookie_name,value,expire_day){
        //cookie생성
        //Get and set the cookies associated with the current document.
        var expire_date = new Date();//현제 날짜
        console.log("expire_date.getDate():"+expire_date.getDate());
        expire_date.setDate(expire_date.getDate() +expire_day);
        var cookieValue = this.escape(value) + ((expire_day==null)?"":";expires="+expire_date.toUTCString())
        //j124_146;expires=Mon, 05 Oct 2020 05:39:49 GMT
        console.log("cookieValue:"+cookieValue);
        console.log(cookie_name +"="+value);
        document.cookie = cookie_name +"="+cookieValue;
 
     }
 	$(document).ready(function(){ 
	    var userId = getCookie("id");
	    console.log(userId);
	    $("#id").val(userId);
	    
/* 	    
	    if($("#userId").val() != "")
	      $("#saveId").attr("checked", true); */

 	 }); 
    

     
    //cookie정보 가지고 오기
     function getCookie(cookie_name){
        cookie_name = cookie_name +"=";
        //j124_146;expires=Mon, 05 Oct 2020 05:39:49 GMT
        var cookie_data = document.cookie;
        console.log("cookie_data="+cookie_data);
        var start = cookie_data.indexOf(cookie_name);
        console.log("start="+start);
        var cookie_value = "";
        if(start !=-1){
           start += cookie_name.length;
           var end = cookie_data.indexOf(";",start);
           
           if(end ==-1)end = cookie_data.length;
           
           cookie_value = cookie_data.substring(start,end);
        }
        
        return unescape( cookie_value );
     }
    
   function deleteCookie(cookie_name){
      var expire_date = new Date();//현재 날짜
      expire_date.setDate(expire_date.getDate()-1);//현재 날짜 -1(전날)
      console.log("expire_date.getDate():"+expire_date.getDate());
      document.cookie  = cookie_name+"="+";expires="+expire_date.toUTCString();
   }
    
</script>
<%@ include file="cmn/footer2.jsp" %>
