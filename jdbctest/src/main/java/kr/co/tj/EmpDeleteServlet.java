package kr.co.tj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "EmpDeleteServlet", value = "/EmpDelete")
public class EmpDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//파라미터 한글 처리 및 얻기
        request.setCharacterEncoding("EUC-KR");
        String emp_id = request.getParameter("emp_id");

        response.setContentType("text/html;charset=EUC-KR");
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


            String sql = "delete from emp where emp_id='"+emp_id+"'";
            pstmt = conn.prepareStatement(sql);
            int n = pstmt.executeUpdate(sql);

            if(n==1){
                out.print("삭제성공");
            }else{
                out.print("삭제실패");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        out.print("</body></html>");
    }

}

