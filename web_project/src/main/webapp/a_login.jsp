<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-09-05
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<!-- 파라미터가 절약됨 -->
<form action="a_controller.jsp?action=login" method="post">
    <table>
        <tr>
            <td class="lp">아이디</td>
            <td><input type="text" name="mid" required></td>
        </tr>
        <tr>
            <td class="lp">비밀번호</td>
            <td><input type="password" name="mpw" required></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="로그인"></td>
        </tr>
    </table>
</form>
<hr>
<a href="a_signup.jsp">회원가입</a>
</body>
</html>
