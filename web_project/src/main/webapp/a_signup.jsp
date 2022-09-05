<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-09-05
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <meta charset="UTF-8">
</head>
<body>
<form action="a_controller.jsp?action=a_signup" method="post">
  <table border="1">
    <tr>
      <td class="lp">아이디</td>
      <td><input type="text" name="mid" required></td>
    </tr>
    <tr>
      <td class="lp">패스워드</td>
      <td><input type="password" name="mpw"></td>
    </tr>
    <tr>
      <td class="lp">이름</td>
      <td><input type="text" name="mname"></td>
    </tr>
    <tr>
      <td colspan="2" align="right"><input type="submit" value="회원가입"></td>
    </tr>
  </table>
</form>
<hr>
<a href="a_login.jsp">로그인페이지</a>
</body>
</html>
