package kr.co.tj.model;

public class ProductVO {
	private int pid; //PK 번호
	private String pname; //이름
	private int price;//가격
	private int cnt;//갯수

	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "ProductVO [pid=" + pid + ", pname=" + pname + ", price=" + price + ", cnt=" + cnt + "]";
	}

	
	
}
