<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="mMgr" class="com.ramyunmoa.web.service.MemberService"/>
<%
	String nickname = request.getParameter("nickname");
	boolean result = mMgr.checkNick(nickname);
 %>
<body>
	<div>
	<br>
		<b><%=nickname%></b>
		<%
			if(result){
				out.println("는 이미 존재하는 닉네임입니다.<p/>");
			} else{
				out.println("는 사용 가능합니다.<p/>");
			}
		%>
		<a href="#" onClick="self.close()">닫기</a>
	</div>
</body>
