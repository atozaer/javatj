package kr.co.tj1;

public class Truck extends Car {
	int product;

	public Truck(int speed) {
		super(speed);
		maxSpeed = 100;
	}

	@Override
	public void run() {
		System.out.println("트럭이 달린다.(최대속도 " + maxSpeed + "km/h)");

	}

	@Override
	public void showSpeed() {
		System.out.println("현재 속도는 " + speed + "km/h 입니다.");
	}

	public void productUp(int product) {
		this.product += product;
	}

	public void productDown(int product) {
		this.product -= product;
	}

	public void showproduct() {
		System.out.println("현재 물건개수는 " + product + "개입니다.");
	}
}
