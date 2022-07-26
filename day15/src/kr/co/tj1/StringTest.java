package kr.co.tj1;

import java.lang.reflect.Constructor;

public class StringTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class c3 = Class.forName("java.lang.String");
		
		Constructor<String>[] cons = c3.getConstructors();
		for(Constructor con: cons) {
			System.out.println(con);
		}
	}

}
