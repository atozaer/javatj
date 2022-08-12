package controller;

import java.util.Scanner;

public class MainController {
	public static Scanner sc = new Scanner(System.in);
	
	public static Controller selectMenu() {
		Controller controller = null;
		System.out.printf("원하는 메뉴를 선택해 주세요(%s)\n",
				(Controller.sessionNo != null) ? Controller.sessionName + "님 반갑습니다." : "비로그인"
		);
		StringBuilder menu = new StringBuilder();
		menu.append("(m)회원, (p)상품, (o)주문조회");
		if (Controller.sessionNo != null) {
			menu.append(", (c)장바구니");
		}
		else {
			menu.append(", (a)관리자");
		}
		menu.append(", (그외)종료");
		//(m)회원, (b)게시판, (p)상품 
		System.out.println(menu);
		
		switch (sc.next().toLowerCase()) {
			case "a" :
				controller = new AdminController();
				break;
			case "c" :
				controller = new CartController();
				break;
			case "m" :
				controller = new MemberController();
				break;
			case "o" :
				controller = new OrderController();
				break;
			case "p" :
				controller = new ProductController();
				break;
		}
		
		return controller;
	}
}
