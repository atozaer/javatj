package kr.co.tj.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;

	final String sql_selectOne = "select id,name,point from member where id = ?";
	final String sql_update = "update member set point = point+? where id=?";

	public MemberVO selectOne(MemberVO vo) {// 매개변수 수정을 할 필요가없음
		MemberVO data = null;
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				data = new MemberVO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPoint(rs.getInt("point"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

	public boolean update(MemberVO vo) {
		// vo가 가지고있는 정보는...
		// 1)추가될 포인트
		// 2)현재 로그인한 멤버정보
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, vo.getPoint());
			pstmt.setString(2, vo.getId());
			int res = pstmt.executeUpdate();
			if (res == 0) {
				System.out.println("로그 : 해당데이터없음!");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
