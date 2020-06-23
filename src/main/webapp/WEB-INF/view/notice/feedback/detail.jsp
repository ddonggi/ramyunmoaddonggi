<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main class="main">
	<section>
		<h1 class="font-size-30">자세한 고객의 소리</h1>
	</section>

	<section class="detail">
		<h1 class="hidden">고객의 소리 보기</h1>
		<table class="detail-table">
			<tbody>
				<tr class="border-bottom-bdbdbd">
					<td class="title text-center">제목</td>
					<td class="text-indent" colspan="6">${f.title }</td>
				</tr>

				<tr class="text-center border-bottom-bdbdbd">
					<td class="writer">작성자</td>
					<td class="w140 h30">${f.writerId }</td>
					<td class="regdate">작성일</td>
					<td class="w160 h30">${f.regdate }</td>
					<td class="hit">조회수</td>
					<td class="w100 h30">${f.hit }</td>
				</tr>
				
				<tr class="content border-bottom-1px-solid-gray">
					<td class="padding-top-5px" colspan="6">${f.content }</td>
				</tr>
			</tbody>
		</table>
	</section>

	<div class="go-list">
		<a class="padding-right-10" href="edit?id=${f.id }">수정</a> 
		<a class="padding-right-10" href="list">목록</a> 
	</div>

	<section>
		<table class="detail-sub-table">
			<tbody>
				<tr class="border-bottom-1px-solid-gray">
					<td class="prev">이전글</td>
					<c:choose>
						<c:when test="${prev.id<f.id }">
							<td class="text-indent w600 h30"><a href="detail?id=${prev.id }">${prev.title }</a></td>
						</c:when>
						<c:otherwise>
							<td class="text-indent w600 h30">이전글이 없습니다.</td>
						</c:otherwise>
					</c:choose>
				</tr>

				<tr>
					<td class="next">다음글</td>
					<c:choose>
						<c:when test="${next.id>f.id }">
							<td class="text-indent w600 h30"><a href="detail?id=${next.id }">${next.title }</a></td>
						</c:when>
						<c:otherwise>
							<td class="text-indent w600 h30">다음글이 없습니다.</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</tbody>
		</table>
	</section>
	
	<div class="comment-box">
	<form action="cmt-del" method="get">
		<c:forEach var="cmt" items="${comments }" varStatus="st">
			<div class="comment">
				<div>
					<div class="icon"></div>
					<div class="writer"><b>${cmt.writerId }</b></div>
				</div>
				<p class="content">${cmt.content }</p>
				<div>
					<input type="hidden" name="cmtId" value="${cmt.id }">
					<input type="hidden" name="boardId" value="${f.id }">
					<input class="delete" type="submit" value="삭제">
					<div class="regdate">${cmt.regdate }</div>
				</div>
			</div>
		</c:forEach>
	</form>
		<form action="detail" method="post">
			<div class="comment-post">
				<input type="hidden" name="uid" value="${sessionScope.uid }">
				<textarea class="comment-textarea" name="content" placeholder="400자까지 입력 가능합니다."></textarea>
				<!-- <input class="comment-textarea" type="text" > -->
				<input type="submit" value="등록" class="comment-button">
				<input type="hidden" name="boardId" value="${f.id }">
			</div>
		</form>
	</div>
</main>