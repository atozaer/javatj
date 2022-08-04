package kr.co.tj;

import java.util.ArrayList;

public class User {
	String name;
	int age;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name+":"+age;
	}

}
