<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="notice-review">
	<h1 class="hidden">후기게시판</h1>
	<div class="container">
		<div class="title">후기게시판</div>

		<div class="title-sub">기간별 현황</div>

		<div class="date-search">
			<form action="main" method="get">
				<input type="date" name="sd"> <input type="date" name="ed">
				<input type="submit" value="검색">
			</form>
		</div>

		<div class="container-table t1">
			<table class="notice-table">
				<thead>
					<tr>
						<td>게시글 수</td>
						<td>댓글 수</td>
						<td>신고 횟수</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${cr}</td>
						<td>${crc}</td>
						<td>${crr}</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="container-table">
			<table class="notice-table t2">
				<thead>
					<tr>
						<td>순위</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${list}" varStatus="list">
						<tr>
							<td>TOP ${list.index+1}</td>
							<td><a href="main-detail?id=${l.id}">${l.title}</a></td>
							<td>${l.nickname}</td>
							<td>${l.regdate}</td>
							<td>${l.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- <hr style="width: 90%; margin: 50px auto;" />

        <div class="title-sub">후기게시판-신고 현황</div>

        <div class="date-search">
            <form action="main" method="get">
                <input type="date" name="sd"> <input type="date" name="ed">
                <input type="submit" value="검색">
            </form>
        </div>

        <div class="container-table">
            <table class="notice-table t1">
                <thead>
                    <tr>
                        <td>게시글 신고 횟수</td>
                        <td>댓글 신고 횟수</td>
                        <td>유저 신고 횟수</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${l.title}</td>
                        <td>${l.nickname}</td>
                        <td>${l.regdate}</td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="container-table">
            <table class="notice-table t2">
                <thead>
                    <tr>
                        <td>순위</td>
                        <td>제목</td>
                        <td>작성자</td>
                        <td>작성일</td>
                        <td>조회수</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" begin="0" end="2">
                        <tr>
                            <td>TOP ${i+1}</td>
                            <td><a href="detail?id=${l.id}">${l.title}</a></td>
                            <td>${l.nickname}</td>
                            <td>${l.regdate}</td>
                            <td>${l.hit}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> -->

	</div>
</section>