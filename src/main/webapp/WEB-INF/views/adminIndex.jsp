<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>AdminUserList</title>
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
		<h2>User List</h2>
		<div align="right">
		<form:form action="/adminMember" modelAttribute="pvo">
			<select class="form-select" name = select style = "display: inline-block; width: 10%">
				<option value = "MEMBER_NAME">이름검색</option>
				<option value = "MEMBER_ID">아이디검색</option>
				<option value = "MEMBER_EMAIL">이메일검색</option>
			</select> 
			<input type="text" name="keyword" class="form-control" placeholder="${keyword}" style = "display: inline-block; width: 20%">
			<input type="submit" class="btn btn-primary" value="검색">
			</form:form>
		</div>
		

		<table class="table table-striped">
			<thead>
				<tr>
					<th>
						<div class="form-check">
						  	<input class="form-check-input" type="checkbox" name="selectall" value="something" onclick='selectAll(this)'>
						</div>
							
					</th>
					<th>회원번호</th>
					<th>ID</th>
					<th>이름</th>
					<th>이메일</th>
					<th>회원관리</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${adminMemberList}" var="e">
					<tr>
						<th>
							<div class="form-check">
						  		<input class="form-check-input" type="checkbox" name="checkbox" value="something" onclick='checkSelectAll()'>
							</div>
						</th>
						<th>${e.MEMBER_No}</th>
						<th>${e.MEMBER_Id}</th>
						<th>${e.MEMBER_Name}</th>
						<th>${e.MEMBER_Email}</th>
						<th>
						<form:form action="/admember/info" modelAttribute="vo">
						<input type="hidden" name = "MEMBER_No" value="${e.MEMBER_No}">
						<button type="submit" class="btn btn-light">관리</button>
						</form:form>
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container mt-3" align="right">
	  	<button type="button" class="btn btn-danger">선택항목 삭제</button>
		</div>
	</div>
	<ul class="pagination">
		<c:if test="${pageMaker.prev}">
			<li class="page-item"><a class="page-link"
				href="/adminMember${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
		</c:if>
		<c:set var="nowpage" value="${pageMaker.pvo.page}" />
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
			var="i">
			<c:choose>
				<c:when test="${nowpage == i}">
					<li class="page-item"><a class="page-link"
						style="background-color: #dee2e6"
						href="/adminMember${pageMaker.makeQuery(i)}">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="/adminMember${pageMaker.makeQuery(i)}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li class="page-item"><a class="page-link"
				href="/adminMember${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
		</c:if>
		</ul>
		
	<%@ include file="/WEB-INF/views/include/adFooter.jsp"%>

</body>

<script>

//선택항목 삭제
function selectDelete(){
	
	
	
 	$.ajax({
 	
	    type : "POST",
        url : "/adminmember/select/delete",
        data : "MEMBER_No=" + memberNo,
        dataType : "json",
        success : function(memberInfo) {
        	
        	console.log(memberInfo)
        	
        	document.getElementById('MEMBER_Id').value = memberInfo.member_Id;
        	document.getElementById('MEMBER_Name').value = memberInfo.member_Name;
        	document.getElementById('MEMBER_Phone').value = memberInfo.member_Phone;
        	document.getElementById('MEMBER_Email').value = memberInfo.member_Email;
        	document.getElementById('MEMBER_Subscription').value = memberInfo.member_Subscription;
        	document.getElementById('MEMBER_Rating').value = memberInfo.member_Rating;
        	document.getElementById('MEMBER_MarketingCheck').value = memberInfo.member_Marketingcheck;
			
    	},
    	
        error : function(jqXHR, textStatus, errorThrown) {
      	  
      	  alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
        }
    	
 	})
};






</script>
</html>