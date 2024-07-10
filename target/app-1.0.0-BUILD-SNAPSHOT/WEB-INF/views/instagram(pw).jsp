<%--
  Created by IntelliJ IDEA.
  User: 나상민
  Date: 2024-06-20
  Time: 오후 9:53
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

    <link rel="stylesheet" href="<c:url value='/css/instagram(pw).css'/>">

    <script src="<c:url value='/js/instagram(pw).js'/>"></script>
</head>
<body>
<div id="wrap"  class="contents_area">
    <div class="logo"></div>
    <div class="desc">비밀번호를 찾기위해 정보를 입력해 주세요!</div>
    <div class="error" id="error" ></div>
    <form action="<c:url value='/findPW'/>" method="post"  class="form" onsubmit="return register_check()">

        <input type="text" placeholder="아이디(닉네임)" class="id" id="id" name="user_id" value="${param.user_id}" ${param.mode=="true"?"readonly":""}>
        <input type="text" placeholder="성명" class="name" name="user_name" id="name" value="${param.user_name}" ${param.mode=="true"?"readonly":""}>
        <input type="text" placeholder="전화번호(숫자만 입력)" class="pone" name="ph_num" id="pone" value="${param.ph_num}" ${param.mode=="true"?"readonly":""}>
        <!-- 정보확인 안했을때는 password id값 지우고이랑 display none 유지 -->


        <c:if test="${not empty param.msg1}">
            <input type="password" placeholder="비밀번호" class="password" id = "password"  name="user_pw"  style = "display: block">
            <%--        <input type="password" placeholder="비밀번호" class="password" id = "${find_user_id == null ? " " : "password"}" name="user_pw"  style = "display: ${find_user_id == null ? "none" : "block"}">--%>

            <%--        <input type="password" placeholder="비밀번호확인" class="pw_chk" id="pw_chk" style = "display: ${find_user_id == null ? "none" : "block"}">--%>
            <input type="password" placeholder="비밀번호확인" class="pw_chk" id="pw_chk" style = "display: block">
        </c:if>

        <button class="update">정보 확인하기</button>
    </form>

    <div class="getid">계정이 있으신가요? <span><a href="/login">로그인하기</a></span></div>

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


</body>
<script>
    $(document).ready(function(){
    })
</script>
</html>