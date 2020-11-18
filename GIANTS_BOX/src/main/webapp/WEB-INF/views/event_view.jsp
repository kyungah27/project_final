<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>
   <main class="page"  style="padding-top: 65px;">
        <section class="clean-block clean-product dark">
            <div class="container">
                <div class="block-heading">
                    <p>${eventVO.regDt}</p>
                    <h2 class="text-primary">${eventVO.eventNm}</h2>
                    <p>주최자</p>
                    <strong>${eventVO.regId}</strong>
                     <input type="hidden" name="movieCd"     id="movieCd"  value="" />
                </div>
                <div class="block-content">
                    <div class="product-info">
                        <div class="row">
                            <div class="col-lg-7 col-md-12">
                                <img src="${context}/img/${imgSeq}.do" class="img-fluid" />
                            </div>
                            <div class="col-lg-5">
                                <div class="info">
                                    <div>
                                        <h3 class="mt-3">${eventVO.eventNm}</h3>
                                    </div>
                                    <hr/>
                                    <div class="d-flex">
                                        <i class="fa fa-calendar p-2"></i>
                                        <fmt:parseDate var="targetParseDate" pattern="yyyy-MM-dd HH:mm:ss" value="${eventVO.targetDt}" />
                                        <fmt:formatDate var="targetFormatDate" pattern="yyyy년 MM월 dd일 HH시 mm분" value="${targetParseDate}"/>
                                        
                                        <p class="p-1">${targetFormatDate}<br/></p>
                                    </div>
                                    <div class="d-flex">
                                        <fmt:parseDate var="startParseDate" pattern="yyyy-MM-dd HH:mm:ss" value="${eventVO.startDt}" />
                                        <fmt:formatDate var="startFormatDate" pattern="yyyy/MM/dd" value="${startParseDate}"/>
                                        <fmt:parseDate var="endParseDate" pattern="yyyy-MM-dd HH:mm:ss" value="${eventVO.endDt}" />
                                        <fmt:formatDate var="endFormatDate" pattern="yyyy/MM/dd" value="${endParseDate}"/>
                                         <p class="p-1"><small>[모집기한] ${startFormatDate} ~ ${endFormatDate}</small></p> 
                                    </div>
                                    <hr class="mt-0"/>
                                    <div class="d-flex">
                                        <i class="fa fa-map-marker p-2"></i>
                                        <p class="p-1">${eventVO.location}</p>
                                    </div>
                                    <hr class="mt-0"/>
                                    <div class="d-flex mb-3">
                                        <i class="fa fa-film p-2"></i>
                                        <div class="p-1" id="movie_text">
                                            <h5><strong id="top_name">도굴</strong></h5>
                                            <strong>감독&nbsp;</strong>강대규<br>
                                            <strong>출연 </strong>성동일, 하지원, 김희원 등<br>
                                            <strong>장르</strong>&nbsp;드라마<br>
                                        </div>
                                    </div>
                                    <div id="join_btn_field">
                                    	<button class="btn btn-primary btn-block btn-sm" type="button" id="doJoin"  >이벤트 참여하기</button>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="product-info">
                        <div>
                            <ul class="nav nav-tabs" id="myTab">
                                <li class="nav-item"><a class="nav-link active" role="tab" data-toggle="tab" id="description-tab" href="#description">이벤트설명</a></li>
                                 <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" id="comments-tab" href="#comments">댓글</a></li>
                                <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" id="photos-tabs" href="#photos">사진</a></li>
                                <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" id="reviews-tab" href="#reviews">후기</a></li>
                            </ul>
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane active fade show description" role="tabpanel" id="description">
                                    
                                    <h3>이 영화 함께 봐요!</h3><br/>
                                    <div class="row">
                            	<div class="col-lg-3">
                                    <img id ="movie_poster" class="rounded img-fluid" src="">
                            </div>
                            
                            <div class="col-lg-9">
                                
                                <h3 class="mt-2 text-primary" id = "movie_name">영화 정보가 등록되어있지 않아요!</h3>
                                <p id="movie_plot">영화정보를 등록해 주세요!</p>
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
                                            <h3>참석자(<strong>${joinCount }</strong>)</h3>
                                        </div>
                                        
                            			
                                        <div class="row justify-content-center" id="join_list">   
                                            
                                        </div>
                                        <div class="row justify-content-end mr-auto mt-2">
                                            <a href="#">더보기</a>
                                        </div>
                                    </div>
                                    <!-- //이벤트 참여자 목록 작업 필요 -->
                                </div>
                                
                                <!-- photoList -->
                           
                                <div class="tab-pane fade show photos" role="tabpanel" id="photos" style="display:hidden">
                                	<!-- photo write -->
									<div id="photo_insert_frm">
										<div class="input-group align-items-center flex-wrap my-3">
											<div class="custom-file">
												<input type="file" name="images[]" class="custom-file-input" aria-describedby="photo_input" id="image_picker" accept="image/jpg, image/png, image/jpeg, image/gif" onchange="preview(this.files);" multiple="">
											    <label class="custom-file-label" for="image_picker">파일선택</label>
											</div>
											<div class="input-group-append align-items-center flex-wrap">
												<button type="button" class="btn btn-outline-secondary" id="photo_input" onclick="javascript:uploadImg()">등록</button>
												<div class="ml-3 ml-xm-1">
													<strong id="img_totalCnt">0</strong>개 이미지를 등록합니다.
												</div>
											</div>
										</div>
										<form class="form-horizontal" id="save_frm" action="${context}/img/doInsert.do" method="post" enctype="multipart/form-data">
											<div id="img_preview" class="flex-container justify-content-start" style="overflow-y: scroll; height: 50%">
												<p id="img_area_txt" class="m-auto">Drag & Drop<br><small>한번에 등록할 수 있는 이미지 수는 20개를 초과할 수 없습니다.</small></p>
											</div>
										</form>
	                               </div>
	                               <!-- //photo write -->

                                   <div class="row mt-4 mb-4">
	                                   	<ul id = "img_list" class="row" style="list-style:none;"></ul>
                                	</div>
                                    <div class="row">
                                        <button class="btn btn-outline-primary btn-block" id="photo-more-btn" type="button">더보기</button>
                                    </div>
                                </div>
                                
                                 
                                <div class="tab-pane fade show" role="tabpanel" id="comments">
                                 <%@include file="comment/comment_view.jsp" %>
                                   <!--  <div class="reviews">
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
                                    </div> -->
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
                            <div class="row justify-content-center" id="event_field" >
          						<!--  추천 이벤트 append-field  -->
            				</div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
    
    <%@ include file="cmn/footer1.jsp" %>
     
     
     <script type="text/javascript">
			
 	$(document).ready(function() {

		drawJoinBtn();
		doSelectList(${eventVO.eventSeq});
		searchToIdKM("${movieSeq}" , "${movieId}");

		let today = new Date(); 
		let year = today.getFullYear(); // 년도
		let month = today.getMonth() + 1;  // 월
		let date = today.getDate()-2;  // 날짜
		var dateForEvent = year+"-"+month+"-"+date;
		evnetSelectList("${eventVO.genre}",dateForEvent);
		
	});


	//------------------------------------[photo]-------------------------------------------------------
	let photoPgNum = 1;
	let maxImgSeq;

	//---[사진 탭 클릭]
	$("#photos-tabs").on("click", photoList);
	function photoList(){
		//---회원 확인 후 사진 등록 폼 그리기
		drawPhotoInsert();

		//---이미지 목록 지우기
		const imgList = document.getElementById("img_list");
		while (imgList.firstChild){
			imgList.removeChild(imgList.lastChild);
		}
		
		let imgListBtn = document.getElementById("photo-more-btn");
		imgListBtn.removeAttribute("style");

		//---파람 초기화
		photoPgNum = 1;
		maxImgSeq;

		//---이미지 목록 가져오기
		fetchImgList(photoPgNum, maxImgSeq);
	}; 

	//---[사진 더보기 클릭]
	$("#photo-more-btn").on('click', morePhotos);
	function morePhotos(){
		photoPgNum = ++photoPgNum;

		console.log("photoPgNum:" + photoPgNum);
		console.log("maxImgSeq:" + maxImgSeq);
		
		fetchImgList(photoPgNum, maxImgSeq);
	};

	//---[사진 목록 불러오기]
	function fetchImgList(num, maxImgSeq){
		console.log("first photo list()");
		console.log("photoPgNum: " + num);
		console.log("maxImgSeq: " + maxImgSeq);

		let startNo = $("#img_list li").last().data("no") || 0;
		console.log("startNo: " + startNo);

		$.ajax({
			url: "${context}/img/doSelectList.do",
			data: {
				eventSeq : ${eventVO.eventSeq},
				maxImgSeq : maxImgSeq,
				photoPgNum : num
				},
			type: "GET",
			dataType: "json",
			success: function(result){
				maxImgSeq = result.fetchedMaxImgSeq;


				if(maxImgSeq != "0") {
					let dataList = result.list;
					let dataLen = dataList.length;

					
					console.log("maxImgSeq: " + maxImgSeq);
	                
	                $.each(dataList, function(index, vo) {
	                	renderList(false, vo);
	                });

	                if (dataLen < 9){
						let imgListBtn = document.getElementById("photo-more-btn");
						imgListBtn.setAttribute("style","display: none"); 
					};
				} else {
					let imgListBtn = document.getElementById("photo-more-btn");
					imgListBtn.setAttribute("style","display: none"); 

					html = '<p>등록된 사진이 없습니다.</p>';
					$("#img_list").append(html);
				}
               
			}//---END success
		});//---END ajax
	}//---END firstPhotoList


	

	//---[사진 목록 렌더링]
	let renderList = function(mode, vo){
		let context = '<c:out value="${context}" />';
		let html =
			"<li data-no='" + vo.num + "' class='col-md-6 col-lg-4 item mt-3'>" +
			"<a class='lightbox' href='#b' onclick='javascript:zoom(event)'><img class='img-thumbnail img-fluid image' src=" +
			context + "/img/" + vo.imgSeq + ".do /></a><p class='text-right'><small>"
			+ vo.imgVO.regId + " | " + vo.imgVO.regDt + "</small></p>";
		if(mode) {
			$("#img_list").prepend(html);
		} else {
			$("#img_list").append(html);
		}
	}//---END renderList


	//---[사진 zoom flag 작업]
	let zoomFlag = 0;
	function zoom(event) {
		console.log("zoom");
		let thisImg = event.target;
		let currWidth = thisImg.clientWidth;

		zoomFlag++;
		console.log("zoomFlag : " + zoomFlag);

		if (zoomFlag == 1){
			console.log("zoomFlag = 1");
			zoomImg(thisImg, currWidth);
		} else if($(event.target).hasClass("opened")){
			closeImg(thisImg, currWidth);
			zoomFlag = 0;			
		} else{
			alert("열려있는 이미지를 먼저 닫아 주세요");
		}
	}
	

	function closeImg(thisImg, currWidth){
		console.log("closeImg()");
		thisImg.setAttribute("class","img-thumbnail img-fluid image");
		thisImg.removeAttribute("style");
		thisImg.style.width = (currWidth - 400) + "px";
	}

	function zoomImg(thisImg, currWidth){
		console.log("zoomImg()");
		thisImg.setAttribute("class", "opened");
		thisImg.setAttribute("style", "z-index:2");
		thisImg.style.position = "fixed";
		thisImg.style.top = "25%";
		thisImg.style.left = "30%";
		thisImg.style.width = (currWidth + 400) + "px";
	}


	

	//---[멤버 여부에 따라 photo 폼 나타나기/숨기기]
	let photoFrm = document.getElementById("photo_insert_frm");
	
	function drawPhotoInsert(){
		if (${joinCheck}==1){
			photoFrm.removeAttribute("style");
		} else {
			photoFrm.setAttribute("style", "display: none");
		}
	}

	//---[Drag & Drop 텍스트 나타내기]
	function imgAreaTxt(){
		let imgAreaTxt = $("#img_area_txt");
		if(!Array.isArray(imgArr) || imgArr.length <= 0){
			console.log("없음");
			imgAreaTxt.css({
				"display": "",
				"margin": "0 auto"
			});
		} else {
			imgAreaTxt.css({
				"display": "none"
			});
		}
	}

	//---[drag over]
	var imgArr = [];
	var idx;

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

	//---[Drag & Drop시 미리보기] 
	function uploadFiles(e){
		e.stopPropagation();
		e.preventDefault();

		//시각적 효과
		dragOver(e);

		e.dataTransfer = e.originalEvent.dataTransfer;
		let files = e.target.files || e.dataTransfer.files;
		console.log(files);

		//이미지 타입체크
		for(let i = 0; i < files.length; i++){
			if (!files[i].type.startsWith('image/')){
				alert("이미지 파일을 업로드해 주세요");
				return;
			}
		}


		// 이미지 미리보기
		preview(files);
		imgAreaTxt()
	}
	
	//--- [이미지 업로드하기]
	function uploadImg(){
		//console.log(imgArr);
		
		let imgLen = imgArr.length;
		
		if(imgLen <= 0){
			return;				
		}

		if(!confirm(imgLen + "개의 이미지를 등록하시겠습니까?")){
			return;
		} 

		const saveForm = document.getElementById("save_frm");
		const formData = new FormData(saveForm);

		for(let i = 0; i < imgLen; i++){
			formData.append("images[]", imgArr[i]);
		}

		formData.append("eventSeq", ${eventVO.eventSeq});
		formData.append("isThumbnail", 'n');

		$.ajax({
			type: "POST",
			url: "${context}/img/doInsert.do",
			data: formData,
			processData: false,
			contentType: false,
			success: function(data){
				if(null != data && data.msgId==imgLen){
	                alert(data.msgContents);

	              //---[이미지 미리보기 영역 초기화]
	                let previewImgs = $(".photo-del");
	                console.log("previewImgs");
	                console.log(previewImgs);
	                
	        		for (let i = 0; i < previewImgs.length; i++){

	        			let div = previewImgs[i].parentNode;
	        			div.removeChild(previewImgs[i]);
	        			imgArr.splice(i, 1);
	        		}
	        		
	        		//---[이미지 배열 초기화]
	        		imgArr.length = 0;
	        		imgAreaTxt();
	        		count();

	        		//---[리스트 다시 뿌리기]
					photoList();
	                
				} else{
	                alert(data.msgId+"|"+data.msgContents);
	            }
			},
			err: function(err){
				alert(err.status);
			}
		});
	}



	
	
	//--- [이미지 미리보기]
	function preview(files){
		let filesLen = files.length;
		
		// 최대 이미지 등록 제한 수 체크
		if(imgArr.length > 20 || filesLen > 20) {
			alert("20개를 초과하는 이미지는 등록할 수 없습니다.");
			return;
		}

		Array.prototype.push.apply(imgArr, files);

		for(let i = 0; i < filesLen; i++){
			const file = files[i];

			if (!file.type.startsWith('image/')){
				alert("이미지 파일을 업로드해 주세요");
				return;
			};

			// FileReader 객체 생성
			let reader = new FileReader();
			
			// FileReader onload 시 이벤트 발생
			reader.onload = function(file) {
				const img = document.createElement("img");
				img.setAttribute("src", this.result);
				img.setAttribute("height", "150px");
				img.setAttribute("class", "position-relative");

				let flexDiv = document.createElement("div");

				let a = document.createElement("a");
				a.setAttribute("name", "removeImg");
				a.setAttribute("onclick", "javascript:remove(this)");
				a.setAttribute("href", "#a");
					
				let aDelDiv = document.createElement("div");
				let i = document.createElement("i");
				i.className="fa fa-times position-relative";
				i.setAttribute("style", "left: -25px; top: -55px; font-size: 22px");
				a.appendChild(i);
				
				flexDiv.appendChild(img);
				flexDiv.appendChild(a);

				document.querySelector("div#img_preview")
							.appendChild(flexDiv);
				flexDiv.className = "flex-item text-right photo-del"
			};

			reader.readAsDataURL(file);
			console.log("imgArr: " + imgArr);


			imgAreaTxt();
			count();
		}
	}

	//--- [이미지 갯수 구하기]
	function count() {
		let cnt = document.getElementById("img_totalCnt");
		console.log(cnt);
		cnt.textContent = imgArr.length;
	}

	//--- [목록에서 이미지 제거]
	function remove(idx){
		console.log(idx);
		let index;
		let elements = document.getElementsByName(idx.name);
		console.log(elements);

		for (let i = 0; i < elements.length; i++){
			if(elements[i]==idx){

				let div = elements[i].parentNode;
				let divParent = div.parentNode;
				divParent.removeChild(div);
				
				imgArr.splice(i, 1);
			}
		}

		//console.log("imgArr: "+imgArr);
		imgAreaTxt();
		count();
	}



	//---------------------------------------------------------- 영화정보 처리   -----------------------------------
	$("#doJoin").on("click", function(e) {
		  $.ajax({
			    type:"POST",
			    url:"${context}/join/doInsert.do",
			    dataType:"html", 
			    data:{"eventSeq":	${eventVO.eventSeq},   
			    	  "memberSeq":	${sessionScope.user.seq}+"",  
			    	  "priority" :  0  						   
			    },
			    success:function(data){ //성공
			       var obj = JSON.parse(data);
			       if(obj.msgId == 1){
						alert(obj.msgContents);
						doSelectList(${eventVO.eventSeq});
						location.reload();
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

	function evnetSelectList(genres ,currentDate){
		  
		  $.ajax({
			    type:"GET",
			    url:"${context}/event/doSelectList.do",
			    dataType:"json", 
			    data:{
			 	  "searchDate":	currentDate,
			 	  "genreStr" : genres,
			 	  "pageNum"  : 1   	
			    },
			    success:function(data){ //성공
			       $("#event_field").empty();	
			       $.each(data, function(i, value) {
			    	let thumbnailUrl = "${context}/img/event/" + value.eventSeq + ".do";
			    	var html = "";
			    	if(i == 3) return false;
				    html += '<div class="col-sm-6 col-lg-4">';
				    html += '<div class="card clean-card text-center"><img class="card-img-top w-100 d-block" src='+thumbnailUrl+'>';
				    html += '<div class="card-body info">';
				    html += '<p class="text-left card-text"><strong>'+value.targetDt+'</strong></p>'
				    html += '<h4 class="text-truncate card-title"><a href="${context}/event_view.do?eventSeq='+value.eventSeq+'">'+value.eventNm+'</a></h4>';
				    html += '<p class="card-text">'+value.content.substring(1, 30)+'..</p>';
				    html += '<div class="icons"><a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i class="icon-social-instagram"></i></a><a href="#"><i class="icon-social-twitter"></i></a><small>12명 참여</small></div>';
				    html +='</div></div></div>';      
				    $("#event_field").append(html);	    		
				   });
				   
			      	
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
			html += '<div class="col-sm-6 col-lg-3"><div class="card clean-card text-center">';
			
			if(value.priority ==1){
				html += '<img class="card-img-top w-100 d-block" src="${context}/resources/img/avatars/avatar_host.jpg">';  //이미지
				html += '<div class="card-body">   <h4 class="card-title text-truncate">'+value.name+'(주최자)</h4>';
			}else{
				html += '<img class="card-img-top w-100 d-block" src="${context}/resources/img/avatars/avatar_guest.jpg">';  //이미지
				html += '<div class="card-body">   <h4 class="card-title text-truncate">'+value.name+'</h4>';			
			}
            html += '<p class="card-text text-truncate">'+value.userId+'</p></div></div></div>';      		
		});
		$("#join_list").append(html);				  
	}

	//information by 한국영화데이터 베이스 (https://www.kmdb.or.kr)
	function searchToIdKM(movieSeq, movieId) {
		var key = 'HAE2WH3Y4F7C3N2R6Z1Y';
		var url = 'http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey='+key+'&movieSeq='+movieSeq+'&movieId='+movieId;
		//url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
		$.ajax({
			url : url,
			type : 'GET',
			dataType : 'html',
			success : function(s) {
				var item = JSON.parse(s);
				$.each(item.Data, function(i,data) {

					$.each(data.Result, function(i,result) {

						var title = result.title;
						title = title.replace(/!HS/gi, " ");
						title = title.replace(/!HE/gi, " ");									
						//감독
						var director = result.directors.director[0].directorNm;
						//출연
						var actors = "";
						$.each(result.actors.actor, function(i,actor) {
							if(i == 3) return false;
							
							actors += actor.actorNm+"  ";
						})							
						//장르
						var genre = result.genre;								
						//코드
						var DOCID = result.DOCID;
						//포스터 url
						var poster = result.posters;
						poster = poster.split("|");
						
						var posterUrl = poster[0];
						if(posterUrl.length < 1){
							posterUrl = "${context}/resources/img/logo.png"
						}
						// 줄거리
						var plot = result.plots.plot[0].plotText;	
						var html = '';		
						$("#movie_name").text(title);
						$("#top_name").text(title);
						$("#movie_plot").text(plot);
						$("#movie_poster").attr("src", posterUrl);

						
					}) 
				})  			
			},
			error : function(xhr, status, error) {
				alert("error:" + error);
			},
			complete : function(data) {
			}
		})
	}

	function drawJoinBtn(){
		if(${sessionScope.user.seq}+"" == ""){
			$("#join_btn_field").empty();
			$("#join_btn_field").append('<button class="btn btn-primary btn-block btn-sm" type="button"  onclick="location.href= &#39;${context}/login.do&#39; " >참여할려면 로그인 해주세요!</button>')
		}else if( ${joinCheck} == 1){
			$("#join_btn_field").empty();
			$("#join_btn_field").append('<button class="btn btn-primary btn-block btn-sm" type="button" disabled="" >이미 참여하셨습니다.</button>')
		}
	}
	
 	


     </script>
    

<!-- 자바스크립트 자리 -->
<%@ include file="cmn/footer2.jsp" %>
