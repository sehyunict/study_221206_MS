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
<!-- <script src="/resources/script/main.js"></script> -->
<link rel="stylesheet" href="/resources/css/main.css"/>
<script>
	$(document).ready(function() {
		//랭크리스트 : 전체 체크박스 기능
		$("#rankCheckAll").change(function() {
			if ($("#rankCheckAll").is(":checked")) {
		    	for (let i=0; i<$('#rankSize').val(); i++) {
		    		let rankId = "#rankCheck" + i;
		    		
		    		if (!$(rankId).is(":checked")) {
		    			$(rankId).prop("checked", true);
		    		}
		    	}
		    } else {
		    	for (let i=0; i<$('#rankSize').val(); i++) {
		    		let rankId = "#rankCheck" + i;
		    		
		    		if ($(rankId).is(":checked")) {
		    			$(rankId).prop("checked", false);
		    		}
		    	}
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
		
		//플레이리스트 : 전체 체크박스 기능
		$("#listCheckAll").change(function() {
			if ($("#listCheckAll").is(":checked")) {
		    	for (let i=0; i<$('#listSize').val(); i++) {
		    		let listId = "#listCheck" + i;
		    		
		    		if (!$(listId).is(":checked")) {
		    			$(listId).prop("checked", true);
		    		}
		    	}
		    } else {
		    	for (let i=0; i<$('#listSize').val(); i++) {
		    		let listId = "#listCheck" + i;
		    		
		    		if ($(listId).is(":checked")) {
		    			$(listId).prop("checked", false);
		    		}
		    	}
		    }
		});
		
		//플레이리스트 : 개별 체크박스 기능
		for (let i=0; i<$('#listSize').val(); i++) {
			let listId = "#listCheck" + i;
			
			$(document).ready(function() {
				$(listId).change(function() {
					if ($(listId).is(":checked")){
						let allCeckon = true;
						
						for (let i=0; i<$('#listSize').val(); i++) {
				    		let listId = "#listCheck" + i;
				    		
				    		if (!$(listId).is(":checked")) {
				    			allCeckon = false;
				    		}
				    	}
						
						if (allCeckon) {
							$("#listCheckAll").prop("checked", true);
						}
			    	} else {
			    		$("#listCheckAll").prop("checked", false);
			    	}
			    });
			});
		}
	});

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
					for(let i = 0; i < result.length; i++) {
						let html = "";
						
						html += "<tr id=\"listNo" + result[i].now_playList_no + "\">";
						html += "	<td>";
						html += "		<input type=\"checkbox\" name=\"listCheck" + result[i].now_playList_no + "\" id=\"listCheck" + $("#listSize").val() + "\">";
						html += "		<input type=\"hidden\" value=\"" + result[i].music_no + "\" id=\"list" + $("#listSize").val() + "\">";
						html += "		<input type=\"hidden\" value=\"" + result[i].now_playList_no + "\" id=\"playList" + $("#listSize").val() + "\">";
						html += "	</td>";
						html += "	<td>";
						html += "		" + result[i].music_title + "";
						html += "		<input type=\"hidden\" name=\"count" + result[i].now_playList_no + "\" value=\"" + result[i].now_playList_count + "\">";
						html += "		<input type=\"hidden\" name=\"date" + result[i].now_playList_no + "\" value=\"" + result[i].now_playList_date + "\">";
						html += "	</td>";
						html += "	<td>" + result[i].artist_name + "</td>";
						html += "	<td style=\"text-align: center\"><a style=\"color:red\" onclick=\"delPlayList(" + result[i].now_playList_no + ")\">삭제</a></td>";
						html += "</tr>";
						
						$("#mainListTblHead").after(html);
						$("#listSize").val(parseInt($("#listSize").val()) + 1);
					}
					alert(result.length + "곡이 추가되었습니다.");
				}
			});
			
			for (let i=0; i<$('#rankSize').val(); i++) {
	    		let rankId = "#rankCheck" + i;
	    		$(rankId).prop("checked", false);
	    	}
			$("#rankCheckAll").prop("checked", false);
		}
	};
	
	//플레이리스트 개별 삭제기능
	function delPlayList(delNum) {
		let delNumId = "#listNo" + delNum;
		
		$.ajax({
			url : "/MDP",
			type : "POST",
			contentType: "application/json",
			data : JSON.stringify(delNum),
			success : function(result) {
				$(delNumId).remove();
				$("#listSize").val(parseInt($("#listSize").val()) - 1);
			}
		});
	};
	
	//플레이리스트 체크 삭제기능
	function delCheckPlayList() {
		let musicList = new Array();
		
		for(let i=0; i<$('#listSize').val(); i++) {
			let listId = "#listCheck" + i;
			let musicId = "#playList" + i;
			
			if ($(listId).is(":checked")) {
				musicList.push($(musicId).val());
			}
		}

		if (musicList.length == 0) {
			alert("음악이 선택되지 않았습니다.");
		} else {
			$.ajax({
				url : "/MDCP",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(musicList),
				success : function(result) {
					for(let i=0; i<musicList.length; i++) {
						let delNumId = "#listNo" + musicList[i];
						
						$(delNumId).remove();
						$("#listSize").val(parseInt($("#listSize").val()) - 1);
					}
					alert(result + "곡이 삭제되었습니다.");
				}
			});
			
			for (let i=0; i<$('#listSize').val(); i++) {
	    		let listId = "#listCheck" + i;
	    		$(listId).prop("checked", false);
	    	}
			$("#listCheckAll").prop("checked", false);
		}
	}

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
	
	//플레이리스트 카운트 업데이트기능
	function updatePlayCount() {
		let musicList = new Array();
		
		for (let i=0; i<$('#listSize').val(); i++) {
			let listId = "#listCheck" + i;
			let musicId = "#list" + i;

			if ($(listId).is(":checked")) {
				musicList.push($(musicId).val());
			}
		}
		
		if (musicList.length == 0) {
			alert("음악이 선택되지 않았습니다.");
		} else {
			$.ajax({
				url : "/MUP",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(musicList),
				success : function(result) {
					alert(result + "곡이 재생되었습니다.");
				}
			});
			
			for (let i=0; i<$('#listSize').val(); i++) {
	    		let listId = "#listCheck" + i;
	    		$(listId).prop("checked", false);
	    	}
			$("#listCheckAll").prop("checked", false);
		}
	};
	
	function noPlay() {
		alert("지원하지 않는 기능입니다.");
	}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<section>
		<div id="mainRank">
			<h2>SEHYUNICT MUSIC 좋아요 랭킹 50</h2>
			<div id="mainRankBtnWrap">
				<input type="button" value="플레이리스트에 담기" id="mainRankBtn" onclick="javascript:insertPlayList()">
			</div>
			<form action="#">
				<div id="mainRankTblWrap">
					<table id="mainRankTbl">
						<tr>
							<th>
								<input type="checkbox" name="rankCheckAll" id="rankCheckAll">
								<input type="hidden" name="rankSize" id="rankSize" value="${fn:length(rankList)}">
							</th>
							<th>음악 타이틀</th>
							<th>아티스트</th>
							<th>앨범</th>
							<th>좋아요</th>
						</tr>
						<c:forEach items="${rankList}" var="rankMusic" varStatus="status">
							<tr id="rankNo${rankMusic.music_no}">
								<td>
									<input type="checkbox" name="rankCheck${rankMusic.music_no}" id="rankCheck${status.index}">
									<input type="hidden" value="${rankMusic.music_no}" id="rank${status.index}">
									<input type="hidden" value="${rankMusic.music_like}" id="hiddenLikeNo${rankMusic.music_no}">
								</td>
								<td><a href="#">${rankMusic.music_title}</a></td>
								<td><a href="#">${rankMusic.artist_name}</a></td>
								<td><a href="#">${rankMusic.album_title}</a></td>
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
		<div id="mainPlayList">			
			<div id="mainPlay">
				<div id="mainPlayWrap">
					<a href="#" onclick="noPlay()"><span class="decoBtn">◀◀</span></a>
					<a href="#" onclick="updatePlayCount()"><span id="playBtn">▶</span></a>
					<a href="#" onclick="noPlay()"><span class="decoBtn">▶▶</span></a>
				</div>
			</div>
			<div id="mainList">
				<h2>플레이 리스트</h2>
				<div id="listDelBtnWrap">
					<input type="button" value="삭제" id="listDelBtn" onclick="javascript:delCheckPlayList()">
				</div>
				<form action="#">
					<div id="mainListTblWrap">
						<table id="mainListTbl">
							<tr id="mainListTblHead">
								<th>
									<input type="checkbox" name="listCheckAll" id="listCheckAll">
									<input type="hidden" name="listSize" id="listSize" value="${fn:length(playList)}">
								</th>
								<th>음악 타이틀</th>
								<th>아티스트</th>
								<th>삭제</th>
							</tr>
							<c:forEach items="${playList}" var="playMusic" varStatus="status">
								<tr id="listNo${playMusic.now_playList_no}">
									<td>
										<input type="checkbox" name="listCheck${playMusic.now_playList_no}" id="listCheck${status.index}">
										<input type="hidden" value="${playMusic.music_no}" id="list${status.index}">
										<input type="hidden" value="${playMusic.now_playList_no}" id="playList${status.index}">
									</td>
									<td>
										${playMusic.music_title}
										<input type="hidden" name="count${playMusic.now_playList_no}" value="${playMusic.now_playList_count}">
										<input type="hidden" name="date${playMusic.now_playList_no}" value="${playMusic.now_playList_date}">
									</td>
									<td>${playMusic.artist_name}</td>
									<td style="text-align: center"><a style="color:red" onclick="delPlayList(${playMusic.now_playList_no})">삭제</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</form>
			</div>
		</div>
	</section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>