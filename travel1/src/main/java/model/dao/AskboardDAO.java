package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;
import model.vo.AskboardSet;
import model.vo.AskboardVO;
import model.vo.AskcommentVO;

public class AskboardDAO {
   Connection conn;
   PreparedStatement pstmt;
   
   static final String a_selectAll="select * from askboard order by anum desc";
   static final String a_selectAll_comments="select * from askcomment where anum=?";
   static final String a_insert="insert into askboard (anum,mid,atitle,acontent,adate,afile) values((select nvl(max(anum),0)+1 from askboard),?,?,?,sysdate,?)";
   static final String a_insert_reply="insert into askcomment (acnum,anum,mid,acdate,accontent) values((select nvl(max(acnum),0)+1 from askcomment),?,?,sysdate,?)";
   static final String a_delete="delete from askboard where anum=?";
   static final String a_selectOne="select * from askboard where anum=?";
   static final String a_update="update askboard set atitle=?, acontent=? where anum=?";
   static final String query = "select * from board where  num = ?";
   
   public ArrayList<AskboardSet> a_selectAll(){
      ArrayList<AskboardSet> datas = new ArrayList<AskboardSet>();
      conn=JDBCUtil.connect();
      try {
         pstmt = conn.prepareStatement(a_selectAll);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            AskboardSet askboardSet = new AskboardSet();
            AskboardVO askboardVO = new AskboardVO();
            
            askboardVO.setMid(rs.getString("mid"));
            askboardVO.setAnum(rs.getInt("anum"));
            askboardVO.setAtitle(rs.getString("atitle"));
            askboardVO.setAcontent(rs.getString("acontent"));
            askboardVO.setAdate(rs.getString("adate"));
            askboardVO.setAfile(rs.getString("afile"));
            askboardVO.setAview(rs.getInt("aview"));
            
            askboardSet.setAskboardVO(askboardVO);
            
            ArrayList<AskcommentVO> askcomment = new ArrayList<AskcommentVO>();
            pstmt = conn.prepareStatement(a_selectAll_comments);
            pstmt.setInt(1, rs.getInt("anum"));
            ResultSet rs2 = pstmt.executeQuery();
            while(rs2.next()) {
               AskcommentVO askcommentVO = new AskcommentVO();
               
               askcommentVO.setMid(rs.getString("mid"));
               askcommentVO.setAnum(rs2.getInt("anum"));
               askcommentVO.setAcnum(rs2.getInt("acnum"));
               askcommentVO.setAcdate(rs2.getString("acdate"));
               askcommentVO.setAccontent(rs2.getString("accontent"));
               
               askcomment.add(askcommentVO);
            }
            rs2.close();
            askboardSet.setComments(askcomment);
            datas.add(askboardSet);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      JDBCUtil.disconnect(pstmt, conn);
      return datas;
   }
   
   public boolean a_insert(AskboardVO vo) {
      conn=JDBCUtil.connect();
      try {
         pstmt=conn.prepareStatement(a_insert);
         pstmt.setString(1, vo.getMid());
         pstmt.setString(2, vo.getAtitle());
         pstmt.setString(3, vo.getAcontent());
         pstmt.setString(4, vo.getAfile());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         return false;
      }
      JDBCUtil.disconnect(pstmt, conn);
      return true;
   }
   
   public boolean a_insert_reply(AskcommentVO vo) {
      conn=JDBCUtil.connect();
      try {
         pstmt=conn.prepareStatement(a_insert_reply);
         pstmt.setInt(1, vo.getAnum());
         pstmt.setString(2, vo.getMid());
         pstmt.setString(3, vo.getAccontent());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      JDBCUtil.disconnect(pstmt, conn);
      return true;
   }
   
   public boolean a_delete(AskboardVO vo) {
      conn=JDBCUtil.connect();
      try {
         pstmt=conn.prepareStatement(a_delete);
         pstmt.setInt(1, vo.getAnum());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         return false;
      }
      JDBCUtil.disconnect(pstmt, conn);
      return true;
   }
   
   public ArrayList<AskboardSet> a_selectOne(AskboardVO vo) {
      
      ArrayList<AskboardSet> datas = new ArrayList<AskboardSet>();
      conn=JDBCUtil.connect();
      
      try {
         pstmt = conn.prepareStatement(a_selectOne);
         pstmt.setInt(1, vo.getAnum());
         ResultSet rs = pstmt.executeQuery();
         if(rs.next()) {
            AskboardSet askboardSet =new AskboardSet();
            AskboardVO askboardVO=new AskboardVO();
            
            
            askboardVO.setAnum(rs.getInt("anum"));
            askboardVO.setMid(rs.getString("mid"));
            askboardVO.setAtitle(rs.getString("atitle"));
            askboardVO.setAcontent(rs.getString("acontent"));
            askboardVO.setAdate(rs.getString("adate"));
            askboardVO.setAfile(rs.getString("afile"));
            askboardVO.setAview(rs.getInt("aview"));
            
            askboardSet.setAskboardVO(askboardVO);
            
            ArrayList<AskcommentVO> askcomment = new ArrayList<AskcommentVO>();
            pstmt = conn.prepareStatement(a_selectAll_comments);
            pstmt.setInt(1, rs.getInt("anum"));
            ResultSet rs2 = pstmt.executeQuery();
            while(rs2.next()) {
               AskcommentVO askcommentVO = new AskcommentVO();
               
               askcommentVO.setMid(rs2.getString("mid"));
               askcommentVO.setAnum(rs2.getInt("anum"));
               askcommentVO.setAcnum(rs2.getInt("acnum"));
               askcommentVO.setAcdate(rs2.getString("acdate"));
               askcommentVO.setAccontent(rs2.getString("accontent"));
               
               askcomment.add(askcommentVO);
            }
            rs2.close();
            askboardSet.setComments(askcomment);
            datas.add(askboardSet);
            
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      JDBCUtil.disconnect(pstmt, conn);
      return datas;
   }
   
   public boolean a_update(AskboardVO vo) {
      conn=JDBCUtil.connect();
      try {
         pstmt=conn.prepareStatement(a_update);
         pstmt.setString(1, vo.getAtitle());
         pstmt.setString(2, vo.getAcontent());
         pstmt.setInt(3, vo.getAnum());
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