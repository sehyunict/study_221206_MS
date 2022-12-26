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


#ADTable {
	width: 100%;
	padding: 0;
	margin-left:auto;
	margin-right:auto;
/* border:1px solid black; */
}

#ADTable tr, #ADTable td{ 
	padding: 10px;
}

#ALIBtn , #ALDBtn{
  background-color:white; 
  border: none; 
  color: red; 
  font-size:20px;
  width:30px;
  
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp" />	
 	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
 	<script type="text/javascript">
 		
 		function albumLikeInsert() {	
 			$.ajax({
				type:"POST",
				url:"/AD/LI",
				contentType: "application/json",
				data: JSON.stringify($("#albumNo").val()),
				success: function(result){
				}								
			});
 		};
 		
 		function albumLikeDelete() {	
 			$.ajax({
				type:"POST",
				url:"/AD/LD",
				contentType: "application/json",
				data: JSON.stringify($("#albumNo").val()),
				success: function(result){

				}
			});
 		};

	</script>
	<section>
		<div>
			<table id="ADTable">
				<c:forEach items="${list}" var="albumD">
					<tr>
						<td rowspan="6"
							style="text-align: center; border: 1px solid black; width: 15%">(앨범 자켓 이미지)${albumD.albumJacket}</td>
						<td colspan="4"><h2>${albumD.albumTitle}</h2></td>
					</tr>
					<tr>
						<td colspan="4"><a href = "${path}/ATD?artistNo=${albumD.artistNo}" value='${albumD.artistNo}'>${albumD.artistName}</a></td>
					</tr>
					<tr>
						<td style="width:100px"><b>발매일</b></td><td colspan="3">${albumD.albumDate}</td>
					</tr>
					<tr>
						<td style="width:100px"><b>기획사</b></td><td>${albumD.albumCompany}</td>
						<td style="width:100px"><b>발매사</b></td><td>${albumD.albumAgency}</td>
					</tr>
					<tr>
						<td><b>장르</b></td><td colspan="3">${albumD.albumGenre}</td>
					</tr>
					<tr>
						<td colspan="4">
							<c:choose>							
								<c:when test="${albumD.albumHeart == 1 }">
									<form>
										<button id="ALDBtn" type="submit" onclick="albumLikeDelete()">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
                        					  <path	d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z" />
                        						</svg>
										</button>${albumD.albumLike}
										<input type="hidden" id="albumNo" name="albumNo" value="${albumD.albumNo}" />
									</form>
								</c:when>
																
								<c:otherwise>
									<form>
										<button id="ALIBtn" type="submit" onclick="albumLikeInsert()">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16">
                        					  <path d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                        						</svg>							
										</button>${albumD.albumLike}
										<input type="hidden" id="albumNo" name="albumNo" value="${albumD.albumNo}" />
									</form>
								</c:otherwise>								
							</c:choose><%-- ${albumD.albumHeart} --%>
						</td>
					</tr>
					<tr>
						<td colspan="5">
							<b>소개글</b><br>${albumD.albumIntroduce}
  						</td>
					</tr>
					<tr>
						<td colspan="5">
							<b>수록곡2</b><br>${albumD.musicTitle}
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>