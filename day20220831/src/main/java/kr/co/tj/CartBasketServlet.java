package kr.co.tj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CartBasketServlet", value = "/CartBasket")
public class CartBasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        out.print("장바구니리스트");

        //세션객체 얻기
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(200);
        if(session!=null){
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");
            out.print("상품 : "+list+"<br>");
        }else {
            out.print("세션없음<br>");
        }
        out.print("<a href='product.html'>상품선택페이지</a><br>");
        out.print("<a href='CartDelete'>장바구니비우기</a><br>");
        out.print("</body></html>");
    }
}
