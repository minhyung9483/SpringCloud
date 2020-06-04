<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<title>게시판</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="/resources/js/script.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="/resources/css/main.css">
<body class="w3-light-grey w3-content" style="max-width:1600px">

<%@ include file="/WEB-INF/views/common/navi.jsp" %>


<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">

  <!-- About section -->
  <div class="w3-container w3-dark-grey w3-center w3-text-light-grey w3-padding-32" id="about">
    <h4><b>게시판</b></h4>
    
      <div class="w3-row-padding" style="margin:0 -16px">
        
      <c:forEach items="${boardList}" var="board" >
      
        <div class="w3-half w3-margin-bottom">
          <ul class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
            <li class="w3-black w3-xlarge w3-padding-32">${board.user.name }</li>
            
            <c:choose>
            
            <c:when test="${board.secret eq 'F'}">
            <li class="w3-padding-16">
              <h2>${board.title }</h2>
              <span class="w3-opacity">${board.content }</span>
            </li>
            <!-- <li class="w3-padding-16">${board.regdate }</li>-->
            <li class="w3-light-grey w3-padding-24">
              <button class="w3-button w3-white w3-padding-large" onClick="goBoardDetail(${board.board_id})">확인</button>
            </li>
            </c:when>
            
            <c:otherwise>
            <li class="w3-padding-16">
              <h2>비밀글</h2>
              <span class="w3-opacity">비밀 게시물 입니다.</span>
            </li>
            <!-- <li class="w3-padding-16">${board.regdate }</li>-->
            <li class="w3-light-grey w3-padding-24">
              <button class="w3-button w3-white w3-padding-large" onClick="goCheckPwd(${board.board_id})">확인</button>
            </li>
            </c:otherwise>
            
            </c:choose>
          </ul>
        </div>
        
       </c:forEach>
       
       <div class="w3-half w3-margin-bottom">
          <ul class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
            <li class="w3-black w3-xlarge w3-padding-32">게시글 등록</li>
            

            <li class="w3-padding-16">
              <h2>+</h2>
              <span class="w3-opacity">게시글을 등록합니다.</span>
            </li>
            <li class="w3-light-grey w3-padding-24">
              <button class="w3-button w3-white w3-padding-large" onClick="goBoardWrite()">등록</button>
            </li>
          </ul>
        </div>
        
      </div>
      
    </div>
  
  
  <!-- Pagination -->
  <div class="w3-center w3-padding-32">
    <div class="w3-bar">
      <a href="#" class="w3-bar-item w3-button w3-hover-black">«</a>
      <a href="#" class="w3-bar-item w3-black w3-button">1</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">2</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">3</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">4</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">»</a>
    </div>
  </div>

  
  <div class="w3-black w3-center w3-padding-24">Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-opacity">w3.css</a></div>

<!-- End page content -->
</div>

<script>
// Script to open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}

</script>


</body>
</html>
