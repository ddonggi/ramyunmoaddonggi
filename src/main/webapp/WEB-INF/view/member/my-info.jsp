<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main id="mypage-main">
	<section class="myinfo-main-section">
		<h1 class="d-none">마이페이지</h1>
		<div class="mypage-context">
		<form action="my-info" method="post">
			<ul>
				<li class="btn-style">내 정보</li>
				<li>닉네임  :  <b>${m.nickname }</b></li>
				<li>회원등급  : <b> ${role.roleGrade }</b></li>
				<li>이메일  :  <b>${m.email }</b></li>
				<li>가입일  :  <b>${m.regdate }</b></li>
			</ul>
			</form>
		</div>
	</section>
</main>