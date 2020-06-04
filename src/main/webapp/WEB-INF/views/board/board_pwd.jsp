<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/script.js"></script>
<title>게시물 비밀번호 입력</title>

<link rel="stylesheet" href="/resources/css/board.css">
</head>
<body>
<div class="container">
    <input type="hidden" id="board_id" name="board_id" value="${board.board_id}">
    <input type="hidden" id="board_pwd" name="board_pwd" value="${board.board_pwd}">
    
    <div class="row">
      <div class="col-25">
        <input type=password id="board_pwd_input" name="board_pwd_input" placeholder="비밀번호">
      </div>
    </div>
    <div class="row">
      <div class="col-25"  style="text-align:right">
   		 <input type="button" value="목록으로" onClick="location.href='/boards'" />
    	 <input type="button" value="확인" onClick="checkBoardPwd()" >    
      </div>
    </div>

</div>
</body>
</html>
