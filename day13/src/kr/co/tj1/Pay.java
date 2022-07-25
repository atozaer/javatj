package kr.co.tj1;

public class Pay {
	int money;

	public Pay(int money) {
		this.money = money;
	}
	
	public void pay(Drink drink, int orders) {
		if (orders > drink.getCnt()) {
			System.out.println("재고가 부족합니다.");
		}else {
			if(money < drink.getPrice()) {
				System.out.println("잔액이부족합니다.");
			}else {
				money -=(drink.getPrice()*orders);
				drink.setCnt(drink.getCnt()*orders);
				System.out.println("주문하신음료"+ drink.getName());
				System.out.println("남은잔액은"+money+"원 남았습니다.");
			}
			
		}
		
	}
	
}
