<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside class="mypage-aside">
	<div class="mypage-menu">
		<nav>
			<ul>
				<li><a href="my-info?id=${m.id }" class="my-info">내 정보</a></li>
				<li><a href="my-post-list?p=${m.id }" class="my-post-list">내가 쓴 글</a></li>
				<li><a href="my-cmt-list?id=${m.id }" class="my-cmt-list">내가 쓴 댓글</a></li>
				<li><a href="my-scrap-list?id=${m.id }" class="my-scrap-list">스크랩 한 글</a></li>
				<li><a href="change-pwd-check" class="change-pwd" >비밀번호 변경</a></li>
				<li><a href="quit-member" class="quit-member" >회원탈퇴</a></li>
			</ul>
		</nav>
	</div>
</aside>