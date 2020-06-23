<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="notice-review">
    <h1 class="hidden">메인</h1>
    <div class="container">
        <div class="title">Product Main</div>
        <div class="container-table">
            <div class="title sub">상품등록현황</div>
            <table class="notice-table">
                <thead>
                    <tr>
                        <td>농심</td>
                        <td>삼양</td>
                        <td>오뚜기</td>
                        <td>팔도</td>
                        <td>GS25</td>
                        <td>CU</td>
                        <td>세븐일레븐</td>
                        <td>합계</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${count1}</td>
                        <td>${count2}</td>
                        <td>${count3}</td>
                        <td>${count4}</td>
                        <td>${count5}</td>
                        <td>${count6}</td>
                        <td>${count7}</td>
                        <td>${count8}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</section>