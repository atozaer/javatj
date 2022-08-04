package kr.co.tj1;

public class Car {
	int speed;
	int maxSpeed;

	public Car(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void run() {
		System.out.println("자동차가 달린다.(최대속도 " + maxSpeed + "km/h)");

	}

	public void showSpeed() {
		System.out.println("현재 속도는 " + speed + "km/h 입니다.");
	}

}
