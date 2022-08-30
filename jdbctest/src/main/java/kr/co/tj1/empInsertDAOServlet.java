package kr.co.tj1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "empInsertDAOServlet", value = "/empInsertDAO")
public class empInsertDAOServlet extends HttpServlet {
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
        String ename = request.getParameter("ename");
        String salary = request.getParameter("salary");
        String depart = request.getParameter("depart");
        vo.setEmp_id(emp_id);
        vo.setEname(ename);
        vo.setSalary(Integer.parseInt(salary));
        vo.setDepart(depart);
        int cnt = dao.insert(vo);
        if(cnt==0){
            out.print("등록실패");
        }else {
            out.print("등록성공");
        }


        out.print("</body></html>");
    }
}
