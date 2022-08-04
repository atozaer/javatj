package kr.co.tj1;

public class SportCar extends Car {

	public SportCar(int speed) {
		super(speed);
		maxSpeed = 190;
	}

	@Override
	public void run() {
		System.out.println("스포츠카가 달린다.(최대속도 " + maxSpeed + "km/h)");

	}

	@Override
	public void showSpeed() {
		System.out.println("현재 속도는 " + speed + "km/h 입니다.");
	}

	public int boosterOn() {
		maxSpeed = maxSpeed+30;
		return maxSpeed;
	}
	
	public int booserOff() {
		maxSpeed = maxSpeed-30;
		return maxSpeed;
	}

}
