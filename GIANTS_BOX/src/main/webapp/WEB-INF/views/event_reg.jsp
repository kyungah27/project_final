<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>

   <main class="page"  style="padding-top: 65px;">
        <section class="clean-block clean-product dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-primary"><strong id="user_id">testId01</strong>님의 이벤트를 시작하세요.</h2>
                </div>
                <div class="block-content pb-1">
                    <form class="product-info">
                        <div class="row">
                            <div class="col-lg-5 col-md-12 col-sm-12">
                                <img src="assets/img/main.jpg" class="img-fluid" />
                                <div class="custom-file mt-2 mb-3">
                                  <input type="file" class="custom-file-input" id="customFile">
                                  <label class="custom-file-label" for="customFile">대표 이미지 업로드하기</label>
                                </div>
                            </div>
                            <div class="col-lg-7 col-md-12 col-sm-12">
                                <div class="input-group mb-3">
                                    <label for="event_nm" class="col-form-label col-lg-3">모임명</label>
                                    <input type="text" class="form-control" id="event_nm" placeholder="모임명" aria-label="event_nm" />
                                </div>
                                <div class="input-group mb-3">
                                    <label for="capacity" class="col-form-label col-lg-3">정원</label>
                                    <input type="number" class="form-control" id="capacity" placeholder="정원" aria-label="capacity" />
                                </div>
                                 <div class="input-group mb-3">
                                    <label for="target_dt" class="col-form-label  col-lg-3">이벤트 일시</label>
                                    <input type="date" class="form-control" id="target_dt" placeholder="이벤트 날짜" aria-label="target_dt" />
                                    <input type="time" class="form-control" id="target_tm" placeholder="이벤트 시간" aria-label="target_tm" />
                                </div>
                                <div class="input-group mb-3">
                                    <label for="start_dt" class="col-form-label col-lg-3">모집 시작일</label>
                                    <input type="date" class="form-control" id="start_dt" placeholder="모집 시작일" aria-label="start_dt" />
                                </div>
                                <div class="input-group mb-3">
                                    <label for="end_dt" class="col-form-label col-lg-3">모집 종료일</label>
                                    <input type="date" class="form-control" id="end_dt" placeholder="모집 종료일" aria-label="end_dt" />
                                </div>
                                <div class="input-group mb-3">
                                    <label for="location" class="col-form-label col-lg-3">장소</label>
                                    <input type="text" class="form-control" id="location" placeholder="장소" aria-label="location" />
                                </div>
                                <div class="input-group mb-3">
                                    <label for="movie_info" class="col-form-label col-lg-3">영화</label>
                                    <input type="text" class="form-control form-control" id="movie_info" placeholder="영화" aria-label="movie_info" />
                                    <button type="button" id="search_movie" class="btn btn-outline-primary btn-sm" type="button">영화검색</button>
                                </div>                                    
                            </div>
                        </div>
                        <div class="form-group row ml-auto">
                            <label for="content" class="col-form-label">세부사항</label>
                            <textarea class="form-control" id="content" rows="16"></textarea>
                        </div>
                        <button type="button" id="search_movie" class="btn btn-primary btn-block" type="button">이벤트 등록</button>
                    </form>
                    
                </div>
            </div>
        </section>
    </main>
   
<%@ include file="cmn/footer.jsp" %>
