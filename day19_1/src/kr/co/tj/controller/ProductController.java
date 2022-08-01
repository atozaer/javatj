package kr.co.tj.controller;

import kr.co.tj.model.ProductDAO;
import kr.co.tj.model.ProductVO;
import kr.co.tj.view.ProductView;

public class ProductController {
	ProductView view;
	ProductDAO dao;
	
	public ProductController() {
		view = new ProductView();
		dao = new ProductDAO();
	}
	
	public void startApp() {
		while(true) {
			view.clientView();
			//[V]에서 사용자의 입력을 받음
			//[C]에서 입력값을 추출,분기처리
			if(view.act==1) {//목록
				ProductVO vo = new ProductVO();
				view.action1(dao.selectAll(vo));
			}//목록
			else if(view.act==2) {//상품구매
				view.action2();
				ProductVO vo = new ProductVO();
				vo.setPid(view.act);
				if(dao.updateClient(vo)) {
					view.action2_A();
				}else {
					view.action2_B();
				}
			}//상품구매
			else if(view.act==3) {//프로그램종료
				view.action3();
				break;
			}//프로그램종료
			else {//관리자모드 변경
				while(true) {//반복문시작
					view.adminView();
					if(view.act==1) {//상품제고추가
						ProductVO vo = view.action4();
						if(dao.updateAdmin(vo)) {	
							view.action4_A();
						}else {
							view.action4_B();
						}								
					}//상품제고추가
					else if(view.act==2) {//관리자모드종료
						view.action5();
						break;
					}//관리자종료
				}//반복문의끝
			}//관리자모드 변경
		}
	}
}

