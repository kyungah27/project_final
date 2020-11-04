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
    <title>join_list</title>
  </head>
<body>
<div id="wrap">
	   <div class="table-responsive">
	    <!-- table -->
		<table border="1" id="joinTable" class="table table-striped table-bordered table-hover table-condensed">
			<thead class="bg-primary">  
				<th class="text-center col-lg-2 col-md-2  col-xs-2">EventSeq(hidden할거)</th>
				<th class="text-center col-lg-2 col-md-2  col-xs-2">memberSeq(hidden할거)</th>
				<th class="text-center col-lg-2 col-md-2  col-xs-2">이름</th>
				<th class="text-center col-lg-2 col-md-2  col-xs-2">아이디</th>
				<th class="text-center col-lg-2 col-md-2  col-xs-2">권한</th>
			</thead>
		    <tbody id = "joinTablebody"></tbody>
		
		</table>
		<!--// table -->
	</div>
</div>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>   
    <script type="text/javascript">
	    //모든 컨트롤(element)가 로딩이 완료되면.
		$(document).ready(function(){   
			console.log("document ready"); 

			  $.ajax({
				    type:"GET",
				    url:"${context}/join/doSelectList.do",
				    dataType:"html", 
				    data:{"eventSeq":1001	         
				    },
				    success:function(data){ //성공
				       console.log("data="+data);
				       var obj = JSON.parse(data);
			          	  $("#joinTablebody").empty();
		                  var html = "";
		                  //Data가 없으면     
			              if(obj.length>0){
			                  <!-- 문자: 왼쪽, 숫자: 오른쪽, 같은면: 가운데 --> 
							  $.each(obj, function(i, value) {  
								  if(value.priority ==1){
									html += "<tr bgcolor=red>";
								}else{  
									html += "<tr>";
								}		
								  html += "<td class='text-center'>"+value.eventSeq+"</td>";
								  html += "<td class='text-center'>"+value.memberSeq+"</td>";
								  html += "<td class='text-center'>"+value.name+"</td>";
								  html += "<td class='text-center'>"+value.memberSeq+"</td>";
								  html += "<td class='text-center'>"+value.priority+"</td>";
								  html += "</tr>";
							  });		  
					      }else{
					    	  html += "<tr>";
							  html += "<td class='text-center' colspan='99'>이벤트에 참여한 사람이 없습니다..</td>";
							  html += "</tr>";
						  }
			              $("#joinTablebody").append(html);	
				    },
				    error:function(xhr,status,error){
				     alert("error:"+error);
				    },
				    complete:function(data){
				    
				    }   
				  
			});//--ajax

		});//document ready   


		</script>
  </body>
</html>