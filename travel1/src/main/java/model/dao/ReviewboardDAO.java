package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;
import model.vo.CommentsVO;
import model.vo.MemberVO;
import model.vo.ReviewboardSet;
import model.vo.ReviewboardVO;

public class ReviewboardDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	static final String r_selectAll="select * from reviewboard order by rnum desc";
	static final String r_selectAll2="select * from reviewboard where mid=? order by rnum desc";
	static final String r_selectOne="select * from reviewboard where rnum=?";
	static final String r_insert="insert into reviewboard (rnum,rtitle,mid,rcontent,rdate,rfile,raddress) values((select nvl(max(rnum),0)+1 from reviewboard),?,?,?,sysdate,?,?)";
	static final String r_reviewSearch="select * from reviewboard where mid like '%'||?||'%' order by rnum desc"; // 작성자로 검색
	static final String r_placeSearch="select * from reviewboard where rtitle like '%'||?||'%' order by rnum desc"; // 제목으로 검색
	static final String r_delete="delete from reviewboard where rnum=?";
	static final String r_update="update reviewboard set rtitle=?, rcontent=?, rfile=? and raddress=? where rnum=?";
	static final String r_cnt_plus="update reviewboard set rcnt=rcnt+1 where rnum=?";
	static final String r_cnt_minus="update reviewboard set rcnt=rcnt-1 where rnum=?";
	static final String r_insert_comment="insert into comments (cnum,rnum,mid,cdate,ccontent,cthumbsup) values ((select nvl(max(cnum),0)+1 from comments),?,?,sysdate,?,?)";
	static final String r_selectAll_comments="select * from comments where rnum =? order by cnum desc";
	static final String r_delete_comment="delete from comments where cnum=?";
	static final String r_update_comment="update comments set ccontent=? where cnum=?";
	static final String r_rfileselectOne="select rfile from reviewboard where rnum=?";	
	static final String r_rthumbsupUpdate="update reviewboard set rthumbsup=? where rnum=?";
	
	
	public ArrayList<ReviewboardSet> r_selectAll(ReviewboardVO vo) {
		ArrayList<ReviewboardSet> datas = new ArrayList<ReviewboardSet>();
		conn=JDBCUtil.connect();
		try {
			
			if(vo.getMid()==null || vo.getMid().equals("")){ // 기존 비즈니스메서드에 분기점 추가
				// if(vo.getMid().equals("") || vo.getMid()==null){ 이렇게 쓰면 null일 때 equals를 못해서 오류가 뜸.
				System.out.println("로그: 글 목록 보기");
				pstmt=conn.prepareStatement(r_selectAll);
			}else {
				System.out.println("로그: 특정인이 작성한 글 보기");
				pstmt=conn.prepareStatement(r_selectAll2);
				pstmt.setString(1, vo.getMid());
				
			}
			ResultSet rs = pstmt.executeQuery();
			float avg = 0;
			while(rs.next()) {
				ReviewboardSet reviewboardSet = new ReviewboardSet();
				ReviewboardVO reviewboardVO = new ReviewboardVO();
				
				reviewboardVO.setRnum(rs.getInt("rnum"));
				reviewboardVO.setRtitle(rs.getString("rtitle"));
				reviewboardVO.setMid(rs.getString("mid"));
				reviewboardVO.setRcontent(rs.getString("rcontent"));
				reviewboardVO.setRdate(rs.getString("rdate"));
				reviewboardVO.setRfile(rs.getString("rfile"));
				reviewboardVO.setRview(rs.getInt("rview"));
				reviewboardVO.setRcnt(rs.getInt("rcnt"));
				reviewboardVO.setRaddress(rs.getString("raddress"));
							
				
				pstmt=conn.prepareStatement(r_selectAll_comments);
				pstmt.setInt(1, rs.getInt("rnum"));
				ResultSet rs2 = pstmt.executeQuery();
				while(rs2.next()) {
					avg+=rs2.getFloat("cthumbsup");
				}
				rs2.close();
				
				if(rs.getInt("rcnt")!=0) {
					avg /= rs.getInt("rcnt");
				}else {
					avg=0;
				}
				
//				pstmt=conn.prepareStatement(r_rthumbsupUpdate);
				
				
				reviewboardVO.setRthumbsup(avg);
				reviewboardSet.setReviewboardVO(reviewboardVO);
				
				datas.add(reviewboardSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}
	
	public ReviewboardVO r_rfileselectOne(ReviewboardVO vo) {
		ReviewboardVO data = null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(r_rfileselectOne);
			pstmt.setInt(1,vo.getRnum());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new ReviewboardVO();
				data.setRfile(rs.getString("rfile"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return data;
	}
	
	
	public ArrayList<ReviewboardSet> r_selectOne(ReviewboardVO vo) {
		ArrayList<ReviewboardSet> datas = new ArrayList<ReviewboardSet>();		
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(r_selectOne);
			pstmt.setInt(1, vo.getRnum());
			ResultSet rs = pstmt.executeQuery();
			float avg=0;
			if(rs.next()) {
				ReviewboardSet reviewboardSet = new ReviewboardSet();
				ReviewboardVO reviewboardVO = new ReviewboardVO();
				
				reviewboardVO.setRnum(rs.getInt("rnum"));
				reviewboardVO.setRtitle(rs.getString("rtitle"));
				reviewboardVO.setMid(rs.getString("mid"));
				reviewboardVO.setRcontent(rs.getString("rcontent"));
				reviewboardVO.setRdate(rs.getString("rdate"));
				reviewboardVO.setRfile(rs.getString("rfile"));
				reviewboardVO.setRview(rs.getInt("rview"));
				reviewboardVO.setRcnt(rs.getInt("rcnt"));
				reviewboardVO.setRaddress(rs.getString("raddress"));
				
				
				
				ArrayList<CommentsVO> comments = new ArrayList<CommentsVO>();
				pstmt=conn.prepareStatement(r_selectAll_comments);
				pstmt.setInt(1, rs.getInt("rnum"));
				ResultSet rs2 = pstmt.executeQuery();
				while(rs2.next()) {
					CommentsVO commentsVO = new CommentsVO();
					
					
					commentsVO.setRnum(rs2.getInt("rnum"));
					commentsVO.setCnum(rs2.getInt("cnum"));
					commentsVO.setCdate(rs2.getString("cdate"));
					commentsVO.setCcontent(rs2.getString("ccontent"));
					commentsVO.setCthumbsup(rs2.getFloat("cthumbsup"));
					commentsVO.setMid(rs2.getString("mid"));
					
					avg+=rs2.getFloat("cthumbsup");
					
					comments.add(commentsVO);
				}
				rs2.close();
				
				if(rs.getInt("rcnt")!=0) {
					avg /= rs.getInt("rcnt");
				}else {
					avg=0;
				}
				reviewboardVO.setRthumbsup(avg);				
				reviewboardSet.setReviewboardVO(reviewboardVO);
				reviewboardSet.setComments(comments);
				datas.add(reviewboardSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}
	
	public boolean r_insert(ReviewboardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(r_insert);
			pstmt.setString(1, vo.getRtitle());
			pstmt.setString(2, vo.getMid());
			pstmt.setString(3, vo.getRcontent());			
			pstmt.setString(4, vo.getRfile());
			pstmt.setString(5, vo.getRaddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	public boolean r_insert_comment(CommentsVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(r_insert_comment);
			pstmt.setInt(1, vo.getRnum());
			pstmt.setString(2, vo.getMid());			
			pstmt.setString(3, vo.getCcontent());
			pstmt.setFloat(4, vo.getCthumbsup());
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement(r_cnt_plus);
			pstmt.setInt(1, vo.getRnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	public ArrayList<ReviewboardVO> r_reviewSearch(ReviewboardVO vo) {
		ArrayList<ReviewboardVO> datas = new ArrayList<ReviewboardVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(r_reviewSearch);
			pstmt.setString(1, vo.getMid());
			ResultSet rs = pstmt.executeQuery();
			float avg = 0;
			while(rs.next()) {
				ReviewboardVO data = new ReviewboardVO();
				
				data.setRnum(rs.getInt("rnum"));
				data.setRtitle(rs.getString("rtitle"));
				data.setMid(rs.getString("mid"));
				data.setRcontent(rs.getString("rcontent"));
				data.setRdate(rs.getString("rdate"));
				data.setRfile(rs.getString("rfile"));
				data.setRview(rs.getInt("rview"));
				data.setRcnt(rs.getInt("rcnt"));
				data.setRaddress(rs.getString("raddress"));
				
				pstmt=conn.prepareStatement(r_selectAll_comments);
				pstmt.setInt(1, rs.getInt("rnum"));
				ResultSet rs2 = pstmt.executeQuery();
				while(rs2.next()) {
					avg+=rs2.getFloat("cthumbsup");
				}
				rs2.close();
				if(rs.getInt("rcnt")!=0) {
					avg /= rs.getInt("rcnt");
				}else {
					avg=0;
				}
				data.setRthumbsup(avg);
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}
	
	public ArrayList<ReviewboardVO> r_placeSearch(ReviewboardVO vo) {
		ArrayList<ReviewboardVO> datas = new ArrayList<ReviewboardVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(r_placeSearch);
			pstmt.setString(1, vo.getRtitle());
			ResultSet rs = pstmt.executeQuery();
			float avg = 0;
			while(rs.next()) {
				ReviewboardVO data = new ReviewboardVO();
				
				data.setRnum(rs.getInt("rnum"));
				data.setRtitle(rs.getString("rtitle"));
				data.setMid(rs.getString("mid"));
				data.setRcontent(rs.getString("rcontent"));
				data.setRdate(rs.getString("rdate"));
				data.setRfile(rs.getString("rfile"));
				data.setRview(rs.getInt("rview"));
				data.setRcnt(rs.getInt("rcnt"));
				data.setRaddress(rs.getString("raddress"));
				
				pstmt=conn.prepareStatement(r_selectAll_comments);
				pstmt.setInt(1, rs.getInt("rnum"));
				ResultSet rs2 = pstmt.executeQuery();
				while(rs2.next()) {
					avg+=rs2.getFloat("cthumbsup");
				}
				rs2.close();
				if(rs.getInt("rcnt")!=0) {
					avg /= rs.getInt("rcnt");
				}else {
					avg=0;
				}
				data.setRthumbsup(avg);
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}
	
	public boolean r_delete(ReviewboardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(r_delete);
			pstmt.setInt(1, vo.getRnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	public boolean r_delete_comments(CommentsVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(r_delete_comment);
			pstmt.setInt(1, vo.getCnum());
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement(r_cnt_minus);
			pstmt.setInt(1, vo.getRnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	public boolean r_update(ReviewboardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(r_update);
			pstmt.setString(1, vo.getRtitle());
			pstmt.setString(2, vo.getRcontent());
			pstmt.setString(3, vo.getRfile());
			pstmt.setString(4, vo.getRaddress());
			pstmt.setInt(5, vo.getRnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	public boolean r_update_comment(CommentsVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(r_update_comment);
			pstmt.setString(1, vo.getCcontent());
			pstmt.setInt(2, vo.getCnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
}
