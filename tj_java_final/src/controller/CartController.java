package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import repository.CartRepository;
import repository.ProductRepository;
import view.CartView;
import view.ProductView;
import vo.CartVO;
import vo.ProductVO;

public class CartController extends Controller {
	CartRepository cartRepository;
	ProductRepository productRepository;
	OrderController orderController;
	CartView cartView;
	CartVO cartVO;
	
	public CartController() {
		cartRepository = new CartRepository();
		cartView = new CartView();
		cartVO = new CartVO();
	}
	
	@Override
	void selectMenu() {
		controllerResult = true;
		List<CartVO> cartList = null;
		if (!loginCheck(true)) {
			controllerResult = false;
			return;
		}
		
		cartView.menuSelector();
		switch(cartView.menuCode) {
			case "l" :
				cartList = cartRepository.selectCartByMemberNo(Controller.sessionNo);
				cartView.printCartList(cartList);
				//cart
				break;
			case "o" :
				cartList = cartRepository.selectCartByMemberNo(Controller.sessionNo);
				orderController = new OrderController();
				orderController.cartOrder(cartList);
				break;
			case "m" :
				cartList = cartRepository.selectCartByMemberNo(Controller.sessionNo);
				cartView.printCartList(cartList);
				if (cartList.size() > 0) {
					
					Long modifyCartNo = cartView.getCartModifyCartNo();
					CartVO modifyCart = null;
					for (CartVO cart : cartList) {
						if (cart.getCartNo() == modifyCartNo) {
							modifyCart = cart;
						}
					}
					if (modifyCart != null) {
						productRepository = new ProductRepository();
						List<ProductVO> productList = productRepository.selectFindById(modifyCart.getCartNo());
						modifyCart = cartView.cartStockModify(modifyCart, productList);
						
						cartView.insertCartResult(cartRepository.update(modifyCart));
					}
				}
				break;
			case "d" :
				cartList = cartRepository.selectCartByMemberNo(Controller.sessionNo);
				cartView.printCartList(cartList);
				if (cartList.size() > 0) {
					Long targetId = cartView.deleteCartNo();
					CartVO deleteCart = null; 
					for (CartVO cart : cartList) {
						if (cart.getCartNo() == targetId) {
							deleteCart = cart;
						}
					}
					
					if (deleteCart != null) {
						if (cartView.deleteFlag().equals("y")) {
							cartView.deleteResult(cartRepository.deleteById(targetId));
							break;
						}
					}
					else {
						cartView.printNotDeleteTarget();
					}
					
				}
				break;
			case "e" :
				controllerResult = false;
				break;
			default :
				cartView.menuReSelector();
				break;
		}
	}
	
	public boolean cartInsert(ProductVO product) {
		cartVO = new CartVO();
		String cartFlag = "n";
		boolean returnResult = false;
		
		if (product != null) {
			CartVO oriCart = cartRepository.selectCartByMemberNoAndProductNo(sessionNo, product.getProductNo());
			if (oriCart != null) {
				cartVO = oriCart;
				cartVO.setPrice(product.getPrice());
				cartVO.setProductName(product.getProductName());
				cartVO.setProductNo(product.getProductNo());
				cartVO.setMemberNo(Controller.sessionNo);
				
				cartFlag = cartView.oriCartFlag(oriCart);
				
				cartView.printProductStock(product);
				if (cartFlag.equals("n")) {
					cartVO.setStock(cartView.inProductStock(product.getStock()));
				}
				else {
					cartVO.setStock(cartView.addProductStock(product.getStock(), cartVO.getStock()));
				}
				
				returnResult = cartView.insertCartResult(cartRepository.update(cartVO));
			}
			else {
				cartVO.setPrice(product.getPrice());
				cartVO.setProductName(product.getProductName());
				cartVO.setProductNo(product.getProductNo());
				cartVO.setMemberNo(Controller.sessionNo);
				cartVO.setStock(cartVO.getStock() + cartView.inProductStock(product.getStock()));
				returnResult = cartView.insertCartResult(cartRepository.save(cartVO));
			}
		}
		else {
			cartView.notProduct();
		}
		return returnResult;
	}
}
