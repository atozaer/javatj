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
  String name="�����";
  out.print("�̰��� out���� ��ü�� ���:"+name+"<br>");
%>
�̰��� expression tag�� ���:<%= name %>
</body>
</html>
