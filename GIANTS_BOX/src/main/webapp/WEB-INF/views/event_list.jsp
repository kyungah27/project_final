<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>


 <main class="page landing-page" style="padding:145px 100px 100px 100px;">
 		<section class="clean-block" style="padding-bottom:50px">
			<!-- Start: Navigation with Search -->
			<nav class="navbar navbar-light navbar-expand-md navigation-clean-search">
				<div class="container">
					<button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1">
						<span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse text-center d-xl-flex" id="navcol-1" style="padding: 10px; padding-right: 20%; padding-left: 20%;">
						<form class="form-inline mx-auto" style="width: 82%;" method="get" target="_self">
							<div class="form-group" style="width: 100%;">
								<label for="search-field"><i class="fa fa-search"></i></label><input class="form-control search-field" type="search" id="search-field" name="search" style="width: 95%;" placeholder="검색">
							</div>
						</form>
						<a class="btn btn-light mr-auto action-button" role="button" href="#" style="background-color: rgb(0, 120, 255);">검색</a>
					</div>
				</div>
			</nav>
			<!-- End: Navigation with Search -->
		</section>
		

	<div class="row">
            <aside class="col-lg-4 col-md-6 mt-5">
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                	<!-- date picker -->
                	<div class="datepicker-here nav-link mr-auto ml-auto mb-3 mt-5" data-language="en" id="my_calendar"></div>
                	<!-- //date picker -->
                	
                	<!-- genre selection -->
                 <div class="d-flex justify-content-between ml-4 mt-3" style="margin-bottom: 7px;">
                      <h3 class="text-primary">장르 선택</h3>
                      <a href="#">전체해제</a>
                  </div>
	                <div class="mr-auto ml-auto" data-toggle="buttons">
	                	<div class="row btn-group-toggle mx-5">
						  <label class="m-2 btn btn-outline-primary btn-sm">
							    <input name="options" id="option1" autocomplete="off" value="genre1" type="checkbox"> genre1
						  </label>
						  <label class="m-2 btn btn-outline-primary btn-sm">
							    <input type="checkbox" name="options" id="option2" autocomplete="off" value="genre2"> genre2
						  </label>
						  <label class="m-2 btn btn-outline-primary btn-sm">
							    <input type="checkbox" name="options" id="option3" autocomplete="off" value="genre3"> genre3
						  </label>
						  <label class="m-2 btn btn-outline-primary btn-sm">
							    <input type="checkbox" name="options" id="option4" autocomplete="off" value="genre4"> genre4
						  </label>
						  <label class="m-2 btn btn-outline-primary btn-sm">
							    <input type="checkbox" name="options" id="option5" autocomplete="off" value="genre5"> genre5
						  </label>
						  <label class="m-2 btn btn-outline-primary btn-sm">
							    <input type="checkbox" name="options" id="option6" autocomplete="off" value="genre6"> genre6
						  </label>
						  <label class="m-2 btn btn-outline-primary btn-sm">
							    <input type="checkbox" name="options" id="option7" autocomplete="off" value="genre6"> genre7
						  </label>
						  <label class="m-2 btn btn-outline-primary btn-sm">
							    <input type="checkbox" name="options" id="option8" autocomplete="off" value="genre6"> genre8
						  </label>
						  <label class="m-2 btn btn-outline-primary btn-sm">
							    <input type="checkbox" name="options" id="option9" autocomplete="off" value="genre6"> genre9
						  </label>
						  <label class="m-2 btn btn-outline-primary btn-sm">
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
                           <div class="d-flex flex-row justify-content-between block-heading" style="margin-bottom: 7px;">
                                <h2 class="text-primary">내가 개최한 이벤트</h2>
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
                                <hr>
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
                                <hr>
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
                                <hr>
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
                                <hr>
                                <div class="card-body">
                                    <h4 class="card-title">참여한 이벤트가 없습니다.</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="tab-pane fade" id="v-pills-test" role="tabpanel" aria-labelledby="v-pills-test-tab">
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
                                <hr>
                                <div class="card-body">
                                    <p class="text-left card-text">
                                        <strong>10월 31일 6:30PM</strong>
                                    </p>
                                    <h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
                                    <p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
                                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                </div>

                                <!-- 참여 이벤트 없을 경우 -->
                                <hr>
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
                                <hr>
                                <div class="card-body">
                                    <p class="text-left card-text">
                                        <strong>10월 31일 6:30PM</strong>
                                    </p>
                                    <h4 class="card-title">[할로윈 파티] 무서운 영화 시리즈 함께 보실 분 :)</h4>
                                    <p class="card-text mb-1"><i class="fa fa-map-marker p-1"></i><span>강남역 CGV</span></p>
                                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                </div>

                                <!-- 참여 이벤트 없을 경우 -->
                                <hr>
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
	    $("#my_calendar").data('datepicker').selectDate(new Date());
	});




</script>


<%@ include file="cmn/footer2.jsp" %>
