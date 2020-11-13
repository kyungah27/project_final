<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>

   <main class="page"  style="padding-top: 65px;">

   
        <section class="clean-block clean-product dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-primary"><strong id="user_id">${user.userId}</strong>님의 이벤트를 시작하세요.</h2>
                </div>
                <div class="block-content">
                    <form class="product-info" id="reg_frm">
                        <div class="row">
                        
                            <div class="col-lg-5 col-md-12 col-sm-12">
                                <div id="img_preview" class="flex-container justify-content-center">
									<p id="img_area_txt">Drag & Drop</p>
									<img id="img_area_img"></img>
								</div>
                                
                                <div class="custom-file mt-2 mb-3">
                                	<form id="img_frm" method="post" enctype="multipart/form-data">
	                                  <input type="file" class="custom-file-input" name="images[]" id="img_picker" accept="image/jpg, image/png, image/jpeg, image/gif"  />
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
                                    <input type='text' class="form-control" id="target_dt" placeholder="이벤트 일시" aria-label="target_dt" />
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
                                    <input type="text" class="form-control form-control" id="movie_code" placeholder="영화" aria-label="movie_info" readonly />
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
                        <button type="button" id="event_reg" class="btn btn-primary btn-block">이벤트 등록</button>
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

	let picker = document.querySelector("#img_picker");
	let preview = document.querySelector("#img_preview");
	let eventRegBtn = document.getElementById("event_reg");
	let transferFile = $("#img_picker")[0].files[0];

	//---[등록]----------------------------------------
	eventRegBtn.addEventListener("click", eventReg, false);
	
	function eventReg(){
		if(!confirm("등록하시겠습니까?")){
			console.log(transferFile);
			return;
		}

		//---[성공 여부]
		let flag = {
			aInternal: 0,
			aListener: function(val) {},
						set a(val) {
							this.aInternal = val;
							this.aListener(val);
						},
						get a(){
							return this.aInternal;
						},
						registerListener: function(listener){
											this.aListener = listener;
						}
		};

		//---[성공여부 listener]
		flag.registerListener(function(val) {
			if(flag.a==1){
				moveToList();
			}
		});

		//---[redirect]
		function moveToList(){
			window.location.href="event_view.do";
		}
				
		//---[img insert]
		const form = $("#img_frm")[0];
        const formData = new FormData(form);
        
        formData.append("images[]", transferFile);
        console.log(transferFile);

		$.ajax({
			type: "POST",
			url: "${context}/img/doInsert.do",
			data: formData,
			processData: false,
			contentType: false,
			success: function(data){
				if(null != data && data.msgId=="1"){
					//---이미지 등록 성공시
	                alert(data.msgContents);
	                flag.a += 1;
				} else{
	                alert(data.msgId+"|"+data.msgContents);
	            }
			},
			err: function(err){
				alert(err.status);
			}
		}); //---//[img insert]
		//---[redirect]
	}
	//---//[등록]----------------------------------------

	//---[영화 검색]-----------------------------------------------------
	$("#search_movie").on("click",function(){
			//$(document).find('#selected_seq').val($(this).val());
			window.open("movieInfo/movie_info.do", "window" ,"width=800 height=400");
	});
	//---//[영화 검색]-----------------------------------------------------
	













	
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
	//---//[드래그 앤 드롭]--------------------------------------
	
	//---[Drag & Drop 텍스트 나타내기 여부 결정]------------------------------------
		function imgAreaTxt(image){
			let imgAreaTxt = $("#img_area_txt");
			if(!image || image.length <= 0){
				console.log("없음");
				imgAreaTxt.css({
					"display": "",
					"margin": "0 auto"
				});
			} else {
				console.log("있음");
				imgAreaTxt.css({
					"display": "none"
				});
			}
		}
	//---//[Drag & Drop 텍스트 나타내기]------------------------------------
	
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
				imgAreaTxt(image);
				transferFile = getFile[0];
			}
		}
	//---//[이미지 미리보기]--------------------------------------------
	
	//---[파일 피커에서 이미지 미리보기]----------------------------------------
	picker.addEventListener('change', function(e){
		let getFile = e.target.files;
		checkImgAndPreview(getFile);
	})
	//---//[파일 피커에서 이미지 미리보기]----------------------------------------
	
	//---[이미지 타입체크]----------------------------------------------------
	function checkImgAndPreview(files){
		for(let i = 0; i < files.length; i++){
			if (!files[i].type.startsWith('image/')){
				alert("이미지 파일을 업로드해 주세요");
				return;
			} else {
				imgPreview(files);
			}
		}
	}
	//---//[이미지 타입체크]----------------------------------------------------
	
	
	
	
	
	
	
	
	//---[datetime picker]----------------------------------------------
    // Create start date
    var start = new Date(),
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
                //---picking 할때마다 date 값 받기------------
                console.log(fd);
                return;
            }
        },
		
    	dateFormat: 'yyyy-mm-dd',
    	timeFormat: 'hh:ii AA'
    })
    
    var date = parse('2016-04-18');
	function parse(str) {
	    var y = str.substr(0, 4);
	    var m = str.substr(4, 2);
	    var d = str.substr(6, 2);
	    return new Date(y, m-1, d);
	}
    //---//[datetime picker]---------------------------------------


	</script>
<%@ include file="cmn/footer2.jsp" %>
