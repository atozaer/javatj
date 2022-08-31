<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-08-31
  Time: 오후 5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="myBean" class="kr.co.tj.el.LoginBean"/>
<jsp:setProperty name="myBean" property="*"/>
<html>
<head>
    <title>EL실습(jsp)</title>
</head>
<body>
    <h1>EL실습</h1>
    사용자아이디 : ${myBean.userid}<br>
    사용자비빌번호 : ${myBean.passwd}<br>
</body>
</html>
