package ko.co.tj;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		int menu = 0;
		int size = 0;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("주문하세요 yes/no");
			String select = scan.next();
			if(select.equals("yes")||select.equals("YES")) {
				System.out.println("주문선택");
				System.out.println("메뉴 1.자장면 2.짬뽕 3.탕수육");
				menu = scan.nextInt();
				if(menu==1) {
					System.out.println("자장면");
				}else if(menu==2) {
					System.out.println("짬뽕");
				}else if(menu==3) {
					System.out.println("탕수육");
				}else {
					System.out.println("찾는메뉴 없음.");
				}
			}else {
				System.out.println("주문취소");
				break;
			}
		}
	}

}
