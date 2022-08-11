package view;

import java.util.List;

import controller.MainController;
import controller.OrderController;
import vo.CartVO;
import vo.OrderItemVO;
import vo.OrderVO;
import vo.ProductVO;

public class OrderView  extends View {

	public OrderView() {
		super("주문번호\t주문자아이디\t총주문금액\t주문일", "%d\t%s\t%d\t%d");
	}

	@Override
	public void menuSelector() {
		//테스트용 코드
		//System.out.println("(o)주문, (c)카트, (e)종료");
		menuCode = MainController.sc.next().toLowerCase();
	}
	
	public int orderProductStock(ProductVO productVO) {
		int inStock = 0;
		if (productVO.getStock() > 0) {
			while (true) {
				System.out.println("구매 상품 : " + productVO.getProductName());
				System.out.println("구매 수량을 입력해 주세요(구매가능 수량 : " + productVO.getStock() + ")");
				int stock = MainController.sc.nextInt();
				if (productVO.getStock() < stock) {
					System.out.println("구매 가능 수량을 초과 했습니다.");
				}
				else {
					inStock = stock;
					break;
				}
			}
		}
		else {
			System.out.println("품절 상품 입니다.");
		}
		return inStock;
	}
	
	public String orderComment() {
		System.out.println("요청사항 : ");
		MainController.sc.nextLine();
		String comment = MainController.sc.nextLine();
		return comment;
	}
	
	public int orderUsePoint(int usePoint) {
		int inUsePoint = 0;
		System.out.printf("현재 사용가능한 적립금이 %d원 이상 존재 합니다.\n", OrderController.sucessPoint);
		System.out.printf("사용가능 적립금 : %d원\n사용하시겠습니까?(y/n)\n", usePoint);
		if (MainController.sc.next().toLowerCase().equals("y")) {
			while (true) {
				System.out.printf("사용할 적립금액을 입력해 주세요\n최소 사용 가능 적립금 : %d원\n", OrderController.sucessPoint);
				inUsePoint = MainController.sc.nextInt();
				if (usePoint < inUsePoint) {
					System.out.printf("보유 하신 적립금 %d원 보다 사용금액을 크게 작성하셨습니다.\n", usePoint);
				}
				else if (OrderController.sucessPoint > inUsePoint) {
					System.out.printf("최소 사용 가능 적립금은 %d원 입니다.\n", OrderController.sucessPoint);
				}
				else {
					break;
				}
			}
		}
		
		return inUsePoint;
	}
	
	public void cartStockZero(CartVO cart) {
		System.out.println("구매 불가 상품이 존재 합니다.");
		System.out.println(listSplit);
		System.out.println(
			String.format("상품번호 : %d\n상품명 : %s\n판매가 : %d",
				cart.getProductNo(),
				cart.getProductName(),
				cart.getPrice()
			)
		);
		System.out.println(listSplit);
	}
	
	public int cartStockModify(ProductVO product) {
		int inStock = 0;
		while(true) {
			System.out.println("현재 구매가능 수량을 초과한 상품이 존재 합니다.");
			System.out.println(listSplit);
			System.out.println(
				String.format("상품번호 : %d\n상품명 : %s\n판매가 : %d\n현재 구매가능 수량 : %d",
					product.getProductNo(),
					product.getProductName(),
					product.getPrice(),
					product.getStock()
				)
			);
			System.out.println(listSplit);
			System.out.print("장바구니 변경 수량 값 입력 : ");
			inStock = MainController.sc.nextInt();
			if (inStock <= 0) {
				System.out.println("잘못 된 수량을 입력 하셨습니다.");
			}
			else if (inStock > product.getStock()) {
				System.out.println("구매 가능 수량을 초과 했습니다.");
			}
			else {
				break;
			}
		}
		return inStock;
	}
	
	public String payment(int totalPrice) {
		System.out.println("실 결제 금액 : " + totalPrice);
		System.out.println("해당 상품을 정말 구매하시겠습니까?\n카드 결제(y/n)");
		
		return MainController.sc.next().toLowerCase();
	}
	
	public void orderItemView(List<OrderItemVO> orderItemList) {
		System.out.println(listSplit);
		System.out.println("번호\t상품명\t판매가\t구매 수량");
		System.out.println(listSplit);
		if (orderItemList.size() > 0) {
			for (OrderItemVO orderItem : orderItemList) {
				System.out.println(
						String.format("%d\t%s\t%d\t%d",
								orderItem.getProductNo(),
								orderItem.getProductName(),
								orderItem.getProductPrice(),
								orderItem.getStock()
						)
				);				
			}
		}
		else {
			System.out.println("주문 상품이 존재하지 않습니다.");
		}
		System.out.println(listSplit);
		
		//System.out.println();
	}
	
	public String notLoginOrderInfo() {
		System.out.println("(주문번호)비회원 주문 조회, (e) 비회원 주문 조회 종료");
		return MainController.sc.next().toLowerCase();
	}
	
	public void printNotOrderInfo() {
		System.out.println(listSplit);
		System.out.println("조회 된 주문 데이터가 존재 하지 않습니다.");
		System.out.println(listSplit);
	}
	
	public void printOrderInfo(OrderVO order, List<OrderItemVO> orderItemList) {
		if (order != null) {
			System.out.println(listSplit);
			System.out.println(
				String.format("주문정보\n주문번호 : %d\n실결제금액 : %d\n지급 적립금 : %d\n사용 적립금 : %d\n요청사항 : %s\n주문일시 : %s\n결제 완료 여부 : %s",
					order.getOrderNo(),
					order.getTotalPrice(),
					order.getPaymentPoint(),
					order.getUsePoint(),
					order.getOrderComment(),
					sdf.format(order.getOrderDate()),
					(order.getCardResult() == "t") ? "결제 완료" : "결제 실패"
				)
			);
			System.out.println(listSplit);
		}
		orderItemView(orderItemList);
		System.out.println("-------------------------------------------------------------");
	}
	
	public void orderResult(OrderVO order, List<OrderItemVO> orderItems, boolean result) {
		String msg = null;
		System.out.println(listSplit);
		if (result) {
			System.out.println("주문을 완료했습니다.\n감사합니다.");
		}
		else {
			System.out.println("주문에 실패 했습니다.");
		}
		
		if (order != null) {
			System.out.println(listSplit);
			System.out.println(
				String.format("주문정보\n주문번호 : %d\n실결제금액 : %d\n지급 적립금 : %d\n사용 적립금 : %d\n요청사항 : %s\n주문일시 : %s\n결제 완료 여부 : %s",
					order.getOrderNo(),
					order.getTotalPrice(),
					order.getPaymentPoint(),
					order.getUsePoint(),
					order.getOrderComment(),
					sdf.format(order.getOrderDate()),
					(order.getCardResult() == "t") ? "결제 완료" : "결제 실패"
				)
			);
			System.out.println(listSplit);
		}
		orderItemView(orderItems);
	}
	
	public void notOrderItem() {
		System.out.println("주문할 상품이 존재하지 않습니다.");
	}
	
	public void notCart() {
		System.out.println("장바구니에 담긴 상품이 없습니다.");
	}

	@Override
	public void menuReSelector() {
		
	}

}
