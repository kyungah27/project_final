<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath }" />



<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Giants Box</title>
    
    <!-- favicon -->
    <link rel=" shortcut icon" href="${context}/resources/img/favicon.ico">
	<link rel="icon" href="${context}/resources/img/favicon.ico">
    <!-- //favicon -->
    
    <link rel="stylesheet" href="${context}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="${context}/resources/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="${context}/resources/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="${context}/resources/css/styles.min.css" rel="stylesheet" type="text/css">
    
     <!--calendar-->
    <link href="${context}/resources/css/datepicker.min.css" rel="stylesheet" type="text/css">
    <!--//calendar-->
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white d-flex d-sm-flex align-content-center clean-navbar" style="height: 65px;background-color: rgba(24,109,128,0.58);filter: brightness(100%);opacity: 1;">
        <div class="container-fluid">
        	<a href="${context}/main.do">
        	<img src="${context}/resources/img/logo.png" style="width: 174px;filter: blur(0px);"></a>
        	<button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1">
        	<span class="sr-only">Toggle navigation</span>
        	<span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                
                <c:set var="user" value="${user}" />
                <c:choose>
                    <c:when test="${!empty user}" >
	                    <li class="nav-item" role="presentation">
	                    	<a class="nav-link text-secondary active" href="${context}/event_list.do">explore</a>
	                    </li>
	                    <li class="nav-item" role="presentation">
	                    	<a class="nav-link text-secondary" href="${context}/my_event.do">my event</a>
	                    </li>
	                    <li class="nav-item" role="presentation">
	                    	<a class="nav-link text-secondary" href="${context}/account.do">my account</a>
	                    </li>
	                    <li class="nav-item" role="presentation">
	                    	<a class="nav-link text-secondary" href="${context}/logout.do">log out</a>
	                    </li>
                    </c:when>
                    <c:otherwise>
	                    <li class="nav-item" role="presentation">
	                    	<a class="nav-link text-secondary active" href="${context}/login.do">log in</a>
	                    </li>
	                    <li class="nav-item" role="presentation">
	                    	<a class="nav-link text-secondary" href="${context}/signup.do">sign up</a>
	                    </li>
                    </c:otherwise>
                </c:choose>    
                    
                    
                    
                    
                </ul>
        </div>
        </div>
    </nav>
