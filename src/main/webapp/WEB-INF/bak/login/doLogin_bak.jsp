<%@page import="com.mintest.board.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% UserVo user = (UserVo)request.getAttribute("user"); %>
<% %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>♥Board List♥</title>
<style>
table {
   width: 100%;
   boarder: 1px solid SkyBlue;
}
th, td {
   boarder: 1px solid SkyBlue; 
}
th {
   background-color: dodgerblue;
   color: white;
}
</style>
</head>
<body>
<h3 style="color: SkyBlue; text-align: center;">♥ 회원 목록 ♥</h3>
<form>
   <div style="text-align: right; padding-right: 20px;">
      <input type="button" value="게시물 작성" onClick="" />
   </div>
   </br>
   <table>
      <thead>
         <tr>
            <th>No</th>
            <th>이름</th>
            <th>ID</th>
            <th>비밀번호</th>
         </tr>
      </thead>
      <tbody>
         
            <tr align="center" background=""
                  onmouseover="this.style.backgroundColor='SkyBlue'"
                  onmouseout="this.style.backgroundColor=''">
         
               <td><%=user.getUser_id() %></td>
               <td><%=user.getName() %></td>
               <td><%=user.getId() %></td>
               <td><%=user.getPassword() %></td>
            </tr>
        
      </tbody>
   </table>
</form>
</body>
</html>