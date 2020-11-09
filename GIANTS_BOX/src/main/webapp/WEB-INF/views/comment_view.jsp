<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>comment</title>
</head>
<body>
	<div class="container">
		<label for="content">comment</label>
		<form name="commentInsertForm">
			<div class="input-group">
				<input type="text" class="form-control" id="content" name="content"
					placeholder="내용을 입력하세요."> <span class="input-group-btn">
					<buttn class="btn btn-default" type="button"
						name="commentInsertBtn">등록 
				</span>
			</div>
		</form>
	</div>
	<div class="container">
		<div class="commentList"></div>
	</div>
</body>
</html>
