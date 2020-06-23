<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>



<!DOCTYPE html>

<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AdminPage</title>
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script src="https://kit.fontawesome.com/096073a2a8.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/admin/layout.css">
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap"
	rel="stylesheet">
<link href='<tiles:getAsString name="css"/>' type="text/css"
	rel="stylesheet" />
<script type="text/javascript" src="/js/member/member.js"></script>
<style>
</style>
</head>

<body>

	<!-- header -->

	<tiles:insertAttribute name="header" />

	<main class="main">
		<!-- main -->

		<tiles:insertAttribute name="aside" />
		<tiles:insertAttribute name="main" />

	</main>
	<!-- footer -->

	<tiles:insertAttribute name="footer" />


</body>

</html>