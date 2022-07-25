package kr.co.tj1;

class Soda extends Drink {

	public Soda(String name, int cnt, int price) {
		super(name, cnt, price);
	}
	
	@Override
	public String toString() {
		return getName() + "\t수량:" + getCnt() + "\t가격:" + getPrice() + "원";
	}
}