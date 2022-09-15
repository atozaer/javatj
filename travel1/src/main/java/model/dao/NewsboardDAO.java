package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;
import model.vo.NewsboardVO;

public class NewsboardDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	static final String n_selectAll="select * from newsboard order by nnum desc";
	static final String n_insert="insert into newsboard (nnum,ntitle,ncontent,ndate,nphoto) values((select nvl(max(nnum),0)+1 from newsboard),?,?,sysdate,?)";
	static final String n_selectOne="select * from newsboard where nnum=?";
	static final String n_update="update newsboard set ntitle=? and ncontent=? and ndate=? and nphoto=?";
	static final String n_delete="delete from newsboard where nnum=?";
	
	public ArrayList<NewsboardVO> n_selectAll(){
		conn=JDBCUtil.connect();
		ArrayList<NewsboardVO> datas = new ArrayList<NewsboardVO>();
		try {
			pstmt=conn.prepareStatement(n_selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				NewsboardVO data = new NewsboardVO();
				
				data.setNcontent(rs.getString("ncontent"));
				data.setNdate(rs.getString("ndate"));
				data.setNnum(rs.getInt("nnum"));
				data.setNphoto(rs.getString("nphoto"));
				data.setNtitle(rs.getString("ntitle"));
				
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}
	
	public boolean n_insert(NewsboardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(n_insert);
			pstmt.setString(1, vo.getNtitle());
			pstmt.setString(2, vo.getNcontent());
			pstmt.setString(3, vo.getNphoto());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	public NewsboardVO n_selectOne(NewsboardVO vo) {
		NewsboardVO data = null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(n_selectOne);
			pstmt.setInt(1, vo.getNnum());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new NewsboardVO();
				
				data.setNnum(rs.getInt("nnum"));
				data.setNtitle(rs.getString("ntitle"));
				data.setNcontent(rs.getString("ncontent"));
				data.setNphoto(rs.getString("nphoto"));
				data.setNdate(rs.getString("ndate"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return data;
	}
	
	public boolean n_update(NewsboardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(n_update);
			pstmt.setString(1, vo.getNtitle());
			pstmt.setString(2, vo.getNcontent());
			pstmt.setString(3, vo.getNdate());
			pstmt.setString(4, vo.getNphoto());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	public boolean n_delete(NewsboardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(n_delete);
			pstmt.setInt(1, vo.getNnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
}
