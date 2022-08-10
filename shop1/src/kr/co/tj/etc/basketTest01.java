package kr.co.tj.etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

class ProductVO{
	private int pnum;
	private String pname;
	private int pstock;
	private int price;
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPstock() {
		return pstock;
	}
	public void setPstock(int pstock) {
		this.pstock = pstock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductVO [pnum=" + pnum + ", pname=" + pname + ", pstock=" + pstock + ", price=" + price + "]";
	}		
}

public class basketTest01 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection conn=null;
		PreparedStatement pstmt=null;
		ArrayList<ProductVO> basket = new ArrayList<ProductVO>();
		ProductVO p0_vo = new ProductVO(); // 제품리스트 출력용
		ProductVO p_vo;					   // 장바구니 추가작업용(이거 사용하세요)
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "shop1"; // 각자 오라클 계정 ID 작성
		String pw = "0000";  // 각자 오라클 계정 PW 작성
				
		// 제품리스트 츨력
		String sql = "select pnum,pname,pstock,price from product";
		try {
			conn = DriverManager.getConnection(url,id,pw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				p0_vo.setPnum(rs.getInt("pnum"));
				p0_vo.setPname(rs.getString("pname"));
				p0_vo.setPstock(rs.getInt("pstock"));
				p0_vo.setPrice(rs.getInt("price"));
				
				System.out.println(p0_vo);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//==== 윗 부분은 id,pw외에는 수정하지 말고 그대로 이용
		
		// 제품검색
		sql = "select pnum,pname,pstock,price from product where pnum=?";				
		
		while(true) {
			System.out.print("제품번호 입력 : ");
			p0_vo.setPnum(scan.nextInt());
			if (p0_vo.getPnum() < 0) break; // 음수 입력시 종료
			
			try {		
				conn = DriverManager.getConnection(url,id,pw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, p0_vo.getPnum());
				rs = pstmt.executeQuery();				
				// 윗부분은 손댈 필요 없음!
				//==== 장바구니 추가 작업 =======================================
				// 60,61라인의 id, pw 설정 후 이용
				// 제품번호에 음수 입력시 종료됨
				// p_vo 사용하여 장바구니추가 작업
				// 장바구니 : basket
				// 54라인 : ArrayList<ProductVO> basket = new ArrayList<ProductVO>();
				
				p_vo = new ProductVO();
				if (rs.next()) {
					p_vo.setPnum(rs.getInt("pnum"));
					p_vo.setPname(rs.getString("pname"));
					p_vo.setPstock(rs.getInt("pstock"));
					p_vo.setPrice(rs.getInt("price"));
				}
				
				
			
				
				
				
				
				
				
				// 아래는 손댈 필요 없음!
				// 장바구니 목록 확인 ===========================================
				for (ProductVO vo:basket) {
					System.out.println(vo);
				}
			 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}
		
		
		
		
		
		
		
				
	}

}
