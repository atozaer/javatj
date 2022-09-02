package kr.co.tj.member;

import kr.co.tj.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    Connection conn;
    PreparedStatement pstmt;

    static final String insert = "insert into member values(?,?,?)";
    static final String update = "update member set mpw=? where mid=?";
    static final String delete = "delete from member where mid=?";
    static final String selectOne = "select mid,mpw,mname from member where mid=?";

    public boolean insert(MemberVO vo) {
        conn = JDBCUtil.connect();

        try {
            pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, vo.getMid());
            pstmt.setString(2, vo.getMpw());
            pstmt.setString(3, vo.getMname());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JDBCUtil.disconnect(pstmt, conn);
        return true;
    }

    public boolean update(MemberVO vo) {
        conn = JDBCUtil.connect();

        try {
            pstmt = conn.prepareStatement(update);
            pstmt.setString(1, vo.getMpw());
            pstmt.setString(2, vo.getMid());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JDBCUtil.disconnect(pstmt, conn);
        return true;
    }

    public boolean delete(MemberVO vo) {
        conn = JDBCUtil.connect();

        try {
            pstmt = conn.prepareStatement(delete);
            pstmt.setString(1, vo.getMid());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JDBCUtil.disconnect(pstmt, conn);
        return true;
    }

    public MemberVO selectOne(MemberVO vo) {
        MemberVO data = null;
        conn = JDBCUtil.connect();

        try {
            pstmt = conn.prepareStatement(selectOne);
            pstmt.setString(1, vo.getMid());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("로그 : 아이디 존재");
                if (rs.getString("mpw").equals(vo.getMpw())) {
                    System.out.println("로그 : 비밀번호 일치");
                    data = new MemberVO();
                    data.setMid(rs.getString("mid"));
                    data.setMpw(rs.getString("mpw"));
                    data.setMname(rs.getString("mname"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JDBCUtil.disconnect(pstmt, conn);
        return data;
    }

}
