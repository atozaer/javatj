<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!--  �ڹٺ� ��� -->
<jsp:useBean id="myBean" class="kr.co.busan.LoginBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>useBean �ǽ�</title>
</head>
<body>
<h1>useBean ���ǽ�</h1>
<%
  myBean.setUserid("ladagers");
  myBean.setPasswd("ladagers");
%>
����� ���̵�:<%= myBean.getUserid() %><br>
����� ��й�ȣ:<%= myBean.getPasswd() %><br>
</body>
</html>
