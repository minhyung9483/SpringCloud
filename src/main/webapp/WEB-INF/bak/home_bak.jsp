<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/js/home.js"></script>
</head>
<body>
<h1>
	초기화면 
</h1>

<div id="curtime"><p>  현재 시간 : ${serverTime}. </p></div>
<input type="button" onClick="curTime()" value="현재시간"/>
<input type="button" onClick="goLogin()" value="로그인"/>
<input type="button" onClick="goSign()" value="회원가입"/>
</body>
</html>