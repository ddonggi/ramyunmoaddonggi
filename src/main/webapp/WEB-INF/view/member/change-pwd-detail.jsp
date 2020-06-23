<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main id="mypage-main">
<section class="main-section">
<h1 class="d-none">비밀번호 변경</h1>
	<div>
		<form class="form-row change-pwd-detail" name="changePwdFrm" method="post" action="change-pwd-detail">
			<table>
				<tr>
					<td>새 비밀번호</td>
					<td><input type="password" name="newpwd"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="newpwd-confirm"></td>
				</tr>
				<tr>
					<td>
						<div>
							<input class="btn-style" type="button" value="뒤로가기" onclick="history.back()">&nbsp;
							<input class="btn-style" type="button" value="확인" onclick="changePwdProc()">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	</section>
</main>