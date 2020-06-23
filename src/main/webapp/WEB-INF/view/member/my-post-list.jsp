<%@page import="java.util.List"%>
<%@page import="com.ramyunmoa.web.entity.member.Post"%>
<%@page import="com.ramyunmoa.web.service.PostService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main class="main">
	<h1 class="main title">내가 쓴 글</h1>


	<div class="notice margin-top">
		<h3 class="hidden">공지사항 목록</h3>
		<table class="table">
			<thead>
				<tr>
					<input type="checkbox"/>
					<th class="w60">번호</th>
					<th class="expand">제목</th>
					<th class="w100">작성일</th>
					<th class="w60">조회수</th>
				</tr>
			</thead>
			<tbody>

 				<c:forEach var="n" items="${list}" varStatus="st">

					<tr>
						<td>${n.id}</td>
						<td class="title indent text-align-left"><a
							href="detail?id=${n.id}">${n.title}</a></td>
						<td>${n.writerId }</td>
						<td>${n.regdate}</td>
						<td>${n.hit }</td>

					</tr>
				</c:forEach> 

				<%-- <%
					List<NoticeView> list = (List<NoticeView>)request.getAttribute("list");
					for(NoticeView n : list){
					%>
					<tr>
						<td><%=n.getId()%></td>
						<td class="title indent text-align-left"><a href="detail?id=<%=n.getId()%>"><%=n.getTitle() %></a></td>
						<td><%=n.getWriterId() %></td>
						<td>
							<%=n.getRegdate() %>	
						</td>
						<td><%=n.getHit() %></td>
					</tr>
					<%} %> --%>



			</tbody>
		</table>
	</div>

	<div class="indexer margin-top align-right">
		<h3 class="hidden">현재 페이지</h3>
		<div>
			<span class="text-orange text-strong">1</span> / 1 pages
		</div>
	</div>

	<div class="margin-top align-center pager">

		<div>


			<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>

		</div>
		<ul class="-list- center">
			<c:forEach var="i" begin="1" end="5">
				<c:set var="orange" value="" />
				<c:if test="${i==1}">
					<c:set var="orange" value="-text- orange bold" />
				</c:if>

				<li><a class="${orange}" href="?p=1&t=&q=">${i}</a></li>
			</c:forEach>
		</ul>

		<div>


			<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>

		</div>

	</div>
</main>
<script src="../js/notice/list.js"></script>
<script src="../js/utils.js"></script>