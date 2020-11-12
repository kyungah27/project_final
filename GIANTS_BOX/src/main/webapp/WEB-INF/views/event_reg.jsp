<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>

   <main class="page"  style="padding-top: 65px;">
        <section class="clean-block clean-product dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-primary"><strong id="user_id">testId01</strong>님의 이벤트를 시작하세요.</h2>
                </div>
                <div class="block-content">
                    <form class="product-info">
                        <div class="row">
                        
                            <div class="col-lg-5 col-md-12 col-sm-12">
                                <div id="img_preview" class="flex_container" >
									<p id="img_area_txt">Drag & Drop</p>
								</div>
                                
                                <div class="custom-file mt-2 mb-3">
	                                <form id="save_frm" action="${context}/img/doInsert.do" method="post">
	                                  <input type="file" class="custom-file-input" id="img_picker" accept="image/jpg, image/png, image/jpeg, image/gif"  />
	                                  <label class="custom-file-label" id="img_label" for="customFile">대표 이미지 업로드하기</label>
	                                </form>
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
                                    <input type='text' class="form-control" id='target_dt' />
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
                                    <input type="text" class="form-control form-control" id="movie_code" placeholder="영화" aria-label="movie_info" />
                                    <button type="button" id="search_movie" class="btn btn-outline-primary btn-sm" type="button">영화검색</button>
                                </div>
                                <div class="input-group mb-3">
                                    <label for="movie_info" class="col-form-label col-lg-3">장르</label>
                                    <input type="text" class="form-control form-control" id="movie_genre" placeholder="장르" aria-label="movie_genre" readonly />
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
    
   



 <!-- javascript -->
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript">
    
    //모든 컨트롤(element)가 로딩이 완료시
	$(document).ready(function(){   
		console.log("document ready"); 
	});//document ready

	let picker = document.querySelector("#img_picker");
	let preview = document.querySelector("#img_preview");

	picker.addEventListener('change', function(e){
		let getFile = e.target.files;
		let image = document.createElement("img");
		image.setAttribute("class", "img-fluid");
		console.log(getFile);

		// FileReader 객체 생성
		let reader = new FileReader();
		
		// FileReader onload 시 이벤트 발생
		reader.onload = (function(file) {
			return function (e) {
				/* base64-encoded String data */
				console.log("result file");
				file.src = e.target.result;
			}
		})(image)
		
		if(getFile){
			console.log("getFile ()");
			reader.readAsDataURL(getFile[0]);
			
		}

		console.log("img append");
		preview.appendChild(image);
		
	})
	
	

	$("#search_movie").on("click",function(){
					//$(document).find('#selected_seq').val($(this).val());
			window.open("movieInfo/movie_info.do", "window" ,"width=800 height=400");
	}) ;

	
	
	
    /* function preview(file){
		console.log("file: "+file);

		// FileReader 객체 생성
		let reader = new FileReader();
				
		// FileReader onload 시 이벤트 발생
		reader.onload = function(file) {
			const img = document.createElement("img");
			img.setAttribute("src", this.result);
			img.setAttribute("height", "150px");

			const flexDiv = document.createElement("div");

			const a = document.createElement("a");
			a.setAttribute("href", "#");
			a.setAttribute("name", "removeImg");
			
			flexDiv.appendChild(img);
			flexDiv.appendChild(a);

			document.querySelector("div#img_preview")
						.appendChild(flexDiv);

			flexDiv.setAttribute("class", "flex_item");
		};

		//reader.readAsDataURL(file);
	} */


	</script>
<%@ include file="cmn/footer1.jsp" %>
<%@ include file="cmn/footer2.jsp" %>
