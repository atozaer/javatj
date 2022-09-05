package kr.co.tj.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FrontControllerServlet", value = "*.do")
public class FrontController extends HttpServlet {
    public FrontController(){
        // 기본생성자 : 서블릿 컨테이너가 관리하기 위해 반드시 필요
        // 객체의 생성 및 관리를 담당하는 것 == 컨테이너
        // 서블릿 컨테이너 == 톰켓
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actionDo(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actionDo(request, response);
    }

    private void actionDo(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        String cp = request.getContextPath();
        String command = uri.substring(cp.length());

        if (command.equals("/login.do")) {
            System.out.println("로그 : FrontController : 로그인요청");
            forward = new LoginAction();
        } else if (command.equals("/main.do")) {
            System.out.println("로그 : FrontController : 메인페이지 출력요청");
        } else if (command.equals("/logout.do")) {
            System.out.println("로그아웃처리");
        } else if (command.equals("/board.do")) {
            System.out.println("상세페이지로가기");
        } else if (command.equals("/insert.do")) {
            System.out.println("글등록");
        } else if (command.equals("/update.do")) {
            System.out.println("글변경");
        } else if (command.equals("/delete.do")) {
            System.out.println("글삭제");
        } else if (command.equals("/signup.do")) {
            System.out.println("회원가입");
        } else if (command.equals("/mupdate.do")) {
            System.out.println("마이페이지에서 회원정보 변경");
        } else if (command.equals("/mdelete.do")) {
            System.out.println("회원삭제=멤버탈퇴");
        } else {
            System.out.println("잘못된 요청!!!");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
