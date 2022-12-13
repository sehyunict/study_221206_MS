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
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<section>
		<div id="mainPlay">
			<h2>플레이 기능</h2>
		</div>
		<div id="mainRankList">
			<div id="mainRank">
				<h2>SEHYUNICT MUSIC 일간 랭킹</h2>
			</div>
			<div id="mainList">
				<h2>플레이리스트</h2>
			</div>
		</div>
	</section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>