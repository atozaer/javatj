package vo;

public class CartVO {

	public final static String TABLENAME = "cart";
	public final static String INDEXNAME = "cartNo";
	
	private Long cartNo;
	private int stock;
	private Long productNo;
	private String productName;
	private int price;
	private Long memberNo;
	
	public CartVO(){
		
	}

	public Long getCartNo() {
		return cartNo;
	}

	public void setCartNo(Long cartNo) {
		this.cartNo = cartNo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	
	
}
