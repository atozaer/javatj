package repository;

import java.util.List;

import vo.OrderVO;

public class OrderRepository extends AbstractRepository<OrderVO> {

	public OrderRepository() {
		super(OrderVO.class);
	}
	
	public List<OrderVO> selectFindMemberNo(Long memberNo) {
		List<OrderVO> orderList = null;
		orderList = selectByQuery(String.format("Select * from `order` where member_no = %d", memberNo));
		
		return orderList;
	}
	
	public List<OrderVO> selectFindOrderNo(Long orderNo) {
		List<OrderVO> orderList = null;
		orderList = selectByQuery(String.format("Select * from `order` where order_no = %d", orderNo));
		
		return orderList;
	}
}
