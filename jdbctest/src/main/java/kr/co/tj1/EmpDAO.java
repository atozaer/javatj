package kr.co.tj1;

import java.sql.*;
import java.util.ArrayList;

public class EmpDAO {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/tj?characterEncoding=utf8";
    String userid = "root";
    String passwd = "1234";

    public EmpDAO() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<EmpVO> select() {
        ArrayList<EmpVO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, userid, passwd);
            String sql = "select emp_id,ename,salary,depart from emp";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String emp_id = rs.getString("emp_id");
                String ename = rs.getString("ename");
                int salary = rs.getInt("salary");
                String depart = rs.getString("depart");

                EmpVO vo = new EmpVO(emp_id, ename, salary, depart);
                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public ArrayList<EmpVO> update() {
        ArrayList<EmpVO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, userid, passwd);
            String sql = "update emp set ename=?,salary=?,depart=? where emp_id=?";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            String ename = pstmt.setString(1, ename);
            int salary = pstmt.setInt(2, salary);
            String depart = pstmt.setString(3, depart);
            String emp_id = pstmt.setString(4, emp_id);
            System.out.println(
                    String.format("%s %d %s %s", ename, salary, depart, emp_id)
            );
            int cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;
    }

}
