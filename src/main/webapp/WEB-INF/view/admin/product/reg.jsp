<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<section class="contents">

	<h1 class="hidden">상품페이지</h1>
	<div class="title">Register</div>

	<form action="reg" method="post" enctype="multipart/form-data">
		<table class="item-table" border="1">
			<tbody>
				<tr>
					<td class="bold" rowspan="2">품명</td>
					<td colspan="2" rowspan="4">
						<div class="img-cell">
							<div class="regImg">
								<img src="" alt="">
							</div>
							<input type="file" name="img">
						</div>
					</td>
					<td class="bold">나트륨</td>
					<td class="bold">탄수화물</td>
					<td class="bold">당류</td>
					<td class="bold">지방</td>
				</tr>
				<tr>
					<td><input type="text" name="natrium" id="">g</td>
					<td><input type="text" name="carbohydrate" id="">g</td>
					<td><input type="text" name="sugars" id="">g</td>
					<td><input type="text" name="fat" id="">g</td>
				</tr>
				<tr>
					<td rowspan="2"><input type="text" name="name" id=""></td>
					<td class="bold">트랜스지방</td>
					<td class="bold">포화지방</td>
					<td class="bold">콜레스테롤</td>
					<td class="bold">단백질</td>
				</tr>
				<tr>
					<td><input type="text" name="transfat" id="">g</td>
					<td><input type="text" name="saturatedFat" id="">g</td>
					<td><input type="text" name="cholesterol" id="">g</td>
					<td><input type="text" name="protein" id="">g</td>
				</tr>
				<tr>
					<td class="bold">용량</td>
					<td class="bold">열량</td>
					<td class="bold">제조사</td>
					<td class="bold" colspan="3">판매량</td>
					<td class="bold" rowspan="2"><input type="submit" value="등록"></td>
				</tr>
				<tr>
					<td><input type="text" name="capacity" id="">g</td>
					<td><input type="text" name="kcal" id="">kcal</td>
					<td><select name="mfr" id="">
							<option value="">농심</option>
							<option value="">삼양</option>
							<option value="">오뚜기</option>
							<option value="">팔도</option>
							<option value="">CU</option>
							<option value="">GS25</option>
							<option value="">세븐일레븐</option>
					</select></td>
					<td><select name="year" id="">
							<option value="">2019</option>
							<option value="">2020</option>
							<option value="">2021</option>
							<option value="">2022</option>
							<option value="">2023</option>
					</select></td>
					<td><select name="quarter" id="">
							<option value="">1분기</option>
							<option value="">2분기</option>
							<option value="">3분기</option>
							<option value="">4분기</option>
					</select></td>
					<td><input type="text" name="amount" id=""></td>
				</tr>
			</tbody>
		</table>
	</form>

</section>