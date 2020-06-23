<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main class="main">
	<section>
		<h1 class="font-size-30">고객의 소리 작성</h1>
	</section>

	<form action="reg" method="post">
		<section class="post">
			<h1 class="hidden">고객의 소리 입력</h1>
			<table class="post-table">
				<tbody>
					<tr class="border-bottom-bdbdbd text-center">
						<td class="title">제목</td>
						<td colspan="3">
							<input class="title-input" type="text" name="title" placeholder="제목을 입력하세요"/>
						</td>
					</tr>

					<tr class="text-center">
						<td class="writer">작성자</td>
						<td class="w180 h30">
							<input type="hidden" name="uid" value="${sessionScope.uid }">
							${sessionScope.nickname }
						</td>
						<td class="regdate">작성일</td>
						<td class="w180 h30">${regdate }</td>
					</tr>
					
					<tr>
						<td colspan="4">
							<textarea class="content-input" name="content" placeholder="내용을 입력하세요"></textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</section>
		<div class="post-btn">
			<input type="submit" value="등록" /> <a href="list">취소</a>
		</div>
	</form>

</main>