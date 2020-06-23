/** -------------회원가입 조건처리 ----------------- */

function inputCheck() {

	var frm = document.regFrm;
	var check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,18}$/.test(frm.pwd.value); // 영문,숫자

	var check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{6,18}$/
			.test(frm.pwd.value); // 영문,특수문자

	var check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{6,18}$/.test(frm.pwd.value); // 특수문자,
	// 숫자

	if (frm.uid.value == "") {
		alert("아이디를 입력해 주세요.");
		frm.uid.focus();
		return;
	}
	if (frm.email1.value == "") {
		alert("이메일을 입력해 주세요.");
		frm.email.focus();
		return;
	}

	if (frm.email2.value == "") {
		alert("이메일을 입력해 주세요.");
		frm.email.focus();
		return;
	}

	if (frm.pwd.value == "") {
		alert("비밀번호를 입력해 주세요.");
		frm.pwd.focus();
		return;
	}
	if (frm.repwd.value == "") {
		alert("비밀번호를 확인해 주세요.");
		frm.repwd.focus();
		return;
	}

	if (!(check1 || check2 || check3)) {

		alert("비밀번호는 영문 대소문자, 숫자, 특수문자 중 최소 2개 조합으로  6~18자리까지 가능합니다");
		frm.repwd.focus();
		return false;

	}

	if (/(\w)\1\1/.test(frm.pwd.value)) {

		alert('비밀번호에 같은 문자를 3번 이상 사용하실 수 없습니다');
		frm.pwd.focus();
		return false;

	}

	if (frm.pwd.value.search(frm.uid.value) > -1) {

		alert("비밀번호에 아이디가 포함될 수 없습니다");
		frm.pwd.focus();
		return false;

	}

	if (frm.repwd.value == "") {
		alert("비밀번호를 확인해 주세요.");
		frm.pwd.focus();
		return;
	}

	if (frm.nickname.value == "") {
		alert("닉네임을 입력해 주세요.");
		frm.nickname.focus();
		return;
	}
	if (frm.pwd.value != frm.repwd.value) {
		alert("비밀번호가 일치하지 않습니다.");
		frm.repwd.value = "";
		frm.repwd.focus();
		return;
	}
	// var str = frm.email.value;
	var str = frm.email1.value + '@' + frm.email2.value;
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;

	if (atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1
			&& commaPos == -1 && atPos + 1 < dotPos && dotPos + 1 < eMailSize)
		;
	else {
		alert('E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요');
		frm.email1.focus();
		return;
	}

	frm.submit();
}

function admit() {
	var req = document.form.req.checked;
	var num = 0;
	if (req == true) {
		num = 1;
	}
	if (num == 1) {
		location.href = "regist";
	} else {
		alert("서비스 이용약관에 동의하셔야 합니다.");
	}
}

function uidCheck(uid) {

	frm = document.regFrm;
	if (uid == "") {
		alert("아이디를 입력해 주세요");
		frm.uid.focus();
		return;
	}
	if ((new RegExp(/[^a-z|^0-9]/gi)).test(frm.uid.value)) {
		alert("한글아이디는 불가능합니다");
		frm.uid.focus();
		return;
	}
	url = "uidCheck?uid=" + uid;
	window.open(url, "UidCheck", "width=330,height=150");
}

function nickCheck(nickname) {

	frm = document.regFrm;
	if (nickname == "") {
		alert("닉네임을 입력해 주세요");
		frm.nickname.focus();
		return;
	}

	url = "nickCheck?nickname=" + nickname;
	window.open(url, "NickCheck", "width=330,height=150");
}

function emailCheck(email) {
	frm = document.regFrm;
	if (email == "@") {
		alert("이이메일을 입력해 주세요");
		frm.email.focus();
		return;
	}

	if ((new RegExp(/[^a-z|^0-9]/gi)).test(frm.email1.value)) {
		alert("한글 이메일 형식은 불가능합니다");
		frm.uid.focus();
		return;
	}

	url = "emailCheck?email=" + email;
	window.open(url, "EmailCheck", "width=300,height=150");
}

function SetEmailTail(emailValue) {
	var email = document.all("email1") // 사용자 입력
	var emailTail = document.all("email2") // Select box

	if (emailValue == "notSelected")
		return;
	else if (emailValue == "etc") {
		emailTail.readOnly = false;
		emailTail.value = "";
		emailTail.focus();
	} else {
		emailTail.readOnly = true;
		emailTail.value = emailValue;
	}
}

/** ------로그인 - 로그아웃 ------ */
function loginCheck() {
	var loginForm = document.loginFrm;

	if (loginForm.uid.value == "") {
		alert("아이디를 입력해 주세요");
		loginForm.uid.focus();
		return;
	}

	if (loginForm.pwd.value == "") {
		alert("비밀번호를 입력해 주세요");
		loginForm.pwd.focus();
		return;
	}
	loginForm.submit();

}
function regist() {
	location.href = "/member/member-term";
	// window.open(url,"","width=500, height=500,left=900,top=200");
	// window.location.replace("index.jsp");
};
function logout() {

	var result = confirm("정말 로그아웃 하시겠습니까?");
	console.log(result);
	if (result) {
		alert("로그아웃 되었습니다");
		location.href = "/member/logout";
	}
}

/** ----------------마이 페이지------------- */

function changePwdProc(){
		var changePwd = document.changePwdFrm;

		if (changePwd.pwd.value == "") {
		alert("비밀번호를 입력해 주세요.");
		changePwd.pwd.focus();
		return;
	}
	changePwd.submit();
}

function checkPwdProc(){

		var checkPwd = document.checkPwdFrm;

		if (checkPwd.pwd.value == "") {
		alert("비밀번호를 입력해 주세요.");
		checkPwd.pwd.focus();
		return;
	}
	checkPwd.submit();
}

function quitProc() {
	var quitForm = document.quitFrm;

	confirm("정말 탈퇴 하시겠습니까? 기존 정보는 지워집니다");

	if (quitForm.pwd.value == "") {
		alert("비밀번호를 입력해 주세요.");
		quitForm.pwd.focus();
		return;
	}
		quitFrm.submit();
}