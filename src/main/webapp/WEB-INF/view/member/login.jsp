<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main id="login-main">
	<div>
		<form class="form-row login-form" name="loginFrm" method="post"	action="login?returnURL=${param.returnURL}">
			<table>
				<tr>
					<td>아이디</td>
					<td><input name="uid"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td>
						<div>
							<input type="button" value="로그인" class="btn-style" onclick="loginCheck()">&nbsp;
							<input class="btn-style" type="button" value="회원가입" onclick="regist()">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
</main>
