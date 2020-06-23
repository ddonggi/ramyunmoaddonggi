<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="main">
	<section class="first">
		<div class="first-rm">라면모아가 처음이신가요?</div>
		<a href=""><p class="click">클릭!</p></a> <span id="cancel"><i
			class="far fa-window-close"></i></span>
	</section>

	<div class="slider-area">
		<div class="slides slide-size">
			<input type="radio" name="i" id="i1" checked> <input
				type="radio" name="i" id="i2"> <input type="radio" name="i"
				id="i3">
			<div class="slide s1">
				<img src="/images/main/메인라면1.jpg" alt="라면" class="img-size">
			</div>
			<div class="slide">
				<img src="/images/main/메인라면2.jpg" alt="라면" class="img-size">
			</div>
			<div class="slide">
				<img src="/images/main/메인라면3.jpg" alt="라면" class="img-size">
			</div>
		</div>
		<div class="slide-nav">
			<label for="i1" class="bar"></label> <label for="i2" class="bar"></label>
			<label for="i3" class="bar"></label>
		</div>
	</div>
	<div class="cal-calc">
		<div>라면 칼로리를 계산해보세요 🍜</div>
		<div class="finger">
			<i class="far fa-hand-point-right"></i>
		</div>
		<a href="/calc" target="_blank" class="cal-calc-go">
			<button class="cal-calc-btn">go! go!</button>
		</a>
	</div>
	<div class="main-area">
		<div class="inner">
			<h2 class="tit-main">RamyunMoa's LIVE</h2>
			<div class="whats-new">
				<div class="whats-tit">
					<p>인기글</p>
					<ul class="whats-list">
						<li><span>글 내용1</span></li>
						<li><span>글 내용2</span></li>
						<li><span>글 내용3</span></li>
						<li><span>글 내용4</span></li>
						<li><span>글 내용5</span></li>
						<li><span>글 내용6</span></li>
						<li><span>글 내용7</span></li>
						<li><span>글 내용8</span></li>
						<li><span>글 내용9</span></li>
						<li><span>글 내용10</span></li>
					</ul>
				</div>
				<div class="whats-tit"> <!-- 수정부분 06.10 -->
					<p>후기 게시판</p>
					<ul class="whats-list">
						<c:forEach var="l" items="${reviewList}">
							<li><a href="review/detail?id=${l.id}">${l.title}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="whats-tit">
					<p>라면 토론장</p>
					<ul class="whats-list">
						<c:forEach var="d" items="${discussionList}">
							<li><span>${d.title}</span></li>
						</c:forEach>
					</ul>
				</div>
				<div class="whats-tit">
					<p>레시피 공유</p>
					<ul class="whats-list">
						<c:forEach var="r" items="${recipeList}">
							<li><span>${r.title}</span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</main>
