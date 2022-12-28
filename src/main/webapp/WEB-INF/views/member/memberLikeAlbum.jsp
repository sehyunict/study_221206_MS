<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEHYUNICT MUSIC</title>
<style>
	table.liketb {
	  border-collapse: separate;
	  border-spacing: 1px;
	  text-align: left;
	  vertical-align: top;
	  line-height: 1.5;
	  margin: 20px 10px;
	}
	table.liketb th {
	  padding: 10px;
	  font-weight: bold;
	  color: #fff;
	  background: #a1a1a1 ;
	}
	table.liketb td {
	  width: 350px;
	  padding: 10px;
	  border-bottom: 1px solid #ccc;
	  background: #eee;
	}
	.pageInfo ul.pagination {
		list-style: none;
		display: inline-block;
	}
	
	.pageInfo ul.pagination li {
		float: left;
		margin-left : 5px;
		padding : 7px;
		font-weight : 500;
	}
	.active {background-color: #cdd5ec;}
</style>
</head>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function delAlbum(no) {
		let albumId = "#likeAlbum" + no;
		
		$.ajax({
			type : "POST",
			url  : "/MLAD",
			contentType : "application/json",
			data : JSON.stringify(no),
			success : function(response) {
				if (response > 0) {
					$(albumId).remove();
					alert("삭제되었습니다.");
				} else {
					alert("삭제실패");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("통신실패");
			}
		});
	}
	
	function pageClick(no) {
		$("#listForm").find("input[name='pageNum']:hidden").val(no);
		$("#listForm").method = "post";
		$("#listForm").action = "/MLA";
		
		$("#listForm").submit();
	}
</script>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<section>
		<h2>좋아요 한</h2>
		<p><a href="MLM">곡</a> / <a href="MLA">앨범</a> / <a href="MF">팬</a></p>
		<table class="liketb">
			<c:choose>
				<c:when test="${empty memberAlbumVo}">
					관심가는 콘텐츠를 좋아요 해보세요!
				</c:when>
				<c:otherwise>
					<tr>
						<th>앨범제목</th>
						<th>가수명</th>
						<th>발매일</th>
						<th>좋아요</th>
					</tr>
					<c:forEach var="memberAlbumVo" items="${memberAlbumVo}">
						<tr id="likeAlbum${memberAlbumVo.like_album_no}">
							<td>${memberAlbumVo.album_title}</td>
							<td>${memberAlbumVo.artist_name}</td>
							<td><fmt:formatDate value="${memberAlbumVo.album_date}" pattern="yyyy.MM.dd"/></td>
							<td><a href="#" onclick="delAlbum(${memberAlbumVo.like_album_no})">취소</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		
		<div class="pageInfo" style="text-align: center;">
		  <ul class="pagination">
		    <c:if test="${pageMaker.prev}">
		      <li class="pagination_btn">
		      	<a href="#" onclick="pageClick(${pageMaker.startPage - 1})">Previous</a>
		      </li>
		    </c:if>
			
			<!-- 각 번호 페이지 버튼 -->
		    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		      <c:if test="${num eq pageMaker.cri.pageNum}">
		        <li class="pagination_btn active">
		      </c:if>
		      <c:if test="${num ne pageMaker.cri.pageNum}">
		        <li class="pagination_btn">
		      </c:if>
		      	<a href="#" onclick="pageClick(${num})">${num}</a>
		        </li>
		    </c:forEach>
		
		    <c:if test="${pageMaker.next}">
			  <li class="pagination_btn">
		        <a href="#" onclick="pageClick(${pageMaker.endPage + 1})">Next</a>
		      </li>
		    </c:if>
		  </ul>
		</div>
		
		<form id="listForm" method="post">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		</form>
	</section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>