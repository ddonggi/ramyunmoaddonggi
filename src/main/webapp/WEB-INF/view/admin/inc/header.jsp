<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>
	<div class="top-header">
		<div class="top-home">RmAdmin</div>
		<ul class="top-header-list">
			<li><a href="/main">라면모아홈</a></li>
			<li><a onclick="logout()"style="cursor:pointer;">로그아웃</a></li>
		</ul>
	</div>
	<div class="bottom-header">
		<ul class="admin-menu">
			<li><a href=""> <i class="fas fa-th"></i>기본설정
			</a></li>
			<li><a href="/admin/product/main"> <i class="fas fa-boxes"></i>제품관리
			</a></li>
			<li><a href=""> <i class="fas fa-users"></i>회원관리
			</a></li>
			<li><a href="/admin/board/review/main"> <i
					class="fas fa-clipboard-list"></i>게시판관리
			</a></li>
			<li><a href="/admin/board/notice/list"> <i class="fas fa-headset"></i>고객센터
			</a></li>
			<li><a href=""> RM 게시판 </a></li>
		</ul>
	</div>
</header>