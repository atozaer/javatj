package kr.or.tj;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("주문하세요y/n");
		char ju = scan.next().charAt(0);

		String str = (ju == 'y' || ju == 'Y') ? "주문선택" : "주문취소";
		System.out.println(str);

		scan.close();
	}
}
