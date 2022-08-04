package controller;

import java.util.Scanner;

public class MainController {
	public static Scanner sc = new Scanner(System.in);
	
	public static Controller selectMenu() {
		Controller controller = null;
		System.out.println("원하는 메뉴를 선택해 주세요");
		System.out.printf("(m)회원, (b)게시판, (p)상품 (e) 종료\n");
		switch (sc.next().toLowerCase()) {
			case "m" :
				controller = new MemberController();
				break;
			case "b" :
				controller = new BoardController();
				break;
			case "p" :
				controller = new ProductController();
				break;
		}
		
		return controller;
	}
}
