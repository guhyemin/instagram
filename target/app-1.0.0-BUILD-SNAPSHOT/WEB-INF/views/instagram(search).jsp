<%--
  Created by IntelliJ IDEA.
  User: 나상민
  Date: 2024-06-20
  Time: 오후 10:02
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
    <title>instagram</title>
    <script src=" https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="<c:url value='/js/instagram(h_f).js'/>"></script>

    <script src="<c:url value='/js/instagram(search).js'/>"></script>

    <link rel="stylesheet" href="<c:url value='/css/instagram(h_f).css'/>">

    <link rel="stylesheet" href="<c:url value='/css/instagram(search).css'/>">

</head>

<body>
<div id="wrap" class="contents_area">
    <div class="haeder">
        <div class="header_logo"><a href="/mainPage"></a></div>
        <div class="ham_btn">
            <div class="ham_line"></div>
            <div class="ham_line"></div>
            <div class="ham_line"></div>
        </div>
        <div class="hampan">
            <div class="ham_top">
                <div class="ham_logo"><a href="/mainPage"></a></div>
                <div class="ham_close">닫기</div>
            </div>
            <div class="ham_menu">
                <div class="ham_img">
                    <svg aria-label="홈" class="x1lliihq x1n2onr6 x5n08af" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>홈</title><path d="M22 23h-6.001a1 1 0 0 1-1-1v-5.455a2.997 2.997 0 1 0-5.993 0V22a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V11.543a1.002 1.002 0 0 1 .31-.724l10-9.543a1.001 1.001 0 0 1 1.38 0l10 9.543a1.002 1.002 0 0 1 .31.724V22a1 1 0 0 1-1 1Z"></path></svg>
                </div>
                <div class="ham_desc"><a href="/mainPage">홈</a></div>
            </div>
            <div class="ham_menu">
                <div class="ham_img">
                    <svg aria-label="검색" class="x1lliihq x1n2onr6 x5n08af" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>검색</title><path d="M19 10.5A8.5 8.5 0 1 1 10.5 2a8.5 8.5 0 0 1 8.5 8.5Z" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"></path><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="16.511" x2="22" y1="16.511" y2="22"></line></svg>
                </div>
                <div class="ham_desc"><a href="/searchForm">검색</a></div>
            </div>
            <div class="ham_menu">
                <div class="ham_img">
                    <svg aria-label="탐색 탭" class="x1lliihq x1n2onr6 x5n08af" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>탐색 탭</title><polygon fill="none" points="13.941 13.953 7.581 16.424 10.06 10.056 16.42 7.585 13.941 13.953" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"></polygon><polygon fill-rule="evenodd" points="10.06 10.056 13.949 13.945 7.581 16.424 10.06 10.056"></polygon><circle cx="12.001" cy="12.005" fill="none" r="10.5" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"></circle></svg>
                </div>
                <div class="ham_desc">탐색 탭</div>
            </div>
            <div class="ham_menu reels" >
                <div class="ham_img">
                    <svg aria-label="릴스" class="x1lliihq x1n2onr6 x5n08af" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>릴스</title><line fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="2" x1="2.049" x2="21.95" y1="7.002" y2="7.002"></line><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="13.504" x2="16.362" y1="2.001" y2="7.002"></line><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="7.207" x2="10.002" y1="2.11" y2="7.002"></line><path d="M2 12.001v3.449c0 2.849.698 4.006 1.606 4.945.94.908 2.098 1.607 4.946 1.607h6.896c2.848 0 4.006-.699 4.946-1.607.908-.939 1.606-2.096 1.606-4.945V8.552c0-2.848-.698-4.006-1.606-4.945C19.454 2.699 18.296 2 15.448 2H8.552c-2.848 0-4.006.699-4.946 1.607C2.698 4.546 2 5.704 2 8.552Z" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"></path><path d="M9.763 17.664a.908.908 0 0 1-.454-.787V11.63a.909.909 0 0 1 1.364-.788l4.545 2.624a.909.909 0 0 1 0 1.575l-4.545 2.624a.91.91 0 0 1-.91 0Z" fill-rule="evenodd"></path></svg>
                </div>
                <div class="ham_desc reels">릴스</div>
            </div>
            <div class="ham_menu">
                <div class="ham_img">
                    <svg aria-label="Direct" class="x1lliihq x1n2onr6 x5n08af" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>Direct</title><line fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="2" x1="22" x2="9.218" y1="3" y2="10.083"></line><polygon fill="none" points="11.698 20.334 22 3.001 2 3.001 9.218 10.084 11.698 20.334" stroke="currentColor" stroke-linejoin="round" stroke-width="2"></polygon></svg>
                </div>
                <div class="ham_desc">메세지</div>
            </div>
            <div class="ham_menu">
                <div class="ham_img">
                    <svg aria-label="알림" class="x1lliihq x1n2onr6 x5n08af" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>알림</title><path d="M16.792 3.904A4.989 4.989 0 0 1 21.5 9.122c0 3.072-2.652 4.959-5.197 7.222-2.512 2.243-3.865 3.469-4.303 3.752-.477-.309-2.143-1.823-4.303-3.752C5.141 14.072 2.5 12.167 2.5 9.122a4.989 4.989 0 0 1 4.708-5.218 4.21 4.21 0 0 1 3.675 1.941c.84 1.175.98 1.763 1.12 1.763s.278-.588 1.11-1.766a4.17 4.17 0 0 1 3.679-1.938m0-2a6.04 6.04 0 0 0-4.797 2.127 6.052 6.052 0 0 0-4.787-2.127A6.985 6.985 0 0 0 .5 9.122c0 3.61 2.55 5.827 5.015 7.97.283.246.569.494.853.747l1.027.918a44.998 44.998 0 0 0 3.518 3.018 2 2 0 0 0 2.174 0 45.263 45.263 0 0 0 3.626-3.115l.922-.824c.293-.26.59-.519.885-.774 2.334-2.025 4.98-4.32 4.98-7.94a6.985 6.985 0 0 0-6.708-7.218Z"></path></svg>
                </div>
                <div class="ham_desc">알림</div>
            </div>
            <div class="ham_menu">
                <div class="ham_img make_btn">
                    <svg aria-label="새로운 게시물" class="x1lliihq x1n2onr6 x5n08af" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>새로운 게시물</title><path d="M2 12v3.45c0 2.849.698 4.005 1.606 4.944.94.909 2.098 1.608 4.946 1.608h6.896c2.848 0 4.006-.7 4.946-1.608C21.302 19.455 22 18.3 22 15.45V8.552c0-2.849-.698-4.006-1.606-4.945C19.454 2.7 18.296 2 15.448 2H8.552c-2.848 0-4.006.699-4.946 1.607C2.698 4.547 2 5.703 2 8.552Z" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"></path><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="6.545" x2="17.455" y1="12.001" y2="12.001"></line><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="12.003" x2="12.003" y1="6.545" y2="17.455"></line></svg>
                </div>
                <div class="ham_desc make_btn"><a href="/write">만들기</a></div>
            </div>
            <div class="ham_menu">
                <div class="ham_img">
                    <svg class="login_icon MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="AccountCircleOutlinedIcon" style="font-size: 1.75rem;"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zM7.35 18.5C8.66 17.56 10.26 17 12 17s3.34.56 4.65 1.5c-1.31.94-2.91 1.5-4.65 1.5s-3.34-.56-4.65-1.5zm10.79-1.38C16.45 15.8 14.32 15 12 15s-4.45.8-6.14 2.12C4.7 15.73 4 13.95 4 12c0-4.42 3.58-8 8-8s8 3.58 8 8c0 1.95-.7 3.73-1.86 5.12z"></path><path d="M12 6c-1.93 0-3.5 1.57-3.5 3.5S10.07 13 12 13s3.5-1.57 3.5-3.5S13.93 6 12 6zm0 5c-.83 0-1.5-.67-1.5-1.5S11.17 8 12 8s1.5.67 1.5 1.5S12.83 11 12 11z"></path></svg>
                </div>
                <div class="ham_desc"><a href="/myPage">프로필</a></div>
            </div>
            <div class="ham_menu">
                <div class="ham_img">
                    <svg class="MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium css-7wsri6 logout" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="ExitToAppIcon"><path d="M10.09 15.59 11.5 17l5-5-5-5-1.41 1.41L12.67 11H3v2h9.67l-2.58 2.59zM19 3H5c-1.11 0-2 .9-2 2v4h2V5h14v14H5v-4H3v4c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2z"></path></svg>
                </div>
                <div class="ham_desc"><a href="/logout">로그아웃</a></div>
            </div>
            <div class="ham_menu">
                <div class="ham_img">
                    <svg aria-label="새로운 게시물" class="x1lliihq x1n2onr6 x5n08af userdelete" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>새로운 게시물</title><path d="M2 12v3.45c0 2.849.698 4.005 1.606 4.944.94.909 2.098 1.608 4.946 1.608h6.896c2.848 0 4.006-.7 4.946-1.608C21.302 19.455 22 18.3 22 15.45V8.552c0-2.849-.698-4.006-1.606-4.945C19.454 2.7 18.296 2 15.448 2H8.552c-2.848 0-4.006.699-4.946 1.607C2.698 4.547 2 5.703 2 8.552Z" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"></path><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="6.545" x2="17.455" y1="12.001" y2="12.001"></line><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="12.003" x2="12.003" y1="6.545" y2="17.455"></line></svg>
                </div>
                <div class="ham_desc">회원탈퇴</div>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="comment_make">
            <input type="text" placeholder="검색하기.." class="commert_text" name="keyword">
            <div class="comment_uplode">검색</div>
        </div>
        <div class="main_bot">
            <c:if test="${empty searchList}">
                <div class="nosearch" style="display: block">검색된 결과가 없습니다.</div>
            </c:if>
            <c:forEach var="user" items="${searchList}">
                <div class="item">
                    <div class="item_L">

                        <c:choose>
                            <c:when test="${user.user_photo == null}">
                                <!-- 프로필 이미지가 없으면 기본 이미지 -->
                                <img src="./img/로고2.jpg" class="item_img">
                            </c:when>
                            <c:otherwise>
                                <img src="<c:url value='/img/${user.getUser_photo()}'/>" class="item_img" >
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="item_R">
                        <a href="/detailArticle?user=${user.getUser_id()}">
                            <div class="id">${user.getUser_id()}</div>
                            <div class="name">${user.getUser_name()}</div>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
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
        $('.u_delete').on("click", function(){
            if(!confirm("정말로 탈퇴 하시겠습니까?")) return;
            location.href = '<c:url value = "/deleteUserInfo"/>'
        });

        $('.comment_uplode').click(function (){
            let keyword = $('.commert_text').val();
            location.href=`/searchForm?keyword=${'${keyword}'}`

        })

        $('.commert_text').keydown(function (e){
            if(e.which == 13){
                let keyword = $('.commert_text').val();
                location.href=`/searchForm?keyword=${'${keyword}'}`
            }
        })


    })



    <%--$(document).ready(function(){--%>
    <%--     $('.comment_uplode').click(function (){--%>
    <%--         let keyword = $('.commert_text').val();--%>
    <%--         location.href=`/searchForm?keyword=${'${keyword}'}`--%>
    <%--     })--%>
    <%-- })--%>

    <%--$(document).ready(function(){--%>
    <%--    $('.commert_text').keydown(function (e){--%>
    <%--      if(e.which == 13){--%>
    <%--          let keyword = $('.commert_text').val();--%>
    <%--          location.href=`/searchForm?keyword=${'${keyword}'}`--%>
    <%--      }--%>
    <%--    })--%>
    <%--})--%>


</script>
</body>
</html>