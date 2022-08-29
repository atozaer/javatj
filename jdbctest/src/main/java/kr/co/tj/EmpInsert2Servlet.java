package kr.co.tj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "EmpInsert2Servlet", value = "/EmpInsert2")
public class EmpInsert2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String emp_id=request.getParameter("emp_id");
        String ename = request.getParameter("ename");
        String salary = request.getParameter("salary");
        String depart = request.getParameter("depart");
        int salary1 = Integer.parseInt(salary);

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
            String sql = "insert into emp(emp_id,ename,salary,depart) values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,emp_id);
            pstmt.setString(2,ename);
            pstmt.setInt(3,salary1);
            pstmt.setString(4,depart);
            int cnt=pstmt.executeUpdate();
            if(cnt==1){
                out.print("저장성공");
            }else{
                out.print("저장실패");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
