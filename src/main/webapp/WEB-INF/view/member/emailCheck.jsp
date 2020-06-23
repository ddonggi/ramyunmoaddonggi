<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="mMgr" class="com.ramyunmoa.web.service.MemberService"/>
<%request.setCharacterEncoding("UTF-8");%>
<%
	String email = request.getParameter("email");
	boolean result = mMgr.checkEmail(email);
%>

<html>
<head>
	<title>이메일 중복체크</title>
	<link href="../css/member/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
	<br>
		<b><%=email%></b>
		<%
			if(result){
				out.println("는 이미 사용중인 이메일 입니다<p/>");
			} else{
				out.println("는 사용 가능합니다<p/>");
			}
		%>
		<a href="#" onClick="self.close()">닫기</a>
	</div>
</body>
</html>