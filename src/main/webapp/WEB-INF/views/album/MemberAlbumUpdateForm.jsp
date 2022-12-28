<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEHYUNICT MUSIC</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp" />

	<!-- <script>
		function updateBtn(){
			let mNo = document.updateForm.mNo.value;
			let title = document.updateForm.title.value;
			
			
			updateForm.submit();
		}	
	</script> -->

	<form name="updateForm" action="/ma/update" method="post">
		<div>
			<label for="mNo">사용자앨범번호</label>
			<input id="mNo" name="MEMBER_ALBUM_No" type="text" value="${mav.MEMBER_ALBUM_No}" readonly>
			<br/>
			<label for="title">사용자앨범타이틀</label>
			<input id="title" name="MEMBER_ALBUM_Title" type="text" value="${mav.MEMBER_ALBUM_Title}">
		</div>
		<br/>
		<!-- <button type="button" onclick="updateBtn(); return false();">수정</button> -->
		<button type="submit">수정</button>
	</form>
	
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>