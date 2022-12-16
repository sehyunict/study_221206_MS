<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
<script>
if (MEMBER_Id == null){</script>
<div style="background:white;margin:-12px -0.5% 0px -20px; text-align:center;height:80px; border: 1px solid">
<h2>로그인 페이지</h2></div>
 <div style="position:absolute; top:50%; left:50%; width:19%; height:80px; margin:-80px 0px 0px -200px; border:1px solid;">
  <form:form name="adminlogin" method="post" action="/adminLoginCheck" modelAttribute="vo">
            아이디 : <input type="text" name="MEMBER_Id"/><br/>
            패스워드 : <input type="password" name="MEMBER_Pw"/><br/>
            <input type="submit" value="로그인">
  </form:form>
     <br>
     <a href="/main.html">고객 페이지로</a>&nbsp;&nbsp;&nbsp;&nbsp;
 </div><br>
 <script>} else if (MEMBER_Id = "admin") {
	 alert("이미 로그인 된 상태입니다.");
 	document.location.href="./board_list.jsp";
 }</script>
</body>
</html>