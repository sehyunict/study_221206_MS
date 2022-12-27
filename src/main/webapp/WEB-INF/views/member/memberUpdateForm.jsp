<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEHYUNICT MUSIC</title>
<style>
	.updateForm {
		margin-top:15px; 
		margin-bottom:20px; 
		width :100%; 
		padding: 15px;
		text-align: left;
		background: #eee; 
		font-size:16px; 
		line-height: 35px;
	}
	.updateForm th{
		text-align: left;
		width: 160px;
	}
	.updateForm input, select{
		height: 25px;
	}
</style>
</head>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 생년월일 설정
		let month = '<fmt:formatDate value="${memberVo.member_birthdate}" pattern="MM"/>';
		$("#month").val(month).prop("selected", true);
		
		// 비밀번호 재확인 체크
	    $('#pwCheck').keyup(function(e) {
	    	$('#show').text('');
	    	
	    	if(pwCheck.value != "") {
		    	if($("#pw").val() == $("#pwCheck").val()) {
		    		$('#show').text('비밀번호가 동일합니다.');
		    	} else {
		    		$('#show').text('비밀번호가 동일하지 않습니다.');
		       	}
	    	}
	    });
	    
	    $('#pwCheck').keyup();
	});
	
	function chkForm() {
		// 비밀번호 널 값 확인
    	if($("#pw").val() == "") {
    		alert("비밀번호를 입력하세요");
    		return false;
    	}
		
		// 전화번호 정규식
		let phone = $("#phone").val();
		
		phone = phone.replace(/[^0-9]/g, '') // 숫자를 제외한 모든 문자 제거
		phone = phone.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
		
		$("#phone").val(phone);
		
		// 폼 전송
		if($("#pw").val() == $("#pwCheck").val()) {
			// 생년월일 저장
			let year = $("#year").val();
			let month = $("#month").val();
			let date = $("#date").val();
			
			let birth = year + "-" + month + "-" + date;
			
			$("#memberBirth").val(birth);
			
			$("#updateMember").method = "post";
			$("#updateMember").action = "/MU";
			
			$("#updateMember").submit();
		} else {
			alert("비밀번호 재확인");
			return false;
		}
	}
	
	function deleteMember() {
		$("#deleteMember").method = "post";
		$("#deleteMember").action = "/MDT";
		
		$("#deleteMember").submit();
	}
</script>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<section>
		<h2>회원정보 수정</h2>
		<form class="updateForm" id="updateMember" action="/MU" method="post">
			<input type="hidden" id="memberNo" name="memberNo" value="${memberVo.member_no}">
			<input type="hidden" id="memberBirth" name="memberBirth" value="">
			<table>
				<tr>
					<th>아이디</th>
					<td>${memberVo.member_id}</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="pw" name="pw" value=""/></td>
				</tr>
				<tr>
					<th>비밀번호 재확인</th>
					<td><input type="password" id="pwCheck" name="pwCheck" value=""/><span id="show"></span></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${memberVo.member_name}"/></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><select name="gender">
						<option value="0" <c:if test="${memberVo.member_gender eq '남'}">selected</c:if>>남</option>
						<option value="1" <c:if test="${memberVo.member_gender eq '여'}">selected</c:if>>여</option>
					</select></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>
						<input type="text" id="year" name="year" value="<fmt:formatDate value="${memberVo.member_birthdate}" pattern="yyyy"/>" placeholder="년(4자)"/>
						<select id="month" name="month">
							<option value="01">1월</option>
							<option value="02">2월</option>
							<option value="03">3월</option>
							<option value="04">4월</option>
							<option value="05">5월</option>
							<option value="06">6월</option>
							<option value="07">7월</option>
							<option value="08">8월</option>
							<option value="09">9월</option>
							<option value="10">10월</option>
							<option value="11">11월</option>
							<option value="12">12월</option>
						</select>
						<input type="text" id="date" name="date" value="<fmt:formatDate value="${memberVo.member_birthdate}" pattern="dd"/>" placeholder="일"/>
					</td>
				</tr>
				<tr>
					<th>소개글</th>
					<td><textarea rows="5" cols="70" name="introduce">${memberVo.member_introduce}</textarea></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${memberVo.member_email}"/></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" id="phone" name="phone" value="${memberVo.member_phone}"/></td>
				</tr>
				<tr>
					<th>마케팅 여부</th>
					<td><select name="marketing">
						<option value="0" <c:if test="${memberVo.member_marketingCheck eq '0'}">selected</c:if>>비동의</option>
						<option value="1" <c:if test="${memberVo.member_marketingCheck eq '1'}">selected</c:if>>동의</option>
					</select></td>
				</tr>
			</table>
		</form>
		<form class="deleteForm" id="deleteMember" action="/MDT" method="post">
			<input type="hidden" id="memberNo" name="memberNo" value="${memberVo.member_no}">
		</form>
		<p><a href="#" onclick="chkForm()">수정</a>
		   <a href="#" onclick="deleteMember()">회원탈퇴</a></p>
	</section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>