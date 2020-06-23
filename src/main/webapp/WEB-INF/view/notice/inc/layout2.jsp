<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en" class="admin-html">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="../images/main/favicon.png"
	type="image/png">
<link rel="stylesheet" href="/css/main/main.css">
<!--     <link href="/css/board/notice/rmreset.css" type="text/css" rel="stylesheet"> -->
<link href="/css/board/notice/rmstyle.css" type="text/css"
	rel="stylesheet">
<title>AdminPage</title>
</head>

<body class="admin-body">
	<tiles:insertAttribute name="header" />

	<div id="body">
			<tiles:insertAttribute name="aside" />
		<div class="content-container">


			<tiles:insertAttribute name="main" />


		</div>
	</div>

	<tiles:insertAttribute name="footer" />

</body>

</html>