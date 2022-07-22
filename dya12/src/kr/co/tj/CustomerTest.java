//package kr.co.tj;
//
//class Customer {
//
//	protected int customerID;
//	protected String customerName;
//	protected String customerGrade;
//	int bonusPoint;
//	double bonusRatio;
//	int money;
//	int price;
//	
//
//	public Customer() {
//		customerGrade = "SILVER";
//		bonusRatio = 0.01;
//		
//		System.out.println("Customer() 생성자 호출");
//	}
//	
//	public Customer(int customerID, String customerName) {
//		this.customerID = customerID;
//		this.customerName = customerName;
//		
//		customerGrade = "SILVER";
//		bonusRatio = 0.01;
//		System.out.println("Customer(int, String) 생성자 호출");
//	}
//	
//	public int calcPrice(int price) {
//		bonusPoint += price * bonusRatio;
//		return price;
//	}
//	
////	public int buyProduct(int price) {
////		this.money-=price;
////		return money;
////		
////	}
//	
//	public int getMoney() {
//		return money;
//	}
//	
//	public void setMoney(int money) {
//		this.money = money;
//	}
//	
//	public int getCustomerID() {
//		return customerID;
//	}
//
//	public void setCustomerID(int customerID) {
//		this.customerID = customerID;
//	}
//
//	public String getCustomerName() {
//		return customerName;
//	}
//
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//
//	public String getCustomerGrade() {
//		return customerGrade;
//	}
//
//	public void setCustomerGrade(String customerGrade) {
//		this.customerGrade = customerGrade;
//	}
//
//	public String showCustomerInfo() {
//		return customerName + "님의 등급은 " + customerGrade + 
//				"이며, 잔액은 "+money+"원, 보너스 포인트는 " + bonusPoint +"지불금액은"+price+"입니다";
//		
//	}	
//}
//
//
//class VIPCustomer extends Customer{
//
//	private int agentID;
//	double salesRatio;
//	
//	public VIPCustomer() {
//		customerGrade = "VIP";    //오류 발생
//		bonusRatio = 0.05;
//		salesRatio = 0.1;
//		
//		System.out.println("VIPCustomer() 생성자 호출");
//	}
//	
//	
//	public VIPCustomer(int customerID, String customerName) {
//		super(customerID, customerName);
//		
//		customerGrade = "VIP";
//		bonusRatio = 0.05;
//		salesRatio = 0.1;
//		
//		System.out.println("VIPCustomer(int, String) 생성자 호출");
//	}
//	public int getAgentID() {
//		return agentID;
//	}
//	@Override
//	public int calcPrice(int price) {
//		bonusPoint += price*bonusRatio;
//		return price - (int)(price*salesRatio);
//	}
//}
//public class CustomerTest {
//
//	public static void main(String[] args) {
//		
////		Customer customerLee = new Customer(10010, "이순신");
////		customerLee.bonusPoint = 1000;
////		customerLee.setMoney(50000);
////		customerLee.buyProduct(10000);
////		customerLee.calcPrice(10000);
////		System.out.println(customerLee.showCustomerInfo());
//		
////		VIPCustomer customerKim = new VIPCustomer(10020, "김유신");
////		customerKim.bonusPoint = 10000;
////		System.out.println(customerKim.showCustomerInfo());
////		
////		Customer customer = new VIPCustomer(20000, "조용운");
////		customer.setMoney(100000);
////		int pricec = customer.calcPrice(10000);
////		System.out.println(customer.showCustomerInfo());
//	
//		
////		int priceLee = customerLee.calcPrice(10000);
////		int priceKim = customerKim.calcPrice(10000);
////		System.out.println(customerLee.showCustomerInfo());
////		System.out.println(customerKim.showCustomerInfo());
//		
////		int pricec = customer.calcPrice(10000);
////		System.out.println(customer.showCustomerInfo());
//	}
//}
//
//
