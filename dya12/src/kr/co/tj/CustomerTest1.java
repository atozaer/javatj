package kr.co.tj;

import java.util.ArrayList;

class Customer {
	protected int customerID;
	protected int customerName;
	protected String customerGrade;
	int bonusPoint;
	int price;
	double bonusRatio;
	double saleRatio;

	public Customer() {

	}

	public Customer(int customerID, int customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
	}
	public int calcPrice(int price) {
		bonusPoint += price+bonusRatio;
		return price-(int)(price*saleRatio);
	}
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + 
				"이며, 보너스 포인트는 " + bonusPoint +"지불금액은"+price+"입니다";
	}

class VIPCustomer extends Customer {
	private int agentID;
	
	public VIPCustomer(int customerID, int customerName, int agentID) {
		super(customerID, customerName);

		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.agentID = agentID;
	}

	@Override
	public String calcPrice(int price) {
		return super.calcPrice(price)+"담당 상담원 번호는 "+ agentID + "입니다";
	}


}

class GoldCustomer extends Customer {
	double saleRatio;

	public GoldCustomer(int customerID, int customerName) {
		super(customerID, customerName);

		customerGrade = "GOLD";
		bonusRatio = 0.02;
		saleRatio = 0.1;
	}
	

}

public class CustomerTest1 {

	public static void main(String[] args) {

		ArrayList<Customer> customerList = new ArrayList<Customer>();

		Customer customerLee = new Customer(10010, "이순신");
		Customer customerShin = new Customer(10020, "신사임당");
		Customer customerHong = new GoldCustomer(10030, "홍길동");
		Customer customerYul = new GoldCustomer(10040, "이율곡");
		Customer customerKim = new VIPCustomer(10050, "김유신", 12345);

		customerList.add(customerLee);
		customerList.add(customerShin);
		customerList.add(customerHong);
		customerList.add(customerYul);
		customerList.add(customerKim);

		System.out.println("====== 고객 정보 출력 =======");

		for (Customer customer : customerList) {
			System.out.println(customer.showCustomerInfo());
		}

		System.out.println("====== 할인율과 보너스 포인트 계산 =======");

		int price = 10000;
		for (Customer customer : customerList) {
			int cost = customer.calcPrice(price);
			System.out.println(customer.getCustomerName() + " 님이 " + +cost + "원 지불하셨습니다.");
			System.out.println(customer.getCustomerName() + " 님의 현재 보너스 포인트는 " + customer.bonusPoint + "점입니다.");
		}
	}
}