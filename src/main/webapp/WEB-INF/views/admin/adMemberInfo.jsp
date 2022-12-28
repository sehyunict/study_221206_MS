<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<style>
th {
	font-size: 17px;
}

td {
	font-size: 17px;
}

#PWD {
	width: 75%;
	float: left;
}

#Reset {
	width: 25%;
	float: right;
}

@media ( max-width : 600px) {
	th {
		font-size: 14px;
	}
	td {
		font-size: 14px;
	}
	.form-control {
		font-size: 14px;
	}
	#PWD {
		font-size: 12px;
		width: 100%;
		float: left;
	}
	#Reset {
		width: 50%;
		float: left;
	}
}
</style>

<script>
// 온로드시 선택 회원정보 불러오기
	window.onload = function(){
	
	memberInfo();
	
	};
	
	function cancleCheck() {
		
		if (confirm("작업을 취소하시겠습니까?")) {
		
			location = "/admin/Member";
			
		}
		
	};
	
	
	// 회원 정보 로드 메서드
	function memberInfo(){
	
	var memberNo = ${member_no};
	
	
 	$.ajax({
 	
	    type : "POST",
        url : "/admin/Member/info",
        data : "member_no=" + memberNo,
        dataType : "json",
        success : function(memberInfo) {
        	
        	console.log(memberInfo)
        	
        	if (memberInfo.member_marketingcheck == 1) {
        		
        		$("#member_marketingcheck1").attr("checked", true);

        	}
        	else {
        		
        		$("#member_marketingcheck2").attr("checked", true);
        	}
        	
        	document.getElementById('member_id').value = memberInfo.member_id;
        	document.getElementById('member_name').value = memberInfo.member_name;
        	document.getElementById('member_phone').value = memberInfo.member_phone;
        	document.getElementById('member_email').value = memberInfo.member_email;
        	$('#member_subscription').val(memberInfo.member_subscription).prop("selected",true);
        	$('#member_rating').val(memberInfo.member_rating).prop("selected",true);
			
    	},
    	
        error : function(jqXHR, textStatus, errorThrown) {
      	  
      	  alert("정보를 다시 입력해주세요.");
        }
    	
 	})
};

</script>
</head>

<body>
	<%@ include file="/WEB-INF/views/include/adHeader.jsp"%>

	<div class="container" style="margin-bottom: 56px;">
		<div class="row">
			<div class="col-sm-12 text-center">
				<div class="col-sm-3"></div>

				<div class="col-sm-6">
					<h1 style="margin-top: 180px;">회원 정보 수정</h1>
					<table class="table table-boardered">
						<tr>
							<th>아이디</th>
							<td><input type="text" class="form-control" id="member_id"
								readonly></td>
						</tr>
						<tr>
							<th>이름</th>
							<td>
								<input type="text" class="form-control" id="member_name"placeholder="" required="required">
							</td>
						</tr>

						<tr>
							<th>전화번호<br>
							</th>

							<td>
								<input type="tel" class="form-control" id="member_phone"maxlength="13" minlength="10" required="required">
							</td>
						</tr>

						<tr>
							<th>이메일</th>
							<td><input type="text" class="form-control"
								id="member_email" required="required"></td>
						</tr>
						<tr>
							<th>구독권<br>
								<div style="font-size: 12px;"></div>
							</th>

							<td><select class="form-control" name="member_subscription"
								id="member_subscription" style="display: inline-block;">
									<option value="21">일년 이용권</option>
									<option value="22">한달 이용권</option>
									<option value="23">일주일 이용권</option>
									<option value="24">하루 이용권</option>
							</select></td>
						</tr>
						<tr>
							<th>등급<br>
								<div style="font-size: 12px;"></div>
							</th>
							<td><select class="form-control" name="member_rating"
								id="member_rating" style="display: inline-block;">
									<option value="25">브론즈</option>
									<option value="26">실버</option>
									<option value="27">골드</option>
									<option value="28">플레티넘</option>
									<option value="29">다이아몬드</option>
							</select></td>
						</tr>
						<tr>
							<th>마케팅동의<br>
								<div style="font-size: 12px;"></div>
							</th>

						<td>
							<input type='radio' id="member_marketingcheck1" name='member_marketingcheck' value='1' />예
  							<input type='radio' id="member_marketingcheck2" name='member_marketingcheck' value='0' />아니요
						</td>
						</tr>




						<tr>
							<td colspan="2"><input type="submit" class="btn btn-primary"
								value="수정" onclick="adMemberUpdate()"> <input
								type="submit" class="btn btn-warning" value="삭제 "
								onclick="adMemberDelete()"> <input type="button"
								class="btn btn-danger" value="취소" onclick="cancleCheck()">
							</td>
						</tr>


					</table>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/include/adFooter.jsp"%>
</body>
<script>
	function adMemberUpdate() {

		var member_No = ${member_no};
		var member_Id = document.getElementById('member_id').value
		var member_Name = document.getElementById('member_name').value
		var member_Phone = document.getElementById('member_phone').value
		var member_Email = document.getElementById('member_email').value
		var member_Subscription = document.getElementById('member_subscription').value
		var member_Rating = document.getElementById('member_rating').value
		var member_Marketingcheck = $("input[type=radio][name=member_marketingcheck]:checked").val()

		console.log(member_Marketingcheck);
		
		$.ajax({

			type : "POST",
			url : "/admin/Member/update",
			data : "member_no=" + member_No + "&member_name=" + member_Name
					+ "&member_phone=" + member_Phone + "&member_email="
					+ member_Email + "&member_subscription="
					+ member_Subscription + "&member_rating=" + member_Rating
					+ "&member_marketingcheck=" + member_Marketingcheck,

			dataType : "text",

			success : function(data) {

				if (data == 'success') {

					alert("회원수정에 성공했습니다.");

					location = "/admin/Member";

				} else if (data == 'error')

					alert("회원수정에 실패했습니다.");

			},

			error : function(jqXHR, textStatus, errorThrown) {

				alert("정보를 다시 입력해주세요.");
			}

		})
	};

	// 회원 정보 삭제 메서드
	function adMemberDelete() {

		var memberNo = $
		{
			member_no
		}
		;

		var memberId = document.getElementById('member_id').value

		$.ajax({

			type : "POST",
			url : "/admin/Member/delete",
			data : "member_no=" + memberNo,
			dataType : "text",
			success : function(data) {

				if (data == 'success') {

					alert(memberId + "회원삭제에 성공했습니다");
					location = "/admin/Member";

				} else if (data == 'error')

					alert("회원삭제에 실패했습니다.");

			},

			error : function(jqXHR, textStatus, errorThrown) {

				alert("다시 시도 바랍니다.");
			}

		})
	};
</script>
</html>