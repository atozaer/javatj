package kr.co.tj.model;

public class ProductVO {
	private int pnum;
	private String pname;
	private int pstock;
	private int price;
	private String pinfo;
	
	public ProductVO() {
		super();
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPstock() {
		return pstock;
	}

	public void setPstock(int pstock) {
		this.pstock = pstock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPinfo() {
		return pinfo;
	}

	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}

	@Override
	public String toString() {
		return "[상품번호:" + pnum + ", 상품명:" + pname + ", 재고:" + pstock + ", 가격:" + price + "원]";
	}	
	
	public String listView() {
		return "[상품번호:" + pnum + ", 상품명:" + pname + ", 구매수량:" + pstock + ", 가격:" + price + "원]";
	}	
	
}
