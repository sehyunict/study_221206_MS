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
				<form:form name="musicInsert" accept-charset="UTF-8">
					
					<tr>
						<th>곡 제목</th>
						<td>
						<input type="text" class="form-control" name="music_title" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>앨범명</th>
						<td>
						<input type="text" class="form-control" name="album_no" placeholder="" required="required">
						</td>
					</tr>

					<tr>
						<th>가수명</th>
						<td>
						<input type="text" class="form-control" name="artist_no" placeholder="" required="required">
						</td>
					</tr>

					<tr>
						<th>작곡가</th>
						<td>
						<input type="text" class="form-control" name="music_composition" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>편곡가</th>
						<td>
						<input type="text" class="form-control" name="music_arrange" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>작사가</th>
						<td>
						<input type="text" class="form-control" name="music_write" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>장르</th>
						<td>
						<input type="text" class="form-control" name="music_genre" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>타이틀 여부</th>
						<td>
							<input type='radio' name='music_title' value='1' />예
  							<input type='radio' name='music_title' value='2' checked="checked" />아니요
						</td>
					</tr>
					
					<tr>
						<th>성인 여부</th>
						<td>
							<input type='radio' name='music_adult' value='1' />예
  							<input type='radio' name='music_adult' value='2' checked="checked"/>아니요
						</td>
					</tr>
					
					<tr>
						<th>가사</th>
							<td>
							<textarea name='music_lyrics' style=" width: 100%; height:100px" ></textarea>
							</td>
					</tr>
					</form:form>
				</table>
			</div>
		</div>

		<div style="width: 100%" align="center">
		<input type="button" class="btn btn-primary" value="추가" onclick="adMusicInsert()"> 
		<input type="button"class="btn btn-danger" value="취소" onclick="cancleCheck()">
		</div>
	</div>
</body>
<script>
	function adMusicInsert() {
		
		var musicInsert = $("form[name=musicInsert]").serialize();
		console.log(musicInsert)
	
 	 $.ajax({
 	
	    type : "POST",
        url : "/adminMusic/insert",
        data : musicInsert,
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
</script>


</html>