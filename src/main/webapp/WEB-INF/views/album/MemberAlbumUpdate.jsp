<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <div class="container" style="margin-bottom: 56px;">
    <div class="row">
    <div class="col-sm-12 text-center" >
    <div class="col-sm-3" ></div>
     
    <div class="col-sm-6">
    <h1 style="margin-top: 180px;">사용자 앨범 수정</h1>
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
</html>