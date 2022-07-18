package kr.co.tj;

class Car{
	String color;
	int speed;
	int gear;
	
	public Car(int speed, int gear, String color) {
		this.speed = speed;
		this.gear = gear;
		this.color = color;
	}
	
	public void print() {
		System.out.println("차의색깔:"+color);
		System.out.println("차의속도:"+speed);
		System.out.println("차의기어:"+gear);
	}
	
}

public class CarTest1 {

	public static void main(String[] args) {
		Car car1 = new Car(0, 1, "red");
		car1.print();
		
		
	}

}
