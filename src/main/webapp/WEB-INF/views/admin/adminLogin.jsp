<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap">
<style>
* {
  margin: 0;
  padding: 0;
}

body {
  font-family: 'Noto Sans KR', sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-form h1 {
  font-size: 32px;
  text-align: center;
  margin-bottom: 50px;
}

.int-area {
  width: 400px;
  position: relative;
  margin-top: 20px;
}

.int-area:first-child {
  margin-top: 0;
}

.int-area input {
  width: 100%;
  padding: 20px 10px 10px;
  background-color: transparent;
  border: none;
  border-bottom: 1px solid black;
  font-size: 18px;
  outline: none;
}

.int-area label {
  position: absolute;
  left: 10px;
  top: 15px;
  font-size: 18px;
  transition: top 0.5s ease;
}

.int-area label.warning {
  color: red !important;
  animation: warning 0.3s ease;
  animation-iteration-count: 3;
}

@keyframes warning {
  0% {
    transform: translateX(-8px);
  }
  25% {
    transform: translateX(8px);
  }
  50% {
    transform: translateX(-8px);
  }
  75% {
    transform: translateX(8px);
  }
}

.int-area input:focus + label,
.int-area input:valid + label {
  top: -2px;
  font-size: 13px;
  color: #166caa;
}

.btn-area {
  margin-top: 30px;
}

.btn-area button {
  width: 100%;
  height: 50px;
  margin: 0px 10px;
  color: #fff;
  background: #166caa;
  border: none;
  border-radius: 20px;
  font-size: 20px;
  cursor: pointer;
}

.caption {
  margin-top: 20px;
  text-align: center;
}

.caption a {
  margin: 0 20px;
  font-size: 15px;
  color: blue;
  text-decoration: none;
}

</style>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
</head>
<body>
    <section class="login-form">
        <h1>Admin Login</h1>
        <form:form name="adminlogin" method="post" action="/admin/LoginCheck" modelAttribute="vo">
            <div class="int-area">
                <input type="text" name="member_id" id="id" autocomplete="off" required>
                <label for="id">ADMIN ID</label>
            </div>
            <div class="int-area">
                <input type="password" name="member_pw" id="pw" autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
            <div class="btn-area">
                <button id="btn" type="submit">LOGIN</button>
            </div>
            <div>
                 <a href="/">고객 페이지로</a>&nbsp;&nbsp;&nbsp;&nbsp;
 			</div>
        </form:form>

    </section>
  
</body>
</html>