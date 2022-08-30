package kr.co.tj.dao;

import kr.co.tj.domain.EmpVO;

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

    public int insert(EmpVO vo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt=0;

        try {
            conn = DriverManager.getConnection(url, userid, passwd);
            String sql = "insert into emp(emp_id,ename,salary,depart) values (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getEmp_id());
            pstmt.setString(2, vo.getEname());
            pstmt.setInt(3, vo.getSalary());
            pstmt.setString(4, vo.getDepart());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return cnt;
    }

    public EmpVO search(EmpVO vo){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, userid, passwd);
            String sql = "select emp_id,ename,salary,depart from emp where emp_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getEmp_id());
            rs = pstmt.executeQuery();
            if(rs.next()){
                vo.setEmp_id(rs.getString("emp_id"));
                vo.setEname(rs.getString("ename"));
                vo.setSalary(rs.getInt("salary"));
                vo.setDepart(rs.getString("depart"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
                pstmt.close();
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return vo;
    }

    public int delete(EmpVO vo){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt=0;

        try {
            conn = DriverManager.getConnection(url, userid, passwd);
            String sql = "Delete from emp where emp_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getEmp_id());
            cnt = pstmt.executeUpdate();
            if(cnt==0){
                System.out.println("삭제실패");
            }else {
                System.out.println("삭제성공");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return cnt;
    }

    public int update(EmpVO vo){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt=0;

        try {
            conn = DriverManager.getConnection(url, userid, passwd);
            String sql = "update emp set ename=?,salary=?,depart=? where emp_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getEname());
            pstmt.setInt(2, vo.getSalary());
            pstmt.setString(3, vo.getDepart());
            pstmt.setString(4, vo.getEmp_id());
            cnt = pstmt.executeUpdate();
            if(cnt==0){
                System.out.println("수정실패");
            }else {
                System.out.println("수정성공");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return cnt;
    }

}

