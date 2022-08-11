package vo;

import java.util.Date;

public class ProductVO {

	public final static String TABLENAME = "product";
	public final static String INDEXNAME = "productNo";
	
	private Long productNo;
	private String productName;
	private int price;
	private int stock;
	private Date regDate;
	
	public ProductVO() {
		
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
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


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
