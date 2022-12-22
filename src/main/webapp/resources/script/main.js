$(document).ready(function() {
	//랭크리스트 : 전체 체크박스 기능
	$("#rankCheckAll").change(function() {
		if ($("#rankCheckAll").is(":checked")) {
   			$("input[name='rankCheck']:checkbox").prop("checked", true);
	    } else {
	    	$("input[name='rankCheck']:checkbox").prop("checked", false);
	    }
	});
	
	//플레이리스트 : 전체 체크박스 기능
	$("#listCheckAll").change(function() {
		if ($("#listCheckAll").is(":checked")) {
			$("input[name='listCheck']:checkbox").prop("checked", true);
	    } else {
	    	$("input[name='listCheck']:checkbox").prop("checked", false);
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
					html += "		<input type=\"checkbox\" name=\"listCheck\" id=\"listCheck" + $("#listSize").val() + "\">";
					html += "		<input type=\"hidden\" value=\"" + result[i].music_no + "\" id=\"list" + $("#listSize").val() + "\">";
					html += "		<input type=\"hidden\" value=\"" + result[i].now_playList_no + "\" id=\"playList" + $("#listSize").val() + "\">";
					html += "	</td>";
					html += "	<td>";
					html += "		<a href=\"/MD?" + result[i].music_no + "\">" + result[i].music_title + "</a>";
					html += "		<input type=\"hidden\" name=\"count" + result[i].now_playList_no + "\" value=\"" + result[i].now_playList_count + "\">";
					html += "		<input type=\"hidden\" name=\"date" + result[i].now_playList_no + "\" value=\"" + result[i].now_playList_date + "\">";
					html += "	</td>";
					html += "	<td><a href=\"/ATD?" + result[i].artist_no + "\">" + result[i].artist_name + "</a></td>";
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
/* 			$("#listSize").val(parseInt($("#listSize").val()) - 1); */
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
/* 					$("#listSize").val(parseInt($("#listSize").val()) - 1); */
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