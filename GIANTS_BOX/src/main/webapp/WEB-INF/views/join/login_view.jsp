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
    <title>login_view</title>
  </head>
<body>
<div id="wrap">

<input type="text" class="btn btn-default btn-sm" id="id">id</input>
<input type="text" class="btn btn-default btn-sm" id="pw">pw</input>


<button type="button" class="btn btn-default btn-sm" id="doLogin">로그인</button>

<input type="text" class="btn btn-default btn-sm" id="msgContents">msgContents</input>


</div>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>   
    <script type="text/javascript">
    $("#doLogin").on("click", function() {
		alert("doInsert");

		  $.ajax({
			    type:"POST",
			    url:"${context}/login.do",
			    dataType:"html", 
			    data:{"userId":$("#id").val(),
				      "password":$("#pw").val()         
			    },
			    success:function(data){ //성공
			    
			    	var obj = JSON.parse(data);
			    	alert(obj.msgContents);
			    	$("#msgContents").val(obj.msgContents);
			    },
			    error:function(xhr,status,error){
			     alert("error:"+error);
			    },
			    complete:function(data){
			    
			    }   
			  
		});//--ajax

		

        });


    
		</script>
  </body>
</html>