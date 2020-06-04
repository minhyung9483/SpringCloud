<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/script.js"></script>
<title>게시물 등록</title>

<link rel="stylesheet" href="/resources/css/board.css">
</head>
<body>
<h3 style="color: SkyBlue; text-align: center;">게시물 작성</h3>
<br>
<div class="container">
  <form action="/boards" method="post" id="frm">
    <input type="hidden" id="user_id" name="user_id" value="${user.user_id}">
   	
   	<div class="row">
      <div class="col-25">
        <label for="country">비밀글</label>
      </div>
      <div class="col-75">
        <input type=checkbox id="secret" name="secret" value="T" onClick="checkSecret()">
      </div>
    </div>
    
    <div class="row" id="pwd_row" style="display:none">
      <div class="col-25">
        <label for="country">비밀번호</label>
      </div>
      <div class="col-75">
        <input type=password id="board_pwd" name="board_pwd" placeholder="비밀번호">
      </div>
    </div>
   	
    <div class="row">
      <div class="col-25">
        <label>제목</label>
      </div>
      <div class="col-75">
        <input type="text" id="title" name="title" placeholder="제목">
      </div>
    </div>

    <div class="row">
      <div class="col-25">
        <label for="contents">내용</label>
      </div>
      <div class="col-75">
        <textarea id="content" name="content" placeholder="내용" style="height:200px"></textarea>
      </div>
    </div>
    <div class="row" style="text-align: right; padding-right: 20px;">
    	<input type="button" value="목록으로" onClick="location.href='/boards'" >
      <input type="button" value="등록하기" onClick="insertBoard()" >
    </div>
  </form>
</div>
</body>
</html>
