<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>라면모아 - 국내 최대 라면 커뮤니티</title>
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<!-- <link rel="stylesheet" href="../css/board/review/layout.css"> -->
<link rel="stylesheet" href="/css/main/main.css">
<link rel="shortcut icon" href="../images/main/favicon.png" type="image/png">

<script src="/js/main.js"></script>
<script type="text/javascript" src="/js/member/member.js"></script>
<script type="text/javascript" src="/js/utils.js"></script>
</head>

<body>
   <!-- -------------- header-----------------  -->
   <tiles:insertAttribute name="header" />


   <!-- -------------- main-----------------  -->

   <tiles:insertAttribute name="main" />
   <!-- <main class="main">
      <img src="images/main/라면이미지1.jpg" alt="라면" class="main-img">
   </main> -->

   <!-- -------------- footer-----------------  -->
   <tiles:insertAttribute name="footer" />

</body>

</html>