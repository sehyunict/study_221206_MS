<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artist Info</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script>
	//온로드시 정보 불러오기
	
	window.onload = function(){
	
	artistInfo();
	
	};
	
	// 수정 취소 확인 알러창
	function cancleCheck() {
		
		if (confirm("작업을 취소하시겠습니까?")) {
		
			location = "/admin/Artist";
			
		}
		
	};
	
	
	// 가수 정보 로드 메서드
	function artistInfo(){
	
	var artistNo = ${artist_no};
	
	
 	$.ajax({
 	
	    type : "POST",
        url : "/admin/Artist/info",
        data : "artist_no=" + artistNo,
        dataType : "json",
        success : function(artistInfo) {
        	
        	console.log(artistInfo)
        	
        	document.getElementById('artist_name').value = artistInfo.artist_name;
        	document.getElementById('artist_date').value = artistInfo.artist_date;
        	document.getElementById('artist_type').value = artistInfo.artist_type;
        	document.getElementById('artist_introduce').value = artistInfo.artist_introduce;
        	document.getElementById('artist_company').value = artistInfo.artist_company;
        	document.getElementById('artist_debut').value = artistInfo.artist_debut;
        	document.getElementById('artist_awarded').value = artistInfo.artist_awarded;
        	document.getElementById('artist_fan').value = artistInfo.artist_fan;
        	document.getElementById('artist_no').value = artistInfo.artist_no;
        	$('#artist_genre').val(artistInfo.artist_genre).prop("selected",true);

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
		<h1>가수 수정</h1>
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
				<form:form name="artistUpdate" accept-charset="UTF-8">
					<h3>가수 정보</h3>
					<tr>
						<th>가수명</th>
						<td>
						<input type="text" class="form-control" id="artist_name" name="artist_name" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>출생년도</th>
						<td>
						<input type="date" class="form-control" id="artist_date" name="artist_date" placeholder="" required="required">
						</td>
					</tr>

					<tr>
						<th>가수유형</th>
						<td>
						<input type="text" class="form-control" id="artist_type" name="artist_type" placeholder="" required="required">
						</td>
					</tr>

					<tr>
						<th>소속사</th>
						<td>
						<input type="text" class="form-control" id="artist_company" name="artist_company" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>데뷔일</th>
						<td>
						<input type="date" class="form-control" id="artist_debut" name="artist_debut" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>수상이력</th>
						<td>
						<input type="text" class="form-control" id="artist_awarded" name="artist_awarded" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>장르</th>
						<td>
							<select class="form-control" name="artist_genre" id = "artist_genre" style="display: inline-block;" >
								<option value="1">댄스</option>
								<option value="2">록</option>
								<option value="3">발라드</option>
								<option value="4">팝</option>
								<option value="5">힙합</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<th>팬 수</th>
						<td>
						<input type="number" class="form-control" id="artist_fan" name="artist_fan" placeholder="" required="required">
						</td>
					</tr>
					
					<tr>
						<th>앨범 소개</th>
							<td>
							<textarea id="artist_introduce" name='artist_introduce' style=" width: 100%; height:100px" ></textarea>
							</td>
					</tr>
							<input type='hidden' id="artist_no" name='artist_no'>
					</form:form>
				</table>
			</div>
		</div>

		<div style="width: 100%" align="center">
		<input type="button" class="btn btn-primary" value="수정" onclick="adArtistUpdate()"> 
		<input type="button" class="btn btn-warning" value="삭제 " onclick="adArtistelete()">
		<input type="button"class="btn btn-danger" value="취소" onclick="cancleCheck()">
		</div>
	</div>
		<%@ include file="/WEB-INF/views/include/adFooter.jsp"%>
</body>
<script>

	//음악 수정
	function adArtistUpdate() {
		
		var artistUpdate = $("form[name=artistUpdate]").serialize();
		
		console.log(artistUpdate)
	
 	 $.ajax({
 	
	    type : "POST",
        url : "/admin/Artist/update",
        data : artistUpdate,
        dataType : "text",
        
        success : function(data) {
        	
        	if (data == 'success') {
        		
        	alert ("가수수정에 성공했습니다.");
        	
        	location = "/admin/Artist";
        	
        	}else if (data == 'error')
        		
        	alert ("가수수정에 싫패했습니다.");
        	
		},
    	
        error : function(jqXHR, textStatus, errorThrown) {
      	  
      	  alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
        }
    	
 	})
};


	//음악 삭제 메서드
	function adArtistDelete() {

		var artistNo = ${artist_no};

		var artistTitle = document.getElementById('artist_title').value

		$.ajax({

			type : "POST",
			url : "/admin/Artist/delete",
			data : "artist_no=" + artistNo,
			dataType : "text",
			success : function(data) {

				if (data == 'success') {

					alert(artistTitle + "가수삭제에 성공했습니다");
					location = "/admin/Artist";

				} else if (data == 'error')

					alert("가수삭제에 싫패했습니다.");

			},

			error : function(jqXHR, textStatus, errorThrown) {

				alert("에러 발생 \n" + "/" + jqXHR + "/" + textStatus + " : "
						+ errorThrown);
			}

		})
	};
</script>


</html>