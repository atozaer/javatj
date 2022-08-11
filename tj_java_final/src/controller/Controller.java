package controller;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public abstract class Controller {
	public static Long sessionNo;
	public static String sessionName;
	
	protected boolean controllerResult;
	
	abstract void selectMenu(); // abstract 메소드로 자식 메소드는 모두 가져야 함.
	
	public Controller() {
	}
	
	/**
	 * @param loginFlag : 로그인 허용 메뉴 true, 로그인 미허용 메뉴 false
	 * @return boolean
	 */
	protected boolean loginCheck(boolean loginFlag) {
		boolean returnFlag = true;
		if (loginFlag && sessionNo == null) {
			returnFlag = false;
			System.out.println("로그인중에 이용 가능한 메뉴 입니다.\n로그인 후 이용해 주세요");
		}
		else if (!loginFlag && sessionNo != null) {
			returnFlag = false;
			System.out.println("비회원 전용 메뉴 입니다.");
		}
		
		return returnFlag;
	}
	
	protected void showSearchMessage(String msg) {
		System.out.printf("검색할 %s을(를) 입력해 주세요\n", msg);
	}
	
	protected String getSearchStringMessage(String msg) {
		showSearchMessage(msg);
		return MainController.sc.next();
	}
	
	protected int getSearchIntMessage(String msg) {
		showSearchMessage(msg);
		return MainController.sc.nextInt();
	}
	
	public final void run() {
		while (true) {
			selectMenu(); // 자식클래스의 selectMenu() 메소드 실행
			if (!this.controllerResult) break;
		}
	}
}
