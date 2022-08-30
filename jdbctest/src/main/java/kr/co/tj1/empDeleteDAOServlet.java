package kr.co.tj1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "empDeleteDAOServlet", value = "/empDeleteDAO")
public class empDeleteDAOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        EmpDAO dao = new EmpDAO();
        EmpVO vo = new EmpVO();
        String emp_id = request.getParameter("emp_id");
        vo.setEmp_id(emp_id);
        int cnt = dao.delete(vo);
        if(cnt==0){
            out.print("삭제실패");
        }else {
            out.print("삭제성공");
        }


        out.print("</body></html>");
    }
}
