<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="yoon" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    function check(bid){
        passwd = prompt('상세페이지로 이동하기 위해 비밀번호를 입력하세요.');
        location.href="controller.jsp?action=board&passwd="+passwd+"&bid="+bid;
    }
</script>
<table border="1">
    <tr>
        <th>글번호</th><th>글작성자</th><th>작성일</th>
    </tr>
    <c:forEach var="v" items="${datas}">
        <tr>
            <td><a href="javascript:check(${v.bid})">${v.bid}</a> </td><td>${v.writer}</td><td>${v.regdate}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<a href="insert.jsp">글작성 페이지</a>
</body>
</html>
