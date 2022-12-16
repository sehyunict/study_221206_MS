<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<style>
		* {
		    padding: 0px;
		    margin: 0px;
		    box-sizing: border-box;
		}
		a {
			text-decoration: none;
			font-weight: bold;
		}
		header {
		    width: 100%;
			height: 120px;
			padding: 35px 150px;
			border-bottom: 1px #E6E6E6 solid;
		}
		header > a > h1 {
		    width: 350px;
			height: 50px;
			display: inline-block;
			float: left;
		}
		header > nav {
			float: left;
		}
		header > nav > ul {
			list-style: none;
			margin: 12.5px 0px 0px 20px;
			height: 50px;
		}
		header > nav > ul > li {
			display: inline-block;
			margin-right: 15px;
		}
		header > div {
			float: right;
		}
		header > div > ul {
			list-style: none;
			height: 50px;
		}
		header > div > ul > li {
			display: inline-block;
			margin-right: 15px;
		}
		header > div > ul > li > a {
			margin-top: 12.5px;
		}
		header > div > ul > li > form > input[type="text"] {
			width: 300px;
			height: 50px;
			margin-right: 15px;
			border-radius: 25px;
			border: 0px;
			background-color: #F0F0F0;
			padding: 0px 25px;
			outline: none;
		}
		header > div > ul > li > form > input[type="submit"] {
			width: 60px;
			height: 30px;
			border: 1px #E6E6E6 solid;
			background-color: white;
			border-radius: 2.5px;
			cursor: pointer;
			outline: none;
		}
		section {
			margin: 50px 150px;
		}
		footer {
			width: 100%;
			height: 120px;
			padding: 35px;
			text-align: center;
			border-top: 1px #E6E6E6 solid;
		}
	</style>
</head>
<header>
	<a href="/"><h1>SEHYUNICT MUSIC</h1></a>
	<nav>
		<ul>
			<li><a href="#">회원관리</a></li>
			<li><a href="#">음악관리</a></li>
			<li><a href="#">앨범관리</a></li>
			<li><a href="#">가수관리</a></li>
		</ul>
	</nav>
	<div>
		<ul>
			<li><a href="#">로그아웃</a></li>
		</ul>
	</div>
</header>