<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
    // DB에 처음 방문할 수 있도록 요청

    // 페이지 이동에도 값을 유지 -> forward요청

    pageContext.forward("controller.jsp?action=main");

    // Controller에서 사용자의 요청을 분기처리하기 위해 action의 파라미터를 사용할 예정!!
%>
