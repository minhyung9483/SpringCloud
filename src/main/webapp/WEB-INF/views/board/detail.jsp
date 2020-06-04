<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/script.js"></script>
<title>게시물 수정</title>

<link rel="stylesheet" href="/resources/css/board.css">
</head>
<body>
<h3 style="color: SkyBlue; text-align: center;">게시물</h3>
<br>
<div class="container">
  <form action="/boards/update" method="post" id="frm">
    <input type="hidden" id="board_id" name="board_id" value="${board.board_id}">
    <input type="hidden" id="user_id" name="user_id" value="${board.user.user_id}">
    <div style="text-align: right; padding-right: 20px;">
   	</div>
   	
   	<c:choose>
   	<c:when test="${board.secret == 'T'}">
	   	<div class="row">
	      <div class="col-25">
	        <label for="country">비밀글</label>
	      </div>
	      <div class="col-75">
	        <input type=checkbox id="secret" name="secret" value="${board.secret}" checked onClick="checkSecret()">
	      </div>
	    </div>
	    
	    <div class="row" id="pwd_row" >
	      <div class="col-25">
	        <label for="country">비밀번호</label>
	      </div>
	      <div class="col-75">
	        <input type=password id="board_pwd" name="board_pwd" value="${board.board_pwd }">
	      </div>
	    </div>
    </c:when>
    <c:otherwise>
    	<div class="row">
	      <div class="col-25">
	        <label for="country">비밀글</label>
	      </div>
	      <div class="col-75">
	        <input type=checkbox id="secret" name="secret" value="T"  onClick="checkSecret()">
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
    </c:otherwise>
    </c:choose>
   	
    <div class="row">
      <div class="col-25">
        <label>제목</label>
      </div>
      <div class="col-75">
        <input type="text" id="title" name="title" value="${board.title }">
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label>작성자</label>
      </div>
      <div class="col-75">
        <input type="text" id="name" name="name" value="${board.user.name }" disabled>
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label>등록일</label>
      </div>
      <div class="col-75">
        <input type="text" id="regdate" name="regdate" value="${board.regdate }" disabled>
      </div>
    </div>
    
    <c:if test="${board.moddate ne null}">
	    <div class="row">
	      <div class="col-25">
	        <label>수정일</label>
	      </div>
	      <div class="col-75">
	        <input type="text" id="moddate" name="moddate" value="${board.moddate }" disabled>
	      </div>
	    </div>
    </c:if>

    <div class="row">
      <div class="col-25">
        <label for="contents">내용</label>
      </div>
      <div class="col-75">
        <textarea id="content" name="content" style="height:200px">${board.content}</textarea>
      </div>
    </div>
    <div class="row" style="text-align: right; padding-right: 20px;">
      <input type="button" value="삭제하기" onClick="deleteBoard(${board.board_id})" >
      <input type="button" value="목록으로" onClick="location.href='/boards'" >
      <input type="button" value="수정하기" onClick="updateBoard()" />
    </div>
  </form>
</div>
</body>
</html>
