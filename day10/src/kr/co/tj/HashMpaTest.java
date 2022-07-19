package kr.co.tj;

import java.util.HashMap;

public class HashMpaTest {

	public static void main(String[] args) {
		HashMap<String, Integer> hashTest = new HashMap<String,Integer>();
		hashTest.put("id", 123);
		hashTest.put("pw", 456);
		System.out.println(hashTest.get("id"));
		System.out.println(hashTest.get("pw"));
	}

}
