package kr.co.tj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CartDeleteServlet", value = "/CartDelete")
public class CartDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        out.print("장바구니 비움!<br>");
        //세션객체 얻기
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }else {
            out.print("세션없음<br>");
        }
        out.print("<a href='product.html'>상품 선택페이지</a>");
        out.print("</body></html>");
    }
}
