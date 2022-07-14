package kr.co.tj;

import java.math.BigDecimal;
import java.math.BigInteger;

public class VariableTest {

	public static void main(String[] args) {
		int age, count = 0;
		age = 10;

		int level = 10000;

		long l1 = 12345678900l;

		double f1 = 3.141592f;

		BigInteger l2 = new BigInteger("100000000000000000000000000000000000000");

		BigDecimal f2 = new BigDecimal("3.1415923519684786176516817621321123");

		// Integer num2 = new Integer(0);
		int result = Integer.MAX_VALUE;
		result = result + 1;

		System.out.println(age);
		System.out.println(level);
		System.out.println(count);
		System.out.println(l1);
		System.out.println(f1);
		System.out.println(l2);
		System.out.println(f2);
		System.out.println(result);
	}

}
