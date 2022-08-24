<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>out test</title>
</head>
<body>
<%
  String name="조용운";
  out.print("이것은 out내장 객체로 출력:"+name+"<br>");
%>
이것은 expression tag로 출력:<%= name %>
</body>
</html>
