<%--
/**
	Class Name:
	Description:
	Modification information
	
	수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2020. 9. 18        최초작성 
    
    author eclass 개발팀
    since 2020.05
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>부트스트랩_form_template</title>
    <%-- <link rel="shortcut icon" type="image/x-icon" href="${context}/resources/img/favicon.ico" > --%> 
    <!-- 부트스트랩 -->
    <%-- <link href="${context}/resources/css/bootstrap.min.css" rel="stylesheet"> --%>
    <!-- <link href="/EJDBC/css/layout.css" rel="stylesheet"> -->

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->


	<style type="text/css">
.flex_container {
	display: flex;
	justify-content: flex-start;
	max-width: 100%;
	flex-wrap: wrap;
	align-items: center;
}

.flex_item {
	flex: 0 1 auto;
	margin: 5px;
}

.btn_img_picker {
	width: 100px;
	background-color: #f8585b;
	border: none;
	color: #fff;
	padding: 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 4px;
	cursor: pointer;
	border-radius:10px;
}


</style>
	
  </head>
<body>
<div id="wrap">
<%-- 	<%@include  file="/cmn/inc/header.jsp" %> --%>
	<section>
		<!-- container -->
		<div class="container">
			<!-- 제목 -->
			<div class="page-header">
				<h2>파일 등록</h2>
			</div>
			<!--// 제목 -->
			
			<!-- 이미지 업로드 -->
			<input type="file" id="image_picker" name="images[]" style="display:none;" accept="image/jpg, image/png, image/jpeg, image/gif" onchange="preview(this.files);" multiple/>
			<label class="btn_img_picker" for="image_picker">파일 선택</label>
			
			
			<form class="form-horizontal" id="save_frm" action="${context}/img/doInsert.do" method="post" enctype="multipart/form-data">
				<input type="button" class="btn btn-primary btn-sm" onclick="javascript:uploadImg()" value="등록"/>
				<div id="img_preview" class="flex_container" >
				</div>
			</form>
			<!-- //이미지 업로드 -->
			
		</div>
		<!--// container -->
	</section>
<%--     <%@include  file="/cmn/inc/footer.jsp" %>	 --%>
</div>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>   
    
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <%-- <script src="${context}/resources/js/bootstrap.min.js"></script> --%>
    
    <!-- javascript -->
    <script type="text/javascript">

	    //모든 컨트롤(element)가 로딩이 완료되면.
		$(document).ready(function(){   
			console.log("document ready"); 

		});//document ready   

		
		var imgArr = [];
		var idx;
		
		// onchange 이벤트
		function preview(files){
			const target = document.getElementsByName('images[]');
			Array.prototype.push.apply(imgArr, target[0].files);

			for(let i = 0; i < files.length; i++){
				const file = files[i];
				

				if (!file.type.startsWith('image/')){
					 continue;
				};


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
					a.setAttribute("onclick", "javascript:remove(this)");
					
					const a_txt = document.createTextNode("X");
					a.appendChild(a_txt);
					
					flexDiv.appendChild(img);
					flexDiv.appendChild(a);

					document.querySelector("div#img_preview")
								.appendChild(flexDiv);

					flexDiv.setAttribute("class", "flex_item");
				};

				//console.log(file);
				reader.readAsDataURL(file);
			}
		}


		
		function remove(idx){
			let index;
			let elements = document.getElementsByName(idx.name);

			for (let i = 0; i < elements.length; i++){
				if(elements[i]==idx){
					//console.log(i+"번째");
					//console.log(imgArr);

					let div = elements[i].parentNode;
					let divParent = div.parentNode;
					divParent.removeChild(div);
					
					imgArr.splice(i, 1);
				}
			}
		}



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

			$.ajax({
				type: "POST",
				url: "${context}/img/doInsert.do",
				data: formData,
				processData: false,
				contentType: false,
				success: function(data){
					alert("이미지가 등록되었습니다.");
				},
				err: function(err){
					alert(err.status);
				}

			});
		}
		
		</script>
    
  </body>
</html>