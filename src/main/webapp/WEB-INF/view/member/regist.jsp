<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://kit.fontawesome.com/096073a2a8.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../../js/member.js"></script>
	<main id="reg-main">
		<section class="content-container">
			<h1 class="d-none">기본정보입력</h1>
			<form class="form-row reg-form" name="regFrm" method="post"
				action="regist">
				<div>
					<label for="uid">아이디</label> <input id="uid" name="uid" type="text"
						placeholder="아이디 입력" /> <input type="button" value="중복확인"
						class="btn-style" onClick="uidCheck(this.form.uid.value)">
				</div>

				<div>
					<label for="email">이메일</label> <input type="text" name="email1"
						value="" placeholder="이메일 입력" /> @ <input type="text"
						name="email2" value="" readonly="true" /> <select
						name="emailCheck2" class="select-email"
						onchange="SetEmailTail(emailCheck2.options[this.selectedIndex].value)">
						<option value="notSelected">::선택하세요::</option>
						<option value="naver.com">naver.com</option>
						<option value="nate.com">nate.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="hanmail.net">daum.net</option>
						<option value="etc">직접입력</option>
					</select> <input type="button" class="button-b btn-style" value="중복확인"
						onClick="emailCheck(this.form.email1.value+'@'+this.form.email2.value)">
				</div>

				<div>
					<label for="pwd">비밀번호</label> <input id="pwd" name="pwd"
						type="password" placeholder="비밀번호 입력" />
				</div>
				<div>
					<label for="repwd">비밀번호확인</label> <input id="repwd" name="repwd"
						type="password" placeholder="비밀번호 재입력" />
				</div>
				<div>
					<label for="nickname">닉네임</label> <input id="nickname"
						name="nickname" type="text" placeholder="닉네임 입력" /> <input
						type="button" value="중복확인" class="button-b btn-style"
						onClick="nickCheck(this.form.nickname.value)">
				</div>
				<div>
					<fieldset class="gender">
						<input id="male" type="radio" name="gender" value="남자" class="radio"
							checked="checked" /> <label for="male" class="radio-label">남자</label>
						<input id="female" type="radio" name="gender" value="여자" class="radio"/> <label
							for="female" class="radio-label">여자</label>
					</fieldset>
				</div>
				<div class="content-end">
					<input class="btn-style" type="button" value="취소"
						onclick="location.href='/main'"> &nbsp; <input
						class="btn-style" type="button" value="가입하기" onclick="inputCheck()">
				</div>
				<!--  "inputCheck()"-->
			</form>
		<div class="content-login">
			<h1 class="d-none">기존회원 로그인</h1>
			<div>
				이미 회원이신가요?<a href="login" class="go-to-login">로그인하기</a>
			</div>
		</div>
		</section>
	</main>
