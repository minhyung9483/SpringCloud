<%@page import="com.mintest.board.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
UserVo user = null;
if (session.getAttribute("user") == null || session.getAttribute("user").equals("")){
	response.sendRedirect("reLogin");
}else{
	user = (UserVo)session.getAttribute("user"); 
%>
<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-bar-block w3-white w3-animate-left w3-text-grey w3-collapse w3-top w3-center" style="z-index:3;width:300px;font-weight:bold" id="mySidebar"><br>
  <h3 class="w3-padding-64 w3-center"><b><%=user.getName() %><br><%=user.getId() %></b></h3>
  <a href="javascript:void(0)" onclick="" class="w3-bar-item w3-button w3-padding w3-hide-large">CLOSE</a>
  <a href="/" onclick="" class="w3-bar-item w3-button">HOME</a> 
  <a href="/clouds" onclick="" class="w3-bar-item w3-button">CLOUD</a> 
  <a href="/boards" onclick="" class="w3-bar-item w3-button">BOARD</a> 
  <a href="/doLogout" onclick="" class="w3-bar-item w3-button">LOGOUT</a>
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-white w3-xlarge w3-padding-16">
  <span class="w3-left w3-padding">SOME NAME</span>
  <a href="javascript:void(0)" class="w3-right w3-button w3-white" onclick="">☰</a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
<%}%>