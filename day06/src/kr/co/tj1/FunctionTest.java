package kr.co.tj1;

public class FunctionTest {
	public static int addNum(int num1, int num2) {
		int result = 0;
		result = num1 + num2;
		return result;
	}

	public static void sayHello(String greeting) {
		System.out.println(greeting);
		return;
	}

	public static int calcsum() {
		int sum = 0;
		int i = 0;
		for (i = 0; i <= 100; i++) {
			sum += i;// sum=sum+i
		}
		return sum;
	}

	public static void main(String[] args) {
		int sum = calcsum();
		System.out.println(sum);
		sayHello("안녕하세요");
		int result = addNum(2, 5);
		System.out.println(result);
	}
}
