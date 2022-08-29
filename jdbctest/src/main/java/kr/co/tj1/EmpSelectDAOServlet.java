package kr.co.tj1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "empSelectDAO", value = "/empSelectDAO")
public class EmpSelectDAOServlet extends HttpServlet {
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
        ArrayList<EmpVO> list = dao.select();
        System.out.print("사원번호&nbsp;사원이름&nbsp;급여&nbsp;부서<br>");
        for(EmpVO vo: list){
            String emp_id = vo.getEmp_id();
            String ename = vo.getEname();
            int salary = vo.getSalary();
            String depart = vo.getDepart();

            out.print(emp_id+"&nbsp;"+ename+"&nbsp;"+salary+"&nbsp;"+depart+"<br>");
        }
        out.print("</body></html>");
    }
}
