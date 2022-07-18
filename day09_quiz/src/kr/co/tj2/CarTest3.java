package kr.co.tj2;

class Car{
	private String color;
	private int speed;
	private int gear;
	private int id;
	private static int numberOfCars;
	static {
		numberOfCars = 0;//실체화된 Car객체의 개수를 위한 정적변수
	}
	public Car() {}
	public Car(String c, int s, int g) {
		color = c;
		speed = s;
		gear = g;
		//자동차의 개수를 증가하고 id번호를 할당한다.
		id = ++numberOfCars;
	}
		
	public static int getNumberOfCars() {
		return numberOfCars;
	}
		
}

public class CarTest3 {

	public static void main(String[] args) {
		Car c1 = new Car("파란색",100,1);
		Car c2 = new Car("흰색",0,1);
		int n = Car.getNumberOfCars();
		System.out.println("지금까지 생성된 자동차 수= "+n);
		
	}

}
