package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import repository.ProductRepository;
import view.ProductView;
import vo.ProductVO;

public class ProductController extends Controller {
	ProductRepository productRepository;
	ProductView productView;
	OrderController orderController;
	CartController cartController;
	List<ProductVO> productList;
	
	public ProductController() {
		// 레포지토리(DB 통신을 위한 객체) 셋팅
		productRepository = new ProductRepository();
		productView = new ProductView();
		orderController = new OrderController();
		cartController = new CartController();
	}

	@Override
	void selectMenu() {
		controllerResult = true;		// 컨트롤러 흐름제어 flag 해당 메뉴 종료시만 false 대입 Controller.run() 메소드 내 흐름 종료 
		productList = null;				// 리스트 형태 데이터 객체
		ProductVO product = null;		// 단일 형태 데이터 객체
		int searchNo = 0;				// 검색, 수정, 삭제 사용 데이터 일련번호
		
		// 메뉴 출력
		productView.menuSelector();
		switch (productView.menuCode) {
			case "l":
				productView.list(productRepository.selectAll());
				break;
			case "v":
				productList = productRepository.selectFindById(
					productView.search()
				);
				String orderResult = productView.view(productList);
				if (orderResult.equals("o")) {
					boolean result = orderController.order(productList.get(0));
					//productRepository.update(productResult);
				}
				else if (orderResult.equals("c")) {
					boolean result = cartController.cartInsert(productList.get(0));
				}
				break;
			case "e":
				controllerResult = false;
				break;
			default:
				productView.menuReSelector();
				break;
		}
	}
}
