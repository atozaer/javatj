package kr.or.tj;

public class LogicalTest {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;

		boolean flag = (num1 > 0) && (num2 > 0);
		System.out.println(flag);
		// && 논리곱 : 둘 다 참일때만 결과가 참이 나옴 
		
		flag = (num1 < 0) && (num2 > 0);
		System.out.println(flag);

		flag = (num1 > 0) || (num2 > 0);
		System.out.println(flag);
		// || 논리합 :	둘 다 거짓일때만 결과가 거짓이 나옴
		//				둘 중 하나만 참이라도 참이 나옴
		
		flag = (num1 < 0) || (num2 > 0);
		System.out.println(flag);

		flag = !(num1 > 0);
		System.out.println(flag);
	}

}
