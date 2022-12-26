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
<script src="/resources/script/main.js"></script>
<link rel="stylesheet" href="/resources/css/main.css"/>
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
									<input type="checkbox" name="rankCheck" id="rankCheck${status.index}">
									<input type="hidden" value="${rankMusic.music_no}" id="rank${status.index}">
									<input type="hidden" value="${rankMusic.music_like}" id="hiddenLikeNo${rankMusic.music_no}">
								</td>
								<td><a href="/MD?musicNo=${rankMusic.music_no}">${rankMusic.music_title}</a></td>
								<td><a href="/ATD?artistNo=${rankMusic.artist_no}">${rankMusic.artist_name}</a></td>
								<td><a href="/AD?albumNo=${rankMusic.album_no}">${rankMusic.album_title}</a></td>
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
										<input type="checkbox" name="listCheck" id="listCheck${status.index}">
										<input type="hidden" value="${playMusic.music_no}" id="list${status.index}">
										<input type="hidden" value="${playMusic.now_playList_no}" id="playList${status.index}">
									</td>
									<td>
										<a href="/MD?musicNo=${playMusic.music_no}">${playMusic.music_title}</a>
										<input type="hidden" name="count${playMusic.now_playList_no}" value="${playMusic.now_playList_count}">
										<input type="hidden" name="date${playMusic.now_playList_no}" value="${playMusic.now_playList_date}">
									</td>
									<td><a href="/ATD?artistNo=${playMusic.artist_no}">${playMusic.artist_name}</a></td>
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