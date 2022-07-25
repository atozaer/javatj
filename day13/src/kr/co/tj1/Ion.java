package kr.co.tj1;

class Ion extends Drink{

	public Ion(String name, int cnt, int price) {
		super(name, cnt, price);
	}
	
	@Override
	public String toString() {
		return getName() + " 수량:" + getCnt() + " 가격:" + getPrice() + "원";
	}

}
