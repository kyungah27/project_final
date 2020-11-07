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
			<div class="table-responsive">
				<!-- table -->
				<table border="1" id="joinTable"
					class="table table-striped table-bordered table-hover table-condensed">
					<thead class="bg-primary">
						<th class="text-center col-lg-2 col-md-2  col-xs-2">EventSeq(hidden)</th>
						<th class="text-center col-lg-2 col-md-2  col-xs-2">memberSeq(hidden)</th>
						<th class="text-center col-lg-2 col-md-2  col-xs-2">이름</th>
						<th class="text-center col-lg-2 col-md-2  col-xs-2">아이디</th>
						<th class="text-center col-lg-2 col-md-2  col-xs-2">권한</th>
					</thead>
					<tbody id="joinTablebody"></tbody>
				</table>
				<!--// table -->

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


			// 강퇴, 삭제를 위한 
			   $("#joinTablebody").on("click", "tr", function(e) {				
					var tds = $(this).children();
	                var eSeq = tds.eq(0).text();
	                var mSeq = tds.eq(1).text();
				   alert("eSeq  :" + eSeq + "mSeq   :"+ mSeq);
				   $("#selected_mseq").val(mSeq);
				   $("#selected_eseq").val(eSeq);
				   //$(tds).parent().after('<tr><td><input type="password" id ="toggle" /></td></tr>');
				});
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
				          	  $("#joinTablebody").empty();
				          	  drawTable(obj);
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
									  html += "<td class='text-center'>"+value.userId+"</td>";
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

			}


		function drawTable(obj){
			var html  = "";		
			$.each(obj, function(i, value) {
				if(value.priority ==1){
					html += '<tr bgcolor=red>';	  
				}else{
					html += '<tr>'
				}
					html += '<td><span class= "glyphicon glyphicon-plus plusIcon"></span> <span class= "glyphicon glyphicon-minus plusIcon" style= "display: none"></span>'
					html +=	"   "+value.name+'( '+ value.userId+' )';
					html +=	 '</td></tr><tr style="display: none"><td><button class="btn btn-info btn-sm"  value= '+value.memberSeq+' id="detail_btn'+i+' name="detail_btn">추방<btn></td></tr>';
			});
			$("#joinToggleTable").append(html);				  
		}





		
		</script>
</body>
</html>