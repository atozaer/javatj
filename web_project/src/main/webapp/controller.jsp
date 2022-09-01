<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.co.tj.board.BoardVO" %><%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-09-01
  Time: 오후 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="kr.co.tj.board.BoardDAO"></jsp:useBean>
<jsp:useBean id="vo" class="kr.co.tj.board.BoardVO"></jsp:useBean>
<jsp:setProperty name="vo" property="*"/>
<%
    //action 파라미터의 값에 따라 분기처리
    String action = request.getParameter("action");

    if (action.equals("main")) {//main시작
        //index.jsp로부터 넘어온 최초 DB연결 요청
        //1. DB => DAO selectAll() => datas[MODEL]
        ArrayList<BoardVO> datas = dao.selectAll(vo);
        //2. datas setAttribute() => [Controller]
        request.setAttribute("datas",datas);
        //3. main.jsp로 이동[VIEW]
        pageContext.forward("main.jsp");
    }//main끝
    else if (action.equals("board")) {//board시작

    }//board끝
    else if (action.equals("update")) {//update시작

    }//update끝
    else if (action.equals("delete")) {//delete시작

    }//delete끝
    else if (action.equals("insert")) {//insert시작

    }//insert끝
    else {
        System.out.println("잘못된 action 파라미터!!!");
    }
%>
