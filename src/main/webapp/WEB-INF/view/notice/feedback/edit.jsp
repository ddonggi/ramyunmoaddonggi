<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main class="main">
	<section class="admin-service">
		<h1 class="font-size-30">고객의 소리 수정</h1>
	</section>

	<form action="edit" method="post">
		<section class="post">
			<h1 class="hidden">고객의 소리 입력</h1>
			<table class="detail-table">
				<tbody>
					<tr class="text-center border-bottom-bdbdbd">
						<td class="title">제목</td>
						<td colspan="6">
							<input class="edit-input" type="text" name="title" value="${f.title }" />
						</td>
					</tr>

					<tr class="text-center">
						<td class="writer">작성자</td>
						<td class="w140 h30">${f.writerId }</td>
						<td class="regdate">작성일</td>
						<td class="w120 h30">${f.regdate }</td>
						<td class="hit-w80">조회수</td>
						<td class="w60 h30">${f.hit }</td>
					</tr>

					<tr>
						<td colspan="6">
							<textarea class="content-input" name="content">${f.content }</textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</section>
		<div class="post-btn">
			<input type="hidden" name="id" value="${f.id }" /> 
			<input type="submit" value="저장" /> 
			<a href="detail?id=${f.id }">취소</a>
		</div>
	</form>

</main>