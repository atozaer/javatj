package kr.co.tj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestServlet", value = "/Request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //속성설정
        request.setAttribute("username","TJ더좋은");
        request.setAttribute("useraddress","서울특별시구로디지털단지");

        //forward
        RequestDispatcher dis = request.getRequestDispatcher("Response");
        dis.forward(request,response);
    }
}
