<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>
   <main class="page"  style="padding-top: 65px;">
        <section class="clean-block clean-product dark">
            <div class="container">
                <div class="block-heading">
                    <p>${eventVO.targetDt}</p>
                    <h2 class="text-primary">${eventVO.eventNm}</h2>
                    <p>주최자</p>
                    <strong>${eventVO.userId}  이거 이름으로 바꿀까요?(지금 아이디)</strong>
                </div>
                <div class="block-content">
                    <div class="product-info">
                        <div class="row">
                            <div class="col-lg-7 col-md-12">
                                <img src="${context}/resources/img/main.jpg" class="img-fluid" />
                            </div>
                            <div class="col-lg-5">
                                <div class="info">
                                    <div>
                                        <h3 class="mt-3">${eventVO.eventNm}</h3>
                                    </div>
                                    <hr/>
                                    <div class="d-flex">
                                        <i class="fa fa-calendar p-2"></i>
                                        <p class="p-1">${eventVO.targetDt}<br/>
                                        오전 9:00 ~ 오후 12:00 <- 기간정보 지금없음</p>
                                    </div>
                                    <hr/>
                                    <div class="d-flex">
                                        <i class="fa fa-map-marker p-2"></i>
                                        <p class="p-1">${eventVO.location}</p>
                                    </div>
                                    <hr/>
                                    <div class="d-flex mb-3">
                                        <i class="fa fa-film p-2"></i>
                                        <div class="p-1">
                                            <h5><strong>도굴</strong></h5>
                                            <strong>감독&nbsp;</strong>강대규<br>
                                            <strong>출연 </strong>성동일, 하지원, 김희원 등<br>
                                            <strong>장르</strong>&nbsp;드라마<br>
                                        </div>
                                    </div>
                                    <form>
                                    	<button class="btn btn-primary btn-block btn-sm" type="button" id="doJoin">이벤트 참여하기</button>
                                    </form>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="product-info">
                        <div>
                            <ul class="nav nav-tabs" id="myTab">
                                <li class="nav-item"><a class="nav-link active" role="tab" data-toggle="tab" id="description-tab" href="#description">이벤트설명</a></li>
                                 <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" id="reviews-tab" href="#comments">댓글</a></li>
                                <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" id="specifications-tabs" href="#photos">사진</a></li>
                                <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" id="reviews-tab" href="#reviews">후기</a></li>
                            </ul>
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane active fade show description" role="tabpanel" id="description">
                                    
                                    <h3>이 영화 함께 봐요!</h3><br/>
                                    <div class="row">
                            <div class="col-lg-3">
                                    <img class="rounded img-fluid" src="${context}/resources/img/rank1.jpg">
                            </div>
                            
                            <div class="col-lg-9">
                                
                                <h3 class="mt-2 text-primary">도굴</h3>
                                <p>“고물인 줄 알았는데 보물이었다?!”
땅 파서 장사하는 도굴꾼들이 온다!
흙 맛만 봐도 보물을 찾아내는 타고난 천재 도굴꾼 강동구(이제훈).
 자칭 한국의 '인디아나 존스'로 불리는 고분벽화 도굴 전문가 존스 박사(조우진), 전설의 삽질 달인 삽다리(임원희)를 만나 환상(?)의 팀플레이를 자랑하며 위험천만하고도 짜릿한 도굴의 판을 키운다.
 
 한편, 그의 재능을 알아본 고미술계 엘리트 큐레이터 윤실장(신혜선)은
 강동구에게 매력적이면서도 위험한 거래를 제안하는데...!
 
 황영사 금동불상, 고구려 고분벽화 그리고 서울 강남 한복판 선릉까지!
 팔수록 판이 커지는 도굴의 세계!
 
 급이 다른 삽질이 시작된다!</p>
                                        </div>
                                        </div>
                                    <div>
                                        <hr/>
                                        <h3>세부사항</h3>
                                        <p><br/>${eventVO.content}<br/></p>
                                    </div>
                                    <hr/>
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    <!-- [영진님] 이벤트 참여자 목록 작업 필요 -->
                                    <div>
                                    
                                        <div>
                                            <h3>참석자(<strong>5</strong>)</h3>
                                        </div>
                                        
                            			
                                        <div class="row justify-content-center" id="join_list">    
                        <%--                     <div class="col-sm-6 col-lg-3">
                                                <div class="card clean-card text-center">
                                                    <img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/avatar1.jpg">
                                                    <div class="card-body">
                                                        <h4 class="card-title text-truncate">김철수(주최자)</h4>
                                                        <p class="card-text text-truncate">chriwj2</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6 col-lg-3">
                                                <div class="card clean-card text-center">
                                                    <img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/avatar1.jpg">
                                                    <div class="card-body">
                                                        <h4 class="card-title text-truncate">이영희</h4>
                                                        <p class="card-text">youngee2</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6 col-lg-3">
                                                <div class="card clean-card text-center">
                                                    <img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/avatar1.jpg">
                                                    <div class="card-body">
                                                        <h4 class="card-title text-truncate">Jimmy Krus</h4>
                                                        <p class="card-text text-truncate">jikrrr</p>
                                                    </div>
                                                </div>
                                            </div> --%>
    <%--                                         <div class="col-sm-6 col-lg-3">
                                                <div class="card clean-card text-center">
                                                    <img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/avatar1.jpg">
                                                    <div class="card-body">
                                                        <h4 class="card-title text-truncate">박모모</h4>
                                                        <p class="card-text text-truncate">momo0509</p>
                                                    </div>
                                                </div>
                                            </div> --%>
                                            
                                        </div>
                                        <div class="row justify-content-end mr-auto mt-2">
                                            <a href="#">더보기</a>
                                        </div>
                                    </div>
                                    <!-- //이벤트 참여자 목록 작업 필요 -->
                                    
                                    
                                    
                                    
                                    
                                    
                                </div>
                                <div class="tab-pane fade show photos" role="tabpanel" id="photos">
                                   <div class="row mt-4 mb-4">
                                    <div class="col-md-6 col-lg-4 item mt-3">
                                        <a class="lightbox" href="${context}/resources/img/movie_rank/image1.jpg">
                                            <img class="img-thumbnail img-fluid image" src="${context}/resources/img/movie_rank/image1.jpg">
                                        </a>
                                       </div>
                                    <div class="col-md-6 col-lg-4 item mt-3"><a class="lightbox" href="${context}/resources/img/movie_rank/image4.jpg"><img class="img-thumbnail img-fluid image" src="${context}/resources/img/movie_rank/image4.jpg"></a></div>
                                    <div class="col-md-6 col-lg-4 item mt-3"><a class="lightbox" href="${context}/resources/img/movie_rank/image6.jpg"><img class="img-thumbnail img-fluid image" src="${context}/resources/img/movie_rank/image6.jpg"></a></div>
                                    <div class="col-md-6 col-lg-4 item mt-3"><a class="lightbox" href="${context}/resources/img/movie_rank/image5.jpg"><img class="img-thumbnail img-fluid image" src="${context}/resources/img/movie_rank/image5.jpg"></a></div>
                                    <div class="col-md-6 col-lg-4 item mt-3"><a class="lightbox" href="${context}/resources/img/movie_rank/image1.jpg"><img class="img-thumbnail img-fluid image" src="${context}/resources/img/movie_rank/image1.jpg"></a></div>
                                    <div class="col-md-6 col-lg-4 item mt-3"><a class="lightbox" href="${context}/resources/img/movie_rank/image4.jpg"><img class="img-thumbnail img-fluid image" src="${context}/resources/img/movie_rank/image4.jpg"></a></div>
                                </div>
                                    <div class="row">
                                        <button class="btn btn-outline-primary btn-block">더보기</button>
                                    </div>
                                </div>
                                <div class="tab-pane fade show" role="tabpanel" id="comments">
                                    <div class="reviews">
                                        <div class="review-item">
                                            <h4>완전 기대돼요</h4><span class="text-muted"><a href="#">이영희</a>, 2020년 11월 11일</span>
                                            <p>기대됩니다.</p>
                                        </div>
                                    </div>
                                    <div class="reviews">
                                        <div class="review-item">
                                            <h4>I might not be there but I've heard that it's an incredible movie</h4><span class="text-muted"><a href="#">Jimmy Krus</a>, 2020년 11월 10일</span>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec augue nunc, pretium at augue at, convallis pellentesque ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                        </div>
                                    </div>
                                    <div class="reviews">
                                        <div class="review-item">
                                            <h4>10분 정도 늦을 것 같은데 영화 시간엔 맞춰 갈게요</h4><span class="text-muted"><a href="#">박모모</a>, 2020년 11월 9일</span>
                                            <p>재밌을 것 같습니다!!</p>
                                        </div>
                                    </div>
                                     <div class="row">
                                        <button class="btn btn-outline-primary btn-block">더보기</button>
                                    </div>
                                </div>
                                <div class="tab-pane fade show" role="tabpanel" id="reviews">
                                    후기게시판
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clean-related-items">
                        <h3>추천 이벤트</h3>
                        <div class="items">
                            <div class="row justify-content-center">
                    <div class="col-sm-6 col-lg-4">
                        <div class="card clean-card text-center"><img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/halloween.jpg">
                            <div class="card-body info">
                                <p class="text-left card-text"><strong>10월 31일 6:30PM</strong></p>
                                <h4 class="text-truncate card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                <div class="icons"><a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i class="icon-social-instagram"></i></a><a href="#"><i class="icon-social-twitter"></i></a><small>59명 참여</small></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="card clean-card text-center"><img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/music.jpg">
                            <div class="card-body info">
                                <p class="text-left card-text"><strong>11월 6일 8:00PM</strong></p>
                                <h4 class="text-truncate card-title">불금<strong>🔥🔥🔥</strong>&nbsp;온라인 무비 마라톤 (라라랜드, 위플래시, 스쿨오브락 음악영화 달리기)</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                <div class="icons"><a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i class="icon-social-instagram"></i></a><a href="#"><i class="icon-social-twitter"></i></a><small>12명 참여</small></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="card clean-card text-center"><img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/netflix.jpg">
                            <div class="card-body info">
                                <p class="text-left card-text"><strong>11월 20일 5:00PM</strong></p>
                                <h4 class="text-truncate card-title">넷플릭스 + 맥주 + Chilling!</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                <div class="icons"><a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i class="icon-social-instagram"></i></a><a href="#"><i class="icon-social-twitter"></i></a><small>2명 참여</small></div>
                            </div>
                        </div>
                    </div>
            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
     <script src="${context}/resources/js/jquery.min.js"></script>
     <script type="text/javascript">
			
 	$(document).ready(function() {
		console.log("document ready");
		doSelectList(${eventVO.eventSeq});
		
	});


	//로그인하기 되는데 seccess alert안됨 이따가함 
	$("#doJoin").on("click", function(e) {
		alert("doJoin");

		  $.ajax({
			    type:"POST",
			    url:"${context}/join/doInsert.do",
			    dataType:"html", 
			    data:{"eventSeq":	${eventVO.eventSeq},   
			    	  "memberSeq":	${sessionScope.user.seq},   	//임시값, 이벤트에서 줄거라고 가정   
			    	  "priority" :  0  						   
			    },
			    success:function(data){ //성공
			       var obj = JSON.parse(data);
			       console.log("obj="+obj);
			       if(obj.msgId == 1){
						alert(obj.msgContents);
						doSelectList(${eventVO.eventSeq});
				   }else{
						alert(obj.msgContents);
				   }
			    },
			    error:function(xhr,status,error){
			     alert("error:"+error);
			    },
			    complete:function(data){		    
			    }   			  
		});//--ajax		
	});

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
		          	  $("#join_list").empty();
		          	  drawTable(obj);   
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
			console.log(value);
			if(value.priority ==1){
				
			}else{
							
			}
			html += '<div class="col-sm-6 col-lg-3"><div class="card clean-card text-center">';
			html += '<img class="card-img-top w-100 d-block" src="${context}/resources/img/event_thumbnail/avatar1.jpg">';  //이미지
			html += '<div class="card-body">   <h4 class="card-title text-truncate">'+value.name+'</h4>';
            html += '<p class="card-text text-truncate">'+value.userId+'</p></div></div></div>';      		
		});
		$("#join_list").append(html);				  
	}
	
 	


     </script>
    
<%@ include file="cmn/footer1.jsp" %>
<!-- 자바스크립트 자리 -->
<%@ include file="cmn/footer2.jsp" %>
