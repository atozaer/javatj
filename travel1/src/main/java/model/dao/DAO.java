package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;
import model.vo.VO;

public class DAO {
   Connection conn;
   PreparedStatement pstmt;
   public boolean insert(VO vo) {
      conn=JDBCUtil.connect();
      try {
         pstmt=conn.prepareStatement("insert into filelist values(?,?)");
         pstmt.setString(1, vo.getFn());
         pstmt.setString(2, vo.getFrn());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
         return false;
      }
      JDBCUtil.disconnect(pstmt, conn);
      return true;
   }
   
   public VO select(VO vo) {
	   conn=JDBCUtil.connect();
	   VO data=null;
	      try {
	         pstmt=conn.prepareStatement("select * from filelist");	         
	         ResultSet rs= pstmt.executeQuery();
	         
	         while(rs.next()) {
	        	 data=new VO();
	        	 data.setFn(rs.getString("fn"));
	        	 data.setFrn(rs.getString("frn"));
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	         
	      }
	      JDBCUtil.disconnect(pstmt, conn);
	      return data;
   }
}