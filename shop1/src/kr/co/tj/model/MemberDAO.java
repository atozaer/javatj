package kr.co.tj.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
			
	final String m_selectAllSql = "select id,name,addr,tel,birth,point,money from member";
	final String m_selectOneSql = "select id,passwd,name,addr,tel,birth,point,money from member where id=?";
	final String m_updateAllSql = "update member set id=?,passwd=?,name=?,addr=?,tel=?,birth=? where id=?";
	final String m_deleteOneSql = "delete from member where id=?";
	final String m_insertSql = "insert into member(id,passwd,name,addr,tel,birth) values(?,?,?,?,?,?)";
	final String m_idSearchSql = "select id from member where name=? and birth=?";
	
	final String m_moneySelectSql = "select money from member where id = ? ";
	final String m_moneyUpdateSql = "update member set money=money+? where id = ?";

	final String m_pointSelectSql = "select point from member where id = ? ";
	final String m_pointUpdateSql = "update member set point=point+? where id=?";
	
	// 로그인
	public MemberVO memberSearch(String id) { // 파라미터를 String으로 변경
		MemberVO m_vo = new MemberVO();
		ResultSet rs = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(m_selectOneSql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				m_vo.setId(id);
				m_vo.setPasswd(rs.getString("passwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return m_vo; // null = 해당id 없음		
	}
	
	// 아이디 찾기
	public MemberVO memberIdSearch(MemberVO m_vo) {
		MemberVO vo = new MemberVO();
		ResultSet rs = null;
				
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(m_idSearchSql);
			pstmt.setString(1,m_vo.getName());
			pstmt.setInt(2, m_vo.getBirth());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo.setId(rs.getString("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return vo;
	}
		
	// 회원가입
	public boolean memberInsert(MemberVO m_vo) {
		boolean res = false;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(m_insertSql);
			
			// id,passwd,name,addr,tel,birth
			pstmt.setString(1, m_vo.getId());
			pstmt.setString(2, m_vo.getPasswd());
			pstmt.setString(3, m_vo.getName());
			pstmt.setString(4, m_vo.getAddr());
			pstmt.setString(5, m_vo.getTel());
			pstmt.setInt(6, m_vo.getBirth());
						
			if (pstmt.executeUpdate() != 0) {
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return res;		
	}
	
	// 회원정보 조회
	public MemberVO memberSelectOne(String id){// 파라미터를 String으로 변경
		MemberVO m_vo = new MemberVO();
		ResultSet rs = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(m_selectOneSql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			// id,passwd,name,addr,tel,birth,point,money
			if (rs.next()) {
				m_vo.setId(id);
				m_vo.setPasswd(rs.getString("passwd"));
				m_vo.setName(rs.getString("name"));
				m_vo.setAddr(rs.getString("addr"));
				m_vo.setTel(rs.getString("tel"));
				m_vo.setBirth(rs.getInt("birth"));
				m_vo.setPoint(rs.getInt("point"));
				m_vo.setMoney(rs.getInt("money"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return m_vo; // null = 해당id 없음	
	}
	
	// 회원목록 조회
	public ArrayList<MemberVO> memberSelectAll(){
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		ResultSet rs = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(m_selectAllSql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVO m_vo = new MemberVO();
				m_vo.setId(rs.getString("id"));
				m_vo.setName(rs.getString("name"));
				m_vo.setAddr(rs.getString("addr"));
				m_vo.setTel(rs.getString("tel"));
				m_vo.setBirth(rs.getInt("birth"));
				m_vo.setPoint(rs.getInt("point"));
				m_vo.setMoney(rs.getInt("money"));
				
				datas.add(m_vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return datas;
	}
	
	// 회원 삭제
	public boolean memberDelete(String id) { // 파라미터 String으로 변경
		boolean res = false;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(m_deleteOneSql);
			pstmt.setString(1,id);
			
			if (pstmt.executeUpdate() != 0) {
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return res;
	}
	
	// 쇼핑머니 충전,사용(구매)
	public boolean memberMoneyUpdate(MemberVO m_vo) { // 충전,구매 모두 사용하므로 메서드명 변경
		boolean res = false;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(m_moneyUpdateSql);
			pstmt.setInt(1, m_vo.getMoney());
			pstmt.setString(2, m_vo.getId());
			
			if(pstmt.executeUpdate() != 0) {
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return res;
	}
	
	// 쇼핑머니 조회
	public int memberMoneyCheck(String id) {
		ResultSet rs = null;
		int money = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(m_moneySelectSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				money = rs.getInt("money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return money;
	}
	
	// 포인트 업데이트 : 적립,사용
	public boolean memberPointUpdate(MemberVO m_vo) {
		boolean res = false;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(m_pointUpdateSql);
			pstmt.setInt(1, m_vo.getPoint());
			pstmt.setString(2, m_vo.getId());			
			if (pstmt.executeUpdate() != 0) {
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return res;		
	}
	
	// 포인트 조회
	public int memberPointCheck(String id) {
		ResultSet rs = null;
		int point = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(m_pointSelectSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				point = rs.getInt("point");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return point;	
	}	
	
}
