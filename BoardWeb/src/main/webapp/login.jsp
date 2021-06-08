<%@ page contentType="text/html; charset=EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
</head>
<body>
<center>
<h1>로그인</h1>
<hr>
<!-- <form action="login_proc.jsp" method="post"> -->
<form action="login.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
   <tr>
      <td bgcolor="orange">아이디</td>
      <!-- ${userVO.id } => ModelAttribute 사용하면 객체가 아닌 설정한 ModelAttribute로 mapping한다. -->
      <td><input type="text" name="id" value="${user.id }"/></td>
   </tr>
   <tr>
      <td bgcolor="orange">비밀번호</td>
      <!-- ${userVO.password } => ModelAttribute 사용하면 객체가 아닌 설정한 ModelAttribute로 mapping한다. -->
      <td><input type="password" name="password" value="${user.password }"/></td>
   </tr>
   <tr>
      <td colspan="2" align="center">
         <input type="submit" value="로그인"/>
      </td>
   </tr>
</table>
</form>
<hr>
</center>
</body>
</html>