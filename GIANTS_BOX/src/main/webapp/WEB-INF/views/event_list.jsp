<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>


 <main class="page landing-page" style="padding:145px 100px 100px 100px;">
 		<section class="clean-block" style="padding-bottom:50px">
             <nav class="navbar navbar-light navbar-expand-md navigation-clean-search">
    			 <div class="container"><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        		 <div class="collapse navbar-collapse text-center d-xl-flex" id="navcol-1" style="padding: 10px;padding-right: 20%;padding-left: 20%;">
             		<form class="form-inline mx-auto" style="width: 82%;" method="get" target="_self">
                 	<div class="form-group" style="width: 100%;"><label for="search-field"><i class="fa fa-search"></i></label><input class="form-control search-field"  type="search" id="search-field" name="search" style="width: 95%;" placeholder="검색"/></div>
             		</form><a id = "search_btn" class="btn btn-light mr-auto action-button" role="button"  style="background-color: rgb(0,120,255);">검색</a></div>
     			</div>
 			</nav>
		</section>
	<div class="row">
            <aside class="col-lg-4 col-md-6">
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                	<!-- date picker -->
                	<div class="datepicker-here nav-link mr-auto ml-auto mb-3 mt-5" data-language="en" id="my_calendar"></div>
                	<!-- //date picker -->
                	
                	<!-- genre selection -->
                 <div class="mx-auto mt-3" style="margin-bottom: 7px;">
                      <h3 class="text-primary">장르 선택</h3>
                  </div>
                  <div class="d-flex justify-content-end mx-5">
                     <input type="button" value="전체선택" id="all_add_selection" class="btn btn-thirtiary btn-sm">
                     <input type="button" value="전체해제" id="all_del_selection" class="btn btn-thirtiary btn-sm">
                  </div>
	                <div class="mr-auto ml-auto" data-toggle="buttons">
	                	<div class="row btn-group-toggle mx-5">
						  <label class="ml-2 my-2 btn btn-outline-primary rounded-pill" for="option1">
							    <input type="checkbox" name="options" id="option1" autocomplete="off" value="드라마"> 드라마
						  </label>
						  <label class="ml-2 my-2 btn btn-outline-primary rounded-pill" for="option2">
							    <input type="checkbox" name="options" id="option2" autocomplete="off" value="액션"> 액션
						  </label>
						  <label class="ml-2 my-2 btn btn-outline-primary rounded-pill" for="option3">
							    <input type="checkbox" name="options" id="option3" autocomplete="off" value="공포"> 공포
						  </label>
						  <label class="ml-2 my-2 btn btn-outline-primary rounded-pill" for="option4">
							    <input type="checkbox" name="options" id="option4" autocomplete="off" value="genre4"> genre4
						  </label>
						  <label class="ml-2 my-2 btn btn-outline-primary rounded-pill" for="option5">
							    <input type="checkbox" name="options" id="option5" autocomplete="off" value="genre5"> genre5
						  </label>
						  <label class="ml-2 my-2 btn btn-outline-primary rounded-pill" for="option6">
							    <input type="checkbox" name="options" id="option6" autocomplete="off" value="genre6"> genre6
						  </label>
						  <label class="ml-2 my-2 btn btn-outline-primary rounded-pill" for="option7" >
							    <input type="checkbox" name="options" id="option7" autocomplete="off" value="genre6"> genre7
						  </label>
						  <label class="ml-2 my-2 btn btn-outline-primary rounded-pill" for="option8">
							    <input type="checkbox" name="options" id="option8" autocomplete="off" value="genre6"> genre8
						  </label>
						  <label class="ml-2 my-2 btn btn-outline-primary rounded-pill" for="option9">
							    <input type="checkbox" name="options" id="option9" autocomplete="off" value="genre6"> genre9
						  </label>
						  <label class="ml-2 my-2 btn btn-outline-primary rounded-pill" for="option10">
							    <input type="checkbox" name="options" id="option10" autocomplete="off" value="genre6"> genre10
						  </label>
						</div>
						
					</div>
					<!-- //genre selection -->
					
                </div>
            </aside>
            
            
            <div class="col mt-5">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                        <div class="container">

                            <div class="card clean-card pt-3" id="event_cards">
               
				
                                <!-- 이벤트 반복 -->
                                <hr/>
                                <div class="card-body row align-items-center justify-content-center">
                                	<div class="col-lg-3">
                                		<img src="resources/img/event_thumbnail/music.jpg" class="img-fluid rounded mb-2">
                                	</div>
                                	<div class="col-lg-6 text-left">
	                                    <p class="text-left card-text">
	                                        <strong>10월 31일 6:30PM</strong>
	                                    </p>
	                                    <h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
	                                    <p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
	                                    <p class="card-text mb-2">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
	                                </div>
	                                <div class="col-lg-3 col-md-5 text-center">
                                    	<button type="button" name="event_update" class="btn btn-outline-primary">참여</button>
                                    </div>
                                </div>

                                <!-- 참여 이벤트 없을 경우 -->
                                <hr>
                                <div class="card-body">
                                    <h4 class="card-title">이벤트가 없습니다.</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    
                    
                    
                    
                </div>
            </div>
        </div>
     
    </main>



    
<%@ include file="cmn/footer1.jsp" %>


<script type="text/javascript">

	var loading = false;
	var page = 1;
	$(document).ready(function() {
	    $("#my_calendar").data('datepicker').selectDate(new Date());
	    $("#my_calendar").datepicker({ dateFormat: 'yyyy-mm-dd' }); 
	    SelectList("${genres}" , "${searchWord}");
	    $("#search-field").val("${searchWord}");
	});









	


	//---[전체선택/전체해제]-------------------------
	
	let allAdd = document.getElementById("all_add_selection");
	let allDel = document.getElementById("all_del_selection");
	
	options = document.getElementsByName("options");
	let optionsLen = options.length;

	allAdd.addEventListener('click', function (){
		for(i = 0; i < optionsLen; i++) {
	        let optionsId = options[i].getAttribute("id");
	        options[i].parentNode.classList.add("active");
	        options[i].checked = true; // 모든 체크박스를 체크한다.
        }
	});

	allDel.addEventListener('click', function (){
		for(i = 0; i < optionsLen; i++) {
        	let optionsId = options[i].getAttribute("id");
        	options[i].parentNode.classList.remove("active");
        	options[i].checked = false; // 모든 체크박스를 해제한다.
        }
	});
	//------------------------------------------

		 $("#search_btn").on("click", function(e) {

		 // 날짜값 가져오기
		 console.log($("#search-field").val());
		 // 체크박스 값 가져오기
		 checkStr = "";
			for(i = 1; i <= optionsLen; i++) {
				if($("#option"+i).prop("checked") == true){
				checkStr += $("#option"+i).val()+","
				}
		     }
			 SelectList(checkStr,searchWord);	
		});

	function SelectList(genreStr ,searchWord ){

		  $.ajax({
			    type:"GET",
			    url:"${context}/event/doSelectList.do",
			    dataType:"json", 
			    data:{"searchWord":	$("#search-field").val(),
			    	  "searchDate":	$("#my_calendar").val(),   	//임시값, 이벤트에서 줄거라고 가정   
			    	  "genreStr" :  checkStr,
			    	  //"pageNum"  : pageNum++,
			    	  //"pageSize" : pageSize		 	   
			    },
			    success:function(data){ //성공
				   alert("일단성공");
			       console.log("data="+data);
			 	  $("#event_cards").empty();
			 	 	drawCards(data);  
			    },
			    error:function(xhr,status,error){
			     alert("error:"+error);
			    },
			    complete:function(data){		    
			    }   			  
		});//--ajax	
		 
		
	});

/* 	 $(document).on("click","button[name=seleted_seq]",function(){
			var eventSeq = $(this).val();
			alert(eventSeq);
			var frm = 
			eventSeq.action ="${context}/event/doSelectList.do";
			
		}) ; */



			
	function drawCards(data){
		var html  = "";		
	 	$.each(data, function(i, value) {
		 	console.log(data);
        html += '<div class="card-body row align-items-center justify-content-center"><div class="col-lg-3">';
        html += '<img src="resources/img/event_thumbnail/music.jpg" class="img-fluid rounded mb-2">';  //이미지 일단 보류
		html += '</div><div class="col-lg-6 text-left"><p class="text-left card-text"><strong>'+value.targetDt+'</strong>';
		html += '</p><h4 class="card-title">'+value.eventNm+'</h4>';
		html += '<p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>'+value.location+'</span></p>';
		html += '<p class="card-text mb-2">'+value.content.substring(1, 50)+'..</p>';
		html += '</div> <div class="col-lg-3 col-md-5 text-center">';
		html +=	'<form method ="GET" action ="${context}/event/doSelectOne.do"><button  value ='+value.eventSeq+' type="submit" name="seleted_seq" class="btn btn-outline-primary">참여</button></form>';
		html +=  '</div></div>'
	 	}); 
		$("#event_cards").append(html);		 	  
	}


		function next_load(){
				page++;
				console.log("=page="+page);
				loading = false;
				
			}


		 $(window).scroll(function(){
		        if($(window).scrollTop()+200>=$(document).height() - $(window).height())
		        {
		            if(!loading)    //실행 가능 상태라면?
		            {
		                loading = true; //실행 불가능 상태로 변경
		                next_load(); 
		            }
		            else            //실행 불가능 상태라면?
		            {
		                alert('다음페이지를 로딩중입니다.');  
		            }
		        }
		    });  

	

</script>


<%@ include file="cmn/footer2.jsp" %>
