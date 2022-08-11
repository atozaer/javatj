package application;

import config.Function;
import controller.Controller;
import controller.MainController;

public class Application {
	public static void main(String[] args) {
		// 어플리케이션 흐름제어
		while(true) {
			// MainController.selectMenu(); 내 메뉴 선택에 따른 컨트롤러 셋팅
			// 정상 메뉴 컨트롤러가 아닌 경우 프로그램 종료
			Controller controller = MainController.selectMenu();
			if (controller == null) { // 어플리케이션 중지
				break;
			}
			else { // 메뉴 컨트롤러 실행(controller.BoardController 클래스 흐름도 판단) 
				controller.run(); // controller.Controller 클래스의 run() 디자인 패턴 메소드 실행 > boardController 흐름 실행
			}
		}
		
		System.out.println("프로그램 종료");
	}
}