package kr.co.tj.controller;

import com.sun.source.util.DocTreePathScanner;
import kr.co.tj.domain.EmpVO;
import kr.co.tj.service.SelectService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "FrontControllerServlet", value = "*.do")
public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = requestURI.substring(contextPath.length());
//        out.print(requestURI+"<br>");
//        out.print(contextPath+"<br>");
//        out.print(command+"<br>");

        if(command.equals("/insert.do")){
            out.print("등록 요청<br>");
        }else if(command.equals("/delete.do")){
            out.print("삭제 요청<br>");
        }else if(command.equals("/update.do")){
            out.print("수정 요청<br>");
        }else if(command.equals("/select.do")){
            out.print("조회 요청<br>");

            out.println("<html><body>");

            SelectService service = new SelectService();
            ArrayList<EmpVO> list = service.execute(request, response);

            for(EmpVO dto:list){
                String emp_id = dto.getEmp_id();
                String ename = dto.getEname();
                int salary = dto.getSalary();
                String depart = dto.getDepart();
                out.print(emp_id+"\t"+ename+"\t"+salary+"\t"+depart+"<br>");
            }
            out.print("</body></html>");
        }else{
            out.print("error");
        }
    }
}
