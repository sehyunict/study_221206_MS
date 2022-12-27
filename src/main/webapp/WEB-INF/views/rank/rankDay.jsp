<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEHYUNICT MUSIC</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/rank.css"/>
<script>
	$(document).ready(function() {
		//랭크리스트 : 전체 체크박스 기능
		$("#rankCheckAll").change(function() {
			if ($("#rankCheckAll").is(":checked")) {
	   			$("input[name='rankCheck']:checkbox").prop("checked", true);
		    } else {
		    	$("input[name='rankCheck']:checkbox").prop("checked", false);
		    }
		});
		
		//랭크리스트 : 개별 체크박스 기능
		for (let i=0; i<$('#rankSize').val(); i++) {
			let rankId = "#rankCheck" + i;
			
			$(document).ready(function() {
				$(rankId).change(function() {
					if ($(rankId).is(":checked")){
						let allCeckon = true;
						
						for (let i=0; i<$('#rankSize').val(); i++) {
				    		let rankId = "#rankCheck" + i;
				    		
				    		if (!$(rankId).is(":checked")) {
				    			allCeckon = false;
				    		}
				    	}
						
						if (allCeckon) {
							$("#rankCheckAll").prop("checked", true);
						}
			    	} else {
			    		$("#rankCheckAll").prop("checked", false);
			    	}
			    });
			});
		}
	});
	
	//좋아요 기능
	function updateLike(like, musicNo) {
		let likeId = "#likeNo" + musicNo;
		let likeNoId = "#hiddenLikeNo" + musicNo;
		let likeTdId = "#likeTdNo" + musicNo;
		
		if (like == 0) { //추가
			$.ajax({
				url : "/MIL",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(musicNo),
				success : function(result) {
					$(likeId).remove();
					
					let html = "";
					
					html += "<a href=\"#\" onclick=\"updateLike(1, " + musicNo + ")\" id=\"likeNo" + musicNo + "\">";
					html += "	<span style=\"color:red\">♥ </span>" + (parseInt($(likeNoId).val()) + 1) + "";
					html += "</a>";
					
					$(likeTdId).append(html);
					$(likeNoId).val(parseInt($(likeNoId).val()) + 1);
				}
			});
		} else {
			$.ajax({ //삭제
				url : "/MDL",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(musicNo),
				success : function(result) {
					$(likeId).remove();
					
					let html = "";
					
					html += "<a href=\"#\" onclick=\"updateLike(0, " + musicNo + ")\" id=\"likeNo" + musicNo + "\">";
					html += "	<span style=\"color:red\">♡ </span>" + (parseInt($(likeNoId).val()) - 1) + "";
					html += "</a>";
					
					$(likeTdId).append(html);
					$(likeNoId).val(parseInt($(likeNoId).val()) - 1);
				}
			});
		}
	}
	
	//플레이리스트 추가기능
	function insertPlayList() {
		let musicList = new Array();
		
		for (let i=0; i<$('#rankSize').val(); i++) {
			let rankId = "#rankCheck" + i;
			let musicId = "#rank" + i;
			
			if ($(rankId).is(":checked")) {
				musicList.push($(musicId).val());
			}
		}
		
		if (musicList.length == 0) {
			alert("음악이 선택되지 않았습니다.");
		} else {
			$.ajax({
				url : "/MIP",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(musicList),
				success : function(result) {
					alert(result.length + "곡이 플레이리스트에 추가되었습니다.");
				}
			});
			
			for (let i=0; i<$('#rankSize').val(); i++) {
	    		let rankId = "#rankCheck" + i;
	    		$(rankId).prop("checked", false);
	    	}
			$("#rankCheckAll").prop("checked", false);
		}
	};
	
	//앨범 추가기능
	function insertAlbum() {
		let musicList = new Array();
		
		musicList.push($("#albumSelect").val());
		
 		for (let i=0; i<$('#rankSize').val(); i++) {
			let rankId = "#rankCheck" + i;
			let musicId = "#rank" + i;
			
			if ($(rankId).is(":checked")) {
				musicList.push($(musicId).val());
			}
		}
		
		if (musicList.length == 1) {
			alert("음악이 선택되지 않았습니다.");
		} else {
			$.ajax({
				url : "/RIA",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(musicList),
				success : function(result) {
					alert(result + "곡이 앨범에 추가되었습니다.");
				}
			});
			
			for (let i=0; i<$('#rankSize').val(); i++) {
	    		let rankId = "#rankCheck" + i;
	    		$(rankId).prop("checked", false);
	    	}
			$("#rankCheckAll").prop("checked", false);
		}
	};
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<section>
		<div id="rank">
			<h2>SEHYUNICT MUSIC 월간 차트 50</h2>
			<div id="rankBtnWrap">
				<input type="button" value="플레이리스트에 담기" class="rankBtn" onclick="insertPlayList()">
				<select name="albumSelect" id="albumSelect">
					<c:forEach items="${albumList}" var="album" varStatus="albumStatus">
						<option value="${album.member_album_no}">${albumStatus.index + 1} : ${album.member_album_title}</option>
					</c:forEach>
				</select>
				<input type="button" value="앨범에 담기" class="rankBtn" onclick="insertAlbum()">
			</div>
			<form action="#">
				<div id="rankTblWrap">
					<table id="rankTbl">
						<tr>
							<th>
								<input type="checkbox" name="rankCheckAll" id="rankCheckAll">
								<input type="hidden" name="rankSize" id="rankSize" value="${fn:length(rankList)}">
							</th>
							<th>순위</th>
							<th>음악 타이틀</th>
							<th>아티스트</th>
							<th>앨범</th>
							<th>좋아요</th>
						</tr>
						<c:forEach items="${rankList}" var="rankMusic" varStatus="status">
							<tr id="rankNo${rankMusic.music_no}">
								<td>
									<input type="checkbox" name="rankCheck" id="rankCheck${status.index}">
									<input type="hidden" value="${rankMusic.music_no}" id="rank${status.index}">
									<input type="hidden" value="${rankMusic.music_like}" id="hiddenLikeNo${rankMusic.music_no}">
								</td>
								<td>${status.index + 1}</td>
								<td class="infotd"><a href="/MD?musicNo=${rankMusic.music_no}">${rankMusic.music_title}</a></td>
								<td class="infotd"><a href="/ATD?artistNo=${rankMusic.artist_no}">${rankMusic.artist_name}</a></td>
								<td class="infotd"><a href="/AD?albumNo=${rankMusic.album_no}">${rankMusic.album_title}</a></td>
								<td id="likeTdNo${rankMusic.music_no}">
									<a href="#" onclick="updateLike(${rankMusic.member_like}, ${rankMusic.music_no})" id="likeNo${rankMusic.music_no}">
										<span style="color:red">
											<c:choose>
												<c:when test="${rankMusic.member_like == 1}">♥</c:when>
												<c:otherwise>♡</c:otherwise>
											</c:choose>
										</span>${rankMusic.music_like}
									</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</form>
		</div>
	</section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>