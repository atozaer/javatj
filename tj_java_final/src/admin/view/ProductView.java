package admin.view;

import java.util.List;

import controller.MainController;
import vo.ProductVO;

public class ProductView implements AdminView{
	String listSplit;
	public ProductView() {
		listSplit = "========================================";
	}
	
	public void printSplit() {
		System.out.println(listSplit);
	}
	@Override
	public String menuSelector() {
	System.out.println("(i)상품 초기화(크롤링등록), (l)리스트 (c)추가 등록, (m)수정, (d)삭제, (s)재고 수정, (그외)상품 관리 종료");
		return MainController.sc.next().toLowerCase();
	}
	
	public ProductVO insert() {
		ProductVO product = new ProductVO();
		System.out.print("등록할 상품명 : ");
		MainController.sc.nextLine();
		product.setProductName(MainController.sc.nextLine());
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
	
	public int search() { 
		System.out.println("대상 상품 번호를 입력해 주세요");
		return MainController.sc.nextInt();
	}
	
	public String modifyCheck(List<ProductVO> productList) {
		String result = "n";
		printSplit();
		if (productList.size() > 0) {
			printProductInfo(productList.get(0));
			printSplit();
			System.out.println("해당 상품을 정말 수정 하시겠습니까?(y/n)");
			result = MainController.sc.next().toLowerCase();
		}
		else {
			System.out.println("대상 상품이 존재하지 않습니다.");
			printSplit();
		}
		
		return result;
	}
	
	public ProductVO modify(ProductVO product) {
		System.out.print("수정 할 상품명 : ");
		MainController.sc.nextLine();
		product.setProductName(MainController.sc.nextLine());
		System.out.print("수정 할 판매가 : ");
		product.setPrice(MainController.sc.nextInt());
		System.out.print("수정 할 재고량 : ");
		product.setStock(MainController.sc.nextInt());
		
		return product;
	}
	
	public String deleteCheck(List<ProductVO> productList) {
		String result = "n";
		printSplit();
		if (productList.size() > 0) {
			printProductInfo(productList.get(0));
			printSplit();
			System.out.println("해당 상품을 정말 삭제 하시겠습니까?(y/n)");
			result = MainController.sc.next().toLowerCase();
		}
		else {
			System.out.println("대상 상품이 존재하지 않습니다.");
			printSplit();
		}
		
		return result;
	}
	
	public void modifyResult(int result) {
		if (result > 0) {
			System.out.println("수정이 완료 되었습니다.");
		}
		else {
			System.out.println("수정 실패");
		}
	}
	
	public void deleteResult(int result) {
		if (result > 0) {
			System.out.println("삭제가 완료 되었습니다.");
		}
		else {
			System.out.println("삭제 실패");
		}
	}
	
	public String stockAddCheck(List<ProductVO> productList) {
		String result = "n";
		printSplit();
		if (productList.size() > 0) {
			printProductInfo(productList.get(0));
			printSplit();
			System.out.println("해당 상품의 재고를 추가 하시겠습니까?(y/n)");
			result = MainController.sc.next().toLowerCase();
		}
		else {
			System.out.println("대상 상품이 존재하지 않습니다.");
			printSplit();
		}
		
		return result;
	}
	
	public ProductVO stockAdd(ProductVO product) {
		while (true) {
		System.out.print("증감 할 재고량 : ");
			int resultStock = product.getStock() + MainController.sc.nextInt();
			if (resultStock > 0) {
				product.setStock(resultStock);
				break;
			}
			else {
				System.out.println("재고량은 0이하로 설정이 불가능 합니다.");
			}
		}
		
		return product;
	}
	
	public void printProductInfo(ProductVO product) {
		System.out.println(
			String.format("상품번호 : %d\n상품명 : %s\n판매가 : %d\n재고량 : %d",
					product.getProductNo(),
					product.getProductName(),
					product.getPrice(),
					product.getStock()
			)		
		);
	}
}
