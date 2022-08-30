package kr.co.tj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "EmpUpdateServlet", value = "/EmpUpdateServlet")
public class EmpUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //파라미터 한글 처리 및 얻기
        request.setCharacterEncoding("UTF-8");
        String emp_id = request.getParameter("emp_id");
        String ename = request.getParameter("ename");
        String salary = request.getParameter("salary");
        String depart = request.getParameter("depart");
        int salaryUpdate = Integer.parseInt(salary);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3356/tj?characterEncoding=utf8";
        String userid = "root";
        String passwd = "love1004";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userid, passwd);
            String sql = "update emp set ename=?,salary=?,depart=? where emp_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ename);
            pstmt.setInt(2, salaryUpdate);
            pstmt.setString(3, depart);
            pstmt.setString(4, emp_id);
            System.out.println(
                    String.format("%s %d %s %s", ename, salaryUpdate, depart, emp_id)
            );
            int cnt = pstmt.executeUpdate();

            if(cnt==1){
                out.print("수정성공");
            }else {
                out.print("수정실패");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        out.print("</body></html>");
    }
}
