<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-08-24
  Time: 오후 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>로그인 입력 파라미터 출력</h1>
<%
    request.setCharacterEncoding("utf-8");

    String userid = request.getParameter("userid");
    String passwd = request.getParameter("passwd");
%>
    아이디값: <%=userid %><br>
    비밀번호: <%=passwd %> <br>

</body>
</html>
