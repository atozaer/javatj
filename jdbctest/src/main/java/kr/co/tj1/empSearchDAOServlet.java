package kr.co.tj1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "empSearchDAOServlet", value = "/empSearchDAO")
public class empSearchDAOServlet extends HttpServlet {
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
        vo = dao.search(vo);
        out.print("<h1>사원검색결과</h1>");
        out.print("사원아이디&nbsp;사원이름&nbsp;급여&nbsp;부서<br>");
        out.print(vo.getEmp_id()+"&nbsp;"+vo.getEname()+"&nbsp;"+vo.getSalary()+"&nbsp;"+vo.getDepart()+"<br>");

        out.print("</body></html>");
    }
}
