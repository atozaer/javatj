package view;

import java.util.List;

import controller.Controller;
import controller.MainController;
import vo.ProductVO;

public class ProductView extends View{
	public String userFlag;
	
	public ProductView() {
		super("번호\t상품명\t판매가\t재고", "%d\t%s\t%d\t%d");
	}

	@Override
	public void menuSelector() {
		System.out.println("(l)상품리스트, (v)상품조회, (e)상품 메뉴 종료");
		menuCode = MainController.sc.next().toLowerCase(); // 메뉴 코드값 입력(소문자 전환)
	}
	
	public void clientMenuSelector() {
		System.out.println("(l)상품리스트, (v)상품조회, (e)사용자 종료");
		menuCode = MainController.sc.next().toLowerCase();
	}
	
	public void adminMenuSelector() {
		System.out.println("(i)상품등록, (l)상품리스트, (u)상품수정, (d)상품삭제, (s)재고량 추가, (e)관리자 종료");
		menuCode = MainController.sc.next().toLowerCase();
	}

	@Override
	public void menuReSelector() {
		System.out.printf("메뉴 코드를 확인해 주세요(현재 입력 코드 : %s)\n", menuCode);
	}
	
	public int search() { 
		return getSearchIntMessage("상품 일련 번호");
	}
	
	public ProductVO insert() {
		ProductVO product = new ProductVO();
		System.out.print("등록할 상품명 : ");
		product.setProductName(MainController.sc.next());
		System.out.print("등록할 판매가 : ");
		product.setPrice(MainController.sc.nextInt());
		System.out.print("등록할 재고량 : ");
		product.setStock(MainController.sc.nextInt());
		
		return product;
	}
	
	public void insertResult(int result) {
		if (result > 0) {
			System.out.println("상품이 정상 등록 되었습니다.");
		}
		else {
			System.out.println("상품이 등록 되지 않았습니다.");
		}
	}
	
	public void list(List<ProductVO> productList) {
		showListHeader();
		if (productList.size() > 0) {
			for (ProductVO product : productList) {
				System.out.println(
					String.format(listString,
						product.getProductNo(),
						product.getProductName(),
						product.getPrice(),
						product.getStock()
					)
				);
			}
		}
		else {
			System.out.println("등록 된 상품이 존재하지 않습니다.");
		}
		showListFooter();
	}
	
	public String view(List<ProductVO> productList) {
		String result = "n";
		showListHeader();
		if (productList.size() > 0) {
			ProductVO product = productList.get(0);
			System.out.println(
				String.format(listString,
					product.getProductNo(),
					product.getProductName(),
					product.getPrice(),
					product.getStock()
				)
			);
			showListFooter();
			StringBuilder str = new StringBuilder(50);
			if (Controller.sessionNo != null) {
				str.append("(c)장바구니, ");
			}
			str.append("(o)구매하기, (e) 종료");
			
			System.out.println(str);
			
			result = MainController.sc.next().toLowerCase();
		}
		else {
			System.out.println("등록 된 상품이 존재하지 않습니다.");
			showListFooter();
		}
		return result;
	}
	
	public String modifyCheck(List<ProductVO> productList) {
		String result = "n";
		showListHeader();
		if (productList.size() > 0) {
			ProductVO product = productList.get(0);
			System.out.println(
				String.format(listString,
						product.getProductNo(),
						product.getProductName(),
						product.getPrice(),
						product.getStock()
				)		
			);
			System.out.println("해당 상품을 정말 수정 하시겠습니까?(y/n)");
			result = MainController.sc.next().toLowerCase();
		}
		else {
			System.out.println("대상 상품이 존재하지 않습니다.");
		}
		
		return result;
	}
	
	public ProductVO modify(ProductVO product) {
		System.out.print("수정 할 상품명 : ");
		product.setProductName(MainController.sc.next());
		System.out.print("수정 할 판매가 : ");
		product.setPrice(MainController.sc.nextInt());
		System.out.print("수정 할 재고량 : ");
		product.setStock(MainController.sc.nextInt());
		
		return product;
	}
	
	public String deleteCheck(List<ProductVO> productList) {
		String result = "n";
		showListHeader();
		if (productList.size() > 0) {
			ProductVO product = productList.get(0);
			System.out.println(
				String.format(listString,
						product.getProductNo(),
						product.getProductName(),
						product.getPrice(),
						product.getStock()
				)		
			);
			showListFooter();
			System.out.println("해당 상품을 정말 삭제 하시겠습니까?(y/n)");
			result = MainController.sc.next().toLowerCase();
		}
		else {
			System.out.println("대상 상품이 존재하지 않습니다.");
			showListFooter();
		}
		
		return result;
	}
	
	public String stockAddCheck(List<ProductVO> productList) {
		String result = "n";
		showListHeader();
		if (productList.size() > 0) {
			ProductVO product = productList.get(0);
			System.out.println(
				String.format(listString,
						product.getProductNo(),
						product.getProductName(),
						product.getPrice(),
						product.getStock()
				)		
			);
			showListFooter();
			System.out.println("해당 상품의 재고를 추가 하시겠습니까?(y/n)");
			result = MainController.sc.next().toLowerCase();
		}
		else {
			System.out.println("대상 상품이 존재하지 않습니다.");
			showListFooter();
		}
		
		return result;
	}
	
	public ProductVO stockAdd(ProductVO product) {
		System.out.print("추가 할 재고량 : ");
		int resultStock = product.getStock() + MainController.sc.nextInt();
		if (resultStock > 0) {
			product.setStock(resultStock);
		}
		else {
			System.out.println("재고량은 0이하로 설정이 불가능 합니다.");
		}
		
		return product;
	}
	
	public ProductVO order(ProductVO product) {
		while(true) {
			System.out.println("주문 수량을 입력해 주세요(최대 주문 가능 수량 : " + product.getStock() + ")");
			int orderStock = MainController.sc.nextInt();
			int resultStock = product.getStock() - orderStock;
			if (resultStock < 0) {
				System.out.println("최대 구매 수량을 초과 했습니다.");
				continue;
			}			
			else {
				System.out.println("구매 해주셔서 감사합니다.");
				product.setStock(resultStock);
				break;
			}
		}
		return product;
	}
}
