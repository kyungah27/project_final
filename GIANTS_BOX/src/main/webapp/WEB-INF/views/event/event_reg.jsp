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
<c:set var="context" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>event_reg</title>
  </head>
<body>
<div id="wrap">
<!-- 입력 Form -->
<!-- 버튼 originName 첨부이름 -->
		    <form action="${hContext}/event_reg.do" name="event_reg" method="post" class="form-horizontal">
		    	
		    	<!-- 이미지 첨부 -->
		    	<div class="form-group">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">이미지 첨부</label>
				    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				    	<input type="button" class="form-control" name="origin_name" id="origin_name" />
				    </div>
				</div>
				<!-- 이미지 첨부 -->
		    	<!-- 모임명 -->
		    	<div class="form-group">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">모임 이름</label>
				    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				    	<input type="text" class="form-control" name="event_nm" id="event_nm" placeholder="모임 이름" maxlength="50"
				    	disabled="disabled"/>
				    </div>
				</div>	
		    	<!--//모임명  -->
		    	<!--모임 주최자  -->
		    	<div class="form-group">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">호스트</label>
				    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				    	<input type="text" class="form-control" name="user_id" id="user_id" placeholder="호스트" maxlength="20"/>
				    </div>
				</div>	
		    	<!--//모임 주최자  -->
		    	<!--모임 정원  -->
		    	<div class="form-group">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">모임 정원</label>
				    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				    	<input type="text" class="form-control" name="capacity" id="capacity" placeholder="모임 정원" maxlength="10"/>
				    </div>
				</div>	
		    	<!--//모임 정원  -->
		    	<!--주최일  -->
		    	<div class="form-group">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">주최일</label>
				    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				    	<input type="text" class="form-control" name="target_dt" id="target_dt" placeholder="주최일" />
				    </div>
				</div>	
		    	<!--//주최일  -->	
		    		
		    	<!--시작일  -->
		    	<div class="form-group">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">모집 시작일</label>
				    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				    	<input type="text" class="form-control" name="start_dt" id="start_dt" placeholder="모집 시작일" />
				    </div>
				</div>	
		    	<!--//시작일  -->
		    	<!--종료일  -->
		    	<div class="form-group">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">모집 종료일</label>
				    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				    	<input type="text" class="form-control" name="end_dt" id="end_dt" placeholder="모집 종료일" />
				    </div>
				</div>	
		    	<!--//종료일  -->
		    	<!--장소  -->
		    	<div class="form-group">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">장소</label>
				    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				    	<input type="text" class="form-control" name="location" id="location" placeholder="장소" maxlength="100"/>
				    </div>
				</div>	
		    	<!--//장소  -->	
		    	<!--모임 소개  -->
		    	<div class="form-group">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2">모임 소개</label>
				    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				    	<input type="text" class="form-control" name="content" id="content" placeholder="모임 소개" />
				    </div>
				</div>	
		    	<!--//모임 소개  -->			    			    			    	
		    	
		    	<input type="button" class="btn btn-default btn-sm"/>
		    			    		    		    			     	
		    </form>
		    <!--// 입력 Form -->
</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>   
    <script type="text/javascript">

    $.ajax({
        type:"GET",
        url:"${hContext}/event/doInsert.do",
        dataType:"html",
        data:{
       }, 
     success: function(data){
       console.log("data:"+data);    
       
       var parseData = JSON.parse(data);
     
       	          	  	
       
     },
     complete:function(data){
      
     },
     error:function(xhr,status,error){
         alert("error:"+error);
     }
    }); 
//--ajax  	
    
	</script>
  </body>
</html>