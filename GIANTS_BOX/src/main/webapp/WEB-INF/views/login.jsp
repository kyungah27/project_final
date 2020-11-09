<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>

    <main class="page login-page" style="padding-top: 65px;">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-primary">Log In</h2>
                </div>
                <form>
                    <div class="form-group"><label for="email">ID</label><input class="form-control item" type="email" id="text"></div>
                    <div class="form-group"><label for="password">Password</label><input class="form-control" type="password" id="password"></div>
                    <div class="form-group">
                        <div class="form-check"><input class="form-check-input" type="checkbox" id="checkbox"><label class="form-check-label" for="checkbox">Remember me</label></div>
                    </div><button class="btn btn-primary btn-block" type="submit">Log In</button></form>
            </div>
        </section>
    </main>
<%@ include file="cmn/footer.jsp" %>