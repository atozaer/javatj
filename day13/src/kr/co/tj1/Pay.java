package kr.co.tj1;

public class Pay {
	int money;

	public Pay(int money) {
		this.money = money;
	}
	
	public void pay(Drink drink, int cnt) {
		drink.cnt -= cnt;
	}
	
}
