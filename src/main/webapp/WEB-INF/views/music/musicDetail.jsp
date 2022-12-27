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

#MDTable {
	width: 100%;
	padding: 0;
	margin-left: auto;
	margin-right: auto;
	/* border:1px solid black; */
}

#MDTable tr, #MDTable td {
	padding: 10px;
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
  width:30px;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	 	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
	
		function playlistInsert() {
			alert('플레이리스트에 추가되었습니다.');
			$.ajax({
				type : "POST",
				url : "/MD/PLI",
				contentType : "application/json",
				data : JSON.stringify($("#musicNo").val()),
				success : function(result) {
				}
			});
		};		

		function myAlbumInsert() {
			alert('마이앨범에 추가되었습니다.');
			var memberAlbumNo = $("#memberAlbumNo").val();
			var musicNo = $("#musicNo").val();			
			var param = {"memberAlbumNo":memberAlbumNo, "musicNo":musicNo }			
			$.ajax({
				type : "POST",
				url : "/MD/MAI",
				contentType : "application/json",
				data : JSON.stringify(param),
				success : function(result) {
				}
			});
		};

		function musicLikeInsert() {
			$.ajax({
				type : "POST",
				url : "/MD/LI",
				contentType : "application/json",
				data : JSON.stringify($("#musicNo").val()),
				success : function(result) {
				}
			});
		};

		function musicLikeDelete() {
			$.ajax({
				type : "POST",
				url : "/MD/LD",
				contentType : "application/json",
				data : JSON.stringify($("#musicNo").val()),
				success : function(result) {
				}
			});
		};
		
		function DLbtn() {
			alert('다운로드 되었습니다.');
		}	
		
	</script>
	<section>
		<div>
			<table id="MDTable">
				<c:forEach items="${list}" var="musicD">
					<tr>
						<td rowspan="7"
							style="text-align: center; border: 1px solid black; width: 15%">(
							앨범 자켓 이미지 )${musicD.albumJacket}</td>
						<td colspan="6"><h2>${musicD.musicAdult}${musicD.musicTitle}</h2></td>
					</tr>
					<tr>
						<td colspan="6">
						<a href="${path}/ATD?artistNo=${musicD.artistNo}"
							value='${musicD.artistNo}'>${musicD.artistName}</a></td>
					</tr>
					<tr>
						<td style="width:100px"><b>작곡</b></td><td>${musicD.musicComposition}</td>
						<td style="width:100px"><b>작사</b></td><td>${musicD.musicWrite}</td>
						<td style="width:100px"><b>편곡</b></td><td>${musicD.musicArrange}</td>
					</tr>
					<tr>
						<td style="width:100px"><b>앨범</b></td><td colspan="6">
						<a href="${path}/AD?albumNo=${musicD.albumNo}" value='${musicD.albumNo}'>${musicD.albumTitle}</a></td>
					</tr>
					<tr>
						<td style="width:100px"><b>발매일</b></td><td colspan="6">${musicD.albumDate}</td>
					</tr>
					<tr>
						<td style="width:100px"><b>장르</b></td><td colspan="6">${musicD.musicGenre}</td>
					</tr>
					<tr>
						<td><c:choose>
								<c:when test="${musicD.musicHeart == 1 }">
									<form>
										<button id="MLDBtn" type="submit" onclick="musicLikeDelete()">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor"
												class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
                        					  <path
													d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z" />
                        						</svg>
										</button>${musicD.musicLike}
										<input type="hidden" id="musicNo" name="musicNo" value="${musicD.musicNo}" />
									</form>
								</c:when>

								<c:otherwise>
									<form>
										<button id="MLIBtn" type="submit" onclick="musicLikeInsert()">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-suit-heart"
												viewBox="0 0 16 16">
                          <path	d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                        </svg>
										</button>${musicD.musicLike}
										<input type="hidden" id="musicNo" name="musicNo" value="${musicD.musicNo}" />
									</form>
								</c:otherwise>

							</c:choose><%--  ${musicD.musicHeart},  --%></td>
							
						<td></td>
						<td><b>뮤비</b></td><td><a style="cursor: pointer">📺${musicD.musicMv}</a></td>
						<td><b>다운로드</b></td><td><a style="cursor: pointer"
							onclick="javascript:DLbtn()">${musicD.musicFile}.mp3</a></td>
					</tr>
					<tr>
						<td><form>
								<%-- <a name="musicNo" id="musicNo" value="${musicD.musicNo}"></a> --%>
								<button type="submit" onclick="playlistInsert()" >듣기</button>
								<input type="hidden" id="musicNo" name="musicNo" value="${musicD.musicNo}" />
							</form></td>
									
						<td colspan="6">
						<form>
						<select name="memberAlbumNo" id="memberAlbumNo">
								<option>마이앨범 선택</option>
								<option value="7">겨울 분위기 팝송</option>
								<option value="8">드라이브 할 때 듣는 음악</option>
								<option value="9">듣고있으면 좋은 노래</option>
								<option value="10">둠칫둠칫</option>
								<option value="11">힙합 뮤직 LIST</option>
						</select> 
								<input type="hidden" id="musicNo" name="musicNo" value="${musicD.musicNo}" />				
								<button type="submit" onclick="myAlbumInsert()">담기</button>
						</form>
						</td>
					</tr>
					<tr>
						<td colspan="7">${musicD.musicLyrics}</td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>