<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-09-02
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="kr.co.tj.board.*" %>

<jsp:useBean id="data" class="kr.co.tj.board.BoardVO" scope="request"></jsp:useBean>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  <form name="checkForm" action="controller.jsp" method="post">
    <input type="hidden" name="bid" value="${data.bid}">
    <input type="hidden" name="action" value="update">
    <table border="1">
      <tr>
        <td class="lg">작성자</td>
        <td><input type="text" name="writer" value="${data.writer}"></td>
      </tr>
      <tr>
        <td class="lg">내용</td>
        <td><input type="text" name="content" value="${data.content}"></td>
      </tr>
      <tr>
        <td class="lg">작성일</td>
        <td><input type="text" name="regdate" value="${data.regdate}"></td>
      </tr>
      <tr>
        <td colspan="2" align="right"><input type="submit" value="내용 변경하기">
        &nbsp;<input type="button" value="글삭제하기" onclick="del()">
        </td>
      </tr>
    </table>
  </form>
  <a href="controller.jsp?action=delete&bid=${data.bid}">글 삭제하기</a>
  <a href="controller.jsp?action=main">메인페이지로 이동하기</a>
  <script>
    function del(){
      ans = confirm("정말 삭제하시겠습니까? 복원되지 않습니다!")
      if(ans==true){
        document.checkForm.action.value="delete";
        document.checkForm.submit();
      }
    }
  </script>
</body>
</html>
