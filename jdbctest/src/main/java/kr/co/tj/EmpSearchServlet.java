package kr.co.tj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "EmpSearchServlet", value = "/EmpSearch")
public class EmpSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String emp_id = request.getParameter("emp_id");
        String ename = request.getParameter("ename");
        String salary = request.getParameter("salary");
        String depart = request.getParameter("depart");

        PrintWriter out = response.getWriter();
        out.print("<html><body>");

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/tj?characterEncoding=utf8";
        String userid = "root";
        String passwd = "1234";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,userid,passwd);

            String sql = "select emp_id,ename,salary,depart from emp where emp_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,emp_id);
            rs = pstmt.executeQuery();
            out.print("찾은사원은:<br>");
            out.print("사원아이디&nbsp;사원이름&nbsp;급여&nbsp;부서&nbsp;<br>");
            if (rs.next()){
                emp_id = rs.getString("emp_id");
                ename = rs.getString("ename");
                int salary1 = rs.getInt("salary");
                depart = rs.getString("depart");
                out.print(emp_id+"&nbsp;"+ename+"&nbsp;"+salary1+"&nbsp;"+depart+"&nbsp<br>");
            }
            else{
                out.print("검색실패");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
                pstmt.close();
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
