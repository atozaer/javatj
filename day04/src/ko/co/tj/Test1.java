package ko.co.tj;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		String select="no"; int menu=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("주문하세요. yes/no");
		select=scan.next();
		
		if(select.equals("yes")||select.equals("YES")) {
				System.out.println("주문선택");
				System.out.println("메뉴선택1.자장면2.짬뽕3.탕수육");
				menu = scan.nextInt();
				switch(menu) {//스위치시작
				case 1:
					System.out.println("자장면선택");
					break;
				case 2:
					System.out.println("짬뽕선택");
					break;
				case 3:
					System.out.println("탕수육선택");
					break;
				default:
					System.out.println("찾는메뉴가없습니다.");
				}//스위치끝
		}else {
			System.out.println("주문취소");
		}
	}

}
