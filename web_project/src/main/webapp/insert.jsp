<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-09-02
  Time: 오후 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="kr.co.tj.board.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>1
<form action="controller.jsp" name="checkForm" method="post">
  <input type="hidden" name="action" value="insert">
  <table>
    <tr>
      <td class="lg">작성자</td>
      <td><input type="text" name="writer" placeholder="${data.mname}"></td>
    </tr>
    <tr>
      <td class="lg">내용</td>
      <td><input type="text" name="content"></td>
    </tr>
    <tr>
      <td colspan="2" align="right"><input type="submit" value="글등록하기"></td>
    </tr>
  </table>
</form>
<hr>
<a href="main.jsp">메인페이지로 이동</a>

</body>
</html>
