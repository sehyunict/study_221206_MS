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
	
	albumInfo();
	
	};
	
	// 수정 취소 확인 알러창
	function cancleCheck() {
		
		if (confirm("작업을 취소하시겠습니까?")) {
		
			location = "/admin/Album";
			
		}
		
	};
	
	
	// 회원 정보 로드 메서드
	function albumInfo(){
	
	var albumNo = ${album_no};
	
	
 	$.ajax({
 	
	    type : "POST",
        url : "/admin/Album/info",
        data : "album_no=" + albumNo,
        dataType : "json",
        success : function(albumInfo) {
        	
        	console.log(albumInfo)
        	
        	document.getElementById('album_title').value = albumInfo.album_title;
        	document.getElementById('artist_name').value = albumInfo.artist_name;
        	document.getElementById('album_type').value = albumInfo.album_type;
        	document.getElementById('album_introduce').value = albumInfo.album_introduce;
        	document.getElementById('album_commany').value = albumInfo.album_commany;
        	document.getElementById('album_agency').value = albumInfo.album_agency;
        	document.getElementById('album_date').value = albumInfo.album_date;
        	document.getElementById('album_like').value = albumInfo.album_like;
        	document.getElementById('album_no').value = albumInfo.album_no;
        	document.getElementById('artist_no').value = albumInfo.artist_no;
        	$('#album_genre').val(albumInfo.album_genre).prop("selected",true);

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
				<form:form name="albumUpdate" accept-charset="UTF-8">
					<h3>앨범 정보</h3>
					<tr>
						<th>앨범명</th>
						<td>
						<input type="text" class="form-control" id="album_title" name="album_title" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>가수명</th>
						<td>
						<input type="text" class="form-control" id="artist_name" name="artist_name" placeholder="" required="required" readonly>
						</td>
					</tr>

					<tr>
						<th>앨범유형</th>
						<td>
						<input type="text" class="form-control" id="album_type" name="album_type" placeholder="" required="required">
						</td>
					</tr>

					<tr>
						<th>장르</th>
						<td>
							<select class="form-control" name="album_genre" id = "album_genre" style="display: inline-block;" >
								<option value="1">댄스</option>
								<option value="2">록</option>
								<option value="3">발라드</option>
								<option value="4">팝</option>
								<option value="5">힙합</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<th>발매사</th>
						<td>
						<input type="text" class="form-control" id="album_commany" name="album_commany" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>기획사</th>
						<td>
						<input type="text" class="form-control" id="album_agency" name="album_agency" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>발매일</th>
						<td>
						<input type="date" class="form-control" id="album_date" name="album_date" placeholder="" required="required" >
						</td>
					</tr>
					
					<tr>
						<th>좋아요 수</th>
						<td>
						<input type="number" class="form-control" id="album_like" name="album_like" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>앨범 소개</th>
							<td>
							<textarea id="album_introduce" name='album_introduce' style=" width: 100%; height:100px" ></textarea>
							</td>
					</tr>
							<input type='hidden' id="album_no" name='album_no'>
							<input type='hidden' id="artist_no" name='artist_no'>
					</form:form>
				</table>
			</div>
		</div>

		<div style="width: 100%" align="center">
		<input type="button" class="btn btn-primary" value="수정" onclick="adAlbumUpdate()"> 
		<input type="button" class="btn btn-warning" value="삭제 " onclick="adAlbumDelete()">
		<input type="button"class="btn btn-danger" value="취소" onclick="cancleCheck()">
		</div>
	</div>
		<%@ include file="/WEB-INF/views/include/adFooter.jsp"%>
</body>
<script>

	//음악 수정
	function adAlbumUpdate() {
		
		var albumUpdate = $("form[name=albumUpdate]").serialize();
		
		console.log(albumUpdate)
	
 	 $.ajax({
 	
	    type : "POST",
        url : "/admin/Album/update",
        data : albumUpdate,
        dataType : "text",
        
        success : function(data) {
        	
        	if (data == 'success') {
        		
        	alert ("회원수정에 성공했습니다.");
        	
        	location = "/admin/Album";
        	
        	}else if (data == 'error')
        		
        	alert ("회원수정에 싫패했습니다.");
        	
		},
    	
        error : function(jqXHR, textStatus, errorThrown) {
      	  
      	  alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
        }
    	
 	})
};


	//음악 삭제 메서드
	function adAlbumDelete() {

		var albumNo = ${album_no};

		var albumTitle = document.getElementById('album_title').value

		$.ajax({

			type : "POST",
			url : "/admin/Album/delete",
			data : "album_no=" + albumNo,
			dataType : "text",
			success : function(data) {

				if (data == 'success') {

					alert(albumTitle + "음악삭제에 성공했습니다");
					location = "/admin/Album";

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