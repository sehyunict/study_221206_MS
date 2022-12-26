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

#ATDTable {
	width: 100%;
	padding: 0;
	margin-left:auto;
	margin-right:auto;
/* border:1px solid black; */
}

#ATDTable tr, #ATDTable td{
	padding: 10px;
}

#FIBtn , #FDBtn{
  background-color:white; 
  border: none; 
  font-size:20px;
  width:30px;  
}

</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	 	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
 	<script type="text/javascript">
 		
 		function fanInsert() {	
 			$.ajax({
				type:"POST",
				url:"/ATD/FI",
				contentType: "application/json",
				data: JSON.stringify($("#artistNo").val()),
				success: function(result){
				}								
			});
 		};
 		
 		function fanDelete() {	
 			$.ajax({
				type:"POST",
				url:"/ATD/FD",
				contentType: "application/json",
				data: JSON.stringify($("#artistNo").val()),
				success: function(result){
				}
			});
 		};

	</script>
	<section>
		<div>

			<table id="ATDTable">
				<c:forEach items="${list}" var="artistD">
					<tr>
						<td rowspan="7"
							style="text-align: center; border: 1px solid black; width: 15%">
							( 아티스트 이미지 )${artistD.artistProfile}</td>
						<td colspan="5"><h2>${artistD.artistName}</h2></td>
					</tr>
					<tr>
						<td style="width:100px"><b>데뷔</b></td><td colspan="5">${artistD.artistDebut}</td>
					</tr>
					<tr>
						<td><b>활동유형</b></td><td colspan="5">${artistD.artistType}</td>
					</tr>
					<tr>
						<td><b>소속사</b></td><td colspan="5">${artistD.artistCompany}</td>
					</tr>
					<tr>
						<td><b>장르</b></td><td colspan="5">${artistD.artistGenre}</td>
					</tr>
					<tr>
						<td><b>수상이력</b></td><td colspan="5">${artistD.artistAwarded}</td>
					</tr>
					<tr>
						<td>
						<c:choose>
							<c:when test="${artistD.fanHeart == 1 }">
									<form><b>팬</b></td><td colspan="5">
										<button id="FIBtn" type="submit" onclick="fanDelete()">
											🌟
										</button>${artistD.artistFan}
										<input type="hidden" id="artistNo" name="artistNo" value="${artistD.artistNo}" />
									</form>
								</c:when>																
								<c:otherwise>
									<form><b>팬</b></td><td colspan="5">
										<button id="FDBtn" type="submit" onclick="fanInsert()">
											⭐					
										</button>${artistD.artistFan}
										<input type="hidden" id="artistNo" name="artistNo" value="${artistD.artistNo}" />
									</form>
								</c:otherwise>
								
							</c:choose>
						
						</td>
					</tr>
					<tr>
						<td colspan = "7"><b>소개글</b><br>${artistD.artistIntroduce}</td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>