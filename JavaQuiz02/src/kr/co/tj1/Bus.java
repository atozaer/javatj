package kr.co.tj1;

public class Bus extends Car {
	int passenger=0;

	public Bus(int speed) {
		super(speed);
		maxSpeed = 120;
	}

	@Override
	public void run() {
		System.out.println("버스가 달린다.(최대속도 " + maxSpeed + "km/h)");

	}

	@Override
	public void showSpeed() {
		System.out.println("현재 속도는 " + speed + "km/h 입니다.");
	}

	public void passengerUp(int passenger) {
		this.passenger+=passenger;
	}

	public void passengerDown(int passenger) {
		this.passenger-=passenger;
	}

	public void showPassenger() {
		System.out.println("현재 탑승인원은 " + passenger + "명입니다.");
	}

}
