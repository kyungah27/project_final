<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="cmn/header.jsp" %>


    <main class="page registration-page" style="padding-top: 65px;">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-primary">Sign up</h2>
                </div>
                <form>
                    <div class="form-group"><label for="id">Id</label><input class="form-control item" type="text" id="id"></div>
                    <div class="form-group"><label for="name">Name</label><input class="form-control item" type="text" id="name"></div>
                    <div class="form-group"><label for="password">Password</label><input class="form-control item" type="password" id="password"></div>
                    <div class="form-group"><label for="email">Email</label><input class="form-control item" type="email" id="email">
                    <div class="form-group"><label for="phone">Phone</label><input class="form-control item" type="text" id="phone"></div>
                    <div class="form-group"><label for="birthday">Birthday</label><input class="form-control item" type="text" id="birthday"></div>
                    </div><button class="btn btn-primary btn-block" type="submit">Sign Up</button></form>
            </div>
        </section>
    </main>


<%@ include file="cmn/footer.jsp" %>