package admin.view;

import java.util.Set;

import config.Function;
import controller.MainController;

public class OrderView implements AdminView{

	@Override
	public String menuSelector() {
		System.out.println("(l)주문 리스트, (s)주문 검색, (m)주문 상태값 변경, (그외)주문 관리 종료");
		return MainController.sc.next().toLowerCase();
	}
	
	public Long searchOrderNo() {
		System.out.println("검색하실 주문번호를 입력해 주세요");
		return MainController.sc.nextLong();
	}
	
	public String printOrderState() {
		StringBuilder str = new StringBuilder();
		Set<String> keys = Function.orderStateCode.keySet();
		for (String key : keys) {
			if (str.length() > 0) {
				str.append(", ");
			}
			str.append(String.format("(%s)%s", key, Function.orderStateCode.get(key)));
		}
		str.append(", (그외) 종료");
		System.out.println(str.toString());
		return MainController.sc.next().toLowerCase();
	}
	
	public String printOrderStateChangeFlag(String orderState) {
		System.out.printf("해당 주문은 카드결제가 되지 않은 상품 입니다.\n상태값을 %s(으)로 정말 변경 하시겠습니까?(y/n)\n", Function.orderStateCode.get(orderState));
		return MainController.sc.next().toLowerCase();
	}
	
	public void printOrderStateChangeResult(int result) {
		if (result > 0) {
			System.out.println("상태 값이 변경 되었습니다.");
		}
		else {
			System.out.println("상태 값 변경에 실패 했습니다.");
		}
	}
}
