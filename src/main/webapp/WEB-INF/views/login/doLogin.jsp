<%@page import="com.mintest.board.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% UserVo user = (UserVo)request.getAttribute("user"); %>
<% session.setAttribute("user", user);%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>로그인</title>
<script>
location.href="/";
</script>
</head>

</html>