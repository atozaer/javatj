package kr.co.tj.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sqlInsert ="insert into board(no,title,content,author,readcount) values((select nvl(max(no),0)+1 from board),?,?,?,?)";
	final String sqlSearchOne="select no,title,content,author,nal,readcount from board where title=?";
	final String sqlSelectAll="select no,title,content,author,nal,readcount from board";
	final String sqlDelete="delete from board where title=?";
	final String sqlUpdate="update board set title=?,content=? where title=?";
	final String sqlReadCount="update board set readcount=readcount+1 where title=?";
	
	public ArrayList<BoardVO> boardAll() {
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		conn =JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sqlSelectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setAuthor(rs.getString("author"));
				vo.setNal(rs.getTimestamp("nal"));
				vo.setReadcount(rs.getInt("readcount"));
				datas.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	public BoardVO boardOne(BoardVO data) {
		conn=JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sqlSearchOne);
			pstmt.setString(1, data.getTitle());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new BoardVO();
				data.setNo(rs.getInt("no"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setAuthor(rs.getString("author"));
				data.setNal(rs.getTimestamp("nal"));
				data.setReadcount(rs.getInt("readcount"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public void boardInsert(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getAuthor());
			pstmt.setInt(4, vo.getReadcount());		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void boardDelete(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setString(1, vo.getTitle());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void boardUpdate(BoardVO vo,String select) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, select);
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
