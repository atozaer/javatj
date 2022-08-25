package kr.co.tj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "EmpSelectServlet", value = "/EmpSelectServlet")
public class EmpSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.print("<html>");
        out.print("<head>");
        out.print("<title>서블릿JDBC실습</title>");
        out.print("<body>");
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/tj?characterEncoding=utf8";
        String userid = "root";
        String passwd = "1234";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userid, passwd);
            String sql = "select emp_id,ename,salary,depart from emp";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            out.print("사원번호&nbsp;&nbsp;&nbsp;사원이름&nbsp;&nbsp;&nbsp;급여&nbsp;&nbsp;&nbsp;부서<br>");
            out.print("<h1>서블릿 JDBC 데이터 출력하기</h1>");
            while (rs.next()) {
                String emp_id = rs.getString("emp_id");
                String ename = rs.getString("ename");
                int salary = rs.getInt("salary");
                String depart = rs.getString("depart");
                out.print(emp_id + "&nbsp;&nbsp;&nbsp;" + ename + "&nbsp;&nbsp;&nbsp;" + salary + "&nbsp;&nbsp;&nbsp;" + depart + "<br>");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();
            if(conn!=null)pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
