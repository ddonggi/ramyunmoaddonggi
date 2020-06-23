<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section class="notice-review">
	<h1 class="hidden">신고 관리</h1>
	<div class="container">
		<div class="title">신고 관리</div>

		<div class="container-table">

			<table class="notice-table">
				<thead>
					<tr>
						<th>No.</th>
						<td>${notice.reportId}</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>${notice.reportRegdate}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${notice.reportNickname}</td>
					</tr>
					<tr>
						<th>제 목</th>
						<td>${notice.reportTitle}</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="6"><textarea name="" id="" cols="30" rows="10">${notice.reportContent}</textarea>
						</td>
					</tr>
					<tr>
						<th>신고대상(제목)</th>
						<td>${notice.title}</td>
					</tr>
					<tr>
						<th>신고대상(작성자)</th>
						<td>${notice.nickname}</td>
					</tr>
					<tr>
						<th>신고대상(내용)</th>
						<td>${notice.content}</td>
					</tr>
				</tbody>
			</table>

			<div class="bottom-btn">
				<a href="report"><input type="button" value="확인"></a>
			</div>
		</div>

	</div>
</section>