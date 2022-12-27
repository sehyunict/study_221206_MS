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

<script>
	//온로드시 combobox 정보 불러오기
	
	window.onload = function(){
	
	comboInfo();
	
	};
	
	// 수정 취소 확인 알러창
	function cancleCheck() {
		
		if (confirm("작업을 취소하시겠습니까?")) {
		
			location = "/admin/Music";
			
		}
		
	};
	
	
	//체크박스 변경시 이벤트
	function chageSelect() {
		
	var select = $('#comboArtist').val();
	
	$.ajax({
	 	
	    type : "POST",
        url : "/admin/Music/comboAlbum",
        data : { "artistNo" : select },
        success : function(comboAlbumList) {
        	
        	$("#comboAlbum").attr('disabled', false);
        	$("#comboAlbum").empty();
        	var album = comboAlbumList;
			var tmpAlbum = "";
         	
			if (album.length == 0){
				
				alert("선택가능한 앨범이 없습니다.");
				$("#comboAlbum").append("<option selected disabled hidden>--- 다른가수를 선택해주세요 ---</option>");
				$("#comboAlbum").attr('disabled', true);
				
			}else{
			
         		for (var i = 0; i < album.length; i++){
         		
            	tmpAlbum += "<option selected disabled hidden>--- 앨범을 선택해주세요 ---</option><option value=" + album[i].ALBUM_NO + ">" + album[i].ALBUM_TITLE + "</option>";
                
            	}
			}
         	
         	$("#comboAlbum").append(tmpAlbum);

    	},
    	
        error : function(jqXHR, textStatus, errorThrown) {
      	  
      	  alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
        }
    	
 	})
};

	
	// 회원 정보 로드 메서드
	function comboInfo(){
		
 	$.ajax({
 	
	    type : "POST",
        url : "/admin/Music/comboInfo",
        dataType : "json",
        success : function(comboArtist) {
        	
        	var artist = comboArtist;
        	var tmpArtist = "<option selected disabled hidden>--- 추가할 음악의 가수를 선택해주세요 ---</option>";
         	
         	for (var i = 0; i < artist.length; i++){
         		
            	tmpArtist += "<option value=" + artist[i].ARTIST_NO + ">" + artist[i].ARTIST_NAME + "</option>";
                
            }
         	
         	
         	$("#comboArtist").append(tmpArtist);

    	},
    	
        error : function(jqXHR, textStatus, errorThrown) {
      	  
      	  alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
        }
    	
 	})
};

</script>

<body>
	<%@ include file="/WEB-INF/views/include/adHeader.jsp"%>
	<div style="margin-left: 20%; margin-top: 50px; margin-right: 20%;">
		<h1>곡 추가</h1>
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
						<th>가수명</th>
						<td>
							<select id=comboArtist name="artist_no" style="display: inline-block;" onchange="chageSelect()" >
							
							</select>
						</td>
					</tr>
										
					<tr>
						<th>앨범명</th>
						<td>
							<select id=comboAlbum name="album_no" style="display: inline-block;" disabled="disabled" >
								<option selected disabled hidden="ture" >--- 가수를 먼저 선택해 주세요 --- </option>
							</select>
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
							<select class="form-control" name="music_genre" id = "genre" style="display: inline-block;" >
								<option selected disabled hidden="ture">--- 장르를 선택해주세요 ---</option>
								<option value="1">댄스</option>
								<option value="2">록</option>
								<option value="3">발라드</option>
								<option value="4">팝</option>
								<option value="5">힙합</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>성인 여부</th>
						<td>
							<input type='radio' name='music_adult' value='1' />예
  							<input type='radio' name='music_adult' value='0' />아니요
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
		
		var selectArt = $('#comboArtist').val();
		var selectAlb = $('#comboAlbum').val();
		var genre = $('#genre').val();
		
		if (selectArt == null || selectAlb == null || genre == null) {
			
			alert ("음악 입력 정보가 정확하지 않습니다.");
			
		}else{
		
			var musicInsert = $("form[name=musicInsert]").serialize();
			console.log(musicInsert)
	
 			$.ajax({
 	
	  		type : "POST",
		    url : "/admin/Music/insert",
		    data : musicInsert,
		    dataType : "text",
		        
		    success : function(data) {
		    	if (data == 'success') {
		        		
		        alert ("음악추가에 성공했습니다.");
		        	
		        	
		        }else if (data == 'error')
		        		
		        alert ("음악추가에 싫패했습니다.");
		        	
		        location = "/admin/Music";
			},
    	
     	    error : function(jqXHR, textStatus, errorThrown) {
      		  
			alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
    	    }
    	
 		})
	}
};
</script>


</html>