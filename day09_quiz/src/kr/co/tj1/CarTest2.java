package kr.co.tj1;


import java.util.Scanner;

class Car{
	private int speed;
	private int mileage;
	private String color;
	
	public Car() {
		this(0,0,"no");
	}
	public Car(int speed, int maleage, String color) {
		super();
		this.speed = speed;
		this.mileage = maleage;
		this.color = color;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}

public class CarTest2 {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.setSpeed(100);
		car1.setMileage(0);
		car1.setColor("red");
		
		
		System.out.println("현재 자동차의 속도는 = "+car1.getSpeed());
		System.out.println("현재 자동차의 주행거리는 = "+car1.getMileage());
		System.out.println("현재 자동차의 색깔은 = "+car1.getColor());
		
	}

}
