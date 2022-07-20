package kr.co.tj4;

class Customer {
	protected int customerID;//고객아이디
	protected String customerName;//고객이름
	protected String customerGrade;//고객등급
	int bonusPoint;//보너스포인트
	double bonusRatio;//얼마을 할인해줄것인지 할인율

	public Customer() {

	}

	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}

	public String showCustomerInfo() {
		return customerName + "님의 등급은" + customerGrade + "이며, 보너스포인트는" + bonusPoint + "점 입니다.";
	}
}

class VipCustomer extends Customer {
	private int agentID;//전문상담사
	double salesRatio;//할인율
	
	public VipCustomer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salesRatio = 0.1;
	}

	public int getAgentID() {
		return agentID;
	}
}

public class CustomerTest {

	public static void main(String[] args) {
		Customer customerLee = new Customer(10010, "이순신");
		customerLee.bonusPoint = 1000;
		System.out.println(customerLee.showCustomerInfo());

		VipCustomer customerKim = new VipCustomer(10020, "김유신");
		customerKim.bonusPoint = 10000;
		System.out.println(customerKim.showCustomerInfo());
	}

}
