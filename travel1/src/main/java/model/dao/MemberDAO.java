package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;
import model.vo.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	static final String m_insert="insert into member (mid,mpw,mname,mbirth,mphone,mgender,mmail,mregdate) values(?,?,?,?,?,?,?,sysdate)";
	static final String m_selectAll="select * from member";	
	static final String m_selectOne="select * from member where mid=? and mpw=?";
	static final String m_idSearch="select mid from member where mname=? and mmail=?";
	static final String m_pwSearch="select mpw from member where mid=? and mname=? and mmail=?";
	static final String m_update="update member set mpw=?, mname=?, mphoto=?, mbirth=?, mphone=?, mgender=?, mmail=? where mid=?";
	static final String m_idCheck="select mid from member where mid=?";
	static final String m_mphotoselectOne="select mphoto from member where mid=?";
	static final String m_mphotoUpdate="update member set mphoto=? where mid=?";
	static final String m_delete="delete from member where mid=?";
	
	
	public boolean m_insert(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(m_insert);
			pstmt.setString(1,vo.getMid());
			pstmt.setString(2,vo.getMpw());
			pstmt.setString(3,vo.getMname());
			pstmt.setString(4,vo.getMbirth());
			pstmt.setString(5,vo.getMphone());
			pstmt.setString(6,vo.getMgender());
			pstmt.setString(7,vo.getMmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	public ArrayList<MemberVO> m_selectAll(){
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(m_selectAll);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data = new MemberVO();
				
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setMbirth(rs.getString("mbirth"));
				data.setMphone(rs.getString("mphone"));
				data.setMgender(rs.getString("mgender"));
				data.setMmail(rs.getString("mmail"));
				data.setMregdate(rs.getString("mregdate"));
				data.setMlastaccessdate(rs.getString("mlastaccessdate"));
				data.setMphoto(rs.getString("mphoto"));
				
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}
	
	public MemberVO m_selectOne(MemberVO vo) {
		MemberVO data = null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(m_selectOne);
			pstmt.setString(1,vo.getMid());
			pstmt.setString(2,vo.getMpw());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setMphoto(rs.getString("mphoto"));
				data.setMbirth(rs.getString("mbirth"));
				data.setMphone(rs.getString("mphone"));
				data.setMgender(rs.getString("mgender"));
				data.setMmail(rs.getString("mmail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return data;
	}
	
	public MemberVO m_mphotoselectOne(MemberVO vo) {
		MemberVO data = null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(m_mphotoselectOne);
			pstmt.setString(1,vo.getMid());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				data.setMphoto(rs.getString("mphoto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return data;
	}
	
	
	public MemberVO m_idCheck(MemberVO vo) {
		conn=JDBCUtil.connect();
		MemberVO data = new MemberVO();
		try {
			pstmt=conn.prepareStatement(m_idCheck);
			pstmt.setString(1,vo.getMid());			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data.setMid(rs.getString("mid"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return data;
	}
	public int m_checkId(String id) {
		conn=JDBCUtil.connect();
		int check = 0;
		try {
			pstmt=conn.prepareStatement(m_idCheck);
			pstmt.setString(1,id);			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next() || id.equals("")) { // 불가
				check = 0;
			} else { // 가능
				check = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return check;
	}
	public MemberVO m_idSearch(MemberVO vo) {
		MemberVO data = null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(m_idSearch);
			pstmt.setString(1,vo.getMname());
			pstmt.setString(2, vo.getMmail());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				
				data.setMid(rs.getString("mid"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return data;
	}
	
	public MemberVO m_pwSearch(MemberVO vo) {
		MemberVO data = new MemberVO();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(m_pwSearch);
			pstmt.setString(1,vo.getMid());
			pstmt.setString(2,vo.getMname());
			pstmt.setString(3, vo.getMmail());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				
				data.setMpw(rs.getString("mpw"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return data;
	}
	
	public boolean m_update(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(m_update);
			pstmt.setString(1,vo.getMpw());
			pstmt.setString(2,vo.getMname());
			pstmt.setString(3,vo.getMphoto());
			pstmt.setString(4,vo.getMbirth());
			pstmt.setString(5,vo.getMphone());
			pstmt.setString(6,vo.getMgender());
			pstmt.setString(7,vo.getMmail());
			pstmt.setString(8,vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	public boolean m_mphotoUpdate(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(m_mphotoUpdate);
			pstmt.setString(1,vo.getMphoto());
			pstmt.setString(2,vo.getMid());			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	public boolean m_delete(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(m_delete);
			pstmt.setString(1,vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
}
