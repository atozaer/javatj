package kr.co.tj.controller;

import java.util.ArrayList;

import kr.co.tj.model.MemberDAO;
import kr.co.tj.model.MemberVO;
import kr.co.tj.model.ProductDAO;
import kr.co.tj.model.ProductVO;
import kr.co.tj.view.AdminView;

public class AdminController {
	MainController mainController;
	
	private MemberDAO mDAO; 
	private ProductDAO pDAO;
	private AdminView aView;
	
	private MemberVO m0_vo, m1_vo;  // m0_vo:입력, m1_vo:출력
	private ProductVO p0_vo; 		// p0_vo:입력
	
	private int select;
	
	public AdminController(MainController mainController) {
		mDAO = new MemberDAO();  
		pDAO = new ProductDAO();
		
		aView = new AdminView();
		
		this.mainController = mainController;
	}
	
	public void start() {
		while(!MainController.exitFlag) {
			select = aView.adminLoginView();
			switch(select) {
				case 1: // 상품목록 확인
					ArrayList<ProductVO> items = pDAO.productList();				
					aView.adminListView(items);
					break;
				case 2: // 재고 추가
					p0_vo = aView.stockAddView();
					if (pDAO.productStockAdd(p0_vo)) {
						aView.stockAddSuccessView(); 	
					} else {
						aView.stockAddFailView(); 		
					}
					break;
				case 3: // 상품 추가
					p0_vo = aView.productAddView();
					if (pDAO.productAdd(p0_vo)) {
						aView.productAddSuccessView();	
					}else {
						aView.productAddFailView();		
					}
					break;
				case 4: // 상품 삭제
					p0_vo = aView.productDeleteView();
					if (pDAO.productDelete(p0_vo)) {
						aView.productDeleteSuccessView(); 	
					} else {
						aView.productDeleteFailView(); 		
					}
					break;
				case 5: // 상품추가(크롤링)
					pDAO.startDAO();
					aView.productMassiveAdd();
					break;
				case 6: // 회원목록 조회
					aView.memberAllView(mDAO.memberSelectAll());
					break;
				case 7: // 회원 검색 
					m0_vo = aView.memberSearchView();
					m1_vo = mDAO.memberSelectOne(m0_vo.getId());
					if (m1_vo.getId() != null) {
						aView.memberSearchSuccessView(m1_vo); 
					} else {
						aView.memberSearchFailView(); 		
					}
					break;
				case 8: // 포인트 추가
					m0_vo = aView.pointAddView();
					if (mDAO.memberPointUpdate(m0_vo)) {
						aView.pointAddSuccessView(); 	
					} else {
						aView.pointAddFailView(); 		
					}
					
					break;
				case 9: // 회원 삭제
					m0_vo = aView.memberDeleteView();
					if (mDAO.memberDelete(m0_vo.getId())) {
						aView.memberDeleteSuccessView(); 
					} else {
						aView.memberDeleteFailView(); 	 
					}
					break;
				case 10: // 관리자 로그아웃
					aView.exitAdmin();	
					mainController.startApp();
					break;
				default: 
					aView.wrongNum();
			
			}
		}
	}
	
}
