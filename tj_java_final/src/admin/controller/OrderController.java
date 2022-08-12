package admin.controller;

import java.util.List;

import admin.view.OrderView;
import config.Function;
import repository.OrderItemRepository;
import repository.OrderRepository;
import vo.OrderVO;

public class OrderController extends AdminMainController {
	OrderRepository orderRepository = new OrderRepository();
	OrderItemRepository orderItemRepository = new OrderItemRepository();
	OrderView orderView = new OrderView();
	view.OrderView userOrderView = new view.OrderView();
	
	OrderVO order;
	List<OrderVO> orderList;
	
	@Override
	public void play() {
		Long searchOrderNo = null;
		switch (orderView.menuSelector()) {
			case "l" :
				orderList = orderRepository.selectAll();
				if (orderList.size() > 0) {
					for (OrderVO order : orderList) {
						userOrderView.printOrderInfo(order, orderItemRepository.selectFindOrderNo(order.getOrderNo()));
					}
				}
				else {
					userOrderView.printNotOrderInfo();
				}
				break;
			case "s" :
				searchOrderNo = orderView.searchOrderNo();
				orderList = orderRepository.selectFindById(searchOrderNo);
				if (orderList.size() > 0) {
					userOrderView.printOrderInfo(orderList.get(0), orderItemRepository.selectFindOrderNo(searchOrderNo));
				}
				else {
					userOrderView.printNotOrderInfo();
				}
				break;
			case "m" :
				searchOrderNo = orderView.searchOrderNo();
				orderList = orderRepository.selectFindById(searchOrderNo);
				if (orderList.size() > 0) {
					order = orderList.get(0);
					userOrderView.printOrderInfo(order, orderItemRepository.selectFindOrderNo(searchOrderNo));
					String orderState = orderView.printOrderState();
					if (Function.orderStateCode.get(orderState) != null) {
						if (order.getCardResult().equals("f") && !orderState.equals("rc")) {
							String flag = orderView.printOrderStateChangeFlag(orderState);
							if (flag.equals("y")) {
								order.setOrderState(orderState);
								orderView.printOrderStateChangeResult(orderRepository.update(order));
							}
						}
						else {
							order.setOrderState(orderState);
							orderView.printOrderStateChangeResult(orderRepository.update(order));
						}
					}
				}
				else {
					userOrderView.printNotOrderInfo();
				}
				break;
			default :
				adminAppResult = false;
				break;
		}
		
	}
}
