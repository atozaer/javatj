package kr.co.tj;

public class ExceptionTest4 {

	public void exceptionMethod(String[] args) {
		try {
			int num = Integer.parseInt(args[0]);
			int result = 10 / num;
			System.out.println("result=" + result);
			return;
		} catch (ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		} catch (ArithmeticException e3) {
			e3.printStackTrace();
		} finally {
			System.out.println("무조건 실행될 영역");
		}
	}

	public static void main(String[] args) {
		ExceptionTest4 et4 = new ExceptionTest4();
		et4.exceptionMethod(args);
	}

}
