<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<section class="contents">

	<h1 class="hidden">상품페이지</h1>
	<div class="title">Delete</div>

	<form action="del" method="get">
		<div class="search">
			<div>
				<label>전체</label> <input type="radio" name="m" value=""> <label>농심</label>
				<input type="radio" name="m" value="농심"> <label>삼양</label> <input
					type="radio" name="m" value="삼양"> <label>오뚜기</label> <input
					type="radio" name="m" value="오뚜기"> <label>팔도</label> <input
					type="radio" name="m" value="팔도"> <label>CU</label> <input
					type="radio" name="m" value="cu"> <label>GS25</label> <input
					type="radio" name="m" value="gs25"><label>세븐일레븐</label> <input
					type="radio" name="m" value="세븐일레븐">
			</div>
			<div>
				<label>컵라면</label> <input type="checkbox" name="c" value="컵">
			</div>
			<div>
				<input type="text" name="s" value="${param.s}"
					placeholder="${param.s}"> <input type="submit" value="검색">
			</div>
		</div>
	</form>

	<form action="remove" method="post">
		<table class="item-table" border="1">
			<thead>
				<tr>
					<td class="bold" colspan="2">TITLE</td>
					<td class="bold" colspan="5">CONTENT</td>
				</tr>
				<tr>
					<td class="space" colspan="7"></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="l" items="${list}">

					<!-- <td >
						<input type="text" value="${l.id}">			
					</td> -->

					<tr>
						<td rowspan="2" colspan="2"><img src="${l.img}"></td>
						<td class="bold">나트륨</td>
						<td class="bold">탄수화물</td>
						<td class="bold">당류</td>
						<td class="bold">지방</td>
						<td class="bold">Review</td>
					</tr>
					<tr>
						<td>${l.natrium}</td>
						<td>${l.carbohydrate}</td>
						<td>${l.sugars}</td>
						<td>${l.fat}</td>
						<td>?</td>
					</tr>
					<tr>
						<td class="bold">용량</td>
						<td class="bold">열량</td>
						<td class="bold">트랜스지방</td>
						<td class="bold">포화지방</td>
						<td class="bold">콜레스테롤</td>
						<td class="bold">단백질</td>
						<td class="bold">Likes</td>
					</tr>
					<tr>
						<td>${l.capacity}</td>
						<td>${l.kcal}</td>
						<td>${l.transfat}</td>
						<td>${l.saturatedFat}</td>
						<td>${l.cholesterol}</td>
						<td>${l.protein}</td>
						<td>?</td>
					</tr>
					<tr>
						<td colspan="2">${l.name}</td>
						<td class="bold">제조사</td>
						<td>${l.mfr}</td>
						<td class="bold">판매량</td>
						<td>${l.amount}</td>
						<td>
							<!-- <input type="hidden" value="${l.id}">
							<input type="submit" value="삭제"> --> <a href="remove?id=${l.id}"><input
								type="button" value="삭제"></a>
						</td>
					</tr>
					<tr>
						<td class="space" colspan="7"></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</form>

	<c:set var="page" value="${(empty param.p)?1:param.p}" />
	<c:set var="startNum" value="${page-(page-1)%5}" />
	<c:set var="lastNum"
		value="${fn:substringBefore(Math.ceil(count/10),'.')}" />

	<div class="list">
		<div class="current">${page}</div>
		<div>/</div>
		<div>${lastNum}</div>
		<div>pages</div>
	</div>

	<div class="pager">
		<c:choose>
			<c:when test="${startNum>1}">
				<a href="del?m=${param.m}&p=${startNum-5}&s=${param.s}"><i
					class="fas fa-arrow-alt-circle-left fa-2x"></i> </a>
			</c:when>
			<c:otherwise>
				<i class="fas fa-arrow-circle-left fa-2x"
					onclick="alert('이전 페이지가 없습니다.');"></i>
			</c:otherwise>
		</c:choose>

		<ul class="flex">
			<c:forEach begin="0" end="4" var="i">
				<c:if test="${startNum+i<=lastNum}">
					<li><a class="${(page==startNum+i)?'current':''}"
						href="del?m=${param.m}&p=${startNum+i}&s=${param.s}">${startNum+i}</a>
					</li>
				</c:if>
			</c:forEach>
		</ul>

		<c:choose>
			<c:when test="${startNum+4<lastNum}">
				<a href="del?m=${param.m}&p=${startNum+5}&s=${param.s}"><i
					class="fas fa-arrow-alt-circle-right fa-2x"></i> </a>
			</c:when>
			<c:otherwise>
				<i class="fas fa-arrow-circle-right fa-2x"
					onclick="alert('다음 페이지가 없습니다.');"></i>
			</c:otherwise>
		</c:choose>
	</div>

</section>

<script>
	window.addEventListener("load", function () {

		var delBtn = document.querySelector("input[value='삭제']");

		delBtn.onclick = function (e) {

			if (confirm("삭제하시겠습니까?") == false) {
				e.preventDefault();
			}
			else {
				alert("삭제하였습니다.");
			}
		}

	})
</script>