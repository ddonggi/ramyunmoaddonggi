<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<section class="contents">

	<h1 class="hidden">상품페이지</h1>
	<div class="title">Update</div>

	<form action="update" method="get">
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

	<form action="edit" method="post">
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
						<td rowspan="2" colspan="2">
						<img src="${l.img}" name="img" value="${l.img}">
						</td>
						<td class="bold">나트륨</td>
						<td class="bold">탄수화물</td>
						<td class="bold">당류</td>
						<td class="bold">지방</td>
						<td rowspan="4"><input type="hidden" name="id"
							value="${l.id}"> <input class="bold" type="submit"
							value="수정"></td>
					</tr>
					<tr>
						<td><input type="text" name="natrium" value="${l.natrium}"></td>
						<td><input type="text" name="carbohydrate"
							value="${l.carbohydrate}"></td>
						<td><input type="text" name="sugars" value="${l.sugars}"></td>
						<td><input type="text" name="fat" value="${l.fat}"></td>
					</tr>
					<tr>
						<td class="bold">용량</td>
						<td class="bold">열량</td>
						<td class="bold">트랜스지방</td>
						<td class="bold">포화지방</td>
						<td class="bold">콜레스테롤</td>
						<td class="bold">단백질</td>
					</tr>
					<tr>
						<td><input type="text" name="capacity" value="${l.capacity}"></td>
						<td><input type="text" name="kcal" value="${l.kcal}"></td>
						<td><input type="text" name="transfat" value="${l.transfat}"></td>
						<td><input type="text" name="saturatedFat"
							value="${l.saturatedFat}"></td>
						<td><input type="text" name="cholesterol"
							value="${l.cholesterol}"></td>
						<td><input type="text" name="protein" value="${l.protein}"></td>
					</tr>
					<tr>
						<td colspan="2"><input class="name" type="text" name="name"
							value="${l.name}"></td>
						<td class="bold">제조사</td>
						<td><input type="text" name="mfr" value="${l.mfr}"></td>
						<td class="bold">판매량</td>
						<td colspan="2">
							<div class="sales">
								<select name="year" id="">
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021">2021</option>
									<option value="2022">2022</option>
									<option value="2023">2023</option>
								</select> <select name="quarter" value="${l.quarter}" id="">
									<option value="1">1분기</option>
									<option value="2">2분기</option>
									<option value="3">3분기</option>
									<option value="4">4분기</option>
								</select> <input type="text" name="amount" value="${l.amount}">
							</div>
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
				<a href="update?m=${param.m}&p=${startNum-5}&s=${param.s}"><i
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
						href="update?m=${param.m}&p=${startNum+i}&s=${param.s}">${startNum+i}</a>
					</li>
				</c:if>
			</c:forEach>
		</ul>

		<c:choose>
			<c:when test="${startNum+4<lastNum}">
				<a href="update?m=${param.m}&p=${startNum+5}&s=${param.s}"><i
					class="fas fa-arrow-alt-circle-right fa-2x"></i> </a>
			</c:when>
			<c:otherwise>
				<i class="fas fa-arrow-circle-right fa-2x"
					onclick="alert('다음 페이지가 없습니다.');"></i>
			</c:otherwise>
		</c:choose>
	</div>

</section>