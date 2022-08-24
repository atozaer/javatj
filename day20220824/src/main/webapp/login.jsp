<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>session test</title>
</head>
<body>
<h1>로그인 정보 세션 저장</h1>
<%
  String id = request.getParameter("userid");
  if(id==null){
    response.sendRedirect("loginForm.html");
  }else{
    String pw = request.getParameter("passwd");

    session.setAttribute("userid", id);
    session.setAttribute("passwd", pw);

    out.print("안녕하세요"+id);
    out.print("<a href='loginInfo.jsp'>정보보기</a>");
  }
%>
</body>
</html>
