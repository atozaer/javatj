package kr.co.tj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseServlet", value = "/Response")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //속성값 얻기
        String username = (String) request.getAttribute("username");
        String useraddress = (String) request.getAttribute("useraddress");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");

        out.print("username 값:"+username+"<br>");
        out.print("useraddress 값:"+useraddress+"<br>");

        out.print("</body></html>");
    }
}
