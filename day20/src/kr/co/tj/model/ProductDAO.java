package kr.co.tj.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sql_selectAll = "select id,name,price,cnt from product";
	final String sql_update = "update product set cnt=cnt-1 where id = ?";
	
	public ArrayList<ProductVO> selectAll(ProductVO vo){
		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO data = new ProductVO();
				data.setId(rs.getInt("id"));
				data.setName(rs.getString("name"));
				data.setPrice(rs.getInt("price"));
				data.setCnt(rs.getInt("cnt"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public boolean update(ProductVO vo) {
		//+) 트랜젝션처리할것!
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, vo.getId());
			int res = pstmt.executeUpdate();
			if(res==0) {
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
