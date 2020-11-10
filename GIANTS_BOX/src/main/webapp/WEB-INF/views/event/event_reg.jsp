<%--
/**
	Class Name:
	Description:
	Modification information
	
	수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2020. 9. 18        최초작성 
    
    author eclass 개발팀
    since 2020.05
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="hContext" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>GIANTS BOX</title>
    <link rel="shortcut icon" type="image/x-icon" href="${hContext}/resources/img/favicon.ico" > 
    <!-- 부트스트랩 -->
    <link href="${hContext}/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link href="/EJDBC/css/layout.css" rel="stylesheet"> -->

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->

  </head>
<body>
<div id="wrap">
<%-- 	<%@include  file="/cmn/inc/header.jsp" %> --%>
	<section>
		<!-- container -->
		<div class="container">
			<!-- 제목 -->
			<div class="page-header">
				<h2>새로운 모임 개설</h2>
			</div>
			<!--// 제목 -->

            <div class="container">
                <div class="flex-item-center">
                <form class="form-horizontal" action="" name="event_reg" method="post" > 
                    <div class="form-group"><input class="form-control item" type="button" id="originName" value="이미지 첨부"></div>
                    <div class="form-group"><label for="event_nm">모임명</label><input class="form-control item" type="text" id="event_nm"></div>
                    <div class="form-group"><label for="user_id">호스트</label><input class="form-control item" type="text" id="user_id"></div>
                    <div class="form-group"><label for="capacity">정원</label><input class="form-control item" type="text" id="capacity">
                    <div class="form-group"><label for="target_dt">일정</label><input class="form-control item" type="text" id="target_dt"></div>
                    <div class="form-group"><label for="start_dt">모집 시작일</label><input class="form-control item" type="text" id="start_dt"></div>
					<div class="form-group"><label for="end_dt">모집 종료일</label><input class="form-control item" type="text" id="end_dt"></div>
					<div class="form-group"><label for="location">장소</label><input class="form-control item" type="text" id="location"></div>
					<div class="form-group"><label for="content">소개</label><input class="form-control item" type="text" id="content"></div>
                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
                    <input type="button" class="btn btn-primary btn-block btn-sm" value="등록하기" id="doInsert"/></div>
				</div>	
				</form>
    		</div>
   
    		</div>
    	</div> 
    	<!--// div container -->
    </section>
</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>   
    
     <script src="${hContext}/resources/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">

  	//모든 컨트롤(element)가 로딩이 완료되면.
	$(document).ready(function(){   
		console.log("document ready");   		
		
	});//document ready 

    
	//--이벤트 등록하기
	$("#doInsert").on("click", function() {
		console.log("doInsert");
		
		//모임명 체크
		var event_nm = $("#event_nm").val();
		console.log("event_nm:"+event_nm);
		if(null == event_nm || event_nm.trim().length==0){
			$("#event_nm").focus();
			alert("모임명을 입력해주세요.");
			return ;
		}

		//정원 체크
		var capacity = $("#capacity").val();
		console.log("capacity:"+capacity);
		if(null == capacity || capacity.trim().length==0){
			$("#capacity").focus();
			alert("정원을 입력해주세요.");
			return ;
		}			

			

		//주최일 체크
		var target_dt = $("#target_dt").val();
		console.log("target_dt:"+target_dt);
		if(null == target_dt || target_dt.trim().length==0){
			$("#target_dt").focus();
			alert("일정을 입력해주세요.");
			return ;
		}


		//모임 소개
		var content = $("#content").val();
		console.log("content:"+content);
		if(null == content || content.trim().length==0){
			$("#content").focus();
			alert("소개를 작성해주세요.");
			return ;
		}
														
		if(confirm("모임을 등록하시겠습니까?") ==false)return;

			//ajax
	        $.ajax({
	           type:"POST",
	           url:"${hContext}/event/doInsert.do",
	           dataType:"html",
	           data:{
	           "event_nm":$("#event_nm").val(),
	           "user_id":$("#user_id").val(),
	           "capacity":$("#capacity").val(),
	           "target_dt":$("#target_dt").val(),
	           "start_dt":$("#start_dt").val(),
	           "end_dt":$("#end_dt").val(),
	           "location":$("#location").val(),
	           "content":$("#content").val()
	          }, 
	        success: function(data){

	        	var jsonObj = JSON.parse(data);
			       console.log("msgId="+jsonObj.msgId);
			       console.log("msgContents="+jsonObj.msgContents);
	          if(null != jsonObj && jsonObj.msgId=="1"){
	            alert(jsonObj.msgContents);
	            //다시조회
	            moveToListView;
	          }
	        },
	        
	        error:function(xhr,status,error){
	            alert("error:"+error);
	        },
			complete:function(data){     

		     }
	        
	       }); //--ajax 	
        
	})//doInsert
    
	</script>
  </body>
</html>