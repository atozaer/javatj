package controller;

import java.util.Scanner;

public class MainController {
	public static Scanner sc = new Scanner(System.in);
	
	public static Controller selectMenu() {
		Controller controller = null;
		System.out.println("원하는 메뉴를 선택해 주세요");
		System.out.printf("(b)게시판, (m)회원관리 (e) 종료\n");
		switch (sc.next().toLowerCase()) {
			case "b" :
				controller = new BoardController();
				break;
			case "m" :
				controller = new MemberController();
				break;
		}
		
		return controller;
	}
}
