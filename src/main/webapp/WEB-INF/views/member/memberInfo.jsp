<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 회원 탈퇴 시 메인 페이지로 이동 -->
<c:if test="${result eq 1}">
	<script>
		alert("탈퇴되었습니다.");
		location.href = "/";
	</script>	 
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEHYUNICT MUSIC</title>
<style>
	.mypage{
		margin-top:15px; 
		margin-bottom:20px; 
		width :100%; 
		padding: 15px; 
		background: #eee; 
		line-height: 28px;
	}
	.infoTable{
		margin: 20px 0 20px;
	}
	.infoTable th{
		text-align: left;
		width: 60px;
	}
</style>
</head>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function updateForm() {
		$("#updateForm").submit();
	}
</script>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<section>
		<h2>마이페이지</h2>
		<p><a href="MI">내 정보</a> / <a href="MLM">마이뮤직</a></p>
		<div class="mypage">
			<form class="updateForm" id="updateForm" action="/MUF" method="post">
			    <input type="hidden" id="memberNo" name="memberNo" value="${memberVo.member_no}">
			</form>
			<p><font style="font-weight:bold;">${memberVo.member_id}</font>님</p>
			<c:if test="${memberVo.member_profile eq null}">
	 			<img src="resources/img/default.gif" width="150" height="150">
			</c:if>
			<p><c:if test="${empty memberVo.member_introduce}">소개글이 없습니다.</c:if> ${memberVo.member_introduce}</p>
			
			<table class="infoTable">
				<tr>
					<th>이 름</th>
					<td>${memberVo.member_name}</td>
				</tr>
				<tr>
					<th>성 별</th>
					<td>${memberVo.member_gender}</td>
				</tr>
				<tr>
					<th>생 일</th>
					<td><fmt:formatDate value="${memberVo.member_birthdate}" pattern="yyyy.MM.dd"/></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${memberVo.member_email}</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${memberVo.member_phone}</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td><fmt:formatDate value="${memberVo.member_date}" pattern="yyyy.MM.dd"/></td>
				</tr>
			</table>
			
			<p style="margin-bottom:15px; border-top: 1px solid rgba(0,0,0,0.06);"></p>
			<p>이용중인 상품</p>
			<p><font style="font-weight:bold;">${memberVo.member_subscription}</font></p>
			<p>회원님의 등급은 <font style="font-weight:bold; color:#59d18e">${memberVo.member_rating}</font> 입니다</p>
		</div>
		<a href="#" onclick="updateForm()">회원정보수정</a>
	</section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>