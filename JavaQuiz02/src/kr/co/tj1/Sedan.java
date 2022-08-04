package kr.co.tj1;

import java.util.ArrayList;
import java.util.HashSet;

public class Sedan extends Car {
	Person person;
	ArrayList<Person> nowPerson = new ArrayList<>();

	public Sedan(int speed) {
		super(speed);
		maxSpeed = 160;
	}

	@Override
	public void run() {
		System.out.println("세단이 달린다.(최대속도 " + maxSpeed + "km/h)");

	}

	@Override
	public void showSpeed() {
		System.out.println("현재 속도는 " + speed + "km/h 입니다.");
	}

	public void personPickup(Person p) {
		nowPerson.add(p);
	}
	
	public void showNowPerson() {
		for(int i = 0; i<nowPerson.size(); i++) {
			System.out.println(nowPerson.get(i));
		}
	}
	
}
