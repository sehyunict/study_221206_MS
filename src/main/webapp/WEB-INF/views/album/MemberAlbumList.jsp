<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEHYUNICT MUSIC</title>
<style type="text/css">
#table {
	
}

.wrap {
	padding: 30px;
}

.wrap table th, .wrap table td {
	border: 1px solid #000;
	font-size: 20px;
}

.wrap table th {
	background: #eee;
}

.wrap table th, .wrap table td {
	padding: 20px;
}

spane {
	font-size: 20pt;
	font-weight:bold;
}
</style>

</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<div class="wrap">
		<table id="table" summary="목록" border=1>
			<caption>
				<span style="font-size:20pt">목록</span>
				<span style="">총 : 4 건</span>
			</caption>
			<thead>
				<tr>
					<th>사용자번호</th>
					<th>사용자명</th>
					<th>사용자앨범번호</th>
					<th>사용자앨범이름</th>
					<th>앨범생성일</th>
					<th>앨범커버</th>
					<!-- <th>사용자 앨범명 수정</th> -->
					<th>사용자 앨범 삭제</th>
				</tr>
			</thead>

			<c:if test="${List.size() == 0 }">
				<tfoot>
					<tr>
						<td colspan="3">현재 데이타가 없습니다.</td>
					</tr>
				</tfoot>
			</c:if>
			<tbody>
				<c:forEach var="memberAlbumList" items="${list}" varStatus="status">
					<tr id="album${memberAlbumList.MEMBER_ALBUM_No}">
						<td><c:out value="${memberAlbumList.MEMBER_No }" /></td>
						<td><c:out value="${memberAlbumList.MEMBER_Name }" /></td>
						<td><a
							href="/ma/detail?memberAlbumNo=${memberAlbumList.MEMBER_ALBUM_No}"><c:out
									value="${memberAlbumList.MEMBER_ALBUM_No }" /></a></td>
						<td><a
							href="/ma/update?memberAlbumNo=${memberAlbumList.MEMBER_ALBUM_No}"><c:out
									value="${memberAlbumList.MEMBER_ALBUM_Title }" /></a></td>
						<td><c:out value="${memberAlbumList.MEMBER_ALBUM_Date }" /></td>
						<td><c:out value="${memberAlbumList.MEMBER_ALBUM_Jacket }" /></td>
						<td><button value="삭제"
								onclick="maDelete(${memberAlbumList.MEMBER_ALBUM_No});">사용자
								앨범이름 삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		function maDelete(memberAlbumNo) {
			$.ajax({
				type: "POST",
				url: "/ma/delete",
				contentType: "application/json",
				data: JSON.stringify(memberAlbumNo),
				success: function(data) {
					// 성공 그리드 로우 삭제
					let albumId = "#album" + memberAlbumNo;
					$(albumId).remove();
					
					// 성공 알림 안내
					alert(memberAlbumNo + "번 앨범 삭제되었습니다.");
				}
			})
		}
	</script>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>