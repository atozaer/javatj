package repository;

import java.util.List;

import vo.OrderItemVO;
import vo.OrderVO;

public class OrderItemRepository extends AbstractRepository<OrderItemVO> {

	public OrderItemRepository() {
		super(OrderItemVO.class);
	}
	
	public List<OrderItemVO> selectFindOrderNo(Long orderNo) {
		List<OrderItemVO> orderItemList = null;
		orderItemList = selectByQuery(String.format("Select * from order_item where order_no = %d", orderNo));
		
		return orderItemList;
	}
}
