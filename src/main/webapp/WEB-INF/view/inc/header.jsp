<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<header class="header">
   <nav class="navbar">
      <div class="navbar-logo">
         <a href="/main"><img src="/images/main/라면모아로고.png" alt="라면모아"></a>
      </div>
      <div class="navbar-bottom">
         <ul class="navbar-menu">
            <li><a href="/product/list">라면 소개</a></li>
            <li><a href="/review/list">후기 게시판</a></li>
            <li><a href="/discussion/list">라면 토론장</a></li>
            <li><a href="/recipe/list">레시피 공유</a></li>
         </ul>
         <ul class="navbar-member">
  
            <!-- 빈 세션일 경우 -->
            <s:authorize access="isAnonymous()">
               <li class="member"><a href="/member/login" onclick="login()">로그인</a></li>
               <li class="member"><a href="/member/member-term" onclick="regist()">회원가입</a></li>
               <li class="member"><a href="/notice/list">고객센터</a></li>
            </s:authorize>

        	<!-- 로그시 일반 회원 헤더 -->
            <s:authorize access="hasRole('USER')">
               <li class="member"><a href="/member/mypage" >내정보</a></li>
               <li class="member"><a onclick="logout()" style="cursor:pointer;">로그아웃</a></li>
               <li class="member"><a href="/notice/list">고객센터</a></li>
            </s:authorize>
  
            <!-- 로그인시 관리자 헤더/ RoleId 7은 관리자 -->
        	<s:authorize access="hasRole('ADMIN')">
               <li class="member"><a href="/member/mypage" >내정보</a></li>
               <li class="member"><a onclick="logout()" style="cursor:pointer;">로그아웃</a></li>
               <li class="member"><a href="/admin/board/main" >관리자페이지</a></li>
           </s:authorize>
  
         </ul>
      </div>
   </nav>
</header>