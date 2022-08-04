// —————————————————— 상속 문제
/*
상속 : 같은 구조의 동일한 기능을 하는 경우 상속을 구현 한다.
다형성 사용 이유 : 세분화된 자식 클래스 보다 조금 더 공식 규격화 된 부모클래스의 공통 기능을 쉽게 사용 할 수 있도록 유도 
(Ex :트럭의 세분화된 기능은 별도 공부를 하여 면허증 별도 취득을 해서 운전해야 하지만 자동차는 운전면허증 있으면 (공식규격 알고 있으면) 운전이 가능하다.
즉 트럭을 자동차로 명명하여 기본적인 운전(개발)을 할 수 있도록 유도 하고 세부적인 트럭의 기능을 사용 하고 싶으면 별도의 트럭(이때 트럭으로 다운캐스팅)만의 고유 기능(메소드)를 공부하여 기능을 사용해야 한다.(나만이 개발하는 것이 아님으로 공식화된 규격으로 업캐스팅하여 유지보수 측면의 이점을 얻는다.
트럭은 자동차로 명명해도 트럭 속도를 내야 한다.(업캐스팅(자동차 명명) 후 에도 오버라이드 된 자식의 메소드를 고유하게 사용해야만 하는 이유) 
부모클래스 - 자동차 : 기본기능 - 달린다,  현재 시속 출력
자전거와 동일한 구조와 같은 기능을 가진 가진 스포츠카, 버스, 트럭, 세단 
자식클래스 
스포츠카 : 기능 - 부모 달린다 오버라이드 (최대 시속 190), 부스터(최대 시속 + 30), 부스터 종료(최대 시속 - 30)
버스 : 기능 - 부모 달린다 오버라이드(최대 시속 120), 사람을 태운다(몇명 +), 사람을 내린다(몇 명 -), 현재 탑승인원(몇명)
트럭 : 기능 - 부모 달린다 오버라이드(최대 시속 100), 물건을 실는다(갯수++), 물건을 내린다(갯수 —), 현재 물건수(몇개)
세단 : 기능 - 부모 달린다 오버라이드(최대 시속 160), 지인을 픽업(누구(사람클래스 has a), 누구, 누구), 지인을 내려준다(지인 누구,누구,누구), 현재 탑승인원은 누구누구누구?
*/

package kr.co.tj1;

public class CarTest {
	
	public static void main(String[] args) {
		
		Car scar = new SportCar(100);
		
		scar.run();
		scar.showSpeed();
		
		SportCar scar2 = (SportCar)scar;
		scar2.boosterOn();
		scar.run();
		scar2.booserOff();
		scar.run();
		
		Car bus = new Bus(50);
		bus.run();
		bus.showSpeed();
		Bus bus2 = (Bus)bus;
		bus2.passengerUp(5);
		bus2.showPassenger();
		bus2.passengerDown(3);
		bus2.showPassenger();
		
		Car truck = new Truck(60);
		truck.run();
		truck.showSpeed();
		Truck truck2 = (Truck)truck;		
		truck2.run();
		truck2.showSpeed();
		truck2.productUp(10);
		truck2.showproduct();
		truck2.productDown(3);
		truck2.showproduct();
		
		Person p1 = new Person("김유신");
		Person p2 = new Person("이순신");
		Person p3 = new Person("강감찬");
		Person p4 = new Person("세종대왕");
		Car sedan = new Sedan(150);
		sedan.run();
		sedan.showSpeed();
		Sedan sedan2 = (Sedan)sedan;
		sedan2.personPickup(p1);
		sedan2.personPickup(p3);
		sedan2.showNowPerson();
		
		
	}
}
