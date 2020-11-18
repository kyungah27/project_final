<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>


 <main class="page landing-page" style="padding:145px 100px 100px 100px;">

        <div class="row">
            <aside class="col-3">
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#" onclick="selectList(1); return false;" role="tab" aria-selected="true">내가 개최한 이벤트</a>
                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#" onclick="selectList(2); return false;"  role="tab" aria-selected="false">내가 참여하는 이벤트</a>
                    <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#" onclick="selectList(3); return false;"  role="tab" aria-selected="false">지난 이벤트</a>
                </div>
            </aside>
            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                        <div class="container" >
                           <div class="d-flex flex-row justify-content-between block-heading" style="margin-bottom: 7px;">
                                <h2 class="text-primary"><label id="menuName">이벤트 목록</label></h2>
                                <button type="button" id="event_reg" class="btn btn-primary">이벤트 등록</button>
                            </div>

                            <div class="card clean-card text-left" id="reg_cards">
                            	
                                <!-- 이벤트 반복 -->
                                <hr />
                                
                                <div class="card-body row align-items-center">
	                               
                                </div>

                                <!-- 참여 이벤트 없을 경우 -->
                                <hr />
                                <%-- <div class="card-body">
                                    <h4 class="card-title">개최한 이벤트가 없습니다.</h4>
                                </div>--%>
                            </div>
                        </div>


                    </div>
                   
                </div>
            </div>
        </div>
     
    </main>



    
<%@ include file="cmn/footer1.jsp" %>


<script type="text/javascript">

 var flag = true;
 var page = 1;
 var loading = false;
 
	$(document).ready(function() {
	    console.log( "document ready" );
	    selectList(1);
	   
	    
	});

	let eventRegBtn = document.getElementById('event_reg');
	eventRegBtn.addEventListener('click', function(){
		window.location.href = "event_reg.do";
	});

	
	
	function selectList(e){
		  
		  $.ajax({
			    type:"GET",
			    url:"${context}/event/doSelectList2.do",
			    dataType:"json",
			    data:{
			    	  "pageNum"  : page,
			    	  "pageSize" : 3,
			    	  "myDiv" : e
			    },
			    success:function(data){ //성공
			    	
			       console.log("data="+data);
			 	 
			 	 	drawCards(data,e);  
			    },
			    error:function(xhr,status,error){
			     alert("error:"+error);
			    },
			    complete:function(data){		    
			    }   			  
		});//--ajax	
		 
		
	}
	
	function drawCards(data,e){
		var html  = "";	
		if(data.length < 1){
			html += '<div class="card-body"><h4 class="card-title">이벤트가 없습니다.</h4></div>'
			flag = false;
		}else{
	 	$.each(data, function(i, value) {
		 	console.log(data);


//		html += '<div class="d-flex flex-row justify-content-between block-heading" style="margin-bottom: 7px;">';
//		html += '<h2 class="text-primary"><label id="menuName">내가 개최한 이벤트</label></h2>';
//        html += '<button type="button" id="event_reg" class="btn btn-primary">이벤트 등록</button>';
//        html += '</div><div class="card clean-card text-left" >''
        html += '<div class="card-body row align-items-center"><div class="col">';
        html += '<p class="text-left card-text">';
        html += '<input type="hidden" name="event_seq" value="' + value.eventSeq  +'"/>'
        html += '<input type="hidden" id="user_id" value="${sessionScope.user.userId}"/>'
        html += '<strong>'+value.targetDt+'</strong></p>';


        html += '<h4 class="card-title">'+value.eventNm+'</h4>';
        html += '<p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>'+value.location+'</span></p>';
        html += '<p class="card-text mb-2">'+value.content+'</p>';
    	html += '</div><div class="col-lg-3 col-md-3 text-center">';
    	if(e=="1"){
       		html += '<button type="button" onclick="updateEvent(this)" class="btn btn-outline-primary mx-1">수정</button>';
       		html += '<button type="button" onclick="deleteEvent(this)" class="btn btn-outline-primary">삭제</button>';
    	} else if(e=="2"){
    		html += '<button type="button" onclick="deleteJoin('+value.eventSeq+')" class="btn btn-outline-primary">참여 취소</button>';
        }
    	html += '</div></div><hr />';
	 	}); 
		}
		$("#reg_cards").empty();
		$("#reg_cards").append(html);		 	  
	}


	function deleteJoin(eventSeq){
		if(!confirm("[경고] 이벤트 참여를 취소 하시겠습니까?")){
			return;
		};
		
		 $.ajax({
			    type:"POST",
			    url:"${context}/join/doDelete.do",
			    dataType:"html", 
			    data:{ "eventSeq":eventSeq },
			    success:function(data){ //성공
			    	selectList(2);            
			    },
			    error:function(xhr,status,error){
			     alert("error:"+error);
			    },
			    complete:function(data){
			}   
		});
	}


	function updateEvent(updateBtn){
		let eventSeq = updateBtn.parentNode.previousSibling.firstChild.firstChild.value;
		window.location.href="event_update.do?eventSeq=" + eventSeq;
	}

	function deleteEvent(deleteBtn){
		if(!confirm("[경고] \n이벤트를 삭제하시겠습니까? \n삭제하실 경우 관련 정보들이 모두 삭제됩니다.")){
			return;
		};
		
		let eventSeq = deleteBtn.parentNode.previousSibling.firstChild.firstChild.value;
		 $.ajax({
			    type:"GET",
			    url:"${context}/event/doDelete.do",
			    dataType:"html", 
			    data:{ "eventSeq":eventSeq },
			    success:function(data){ //성공

			    	var obj = JSON.parse(data);

				    if(null != obj && obj.msgId=="1"){
				    	console.log("success");
		                alert(obj.msgContents);
		                selectList(1);
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
		
	}
	


	



</script>


<%@ include file="cmn/footer2.jsp" %>
