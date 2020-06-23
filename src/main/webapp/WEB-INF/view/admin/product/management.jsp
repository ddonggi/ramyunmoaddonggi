<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<main class="main">
	<aside class="aside-menu">
		<h2>
			<a href="">관리메뉴 제목</a>
		</h2>
		<div class="menu-tit">
			<i class="far fa-list-alt"></i>메뉴 제목1
		</div>
		<ul class="sub-menu">
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
		</ul>
		</div>
		<div class="menu-tit">
			<i class="far fa-list-alt"></i>분류 제목2
		</div>
		<ul class="sub-menu">
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
		</ul>
		</div>
		<div class="menu-tit">
			<i class="far fa-list-alt"></i>분류 제목3
		</div>
		<ul class="sub-menu">
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
		</ul>
		</div>
		<div class="menu-tit">
			<i class="far fa-list-alt"></i>분류 제목4
		</div>
		<ul class="sub-menu">
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
		</ul>
		</div>
		<div class="menu-tit">
			<i class="far fa-list-alt"></i>분류 제목5
		</div>
		<ul class="sub-menu">
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
			<li><a href=""><i class="fas fa-chevron-right"></i>서브메뉴</a></li>
		</ul>
		</div>
	</aside>

	<section class="contents">
		<h1 class="d-none">상품페이지</h1>
		<span>제품관리</span>
		<div class="reg">
			<input type="button" value="&#xf0fe">
		</div>
		<table class="item-table" border="1">
			<thead>
				<tr>
					<td colspan="2">TITLE</td>
					<td colspan="7" class="line">CONTENT</td>
					<td colspan="2" class="line">BUTTON</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="l" items="${list}">
					<tr class="label">
						<td rowspan="4"><img src="${l.img}"></td>
						<td rowspan="2">${l.name}</td>
						<td class="line">용량</td>
						<td>나트륨</td>
						<td>탄수화물</td>
						<td>당류</td>
						<td>지방</td>
						<td>Likes</td>
						<td>제조사</td>
						<td rowspan="4"><input type="checkbox"></td>
						<td class="line" rowspan="4">
							<a href="">
								<i class="far fa-edit fa-2x"></i>
							</a>
						</td>
					</tr>
					<tr class="inputs">
						<td class="line">${l.capacity}</td>
						<td>${l.natrium}</td>
						<td>${l.carbohydrate}</td>
						<td>${l.sugars}</td>
						<td>${l.fat}</td>
						<td>likes</td>
						<td>${l.mfr}</td>
					</tr>
					<tr class="label">
						<td rowspan="2">${l.id}</td>
						<td class="line"> 열량</td>
						<td>트랜스지방</td>
						<td>포화지방</td>
						<td>콜레스테롤</td>
						<td>단백질</td>
						<td>Review</td>
						<td>판매량</td>
					</tr>
					<tr class="inputs">
						<td class="line">${l.kcal}</td>
						<td>${l.transfat}</td>
						<td>${l.saturatedFat}</td>
						<td>${l.cholesterol}</td>
						<td>${l.protein}</td>
						<td>reviews</td>
						<td>${l.amount}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="del">
			<input type="button" value="&#xf2ed" name="" id="">
		</div>

		<section class="pager">
			<h1 class="d-none">pager</h1>

			<c:set var="page" value="${(empty param.p)?1:param.p}" />
			<c:set var="startNum" value="${page-(page-1)%5}" />
			<c:set var="lastNum" value="${fn: substringBefore(count/5+1,'.')}" />

			<a href="management?m=${param.m}&p=${page-1>=1?page-1:1}&s=${param.s}">
				<i class="fas fa-arrow-circle-left"></i>
			</a>

			<ul>
				<c:forEach begin="0" end="4" var="i">
					<li><a href="management?m=${param.m}&p=${startNum+i}&s=${param.s}">${startNum+i}</a>
					</li>
				</c:forEach>
			</ul>

			<a href="management?m=${param.m}&p=${(page+1<=lastNum)?page+1:lastNum}&s=${param.s}">
				<i class="fas fa-arrow-circle-right"></i>
			</a>

		</section>

	</section>

</main>