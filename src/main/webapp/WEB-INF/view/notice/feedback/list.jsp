<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<main class="main">
	<section class="customer-service">
		<h1 class="font-size-30">고객의 소리</h1>
	</section>

	<section class="search">
		<h1 class="hidden">문의사항 검색폼</h1>
		<form class="search-form">
			<fieldset>
				<legend class="hidden">문의사항 검색필드</legend>

				<label class="hidden">검색분류</label> <select>
					<option ${(param.f == "title")?"selected":"" } value="title">제목</option>
					<option ${(param.f == "content")?"selected":"" } value="content">내용</option>
					<option ${(param.f == "writerId")?"selected":"" } value="writerId">작성자</option>
				</select> 
				<label class="hidden">검색어</label> 
				<input class="search-text" type="text" name="q" placeholder="검색어를 입력하세요">
				<input class="search-button" type="submit" value="검색">
			</fieldset>
		</form>
	</section>

	<section class="list">
		<h1 class="hidden">게시글 목록</h1>
		<table class="table">
			<thead>
				<tr>
					<td class="col-num">번호</td>
					<td class="col-exp">제목</td>
					<td class="col-text">작성자</td>
					<td class="col-num">조회수</td>
					<td class="col-text">작성일</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="f" items="${list }" varStatus="st">
					<tr>
						<td>${f.id }</td>
						<td class="title"><a href="detail?id=${f.id}">${f.title }</a><span>[${f.cmtCount }]</span></td>
						<td>${f.writerId }</td>
						<td>${f.hit }</td>
						<td>${f.regdate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<section class="write">
			<h1 class="hidden">문의하기</h1>
			<div>
				<a href="reg">글쓰기</a>
			</div>
		</section>

		<section class="page">
			<h1 class="hidden">페이지</h1>

			<c:set var="page" value="${(empty param.p)?1:param.p }"/>
			<c:set var="startNum" value="${page-(page-1)%5 }"/>
			<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}"/>

			<div>
				<c:if test="${startNum>1 }">
					<a class="prev" href="?p=${startNum-1 }&f=&q=">이전</a>
				</c:if>
				<c:if test="${startNum<=1 }">
					<span class="prev" onclick="alert('이전페이지가 없습니다.')">이전</span>
				</c:if>
			</div>
			
			<ul>
				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(startNum+i) <= lastNum }">
						<li><a class="${(page==(startNum+i))?'text-highlight':'' } font-weight-bold" href="?p=${startNum+i }&f=&q=">${startNum+i }</a></li>
					</c:if>
				</c:forEach>
			</ul>
			<div>
				<c:if test="${startNum+4<lastNum }">
					<a class="next" href="?p=${startNum+5 }&f=&q=">다음</a>
				</c:if>
				<c:if test="${startNum+4>=lastNum }">
					<span class="next" onclick="alert('다음페이지가 없습니다.')">다음</span>
				</c:if>
			</div>
		</section>
	</section>
</main>