<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-08-31
  Time: 오후 5:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>JSTL Core 라이브러리 실습</title>
</head>
<body>
<h1>JSTL Core 라이브러리 실습</h1>
<%
    int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    request.setAttribute("myArray", num);
%>
<c:forEach var="n" items="${myArray}">
    <c:out value="${n}"/>
</c:forEach>
<br>
<c:forEach var="n" items="${myArray}" begin="0" end="6">
    <c:out value="${n}"/>
</c:forEach>


</body>
</html>
