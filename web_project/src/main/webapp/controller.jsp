<%@ page import="java.util.*" %>
<%@ page import="kr.co.tj.board.*" errorPage="error.jsp" %>

<%@ page import="java.io.IOException" %><%--
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
        request.setAttribute("datas", datas);
        //3. main.jsp로 이동[VIEW]
        pageContext.forward("main.jsp");
    }//main끝
    else if (action.equals("board")) {//board시작
        if (!request.getParameter("passwd").equals("1234")) {
            out.print("<script>alert('비밀번호가 틀렸습니다!'); history.go(-1);</script>");
        } else {
            //메인페이지에서 상세페이지보여달라고 요청
            //System.out.println("상세페이지:"+request.getParameter("bid"));
            //0. bid의 값을 vo에 저장[Controller]>>vo.setBid(Integer.parseInt(request.getParameter("bid"));
            //System.out.println(vo);
            //1. DAO selectOne(vo)[MODEL]
            BoardVO data = dao.selectOne(vo);
            if (data == null) {
                response.sendRedirect("controller.jsp?action=main");//새로요청할 경우 => sendRedirect()
            }
            //2. data setAttribute() [Controller]
            request.setAttribute("data", data);
            //3. board.jsp로 이동[View]
            pageContext.forward("board.jsp");//타겟페이지가 존재할 경우 => forward
        }
    }//board끝
    else if (action.equals("update")) {//update시작
        if (dao.update(vo)) {
            response.sendRedirect("controller.jsp?action=main");
        } else {
            throw new Exception("update중에 오류발생!");
        }
    }//update끝
    else if (action.equals("delete")) {//delete시작
        if (dao.delete(vo)) {
            response.sendRedirect("controller.jsp?action=main");
        } else {
            throw new Exception("delete중에 오류발생!");
        }
    }//delete끝
    else if (action.equals("insert")) {//insert시작
        if (dao.insert(vo)) {
            response.sendRedirect("controller.jsp?action=main");
        } else {
            throw new Exception("insert중에 오류발생!");
        }
    }//insert끝
    else {
        throw new Exception("잘못된 action 파라미터!!!");
    }
%>
