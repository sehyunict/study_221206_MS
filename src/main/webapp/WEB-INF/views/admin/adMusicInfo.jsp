<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script>
	//온로드시 정보 불러오기
	
	window.onload = function(){
	
	musicInfo();
	
	};
	
	// 수정 취소 확인 알러창
	function cancleCheck() {
		
		if (confirm("작업을 취소하시겠습니까?")) {
		
			location = "/adminMusic";
			
		}
		
	};
	
	
	// 회원 정보 로드 메서드
	function musicInfo(){
	
	var musicNo = ${music_no};
	
	
 	$.ajax({
 	
	    type : "POST",
        url : "/adminMusic/info",
        data : "music_no=" + musicNo,
        dataType : "json",
        success : function(musicInfo) {
        	
        	console.log(musicInfo)
        	
        	if (musicInfo.music_adult == 1) {
        		
        		$("#music_adult1").attr("checked", true);

        	}
        	else {
        		
        		$("#music_adult2").attr("checked", true);
        	}
        	
        	document.getElementById('music_title').value = musicInfo.music_title;
        	document.getElementById('album_title').value = musicInfo.album_title;
        	document.getElementById('artist_name').value = musicInfo.artist_name;
        	document.getElementById('music_composition').value = musicInfo.music_composition;
        	document.getElementById('music_arrange').value = musicInfo.music_arrange;
        	document.getElementById('music_write').value = musicInfo.music_write;
        	document.getElementById('com_code').value = musicInfo.com_code;
        	document.getElementById('music_albumorder').value = musicInfo.music_albumorder;
        	document.getElementById('music_lyrics').value = musicInfo.music_lyrics;
        	document.getElementById('music_genre').value = musicInfo.music_genre;
        	document.getElementById('album_no').value = musicInfo.album_no;
        	document.getElementById('artist_no').value = musicInfo.artist_no;
        	document.getElementById('music_no').value = musicInfo.music_no;

    	},
    	
        error : function(jqXHR, textStatus, errorThrown) {
      	  
      	  alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
        }
    	
 	})
};

</script>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/adHeader.jsp"%>
	<div style="margin-left: 20%; margin-top: 50px; margin-right: 20%;">
		<h1>노래 수정</h1>
		<br>
		<hr>
		<div style="margin-top: 50px;">
			<div style="float: left; width: 40%; margin-right: 10%">
				<img
					src="https://i.pinimg.com/236x/3f/9c/46/3f9c4617e8c12ae2a4ff47bbe389a38e.jpg"
					style="width: 100%; height: 100%;">
			</div>
			<div>
				<table class="table table-boardered" style="width: 50%; height: 100%; float: left;">
				<form:form name="musicUpdate" accept-charset="UTF-8">
					<h3>곡 정보</h3>
					<tr>
						<th>곡 제목</th>
						<td>
						<input type="text" class="form-control" id="music_title" name="music_title" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>앨범명</th>
						<td>
						<input type="text" class="form-control" id="album_title" name="album_title" placeholder="" required="required" readonly>
						</td>
					</tr>

					<tr>
						<th>가수명</th>
						<td>
						<input type="text" class="form-control" id="artist_name" name="artist_name" placeholder="" required="required" readonly>
						</td>
					</tr>

					<tr>
						<th>작곡가</th>
						<td>
						<input type="text" class="form-control" id="music_composition" name="music_composition" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>편곡가</th>
						<td>
						<input type="text" class="form-control" id="music_arrange" name="music_arrange" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>작사가</th>
						<td>
						<input type="text" class="form-control" id="music_write" name="music_write" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>장르</th>
						<td>
						<input type="text" class="form-control" id="com_code" name="com_code" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>앨범내 번호</th>
						<td>
						<input type="text" class="form-control" id="music_albumorder" name="music_albumorder" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>성인 여부</th>
						<td>
							<input type='radio' id="music_adult1" name='music_adult' value='1' />예
  							<input type='radio' id="music_adult2" name='music_adult' value='2' />아니요
						</td>
					</tr>
					
					<tr>
						<th>가사</th>
							<td>
							<textarea id="music_lyrics" name='music_lyrics' style=" width: 100%; height:100px" ></textarea>
							</td>
					</tr>
							<input type='hidden' id="music_genre" name='music_genre'>
							<input type='hidden' id="album_no" name='album_no'>
							<input type='hidden' id="artist_no" name='artist_no'>
							<input type='hidden' id="music_no" name='music_no'>
					</form:form>
				</table>
			</div>
		</div>

		<div style="width: 100%" align="center">
		<input type="button" class="btn btn-primary" value="수정" onclick="adMusicUpdate()"> 
		<input type="button" class="btn btn-warning" value="삭제 " onclick="adMusicDelete()">
		<input type="button"class="btn btn-danger" value="취소" onclick="cancleCheck()">
		</div>
	</div>
</body>
<script>

	//음악 수정
	function adMusicUpdate() {
		
		var musicUpdate = $("form[name=musicUpdate]").serialize();
		
		console.log(musicUpdate)
	
 	 $.ajax({
 	
	    type : "POST",
        url : "/adminMusic/update",
        data : musicUpdate,
        dataType : "text",
        
        success : function(data) {
        	
        	if (data == 'success') {
        		
        	alert ("회원수정에 성공했습니다.");
        	
        	memberInfo();
        	
        	}else if (data == 'error')
        		
        	alert ("회원수정에 싫패했습니다.");
        	
		},
    	
        error : function(jqXHR, textStatus, errorThrown) {
      	  
      	  alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
        }
    	
 	})
};


	//음악 삭제 메서드
	function adMusicDelete() {

		var musicNo = ${music_no};

		var musicTitle = document.getElementById('music_title').value

		$.ajax({

			type : "POST",
			url : "/adminMusic/delete",
			data : "music_no=" + musicNo,
			dataType : "text",
			success : function(data) {

				if (data == 'success') {

					alert(musicTitle + "음악삭제에 성공했습니다");
					location = "/adminMember";

				} else if (data == 'error')

					alert("음악삭제에 싫패했습니다.");

			},

			error : function(jqXHR, textStatus, errorThrown) {

				alert("에러 발생 \n" + "/" + jqXHR + "/" + textStatus + " : "
						+ errorThrown);
			}

		})
	};
</script>


</html>