package kr.co.tj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestRedirectServlet", value = "/RequestRedirect")
public class RequestRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //속성설정
        request.setAttribute("username","홍길동");
        request.setAttribute("useraddress","서울시구로구");

        //redirect
        response.sendRedirect("ResponseRedirect");
    }
}
