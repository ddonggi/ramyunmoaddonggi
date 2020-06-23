<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main id="mypage-main">
<section class="main-section">
	<div>
		<form class="form-row change-pwd-check" name="checkPwdFrm" method="post" action="change-pwd-check">
		<h1 class="d-none">비밀번호 변경</h1>
			<table>	
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td>
						<div>
							<input class="btn-style" type="button" value="뒤로가기" onclick="history.back()">&nbsp;
							<input class="btn-style" type="button" value="확인" onclick="checkPwdProc()">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	</section>
</main>