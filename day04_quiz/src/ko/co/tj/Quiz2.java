package ko.co.tj;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		int a = 0, b = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자 2개 입력");
		a = scan.nextInt();
		b = scan.nextInt();

		System.out.printf("최초값 a=%d, b=%d \n\n", a, b);
		System.out.printf("a++=%d , ++b=%d \n", a++, b++);
		System.out.printf("실행후 a=%d, b=%d \n\n", a, b);

		System.out.printf("a--=%d, --b=%d\n", a--, --b);
		System.out.printf("실행후 a=%d, b=%d", a, b);
	}

}
