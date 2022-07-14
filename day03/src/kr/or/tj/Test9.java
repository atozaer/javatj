package kr.or.tj;

import java.util.Scanner;

public class Test9 {// 클래스시작

	public static void main(String[] args) {// 메인시작
		Scanner scan = new Scanner(System.in);
		System.out.println("주문하세요 yes/no");
		String select = scan.next();
		int menu = 0;
		int tang = 0;

		if (select.equals("yes") || select.equals("YES")) {// 주문선택시작
			System.out.println("주문선택");
			System.out.println("메뉴선택 1.자장면 2.짬뽕 3.탕수육");
			menu = scan.nextInt();
			if (menu == 1) {// 자장면시작
				System.out.println("자장면선택");
				System.out.println("곱배기선택yes/no");
				select = scan.next();
				if (select.equals("yes") || select.equals("YES")) {
					System.out.println("곱배기선택");
				} else {
					System.out.println("보통선택");
				}
			} // 자장면끝
			else if (menu == 2) {// 짬뽕시작
				System.out.println("짬뽕선택");
				System.out.println("곱배기선택yes/no");
				select = scan.next();
				if (select.equals("yes") || select.equals("YES")) {
					System.out.println("곱배기선택");
				} else {
					System.out.println("보통선택");
				}
			} // 짬뽕끝
			else if (menu == 3) {// 탕수육시작
				System.out.println("탕수육선택");
				System.out.println("탕수육 1.소 2.중 3.대");
				tang = scan.nextInt();
				if (tang == 1) {
					System.out.println("탕수육 소");
				} else if (tang == 2) {
					System.out.println("탕수육 중");
				} else if (tang == 3) {
					System.out.println("탕수육 대");
				}
			} // 탕수육끝
			else {
				System.out.println("1,2,3번중에서 선택해주세요.");
			}
		} // 주문선택끝
		else {// 주문취소시작
			System.out.println("주문취소");
		} // 주문취소끝

		scan.close();
	}// 메인끝

}// 클래스끝
