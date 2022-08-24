<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>방문자수 조회</title>
</head>
<body>
<h1>방문자수 조회하기 화면</h1>
<%
  int count = (Integer)application.getAttribute("countValue");
%>
현재까지 총 방문자수: <%=count %>
</body>
</html>
