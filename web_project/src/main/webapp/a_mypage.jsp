<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-09-05
  Time: 오후 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="a_controller.jsp?action=mupdate" method="post">
    <table>
        <tr>
            <td class="lp">아이디</td>
            <td><input type="text" name="mid" value="${data.mid}" readonly></td>
        </tr>
        <tr>
            <td class="lp">비밀번호</td>
            <td><input type="password" name="mpw" value="${data.mpw}"></td>
        </tr>
        <tr>
            <td class="lp">이름</td>
            <td>${data.mname}</td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="비밀번호변경"></td>
        </tr>
    </table>
</form>
<hr>
<a href="a_controller.jsp?action=mdelete&mid=${data.mid} | ">회원탈퇴</a>
<a href="controller.jsp?action=main">메인페이지 이동</a>

</body>
</html>
