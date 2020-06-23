<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>칼로리 계산기</title>
<link rel="shortcut icon" href="/images/main/favicon.png" type="image/favicon">
<link rel="stylesheet" href="/css/main/calc.css">
<script src="/js/calc.js"></script>
</head>
<body>
   <div id="calc">
      <div class="select-area">
         <form class="total-kcal">
            <label>총칼로리 
               <input class="kcal-view" name="kcal" value="" readonly>
            </label>
         </form>
         <div class="calc-top">
               <label for="manufacturer-select">제조사 - 라면</label> 
               <select id="ramyun-select">
                  <c:forEach var="info" items="${prodList}" varStatus="status">
                     <option class="value" value="${info.kcal}" selected>
                        &#10094${info.mfr}&#10095 ${info.name}
                     </option>
                  </c:forEach>
               </select>
               
               <button class="add-btn">추가</button>
         </div>
         <form class="form">
            <fieldset>
               <legend>추가된 라면</legend>
               <div></div>
            </fieldset>
         </form>

      </div>
      <div class="calculation-btn">
         <button class="re-sum-btn" onClick="window.location.reload()">다시 계산하기</button>
      </div>
   </div>
</body>
</html>