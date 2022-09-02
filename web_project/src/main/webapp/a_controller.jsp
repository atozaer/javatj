<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-09-02
  Time: 오후 6:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" errorPage="error.jsp"
         import="kr.co.tj.member.*"
%>

<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mdao" class="kr.co.tj.member.MemberDAO"/>
<jsp:useBean id="mvo" class="kr.co.tj.member.MemberVO"/>
<jsp:setProperty name="mvo" property="*"/>
<%
    String action = request.getParameter("action");

    if (action.equals("login")) {//로그인시작
        MemberVO data = mdao.selectOne(mvo);
        if (data==null){
            System.out.println("로그 : 로그인 실패!!!");
        } else {
            session.setAttribute("data", data);
            response.sendRedirect("controller.jsp?action=main");
        }
    }//로그인끝
    else if (action.equals("logout")) {//로그아웃시작

    }//로그아웃시작
    else if (action.equals("signup")) {//회원가입시작

    }//회원가입끝
    else if (action.equals("mupdate")) {//패스워드수정

    }//패스워드수정
    else if (action.equals("mdelete")) {//회원탈퇴

    }//회원탈퇴
    else {
        throw new Exception("잘못된 action 파라미터!!!");
    }
%>
