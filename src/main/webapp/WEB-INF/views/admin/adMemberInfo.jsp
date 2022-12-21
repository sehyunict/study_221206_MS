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

  @media (max-width: 600px) {
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
 font-size:12px;
 width: 100%; 
 float: left;
 }
 #Reset {
width: 50%;
float: left;
 }	
</style>

<script>
// 온로드시 선택 회원정보 불러오기
	window.onload = function(){
	
	memberInfo();
	
	};
	
	function cancleCheck() {
		
		if (confirm("작업을 취소하시겠습니까?")) {
		
			location = "/adminMember";
			
		}
		
	};
	
	
	// 회원 정보 로드 메서드
	function memberInfo(){
	
	var memberNo = ${member_no};
	
	
 	$.ajax({
 	
	    type : "POST",
        url : "/adminMember/info",
        data : "member_no=" + memberNo,
        dataType : "json",
        success : function(memberInfo) {
        	
        	console.log(memberInfo)
        	
        	document.getElementById('member_id').value = memberInfo.member_id;
        	document.getElementById('member_name').value = memberInfo.member_name;
        	document.getElementById('member_phone').value = memberInfo.member_phone;
        	document.getElementById('member_email').value = memberInfo.member_email;
        	document.getElementById('member_subscription').value = memberInfo.member_subscription;
        	document.getElementById('member_rating').value = memberInfo.member_rating;
        	document.getElementById('member_marketingcheck').value = memberInfo.member_marketingcheck;
			
    	},
    	
        error : function(jqXHR, textStatus, errorThrown) {
      	  
      	  alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
        }
    	
 	})
};

</script>
</head>

<body>

     <div class="container" style="margin-bottom: 56px;">
    <div class="row">
    <div class="col-sm-12 text-center" >
    <div class="col-sm-3" ></div>
     
    <div class="col-sm-6">
    <h1 style="margin-top: 180px;">회원 정보 수정</h1>
        <table class="table table-boardered">
            <tr>
                <th>아이디</th>
                <td><input type="text" class="form-control" id="member_id" readonly ></td>
            </tr>         
            <tr>
                <th>이름</th>
                <td><input type="text" class="form-control" id="member_name" placeholder="" required="required"></td>       
            </tr>
            
             <tr>
                <th>전화번호<br>
                 <div style="font-size: 12px;">(- 제외 숫자만 입력 바랍니다.)</div>
                </th>
               
                <td><input type="tel" class="form-control" id="member_phone" maxlength = "12" minlength = "9" required="required"></td>       
            </tr>

		  	<tr>    
                <th>이메일</th>
				<td><input type="text" class="form-control" id="member_email" required="required"></td>
			</tr>
			             <tr>
                <th>구독권<br>
                 <div style="font-size: 12px;"></div>
                </th>
               
                <td><input type="tel" class="form-control" id="member_subscription"  maxlength = "12" minlength = "9" required="required"></td>       
            </tr>
                         <tr>
                <th>등급<br>
                 <div style="font-size: 12px;"></div>
                </th>
               
                <td><input type="tel" class="form-control" id="member_rating"  maxlength = "12" minlength = "9" required="required"></td>       
            </tr>
                         <tr>
                <th>마케팅동의<br>
                 <div style="font-size: 12px;"></div>
                </th>
               
                <td><input type="tel" class="form-control" id="member_marketingcheck"  maxlength = "12" minlength = "9" required="required"></td>       
            </tr>
			



            <tr>
                <td colspan="2">
                <input type="submit" class="btn btn-primary" value="수정" onclick="adMemberUpdate()">
                
                <input type="submit" class="btn btn-warning" value="삭제 " onclick="adMemberDelete()">
        
                <input type="button" class="btn btn-danger" value="취소" onclick="cancleCheck()" >
                </td>                
	</tr>
             
             
        </table>
    </div>
     
    </div>
    </div>
</div>
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
	var member_Marketingcheck = document.getElementById('member_marketingcheck').value
	
 	 $.ajax({
 	
	    type : "POST",
        url : "/adminMember/update",
        data : "member_no=" + member_No + 
        	   "&member_name=" + member_Name + 
        	   "&member_phone=" + member_Phone + 
        	   "&member_email=" + member_Email + 
        	   "&member_subscription=" + member_Subscription + 
        	   "&member_rating=" + member_Rating + 
        	   "&member_marketingcheck=" + member_Marketingcheck,
        	   
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



// 회원 정보 삭제 메서드
function adMemberDelete(){

	var memberNo = ${member_no};
	
	var memberId = document.getElementById('member_id').value

	$.ajax({
	
    type : "POST",
    url : "/adminMember/delete",
    data : "member_no=" + memberNo,
    dataType : "text",
    success : function(data) {
    	
    	if (data == 'success') {
    		
        alert(memberId + "회원삭제에 성공했습니다");
        location = "/adminMember";
    	
    	}else if (data == 'error')
    		
    	alert ("회원삭제에 싫패했습니다.");
    	
	},

    error : function(jqXHR, textStatus, errorThrown) {
  	  
  	  alert("에러 발생 \n" +"/"+jqXHR+"/"+ textStatus + " : " + errorThrown);
    }
	
	})
};

</script>
</html>