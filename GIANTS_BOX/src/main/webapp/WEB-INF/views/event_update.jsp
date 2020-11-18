<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>

   <main class="page"  style="padding-top: 65px;">

   
        <section class="clean-block clean-product dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-primary"><strong id="user_id">${user.userId}</strong>님의 이벤트를 수정하세요.</h2>
                </div>
                <div class="block-content">
                    <form class="product-info" id="reg_frm">
                        <div class="row">
                        
                            <div class="col-lg-5 col-md-12 col-sm-12">
                                <div id="img_preview" class="flex-container justify-content-center">
									<img src="${context}/img/${imgSeq}.do" id="img_area_img" class="img-fluid"></img>
								</div>
                                
                                <div class="custom-file mt-2 mb-3">
                                	<form id="img_frm" method="post" enctype="multipart/form-data">
	                                  <input type="file" class="custom-file-input" name="images" id="img_picker" accept="image/jpg, image/png, image/jpeg, image/gif"  />
	                                  <label class="custom-file-label" id="img_label" for="customFile">대표 이미지 업로드하기</label>
									  <input type="hidden" name="regId" value="${user.userId}" />
									  <input type="hidden" name="eventSeq" value="${event.eventSeq}" />
	                                  <input type="hidden" name="isThumbnail" value="y" />
	                                  <input type="hidden" name="imgSeq" value="${imgSeq}" />
	                                </form>
                                </div>
                            </div>
                            
                            <div class="col-lg-7 col-md-12 col-sm-12">
                            
                            <form id="event_frm" action="${context}/event/doInsert.do" method="POST">
                            	<input type="hidden" id=userId name=userId value="${user.userId}" />
                            	
                                <div class="input-group mb-3">
                                    <label for="event_nm" class="col-form-label col-lg-3">모임명</label>
                                    <input type="text" class="form-control" id="event_nm" placeholder="모임명" aria-label="event_nm" value="${event.eventNm}" />
                                </div>
                                <div class="input-group mb-3">
                                    <label for="capacity" class="col-form-label col-lg-3">정원</label>
                                    <input type="number" class="form-control" id="capacity" placeholder="정원" aria-label="capacity" value="${event.capacity}" />
                                </div>
                                 <div class="input-group mb-3">
                                    <label for="target_dt" class="col-form-label  col-lg-3">이벤트 일시</label>
                                    <input type='text' class="form-control" id="target_dt" placeholder="이벤트 일시" aria-label="target_dt" value="${event.targetDt}" />
                                </div>
                                <div class="input-group mb-3">
                                    <label for="start_dt" class="col-form-label col-lg-3">모집 시작일</label>
                                    <fmt:parseDate value="${event.startDt}" var="startParseDate" pattern="yyyy-MM-dd HH:mm:ss" />
                                    <fmt:formatDate value="${startParseDate}" var="start_date" pattern="yyyy-MM-dd" />
                                    <input type="date" class="form-control" id="start_dt" placeholder="모집 시작일" aria-label="start_dt" value="${start_date}"/>
                                </div>
                                <div class="input-group mb-3">
                                    <label for="end_dt" class="col-form-label col-lg-3">모집 종료일</label>
                                    <fmt:parseDate value="${event.endDt}" var="endParseDate" pattern="yyyy-MM-dd HH:mm:ss" />
                                    <fmt:formatDate value="${endParseDate}" var="end_date" pattern="yyyy-MM-dd" />
                                    <input type="date" class="form-control" id="end_dt" placeholder="모집 종료일" aria-label="end_dt" value="${end_date}"/>
                                </div>
                                <div class="input-group mb-3">
                                    <label for="place" class="col-form-label col-lg-3">장소</label>
                                    <input type="text" class="form-control" id="place" placeholder="장소" aria-label="place" value="${event.location}"/>
                                </div>
                                <div class="input-group mb-3">
                                    <label for="movie_info" class="col-form-label col-lg-3">영화</label>
                                    <input type="text" class="form-control form-control" id="movie_code" placeholder="영화" aria-label="movie_info" value="${event.movieInfo}" />
                                    <button type="button" id="search_movie" class="btn btn-outline-primary btn-sm" type="button">영화검색</button>
                                </div>
                                <div class="input-group mb-3">
                                    <label for="movie_genre" class="col-form-label col-lg-3">장르</label>
                                    <input type="text" class="form-control form-control" id="movie_genre" placeholder="장르" aria-label="movie_genre" value="${event.genre}" />
                                </div>
                                </form>                                       
                            </div>
                        </div>
                        <div class="form-group row ml-auto">
                            <label for="content" class="col-form-label">세부사항</label>
                            <textarea class="form-control" id="content" rows="16">${event.content}</textarea>
                        </div>
                        <button type="button" id="event_update_btn" class="btn btn-primary btn-block">이벤트 수정</button>
                    </form>
                    
                </div>
            </div>
        </section>
    </main>

 
<%@ include file="cmn/footer1.jsp" %>

<!-- javascript -->
    <script type="text/javascript">
    
    //모든 컨트롤(element)가 로딩이 완료시
	$(document).ready(function(){   
		
	});

	let imgPicker = document.querySelector("#img_picker");
	let preview = document.querySelector("#img_preview");
	let eventRegBtn = document.getElementById("event_update_btn");
	let transferFile = $("#img_picker")[0].files[0];

 	let eventNm = document.getElementById("event_nm");
 	let capacity = document.getElementById("capacity");
 	let targetDt = document.getElementById("target_dt").value;
 	let startDt = document.getElementById("start_dt");
 	let endDt = document.getElementById("end_dt");
 	let place = document.getElementById("place");
 	let movieCode = document.getElementById("movie_code");
 	let movieGenre = document.getElementById("movie_genre");
 	let content = document.getElementById("content");
 	 

	//---[수정]----------------------------------------
	eventRegBtn.addEventListener("click", eventReg, false);
	
	function eventReg(){
		//---[수정 확인]
		if(!confirm("수정하시겠습니까?")){
			console.log(transferFile);
			return;
		}

		
		//---[validation]
		console.log(eventNm.value);
		console.log(capacity.value);
		console.log(targetDt);
		console.log(startDt.value);
		console.log(endDt.value);
		console.log(place.value);
		console.log(movieCode.value);
		console.log(movieGenre.value);
		console.log(content.value);


		let chkImgSeq = document.getElementById("img_area_img").src.split(".")[0];
		let lastChkImgSeq = chkImgSeq.slice(chkImgSeq.length-3, chkImgSeq.length);
		console.log(lastChkImgSeq);
		

		
		//---기본 이미지는 수정 대상 X
        if (lastChkImgSeq != 707){
        	eventUpdate()
    		.then(imgUpdate)
    		.then(successFunction)
    		.catch(errorFunction)
		} else {
			eventUpdate()
			.then(successFunction)
    		.catch(errorFunction)
		}
		

	}
	//---//[수정]----------------------------------------
	
	
	//---[이벤트 수정]--------------------
	function eventUpdate(){
		let eventData = {
				eventSeq : ${event.eventSeq},
				userId : $("#userId").val(),
				eventNm : eventNm.value.trim(),
				content : content.value.trim(),
				capacity : capacity.value,
				movieInfo : movieCode.value,
				startDt : startDt.value,
				endDt : endDt.value,
				location : place.value.trim(),
				regDt : "2020-01-02",
				targetDt : targetDt,
				regId : $("#userId").val(),
				genre : movieGenre.value
		};
		
		console.log(eventData);
		
		return new Promise(function(resolve, reject){
			$.ajax({
				type: "POST",
				url: "${context}/event/doUpdate.do",
				data: JSON.stringify(eventData),
				contentType: "application/json",
				success: function(result){
					if(null != result && result.msgId == "1"){
						console.log(result.msgContents);
						let flag = 1;
						resolve(flag);
					} else{
		                alert(result.msgId+"|"+result.msgContents);
		            }
		        }
			});//---ajax
		});//---promise
	}
		
	//---[이미지 수정]--------------------------
	function imgUpdate(flag){
		return new Promise(function(resolve, reject) {
			console.log(flag);
			
			const form = $("form")[0];
	        let formData = new FormData(form);

        	formData.append("images[]", transferFile);
	        console.log(transferFile);

			$.ajax({
				type: "POST",
				url: "${context}/img/doUpdate.do",
				data: formData,
				processData: false,
				contentType: false,
				success: function(result){
					if(null != result && result.msgId == "2"){
						//---등록 성공시
		                console.log(result.msgId + "|" + result.msgContents);
		                flag += 1;
		                resolve();
					} else{
		                alert(result.msgId+"|"+result.msgContents);
		            }
				}
			});//---ajax
		});//---promise
	}

	//---[수정 성공시]----------------
	function successFunction(){
		alert("이벤트 수정을 성공했습니다.");
		moveToList();
		return false;
	}
	
	//---[수정시]-----------------------
	function errorFunction(){
		alert("에러가 발생했습니다.");
		return false;
	}
	
	
	//---[redirect]-------------------------------
	function moveToList(){
		let addr = "event_view.do?eventSeq=" + ${event.eventSeq}; 
		window.location.href=addr;
	}
	

	//---[영화 검색]-----------------------------------------------------
	$("#search_movie").on("click",function(){
			//$(document).find('#selected_seq').val($(this).val());
			window.open("movieInfo/movie_info.do", "window" ,"width=800 height=500");
	});
	

	
	//---[이미지 드래그 앤 드롭]--------------------------------------
	$('.flex-container')
	.on("dragover", dragOver)
	.on("dragleave", dragOver)
	.on("drop", uploadFiles);
	
	function dragOver(e){
		//현재 이벤트가 상위 DOM으로 전파되지 않도록 중단
		e.stopPropagation();

		//현재 이벤트의 기본 동장 중단
		e.preventDefault();

		//시각적 효과
		if (e.type == "dragover") {
			$(e.target).css({
				"background-color": "#eee",
				"outline-offset": "-30px"
			});
			$('.flex_item').css({
				"background-color": "#eee",
			});
			
		} else {
			$(e.target).css({
				"background-color": "white",
				"outline-offset": "0px"
			});
			$('.flex_item').css({
				"background-color": "white"
			});
		}
	}

	//이미지 드롭시
	function uploadFiles(e){
		e.stopPropagation();
		e.preventDefault();

		//시각적 효과
		dragOver(e);

		e.dataTransfer = e.originalEvent.dataTransfer;
		let files = e.target.files || e.dataTransfer.files;

		// 이미지 미리보기
		checkImgAndPreview(files);
	}
	
	
	
	//---[이미지 미리보기]--------------------------------------------
		function imgPreview(files){
			let getFile = files;
			let image = document.getElementById('img_area_img');
			image.setAttribute("class", "img-fluid");

			// FileReader 객체 생성
			let reader = new FileReader();
			
			// FileReader onload 시 이벤트 발생
			reader.onload = (function(file) {
				return function (e) {
					file.src = e.target.result;
				}
			})(image)
			
			if(getFile){
				reader.readAsDataURL(getFile[0]);
				transferFile = getFile[0];
			}
		}
	
	//---[파일 피커에서 이미지 미리보기]----------------------------------------
	imgPicker.addEventListener('change', function(e){
		let getFile = e.target.files;
		checkImgAndPreview(getFile);
	})
	
	//---[이미지 타입체크]----------------------------------------------------
	function checkImgAndPreview(files){
		for(let i = 0; i < files.length; i++){
			if (!files[i].type.startsWith('image/')){
				alert("이미지 파일을 업로드해 주세요");
				return;
			} else {
				imgPreview(files);
				console.log("preview");
				$("#img_preview").css({
					"outline":"0px"
				});
			}
		}
	}
	
	//---[datetime picker]----------------------------------------------
    // Create start date
    let start = new Date(),
        prevDay,
        startHours = 5;

    // 05:00 AM 부터
    start.setHours(5);
    start.setMinutes(0);

    $('#target_dt').datepicker({
        timepicker: true,
        language: 'en',
        startDate: start,
        minHours: startHours,
        maxHours: 24,
        onSelect: function (fd, d, picker) {
            
            // Do nothing if selection was cleared
            if (!d) return;

            var day = d.getDay();

            // Trigger only if date is changed
            if (prevDay != undefined && prevDay == day) {
                return;
            }

			targetDt = d.toISOString().split('T')[0]+' '+d.toTimeString().split(' ')[0];
            console.log(targetDt);
        },
		
    	dateFormat: 'yyyy-mm-dd',
    	timeFormat: 'hh:ii AA'
       	
    })

	</script>
<%@ include file="cmn/footer2.jsp" %>
