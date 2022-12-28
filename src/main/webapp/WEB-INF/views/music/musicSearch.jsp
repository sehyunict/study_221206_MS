<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEHYUNICT MUSIC</title>
<style>
#mainPlay {
	width: 1620px;
	height: 150px;
	margin: 0px auto 50px;
	background-color: #F0F0F0;
	padding: 25px;
}

#mainRankList {
	width: 1620px;
	height: 600px;
	margin: 0px auto;
}

#mainRank {
	width: 900px;
	height: 600px;
	background-color: #F0F0F0;
	margin-right: 50px;
	float: left;
	padding: 25px;
}

#mainList {
	width: 670px;
	height: 600px;
	background-color: #F0F0F0;
	float: left;
	padding: 25px;
}

#MStable {
	width: 80%;
	margin-left: auto;
	margin-right: auto;
}

#MStable th, #MStable td {
	padding: 10px 5px 10px 0;
	text-align: left;
}


button {
	width: 60px;
	height: 30px;
	border: 1px #E6E6E6 solid;
	background-color: white;
	border-radius: 2.5px;
	cursor: pointer;
	outline: none;
}

#MLIBtn , #MLDBtn{
  background-color:white; 
  border: none; 
  color: red; 
  font-size:20px;
  width:20px;
}

</style>
</head>
<body>
	 	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		
	function checkSelectAll(checkbox)  {
		  const selectAll 
		    = document.querySelector('input[name="selectAll"]');
		  
		  if(checkbox.checked === false)  {
		    selectAll.checked = false;
		  }
		}

		function selectAll(selectAll)  {
		  const checkboxes 
		     = document.getElementsByName('selected');
		  
		  checkboxes.forEach((checkbox) => {
		    checkbox.checked = selectAll.checked
		  })
		}		
		
		function DLbtn(){
			alert('다운로드 되었습니다.');
		}
		
		
</script>
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<section>
		<div>
			<table id='MStable'>
<!-- 				<tr>
					<th colspan="4"><button>듣기</button>
					<button>담기</button></th>
				</tr> -->
				<tr>
					<th><input type='checkbox' name='selectAll' value='selectAll' onclick='selectAll(this)'/></th>
					<th>No</th>
					<th>노래</th>
					<th>아티스트</th>
					<th>앨범</th>
					<th>좋아요</th>
					<th>뮤비</th>
					<th>다운</th>
				</tr>
				<c:forEach items="${list}" var="music">
					<tr>
						<td><input type='checkbox' name='selected' onclick='checkSelectAll(this)'/></td>
						<td>${music.musicNumber}</td>
						<td><a href="${path}/MD?musicNo=${music.musicNo}"
							value='${music.musicNo}'>${music.musicAdult}<%-- ${music.musicAlbumorder} --%>
							
							<c:if test="${music.musicAlbumorder eq 'Title' }">
							
							<b style="font-size:smaller; border:1px solid pink; padding:0 5px; border-radius:30px; color:pink">${music.musicAlbumorder}</b>
							
							
							</c:if>
							${music.musicTitle}
							</a></td>
							
							
						<td><a href="${path}/ATD?artistNo=${music.artistNo}"
							value='${music.artistNo}'>${music.artistName}</a></td>
						<td><a href="${path}/AD?albumNo=${music.albumNo}"
							value='${music.albumNo}'>${music.albumTitle}</a></td>
						<td><c:choose>
								<c:when test="${music.musicHeart == 1 }">
									<form >
<!-- 										<button id="MLDBtn" >
 -->											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="color: red" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
                        					  		<path d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z" />
                        						</svg>
<!-- 										</button>
 -->										<input type="hidden" id="musicNo" name="musicNo" value="${music.musicNo}" />
										${music.musicLike}
									</form>
								</c:when>

								<c:otherwise>
									<form>
<!--  										 <button id="MLIBtn" onclick="musicLikeInsert()"  > 
 -->											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="color: red" class="bi bi-suit-heart" viewBox="0 0 16 16">
                         							<path d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                        						</svg> 										 
                        				<!-- </button> --> ${music.musicLike}
 								<input type="hidden" id="musicNo" name="musicNo" value="${music.musicNo}" />		 								
 									</form>
								</c:otherwise>
							</c:choose><%-- ${music.musicHeart},  --%></td>			
						
						<td>
							${music.musicMv}📺
						</td>
						<td><a style="cursor:pointer" onclick="javascript:DLbtn()">${music.musicFile}</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>

	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	
</body>

</html>