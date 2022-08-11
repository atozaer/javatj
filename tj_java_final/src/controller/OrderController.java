package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import config.Function;
import repository.AbstractRepository;
import repository.CartRepository;
import repository.MemberRepository;
import repository.OrderItemRepository;
import repository.OrderRepository;
import repository.ProductRepository;
import view.OrderView;
import vo.CartVO;
import vo.MemberVO;
import vo.OrderItemVO;
import vo.OrderVO;
import vo.ProductVO;

public class OrderController extends Controller {
	public static int sucessPoint = 100;
	public static double paymentPointPer = 1.0;
	
	ProductRepository productRepository = new ProductRepository();
	OrderRepository orderRepository = new OrderRepository();
	OrderItemRepository orderItemRepository = new OrderItemRepository();
	MemberRepository memberRepository = new MemberRepository();
	CartRepository cartRepository = new CartRepository();
	
	OrderView orderView = new OrderView();
	OrderVO orderVO = null;
	OrderItemVO orderItemVO = null;
	Date ordDate;
	
	List<OrderItemVO> orderItemList;
	@Override
	void selectMenu() {
		controllerResult = true;
		printOrderList();
		
		controllerResult = false;
		/*// 테스트용 코드
		orderView.menuSelector();
		switch (orderView.menuCode) {
		
			case "o" :
				List<ProductVO> product = productRepository.selectFindById((long)17);
				boolean orderResult = false;
				if (product.size() > 0) {
					orderResult = order(product.get(0));
				}
				break;
			case "c" :
				List<CartVO> cartList = cartRepository.selectAll();
				if (cartList.size() > 0) {
					cartOrder(cartList);
				}
				else {
					orderView.notCart();
				}
				break;
			case "e" :
				controllerResult = false;
				break;
		}
		 */
	}
	
	public void printOrderList() {
		List<OrderVO> orderList = null;
		if (Controller.sessionNo != null) {
			orderList = orderRepository.selectFindMemberNo(sessionNo);
			if (orderList.size() > 0) {
				for (OrderVO order : orderList) {
					List<OrderItemVO> orderItemList = orderItemRepository.selectFindOrderNo(order.getOrderNo());
					
					orderView.printOrderInfo(order, orderItemList);
				}
			}
			else {
				orderView.printNotOrderInfo();
			}
//			orderRepository.sele
		}
		else {
			while (true) {
				String orderNo = orderView.notLoginOrderInfo();
				if (orderNo.equals("e")) {
					break;
				}
				else {
					orderList = orderRepository.selectFindOrderNo(Long.parseLong(orderNo));
					
					if (orderList.size() > 0) {
						for (OrderVO order : orderList) {
							List<OrderItemVO> orderItemList = orderItemRepository.selectFindOrderNo(order.getOrderNo());
							
							orderView.printOrderInfo(order, orderItemList);
						}
						break;
					}
					else {
						orderView.printNotOrderInfo();
					}
				}
			}
		}
	}
	
	public boolean order(ProductVO product) {
		orderItemList = new ArrayList<>();
		OrderVO orderVO = null;
		int usePoint = 0;
		boolean result = true;
		if (product != null) {
			ordDate = new Date();
			Long orderNo = Function.createOrderNo(ordDate);
			MemberVO member = null;
			
			int stock = orderView.orderProductStock(product);
			if (stock > 0) {
				orderVO = new OrderVO();
				AbstractRepository.setTransaction();
				
				orderVO.setOrderNo(orderNo);
				
				orderVO.setPaymentPoint((int)Math.round(product.getPrice() * (paymentPointPer / 100)) * stock);
				
				if (Controller.sessionNo != null) {
					List<MemberVO> memberList = memberRepository.selectFindById(Controller.sessionNo);
					member = memberList.get(0);
					orderVO.setMemberNo(Controller.sessionNo);
					usePoint = orderUsePoint(memberRepository.selectFindById(Controller.sessionNo));
					orderVO.setUsePoint(usePoint);
					member.setMemberPoint(member.getMemberPoint() - usePoint);
					member.setMemberPoint(member.getMemberPoint() + ((int)Math.round(product.getPrice() * (paymentPointPer / 100)) * stock));
					
					int memberResult = memberRepository.update(member);
					
					if (memberResult == 0) result = false;
				}
				
				orderVO.setTotalPrice(product.getPrice() * stock - usePoint);
				
				orderVO.setOrderComment(orderView.orderComment());
				orderVO.setOrderDate(ordDate);
				
				int orderResult = orderRepository.save(orderVO);
				if (orderResult == 0) result = false;
				
				if (result)	result = orderProduct(orderNo, product, stock);
				
				orderView.orderItemView(orderItemList);
				String cardResult;
				if (orderView.payment(orderVO.getTotalPrice()).equals("y")) {
					cardResult = (cardReturn()) ? "t" : "f";
				}
				else {
					cardResult = "f";
				}
				result = (cardResult == "t") ? true : false;
				orderVO.setCardResult(cardResult);
				
				AbstractRepository.transactionProcess(result);
				
				orderView.orderResult(orderVO, orderItemList, result);
			}
			else result = false;
		}
		else {
			orderView.notOrderItem();
			result = false;
		}
		
		return result;
	}
	
	public int orderUsePoint(List<MemberVO> memberList) {
		int usePoint = 0;
		if (memberList.size() > 0) {
			MemberVO member = memberList.get(0);
			if (member.getMemberPoint() >= sucessPoint) {
				usePoint = orderView.orderUsePoint(member.getMemberPoint());
				if (usePoint > 0) {
					member.setMemberPoint(member.getMemberPoint() - usePoint);
					memberRepository.update(member);
				}
			}
		}
		return usePoint;
	}
	
	public boolean orderProduct(Long orderNo, ProductVO product, int stock) {
		boolean result = true;
		OrderItemVO orderItemVO = new OrderItemVO();
		
		orderItemVO.setOrderNo(orderNo);
		orderItemVO.setProductName(product.getProductName());
		orderItemVO.setStock(stock);
		orderItemVO.setProductNo(product.getProductNo());
		orderItemVO.setProductPrice(product.getPrice());
		product.setStock(product.getStock() - stock);
		
		orderItemList.add(orderItemVO);
		
		int orderItemResult = orderItemRepository.save(orderItemVO);
		if (orderItemResult == 0) result = false;
		
		int productResult = productRepository.update(product);
		if (productResult == 0) result = false;
		
		return result;
	}
	
	public boolean cartOrder(List<CartVO> cartList) {
		boolean result = true;
		if (cartList.size() > 0) {
			orderItemList = new ArrayList<>();
			
			int usePoint = 0;
			
			MemberVO member = null;
			
			ordDate = new Date();
			Long orderNo = Function.createOrderNo(ordDate);
			
			OrderVO orderVO = new OrderVO();
			orderVO.setOrderNo(orderNo);
			orderVO.setOrderDate(ordDate);
			orderVO.setOrderComment(orderView.orderComment());
			
			int totalPrice = 0;
			int totalPaymentPoint = 0;
			AbstractRepository.setTransaction();
			
			if (Controller.sessionNo != null) {
				List<MemberVO> memberList = memberRepository.selectFindById(Controller.sessionNo);
				member = memberList.get(0);
				orderVO.setMemberNo(Controller.sessionNo);
				usePoint = orderUsePoint(memberRepository.selectFindById(Controller.sessionNo));
				orderVO.setUsePoint(usePoint);
				member.setMemberPoint(member.getMemberPoint() - usePoint);
			}
			
			for (CartVO cart : cartList) {
				List<ProductVO> productList = productRepository.selectFindById(cart.getProductNo());
				if (productList.size() > 0) {
					ProductVO product = productList.get(0);
					
					if (product.getStock() <= 0) {
						orderView.cartStockZero(cart);
						if (cartRepository.deleteById(cart.getCartNo()) == 0 && result) {
							result = false;
							break;
						}
						continue;
					}
					
					if (product.getStock() < cart.getStock()) {
						cart.setStock(orderView.cartStockModify(product));
					}
					
					result = orderProduct(orderNo, product, cart.getStock());
					totalPrice += product.getPrice() * cart.getStock();
					totalPaymentPoint += (int)Math.round(product.getPrice() * (paymentPointPer / 100)) * cart.getStock();
					if (cartRepository.deleteById(cart.getCartNo()) == 0 && result) {
						result = false;
						break;
					}
				}
			}
			totalPrice -= usePoint;
			orderVO.setPaymentPoint(totalPaymentPoint);
			orderVO.setTotalPrice(totalPrice);
			
			if (Controller.sessionNo != null) {
				member.setMemberPoint(member.getMemberPoint() + totalPaymentPoint);
				int memberResult = memberRepository.update(member);
				if (memberResult == 0) result = false;
			}
			
			orderView.orderItemView(orderItemList);
			String cardResult;
			if (orderView.payment(totalPrice).equals("y")) {
				cardResult = (cardReturn()) ? "t" : "f";
			}
			else {
				cardResult = "f";
			}
			result = (cardResult == "t") ? true : false;
			
			orderVO.setCardResult(cardResult);
			orderRepository.save(orderVO);
			
			AbstractRepository.transactionProcess(result);
			
			orderView.orderResult(orderVO, orderItemList, result);
		}
		else {
			orderView.notCart();
		}

		return result;
	}
	
	public boolean cardReturn () {
		boolean result = true;
		int resultNumber = (int)(Math.random() * 10) + 1;
		System.out.println(resultNumber);
		if (resultNumber > 8) {
			result = false;
		}
		return result;
	}

}
