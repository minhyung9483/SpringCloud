<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/login.css">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <script type="text/javascript" src="/resources/js/script.js"></script>
  <script>
  function checkLogin(){
	  var form = document.loginForm;
	  form.submit();
  }
  </script>
  <title>로그인</title>
</head>

<body>
  <div class="main">
  <div class="back"><a href="/">X  </a></div>
    <p class="sign" align="center">로그인</p>
    <form class="form1" name="loginForm" action="/checkLogin" method="post">
      <input class="un " type="text" align="center" placeholder="ID" name="id">
      <input class="pass" type="password" align="center" placeholder="Password" name="password">
      <a class="submit" align="center" href="javascript:checkLogin();">로그인</a>
      <p class="forgot" align="center"><span><a href="/goFindPwd">비밀번호 찾기</a></span> <span><a href="/goSign">회원가입</a></span></p>
    </form>
                
    </div>
</body>

</html>