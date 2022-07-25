package kr.co.tj1;

class Juice extends Drink {

	public Juice(String name, int cnt, int price) {
		super(name, cnt, price);
	}
	
	@Override
	public String toString() {
		return getName() + " 수량:" + getCnt() + " 가격:" + getPrice() + "원";
	}
}
