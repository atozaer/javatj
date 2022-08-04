package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import repository.ProductRepository;
import view.ProductView;
import vo.BoardVO;
import vo.ProductVO;

public class ProductController extends Controller {
	ProductRepository productRepository;
	ProductView productView; 
	List<ProductVO> productList;
	
	public ProductController() {
		// super 클래스쪽 인자 전달을 통한 리스트 조회에 필요한 타이틀, 내용 출력 포멧 셋
		super("번호\t상품명\t판매가\t재고량", "%d\t%s\t%d\t%d");
		// 레포지토리(DB 통신을 위한 객체) 셋팅
		productRepository = new ProductRepository();
		productView = new ProductView();
	}

	@Override
	void selectMenu() {
		controllerResult = true;		// 컨트롤러 흐름제어 flag 해당 메뉴 종료시만 false 대입 Controller.run() 메소드 내 흐름 종료 
		productList = null;				// 리스트 형태 데이터 객체
		ProductVO product = null;		// 단일 형태 데이터 객체
		int searchNo = 0;				// 검색, 수정, 삭제 사용 데이터 일련번호
		
		// 메뉴 출력
		productView.menuSelector();
		switch (productView.userFlag) {
			case "a":
				
				adminMenu : while(true) {
					productView.adminMenuSelector();
					switch (productView.menuCode) {
						case "i":
							product = productView.insert();
							productView.insertResult(
								productRepository.save(product)
							);
							break;
						case "l":
							productView.list(productRepository.selectAll());
							break;
						case "u":
							productList = productRepository.selectFindById(
												productView.search()
											);
							
							String modifyResult = productView.modifyCheck(productList);
							if (modifyResult.equals("y")) {
								product = productView.modify(productList.get(0));
								productRepository.update(product);
							}
							break;
						case "d":
							int deleteTargetNo = productView.search();
							productList = productRepository.selectFindById(
									deleteTargetNo
								);
				
							String deleteResult = productView.deleteCheck(productList);
							if (deleteResult.equals("y")) {
								productRepository.deleteById(deleteTargetNo);
							}
							break;
						case "s":
							productList = productRepository.selectFindById(
								productView.search()
							);
							
							String stockAddResult = productView.stockAddCheck(productList);
							if (stockAddResult.equals("y")) {
								productRepository.update(productView.stockAdd(productList.get(0)));
							}
							break;
						case "e":
							break adminMenu;
						default:
							break;
					}
				}
				
				break;
			case "c":
				clientMenu : while (true) {
					productView.clientMenuSelector();
					switch (productView.menuCode) {
						case "l":
							productView.list(productRepository.selectAll());
							break;
						case "v":
							productList = productRepository.selectFindById(
								productView.search()
							);
							String orderResult = productView.view(productList);
							if (orderResult.equals("y")) {
								ProductVO productResult = productView.order(productList.get(0));
								productRepository.update(productResult);
							}
							break;
						case "e":
							break clientMenu;
						default:
							break;
					}
				}
				
				break;
//			case "c":
//				product = new ProductVO();		// VO객체 셋팅
//				
//				// 셋팅된 VO객체 멤버변수 값 셋팅 처리
//				System.out.print("상품명 입력 : ");
//				String productName = MainController.sc.next();
//				
//				System.out.print("판매가 입력 : ");
//				int price = MainController.sc.nextInt();
//				
//				System.out.print("재고량 입력 : ");
//				int stock = MainController.sc.nextInt();
//				product.setProductName(productName);
//				product.setPrice(price);
//				product.setStock(stock);
//				
//				// repository.save 메소드 boardVO 객체 전달로 DB 저장
//				productRepository.save(product);
//				break;
//			case "r":
//				// 검색 일련번호 수집
//				searchNo = getSearchIntMessage("상품 일련 번호");
//				
//				// 검색 일련번호 데이터를 조회 후 리스트 형태 단일 데이터 추출
//				productList = productRepository.selectFindById(searchNo);
//				
//				showListHeader();// 리스트 헤더 출력
//				
//				// 일련번호 조회 단일 데이터 추출
//				product = productList.get(0);
//				
//				// 검색 데이터 노출
//				System.out.printf(listString + "\n", 
//						product.getProductNo(),
//						product.getProductName(),
//						product.getPrice(),
//						product.getStock()
//				);
//				break;
//			case "l":	
//				// 전체 데이터 조회
//				productList = productRepository.selectAll();
//				
//				showListHeader(); // 리스트 헤더 출력 
//				
//				// 조회 데이터 노출
//				for(ProductVO productVO: productList) {
//					System.out.printf(listString + "\n", 
//							productVO.getProductNo(),
//							productVO.getProductName(),
//							productVO.getPrice(),
//							productVO.getStock()
//					);
//				}
//				break;
//			case "u":
//				// 수정 게시글 일련번호 수집
//				searchNo = getSearchIntMessage("상품 일련 번호");
//				// 수정 게시글 조회 VO 객체 생성
//				productList = productRepository.selectFindById(searchNo);
//				ProductVO productVO = productList.get(0);
//				
//				// 조회 후 등록 된 VO 객체 데이터 수정 
//				System.out.print("상품명 입력 : ");
//				String updateProductName = MainController.sc.next();
//				
//				System.out.print("판매가 입력 : ");
//				int updatePrice = MainController.sc.nextInt();
//				
//				System.out.print("재고량 입력 : ");
//				int updateStock = MainController.sc.nextInt();
//				productVO.setProductName(updateProductName);
//				productVO.setPrice(updatePrice);
//				productVO.setStock(updateStock);
//				
//				// 수정된 데이터 업데이트 처리
//				int updateNo = productRepository.update(productVO);
//				if (updateNo > 0) {
//					System.out.println("정상 수정 되었습니다.");
//				}
//				else {
//					System.out.printf("%d 일련번호 상품이 수정 되지 않았습니다.\n", updateNo);
//				}
//				break;
//			case "d":
//				// 삭제 대상 일련번호 수집
//				searchNo = getSearchIntMessage("상품 일련 번호");
//				// 수집 된 일련번호 삭제
//				int resultNo = productRepository.deleteById(searchNo);
//				if (resultNo > 0) {
//					System.out.println("정상 삭제 되었습니다.");
//				}
//				else {
//					System.out.printf("%d 일련번호 상품이 삭제 되지 않았습니다.\n", searchNo);
//				}
//				break;
//			case "e":
//				controllerResult = false;
//				break;
			default:
				System.out.printf("메뉴 코드를 확인해 주세요(현재 입력 코드 : %s)\n", productView.userFlag);
				break;
		}
	}
}
