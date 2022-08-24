<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>방문자수 카운트</title>
</head>
<body>
<h1>방문자수 설정하기 화면</h1>
<%! int count; %>
<%
  count++;

  application.setAttribute("countValue", count);
%>

현재방문자수:<%= count %>
</body>
</html>
