<%@page import="sehyunict.member.album.entity.AlbumVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 앨범 목록</title>
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
span {
	font-size: 20pt;
	font-weight:bold;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<div class="wrap">
		<table summary="사용자 앨범 상세" border=0>
			<caption>
				<span style="font-size:20pt">사용자 앨범 상세</span>
			</caption>
			<thead>
				<tr>
					<th>음악번호</th>
					<th>사용자앨범의 음악 타이틀</th>
					<th>아티스트명</th>
					<th>사용자 앨범 음악 등록일</th>
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
				<c:forEach var="list" items="${memberDetailsList}"
					varStatus="status">
					<tr>
						<td>${list.MUSIC_No}</td>
						<td>${list.MUSIC_Title}</td>
						<td>${list.ARTIST_Name}</td>
						<td>${list.MAM_date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>