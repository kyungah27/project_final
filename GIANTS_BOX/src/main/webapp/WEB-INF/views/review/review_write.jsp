<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath }" />



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Review Write- Giants Box</title>

<!-- favicon -->
<link rel=" shortcut icon" href="${context}/resources/img/favicon.ico">
<link rel="icon" href="${context}/resources/img/favicon.ico">
<!-- //favicon -->

<link rel="stylesheet"
	href="${context}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
<link rel="stylesheet"
	href="${context}/resources/fonts/font-awesome.min.css">
<link rel="stylesheet"
	href="${context}/resources/fonts/simple-line-icons.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
<link rel="stylesheet" href="${context}/resources/css/styles.min.css"
	rel="stylesheet" type="text/css">

<!--calendar-->
<link href="${context}/resources/css/datepicker.min.css"
	rel="stylesheet" type="text/css">
<!--//calendar-->

<!-- css/불러오는 jsp -->
<!-- //css/불러오는 jsp -->


</head>

<body>

	<main class="page review-page" style="padding-top: 65px;">
		<section class="clean-block clean-form">
			<div class="container">
				<!-- 게시판 작성  -->
				

				<!-- //게시판 작성  -->

			</div>
		</section>
	</main>

</body>



<!-- 자바스크립트 자리 -->
<script type="text/javascript">
//모든 컨트롤(element)가 로딩이 완료되면.
$(document).ready(function(){   
	console.log("document ready");   		
	
});//document ready    


$("#reviewList").on("click", function() {
	moveToListView();
});


	
$("#insertBtn").on("click", function() {
	console.log("insertBtn");

	var writer = $("#writer").val();
	console.log("writer:"+writer);
	if(null == writer || writer.trim().length==0){
		$("#writer").focus();
		alert("등록자를 입력하세요.");
		return;
	}
	
	var title = $("#title").val();
	console.log("title:"+title);
	if(null == title || title.trim().length==0){
		$("#title").focus();
		alert("제목을 입력하세요.");
		return;
	}

	
				
	var context = $("#context").val();
	console.log("context:"+context);
	if(null == context || context.trim().length==0){
		$("#context").focus();
		alert("내용을 입력하세요.");
		return;
	}			

	var category = $("#category").val();
	console.log("category:"+category);
	if(null == category || category.trim().length==0){
		$("#category").focus();
		alert("[영화/후기]를 입력하세요.");
		return;
	}
	
	if(false==confirm("등록 하시겠습니까?"))return;

	$.ajax({
	    type:"POST",
	    url:"${hContext}/review/doInsert.do",
	    dataType:"html", 
	    data:{
	    	  "div" :$("#div").val(),
	    	  "writer":$("#writer").val(),
	    	  "title":$("#title").val(),
	    	  "context":$("#context").val(),
	    	  "category":$("#category").val()   
	    },  
	    success:function(data){ //성공
	       //console.log("data="+data);
	       //alert("data:"+data);
	       
	       //json 분리해서 변수
	       var jsonObj = JSON.parse(data);
	       console.log("msgId="+jsonObj.msgId);
	       console.log("msgContents="+jsonObj.msgContents);
	    
	       if(null !=jsonObj && jsonObj.msgId=="1"){
	    	   alert(jsonObj.msgContents);
	    	   //review_list.jsp로 이동
	    	   moveToListView();
	       }
	    },
	    error:function(xhr,status,error){
	     alert("error:"+error);
	    },
	    complete:function(data){
	    
	    }   
	  
});//--ajax


	
});



//목록 Event감지
$("#move_list").on("click",function(){
	console.log("move_list");
	//window.location.href="/EJDBC/board/board.do?work_div=doSelectList";
	moveToListView();
});


//목록화면으로 이동
<!--뭔소린지..div 바꾸기!--> 
function moveToListView(){
	window.location.href="${hContext}/review/doSelectList.do?div="+$("#div").val();
}




//jquery event감지:id
$("#insert_btn").on('click',function(){
	console.log("#insert_btn");

	var writer = $("#writer").val();
	console.log("writer:"+writer);
	if(null == writer || writer.trim().length==0){
		$("#writer").focus();
		alert("등록자를 입력하세요.");
		return;
	}

	
	var title = $("#title").val();
	console.log("title:"+title);
	if(null == title || title.trim().length==0){
		$("#title").focus();
		alert("제목을 입력하세요.");
		return;
	}
	
	
	
	var context = $("#context").val();
	console.log("context:"+context);
	if(null == context || context.trim().length==0){
		$("#context").focus();
		alert("내용을 입력하세요.");
		return;
	}	

	var category = $("#category").val();
	console.log("category:"+category);
	if(null == category || category.trim().length==0){
		$("#category").focus();
		alert("[영화/카테고리]를 입력하세요.");
		return;
	}				
	
	//confirm : 확인
	if( false==confirm("저장 하시겠습니까?"))return;
	
	
	//fiddler : web debuger(오후)
	//ajax->BoardController.java 
	//return json   
	$.ajax({
		    type:"POST",
		    url:"/GIANTS_BOX/review/review_list.do",
		    dataType:"html", 
		    data:{"work_div":"doInsert",
		    	  "div" :$("#div").val(),
		    	  "writer":$("#writer").val(),
		          "title":$("#title").val(),
		          "context":$("#context").val(),
		          "category":$("#category").val()
		    },
		    success:function(data){ //성공
		       //console.log("data="+data);
		       //alert("data:"+data);
		       
		       // - =jsonMsg={"msgId":"1","msgContents":"등록 되었습니다.","num":0,"totalCnt":0}
		       
		       //json 분리해서 변수
		       var jsonObj = JSON.parse(data);
		       console.log("msgId="+jsonObj.msgId);
		       console.log("msgContents="+jsonObj.msgContents);
		    
		       if(null !=jsonObj && jsonObj.msgId=="1"){
		    	   alert(jsonObj.msgContents);
		    	   //board_list.jsp로 이동 
		    	   //window.location.href="/EJDBC/board/board.do?work_div=doSelectList";
		    	   moveToListView();
		       }
		    },
		    error:function(xhr,status,error){
		     alert("error:"+error);
		    },
		    complete:function(data){
		    
		    }   
		  
	});//--ajax


	
});//insert_btn  

function doInsert_javascript() {
	//console.log("doInsert() call");
	//alert("doInsert");
	//var frm = document.save_frm;
	//alert("frm.div.value:"+frm.div.value);
	
	//form에 컨트롤에 값 가지고 오기
	/*
		1. 컨트롤 이름으로 가지고 오기
		   document.컨트롤이름.value
		2. 컨트롤의 id로 가지고 오기
		   document.getElementById('컨트롤id').value
	*/
	var frm = document.save_frm;
	
	console.log("1.컨트롤 이름으로 가지고 오기"+document.save_frm.div.value);
	console.log("2.컨트롤의 id로 가지고"+document.getElementById('div').value);
	
	var title = frm.title.value;
	console.log("before title:"+title);

	//등록자ID
	var writer = frm.writer.value;
	if(writer==""){
		alert("등록자를 입력하세요.");
		frm.writer.focus();
		return;
	}
	
	//제목
	if(title==""){
		alert("제목을 입력하세요.");
		frm.title.focus();
		return;
	}
	
	
	
	//내용
	var context = frm.context.value;
	if(context==""){
		alert("내용을 입력하세요.");
		frm.context.focus();
		return;
	}  

	//카테고리
	var category = frm.category.value;
	if(category==""){
		alert("[영화/후기]를 입력하세요.");
		frm.category.focus();
		return;
	}      
	
	//confirm : 확인
	if( false==confirm("저장 하시겠습니까?"))return;
	
	
	//작업구분 : doInsert
	frm.work_div.value="doInsert";   
	
	//브라우저 to server로
	frm.action = "/GIANTS_BOX/review/review_list.do"
	frm.submit();

}
</script>

</html>
