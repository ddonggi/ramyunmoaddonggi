<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="header">
	<div class="box">
		<nav class="navbar flex">
			<div class="navbar-logo flex">
				<a href="/main">라면모아</a>
			</div>
			<ul class="navbar-menu flex">
				<li><a href="/product/list">라면 소개</a></li>
				<li><a href="/review/list">후기 게시판</a></li>
				<li><a href="">라면 토론장</a></li>
				<li><a href="">레시피 공유</a></li>
			</ul>
			<ul class="navbar-member flex">
					<!-- 로그인 안됐을경우  로그인 / 회원가입 표시 -->
					<c:if test="${sessionScope.uid==null}">
						<li class="member"><a onclick="login()" >로그인</a></li>
						<li class="member"><a onclick="regist()">회원가입</a></li>
						<li class="member"><a href="">고객센터</a></li>
					</c:if>
					
					<!-- 로그인 됐을경우  내정보 / 로그아웃 표시 -->
					<c:if test="${sessionScope.uid!=null}">
						<li class="member"><a href="/member/mypage">내정보</a></li>
						<li class="member"><a href="/member/logout" onclick="logout()">로그아웃</a></li>
						<li class="member"><a href="">고객센터</a></li>
					</c:if>
					<!-- 관리자 로그인   로그아웃 -->
					<c:if test="${sessionScope.uid=='admin'}">
						<li class="member"><a onclick="memberList()">회원보기</a></li>
						<li class="member"><a href="/member/logout" onclick="logout()">로그아웃</a></li>
					</c:if>
			</ul>
		</nav>
	</div>
</header> --%>