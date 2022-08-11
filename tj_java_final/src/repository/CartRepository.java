package repository;

import java.util.List;

import vo.CartVO;
import vo.MemberVO;

public class CartRepository extends AbstractRepository<CartVO>  {
	public CartRepository() {
		super(CartVO.class);	
	}
	
	public List<CartVO> selectCartByMemberNo(Long memberNo) {
		List<CartVO> cartList = null;
		
		cartList = selectByQuery(String.format("Select * from cart where member_no = %d", memberNo));
		
		return cartList;
	}
	
	public CartVO selectCartByMemberNoAndProductNo(Long memberNo, Long productNo) {
		List<CartVO> cartList = null;
		CartVO cart = null;
		cartList = selectByQuery(String.format("Select * from cart where member_no = %d and product_no = %d", memberNo, productNo));
		
		if (cartList.size() > 0) {
			cart = cartList.get(0);
		}
		
		return cart;
	}
}
