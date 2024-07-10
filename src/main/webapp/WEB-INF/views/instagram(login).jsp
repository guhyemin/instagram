<%--
  Created by IntelliJ IDEA.
  User: 나상민
  Date: 2024-06-20
  Time: 오후 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="logInOutLink" value="${ sessionScope.id==null ? '/login':'/logout' }" />
<c:set var="logInOutTxt" value="${ sessionScope.id==null ? '로그인':'로그아웃' }" />
<c:set var="userId" value="${sessionScope.id==null?'':sessionScope.id}" />



<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

    <link rel="stylesheet" href="<c:url value='/css/instagram(login).css'/>">

    <script src="<c:url value='/js/instagram(login).js'/>"></script>
</head>

<body>
<div id="wrap" class="contents_area">
    <div class="logo"></div>
    <div class="error" >${param.msg}</div>
    <form action="/login" method="post">
        <input type="text" placeholder="아이디를 입력해주세요" class="id" name="user_id" value="">
        <input type="password" placeholder="비밀번호를 입력해주세요" class="password" name="user_pw" value="">
        <button class="login">로그인</button>
    </form>
    <div class="orbox">
        <div class="orbox_line"></div>
        <div class="orbox_text">또는</div>
        <div class="orbox_line"></div>
    </div>
    <div class="facebook_box">
        <div class="facebook_icon"></div>
        <div class="facebook_text">Facebook으로 로그인</div>
    </div>
    <div class="loss_passwrad">비밀번호를 잊으셨나요? <span><a href="/findPwForm">비밀번호 찾기</a></span></div>
    <div class="getid">계정이 없으신가요? <span><a href="/register/join">가입하기</a></span></div>
    <div class="footer">
        <div class="footer_text">Meta</div>
        <div class="footer_text">소개</div>
        <div class="footer_text">블로그</div>
        <div class="footer_text">채용 정보</div>
        <div class="footer_text">도움말</div>
        <div class="footer_text">API</div>
        <div class="footer_text">약관</div>
        <div class="footer_text">위치</div>
    </div>
</div>

<script>
    $(document).ready(function(){

    })
</script>
</body>
</html>