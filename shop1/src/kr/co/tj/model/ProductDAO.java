package kr.co.tj.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;

	// pnum,pname,pstock,price,pinfo(null)
	final String p_selectAllSql = "select pnum,pname,pstock,price,pinfo from product";
	final String p_selectOneSql = "select pnum,pname,pstock,price,pinfo from product where pnum=?";
	final String p_updateAllSql = "update product set pname=?, pstock=?, price=?, pinfo=? where pnum=?";
	final String p_deleteAllSql = "delete from product where pnum=?";
	final String p_insertSql = "insert into product(pnum,pname,pstock,price,pinfo) "
			+ "values((select nvl(max(pnum),0)+1 from product),?,?,?,?)";
	final String p_stockAddSql = "update product set pstock=pstock+? where pnum=?";
	final String p_stockCheckSql = "select pstock from product";
	final String p_basketPurchaseSql = "update product set pstock=pstock-? where pnum=?";
	final String p_basketAddSql = "select pnum,pname,price from product";

	// 상품목록 조회
	public ArrayList<ProductVO> productList() {// 파라미터 제거
		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();

		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(p_selectAllSql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO data = new ProductVO();
				data.setPnum(rs.getInt("pnum"));
				data.setPname(rs.getString("pname"));
				data.setPstock(rs.getInt("pstock"));
				data.setPrice(rs.getInt("price"));
				data.setPinfo(rs.getString("pinfo"));

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

	// 장바구니에 상품 추가
	public ArrayList<ProductVO> basketAdd(ArrayList<ProductVO> basket, int pnum, int pstock) {
		ArrayList<Integer> itemNum = new ArrayList<Integer>();
		ResultSet rs = null;
		int num = 0;

		for (ProductVO data : basket) {
			itemNum.add(data.getPnum());
		}

		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(p_selectOneSql);
			pstmt.setInt(1, pnum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ProductVO p_vo = new ProductVO();
				p_vo.setPnum(pnum);
				p_vo.setPname(rs.getString("pname"));
				p_vo.setPrice(rs.getInt("price"));
				p_vo.setPinfo(rs.getString("pinfo"));

				if (itemNum.contains(pnum)) {
					num = itemNum.indexOf(pnum);
					p_vo.setPstock(basket.get(num).getPstock() + pstock);
					basket.set(num, p_vo);
				} else {
					p_vo.setPstock(pstock);
					basket.add(p_vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return basket;
	}

	// 장바구니 수량 변경
		public int basketUpdate(ArrayList<ProductVO> basket, ProductVO p0_vo) {
			// 수량변경하려면 장바구니와 해당상품을 불러와야 하므로 파라미터에 ArrayList,pnum 추가
			ArrayList<Integer> basketNum = new ArrayList<Integer>();		
			ProductVO p_vo = new ProductVO();
			ResultSet rs = null;
			int res = 0; // 1=성공, 2=장바구니에 없는 상품번호, 3=재고수량 부족
			int num = 0;
			int buyQuantity = p0_vo.getPstock(); // 구매변경 수량
							
			for (ProductVO data : basket) {		 // 장바구니 출력 
				basketNum.add(data.getPnum());
			}
			if (basketNum.contains(p0_vo.getPnum())) { // 장바구니에 있는지?
				System.out.println();
				// 재고 수량 확인
				conn = JDBCUtil.connect();
				try {
					pstmt = conn.prepareStatement(p_selectOneSql);
					pstmt.setInt(1, p0_vo.getPnum());
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						p0_vo.setPstock(rs.getInt("pstock")); // 재고수량
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}		
				
				// 재고수량 < 장바구니 변경수량?
				if (basket.get(num).getPstock() + buyQuantity > p0_vo.getPstock() || basket.get(num).getPstock() + buyQuantity < 0) {
					res = 3; // 장바구니 수량이 재고수량을 초과하거나 음수일때
				} else { // 장바구니 수량 변경
					num = basketNum.indexOf(p0_vo.getPnum());
					if (basket.get(num).getPstock() + buyQuantity == 0) {
						basket.remove(num);
					} else {
						p_vo.setPnum(p0_vo.getPnum());
						p_vo.setPname(basket.get(num).getPname());
						p_vo.setPrice(basket.get(num).getPrice());
						p_vo.setPstock(basket.get(num).getPstock() + buyQuantity);
						p_vo.setPinfo(basket.get(num).getPinfo());
						
						basket.set(num, p_vo);
						res = 1;
					}
				}
				
			} else {
				res = 2; // 장바구니에 해당상품이 없음
			}
			return res;
		}

	// 장바구니 삭제
	public boolean basketDelete(ArrayList<ProductVO> basket) {
		boolean res = false;

		if (basket.size() > 0) {
			basket.clear();
			res = true;
		}
		return res;
	}

	// 장바구니 구매
	public boolean basketPurchase(ArrayList<ProductVO> basket) {
		boolean res = true;

		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(p_basketPurchaseSql);
			// +) 트랜젝션 추가
			conn.setAutoCommit(false);
			for (ProductVO data : basket) {
				pstmt.setInt(1, data.getPstock());
				pstmt.setInt(2, data.getPnum());

				if (pstmt.executeUpdate() == 0) {
					res = false;
					conn.rollback(); // 구매실패시 롤백
					break;
				}
			}
			conn.commit(); // 구매성공시 커밋
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return res;
	}

	// 상품 재고(수량) 추가(admin)
	public boolean productStockAdd(ProductVO vo) {
		boolean res = false;
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(p_stockAddSql);
			pstmt.setInt(1, vo.getPstock());
			pstmt.setInt(2, vo.getPnum());

			res = (pstmt.executeUpdate() != 0) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return res;
	}

	// 상품 추가(admin)
	public boolean productAdd(ProductVO vo) {
		boolean res = false;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(p_insertSql);
			pstmt.setString(1, vo.getPname());
			pstmt.setInt(2, vo.getPstock());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getPinfo());

			res = (pstmt.executeUpdate() != 0) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return res;
	}

	// 상품 삭제
	public boolean productDelete(ProductVO vo) {
		boolean res = false;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(p_deleteAllSql);
			pstmt.setInt(1, vo.getPnum());
			res = (pstmt.executeUpdate() != 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return res;
	}

	// 크롤링		
	public void startDAO() { 
		final String webUrl = "https://www.shoemarker.co.kr/ASP/Product/Brand.asp?SBrandCode=NK";
		Document doc = null;

		try {

			doc = Jsoup.connect(webUrl).get(); 
		} catch (IOException e) {

			e.printStackTrace();
		}

		Elements eles = doc.select("div.product-list");

		Iterator<Element> itr1 = eles.select("div.ly-name").iterator();//상품명
		Iterator<Element> itr2 = eles.select("div.ly-price>span.ns-type-bl-eb18x").iterator();//상품가격


		int i=0;

		while(itr1.hasNext()&&itr2.hasNext()) {

			i++;
			if(i==11) {
				break;
			}
			//      System.out.println(itr1.next().text());// ex )에어맥스 AP 우먼스
			//      System.out.println(itr2.next().text().replace(",",""));// ex ) 89000  (String)
			int price= Integer.parseInt(itr2.next().text().replace(",",""));// ex ) 89000  (int)

			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement("insert into product values((select nvl(max(pnum),0)+1 from product),?,?,?,?)");
				pstmt.setString(1, itr1.next().text());
				pstmt.setInt(2, 10);
				pstmt.setInt(3, price);
				pstmt.setString(4, "");
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.disconnect(pstmt, conn);
			}            

		}
	}

}
