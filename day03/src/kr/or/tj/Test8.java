package kr.or.tj;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		System.out.println("메뉴를 선택해주세요. \n1.자장면 2.짬뽕 3.탕수육");
		menu = scan.nextInt();
		
		if (menu==1) {
			System.out.println("자장면선택");
		}
		else if (menu==2) {
			System.out.println("짬뽕선택");
		}
		else if (menu==3) {
			System.out.println("탕수육선택");
		}
		else {
			System.out.println("1,2,3번중에서선택해주세요.");
		}
		
		scan.close();
		
	}

}
