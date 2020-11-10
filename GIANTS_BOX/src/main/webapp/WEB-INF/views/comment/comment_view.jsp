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
		<b>comment</b>
		<form name="commentInsertForm">
			<div class="input-group">
				<textarea style="resize: none;" rows="5" cols="80" name="contents"
					id="contents" class="form-control" placeholder="내용을 입력해주세요"></textarea>
				<br /> <input type="button" class="btn btn-primary btn-sm"
					value="등록" /> </span>

			</div>
		</form>
	</div>
	<div class="container">
		<div class="commentList"></div>
	</div>
</body>
</html>
