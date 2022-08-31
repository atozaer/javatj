package kr.co.tj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CartSaveServlet", value = "/CartSave")
public class CartSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //입력파라미터 얻기
        String product = request.getParameter("product");

        //세션객체 얻기
        HttpSession session = request.getSession();
        ArrayList<String> list = (ArrayList<String>)session.getAttribute("product");
        if(list==null){
            list = new ArrayList<String>();
            list.add(product);
            session.setAttribute("product",list);
        }else {
            list.add(product);
        }
        out.print("<html><body>");
        out.print("Product 추가<br>");
        out.print("<a href='CartBasket'>장바구니보기</a><br>");
        out.print("</body></html>");


    }
}
