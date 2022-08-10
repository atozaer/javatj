package kr.co.tj.controller;

import java.util.ArrayList;

import kr.co.tj.model.MemberDAO;
import kr.co.tj.model.MemberVO;
import kr.co.tj.model.ProductDAO;
import kr.co.tj.model.ProductVO;
import kr.co.tj.view.AdminView;
import kr.co.tj.view.ShoppingView;
import kr.co.tj.view.StartView;

public class ProductController {
	MainController mainController;
	
	private MemberDAO mDAO; 
	private ProductDAO pDAO;
	private StartView sView;
	private ShoppingView pView;
	private MemberVO m0_vo; 
	private ProductVO p0_vo;
	
	private int select;
	
	public ProductController(MainController mainController) {
		mDAO = new MemberDAO();  
		pDAO = new ProductDAO();
		
		sView = new StartView();
		pView = new ShoppingView();
		
		this.mainController = mainController;
	}
	
	public void start() {
		ArrayList<ProductVO> basket = new ArrayList<ProductVO>();
		ArrayList<ProductVO> items = new ArrayList<ProductVO>();
		
		while(!MainController.exitFlag) {
			// 보유금액, 보유포인트 조회
			int myMoney = mDAO.memberMoneyCheck(MemberController.loginID);
			int myPoint = mDAO.memberPointCheck(MemberController.loginID);
						
			select = sView.loginSuccessView(myMoney, myPoint);
			switch(select) {
				case 1: // 상품목록 보기
					items.clear();
					items = pDAO.productList();
					while(true) {
						if (pView.productListView(items)) { //상품목록 보기
							addItems(items, basket); 		// 장바구니에 담기
						} else {
							break;
						}
					}
					break;
				case 2: // 쇼핑머니 충전
					m0_vo = pView.moneyAddView();
					if (mDAO.memberMoneyUpdate(m0_vo)) {
						pView.moneyAddSuccessView(); 	
					} else {
						pView.moneyAddFailView();		
					}
					break;
				case 3: // 장바구니 보기
					pView.basketListView(basket);
					int select2 = pView.basketSelectView();
					if (select2 == 1) { // 1.장바구니 목록 구매			
						purchaseItems(basket);
					} else if (select2 == 2) { // 2.장바구니 목록 수량 변경
						int res = 0;
						p0_vo = pView.basketUpdateView();		
						
						res = pDAO.basketUpdate(basket, p0_vo);						
						if (res == 1){ // 1=성공, 2=장바구니에 없는 상품번호, 3=재고수량 부족
							pView.basketUpdateSuccessView();
						} else if (res == 2){
							pView.basketUpdateFailViewA(); // 장바구니에 상품 부재		
						} else if (res == 3){
							pView.basketUpdateFailViewB(p0_vo.getPstock()); // 재고 부족 : 파라미터-재고수량		
						} else {
							System.out.println("로그 : 알 수 없는 실패사유");
						}
					} else if (select2 == 3) { // 3.장바구니 목록 삭제
						if (pView.basketDeleteView()) { 		 
							if (pDAO.basketDelete(basket)) {
								pView.basketDeleteSuccessView(); 
							} else {
								pView.basketDeleteFailView();	 
							}
						}
					} 
					break;
				case 4: // 로그아웃
					MemberController.session = false;
					MemberController.loginID = null;
					mainController.startApp();
					break;
				default:;
			}
		}
	}
	
	// 장바구니 목록 구매
	private boolean purchaseItems(ArrayList<ProductVO> basket) {
		boolean res = false;
		int totalPrice = 0;	// 장바구니 금액 합계
		int myMoney = 0;	// 보유금액
		int myPoint = 0;	// 보유포인트
				
		if (basket.size() < 1) {
			pView.purchaseFailViewC(); // 장바구니가 비어있으면 구매불가			
		} else {
		
			// 장바구니 금액 합계(수량/재고 문제는 장바구니 단계에서 처리)		
			for (ProductVO data:basket) {
				totalPrice += data.getPrice() * data.getPstock(); 
			}
					
			// 회원 쇼핑머니,포인트 조회
			myMoney = mDAO.memberMoneyCheck(MemberController.loginID);
			myPoint = mDAO.memberPointCheck(MemberController.loginID);
			
			// 구매가능 여부 판단
			if (totalPrice > myMoney + myPoint) {
				pView.purchaseFailViewA(); // 쇼핑머니+포인트 부족
			} else {// 구매처리	
				if (pDAO.basketPurchase(basket)) { // 장바구니 구매
					// 쇼핑머니, 사용포인트 차감
					int usePoint = pView.pointUseView(myMoney, myPoint, totalPrice);
					int useMoney = totalPrice - usePoint;
					m0_vo = new MemberVO();
					m0_vo.setId(MemberController.loginID);
					m0_vo.setMoney(-useMoney);  // 적립과 차감을 분리하지 않고 memberMoneyUpdate() 한개로 처리(양수:적립,음수:차감)
					m0_vo.setPoint(-usePoint);  // 적립과 차감을 분리하지 않고 memberPointUpdate() 한개로 처리(양수:적립,음수:차감)
					if (mDAO.memberMoneyUpdate(m0_vo)) {						
						System.out.println("로그 : 머니차감 성공"); // 시스템 로그
					}else {						
						System.out.println("로그 : 머니차감 실패"); // 시스템 로그
					}
					if (mDAO.memberPointUpdate(m0_vo)) {						
						System.out.println("로그 : 포인트차감 성공"); // 시스템 로그
					}else {						
						System.out.println("로그 : 포인트차감 실패"); // 시스템 로그
					}
					
					// 포인트 적립
					myPoint = (int)(totalPrice * 0.1);
					m0_vo.setPoint(myPoint);
					if (mDAO.memberPointUpdate(m0_vo)) {
						pView.pointStackView(myPoint);
					} else {
						// 포인트 적립 실패 로그
						System.out.println("로그 : 포인트적립 실패");
					}					
					pDAO.basketDelete(basket);   // 장바구니 삭제
					
					pView.purchaseSuccessView();
				} else {
					pView.purchaseFailViewB();  
				}
			}	
		}		
		return res;
	}
	
	// 장바구니에 추가
	private void addItems(ArrayList<ProductVO> items, ArrayList<ProductVO> basket) {
		int num1=0, num2=0, buyQuantity=0;
		ArrayList<Integer> itemNum = new ArrayList<Integer>();   // 쇼핑목록 상품번호 리스트
		ArrayList<Integer> basketNum = new ArrayList<Integer>(); // 장바구니 상품번호 리스트
				
		// 쇼핑목록 상품번호 리스트 작성
		itemNum.clear();
		for (ProductVO data:items) {
			itemNum.add(data.getPnum());
		}		
		// 장바구니 상품번호 리스트 작성
		basketNum.clear();
		for (ProductVO data:basket) {
			basketNum.add(data.getPnum());
		}
		
		p0_vo = pView.basketAddView(); // 중복검색할 상품
		
		if (itemNum.contains(p0_vo.getPnum())) {      // 존재하는 상품인지 체크(쇼핑목록)
			num1 = itemNum.indexOf(p0_vo.getPnum());  // 쇼핑목록 상품위치(index)
			
			if (basketNum.contains(p0_vo.getPnum())){      // 장바구니에 해당상품이 있는지 체크
				num2 = basketNum.indexOf(p0_vo.getPnum()); // 장바구니에 있으면 그 위치(index)
				buyQuantity = basket.get(num2).getPstock() + p0_vo.getPstock(); // 장바구니 수량 + 추가 수량
			} else {
				buyQuantity = p0_vo.getPstock(); // 장바구니에 없으면 추가 수량만..
			}
			if (items.get(num1).getPstock() < buyQuantity) { // 재고수량 < 구매수량?
				pView.basketAddFailViewB(); // 재고수량 부족
			} else {
				basket = pDAO.basketAdd(basket, p0_vo.getPnum(), p0_vo.getPstock()); // 장바구니 추가
				pView.basketAddSuccessView();
			}
		} else { // 상품번호 입력 오류
			pView.basketAddFailViewA();
		}		
	}
	
}
