<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Config test</title>
</head>
<body>
	<h2>config 테스트</h2>
	<table border="1">
		<tr>
			<td>초기 파라미터 이름</td>
			<td>초기 파라미터 값</td>
		</tr>
		<%
		Enumeration e = config.getInitParameterNames();
		while (e.hasMoreElements()) {
			String init_paramName = (String) e.nextElement();
		%>
		<tr>
			<td><%=init_paramName%></td>
			<td><%=config.getInitParameter(init_paramName)%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
