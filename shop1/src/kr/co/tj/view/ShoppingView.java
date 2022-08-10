package kr.co.tj.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.tj.controller.MemberController;
import kr.co.tj.model.MemberVO;
import kr.co.tj.model.ProductVO;

public class ShoppingView {
		
	// 쇼핑몰 머니 충전
	public MemberVO moneyAddView() {
		Scanner scan = new Scanner(System.in);
		MemberVO m_vo = new MemberVO();
		int money = -1; 
		
		m_vo.setId(MemberController.loginID);
		while(money < 0) {
			System.out.println("쇼핑머니를 충전합니다.");
			System.out.print("충전할 금액 입력 : ");
			money = scan.nextInt();
			m_vo.setMoney(money);
			if(money < 0) System.out.println("충전금액을 다시 입력해주세요.");
		}
		
		return m_vo;		
	}
	
	public void moneyAddSuccessView() {
		System.out.println("쇼핑머니를 충전했습니다.");
	}
	
	public void moneyAddFailView() {
		System.out.println("쇼핑머니를 충전하지 못했습니다. 다시 시도해주세요.");
	}
	
	// 포인트
	public int pointUseView(int myMoney, int myPoint, int totalPrice) { // 머니, 포인트, 구매가격 파라미터 추가
		Scanner scan = new Scanner(System.in);
		int point=0;
		
		System.out.println("보유머니:"+myMoney+"원, 보유포인트:"+myPoint+"p");
		while(true) {
			System.out.println("구매에 사용할 포인트 입력 : ");
			point = scan.nextInt();
			if (point<0 || point>myPoint || point>totalPrice) {
				System.out.println(point + " " + myPoint + " " + totalPrice);
				System.out.println("포인트는 음수이거나 보유포인트를 초과하거나 구매금액을 초과할 수 없습니다.");
			} else {
				break;
			}
		}
		
		return point;
	}
	
	public void pointStackView(int point) { // 적립포인트 파라미터 추가
		System.out.println(point+"포인트가 적립되었습니다.");
	}
	
	// 상품목록
	public boolean productListView(ArrayList<ProductVO> datas) {// 반환값을 boolean으로 변경
		Scanner scan = new Scanner(System.in);
		boolean res = false;
		int agree = 0;
		
		System.out.println("==== 상품목록 =====");
		for(ProductVO p_vo:datas) {
			System.out.println(p_vo);
		}
		while(agree<1 || agree>2) {
			System.out.println("1.장바구니에 담기   2.뒤로가기");
			System.out.print("메뉴선택 : ");
			agree = scan.nextInt();
			if (agree == 1) res = true;
		}		
				
		return res; // true:장바구니 담기, false:뒤로가기
	}
		
	// 장바구니
	public ProductVO basketAddView() { // 반환값을 ProductVO로 변경
		Scanner scan = new Scanner(System.in);
		ProductVO p_vo = new ProductVO();
		int pstock = 0;
		
		System.out.print("구매할 상품번호 입력 : ");
		p_vo.setPnum(scan.nextInt());
		while(pstock < 1) {
			System.out.println("구매수량 입력 : ");
			pstock = scan.nextInt();
			if (pstock < 1) {
				System.out.println("구매수량은 1개 이상 입력해주세요.");
				continue;
			}
			p_vo.setPstock(pstock);
		}
		return p_vo;
	}
	
	public void basketAddSuccessView() {
		System.out.println("해당상품을 장바구니에 추가했습니다.");
	}
	
	public void basketAddFailViewA() { // 장바구니 추가 실패사유 세분화
		System.out.println("상품번호를 잘못 입력하셨습니다.");
	}	
	
	public void basketAddFailViewB() { // 장바구니 추가 실패사유 세분화
		System.out.println("해당상품의 재고가 부족합니다.");
	}	
	
	public void basketListView(ArrayList<ProductVO> datas) { // 장바구니 출력만 하면 되므로 반환값을 void로 수정
		System.out.println("==== 장바구니 목록 ====");
		if (datas.size() > 0) {
			int totalPrice = 0;
			for (ProductVO p_vo:datas) {
				System.out.println(p_vo.listView());
				totalPrice += p_vo.getPrice() * p_vo.getPstock();
			}			
			System.out.print("상품의 총 금액 : "+totalPrice+"원");
		} else {
			System.out.println("장바구니가 비어있습니다.");
		}
		System.out.println();
	}
	
	public int basketSelectView() {
		Scanner scan = new Scanner(System.in);
		int select = 0;
		
		while(select<1 || select>4) {
			System.out.println("1.장바구니 목록 구매");
			System.out.println("2.장바구니 목록 수량 변경");
			System.out.println("3.장바구니 목록 삭제");
			System.out.println("4.장바구니 나가기");
			System.out.print("메뉴 선택 : ");
			select = scan.nextInt();			
			if (select<1 || select>4) {
				System.out.println("잘못 선택하셨습니다.");
			}
		}
		return select;		
	}	
	
	public ProductVO basketUpdateView() {
		Scanner scan = new Scanner(System.in);
		ProductVO p_vo = new ProductVO();
		
		System.out.println("장바구니 상품의 수량을 변경합니다.");
		System.out.print("수량을 변경할 상품번호 입력 : ");
		p_vo.setPnum(scan.nextInt());
		System.out.print("변경(추가(+)/감소(-))시킬 수량 입력 : ");
		p_vo.setPstock(scan.nextInt());
		
		return p_vo;		
	}
	
	public void basketUpdateSuccessView(){
		System.out.println("상품의 수량을 변경하였습니다.");
	}
	
	public void basketUpdateFailViewA() { 			// 실패사유 세분화
		System.out.println("장바구니에 없는 상품입니다.");		
	}
	
	public void basketUpdateFailViewB(int pstock) { // 실패사유 세분화
		System.out.println("구매수량이 음수이거나 재고수량을 초과할 수 없습니다. 현재 재고 : "+pstock+"개");		
	}
	
	public boolean basketDeleteView() { // 장바구니 삭제여부만 체크하므로 반환값을 boolean으로 변경		
		Scanner scan = new Scanner(System.in);
		boolean res = false;		
		
		System.out.print("장바구니를 삭제하시겠습니까?(Y/N) ");
		if (scan.next().toUpperCase().charAt(0)=='Y') {
			res = true;
		}
		
		return res;
	}
	
	public void basketDeleteSuccessView() { // 장바구니 삭제결과 추가
		System.out.println("장바구니를 삭제했습니다.");		
	}
	
	public void basketDeleteFailView() {    // 장바구니 삭제결과 추가
		System.out.println("장바구니를 삭제하지 못했습니다.");
		
	}
	
	// 상품구매
	public void purchaseSuccessView() {
		System.out.println("장바구니의 상품을 구매했습니다.");
	}
	
	public void purchaseFailViewA() { // 구매실패 세분화
		System.out.println("보유금액과 포인트가 부족합니다.");
	}
	
	public void purchaseFailViewB() { // 구매실패 세분화
		System.out.println("구매에 실패했습니다.");
	}
	
	public void purchaseFailViewC() { // 구매실패 세분화
		System.out.println("장바구니가 비어있습니다");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
