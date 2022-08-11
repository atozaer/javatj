package vo;

public class OrderItemVO {
	public final static String TABLENAME = "order_item";
	public final static String INDEXNAME = "orderItemNo";
	
	private Long orderItemNo;
	private Long orderNo;
	private Long productNo;
	private String productName;
	private int productPrice;
	private int paymentPoint;
	private int stock;
	
	public Long getOrderItemNo() {
		return orderItemNo;
	}
	public void setOrderItemNo(Long orderItemNo) {
		this.orderItemNo = orderItemNo;
	}
	
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
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
	
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getPaymentPoint() {
		return paymentPoint;
	}
	public void setPaymentPoint(int paymentPoint) {
		this.paymentPoint = paymentPoint;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
