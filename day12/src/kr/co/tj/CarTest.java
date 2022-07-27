//package kr.co.tj;
//
//
//
//class Car{
//	private String model;
//	public Car(String model) {
//	this.model = model;
//	}
//	
//	@Override
//	public boolean equals(Object obj){
//		if (obj instanceof Car) {
//			Car car = (Car)obj;
//			return model.equals(((Car) obj).model);
//		}
//		else {
//			return false;
//		}
//	}
//}
//
//
//public class CarTest {
//
//	public static void main(String[] args) {
//		Car firstCar = new Car("HMW520");
//		Car secondCar = new Car("HMW520");
//		if(firstCar.equals(secondCar)) {
//			System.out.println("동일한종류의차입니다.");
//		}else {
//			System.out.println("동일한종류의차가아닙니다.");
//		}
//	}
//
//}
