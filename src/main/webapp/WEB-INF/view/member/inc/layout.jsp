<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>라면모아-국내 최대 라면 커뮤니티</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet" href="/css/main/main.css">
<link rel="stylesheet" href="/css/member/regist.css" type="text/css">
<link rel="stylesheet" href="/css/member/myPage.css" type="text/css">
<link rel="shortcut icon" href="../images/main/favicon.png"
	type="image/png">
<!-- <script src="https://kit.fontawesome.com/096073a2a8.js"crossorigin="anonymous"></script> -->

<script type="text/javascript" src="/js/member/member.js"></script>
<script src="/js/main.js"></script>
</head>

<body>
	<!-- header 부분 -->
	<tiles:insertAttribute name="header" />

	<!-- --------------------------- <body> --------------------------------------- -->
	<!-- --------------------------- aside --------------------------------------- -->
	<section class="section-layout">
		<tiles:insertAttribute name="aside" />


		<!-- --------------------------- main --------------------------------------- -->
		<tiles:insertAttribute name="main" />
	</section>
	<!-- ------------------- <footer> --------------------------------------- -->
	<tiles:insertAttribute name="footer" />

</body>
</html>