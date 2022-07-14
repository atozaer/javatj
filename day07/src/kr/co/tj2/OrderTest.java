package kr.co.tj2;

class Order{
	public String orderNumber;
	public String customerPhone;
	public String customerAddress;
	public String orderDate;
	public String orderTime;
	public int price;
	public String menuId;
	
	public Order() {}
	public Order(String orderNumber, String customerPhone, String customerAddress, String orderDate, String orderTime, int price, String menuId) {
		this.orderNumber = orderNumber;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.price = price;
		this.menuId = menuId;
	}
	
	public void showOrderData1() {
		System.out.println("주문접수번호:"+orderNumber);
		System.out.println("주문핸드폰번호:"+customerPhone);
		System.out.println("주문집수소:"+customerAddress);
		System.out.println("주문날짜:"+orderDate);
		System.out.println("주문시간:"+orderTime);
		System.out.println("주문가격:"+price);
		System.out.println("메뉴번호:"+menuId);
	}
	
}


public class OrderTest {

	public static void main(String[] args) {
		Order myOrder = new Order();
		myOrder.orderNumber = "202011020003";
		myOrder.customerPhone = "01023450001";
		myOrder.customerAddress = "구로디지털단지";
		myOrder.orderDate = "20201102";
		myOrder.orderTime = "130258";
		myOrder.price = 35000;
		myOrder.menuId = "0003";
		
		myOrder.showOrderData1();
		
	}

}
