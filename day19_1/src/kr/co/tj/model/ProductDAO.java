package kr.co.tj.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sqlSelectAll = "select pid,pname,price,cnt from product";
	final String sqlSelectOne = "select pid,pname,price,cnt from product where pid=?";
	final String sqlUpdateClient = "update product set cnt=cnt-1 where pid=?";
	final String sqlUpdateAdmin = "update product set cnt=cnt+? where pid=?";
	
	//★★★설계★★★ - > 비즈니스 메서드
	
	public ArrayList<ProductVO> selectAll(ProductVO vo){
		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sqlSelectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO data = new ProductVO();
				data.setCnt(rs.getInt("cnt"));
				data.setPid(rs.getInt("pid"));
				data.setPname(rs.getString("pname"));
				data.setPrice(rs.getInt("price"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	public ProductVO selectOne(ProductVO vo) {
		ProductVO data = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sqlSelectOne);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new ProductVO();
				data.setCnt(rs.getInt("cnt"));
				data.setPid(rs.getInt("pid"));
				data.setPname(rs.getString("pname"));
				data.setPrice(rs.getInt("price"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	public boolean updateClient(ProductVO vo) {
		//+)트랜잭션 처리
			try {
				conn = JDBCUtil.connect();
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sqlUpdateClient);
				pstmt.setInt(1, vo.getPid());
				int res = pstmt.executeUpdate();
				if(res == 0) {
					System.out.println("로그: 해당상품없음!");
					return false;
				}
				pstmt = conn.prepareStatement(sqlSelectOne);
				pstmt.setInt(1, vo.getPid());
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				if(rs.getInt("cnt")<0) {
					System.out.println("로그 : 해당상품 재고없음!");
					conn.rollback();
					return false;
				}
				conn.commit();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
	}
	public boolean updateAdmin(ProductVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sqlUpdateAdmin);
			pstmt.setInt(1, vo.getCnt());
			pstmt.setInt(2, vo.getPid());
			int res = pstmt.executeUpdate();
			if(res==0) {
				System.out.println("로그: 해당상품없음!");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
