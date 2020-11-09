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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${context}/resources/css/bootstrap.min.css" rel="stylesheet">
<title>join_list</title>
</head>
<body>
	<div class="container">
		<div id="wrap">
			<input type="text" name="current_mseq" id="current_mseq"
				value="히든으로 바꿀거 cmseq" /> <input type="text" name="current_eseq"
				id="current_eseq" value="히든으로 바꿀거 ceseq" /> <input type="text"
				name="selected_mseq" id="selected_mseq" value="히든으로 바꿀거 smseq" /> <input
				type="text" name="selected_eseq" id="selected_eseq"
				value="히든으로 바꿀거 seseq" />
			<div class="table-responsive" style=" verflow:scroll;  height:200px;" >
				<!-- 현재 이벤트 구성원 -->
				<table class="table table-bordered" id="joinToggleTable">
	
				</table>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript">



	$("#joinToggleTable").on("click","span" ,function(){
	  var obj = $(this);
	  if(obj.hasClass("glyphicon glyphicon-plus plusIcon")){
		  obj.hide();
		  obj.next().show();
		  obj.parent().parent().next().show();
		}
		else{
		  obj.hide();
		  obj.prev().show();
		  obj.parent().parent().next().hide(); 
		}
	});


	

	
	    //모든 컨트롤(element)가 로딩이 완료되면
		$(document).ready(function(){   
			console.log("document ready"); 
			//이벤트 리스트 뽑기 
			doSelectList(1001);

			// 추방 차단 버튼 이벤트 
	
			 $("#ban_btn1").on("click", function(e) {
				 alert($(this).val());

				 });		
			 $(document).on("click","button[name=ban_btn]",function(){
					var memberSeq = $(this).val();
					KickOrBan(2 , memberSeq);
				}) ;
			 $(document).on("click","button[name=kick_btn]",function(){
				 	var memberSeq = $(this).val();
					 KickOrBan(1 , memberSeq);
				}) ;
			
	
		});//document ready   


		//이벤트에 참여되어있는 모든 사람 조회
		function doSelectList(eventSeq){
				  $.ajax({
					    type:"GET",
					    url:"${context}/join/doSelectList.do",
					    dataType:"html", 
					    data:{"eventSeq":eventSeq	//임시값, 이벤트에서 줄거라고 가정         
					    },
					    success:function(data){ //성공
					       console.log("data="+data);
					       var obj = JSON.parse(data);
				          	  $("#joinToggleTable").empty();
				          	  drawTable(obj);   
					    },
					    error:function(xhr,status,error){
					     alert("error:"+error);
					    },
					    complete:function(data){		    
					    }   			  
				});//--ajax		

			}

		function KickOrBan(num , memberSeq){
			
			var urlString = "";
			var warnString = "";
			if(num ==1){
				urlString = "${context}/join/Kick.do";
				warnString = "추방";			
			}else{
				urlString = "${context}/join/Ban.do"
				warnString = "차단";		
			}
			if( false==confirm(warnString+ "하시겠습니까?"))return;
			  $.ajax({
				    type:"POST",
				    url: urlString,
				    dataType:"html", 
				    data:{"memberSeq":memberSeq,
				    	  "eventSeq":1001	//임시값, 이벤트에서 줄거라고 가정         
				    },
				    success:function(data){ //성공
				    	var obj = JSON.parse(data);
				       console.log("obj="+obj); 
				       if(obj.msgId ==1){
				    	   alert(warnString+ "에 성공했습니다.");
				    	   doSelectList(1001);
					   }else{
							alert(warnString+ "에 실패했습니다.");
					   }
				    },
				    error:function(xhr,status,error){
				     alert("error:"+error);
				    },
				    complete:function(data){		    
				    }   			  
			});//--ajax		

		}


		

		//테이블 그리기
		function drawTable(obj){
			var html  = "";		
			$.each(obj, function(i, value) {
				if(value.priority ==1){
					html += '<tr bgcolor=red>';	  
				}else{
					html += '<tr>'
				}
					html += '<td><span class= "glyphicon glyphicon-plus plusIcon"></span> <span class= "glyphicon glyphicon-minus plusIcon" style= "display: none"></span>';
					html +=	"   "+value.name+'( '+ value.userId+' )';
					html +=	 '</td></tr><tr style="display: none"><td><button class="btn btn-info btn-sm"  value= "'+value.memberSeq+'"name= "kick_btn">추방<btn>';
					html +=	 '<button class="btn btn-info btn-sm"  value= "'+value.memberSeq+'" name= "ban_btn">차단<btn></td></tr>';
			});
			$("#joinToggleTable").append(html);				  
		}





		
		</script>
</body>
</html>