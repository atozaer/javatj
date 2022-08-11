package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.directory.SearchControls;

import controller.MainController;
import vo.CartVO;
import vo.ProductVO;

public class CartView extends View {

	public CartView() {
		super("번호\t상품명\t판매가\t구매수량", "%d\t%s\t%d\t%d");
	}

	@Override
	public void menuSelector() {
		System.out.println("(l)장바구니 리스트, (o)주문, (m)구매 수량 수정, (d)삭제, (e) 장바구니 종료");
		menuCode = MainController.sc.next();
	}

	@Override
	public void menuReSelector() {
		System.out.printf("메뉴 코드를 확인해 주세요(현재 입력 코드 : %s)\n", menuCode);		
	}
	
	public void printProductStock(ProductVO product) {
		System.out.println(listSplit);
		System.out.println("상품번호\t상품명\t판매가");
		System.out.println(listSplit);
		System.out.println(String.format("%d\t%s\t%d", 
				product.getProductNo(),
				product.getProductName(),
				product.getPrice()
			)
		);
		System.out.println(listSplit);
	}
	
	public int inProductStock(int stock) {
		
		int inStock = 0;
		while (true) {
			System.out.printf("몇개의 상품을 장바구니에 담으시겠습니까?(구매가능 수량 : %d)\n", stock);
			inStock = MainController.sc.nextInt();
			if (inStock < 0 || inStock > stock) {
				System.out.println("구매 가능 수량을 확인해 주세요");
			}
			else break;
		}
		//if (stock)
		return inStock;
	}
	
	public int addProductStock(int maxStock, int oriStock) {
		
		int inStock = 0;
		while (true) {
			System.out.printf("몇개의 상품을 장바구니에 추가하시겠습니까?(구매가능 수량 : %d)\n", maxStock);
			inStock = MainController.sc.nextInt();
			if (inStock + oriStock < 0 || inStock + oriStock > maxStock) {
				System.out.printf("구매 가능 수량을 확인해 주세요(현재 수량 : %d)\n", oriStock);
			}
			else break;
		}
		
		inStock += oriStock;
		//if (stock)
		return inStock;
	}

	public void notProduct() {
		System.out.println("장바구니에 담을 상품이 존재하지 않습니다.");
	}
	
	public boolean insertCartResult(int result) {
		boolean returnResult = true;
		if (result > 0) {
			System.out.println("장바구니에 담았습니다.");
		}
		else {
			returnResult = false;
			System.out.println("장바구니에 담지 못했어요 ㅠㅠ");
		}
		
		return returnResult;
	}
	
	public void printCartList(List<CartVO> cartList) {
		System.out.println(listSplit);
		System.out.println("장바구니 번호\t상품 번호\t상품명\t판매가\t담은수량");
		System.out.println(listSplit);
		if (cartList.size() > 0) {
			for (CartVO cart : cartList) {
				System.out.println(String.format("%d\t%d\t%s\t%d\t%d", 
						cart.getCartNo(),
						cart.getProductNo(),
						cart.getProductName(),
						cart.getPrice(),
						cart.getStock()
					)
				);
			}
		}
		else {
			System.out.println("장바구니에 담은 상품이 존재하지 않습니다.");
		}
		
		System.out.println(listSplit);
	}
	
	public String oriCartFlag(CartVO cart) {
		System.out.println(listSplit);
		System.out.println("이미 장바구니에 담긴 상품이 존재 합니다.");
		List<CartVO> cartList = new ArrayList<>();
		cartList.add(cart);
		printCartList(cartList);
		System.out.println("해당 상품의 구매수량 추가/수정 여부(y/n)");
		
		return MainController.sc.next().toLowerCase();
	}
	
	public Long getCartModifyCartNo() {
		System.out.println("수정할 장바구니 번호를 입력해 주세요");
		return MainController.sc.nextLong();
	}
	
	public CartVO cartStockModify(CartVO cart, List<ProductVO> productList) {
		if (cart == null) {
			System.out.println("수정 대상의 장바구니 상품이 존재하지 않습니다.");
		}
		else {
			if (productList.size() == 0) {
				System.out.println("존재하지 않는 상품 입니다.");
			}
			else {
				while(true) {					
					System.out.printf("변경할 구매 수량을 입력해 주세요(구매가능 수량 : %d)\n", productList.get(0).getStock());
					int inStock = MainController.sc.nextInt();
					if (inStock < 0 || inStock > productList.get(0).getStock()) {
						System.out.println("구매가능 수량을 초과 했습니다.");
					}
					else {
						cart.setStock(inStock);
						break;
					}
				}
			}
		}
		return cart;
	}
	
	public Long deleteCartNo() {
		System.out.println("삭제할 장바구니 번호를 입력해 주세요");
		return MainController.sc.nextLong();
	}
	
	public String deleteFlag() {
		System.out.println("장바구니의 해당 상품을 정말 삭제 하시겠습니까?(y/n)");
		
		return MainController.sc.next().toLowerCase();
	}
	
	public void deleteResult(int result) {
		if (result > 0) {
			System.out.println("장바구니 삭제를 완료 했습니다.");
		}
		else { 
			System.out.println("삭제 되지 않았습니다.");
		}
	}
}
