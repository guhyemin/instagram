<%--
  Created by IntelliJ IDEA.
  User: 나상민
  Date: 2024-06-20
  Time: 오후 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="logInOutLink" value="${ sessionScope.id==null ? '/login':'/logout' }" />
<c:set var="logInOutTxt" value="${ sessionScope.id==null ? '로그인':'로그아웃' }" />
<c:set var="userId" value="${sessionScope.id==null?'':sessionScope.id}" />
<c:set var="inOut" value="${follow==null?'팔로우':'팔로우 취소'}" />

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>instagram</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

    <link rel="stylesheet" href="<c:url value='/css/instagram(h_f).css'/>">
    <link rel="stylesheet" href="<c:url value='/css/instagram(detail).css'/>">

    <script src="<c:url value='/js/instagram(h_f).js'/>"></script>
    <script src="<c:url value='/js/instagram(detail).js'/>"></script>
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
                <div class="ham_logo"><a href="#"></a></div>
                <div class="ham_close">닫기</div>
            </div>
            <div class="ham_menu">
                <div class="ham_img">
                    <svg aria-label="홈" class="x1lliihq x1n2onr6 x5n08af" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>홈</title><path d="M22 23h-6.001a1 1 0 0 1-1-1v-5.455a2.997 2.997 0 1 0-5.993 0V22a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V11.543a1.002 1.002 0 0 1 .31-.724l10-9.543a1.001 1.001 0 0 1 1.38 0l10 9.543a1.002 1.002 0 0 1 .31.724V22a1 1 0 0 1-1 1Z"></path></svg>
                </div>
                <div class="ham_desc">홈</div>
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
                <div class="ham_desc u_delete">회원탈퇴</div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="container_top">
            <div class="detailbox">
                <div class="detilbox_L">
                    <div class="detail_img">
                        <c:choose>
                            <c:when test="${userdto.getUser_photo() == null}">
                                <!-- 프로필 이미지가 없으면 기본 이미지 -->
                                <img src="./img/로고2.jpg" class="detail_back_img">
                            </c:when>
                            <c:otherwise>
                                <img src="<c:url value='/img/${userdto.getUser_photo()}'/>" class="detail_back_img" >
                            </c:otherwise>
                        </c:choose>

        <%--                        <div class="detail_back_img"></div>--%>
<%--                        <img src="<c:url value='/img/${userdto.getUser_photo()}'/>" class="detail_back_img" >--%>
                    </div>
                </div>
                <div class="detilbox_R">
                    <div class="detail_top">
                        <div class="name">${userdto.getUser_id()}</div>
                        <div class="follow">${inOut}</div>
                    </div>
                    <div class="detail_bot">
                        <div class="aticle_count">게시물 <span>${article_count}</span></div>
                        <div class="follower_count">팔로워 <span>${follower_count}</span></div>
                        <div class="follow_count">팔로우 <span>${following_count}</span></div>
                    </div>
                </div>
        </div>
        <c:if test="${not empty modify}">
            <div class="modify_btn"><a href="/myPage">프로필 편집하기</a></div>
        </c:if>
    </div>
        <div class="container_mid">
            <div class="Postingbox">
                <svg aria-label="게시물" class="x1lliihq x1n2onr6 x173jzuc" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>게시물</title><rect fill="none" height="18" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" width="18" x="3" y="3"></rect><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="9.015" x2="9.015" y1="3" y2="21"></line><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="14.985" x2="14.985" y1="3" y2="21"></line><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="21" x2="3" y1="9.015" y2="9.015"></line><line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" x1="21" x2="3" y1="14.985" y2="14.985"></line></svg>
            </div>
            <c:if test="${ not empty modify}">
                <div class="heartbox">
                    <svg aria-label="좋아요 취소" class="ttt" fill="currentColor" height="24" role="img" viewBox="0 0 48 48" width="24"><title>좋아요 취소</title><path d="M34.6 3.1c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5s1.1-.2 1.6-.5c1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"></path></svg>
                </div>
            </c:if>
        </div>
        <div class="container_bot bot_nomal">
            <c:forEach var="item" items="${articledto}">
                <div class="main_box">
                    <div class="main_top">
                        <div class="top_left">
                            <div class="my_img">
                                <c:choose>
                                    <c:when test="${item.getA_userPhoto() == null}">
                                        <!-- 프로필 이미지가 없으면 기본 이미지 -->
                                        <img src="./img/로고2.jpg" class="back_img">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="<c:url value='/img/${item.getA_userPhoto()}'/>" class="back_img" >
                                    </c:otherwise>
                                </c:choose>
<%--                                <img src="<c:url value='/img/${userdto.getUser_photo()}'/>" class="back_img" >--%>
<%--                                <div class="back_img">${item.getA_img()}</div>--%>
                                <!-- <img src="../인스타그램/로고/로고2.jpg" alt=""> -->
                            </div>
                            <div class="top_name"><a href="#">${item.getA_writer()}</a></div>
                                <%-- 찍히는 방식 변경 예정--%>
                            <div class="top_day">${item.getA_reg_date()}</div>
                        </div>
                        <div class="top_right">...</div>
                    </div>
                    <div class="main_mid">
                        <div class="main_imgbox">
                            <img src="<c:url value='/img/${item.getA_img()}'/>" class="main_imgbox_img" >
<%--                            <div class="main_imgbox_img">${item.getA_img()}</div>--%>
                            <!-- <img src="../인스타그램/이미지/커피홀174.jpg" alt=""> -->
                        </div>
                    </div>
                    <div class="main_bot">
                        <div class="bot_like">
                            <div style="display: none" class="A_seqno">${item.getA_seqno()}</div>
                            <svg aria-label="좋아요" class="x1lliihq x1n2onr6 xyb1xck" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24" style="display: ${item.getH_condition()==null?"block":"none"}"><title>좋아요</title><path d="M16.792 3.904A4.989 4.989 0 0 1 21.5 9.122c0 3.072-2.652 4.959-5.197 7.222-2.512 2.243-3.865 3.469-4.303 3.752-.477-.309-2.143-1.823-4.303-3.752C5.141 14.072 2.5 12.167 2.5 9.122a4.989 4.989 0 0 1 4.708-5.218 4.21 4.21 0 0 1 3.675 1.941c.84 1.175.98 1.763 1.12 1.763s.278-.588 1.11-1.766a4.17 4.17 0 0 1 3.679-1.938m0-2a6.04 6.04 0 0 0-4.797 2.127 6.052 6.052 0 0 0-4.787-2.127A6.985 6.985 0 0 0 .5 9.122c0 3.61 2.55 5.827 5.015 7.97.283.246.569.494.853.747l1.027.918a44.998 44.998 0 0 0 3.518 3.018 2 2 0 0 0 2.174 0 45.263 45.263 0 0 0 3.626-3.115l.922-.824c.293-.26.59-.519.885-.774 2.334-2.025 4.98-4.32 4.98-7.94a6.985 6.985 0 0 0-6.708-7.218Z"></path></svg>

                            <svg aria-label="좋아요 취소" class="x1lliihq x1n2onr6 xxk16z8" fill="currentColor" height="24" role="img" viewBox="0 0 48 48" width="24" style="display: ${item.getH_condition()==null?"none":"block"}"><title>좋아요 취소</title><path d="M34.6 3.1c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5s1.1-.2 1.6-.5c1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"></path></svg>
                        </div>

                        <div class="bot_comment_icon">
                            <svg aria-label="댓글 달기" class="x1lliihq x1n2onr6 x5n08af c_icon" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>댓글 달기</title><path d="M20.656 17.008a9.993 9.993 0 1 0-3.59 3.615L22 22Z" fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="2"></path></svg>
                        </div>
                        <div class="bot_send">
                            <svg aria-label="게시물 공유" class="x1lliihq x1n2onr6 x5n08af" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>게시물 공유</title><line fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="2" x1="22" x2="9.218" y1="3" y2="10.083"></line><polygon fill="none" points="11.698 20.334 22 3.001 2 3.001 9.218 10.084 11.698 20.334" stroke="currentColor" stroke-linejoin="round" stroke-width="2"></polygon></svg>
                        </div>
                    </div>
                    <div class="like_count">좋아요 <span>${item.getA_Heart()}</span> 개</div>
                    <div class="main_comment">
                        <div class="my_comment">
                            <div class="commert_name">${item.getA_writer()}</div>
                            <div class="commert_desc">${item.getA_contents()}</div>
                        </div>
                        <div class="comment_count">댓글 <span>${item.getA_comment()}</span>개 모두보기</div>
                        <div style="display: none" class="A_seqno">${item.getA_seqno()}</div>
                        <div class="comment_make">
                            <input type="text" placeholder="댓글달기.." class="commert_text" value="">
                            <div class="comment_uplode">게시</div>
                        </div>
                    </div>
                    <div class="main_seemore">
                        <div class="seemore_menubox">
                            <div class="seemore_menu color_red">신고</div>
                            <div class="seemore_menu color_red seemore_cancle">팔로우 취소</div>
                            <div class="seemore_menu">즐겨찾기에 추가</div>
                            <div class="seemore_menu">게시물로 이동</div>
                            <div class="seemore_menu">공유대상...</div>
                            <div class="seemore_menu">링크 복사</div>
                            <div class="seemore_menu">퍼가기</div>
                            <div class="seemore_menu">이계정 정보</div>
                            <div class="seemore_menu seemore_delete">삭제</div>
                            <div class="seemore_menu seemore_cancle">취소</div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class="big_comment">
                <div class="bc_pan">
                    <div class="bc_top">
                        <div class="bc_title">댓글</div>
                        <div class="bc_close">x</div>
                    </div>
                    <div class="bc_bot">
                        <div class="bc_item">
                            <div class="bc_item_L">
                                <div class="bc_img"></div>
                            </div>
                            <div class="bc_item_R">
                                <div class="bc_R_top">
                                    <div class="bc_name">nasangmin</div>
                                    <div class="bc_day">15일</div>
                                </div>
                                <textarea name="content" id="#" class="bc_text" readonly >너무웃겨요 ㅎㅎㅎ</textarea>
                                <div class="bc_change">
                                    <div class="bc_modify">수정</div>
                                    <div class="bc_delete">삭제</div>
                                </div>
                                <div class="reply">
                                    <div class="reply_title">답글보기</div>
                                    <div class="replay_bot">
                                        <div class="sc_item">
                                            <div class="sc_item_L">
                                                <div class="sc_img"></div>
                                            </div>
                                            <div class="sc_item_R">
                                                <div class="sc_R_top">
                                                    <div class="sc_name">nasangmin</div>
                                                    <div class="sc_day">15일</div>
                                                </div>
                                                <textarea name="content" id="" class="sc_text" readonly >너무웃겨요 ㅎㅎㅎ</textarea>
                                                <div class="sc_change">
                                                    <div class="sc_modify">수정</div>
                                                    <div class="sc_delete">삭제</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="sc_up">
                                        <input type="text" placeholder="댓글달기.." class="sc_up_text">
                                        <div class="sc_uplode">게시</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="bc_up">
                            <input type="text" placeholder="댓글달기.." class="bc_up_text">
                            <div class="bc_uplode">게시</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="container_bot bot_heart">
            <c:if test="${not empty articledto2}">
                <c:forEach var="item" items="${articledto2}">
                    <div class="main_box">
                        <div class="main_top">
                            <div class="top_left">
                                <div class="my_img">
                                    <c:choose>
                                        <c:when test="${item.getA_userPhoto() == null}">
                                            <!-- 프로필 이미지가 없으면 기본 이미지 -->
                                            <img src="./img/로고2.jpg" class="back_img">
                                        </c:when>
                                        <c:otherwise>
                                            <img src="<c:url value='/img/${item.getA_userPhoto()}'/>" class="back_img" >
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="top_name"><a href="#">${item.getA_writer()}</a></div>
                                    <%-- 찍히는 방식 변경 예정--%>
                                <div class="top_day">${item.getA_reg_date()}</div>
                            </div>
                            <div class="top_right">...</div>
                        </div>
                        <div class="main_mid">
                            <div class="main_imgbox">
                                <img src="<c:url value='/img/${item.getA_img()}'/>" class="main_imgbox_img" >
                            </div>
                        </div>
                        <div class="main_bot">
                            <div class="bot_like">
                                <div style="display: none" class="A_seqno">${item.getA_seqno()}</div>
                                <svg aria-label="좋아요" class="x1lliihq x1n2onr6 xyb1xck" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24" style="display:none"><title>좋아요</title><path d="M16.792 3.904A4.989 4.989 0 0 1 21.5 9.122c0 3.072-2.652 4.959-5.197 7.222-2.512 2.243-3.865 3.469-4.303 3.752-.477-.309-2.143-1.823-4.303-3.752C5.141 14.072 2.5 12.167 2.5 9.122a4.989 4.989 0 0 1 4.708-5.218 4.21 4.21 0 0 1 3.675 1.941c.84 1.175.98 1.763 1.12 1.763s.278-.588 1.11-1.766a4.17 4.17 0 0 1 3.679-1.938m0-2a6.04 6.04 0 0 0-4.797 2.127 6.052 6.052 0 0 0-4.787-2.127A6.985 6.985 0 0 0 .5 9.122c0 3.61 2.55 5.827 5.015 7.97.283.246.569.494.853.747l1.027.918a44.998 44.998 0 0 0 3.518 3.018 2 2 0 0 0 2.174 0 45.263 45.263 0 0 0 3.626-3.115l.922-.824c.293-.26.59-.519.885-.774 2.334-2.025 4.98-4.32 4.98-7.94a6.985 6.985 0 0 0-6.708-7.218Z"></path></svg>

                                <svg aria-label="좋아요 취소" class="x1lliihq x1n2onr6 xxk16z8" fill="currentColor" height="24" role="img" viewBox="0 0 48 48" width="24"  style="display:block"><title>좋아요 취소</title><path d="M34.6 3.1c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5s1.1-.2 1.6-.5c1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"></path></svg>
                            </div>

                            <div class="bot_comment_icon">
                                <svg aria-label="댓글 달기" class="x1lliihq x1n2onr6 x5n08af c_icon" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>댓글 달기</title><path d="M20.656 17.008a9.993 9.993 0 1 0-3.59 3.615L22 22Z" fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="2"></path></svg>
                            </div>
                            <div class="bot_send">
                                <svg aria-label="게시물 공유" class="x1lliihq x1n2onr6 x5n08af" fill="currentColor" height="24" role="img" viewBox="0 0 24 24" width="24"><title>게시물 공유</title><line fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="2" x1="22" x2="9.218" y1="3" y2="10.083"></line><polygon fill="none" points="11.698 20.334 22 3.001 2 3.001 9.218 10.084 11.698 20.334" stroke="currentColor" stroke-linejoin="round" stroke-width="2"></polygon></svg>
                            </div>
                        </div>
                        <div class="like_count">좋아요 <span>${item.getA_Heart()}</span> 개</div>
                        <div class="main_comment">
                            <div class="my_comment">
                                <div class="commert_name">${item.getA_writer()}</div>
                                <div class="commert_desc">${item.getA_contents()}</div>
                            </div>
                            <div class="comment_count">댓글 <span>${item.getA_comment()}</span>개 모두보기</div>
                            <div style="display: none" class="A_seqno">${item.getA_seqno()}</div>
                            <div class="comment_make">
                                <input type="text" placeholder="댓글달기.." class="commert_text" value="">
                                <div class="comment_uplode">게시</div>
                            </div>
                        </div>
                        <div class="main_seemore">
                            <div class="seemore_menubox">
                                <div class="seemore_menu color_red">신고</div>
                                <div class="seemore_menu color_red seemore_cancle">팔로우 취소</div>
                                <div class="seemore_menu">즐겨찾기에 추가</div>
                                <div class="seemore_menu">게시물로 이동</div>
                                <div class="seemore_menu">공유대상...</div>
                                <div class="seemore_menu">링크 복사</div>
                                <div class="seemore_menu">퍼가기</div>
                                <div class="seemore_menu">이계정 정보</div>
                                <div class="seemore_menu seemore_delete">삭제</div>
                                <div class="seemore_menu seemore_cancle">취소</div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
            <div class="big_comment">
                <div class="bc_pan">
                    <div class="bc_top">
                        <div class="bc_title">댓글</div>
                        <div class="bc_close">x</div>
                    </div>
                    <div class="bc_bot">
                        <%--                            <div class="bc_item">--%>
                        <%--                                <div class="bc_item_L">--%>
                        <%--                                    <div class="bc_img"></div>--%>
                        <%--                                </div>--%>
                        <%--                                <div class="bc_item_R">--%>
                        <%--                                    <div class="bc_R_top">--%>
                        <%--                                        <div class="bc_name">nasangmin</div>--%>
                        <%--                                        <div class="bc_day">15일</div>--%>
                        <%--                                    </div>--%>
                        <%--                                    <textarea name="content" id="#" class="bc_text" readonly >너무웃겨요 ㅎㅎㅎ</textarea>--%>
                        <%--                                    <div class="bc_change">--%>
                        <%--                                        <div class="bc_modify">수정</div>--%>
                        <%--                                        <div class="bc_delete">삭제</div>--%>
                        <%--                                    </div>--%>
                        <%--                                    <div class="reply">--%>
                        <%--                                        <div class="reply_title">답글보기</div>--%>
                        <%--                                        <div class="replay_bot">--%>
                        <%--                                            <div class="sc_item">--%>
                        <%--                                                <div class="sc_item_L">--%>
                        <%--                                                    <div class="sc_img"></div>--%>
                        <%--                                                </div>--%>
                        <%--                                                <div class="sc_item_R">--%>
                        <%--                                                    <div class="sc_R_top">--%>
                        <%--                                                        <div class="sc_name">nasangmin</div>--%>
                        <%--                                                        <div class="sc_day">15일</div>--%>
                        <%--                                                    </div>--%>
                        <%--                                                    <textarea name="content" id="" class="sc_text" readonly >너무웃겨요 ㅎㅎㅎ</textarea>--%>
                        <%--                                                    <div class="sc_change">--%>
                        <%--                                                        <div class="sc_modify">수정</div>--%>
                        <%--                                                        <div class="sc_delete">삭제</div>--%>
                        <%--                                                    </div>--%>
                        <%--                                                </div>--%>
                        <%--                                            </div>--%>
                        <%--                                        </div>--%>
                        <%--                                        <div class="sc_up">--%>
                        <%--                                            <input type="text" placeholder="댓글달기.." class="sc_up_text">--%>
                        <%--                                            <div class="sc_uplode">게시</div>--%>
                        <%--                                        </div>--%>
                        <%--                                    </div>--%>
                        <%--                                </div>--%>
                        <%--                            </div>--%>
                        <%--                            <div class="bc_up">--%>
                        <%--                                <input type="text" placeholder="댓글달기.." class="bc_up_text">--%>
                        <%--                                <div class="bc_uplode">게시</div>--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>
                    </div>
                </div>

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
</div>>


<script>
    $(document).ready(function(){
        $('.u_delete').on("click", function(){
            if(!confirm("정말로 탈퇴 하시겠습니까?")) return;
            location.href = '<c:url value = "/deleteUserInfo"/>'
        });

        let showList;
        let childrenList;

        // 한자리 수면 앞에 0 붙이는 함수
        function zero(num) {
            if(num < 10) {
                return "0"+num;
            }
            return num;
        }

        $(document).on('click','.bot_like',function() {
            let A_seqno = $(this).children('.A_seqno').text();
            let box =$(this).parent().next().children('span')
            let count = $(this).parent().next().children('span').text()
            console.log(A_seqno);

            $.ajax({
                type:'PUT', // 요청 메서드
                url: '/heart/modify/'+A_seqno, // 요청 URI - Ex17_CommentController 의 맵핑 "/comments/{cno}"가 받음
                // dataType : 'json', // 전송받을 데이터의 타입
                success : function(body){
                    alert("좋아요"+body)
                    console.log($(this))
                    if (body=="추가"){
                        box.text(++count);
                    }
                    else if (body=="취소"){
                        box.text(--count);
                    }
                },
                error : function(){
                    alert("이상해") } // 에러가 발생했을 때, 호출될 함수
            });
        });


        // 부모 댓글 나오게하기
        $(document).on('click','.comment_count,.bot_comment_icon',function() {
            let A_seqno = $(this).parent().find('.A_seqno').text();
            console.log(A_seqno); //이거 잘나오는지 체크해야함.


            showList = function(A_seqno){
                $.ajax({
                    type:'GET', // 요청 메서드
                    url: '/comment/'+A_seqno, // 요청 URI - Ex17_CommentController 의 맵핑 "/comments/{cno}"가 받음
                    // dataType : 'json', // 전송받을 데이터의 타입
                    success : function(result){
                        let tmp = "";
                        let userId = "<%= session.getAttribute("id") %>";
                        result.forEach(function(rowResult){
                            let dt = new Date(rowResult.c_reg_date);
                            console.log(dt);
                            let year = dt.getFullYear();
                            let month = dt.getMonth()+1;
                            let date=dt.getDate();
                            let hour=dt.getHours();
                            let min=dt.getMinutes();
                            let sec=dt.getSeconds();



                            tmp +=`
    <div class="bc_item">
    <div class="bc_item_L">
    <div class="bc_img">`
                            if(rowResult.userPhoto == null){
                                tmp += `<img src="./img/로고2.jpg" class="back_img">`
                            }
                            else {
                                tmp += `<img src="<c:url value='/img/${"${rowResult.userPhoto}"}'/>" class="back_img" >`
                            }
    tmp +=`</div>
    </div>
    <div class="bc_item_R">
    <div class="bc_R_top">
    <div class="bc_name"><a href="/detailArticle?user=${'${rowResult.c_writer}'}">${'${rowResult.c_writer}'}</a></div>
    <div class="bc_day">${'${year}'}-${'${zero(month)}'}-${'${zero(date)}'} ${'${zero(hour)}'}:${'${zero(min)}'}:${'${zero(sec)}'}</div>
    </div>
    <textarea name="content" id="" class="bc_text" readonly >${'${rowResult.c_txt}'}</textarea>
    <div class="C_group_num" style="display: none">${'${rowResult.C_group_num}'}</div>
    <div class="c_seqno" style="display: none">${'${rowResult.c_seqno}'}</div>
    `
                            if(userId == rowResult.c_writer){
                                tmp +=`
        <div class="bc_change">
        <div class="bc_modify">수정</div>
<div style="display: none" class="A_seqno">${'${rowResult.fk_A_seqno}'}</div>
        <div class="bc_delete">삭제</div>
        </div>
            `
                            }
                            tmp +=`
    <div style="display: none" class="A_seqno">${'${rowResult.fk_A_seqno}'}</div>
    <div style="display: none" class="group">${'${rowResult.c_group_num}'}</div>
    <div class="reply">
    <div class="reply_title">답글보기</div>
    <div class="replay_bot">

    </div>
    <div class="sc_up">
    <input type="text" placeholder="댓글달기.." class="sc_up_text">
    <div style="display: none" class="A_seqno">${'${rowResult.fk_A_seqno}'}</div>
    <div style="display: none" class="group">${'${rowResult.c_group_num}'}</div>
    <div class="sc_uplode">게시</div>
    </div>
    </div>
    </div>
    </div>`
                        });

                        tmp +=
                            `

    <div class="bc_up">
    <input type="text" placeholder="댓글달기.." class="bc_up_text">
    <div class="A_seqno" style="display: none">${'${A_seqno}'}</div>
    <div class="bc_uplode">게시</div>
    </div>
    `
                        $('.bc_bot').html(tmp);

                    },
                    error : function(){
                        alert("잘못된 접근입니다.") } // 에러가 발생했을 때, 호출될 함수
                });
            }
            showList(A_seqno);
        });





        // 대댓글 나오게하기
        $(document).on('click','.reply_title',function() {
            let A_seqno = $(this).parent().prev().prev().text();
            let group = $(this).parent().prev().text();
            let ttt =$(this).next();
            console.log(A_seqno); //이거 잘나오는지 체크해야함.
            console.log(group);
            console.log(ttt);

            childrenList = function(A_seqno,group,ttt){
                $.ajax({
                    type:'GET', // 요청 메서드
                    url: '/comment/children/'+A_seqno+"?group="+group, // 요청 URI - Ex17_CommentController 의 맵핑 "/comments/{cno}"가 받음
                    // dataType : 'json', // 전송받을 데이터의 타입
                    success : function(result){
                        console.log(result)
                        let tmp = "";
                        let userId = "<%= session.getAttribute("id") %>";
                        result.forEach(function(rowResult) {
                            let dt = new Date(rowResult.c_reg_date);
                            console.log(dt);
                            let year = dt.getFullYear();
                            let month = dt.getMonth() + 1;
                            let date = dt.getDate();
                            let hour = dt.getHours();
                            let min = dt.getMinutes();
                            let sec = dt.getSeconds();


                            tmp +=`
            <div class="sc_item">
                <div class="sc_item_L">
                    <div class="sc_img">`
                            if(rowResult.userPhoto == null){
                                tmp += `<img src="./img/로고2.jpg" class="back_img">`
                            }
                            else {
                                tmp += `<img src="<c:url value='/img/${"${rowResult.userPhoto}"}'/>" class="back_img" >`
                            }
                    tmp +=`</div>
                </div>
                <div class="sc_item_R">
                        <div class="sc_R_top">
                            <div class="sc_name"><a href="/detailArticle?user=${'${rowResult.c_writer}'}">${'${rowResult.c_writer}'}</a></div>
                            <div class="sc_day">${'${year}'}-${'${zero(month)}'}-${'${zero(date)}'} ${'${zero(hour)}'}:${'${zero(min)}'}:${'${zero(sec)}'}</div>
                        </div>
                    <textarea name="content" id="" class="sc_text" readonly >${'${rowResult.c_txt}'}</textarea>
                    <div class="c_seqno" style="display: none">${'${rowResult.c_seqno}'}</div>`
                            if (userId == rowResult.c_writer){
                                tmp +=`
                    <div class="sc_change">
                        <div class="sc_modify">수정</div>
                        <div style="display: none" class="A_seqno">${'${rowResult.fk_A_seqno}'}</div>
                        <div class="sc_delete">삭제</div>
                    </div>
                    `
                            }
                            tmp +=`
                </div>
            </div>
            `
                        })
                        ttt.html(tmp);
                        // this 잡으면 바로 사라져서 못잡는듯.
                    },
                    error : function(){
                        alert("잘못된 접근입니다.") } // 에러가 발생했을 때, 호출될 함수
                });
            }
            childrenList(A_seqno,group,ttt)
        });

        //댓글 삭제하기

        $(document).on('click','.bc_delete,.sc_delete',function(){
            if(!confirm("정말로 삭제 하시겠습니까?")) return;
            let c_seqno = $(this).parent().prev().text();
            let A_seqno = $(this).prev().text();


            $.ajax({
                type:"DELETE",
                url: "/comment/"+c_seqno,
                success:function(body) {
                    alert(body)
                    showList(A_seqno);
                },
                error:function(){
                    alert("삭제 실패")
                }
            });


        })


        // 댓글 등록하기 부모(팝업)
        $(document).on('click','.bc_uplode',function(){
            let A_seqno = $(this).prev().text();
            let text =  $(this).prev().prev().val();
            console.log(A_seqno);
            console.log(text);
            // 밑에 일단 이렇게 넘기는데 밑에 data에 담을려면 dto에 대문자 뺴야 할거같은데 ?
            $.ajax({
                type:"POST",
                url: "/comment/?A_seqno="+A_seqno+"&text="+text,
                // headers: {"content-type":"application/json"},
                // data:JSON.stringify(text),
                success:function(body) {
                    alert(body)
                    showList(A_seqno);
                },
                error:function(){
                    alert("로그인 후 이용해주세요")
                }
            });
        })

        // 댓글 등록하기 부모(게시글)
        $(document).on('click','.comment_uplode',function(){
            let text =  $(this).prev().val();
            let A_seqno = $(this).parent().prev().text();
            console.log(A_seqno);
            console.log(text);

            $.ajax({
                type:"POST",
                url: "/comment/?A_seqno="+A_seqno+"&text="+text,
                // headers: {"content-type":"application/json"},
                // data:JSON.stringify(text),
                success:function(body) {
                    alert(body)
                },
                error:function(){
                    alert("로그인 후 이용 해주세요.")
                }
            });

        })


        //대댓글 등록하기

        // 댓글 등록하기 부모(게시글)
        $(document).on('click','.sc_uplode',function(){
            let text =  $(this).prev().prev().prev().val();
            let A_seqno = $(this).prev().prev().text();
            let group = $(this).prev().text();
            let ttt = $(this).parent().prev();
            console.log(A_seqno);
            console.log(text);
            console.log(group)

            $.ajax({
                type:"POST",
                url: "/comment/children/?A_seqno="+A_seqno+"&text="+text+"&group="+group,
                // headers: {"content-type":"application/json"},
                // data:JSON.stringify(text),
                success:function(body) {
                    alert(body)
                    childrenList(A_seqno,group,ttt)
                },
                error:function(){
                    alert("로그인 후 이용 해주세요.")
                }
            });

        })


        $(document).on('click','.follow',function(){
            let user_id = $(this).prev().text();
            console.log(user_id);

            $.ajax({
                type:"PATCH",
                url: "/follow/"+user_id,

                success:function(body) {
                    $('.follow').text(($('.follow').eq(0).text()== "팔로우"?"팔로우 취소" : "팔로우 하기"))
                    alert(body)
                },
                error:function(){
                    alert("로그인 후 이용 해주세요.")
                }
            });

        });

    })
</script>
</body>
</html>