package vo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ProductVO {
	public final static String TABLENAME = "product";
	public final static String INDEXNAME = "productNo";
	private Long productNo;
	private String productName;
	private int price;
	private int stock;
	
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

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public ProductVO() {
		
	}
}
