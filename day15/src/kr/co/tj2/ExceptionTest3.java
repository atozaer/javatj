package kr.co.tj2;

public class ExceptionTest3 {

	public static void main(String[] args) {
		try {
			int num = Integer.parseInt(args[0]);
			int result = 10/num;
			System.out.println("result="+result);
		}catch (ArrayIndexOutOfBoundsException e1) {
			System.out.println("배열방인자를하나넣어주세요");
		}catch (NumberFormatException e2) {
			System.out.println("숫자를넣어주세요");
		}catch (ArithmeticException e3) {
			System.out.println("정수를 0으로나누면 안돼요");
		}
		System.out.println("프로그램은 계속실행");
	}

}
