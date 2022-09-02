<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${data.name!=null}">
        <h1>${data.mname}님, 안녕하세요! :)</h1>
        <h3><a href="a_mypage.jsp">마이페이지</a><a href="a_controller.jsp?action=logout">로그아웃</a></h3>
    </c:when>
    <c:otherwise>
        <h1>※로그인 후에 이용해 주세요※</h1>
    </c:otherwise>
</c:choose>
