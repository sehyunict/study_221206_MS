<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Admin Album</title>
</head>

<style>
.pagination
	  {
        justify-content : center;
      }
</style>

<script>

//체크박스 전체선택 및 해제

function checkSelectAll()  {
  // 전체 체크박스
  const checkboxes 
    = document.querySelectorAll('input[name="checkbox"]');
  // 선택된 체크박스
  const checked 
    = document.querySelectorAll('input[name="checkbox"]:checked');
  // select all 체크박스
  const selectAll 
    = document.querySelector('input[name="selectall"]');
  
  console.log(checked, selectAll, checkboxes);
  
  if(checkboxes.length === checked.length)  {
    selectAll.checked = true;
  }else {
    selectAll.checked = false;
  }

}

function selectAll(selectAll)  {
  const checkboxes 
       = document.getElementsByName('checkbox');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
}
</script>

<body>

	<%@ include file="/WEB-INF/views/include/adHeader.jsp"%>

	<div class="container mt-3">
		<h2>Album List</h2>
		<p>전체 앨범수 : ${pageMaker.totalCount}</p>
		<div align="right">
			<form:form action="/adminMember" modelAttribute="pvo">
				<select class="form-select" name=select
					style="display: inline-block; width: 10%">
					<option value="member_name">이름검색</option>
					<option value="member_id">아이디검색</option>
					<option value="member_email">이메일검색</option>
				</select>
				<input type="text" name="keyword" class="form-control"
					placeholder="${keyword}" style="display: inline-block; width: 20%">
				<input type="submit" class="btn btn-primary" value="검색">
			</form:form>
		</div>
		<table class="table" style="margin-top: 10px;">
			<thead style="background-color:#E2E2E2;">
				<tr>
					<th>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="selectall"
								value="something" onclick='selectAll(this)'>
						</div>
					</th>
					<th>장르</th>
					<th>앨범명</th>
					<th>가수</th>
					<th>타입</th>
					<th>회사</th>
					<th>출시일</th>
					<th>좋아요</th>
					<th>관리</th>
				</tr>
			</thead>
			<tbody id="albumList">
				<c:forEach items="${adminAlbumList}" var="e">
					<tr>
						<th>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="checkbox"
									value="${e.album_no}" onclick=''>
							</div>
						</th>
						<th>${e.com_code}</th>
						<th>${e.album_title}</th>
						<th>${e.artist_name}</th>
						<th>${e.album_type}</th>
						<th>${e.album_commany}</th>
						<th>${e.album_date}</th>
						<th>${e.album_like}</th>
						<th><form:form action="/adAlbumInfo" modelAttribute="vo">
								<input type="hidden" name="album_no" value="${e.album_no}">
								<button type="submit" class="btn btn-light">관리</button>
							</form:form></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container mt-3" align="right">
			<button type="button" class="btn btn-danger" onclick='checkDeleteAB()'>선택항목삭제</button>
			<button type="button" class="btn btn-primary" onclick="window.location.href='/adMusicInsert'">음악 추가</button>
		</div>
	</div>
	<ul class="pagination">
		<c:if test="${pageMaker.prev}">
			<li class="page-item"><a class="page-link"
				href="/adminAlbum${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
		</c:if>

		<c:set var="nowpage" value="${pageMaker.pvo.page}" />
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
			var="i">
			<c:choose>
				<c:when test="${nowpage == i}">
					<li class="page-item"><a class="page-link"
						style="background-color: #dee2e6"
						href="/adminAlbum${pageMaker.makeQuery(i)}">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="/adminAlbum${pageMaker.makeQuery(i)}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>


		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li class="page-item"><a class="page-link"
				href="/adminAlbum${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
		</c:if>

	</ul>

	<%@ include file="/WEB-INF/views/include/adFooter.jsp"%>
</body>
<script>

//선택항목 삭제
	function checkDeleteAB(){
	
	var checkList = new Array();
	var checked = document.querySelectorAll("input[name=checkbox]:checked");
	
		for (var i = 0; i < checked.length; i++){
			
			checkList.push(checked[i].value);
		
		}
		console.log(checkList);
	
 	$.ajax({
 		
 		type : "POST",
        url : "/adminAlbum/chdelete",
        traditional : true,
        data : {
        	 'checkList' : checkList
        }, 
        success : function(){
        	
        	alert ("선택항목 삭제에 성공했습니다.");
        	
        	location = "/adminAlbum";
			
    	},
    	
        error : function(jqXHR, textStatus, errorThrown) {
      	  
      	  alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
        }
    	
 	})
};

</script>
</html>