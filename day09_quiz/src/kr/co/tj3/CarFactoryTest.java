package kr.co.tj3;

class Car {
	private static int serialNum=10000;
	private int carNum;

	public Car() {
		serialNum++;
		carNum = serialNum;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	
}

class CarFactory {
	private static CarFactory Instance = new CarFactory();

	private CarFactory() {

	}

	public static CarFactory getInstance() {
		if (Instance == null) {
			Instance = new CarFactory();
		}
		return Instance;
	}
	public Car createCar() {
		Car car = new Car();
		return car;
	}

}

public class CarFactoryTest {

	public static void main(String[] args) {
		CarFactory factory = CarFactory.getInstance();
		Car mySonata = factory.createCar();
		Car yourSonata = factory.createCar();
		
		System.out.println(mySonata.getCarNum());
		System.out.println(yourSonata.getCarNum());
	}

}
