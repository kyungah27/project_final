<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>


 <main class="page landing-page" style="padding:145px 100px 100px 100px;">

        <div class="row">
            <aside class="col-3">
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">내가 개최한 이벤트</a>
                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">내가 참여하는 이벤트</a>
                    <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">지난 이벤트</a>
                </div>
            </aside>
            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                        <div class="container">
                           <div class="d-flex flex-row justify-content-between block-heading" style="margin-bottom: 7px;">
                                <h2 class="text-primary">내가 개최한 이벤트</h2>
                                <button type="button" id="event_reg" class="btn btn-primary">이벤트 등록</button>
                            </div>

                            <div class="card clean-card text-left">
                                <div class="card-body row align-items-center">
                                	<div class="col">
	                                    <p class="text-left card-text">
	                                        <strong>10월 31일 6:30PM</strong>
	                                    </p>
	                                    <h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
	                                    <p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
	                                    <p class="card-text mb-2">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                    </div>
                                    
	                                <div class="col-lg-2 col-md-3 text-center">
                                    	<button type="button" name="event_update" class="btn btn-outline-primary">수정</button>
                                    	<button type="button" name="event_delete" class="btn btn-outline-primary">삭제</button>
                                    </div>
                                    
                                </div>

                                <!-- 이벤트 반복 -->
                                <hr />
                                <div class="card-body row align-items-center">
	                                <div class="col">
	                                    <p class="text-left card-text">
	                                        <strong>10월 31일 6:30PM</strong>
	                                    </p>
	                                    <h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
	                                    <p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
	                                    <p class="card-text mb-2">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
	                                </div>
	                                <div class="col-lg-2 col-md-3 text-center">
                                    	<button type="button" name="event_update" class="btn btn-outline-primary">수정</button>
                                    	<button type="button" name="event_delete" class="btn btn-outline-primary">삭제</button>
                                    </div>
                                </div>

                                <!-- 참여 이벤트 없을 경우 -->
                                <hr />
                                <div class="card-body">
                                    <h4 class="card-title">개최한 이벤트가 없습니다.</h4>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">

                        <div class="container">
                            <div class="d-flex flex-column justify-content-between block-heading" style="margin-bottom: 7px;">
                                <h2 class="text-primary">내가 참여하는 이벤트</h2>
                            </div>

                            <div class="card clean-card text-left">
                                <div class="card-body row align-items-center">
                                	<div class="col">
	                                    <p class="text-left card-text">
	                                        <strong>10월 31일 6:30PM</strong>
	                                    </p>
	                                    <h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
	                                    <p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
	                                    <p class="card-text mb-2">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                    </div>
                                    
                                    <div class="col-lg-2 col-md-3 text-center">
                                    	<button type="button" name="event_cancel" class="btn btn-outline-primary">참여 취소</button>
                                    </div>
                                </div>

                                <!-- 이벤트 반복 -->
                                <hr />
                                <div class="card-body row align-items-center">
	                                <div class="col">
	                                    <p class="text-left card-text">
	                                        <strong>10월 31일 6:30PM</strong>
	                                    </p>
	                                    <h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
	                                    <p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
	                                    <p class="card-text mb-2">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
	                                </div>
	                                 <div class="col-lg-2 col-md-3 text-center">
                                    	<button type="button" name="event_cancel" class="btn btn-outline-primary">참여 취소</button>
                                    </div>
                                </div>

                                <!-- 참여 이벤트 없을 경우 -->
                                <hr />
                                <div class="card-body">
                                    <h4 class="card-title">참여한 이벤트가 없습니다.</h4>
                                </div>
                            </div>
                        </div>




                    </div>
                    <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">


                        <div class="container">
                            <div class="d-flex flex-column justify-content-between block-heading" style="margin-bottom: 7px;">
                                <h2 class="text-primary">지난 이벤트</h2>
                            </div>

                            <div class="card clean-card text-left">
                                <div class="card-body">
                                    <p class="text-left card-text">
                                        <strong>10월 31일 6:30PM</strong>
                                    </p>
                                    <h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
                                    <p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
                                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                </div>

                                <!-- 이벤트 반복 -->
                                <hr />
                                <div class="card-body">
                                    <p class="text-left card-text">
                                        <strong>10월 31일 6:30PM</strong>
                                    </p>
                                    <h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
                                    <p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
                                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                </div>

                                <!-- 참여 이벤트 없을 경우 -->
                                <hr />
                                <div class="card-body">
                                    <h4 class="card-title">참여한 이벤트가 없습니다.</h4>
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
	$(document).ready(function() {
	    console.log( "document ready" );
	});

	let eventRegBtn = document.getElementById('event_reg');
	eventRegBtn.addEventListener('click', function(){
		window.location.href = "event_reg.do";
	});




</script>


<%@ include file="cmn/footer2.jsp" %>
